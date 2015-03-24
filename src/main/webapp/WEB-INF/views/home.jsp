<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/estilo.css" />" rel="stylesheet">
		<title>HEAV</title>
	</head>
	<body>
		<div class="container">	
			<h1>
				Herramienta Estadística Avanzada para el Vendedor
			</h1>
			<br><br>
			<div class="row">
				<div class="col-sm-4 col-sm-offset-4 drop-shadow">
					Pulse aquí para vincular su cuenta. <br>
					Será redireccionado a la página oficial de eBay.<br><br>
					<div class="col-sm-2 col-sm-offset-4">
						<form action="Usuario/">
							<input type="submit" value="Vincular" class="btn btn-primary">
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
