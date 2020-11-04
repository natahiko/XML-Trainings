import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class MyParser extends DefaultHandler {
    @Override
    public void warning(SAXParseException exp) {
        System.out.println("Warning: "+exp.getMessage());
        System.exit(0);
    }

    @Override
    public void error(SAXParseException exp) {
        System.out.println("Error: "+exp.getMessage());
        System.exit(0);
    }

    @Override
    public void fatalError(SAXParseException exp) {
        System.out.println("Fatal error: "+exp.getMessage());
        System.exit(0);
    }


}
