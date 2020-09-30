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
                            <xsl:text>Підрозділ</xsl:text>
                        </th>
                        <th>
                            <xsl:text>Зарплата</xsl:text>
                        </th>
                        <th>
                            <xsl:text>E-mail</xsl:text>
                        </th>
                        <th>
                            <xsl:text>WWW</xsl:text>
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
                                <xsl:value-of select="middlename"/>
                            </td>
                            <td>
                                <xsl:value-of select="@unit"/>
                            </td>
                            <td>
                                <xsl:value-of select="salary"/>
                            </td>
                            <td>
                                <a>
                                    <!-- FIRST TYPE set hre by attribute-->
                                    <xsl:attribute name="href">
                                        <xsl:value-of select="email"/>
                                    </xsl:attribute>
                                    <xsl:value-of select="email"/>
                                </a>
                            </td>
                            <td>
                                <xsl:if test="./link">
                                    <!-- SECOND TYPE of href-->
                                    <a href='mailto:{current()/link}'>
                                        <xsl:value-of select="link"/>
                                    </a>
                                </xsl:if>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </HTML>

    </xsl:template>

</xsl:stylesheet>