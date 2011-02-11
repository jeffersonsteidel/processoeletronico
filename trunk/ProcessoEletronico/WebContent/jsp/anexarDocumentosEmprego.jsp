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
<body onload="carregar()">
<f:view>
	<jsp:directive.include file="menus.jsp" />
	<a4j:loadScript src="../js/script.js" />
	<a4j:form id="form">
			<a4j:jsFunction immediate="true" ajaxSingle="true"
			action="#{documentoImagemController.listarDocumentosEmprego}"
			name="carregar" reRender="documentos"/>
		<center><rich:panel id="painelPai">
			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<font size="2"><b>ADICIONAR DOCUMENTOS - EMPREGO</b></font>
			<h:panelGrid columns="2">
				<h:outputText
					value="#{documentoImagemController.documentoImagem.servidor.siape} - #{documentoImagemController.documentoImagem.servidor.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="3" id="titular">
				<h:outputText value="Emprego do Documento: "
					/>

				<h:selectOneMenu
					value="#{documentoImagemController.documentoImagem.emprego.codigo}"
					required="true" 
					requiredMessage="Campo Emprego do Documento é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{documentoImagemController.empregos}" />
					<a4j:support event="onchange"
						action="#{documentoImagemController.listarDocumentosEmprego}"
						ajaxSingle="true" reRender="documentos"></a4j:support>
				</h:selectOneMenu>
			</h:panelGrid>
<center><h:panelGrid columns="1" id="documentos">
				<h:outputText value="Documentos já anexados:" rendered="#{not empty documentoImagemController.documentoList && documentoImagemController.documentoImagem.emprego.codigo != null}"/>
				<h:outputText styleClass="negrito" value="Nenhum Documento para este Emprego!" rendered="#{empty documentoImagemController.documentoList  && documentoImagemController.documentoImagem.emprego.codigo != null}"/>
				<rich:dataTable id="listaDocumento" rendered="#{not empty documentoImagemController.documentoList  && documentoImagemController.documentoImagem.emprego.codigo != null}"
					value="#{documentoImagemController.documentoList}" var="list" width="600px"
					columnClasses="center" reRender="ds">
					<rich:column width="550px">
						<f:facet name="header">
							<h:outputText value="Tipo Documento" />
						</f:facet>
						<h:outputText value="#{list.tipoDocumento.descricao}" />
					</rich:column>
					<rich:column width="50px">
						<f:facet name="header">
							<h:outputText value="Visualizar" />
						</f:facet>
						<a4j:commandLink
							action="#{documentoImagemController.verDocumentos}"
							reRender="editPanel" ajaxSingle="true">
							<h:graphicImage value="../images/visualizar.gif" style="border:0"
								width="20" height="18" id="visualizar" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{documentoImagemController.documentoImagem.codigo}" />
						</a4j:commandLink>
						<rich:toolTip for="visualizar" value="Visualizar" />
					</rich:column>
				</rich:dataTable>
			</h:panelGrid></center>

			<h:outputText value="Tipo de Documento: " />
			<h:selectOneMenu
				value="#{documentoImagemController.documentoImagem.tipoDocumento.codigo}"
				required="true"
				requiredMessage="Campo Tipo de Documento é obrigatório!">
				<f:selectItem itemLabel="REGISTRO NA CARTEIRA DE TRABALHO" itemValue="15" />
			</h:selectOneMenu>

			<rich:fileUpload
				rendered="#{documentoImagemController.documentoImagem.codigo == null}"
				fileUploadListener="#{documentoImagemController.listener}"
				maxFilesQuantity="3" clearAllControlLabel="Limpar Todos"
				addControlLabel="Adicionar Documento" id="upload"
				transferErrorLabel="Falha Ao realizar Transferência"
				doneLabelClass="Finalizada" immediateUpload="true" listWidth="400px"
				stopControlLabel="Parar" autoclear="true"
				acceptedTypes="jpg, gif, png, bmp" allowFlash="true"
				sizeErrorLabel="Foto muito grande" uploadControlLabel="Carregar"
				listHeight="70px">
				<a4j:support event="onuploadcomplete" reRender="info" />
			</rich:fileUpload>

			<a4j:commandButton value="Salvar"
				action="#{documentoImagemController.salvar}"
				reRender="form, info,painelPai, titular" />
				
			<a4j:region>
				<a4j:commandButton value="Voltar"
					action="#{empregoController.abrirEmprego}" />
			</a4j:region>

			<h:panelGroup id="info">
				<rich:panel bodyClass="info">
					<rich:dataGrid columns="1"
						value="#{documentoImagemController.documentoImagem.imagem1}"
						var="file" rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="5">
								<a4j:mediaOutput element="img"
									createContent="#{documentoImagemController.paint1}"
									value="#{row}" style="width:600px; height:800px;"
									cacheable="false">
								</a4j:mediaOutput>
							</h:panelGrid>
						</rich:panel>
					</rich:dataGrid>
					<rich:dataGrid columns="1"
						value="#{documentoImagemController.documentoImagem.imagem2}"
						var="file" rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="5">
								<a4j:mediaOutput element="img"
									createContent="#{documentoImagemController.paint2}"
									value="#{row}" style="width:600px; height:800px;"
									cacheable="false">
								</a4j:mediaOutput>
							</h:panelGrid>
						</rich:panel>
					</rich:dataGrid>
					<rich:dataGrid columns="1"
						value="#{documentoImagemController.documentoImagem.imagem3}"
						var="file" rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="5">
								<a4j:mediaOutput element="img"
									createContent="#{documentoImagemController.paint3}"
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