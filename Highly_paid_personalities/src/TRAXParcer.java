import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringReader;
import java.util.Scanner;

public class TRAXParcer {
    public static void main(String[] args) {
        Scanner myInput = new Scanner( System.in );
        System.out.print( "minSalary: " );
        int minSalary = myInput.nextInt();

        TransformerFactory factory = TransformerFactory.newInstance();
        Source xsl = new StreamSource("file.xslt");
        Transformer transformer = null;

        try {
            transformer = factory.newTransformer(xsl);
            transformer.setParameter("minSalary", minSalary);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        Source xml =new StreamSource("file.xml");
        Result result = new StreamResult("result.xml");
        try {
            transformer.transform(xml,result);
            System.out.println("The file has been successfully created");
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}