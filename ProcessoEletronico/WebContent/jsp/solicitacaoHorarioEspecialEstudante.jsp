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

			<font size="2"><b>SOLICITAÇÃO DE HORÁRIO ESPECIAL PARA
			ESTUDANTE</b></font>
			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.solicitante.siape} - #{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.solicitante.nome}">
				</h:outputText>
				<h:outputText
					value="Jornada de Trabalho: #{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.solicitante.regimeTrabalho.descricao}">
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
				<h:outputText value="Horário de Compensação: " />
				<h:outputText value="Segunda-feira " />
				<h:panelGrid columns="9">
					<h:outputText value="Entrada: " />
					<h:inputText id="entradaSegunda"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioEntradaSegunda}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Entrada (Segunda-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, segunda, entradaSegunda, saidaAlmocoSegunda, retornoAlmocoSegunda, saidaSegunda"></a4j:support>
					</h:inputText>
					<h:outputText value="Saída para Almoço:" />
					<h:inputText id="saidaAlmocoSegunda"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoSegunda}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Saida para Almoço (Segunda-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, segunda, entradaSegunda, saidaAlmocoSegunda, retornoAlmocoSegunda, saidaSegunda"></a4j:support>
					</h:inputText>
					<h:outputText value="Retorno do Almoço: " />
					<h:inputText id="retornoAlmocoSegunda"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoSegunda}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Retorno do Almoço (Segunda-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, segunda, entradaSegunda, saidaAlmocoSegunda, retornoAlmocoSegunda, saidaSegunda"></a4j:support>
					</h:inputText>
					<h:outputText value="Saída: " />
					<h:inputText id="saidaSegunda"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaSegunda}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Saida (Segunda-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, segunda, entradaSegunda, saidaAlmocoSegunda, retornoAlmocoSegunda, saidaSegunda"></a4j:support>
					</h:inputText>
					<h:outputText id="segunda"
						value="#{solicitacaoHorarioEspecialEstudanteController.totalSegunda}" />
				</h:panelGrid>
				<h:outputText value="Terça-feira " />
				<h:panelGrid columns="9">
					<h:outputText value="Entrada: " />
					<h:inputText id="entradaTerca"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioEntradaTerca}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Entrada (Terça-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, terca, entradaTerca, saidaAlmocoTerca, retornoAlmocoTerca, saidaTerca"></a4j:support>
					</h:inputText>
					<h:outputText value="Saída para Almoço:" />
					<h:inputText id="saidaAlmocoTerca"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoTerca}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Saida para Almoço (Terça-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, terca, entradaTerca, saidaAlmocoTerca, retornoAlmocoTerca, saidaTerca"></a4j:support>
					</h:inputText>
					<h:outputText value="Retorno do Almoço: " />
					<h:inputText id="retornoAlmocoTerca"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoTerca}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Retorno do Almoço (Terça-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, terca, entradaTerca, saidaAlmocoTerca, retornoAlmocoTerca, saidaTerca"></a4j:support>
					</h:inputText>
					<h:outputText value="Saída: " />
					<h:inputText  id="saidaTerca"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaTerca}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Saida (Terça-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, terca, entradaTerca, saidaAlmocoTerca, retornoAlmocoTerca, saidaTerca"></a4j:support>
					</h:inputText>
					<h:outputText id="terca"
						value="#{solicitacaoHorarioEspecialEstudanteController.totalTerca}" />
				</h:panelGrid>
				<h:outputText value="Quarta-feira" />
				<h:panelGrid columns="9">
					<h:outputText value="Entrada: " />
					<h:inputText id="entradaQuarta"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioEntradaQuarta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Entrada (Quarta-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, quarta, entradaQuarta, saidaAlmocoQuarta, retornoAlmocoQuarta, saidaQuarta"></a4j:support>
					</h:inputText>
					<h:outputText value="Saída para Almoço:" />
					<h:inputText id="saidaAlmocoQuarta"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoQuarta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Saida para Almoço (Quarta-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, quarta, entradaQuarta, saidaAlmocoQuarta, retornoAlmocoQuarta, saidaQuarta"></a4j:support>
					</h:inputText>
					<h:outputText value="Retorno do Almoço: " />
					<h:inputText id="retornoAlmocoQuarta"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoQuarta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Retorno do Almoço (Quarta-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, quarta, entradaQuarta, saidaAlmocoQuarta, retornoAlmocoQuarta, saidaQuarta"></a4j:support>
					</h:inputText>
					<h:outputText value="Saída: " />
					<h:inputText  id="saidaQuarta"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaQuarta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Saida (Quarta-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, quarta, entradaQuarta, saidaAlmocoQuarta, retornoAlmocoQuarta, saidaQuarta"></a4j:support>
					</h:inputText>
					<h:outputText id="quarta"
						value="#{solicitacaoHorarioEspecialEstudanteController.totalQuarta}" />
				</h:panelGrid>
				<h:outputText value="Quinta-feira " />
				<h:panelGrid columns="9">
					<h:outputText value="Entrada: " />
					<h:inputText id="entradaQuinta"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioEntradaQuinta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Entrada (Quinta-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, quinta, entradaQuinta, saidaAlmocoQuinta, retornoAlmocoQuinta, saidaQuinta"></a4j:support>
					</h:inputText>
					<h:outputText value="Saída para Almoço:" />
					<h:inputText id="saidaAlmocoQuinta"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoQuinta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Saida para Almoço (Quinta-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, quinta, entradaQuinta, saidaAlmocoQuinta, retornoAlmocoQuinta, saidaQuinta"></a4j:support>
					</h:inputText>
					<h:outputText value="Retorno do Almoço: " />
					<h:inputText id="retornoAlmocoQuinta"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoQuinta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Retorno do Almoço (Quinta-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, quinta, entradaQuinta, saidaAlmocoQuinta, retornoAlmocoQuinta, saidaQuinta"></a4j:support>
					</h:inputText>
					<h:outputText value="Saída: " />
					<h:inputText  id="saidaQuinta"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaQuinta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Saida (Quinta-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, quinta, entradaQuinta, saidaAlmocoQuinta, retornoAlmocoQuinta, saidaQuinta"></a4j:support>
					</h:inputText>
					<h:outputText id="quinta"
						value="#{solicitacaoHorarioEspecialEstudanteController.totalQuinta}" />
				</h:panelGrid>
				<h:outputText value="Sexta-feira" />
				<h:panelGrid columns="9">
					<h:outputText value="Entrada: " />
					<h:inputText id="entradaSexta"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioEntradaSexta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Entrada (Sexta-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, sexta, entradaSexta, saidaAlmocoSexta, retornoAlmocoSexta, saidaSexta"></a4j:support>
					</h:inputText>
					<h:outputText value="Saída para Almoço:" />
					<h:inputText id="saidaAlmocoSexta"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoSexta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Saida para Almoço (Sexta-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, sexta, entradaSexta, saidaAlmocoSexta, retornoAlmocoSexta, saidaSexta"></a4j:support>
					</h:inputText>
					<h:outputText value="Retorno do Almoço: " />
					<h:inputText id="retornoAlmocoSexta"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoSexta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Retorno do Almoço (Sexta-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, sexta, entradaSexta, saidaAlmocoSexta, retornoAlmocoSexta, saidaSexta"></a4j:support>
					</h:inputText>
					<h:outputText value="Saída: " />
					<h:inputText  id="saidaSexta"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaSexta}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Saida (Sexta-Feira) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, sexta, entradaSexta, saidaAlmocoSexta, retornoAlmocoSexta, saidaSexta"></a4j:support>
					</h:inputText>
					<h:outputText id="sexta"
						value="#{solicitacaoHorarioEspecialEstudanteController.totalSexta}" />
				</h:panelGrid>
				<h:outputText value="Sábado" />
				<h:panelGrid columns="9">
					<h:outputText value="Entrada: " />
					<h:inputText id="entradaSabado"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioEntradaSabado}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Entrada (Sabado) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, sabado, entradaSabado, saidaAlmocoSabado, retornoAlmocoSabado, saidaSabado"></a4j:support>
					</h:inputText>
					<h:outputText value="Saída para Almoço:" />
					<h:inputText id="saidaAlmocoSabado"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoSabado}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Saida para Almoço (Sabado) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, sabado, entradaSabado, saidaAlmocoSabado, retornoAlmocoSabado, saidaSabado"></a4j:support>
					</h:inputText>
					<h:outputText value="Retorno do Almoço: " />
					<h:inputText id="retornoAlmocoSabado"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoSabado}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Retorno do Almoço (Sabado) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, sabado, entradaSabado, saidaAlmocoSabado, retornoAlmocoSabado, saidaSabado"></a4j:support>
					</h:inputText>
					<h:outputText value="Saída: " />
					<h:inputText  id="saidaSabado"
						value="#{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.horarioSaidaSabado}"
						size="8" maxlength="5" onkeypress="mascara(this,horario);"
						validatorMessage="O campo Saida (Sabado) deve ter 4 digitos">
						<f:validateLength minimum="5" />
						<a4j:support event="onchange"
							action="#{solicitacaoHorarioEspecialEstudanteController.calcularTempo}"
							ajaxSingle="true" reRender="total, sabado, entradaSabado, saidaAlmocoSabado, retornoAlmocoSabado, saidaSabado"></a4j:support>
					</h:inputText>
					<h:outputText id="sabado"
						value="#{solicitacaoHorarioEspecialEstudanteController.totalSabado}" />
				</h:panelGrid>
			</h:panelGrid>
			<center><h:outputText value="Total: "/><h:outputText id="total" value="#{solicitacaoHorarioEspecialEstudanteController.totalSemana}"/></center>

			<rich:fileUpload
				fileUploadListener="#{solicitacaoHorarioEspecialEstudanteController.listener}"
				maxFilesQuantity="1" required="true"
				requiredMessage="É necessário adicionar a Declaração de Matrícula!"
				addControlLabel="Adicionar Declaracao de Matricula" id="upload"
				transferErrorLabel="Falha Ao realizar Transferência"
				doneLabelClass="Finalizada" autoclear="true" immediateUpload="true"
				listWidth="270px" stopControlLabel="Parar"
				acceptedTypes="jpg, gif, png" allowFlash="true"
				sizeErrorLabel="Foto muito grande" uploadControlLabel="Carregar"
				listHeight="70px">
				<a4j:support event="onuploadcomplete" reRender="total, info" />
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