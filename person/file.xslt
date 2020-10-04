<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xls="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <HTML>
            <head>
                <title>
                    <xsl:text> ЗАРПЛАТИ СПІВРОБІТНИКІВ </xsl:text>
                </title>
            </head>
            <body>
                <h1 style="color:red;">ЗАРПЛАТИ СПІВРОБІТНИКІВ</h1>
                <table>
                    <tr style="color: teal;">
                        <th>
                            <xsl:text>ПІБ</xsl:text>
                        </th>
                        <th>
                            <xsl:text>Зарплата</xsl:text>
                        </th>
                    </tr>
                    <xsl:for-each select="employees/employee">
                        <xsl:sort select="surname"/>
                        <tr>
                            <td>
                                <i>
                                    <xsl:value-of select="surname"/>
                                </i>
                                <xsl:text> </xsl:text>
                                <xsl:value-of select="name"/><xsl:text> </xsl:text>
                            </td>
                            <td>
                                <xsl:value-of select="salary"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </HTML>

    </xsl:template>

</xsl:stylesheet>