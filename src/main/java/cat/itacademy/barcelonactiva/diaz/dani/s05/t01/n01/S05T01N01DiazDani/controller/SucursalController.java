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

        return "views/sucursales/add";
    }

    @PostMapping("/add")
    public String addSucursal(@Valid @ModelAttribute Sucursal sucursal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("sucursal", new Sucursal());
            model.addAttribute("error", "El campo del nombre tiene que estar rellenado.");
            return "views/sucursales/add";
        } else {
            SucursalDTO sucursalDTO = sucursalService.updateSucursal(sucursal);
            return "redirect:/views/sucursales/";
        }
    }


    @GetMapping("/edit/{id}")
    public String updateSucarsal(@PathVariable("id") Integer sucursalId, Model model) {

        Sucursal sucursal = sucursalService.getOneSucursal(sucursalId);
        List<CountryWorld> countryWorldList = Arrays.stream(CountryWorld.values()).toList();

        model.addAttribute("titulo", "Editar Sucursal");
        model.addAttribute("paises", countryWorldList);
        model.addAttribute("sucursal", sucursal);
        return "/views/sucursales/add";
    }

    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable("id") Integer sucursalId, Model model) {
        sucursalService.deleteSucursal(sucursalId);
        return "redirect:/views/sucursales/";
    }







}
