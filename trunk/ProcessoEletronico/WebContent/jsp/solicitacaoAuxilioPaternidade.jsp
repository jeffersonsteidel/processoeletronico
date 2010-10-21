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

			<font size="2"><b>AUXÍLIO PATERNIDADE</b></font>

			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoAuxilioPaternidadeController.solicitacaoAuxilioPaternidade.solicitante.siape} - #{solicitacaoAuxilioPaternidadeController.solicitacaoAuxilioPaternidade.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="4">
				<h:outputText value="Período: "></h:outputText>
				<rich:calendar
					value="#{solicitacaoAuxilioPaternidadeController.solicitacaoAuxilioPaternidade.dataInicial}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					required="true" inputSize="12"
					requiredMessage="Campo Período (Início do Período) é obrigatório!" />

				<h:outputText value=" a "></h:outputText>
				<rich:calendar
					value="#{solicitacaoAuxilioPaternidadeController.solicitacaoAuxilioPaternidade.dataFinal}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					required="true" inputSize="12"
					requiredMessage="Campo Período (Fim do Período) é obrigatório!" />
			</h:panelGrid>

			<h:panelGrid columns="1">
				<rich:fileUpload addControlLabel="Adicionar Certidao de Nascimento"
					fileUploadListener="#{solicitacaoAuxilioPaternidadeController.listener}"
					id="upload" required="true"
					requiredMessage="É necessario anexar o Certidão de  Nascimento do Filho!"
					immediate="false" allowFlash="false" clearAllControlLabel="Limpar"
					clearControlLabel="" cancelEntryControlLabel=""
					doneLabel="Finalizada" stopButtonClassDisabled="true"
					transferErrorLabel="Falha Ao realizar Transferência"
					doneLabelClass="Finalizada" autoclear="true"
					acceptedTypes="jpg, gif, png, bmp" maxFilesQuantity="1"
					listWidth="270px" stopControlLabel="Parar" stopEntryControlLabel=""
					sizeErrorLabel="Foto muito grande" uploadControlLabel="Carregar"
					listHeight="70px">
					<a4j:support event="onuploadcomplete" reRender="info" />
				</rich:fileUpload>
				<h:panelGroup id="info">
					<a4j:mediaOutput element="img"
						createContent="#{solicitacaoAuxilioPaternidadeController.paint}"
						value="#{solicitacaoAuxilioPaternidadeController.solicitacaoAuxilioPaternidade.certidaoNascimento}"
						style="width:100px; height:200px;" cacheable="false">
					</a4j:mediaOutput>
				</h:panelGroup>
			</h:panelGrid>

			<a4j:commandButton value="Salvar"
				action="#{solicitacaoAuxilioPaternidadeController.salvar}"
				reRender="form" />
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>