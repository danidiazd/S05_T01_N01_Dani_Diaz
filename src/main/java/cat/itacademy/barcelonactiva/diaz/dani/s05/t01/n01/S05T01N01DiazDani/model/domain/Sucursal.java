package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;


@Entity
@Table(name = "sucursal")
public class Sucursal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk_SucursalId;

    @Column(name = "name")
    @NotEmpty(message = "Este campo no puede estar vacio.")
    private String nameSucursal;

    @Column(name = "country")
    @NotEmpty(message = "Este campo no puede estar vacio.")
    private String nameCountry;

    public Sucursal(){}

    public Integer getPk_SucursalId() {
        return pk_SucursalId;
    }

    public void setPk_SucursalId(Integer pk_SucursalId) {
        this.pk_SucursalId = pk_SucursalId;
    }

    public String getNameSucursal() {
        return nameSucursal;
    }

    public void setNameSucursal(String nameSucursal) {
        this.nameSucursal = nameSucursal;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }
}
