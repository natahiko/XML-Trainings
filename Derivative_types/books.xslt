<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

    <xs:complexType name="book">


        <xs:sequence>

            <xs:element name="author"  type="xs:string"/>
            <xs:element name="title"  type="xs:string" />

        </xs:sequence>

    </xs:complexType>

    <xs:complexType name="scientific-book">

        <xs:complexContent>
            <xs:extension base="book">
                <xs:sequence>
                    <xs:element name="reviewer"  type="xs:string"/>
                </xs:sequence>
            </xs:extension>
        </xs:complexContent>

    </xs:complexType>


    <xs:element name="katalog">
        <xs:complexType>
            <xs:sequence>

                <xs:element name="book" type="book" maxOccurs="unbounded"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
</xs:schema>
