package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.controller;


import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.dto.CountryWorld;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.services.SucursalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/views/sucursales")
public class SucursalController {


    @Autowired
    SucursalService sucursalService;

    @GetMapping({"/", ""})
    public String listSucursal(Model model) {
        List<SucursalDTO> list = sucursalService.getAllSucursal();
        model.addAttribute("titulo", "Lista Sucursales");
        model.addAttribute("sucursales", list);
        return "views/sucursales/list";
    }

    @GetMapping("/add")
    public String newSucursal(Model model) {

        Sucursal sucursal = new Sucursal();
        List<CountryWorld> countryWorldList = Arrays.stream(CountryWorld.values()).toList();
        model.addAttribute("titulo", "Agregar Sucursal");
        model.addAttribute("paises", countryWorldList);
        model.addAttribute("sucursal", sucursal);

        return "/views/sucursales/add";
    }

    @PostMapping("/add")
    public ModelAndView addSucursal(@Valid @ModelAttribute Sucursal sucursal, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("sucursal", new Sucursal());
            model.addAttribute("error", "Se necesitan todos los campos");
            return new ModelAndView("/views/sucursales/add", model.asMap());
        } else {
            SucursalDTO sucursalDTO = sucursalService.addSucursal(sucursal);
            return new ModelAndView("redirect:/views/sucursales/list", model.asMap());
        }
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateSucarsal(@PathVariable("id") Integer sucursalId, Model model) {
        model.addAttribute("sucursal", sucursalService.getOneSucursal(sucursalId));
        String updateUrl = "/sucursales/update" + sucursalId;
        model.addAttribute("updateUrl", updateUrl);
        return new ModelAndView("views/sucursales/update", model.asMap());
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateSucursal(@Valid @ModelAttribute Sucursal sucursal,
                 BindingResult result, @PathVariable("id") Integer sucursalId, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("error", "Se necesitan todos los campos");
            return new ModelAndView("views/sucursales/update", model.asMap());
        } else {
            sucursalService.updateSucursal(sucursal);
            return new ModelAndView("redirect:/views/sucursales/list", model.asMap());
        }
    }





}
