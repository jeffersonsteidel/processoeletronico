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
				<a4j:region>
					<a4j:commandLink
						action="#{dependenteController.abrirAdicionarDependentes}"
						value="#{solicitacaoLicencaPaternidadeController.texto}"></a4j:commandLink>
				</a4j:region>
			</rich:messages>

			<font size="2"><b>LICENÇA PATERNIDADE</b></font>

			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoLicencaPaternidadeController.solicitacaoLicencaPaternidade.solicitante.siape} - #{solicitacaoLicencaPaternidadeController.solicitacaoLicencaPaternidade.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Data de Nascimento do Filho(a): "></h:outputText>
				<rich:calendar
					value="#{solicitacaoLicencaPaternidadeController.solicitacaoLicencaPaternidade.dataNascimento}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					required="true" inputSize="12" ajaxSingle="true"
					requiredMessage="Campo Data de Nascimento do Filho(a) é obrigatório!">
					<a4j:support event="onchanged"
						action="#{solicitacaoLicencaPaternidadeController.calcularRetorno}"
						ajaxSingle="true" reRender="form"></a4j:support>
				</rich:calendar>
				
				<h:outputText value="Data de Retorno ao Trabalho: "
					rendered="#{solicitacaoLicencaPaternidadeController.solicitacaoLicencaPaternidade.dataRetorno != null}"></h:outputText>
				<h:outputText 
					value="#{solicitacaoLicencaPaternidadeController.solicitacaoLicencaPaternidade.dataRetorno}"
					rendered="#{solicitacaoLicencaPaternidadeController.solicitacaoLicencaPaternidade.dataRetorno != null}">
					<f:convertDateTime locale="pt_BR" pattern="dd/MM/yyyy" />
				</h:outputText>
			</h:panelGrid>
			<rich:fileUpload
				fileUploadListener="#{solicitacaoLicencaPaternidadeController.listener}"
				maxFilesQuantity="1"
				addControlLabel="Adicionar Certidao de Nascimento" id="upload"
				transferErrorLabel="Falha Ao realizar Transferência"
				doneLabelClass="Finalizada" autoclear="true" immediateUpload="true"
				listWidth="270px" stopControlLabel="Parar"
				acceptedTypes="jpg, gif, png" allowFlash="true"
				sizeErrorLabel="Foto muito grande" uploadControlLabel="Carregar"
				listHeight="70px">
				<a4j:support event="onuploadcomplete" reRender="info" />
			</rich:fileUpload>
			<a4j:commandButton value="Salvar"
				action="#{solicitacaoLicencaPaternidadeController.salvar}"
				reRender="form" />

			<h:panelGroup id="info">
				<rich:panel bodyClass="info">
					<rich:dataGrid columns="1"
						value="#{solicitacaoLicencaPaternidadeController.solicitacaoLicencaPaternidade.certidaoNascimento}"
						var="file" rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="2">
								<a4j:mediaOutput element="img"
									createContent="#{solicitacaoLicencaPaternidadeController.paint}"
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