package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.controller;


import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.dto.CountryWorld;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/views/sucursales")
public class SucursalController {


    @Autowired
    SucursalService sucursalService;

    @GetMapping({"/", ""})
    String listSucursal(Model model) {
        List<SucursalDTO> list = sucursalService.getAllSucursal();
        model.addAttribute("titulo", "Lista Sucursales");
        model.addAttribute("sucursales", list);
        return "/views/sucursales/list";
    }

    @GetMapping("/add")
    public String addSucursal(Model model) {

        Sucursal sucursal = new Sucursal();
        List<CountryWorld> countryWorldList = Arrays.stream(CountryWorld.values()).toList();
        model.addAttribute("titulo", "Agregar Sucursal");
        model.addAttribute("paises", countryWorldList);
        model.addAttribute("sucursal", sucursal);

        return "/views/sucursales/add";
    }

}
