package test;

import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

class XMLParcer {
    public static void main(String[] args0) throws Exception{

        String filename= "file.xml";
        DefaultHandler handler= new SAXCounter();
        SAXParserFactory factory=SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(filename,handler);
    }
}
