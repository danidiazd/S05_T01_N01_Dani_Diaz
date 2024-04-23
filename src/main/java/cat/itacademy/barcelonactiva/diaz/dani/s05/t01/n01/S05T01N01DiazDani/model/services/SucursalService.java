package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.services;

import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SucursalService implements ISucursalService {


    @Autowired
    SucursalRepository sucursalRepository;

    @Override
    public SucursalDTO addSucursal(Sucursal sucursal) {
        return convertToDTO(sucursalRepository.save(sucursal));
    }

    @Override
    public SucursalDTO updateSucursal(Sucursal sucursal) {
        return null;
    }

    @Override
    public boolean deleteSucursal(Integer id) {
        return false;
    }

    @Override
    public SucursalDTO getOneSucursalDTO(Integer id) {
        return null;
    }

    @Override
    public Sucursal getOneSucursal(Integer id) {
        return null;
    }

    @Override
    public List<SucursalDTO> getAllSucursal() {
        return null;
    }


    private SucursalDTO convertToDTO(Sucursal sucursal){
        return new SucursalDTO(sucursal.getPk_SucursalId(), sucursal.getNameSucursal(), sucursal.getNameCountry());
    }
}
