<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method='xml' indent='yes'/>

    <xsl:param name="mode" select="expand"/>

    <xsl:template match="@* | node()">
        <xsl:copy>
            <xsl:apply-templates select="@* | node()"/>
        </xsl:copy>
    </xsl:template>

    <xsl:template match="@*">
        <xsl:element name="{name()}"><xsl:value-of select="."/></xsl:element>
    </xsl:template>

</xsl:stylesheet>