package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n01.S05T01N01DiazDani.model.dto;

import jakarta.validation.constraints.NotEmpty;

public class SucursalDTO {

    private Integer pk_SucursalID;

    @NotEmpty(message = "El nombre no puede estar vacio")
    private String sucursalName;

    @NotEmpty(message = "El pais no puede estar vacio")
    private String countryName;

    private String typeSucursal;


    public SucursalDTO(Integer pk_SucursalID, String sucursalName, String countryName) {
        this.pk_SucursalID = pk_SucursalID;
        this.sucursalName = sucursalName;
        this.countryName = countryName;
        this.typeSucursal = checkCountry(countryName);
    }

    public SucursalDTO() {

    }

    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getSucursalName() {
        return sucursalName;
    }

    public void setSucursalName(String sucursalName) {
        this.sucursalName = sucursalName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getTypeSucursal() {
        return typeSucursal;
    }

    public void setTypeSucursal(String typeSucursal) {
        this.typeSucursal = typeSucursal;
    }

    private String checkCountry(String countryOffice) {
        for (CountryEU country : CountryEU.values()) {
            if (countryOffice.equalsIgnoreCase(country.name())) {
                return "EU";
            }
        }
        return "NOT_EU";
    }
}
