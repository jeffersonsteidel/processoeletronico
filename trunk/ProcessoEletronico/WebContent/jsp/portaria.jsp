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

			<font size="2"><b>PORTARIAS</b></font>


			<h:panelGrid columns="2">
				<h:outputText value="Nome da Portaria: "></h:outputText>
				<h:inputText value="#{portariaController.portaria.nome}" size="53"
					maxlength="120" required="true"
					requiredMessage="Campo Nome da Portaria é obrigatório!">
				</h:inputText>
				<h:outputText value="Numero da Portaria: "></h:outputText>
				<h:inputText value="#{portariaController.portaria.numero}" size="53"
					maxlength="11" required="true" onkeypress="mascara(this,soNumeros);"
					requiredMessage="Campo Numero da Portaria é obrigatório!">
				</h:inputText>
				<h:outputText value="Data da Portaria: "></h:outputText>
				<rich:calendar value="#{portariaController.portaria.data}" locale=""
					popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					required="true" inputSize="12" ajaxSingle="true"
					requiredMessage="Campo Data da Portaria é obrigatório!">
				</rich:calendar>
				<h:outputText value="Tipo da Portaria: "></h:outputText>
				<h:selectOneMenu value="#{portariaController.portaria.tipo.codigo}"
					required="true"
					requiredMessage="Campo Tipo da Portaria é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{portariaController.tiposPortaria}" />
				</h:selectOneMenu>
				<h:outputText value="Local da Portaria: "></h:outputText>
				<h:selectOneMenu value="#{portariaController.portaria.local}"
					required="true"
					requiredMessage="Campo Local da Portaria é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItem itemLabel="PROGEPE" itemValue="PROGEPE" />
					<f:selectItem itemLabel="REITORIA" itemValue="REITORIA" />
				</h:selectOneMenu>
				<h:outputText value="Descrição da Portaria: "></h:outputText>
				<h:inputTextarea value="#{portariaController.portaria.descricao}"
					rows="10" cols="50">
				</h:inputTextarea>
			</h:panelGrid>
			<rich:fileUpload rendered="#{portariaController.portaria.codigo == null}"
				fileUploadListener="#{portariaController.listener}"
				maxFilesQuantity="1"
				addControlLabel="Adicionar Portaria" id="upload"
				transferErrorLabel="Falha Ao realizar Transferência"
				doneLabelClass="Finalizada" autoclear="true" immediateUpload="true"
				listWidth="270px" stopControlLabel="Parar"
				acceptedTypes="pdf" allowFlash="true"
				sizeErrorLabel="PDF muito grande" uploadControlLabel="Carregar"
				listHeight="70px" >
				<a4j:support event="onuploadcomplete" />
			</rich:fileUpload>
			<a4j:commandButton value="Salvar"
				action="#{portariaController.salvar}" reRender="form" />

		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>