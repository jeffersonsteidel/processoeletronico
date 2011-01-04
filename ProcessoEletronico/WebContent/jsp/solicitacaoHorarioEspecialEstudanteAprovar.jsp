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
					value="Solicitante: #{solicitacaoController.solicitacaoHorarioEspecialEstudante.solicitante.siape} - #{solicitacaoController.solicitacaoHorarioEspecialEstudante.solicitante.nome}">
				</h:outputText>
				<h:outputText
					value="Jornada de Trabalho: #{solicitacaoHorarioEspecialEstudanteController.solicitacaoHorarioEspecialEstudante.solicitante.regimeTrabalho.descricao}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Curso: " />
				<h:outputText
					value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.curso}">
				</h:outputText>

				<h:outputText value="Instituição: " />
				<h:outputText
					value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.instituicao}">
				</h:outputText>

				<h:outputText value="Motivo: " />
				<h:outputText
					value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.motivo}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="1">
				<h:outputText value="Horário de Compensação: " />
				<h:outputText value="Segunda-feira " />
				<h:panelGrid columns="8">
					<h:outputText value="Entrada: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioEntradaSegunda}" />
					<h:outputText value="Saída para Almoço:" />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoSegunda}" />
					<h:outputText value="Retorno do Almoço: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoSegunda}" />
					<h:outputText value="Saída: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaSegunda}" />
				</h:panelGrid>
				<h:outputText value="Terça-feira " />
				<h:panelGrid columns="8">
					<h:outputText value="Entrada: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioEntradaTerca}" />
					<h:outputText value="Saída para Almoço:" />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoTerca}" />
					<h:outputText value="Retorno do Almoço: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoTerca}" />
					<h:outputText value="Saída: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaTerca}" />
				</h:panelGrid>
				<h:outputText value="Quarta-feira" />
				<h:panelGrid columns="8">
					<h:outputText value="Entrada: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioEntradaQuarta}" />
					<h:outputText value="Saída para Almoço:" />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoQuarta}" />
					<h:outputText value="Retorno do Almoço: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoQuarta}" />
					<h:outputText value="Saída: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaQuarta}" />
				</h:panelGrid>
				<h:outputText value="Quinta-feira " />
				<h:panelGrid columns="8">
					<h:outputText value="Entrada: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioEntradaQuinta}" />
					<h:outputText value="Saída para Almoço:" />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoQuinta}" />
					<h:outputText value="Retorno do Almoço: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoQuinta}" />
					<h:outputText value="Saída: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaQuinta}" />
				</h:panelGrid>
				<h:outputText value="Sexta-feira" />
				<h:panelGrid columns="8">
					<h:outputText value="Entrada: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioEntradaSexta}" />
					<h:outputText value="Saída para Almoço:" />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoSexta}" />
					<h:outputText value="Retorno do Almoço: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoSexta}" />
					<h:outputText value="Saída: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaSexta}" />
				</h:panelGrid>
				<h:outputText value="Sábado" />
				<h:panelGrid columns="8">
					<h:outputText value="Entrada: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioEntradaSabado}" />
					<h:outputText value="Saída para Almoço:" />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoSabado}" />
					<h:outputText value="Retorno do Almoço: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoSabado}" />
					<h:outputText value="Saída: " />
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaSabado}" />
				</h:panelGrid>
			</h:panelGrid>

			<h:panelGroup id="info">
				<rich:panel bodyClass="info">
					<rich:dataGrid columns="1"
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.files}"
						var="file" rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="2">
								<a4j:mediaOutput element="img"
									createContent="#{solicitacaoController.paint}" value="#{row}"
									style="width:600px; height:800px;" cacheable="false">
								</a4j:mediaOutput>
							</h:panelGrid>
						</rich:panel>
					</rich:dataGrid>
				</rich:panel>
			</h:panelGroup>

			<h:panelGrid columns="2">
				<h:outputText value="Justificativa: " />
				<h:inputTextarea disabled="#{solicitacaoController.desabilitaBotao}"
					value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.justificativa}"
					cols="50" rows="5"></h:inputTextarea>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<a4j:commandButton value="Deferir" reRender="form"
					disabled="#{solicitacaoController.desabilitaBotao}"
					oncomplete="#{rich:component('confirmPanel')}.show()" />
				<a4j:commandButton value="Indeferir" reRender="form"
					disabled="#{solicitacaoController.desabilitaBotao}"
					oncomplete="#{rich:component('confirmPanel02')}.show()" />
			</h:panelGrid>
		</rich:panel></center>

		<rich:modalPanel id="confirmPanel" autosized="true" width="200">
			<f:facet name="header">
				<h:outputText value="Confirma este deferimento?"
					style="padding-right:15px;" />
			</f:facet>
			<h:form>
				<table width="100%">
					<tbody>
						<tr>
							<td align="center" width="50%"><a4j:commandButton
								value="Sim" ajaxSingle="true"
								action="#{solicitacaoController.deferirSolicitacao}"
								oncomplete="#{rich:component('confirmPanel')}.hide();"
								reRender="form" /></td>
							<td align="center" width="50%"><a4j:commandButton
								value="Não"
								onclick="#{rich:component('confirmPanel')}.hide();return false;" />
							</td>
						</tr>
					</tbody>
				</table>
			</h:form>
		</rich:modalPanel>
		<rich:modalPanel id="confirmPanel02" autosized="true" width="200">
			<f:facet name="header">
				<h:outputText value="Confirma este indeferimento?"
					style="padding-right:15px;" />
			</f:facet>
			<h:form>
				<table width="100%">
					<tbody>
						<tr>
							<td align="center" width="50%"><a4j:commandButton
								value="Sim" ajaxSingle="true"
								action="#{solicitacaoController.indeferirSolicitacao}"
								oncomplete="#{rich:component('confirmPanel02')}.hide();"
								reRender="form" /></td>
							<td align="center" width="50%"><a4j:commandButton
								value="Não"
								onclick="#{rich:component('confirmPanel02')}.hide();return false;" />
							</td>
						</tr>
					</tbody>
				</table>
			</h:form>
		</rich:modalPanel>
	</a4j:form>
</f:view>
</body>
</html>