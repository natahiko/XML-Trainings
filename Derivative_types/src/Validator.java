import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author O.Oletsky
 * Demonstration of validating XML file
 * with schemas and DTD
 */
public class Validator {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final String JSL = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
        final String WXC = "http://www.w3.org/2001/XMLSchema";
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the name of XML file");
//        String fileName = sc.nextLine();
//        System.out.println("Is it schema-oriented (default; enter n if DTD)?");
//        String ans = sc.nextLine();
        String fileName = "books.xml";
        String ans = "";
        boolean schemaBased = !ans.equals("n");
        if(schemaBased) factory.setAttribute(JSL,WXC);

        factory.setNamespaceAware(true);
        factory.setValidating(true);
        try {
            DocumentBuilder builder=factory.newDocumentBuilder();
            builder.setErrorHandler(new MyParser());
            Document document = builder.parse(fileName);
            Element rootElement = document.getDocumentElement();
            rootElement.normalize();
            System.out.println("This file is valid");
        }
        catch (Exception e) {e.printStackTrace();
        }
    }

}