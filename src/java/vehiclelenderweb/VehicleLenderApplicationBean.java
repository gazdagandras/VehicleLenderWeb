package vehiclelenderweb;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import vehiclelender.vehicle.Car;

/**
 *
 * @author rych
 */
@Named(value = "vehicleLenderApplicationBean")
@ApplicationScoped
public class VehicleLenderApplicationBean {

    private List<Car> cars = new ArrayList<>();
    
    /**
     * Creates a new instance of VehicleLenderApplicationBean
     */
    public VehicleLenderApplicationBean() {
        cars.add(new Car("FOrd", "Focus 1.6", "red", 2012));
    }

    public List<Car> getCars() {
        return cars;
    }
    
    
}
