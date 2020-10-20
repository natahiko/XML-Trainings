<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:key name="keysearch" match="employee" use="unit"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Grouping by Munch</title>
            </head>
            <body>
                <xsl:variable name="uniques"
                              select="employees/employee[generate-id(.)=generate-id(key('keysearch',unit))]/unit"/>


                    <xsl:for-each select="$uniques">
                        <h3>
                            <xsl:value-of select="."/>
                        </h3>
                        <ul>
                        <xsl:for-each select="key('keysearch',.)">
                            <li>
                                <xsl:value-of select="surname"/>
                                <xsl:text> </xsl:text>
                                <xsl:value-of select="name"/>
                            </li>
                        </xsl:for-each>
                        </ul>
                    </xsl:for-each>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
