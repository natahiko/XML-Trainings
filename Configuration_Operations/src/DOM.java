import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMTester {
    public static void main(String[] args) {
        String filename = "books.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = builder.parse(filename);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element rootElement = document.getDocumentElement();
        rootElement.normalize();
        NodeList books = rootElement.getElementsByTagName("book");
        int count = books.getLength();
        System.out.println("There is " + count + " books:");
        for (int i = 0; i < count; i++) {
            Element book = (Element) books.item(i);
            NodeList titles = book.getElementsByTagName("title");
            Element title = (Element) titles.item(0);
            Text titletext = (Text) title.getFirstChild();
            String titlevalue = titletext.getData();
            System.out.print(titlevalue);
            System.out.println("");

        }

    }
}