import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringReader;
import java.util.Scanner;

public class Parce {
    public static void main(String[] args) {
//        Scanner myInput = new Scanner( System.in );
//        System.out.print( "mode: " );
//        String mode = myInput.nextLine();
//        while(mode.equals("expand") && mode.equals("collapse")){
//            System.out.print( "mode: " );
//            mode = myInput.nextLine();
//        }
        String mode = "expand";

        TransformerFactory factory = TransformerFactory.newInstance();
        Source xsl = new StreamSource("first.xslt");
        Transformer transformer = null;

        try {
            transformer = factory.newTransformer(xsl);
            transformer.setParameter("mode", mode);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        Source xml =new StreamSource("first.xml");
        Result result = new StreamResult("result2.xml");
        try {
            transformer.transform(xml,result);
            System.out.println("The file has been successfully created");
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}