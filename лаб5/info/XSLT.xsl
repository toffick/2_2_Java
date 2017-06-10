<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
               <xsl:output method="html"/>
    <xsl:template match="/">
        <table >
            <tr bgcolor="#CCCCCC">
                <td align="center" ><strong>Тип</strong></td>
                <td align="center"><strong>Вместимость</strong></td>
                <td align="center"><strong>Вес</strong></td>
                <td align="center"><strong>Топливо</strong></td>
                <td align="center"><strong>Дальность полета</strong></td>
                <td align="center"><strong>Модель</strong></td>
            </tr>
            <xsl:for-each select="air/airplane">

                <tr bgcolor="#F5F5F5" >
                    <td><xsl:value-of select="@type"/<xsl:sort select = "capacity" data-type = "number"/></td>
                    <td><xsl:value-of select ="capacity"/></td>
                    <td><xsl:value-of select ="weith"/></td>
                    <td><xsl:value-of select ="fuel"/></td>
                    <td><xsl:value-of select ="rang"/></td>
                    <td><xsl:value-of select ="model"/></td>

                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>

</xsl:stylesheet>