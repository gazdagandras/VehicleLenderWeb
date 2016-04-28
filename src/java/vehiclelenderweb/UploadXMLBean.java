package vehiclelenderweb;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;

/**
 *
 * @author rych
 */
@Named(value = "uploadXMLBean")
@RequestScoped
public class UploadXMLBean {

    private Part file;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public void upload() {
        
    }
    
}
