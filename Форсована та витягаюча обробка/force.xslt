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
                    <xsl:apply-templates select="/employees"></xsl:apply-templates>
                </table>
            </body>
        </HTML>

    </xsl:template>
    <xsl:template match="/employees">

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
        <xsl:for-each select="./employee">
            <xsl:sort select="surname"/>
            <tr>
                <xsl:apply-templates select="."></xsl:apply-templates>
            </tr>
        </xsl:for-each>
    </xsl:template>

    <xls:template match="/employees/employee">
        <td>
            <xsl:apply-templates select="surname"/>
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
    </xls:template>

    <xsl:template match="surname">
        <i>
            <xsl:value-of select="."/>
        </i>
        <xsl:text> </xsl:text>
    </xsl:template>

</xsl:stylesheet>