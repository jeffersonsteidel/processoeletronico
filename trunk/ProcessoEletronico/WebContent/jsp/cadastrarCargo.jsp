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
			<font size="2"><b>CADASTRAR CARGO</b></font>
			<h:panelGrid columns="2">
				<h:outputText value="Código: " />
				<h:inputText requiredMessage="Campo Código é obrigatório!" disabled="#{!cargoController.indNovo}"
					required="true" value="#{cargoController.cargo.codigo}" size="6"
					onkeypress="mascara(this, soNumeros);" maxlength="6"></h:inputText>

				<h:outputText value="Descrição do Cargo: " />
				<h:inputText
					requiredMessage="Campo Descrição do Cargo é obrigatório!"
					required="true" value="#{cargoController.cargo.descricao}"
					size="60" maxlength="100"></h:inputText>
					
				<h:outputText value="Classe do Cargo: " />
				<h:selectOneMenu value="#{cargoController.cargo.classe.codigo}"
					required="true" requiredMessage="Campo Classe do Cargo é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{cargoController.classes}" />
				</h:selectOneMenu>

			</h:panelGrid>
			<h:panelGrid columns="2">
				<a4j:commandButton value="Salvar"
					action="#{cargoController.salvar}"
					reRender="form" />
			</h:panelGrid>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>