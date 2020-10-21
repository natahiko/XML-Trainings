import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Parce {
    public static void main(String[] args) {
        try {
            String filepath = "parameters.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);
            Scanner myInput = new Scanner(System.in);

            Node roots = doc.getFirstChild();
            NodeList parameters = roots.getChildNodes();

            for (int i = 0; i < parameters.getLength(); i++) {

                Node param = parameters.item(i);
                if (param.getNodeValue() == null) {
                    System.out.println(param.getNodeName() + ": " + param.getTextContent());
                    System.out.print("Write new value of " + param.getNodeName() + ":");
                    String newValue = myInput.nextLine();
                    if (newValue != "")
                        param.setTextContent(newValue);
                }

            }

            //write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

            System.out.println("Done");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
    }
}