package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.controller;


import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/views/sucursal")
public class SucursalController {


    @Autowired
    SucursalService sucursalService;

    @GetMapping("/")
    String listSucursal(Model model) {
        List<SucursalDTO> list = sucursalService.getAllSucursal();
        model.addAttribute("titulo", "Lista Sucursales");
        model.addAttribute("sucursales", list);
        return "/views/sucursales/list";
    }

}
