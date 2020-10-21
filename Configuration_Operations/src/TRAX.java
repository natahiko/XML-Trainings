import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * @author O.Oletsky
 * Demonstration of transforming XML documents in Java by means of TrAX
 */
public class TRAXTransformer {
    public static void main(String[] args) {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xsl = new StreamSource(args[1]);
        Transformer transformer = null;
        try {
            transformer = factory.newTransformer(xsl);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        Source xml =new StreamSource(args[0]);
        Result result = new StreamResult(args[2]);
        try {
            transformer.transform(xml,result);
            System.out.println("The file has been successfully created");
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
