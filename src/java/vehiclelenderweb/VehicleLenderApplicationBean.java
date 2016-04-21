package vehiclelenderweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
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
    
    /**
     * Creates a new instance of VehicleLenderApplicationBean
     */
    public VehicleLenderApplicationBean() {
        try {
            site.loadVehiclesFromFile("/home/rych/vehicles1.xml");
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
    
    
}
