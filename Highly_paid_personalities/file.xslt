<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method='xml' indent='yes'/>

    <xsl:param name="minSalary" select="2"/>
    <xsl:template match="/">
        <HTML>
            <head>
                <title>
                    <xsl:text> Salaries </xsl:text>
                </title>
            </head>
            <body>
                <h1>Salaries</h1>
                <xsl:for-each select="employees/employee[salary >= $minSalary]">
                    <employee>
                        <surname>
                            <xsl:value-of select="surname"/>
                        </surname>
                        <name>
                            <xsl:value-of select="name"/>
                        </name>
                        <salary>
                            <xsl:value-of select="salary"/>
                        </salary>
                    </employee>
                </xsl:for-each>
            </body>
        </HTML>

    </xsl:template>
</xsl:stylesheet>