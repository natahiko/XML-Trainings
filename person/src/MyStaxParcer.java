import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.xpath.*;
import java.io.FileWriter;
import java.util.Scanner;

public class MyStaxParcer {
    private static final String filename  = "file.xml";

    public static void main(String[] srgs0){

        Scanner myInput = new Scanner( System.in );
        System.out.print( "maxSalary: " );
        int maxSalary = myInput.nextInt();

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(filename);

            //parcer
            XPathFactory pathFactory = XPathFactory.newInstance();
            XPath xpath = pathFactory.newXPath();
            XPathExpression expr = xpath.compile("employees/employee[salary>="+maxSalary+"]");
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            //output
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter("result.xml"));
            writer.writeStartDocument("1.0");
            writer.writeProcessingInstruction("xml-stylesheet type='text/xsl' href='/file.xslt'");

            writer.writeStartElement("employees");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                writer.writeStartElement("employee");
                NodeList nodesChilds = n.getChildNodes();

                if(nodesChilds.getLength()<1){
                    writer.writeStartElement("h1");
                    writer.writeCharacters("Немає співробітників з заробітною платнею більше ніж "+maxSalary);
                    writer.writeEndElement();
                } else {
                    for (int j = 0; j < nodesChilds.getLength(); j++) {
                        Node child = nodesChilds.item(j);

                        if (child.getNodeType() == Node.ELEMENT_NODE) {
                            writer.writeStartElement(child.getNodeName());
                            writer.writeCharacters(child.getTextContent());
                            writer.writeEndElement();
                        }

                    }
                }

                writer.writeEndElement();
            }

            //close output
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}
