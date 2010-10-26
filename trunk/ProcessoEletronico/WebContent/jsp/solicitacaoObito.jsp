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

			<font size="2"><b>LICEN�A DE �BITO</b></font>
			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoObitoController.solicitacaoObito.solicitante.siape} - #{solicitacaoObitoController.solicitacaoObito.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Nome do Falecido: " />
				<h:inputText
					value="#{solicitacaoObitoController.solicitacaoObito.nomeFalecido}"
					size="50" maxlength="100" required="true"
					requiredMessage="Campo Nome do Falecido � obrigat�rio!">
				</h:inputText>

				<h:outputText value="Grau Parentesco: " />
				<h:selectOneMenu
					value="#{solicitacaoObitoController.solicitacaoObito.grauParentesco.codigo}"
					required="true"
					requiredMessage="Campo Grau Parentesco � obrigat�rio!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems
						value="#{solicitacaoObitoController.grausParentescos}" />
				</h:selectOneMenu>

				<h:outputText value="N�mero da certid�o de �bito: " />
				<h:inputText
					value="#{solicitacaoObitoController.solicitacaoObito.numeroCertidao}"
					size="20" maxlength="9" required="true"
					onkeypress="mascara(this,soNumeros);"
					requiredMessage="Campo N�mero da Certid�o de �bito � obrigat�rio!">
				</h:inputText>
			</h:panelGrid>

			<h:panelGrid columns="1">
				<rich:fileUpload addControlLabel="Adicionar Certidao de �bito"
					fileUploadListener="#{solicitacaoObitoController.listener}"
					id="upload" required="true"
					requiredMessage="� necessario anexar o Certid�o de �bito!"
					immediate="false" allowFlash="false" clearAllControlLabel="Limpar"
					clearControlLabel="" cancelEntryControlLabel=""
					doneLabel="Finalizada" stopButtonClassDisabled="true"
					transferErrorLabel="Falha Ao realizar Transfer�ncia"
					doneLabelClass="Finalizada" autoclear="true"
					acceptedTypes="jpg, gif, png, bmp" maxFilesQuantity="1"
					listWidth="270px" stopControlLabel="Parar" stopEntryControlLabel=""
					sizeErrorLabel="Foto muito grande" uploadControlLabel="Carregar"
					listHeight="70px">
					<a4j:support event="onuploadcomplete" reRender="info" />
				</rich:fileUpload>
				<h:panelGroup id="info">
					<a4j:mediaOutput element="img"
						createContent="#{solicitacaoObitoController.paint}"
						value="#{solicitacaoObitoController.solicitacaoObito.certidaoObito}"
						style="width:100px; height:200px;" cacheable="false">
					</a4j:mediaOutput>
				</h:panelGroup>
			</h:panelGrid>

			<a4j:commandButton value="Salvar"
				action="#{solicitacaoObitoController.salvar}" reRender="form" />
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>