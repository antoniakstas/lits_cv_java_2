package model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddressResponseModel {

    @NotNull(message = "Please provide country")
    @Size(min=4, max=30)
    String country;
    String town;
    String street;
    String houseNumber;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

}
