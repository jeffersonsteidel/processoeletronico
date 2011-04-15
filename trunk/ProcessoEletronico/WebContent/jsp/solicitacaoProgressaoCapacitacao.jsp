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
			<font size="2"><b>PROGRESSÃO POR CAPACITAÇÃO</b></font>
			<h:panelGrid columns="2">
				<h:outputText
					value="#{solicitacaoProgressaoCapacitacaoController.solicitacaoProgressaoCapacitacao.solicitante.siape} - #{solicitacaoProgressaoCapacitacaoController.solicitacaoProgressaoCapacitacao.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>
			<br>
			<h:panelGrid columns="6">
				<h:outputText value="Curso: "></h:outputText>
				<h:inputText
					value="#{solicitacaoProgressaoCapacitacaoController.solicitacaoProgressaoCapacitacao.curso}"
					size="40" maxlength="60"
					requiredMessage="Campo Curso é obrigatório!" required="true">
				</h:inputText>
				<h:outputText value="Instituição de Ensino: "></h:outputText>
				<h:inputText
					value="#{solicitacaoProgressaoCapacitacaoController.solicitacaoProgressaoCapacitacao.instituicaoEnsino}"
					size="40" maxlength="60"
					requiredMessage="Campo Instituição de Ensino é obrigatório!"
					required="true"></h:inputText>
				<h:outputText value="Carga Horária: "></h:outputText>
				<h:inputText
					value="#{solicitacaoProgressaoCapacitacaoController.solicitacaoProgressaoCapacitacao.cargaHoraria}"
					size="5" maxlength="6"
					requiredMessage="Campo Carga Horária é obrigatório!"
					required="true">
				</h:inputText>

			</h:panelGrid>

			<h:panelGrid columns="4">
				<h:outputText value="Periodo: "></h:outputText>
				<rich:calendar
					value="#{solicitacaoProgressaoCapacitacaoController.solicitacaoProgressaoCapacitacao.dataInicio}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					required="true" inputSize="12" ajaxSingle="true"
					requiredMessage="Campo Data Periodo é obrigatório!">
				</rich:calendar>
				<h:outputText value=" a "></h:outputText>
				<rich:calendar
					value="#{solicitacaoProgressaoCapacitacaoController.solicitacaoProgressaoCapacitacao.dataTermino}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					required="true" inputSize="12" ajaxSingle="true"
					requiredMessage="Campo Data Periodo é obrigatório!">
				</rich:calendar>
			</h:panelGrid>

			<rich:fileUpload
				fileUploadListener="#{solicitacaoProgressaoCapacitacaoController.listener}"
				addControlLabel="Adicionar Diploma e TCC" id="upload"
				transferErrorLabel="Falha Ao realizar Transferência"
				doneLabelClass="Finalizada" autoclear="true" immediateUpload="true"
				listWidth="270px" stopControlLabel="Parar"
				acceptedTypes="jpg, gif, png" allowFlash="true"
				sizeErrorLabel="Foto muito grande" uploadControlLabel="Carregar"
				listHeight="70px">
				<a4j:support event="onuploadcomplete" reRender="info" />
			</rich:fileUpload>

			<h:panelGroup id="info">
				<rich:panel bodyClass="info">
					<rich:dataGrid columns="1"
						value="#{solicitacaoProgressaoCapacitacaoController.documentoImagem.certificado}"
						var="file" rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="2">
								<a4j:mediaOutput element="img"
									createContent="#{solicitacaoProgressaoCapacitacaoController.paint}"
									value="#{row}" style="width:600px; height:800px;"
									cacheable="false">
								</a4j:mediaOutput>
							</h:panelGrid>
						</rich:panel>
					</rich:dataGrid>
				</rich:panel>
			</h:panelGroup>

			<a4j:commandButton value="Salvar"
				action="#{solicitacaoProgressaoCapacitacaoController.salvar}"
				reRender="form" />
		</rich:panel></center>
	</a4j:form>

</f:view>
</body>
</html>