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

			<font size="2"><b>ANEXAR DOCUMENTOS</b></font>
			<h:panelGrid columns="2">
				<h:outputText
					value="#{documentoImagemController.documentoImagem.servidor.siape} - #{documentoImagemController.documentoImagem.servidor.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="1">
				<h:outputText value="Titular do Documento: ">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="3">
				<h:selectOneRadio id="radios"
					value="#{documentoImagemController.titularDocumento}"
					required="Campo Titular do Documento é obrigatório!">
					<f:selectItem itemValue="1" itemLabel="Servidor" />
					<f:selectItem itemValue="2" itemLabel="Cônjuge" />
					<f:selectItem itemValue="3" itemLabel="Dependente" />
					<a4j:support event="onclick" action="#"
						 ajaxSingle="true" reRender="nomeTitular, conjuge, dependente"></a4j:support>
				</h:selectOneRadio>
			</h:panelGrid>

			<h:outputText value="Nome do Titular do Documento: " id="nomeTitular"
				rendered="#{documentoImagemController.titularDocumento != 1}" />
			<h:panelGrid columns="3">
				<h:selectOneMenu id="conjuge"
					rendered="#{documentoImagemController.titularDocumento == 2}"
					value="#{documentoImagemController.documentoImagem.conjuge.codigo}"
					required="true"
					requiredMessage="Campo Nome do Titular do Documento é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{documentoImagemController.conjuges}" />
				</h:selectOneMenu>
				<h:selectOneMenu id="dependente"
					rendered="#{documentoImagemController.titularDocumento == 3}"
					value="#{documentoImagemController.documentoImagem.dependente.codigo}"
					required="true"
					requiredMessage="Campo Nome do Titular do Documento é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{documentoImagemController.dependentes}" />
				</h:selectOneMenu>
			</h:panelGrid>

			<h:outputText value="Tipo de Documento: " />
			<h:selectOneMenu value="#" required="true"
				requiredMessage="Campo Tipo de Documento é obrigatório!">
				<f:selectItem itemLabel="SELECIONE" itemValue="" />
				<f:selectItems value="#{documentoImagemController.tiposDocumentos}" />
			</h:selectOneMenu>

			<rich:fileUpload
				fileUploadListener="#{documentoImagemController.listener}"
				maxFilesQuantity="3" required="true"
				addControlLabel="Adicionar Documento" id="upload"
				transferErrorLabel="Falha Ao realizar Transferência"
				doneLabelClass="Finalizada" autoclear="true" immediateUpload="true"
				listWidth="270px" stopControlLabel="Parar"
				acceptedTypes="jpg, gif, png" allowFlash="true"
				sizeErrorLabel="Foto muito grande" uploadControlLabel="Carregar"
				listHeight="70px">
				<a4j:support event="onuploadcomplete" reRender="info" />
			</rich:fileUpload>
			<a4j:commandButton value="Salvar" action="#" reRender="form" />
			<h:panelGroup id="info">
				<rich:panel bodyClass="info">
					<rich:dataGrid columns="1"
						value="#{documetoImagemController.files}" var="file"
						rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="2">
								<a4j:mediaOutput element="img"
									createContent="#{documetoImagemController.paint}"
									value="#{row}" style="width:600px; height:800px;"
									cacheable="false">
								</a4j:mediaOutput>
							</h:panelGrid>
						</rich:panel>
					</rich:dataGrid>
				</rich:panel>
			</h:panelGroup>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>