<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <HTML>
            <head>
                <title>
                    <xsl:text> Книжкова полиця </xsl:text>
                </title>
            </head>
            <body>
                <xsl:for-each select="/catalog/book">
                    <b>
                        <xsl:value-of select="author"/>
                    </b>
                    <xsl:text>. </xsl:text>
                    <xsl:value-of select="title"/>
                    <xsl:text>.</xsl:text>
                    <br/>
                </xsl:for-each>

            </body>
        </HTML>

    </xsl:template>

</xsl:stylesheet>