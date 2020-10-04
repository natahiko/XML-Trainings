import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringReader;
import java.util.Scanner;

public class TRAXParcer {
    public static void main(String[] args) {
        Scanner myInput = new Scanner( System.in );
        System.out.print( "maxSalary: " );
        int maxSalary = myInput.nextInt();

        TransformerFactory factory = TransformerFactory.newInstance();
        Source xsl = new StreamSource("file.xslt");
        Transformer transformer = null;

        try {
            transformer = factory.newTransformer(xsl);
            transformer.setParameter("maxSalary", maxSalary);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        Source xml =new StreamSource("file.xml");
        Result result = new StreamResult("result.html");
        try {
            transformer.transform(xml,result);
            System.out.println("The file has been successfully created");
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}