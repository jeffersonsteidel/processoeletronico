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

			<font size="2"><b>SOLICITAÇÃO DE HORÁRIO ESPECIAL PARA ESTUDANTE</b></font>
			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.solicitante.siape} - #{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Curso: " />
				<h:inputText
					value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.curso}"
					size="53" maxlength="80" required="true"
					requiredMessage="Campo Curso é obrigatório!">
				</h:inputText>

				<h:outputText value="Instituição: " />
				<h:inputText
					value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.instituicao}"
					size="53" maxlength="120" required="true"
					requiredMessage="Campo Instituição é obrigatório!">
				</h:inputText>

				<h:outputText value="Motivo: " />
				<h:inputTextarea
					value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.motivo}"
					cols="50" rows="5" required="true"
					requiredMessage="Campo Motivo é obrigatório!">
				</h:inputTextarea>
			</h:panelGrid>
			<h:panelGrid columns="1">
				<rich:fileUpload addControlLabel="Adicionar Declaracao de Matricula"
					fileUploadListener="#{solicitacaoHorarioEspecialEstudanteController.listener}"
					id="upload" required="true" 
					requiredMessage="É necessario anexar a Declaracao de Matricula!"
					immediate="false" allowFlash="false" clearAllControlLabel="Limpar"
					clearControlLabel="" cancelEntryControlLabel=""
					doneLabel="Finalizada" stopButtonClassDisabled="true"
					transferErrorLabel="Falha Ao realizar Transferência"
					doneLabelClass="Finalizada" autoclear="true"
					acceptedTypes="jpg, gif, png, bmp" maxFilesQuantity="1"
					listWidth="300px" stopControlLabel="Parar" stopEntryControlLabel=""
					sizeErrorLabel="Foto muito grande" uploadControlLabel="Carregar"
					listHeight="70px">
					<a4j:support event="onuploadcomplete" reRender="info" />
				</rich:fileUpload>
				<h:panelGroup id="info">
					<a4j:mediaOutput element="img"
						createContent="#{solicitacaoHorarioEspecialEstudanteController.paint}"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.declaracaoMatricula}"
						style="width:100px; height:200px;" cacheable="false">
					</a4j:mediaOutput>
				</h:panelGroup>
			</h:panelGrid>


			<a4j:commandButton value="Salvar"
				action="#{solicitacaoHorarioEspecialEstudanteController.salvar}" reRender="form" />
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>