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
	<a4j:loadScript src="../js/script.js" />
	<center><a4j:form id="form">
		<rich:panel header="Função" style="width: 1080px;">
			<h:panelGrid columns="2">

				<h:outputText value="Função: " />
				<h:inputText value="#{funcaoController.funcao.descricao}" size="50"
					maxlength="100" required="true"
					requiredMessage="Campo Função obrigatório!"></h:inputText>

				<h:outputText value="Tipo: " />
				<h:selectOneMenu id="tipo"
					value="#{funcaoController.funcao.tipo}"
					required="true" requiredMessage="Campo Tipo é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItem itemLabel="CARGO DE DIREÇÃO" itemValue="1" />
					<f:selectItem itemLabel="FUNÇÃO GRATIFICADA" itemValue="2" />
				</h:selectOneMenu>

			</h:panelGrid>
			<a4j:commandButton value="Salvar"
				action="#{funcaoController.salvar}"
				oncomplete="#{rich:component('confirmPanel')}.show()" />
		</rich:panel>
	</a4j:form></center>
	<center><rich:modalPanel id="confirmPanel" autosized="false"
		resizeable="true"
		showWhenRendered="#{not empty facesContext.maximumSeverity}">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Verificar Campos"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="../images/close.gif"
					onclick="#{rich:component('confirmPanel')}.hide();" />
			</h:panelGroup>
		</f:facet>
		<h:form>
			<table width="100%" height="100%">
				<tbody>
					<tr>
						<td><rich:messages layout="list" errorLabelClass="errorLabel"
							style="top:auto;" infoLabelClass="infoLabel">
							<f:facet name="infoMarker">
								<h:graphicImage value="../images/passed.gif" />
							</f:facet>
							<f:facet name="errorMarker">
								<h:graphicImage value="../images/error.gif" />
							</f:facet>
						</rich:messages></td>
					</tr>
				</tbody>
			</table>
		</h:form>
	</rich:modalPanel></center>
</f:view>
</body>
</html>