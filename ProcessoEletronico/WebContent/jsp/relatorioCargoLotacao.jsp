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
	<a4j:form id="form">
		<center><rich:panel>
			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<font size="2"><b>RELATÓRIO CARGO LOTAÇÃO</b></font>

			<h:panelGrid columns="6">

				<h:outputText value="Cargo: " />
				<h:selectOneMenu value="#{relatorioController.cargo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{relatorioController.cargos}" />
				</h:selectOneMenu>

				<h:outputText value="Local Exercício: " />
				<h:selectOneMenu value="#{relatorioController.lotacao}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{relatorioController.locaisExercicio}" />
				</h:selectOneMenu>

				<h:outputText value="Situação do Servidor: " />
				<h:selectOneMenu value="#{relatorioController.situacao}">
				<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="ATIVOS" itemValue="1" />
					<f:selectItem itemLabel="INATIVOS" itemValue="2" />
				</h:selectOneMenu>

			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:commandButton value="Gerar Relatório"
					action="#{relatorioController.gerarRelatorioServidorCargoLotacaoByFiltro}" />
			</h:panelGrid>

		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>