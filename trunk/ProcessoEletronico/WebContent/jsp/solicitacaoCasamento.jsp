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

			<font size="2"><b>LICEN�A DE CASAMENTO</b></font>
			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoCasamentoController.solicitacaoCasamento.solicitante.siape} - #{solicitacaoCasamentoController.solicitacaoCasamento.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Nome do C�njuge: " />
				<h:inputText
					value="#{solicitacaoCasamentoController.solicitacaoCasamento.nomeConjuge}"
					size="50" maxlength="100" required="true"
					requiredMessage="Campo Nome do C�njuge � obrigat�rio!">
				</h:inputText>

				<h:outputText value="N�mero da Certid�o de Casamento: " />
				<h:inputText
					value="#{solicitacaoCasamentoController.solicitacaoCasamento.numeroCertidao}"
					size="20" maxlength="9" required="true"
					onkeypress="mascara(this,soNumeros);"
					requiredMessage="Campo N�mero da Certid�o de Casamento � obrigat�rio!">
				</h:inputText>
			</h:panelGrid>

			<rich:fileUpload
				fileUploadListener="#{solicitacaoCasamentoController.listener}"
				maxFilesQuantity="1"
				addControlLabel="Adicionar Certidao de Nascimento" id="upload"
				transferErrorLabel="Falha Ao realizar Transfer�ncia"
				doneLabelClass="Finalizada" autoclear="true" immediateUpload="true"
				listWidth="270px" stopControlLabel="Parar"
				acceptedTypes="jpg, gif, png, bmp" allowFlash="true"
				sizeErrorLabel="Foto muito grande" uploadControlLabel="Carregar"
				listHeight="70px">
				<a4j:support event="onuploadcomplete" reRender="info" />
			</rich:fileUpload>
			<a4j:commandButton value="Salvar"
				action="#{solicitacaoCasamentoController.salvar}" reRender="form" />

			<h:panelGroup id="info">
				<rich:panel bodyClass="info">
					<rich:dataGrid columns="1"
						value="#{solicitacaoCasamentoController.files}" var="file"
						rowKeyVar="row">
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