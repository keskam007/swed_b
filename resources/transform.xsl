<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="html"/>
	<xsl:template match="/">
	  <html>
	  	<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css"></link>
		<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
		<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
	    <body>
		      <h3>Decathlon Athlete List</h3>

	    </body>
	  </html>
	<xsl:apply-templates/>  
</xsl:template>

<xsl:template match="Athlete">
	<div data-role="main" class="ui-content">
		<div data-role="collapsible">
    		<h1> <xsl:apply-templates select="name"/></h1>
    		<p> <xsl:apply-templates select="totalScore"/> </p>
    		<p> <xsl:apply-templates select="place"/> </p>
    		<p> <xsl:apply-templates select="_100m"/> </p>
    		<p> <xsl:apply-templates select="_110Hurdles"/> </p>
    		<p> <xsl:apply-templates select="_400m"/> </p>
    		<p> <xsl:apply-templates select="discusThrow"/> </p>
    		<p> <xsl:apply-templates select="highJump"/> </p>
    		<p> <xsl:apply-templates select="javelinThrow"/> </p>
    		<p> <xsl:apply-templates select="longJump"/> </p>
    		<p> <xsl:apply-templates select="poleVault"/> </p>
    		<p> <xsl:apply-templates select="shotPut"/> </p>
    	</div>
	</div>
</xsl:template>

<xsl:template match="name">
  Name: <span>
  	<xsl:value-of select="current()"/></span>
  <br />
</xsl:template>

<xsl:template match="totalScore">
  Total Score: <span>
  <xsl:value-of select="current()"/></span>
  <br />
</xsl:template>

<xsl:template match="place">
  Place: <span>
  <xsl:value-of select="current()"/></span>
  <br />
</xsl:template>

<xsl:template match="_100m">
  100m: <span>
  <xsl:value-of select="current()"/></span>
  <br />
</xsl:template>

<xsl:template match="_110Hurdles">
  110Hurdles: <span>
  <xsl:value-of select="current()"/></span>
  <br />
</xsl:template>

<xsl:template match="_400m">
  400m: <span>
  <xsl:value-of select="current()"/></span>
  <br />
</xsl:template>

<xsl:template match="discusThrow">
  Discus Throw: <span>
  <xsl:value-of select="current()"/></span>
  <br />
</xsl:template>

<xsl:template match="highJump">
  High Jump: <span>
  <xsl:value-of select="current()"/></span>
  <br />
</xsl:template>

<xsl:template match="javelinThrow">
  Javelin Throw: <span>
  <xsl:value-of select="current()"/></span>
  <br />
</xsl:template>

<xsl:template match="longJump">
  Long Jump: <span>
  <xsl:value-of select="current()"/></span>
  <br />
</xsl:template>

<xsl:template match="poleVault">
  Pole Vault: <span>
  <xsl:value-of select="current()"/></span>
  <br />
</xsl:template>

<xsl:template match="shotPut">
  Shot Put: <span>
  <xsl:value-of select="current()"/></span>
  <br />
</xsl:template>

</xsl:stylesheet>

