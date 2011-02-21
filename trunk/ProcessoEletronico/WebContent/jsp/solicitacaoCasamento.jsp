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
						action="#{conjugeController.abrirCadastrarConjuge}"
						value="#{solicitacaoCasamentoController.texto}"></a4j:commandLink>
				</a4j:region>
			</rich:messages>

			<h:panelGrid columns="1">
				<font size="2"><b>LICENÇA DE CASAMENTO</b></font>
				<h:outputText
					value="#{solicitacaoCasamentoController.solicitacaoCasamento.solicitante.siape} - #{solicitacaoCasamentoController.solicitacaoCasamento.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputText value="Nome do Cônjuge: " />
				<h:inputText
					value="#{solicitacaoCasamentoController.solicitacaoCasamento.nomeConjuge}"
					size="50" maxlength="100" required="true"
					requiredMessage="Campo Nome do Cônjuge é obrigatório!">
				</h:inputText>

				<h:outputText value="Número da Certidão: " />
				<h:inputText
					value="#{solicitacaoCasamentoController.solicitacaoCasamento.numeroCertidao}"
					size="20" maxlength="9" required="true"
					onkeypress="mascara(this,soNumeros);"
					requiredMessage="Campo Número da Certidão é obrigatório!">
				</h:inputText>

				<h:outputText value="Data do Casamento: "></h:outputText>
				<rich:calendar
					value="#{solicitacaoCasamentoController.solicitacaoCasamento.dataCasamento}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					required="true" inputSize="12" ajaxSingle="true"
					requiredMessage="Campo Data do Casamento é obrigatório!">
					<a4j:support event="onchanged"
						action="#{solicitacaoCasamentoController.calcularRetorno}"
						ajaxSingle="true" reRender="dataRetorno"></a4j:support>
				</rich:calendar>
			</h:panelGrid>

			<h:panelGrid columns="2" id="dataRetorno">
				<h:outputText value="Data de Retorno ao Trabalho: "
					rendered="#{solicitacaoCasamentoController.solicitacaoCasamento.dataRetorno != null}"></h:outputText>
				<h:outputText
					value="#{solicitacaoCasamentoController.solicitacaoCasamento.dataRetorno}"
					rendered="#{solicitacaoCasamentoController.solicitacaoCasamento.dataRetorno != null}">
					<f:convertDateTime locale="pt_BR" pattern="dd/MM/yyyy" />
				</h:outputText>
			</h:panelGrid>



			<rich:fileUpload
				fileUploadListener="#{solicitacaoCasamentoController.listener}"
				maxFilesQuantity="1" required="true"
				requiredMessage="É necessário adicionar a  Certidão de Casamento!"
				addControlLabel="Adicionar Certidao de Casamento" id="upload"
				transferErrorLabel="Falha Ao realizar Transferência"
				doneLabelClass="Finalizada" autoclear="true" immediateUpload="true"
				listWidth="270px" stopControlLabel="Parar"
				acceptedTypes="jpg, gif, png" allowFlash="true"
				sizeErrorLabel="Foto muito grande" uploadControlLabel="Carregar"
				listHeight="70px">
				<a4j:support event="onuploadcomplete" reRender="info" />
			</rich:fileUpload>
			<a4j:commandButton value="Salvar"
				action="#{solicitacaoCasamentoController.salvar}" reRender="form" />

			<h:panelGroup id="info">
				<rich:panel bodyClass="info">
					<rich:dataGrid columns="1"
						value="#{solicitacaoCasamentoController.solicitacaoCasamento.certidaoCasamento}"
						var="file" rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="2">
								<a4j:mediaOutput element="img"
									createContent="#{solicitacaoCasamentoController.paint}"
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