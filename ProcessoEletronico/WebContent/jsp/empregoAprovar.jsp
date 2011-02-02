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
		<rich:panel>
			<center><rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages></center>
			<center><font size="2"><b>EMPREGO APROVAR</b></font> <h:panelGrid
				columns="2">
				<h:outputText value="Servidor: " />
				<h:outputText
					value="#{empregoController.emprego.servidor.siape} - #{empregoController.emprego.servidor.nome}" />
			</h:panelGrid> <h:panelGrid columns="4">
				<h:outputText value="Cargo: " />
				<h:outputText id="cargo" value="#{empregoController.emprego.cargo}"></h:outputText>
				<h:outputText value="Data de Admissão: " />
				<h:outputText value="#{empregoController.emprego.dataAdmissao}">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:outputText>
				<h:outputText value="Empresa: " />
				<h:outputText value="#{empregoController.emprego.empresa}"></h:outputText>
				<h:outputText value="Data de Saida: " />
				<h:outputText value="#{empregoController.emprego.dataSaida}">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:outputText>
			</h:panelGrid> <h:panelGrid columns="2">
				<h:outputText value="Atividades: " />
				<h:inputTextarea value="#{empregoController.emprego.atividades}"
					rows="10" cols="50" disabled="true">
				</h:inputTextarea>

				<h:outputText value="Justificativa: " />
				<h:inputTextarea value="#{empregoController.emprego.justificativa}"
					rows="10" cols="50" disabled="#{empregoController.desabilitaBotao}">
				</h:inputTextarea>
			</h:panelGrid> <h:panelGrid columns="3">



				<a4j:commandButton value="Deferir" reRender="form" disabled="#{empregoController.desabilitaBotao}"
					action="#{empregoController.deferir}" />
				<a4j:commandButton value="Indeferir" reRender="form" disabled="#{empregoController.desabilitaBotao}"
					action="#{empregoController.indeferir}" />
				<a4j:commandButton value="Voltar" action="#{empregoController.voltarListarEmprego}" />
			</h:panelGrid></center>
		</rich:panel>



	</a4j:form>


</f:view>
</body>
</html>