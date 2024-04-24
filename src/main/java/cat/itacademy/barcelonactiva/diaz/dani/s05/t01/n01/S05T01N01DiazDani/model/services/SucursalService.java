package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.services;

import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SucursalService implements ISucursalService {


    @Autowired
    SucursalRepository sucursalRepository;

    @Override
    public SucursalDTO addSucursal(Sucursal sucursal) {
        return convertToDTO(sucursalRepository.save(sucursal));
    }

    @Override
    public SucursalDTO updateSucursal(Sucursal sucursal) {
        Optional<Sucursal> optionalSucursal = sucursalRepository.findById(sucursal.getPk_SucursalId());
        if (optionalSucursal.isPresent()) {
            Sucursal updateSucursal = optionalSucursal.get();
            updateSucursal.setPk_SucursalId(sucursal.getPk_SucursalId());
            updateSucursal.setNameSucursal(sucursal.getNameSucursal());
            updateSucursal.setNameCountry(sucursal.getNameCountry());
            return convertToDTO(sucursalRepository.save(updateSucursal));
        } else {
            throw new RuntimeException("No encontrado con ID: " + sucursal.getPk_SucursalId());
        }
    }

    @Override
    public boolean deleteSucursal(Integer id) {
        Optional<Sucursal> optionalSucursal = sucursalRepository.findById(id);
        if (optionalSucursal.isPresent()) {
            sucursalRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public SucursalDTO getOneSucursalDTO(Integer id) {
        return convertToDTO(sucursalRepository.findById(id).orElse(null));
    }

    @Override
    public Sucursal getOneSucursal(Integer id) {
     return sucursalRepository.findById(id).orElse(null);
    }

    @Override
    public List<SucursalDTO> getAllSucursal() {
        List<Sucursal> sucursalList = sucursalRepository.findAll();
        List<SucursalDTO> sucursalDTOList = sucursalList.stream().map(this::convertToDTO).toList();
        return sucursalDTOList;
    }


    private SucursalDTO convertToDTO(Sucursal sucursal) {
        return new SucursalDTO(sucursal.getPk_SucursalId(), sucursal.getNameSucursal(), sucursal.getNameCountry());
    }
}
