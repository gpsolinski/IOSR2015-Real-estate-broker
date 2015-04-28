<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
	<xsl:output omit-xml-declaration="yes" />
	<xsl:template match="/">
		<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
			<soap:Body>
				<xsl:copy-of select="*" />
			</soap:Body>
		</soap:Envelope>
	</xsl:template>
</xsl:stylesheet>	