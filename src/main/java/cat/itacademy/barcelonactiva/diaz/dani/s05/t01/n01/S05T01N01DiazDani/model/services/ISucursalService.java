package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.services;

import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.dto.SucursalDTO;

import java.util.List;

public interface ISucursalService {

    SucursalDTO addSucursal(Sucursal sucursal);

    SucursalDTO updateSucursal(Sucursal sucursal);

    boolean deleteSucursal(Integer id);

    SucursalDTO getOneSucursalDTO(Integer id);

    Sucursal getOneSucursal(Integer id);

    List<SucursalDTO> getAllSucursal();

}
