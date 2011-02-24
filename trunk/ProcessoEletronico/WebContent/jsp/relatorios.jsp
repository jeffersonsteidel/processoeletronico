<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instituto Federal do Paraná</title>
<link rel="StyleSheet" type="text/css" href="../css/messages-style.css"
	media="screen" />
</head>
<body>
<f:view>
	<jsp:directive.include file="menus.jsp" />
	<a4j:loadScript src="../js/script.js" />
	<rich:panel>
		<h:form>
			<h:panelGrid columns="2">
				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="RELATÓRIO SERVIDOR CARGO LOTAÇÃO"
					action="#{relatorioController.gerarRelatorioServidorCargoLotacao}" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="RELATÓRIO SERVIDOR CONTA BANCÁRIA"
					action="#{relatorioController.gerarRelatorioServidorContaBancaria}" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="RELATÓRIO GERAL TITULAÇÃO"
					action="#{relatorioController.gerarRelatorioServidorTitulacao}" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="RELATÓRIO GERAL SERVIDOR"
					action="#{relatorioController.abrirRelatorioGeral}" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="RELATÓRIO PERMISSÃO USUÁRIO"
					action="#{relatorioController.abrirRelatorioPermissaoUsuario}" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="CARGO LOTAÇÂO (FILTRO)"
					action="#{relatorioController.abrirRelatorioCargoLotacaoByFiltro}" />

			</h:panelGrid>
		</h:form>
	</rich:panel>
</f:view>
</body>
</html>