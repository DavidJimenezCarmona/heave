<%@ page import="com.ebay.sdk.*" %>
<%@ page import="com.ebay.sdk.call.*" %>

<HTML>
	<HEAD>
		<title>Aceptado</title>
	</HEAD>
	<BODY>
  		Bienvenido/a,  <%= request.getSession().getAttribute("alias") %>
  		<br>
  		Has vendido ${nOrdenes} art�culos esta semana <br>
  		Esta semana has ganado ${totalGanado} &euro; 
	</BODY>
</HTML>
