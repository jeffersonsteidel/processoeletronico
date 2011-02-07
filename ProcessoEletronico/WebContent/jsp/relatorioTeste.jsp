<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instituto Federal do Paran�</title>
<link rel="StyleSheet" type="text/css" href="../css/messages-style.css"
	media="screen" />
</head>
<body>
<f:view>
	<jsp:directive.include file="menus.jsp" />
	<a4j:loadScript src="../js/script.js" />
	<h:form>
		<h:commandButton value="GERAR RELAT�RIO TESTE"
			action="#{relatorioController.gerarRelatorioTeste}" />

		<h:commandButton value="GERAR RELAT�RIO TESTE PARAM"
			action="#{relatorioController.gerarRelatorioTeste2}" />

		<h:commandButton value="GERAR RELAT�RIO SERVIDOR CARGO LOTA��O"
			action="#{relatorioController.gerarRelatorioServidorCargoLotacao}" />
	</h:form>
</f:view>
</body>
</html>