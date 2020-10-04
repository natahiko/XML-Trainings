import java.io.FileWriter;
import java.io.IOException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class WriteExample {

    public static void main(String[] args) {
        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter("result.xml"));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("employees");
            // Делаем цикл для книг
            for (int i = 0; i < 5; i++) {
                writer.writeStartElement("employee");

                writer.writeStartElement("name");
                writer.writeCharacters("name #" + i);
                writer.writeEndElement();

                writer.writeStartElement("surname");
                writer.writeCharacters("surname #" + i);
                writer.writeEndElement();

                writer.writeStartElement("salary");
                writer.writeCharacters("salary #" + i);
                writer.writeEndElement();

                writer.writeEndElement();
            }
            // Закрываем корневой элемент
            writer.writeEndElement();
            // Закрываем XML-документ
            writer.writeEndDocument();
            writer.flush();
        } catch (XMLStreamException | IOException ex) {
            ex.printStackTrace();
        }
    }
}