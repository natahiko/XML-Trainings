<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method='xml' indent='yes'/>

    <xsl:param name="mode" select="expand"/>

    <xsl:template match="node()|@*">
        <xsl:copy>
            <xsl:apply-templates select="node()|@*"/>
        </xsl:copy>
    </xsl:template>


    <xsl:template match="node()">
        <xsl:if test="$mode='collapse'">
            <xsl:copy>
                <xsl:for-each select="*[not(*|@*)]">
                    <xsl:attribute name="{name()}">
                        <xsl:value-of select="text()"/>
                    </xsl:attribute>
                </xsl:for-each>
                <xsl:apply-templates select="node()|@*"/>
            </xsl:copy>
        </xsl:if>

        <xsl:if test="$mode='expand'">
            <xsl:copy>
                <xsl:apply-templates select="node()|@*"/>
            </xsl:copy>
        </xsl:if>
    </xsl:template>


    <xsl:template match="@*">
        <xsl:if test="$mode='collapse'">
            <xsl:copy>
                <xsl:for-each select="*[not(*|@*)]">
                    <xsl:attribute name="{name()}">
                        <xsl:value-of select="text()"/>
                    </xsl:attribute>
                </xsl:for-each>
                <xsl:apply-templates select="node()|@*"/>
            </xsl:copy>
        </xsl:if>

        <xsl:if test="$mode='expand'">
            <xsl:element name="{name()}">
                <xsl:value-of select="."/>
            </xsl:element>
        </xsl:if>
    </xsl:template>


    <xsl:template match="*[not(*|@*)]">
        <xsl:if test="$mode='expand'">
            <xsl:copy>
                <xsl:apply-templates select="node()|@*"/>
            </xsl:copy>
        </xsl:if>
    </xsl:template>


</xsl:stylesheet>