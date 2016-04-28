package vehiclelenderweb;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author rych
 */
@Named(value = "uploadXMLBean")
@RequestScoped
public class UploadXMLBean {

    private Part file;
    
    @Inject
    VehicleLenderApplicationBean appBean;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public void upload() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file.getInputStream());
            
            appBean.getSite().loadVehicles(doc);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(UploadXMLBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UploadXMLBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(UploadXMLBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
