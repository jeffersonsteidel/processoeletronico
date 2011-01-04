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

			<font size="2"><b>SOLICITA��O DE HOR�RIO ESPECIAL PARA
			ESTUDANTE</b></font>
			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.solicitante.siape} - #{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.solicitante.nome}">
				</h:outputText>
				<h:outputText
					value="Jornada de Trabalho - #{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.solicitante.regimeTrabalho.descricao}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Curso: " />
				<h:inputText
					value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.curso}"
					size="53" maxlength="80" required="true"
					requiredMessage="Campo Curso � obrigat�rio!">
				</h:inputText>

				<h:outputText value="Institui��o: " />
				<h:inputText
					value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.instituicao}"
					size="53" maxlength="120" required="true"
					requiredMessage="Campo Institui��o � obrigat�rio!">
				</h:inputText>

				<h:outputText value="Motivo: " />
				<h:inputTextarea
					value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.motivo}"
					cols="50" rows="5" required="true"
					requiredMessage="Campo Motivo � obrigat�rio!">
				</h:inputTextarea>
			</h:panelGrid>


			<h:panelGrid columns="1">
				<h:outputText value="Hor�rio de Compensa��o: " />
				<h:outputText value="Segunda-feira " />
				<h:panelGrid columns="8">
					<h:outputText value="Entrada: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioEntradaSegunda}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Sa�da para Almo�o:" />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoSegunda}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Retorno do Almo�o: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoSegunda}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Sa�da: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaSegunda}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
				</h:panelGrid>
				<h:outputText value="Ter�a-feira " />
				<h:panelGrid columns="8">
					<h:outputText value="Entrada: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioEntradaTerca}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Sa�da para Almo�o:" />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoTerca}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Retorno do Almo�o: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoTerca}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Sa�da: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaTerca}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
				</h:panelGrid>
				<h:outputText value="Quarta-feira" />
				<h:panelGrid columns="8">
					<h:outputText value="Entrada: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioEntradaQuarta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Sa�da para Almo�o:" />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoQuarta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Retorno do Almo�o: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoQuarta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Sa�da: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaQuarta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
				</h:panelGrid>
				<h:outputText value="Quinta-feira " />
				<h:panelGrid columns="8">
					<h:outputText value="Entrada: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioEntradaQuinta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Sa�da para Almo�o:" />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoQuinta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Retorno do Almo�o: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoQuinta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Sa�da: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaQuinta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
				</h:panelGrid>
				<h:outputText value="Sexta-feira" />
				<h:panelGrid columns="8">
					<h:outputText value="Entrada: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioEntradaSexta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Sa�da para Almo�o:" />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoSexta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Retorno do Almo�o: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoSexta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Sa�da: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaSexta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
				</h:panelGrid>
				<h:outputText value="S�bado" />
				<h:panelGrid columns="8">
					<h:outputText value="Entrada: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioEntradaSabado}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Sa�da para Almo�o:" />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoSabado}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Retorno do Almo�o: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoSabado}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
					<h:outputText value="Sa�da: " />
					<h:inputText
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaSabado}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);">
					</h:inputText>
				</h:panelGrid>
			</h:panelGrid>

			<rich:fileUpload
				fileUploadListener="#{solicitacaoHorarioEspecialEstudanteController.listener}"
				maxFilesQuantity="1" required="true"
				requiredMessage="� necess�rio adicionar a Declara��o de Matr�cula!"
				addControlLabel="Adicionar Declaracao de Matricula" id="upload"
				transferErrorLabel="Falha Ao realizar Transfer�ncia"
				doneLabelClass="Finalizada" autoclear="true" immediateUpload="true"
				listWidth="270px" stopControlLabel="Parar"
				acceptedTypes="jpg, gif, png" allowFlash="true"
				sizeErrorLabel="Foto muito grande" uploadControlLabel="Carregar"
				listHeight="70px">
				<a4j:support event="onuploadcomplete" reRender="info" />
			</rich:fileUpload>
			<a4j:commandButton value="Salvar"
				action="#{solicitacaoHorarioEspecialEstudanteController.salvar}"
				reRender="form" />

			<h:panelGroup id="info">
				<rich:panel bodyClass="info">
					<rich:dataGrid columns="1"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.files}"
						var="file" rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="2">
								<a4j:mediaOutput element="img"
									createContent="#{solicitacaoHorarioEspecialEstudanteController.paint}"
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