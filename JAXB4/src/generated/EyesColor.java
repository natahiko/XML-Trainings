//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.11.25 at 12:41:13 PM EET 
//


package generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eyes_color.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eyes_color">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="green"/>
 *     &lt;enumeration value="grey"/>
 *     &lt;enumeration value="blue"/>
 *     &lt;enumeration value="brown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eyes_color")
@XmlEnum
public enum EyesColor {

    @XmlEnumValue("green")
    GREEN("green"),
    @XmlEnumValue("grey")
    GREY("grey"),
    @XmlEnumValue("blue")
    BLUE("blue"),
    @XmlEnumValue("brown")
    BROWN("brown");
    private final String value;

    EyesColor(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EyesColor fromValue(String v) {
        for (EyesColor c: EyesColor.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}