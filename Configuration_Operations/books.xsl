<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>My book catalog</title>
            </head>
            <body>
                <xsl:for-each select="/catalog/book">
                    <strong>ISBN:</strong>
                    <xsl:value-of select="@ISBN"/>
                    <br/>
                    <strong>Author:</strong>
                    <xsl:value-of select="author"/>
                    <br/>
                    <strong>Title:</strong>
                    <xsl:value-of select="title"/>
                    <br/>
                    <xsl:text>-------------------------</xsl:text>
                    <br/>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>