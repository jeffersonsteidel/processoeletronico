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

			<font size="2"><b>RESSARCIMENTO SAÚDE</b></font>
			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoRessarcimentoSaudeController.solicitacaoRessarcimentoSaude.solicitante.siape} - #{solicitacaoRessarcimentoSaudeController.solicitacaoRessarcimentoSaude.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="2">
			<h:outputText value="Data de Pagamento: " />
				<rich:calendar value="#{solicitacaoRessarcimentoSaudeController.solicitacaoRessarcimentoSaude.dataPagamento}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					inputSize="12" required="true"
					requiredMessage="Campo Data de Pagamento é obrigatório!" />
			<h:outputText value="Valor do Pagamento: " />
						<h:inputText value="#{solicitacaoRessarcimentoSaudeController.solicitacaoRessarcimentoSaude.valor}"
							size="10" required="true"
							requiredMessage="Campo Valor do Pagamento é obrigatório!"
							onkeypress="mascara(this,moeda);"></h:inputText>
			</h:panelGrid>
				<rich:fileUpload
				fileUploadListener="#{solicitacaoRessarcimentoSaudeController.listener}"
				maxFilesQuantity="1" required="true"
				requiredMessage="É necessário adicionar o Comprovante de Pagamento!"
				addControlLabel="Adicionar Comprovante de Pagamento" id="upload"
				transferErrorLabel="Falha Ao realizar Transferência"
				doneLabelClass="Finalizada" autoclear="true" immediateUpload="true"
				listWidth="270px" stopControlLabel="Parar"
				acceptedTypes="jpg, gif, png" allowFlash="true"
				sizeErrorLabel="Foto muito grande" uploadControlLabel="Carregar"
				listHeight="70px">
				<a4j:support event="onuploadcomplete" reRender="info" />
			</rich:fileUpload>
			<a4j:commandButton value="Salvar"
				action="#{solicitacaoRessarcimentoSaudeController.salvar}"
				reRender="form" />

			<h:panelGroup id="info">
				<rich:panel bodyClass="info">
					<rich:dataGrid columns="1"
						value="#{solicitacaoRessarcimentoSaudeController.solicitacaoRessarcimentoSaude.comprovante}"
						var="file" rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="2">
								<a4j:mediaOutput element="img"
									createContent="#{solicitacaoRessarcimentoSaudeController.paint}"
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