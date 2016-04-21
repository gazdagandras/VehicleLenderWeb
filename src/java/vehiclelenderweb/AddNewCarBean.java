package vehiclelenderweb;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author rych
 */
@Named(value = "addNewCarBean")
@RequestScoped
public class AddNewCarBean {

    private String manufacturer;
    private String type;
    private String color;
    private Integer yearOfManufacture;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYearOfManufacture(Integer yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
    
    public void clear() {
        manufacturer = null;
        type = null;
        color = null;
        yearOfManufacture = null;
    }
}
