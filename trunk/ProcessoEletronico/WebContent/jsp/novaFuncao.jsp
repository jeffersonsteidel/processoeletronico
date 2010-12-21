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
			<font size="2"><b>NOVA FUNÇÃO</b></font>

			<h:panelGrid columns="6">
				<h:outputText value="Tipo Função: " />
				<h:selectOneMenu id="tipoFuncao"
					value="#{funcaoController.funcao.tipoFuncao.codigo}"
					required="true" requiredMessage="Campo Tipo Função é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{funcaoController.tipoFuncoes}" />
				</h:selectOneMenu>

				<h:outputText value="Função: " />
				<h:inputText id="funcao"
					value="#{funcaoController.funcao.descricao}" size="80"
					maxlength="80" required="true"
					requiredMessage="Campo Função é obrigatório!">
				</h:inputText>

				<h:outputText value="Ato de Criação: " />
				<h:inputText id="atoCriacao"
					value="#{funcaoController.funcao.atoCriacao}" size="40"
					maxlength="100" required="true"
					requiredMessage="Campo Ato de Criação é obrigatório!">
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid columns="1">
				<a4j:commandButton value="Salvar"
					action="#{funcaoController.salvarNovaFuncao}" reRender="form"/>
			</h:panelGrid>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>