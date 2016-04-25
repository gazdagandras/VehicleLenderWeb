package vehiclelenderweb;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import vehiclelender.Site;
import vehiclelender.vehicle.Car;

/**
 *
 * @author rych
 */
@Named(value = "vehicleLenderApplicationBean")
@ApplicationScoped
public class VehicleLenderApplicationBean {

    private Site site = new Site("Kaposvár", "Füredi út 234.");
    
    @Inject
    private AddNewCarBean addNewCarBean;
    
    /**
     * Creates a new instance of VehicleLenderApplicationBean
     */
    public VehicleLenderApplicationBean() {
        try {
            site.loadVehiclesFromPackage("/vehiclelender/data/vehicles1.xml");
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(VehicleLenderApplicationBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(VehicleLenderApplicationBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VehicleLenderApplicationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Site getSite() {
        return site;
    }
    
    public void addNewCar() {
        site.addCar(
                addNewCarBean.getManufacturer(),
                addNewCarBean.getType(),
                addNewCarBean.getColor(),
                addNewCarBean.getYearOfManufacture()
        );
        addNewCarBean.clear();
    }
}
