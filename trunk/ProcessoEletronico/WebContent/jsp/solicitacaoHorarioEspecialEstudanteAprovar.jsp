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
			<font size="2"><b>HORÁRIO ESPECIAL PARA ESTUDANTE</b></font>
			<h:panelGrid columns="1">
				<h:outputText
					value="Solicitante: #{solicitacaoController.solicitacaoHorarioEspecialEstudante.solicitante.siape} - #{solicitacaoController.solicitacaoHorarioEspecialEstudante.solicitante.nome}">
				</h:outputText>
				<h:outputText
					value="Jornada de Trabalho: #{solicitacaoController.solicitacaoHorarioEspecialEstudante.solicitante.regimeTrabalho.descricao}">
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


				<h:panelGrid columns="6" border="1">
					<h:outputText>
						<b>Dia da Semana</b>
					</h:outputText>
					<h:outputText>
						<b>Horário de Entrada</b>
					</h:outputText>
					<h:outputText>
						<b>Horário de Saida para Almoço</b>
					</h:outputText>
					<h:outputText>
						<b>Horário de Retorno do Almoço</b>
					</h:outputText>
					<h:outputText>
						<b>Horário de Saída</b>
					</h:outputText>
					<h:outputText>
						<b>Carga Horária do Dia</b>
					</h:outputText>
					<h:outputText value="Segunda-Feira"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioEntradaSegunda}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoSegunda}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoSegunda}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaSegunda}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.totalSegunda}"></h:outputText>
					<h:outputText value="Terca-Feira"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioEntradaTerca}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoTerca}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoTerca}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaTerca}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.totalTerca}"></h:outputText>
					<h:outputText value="Quarta-Feira"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioEntradaQuarta}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoQuarta}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoQuarta}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaQuarta}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.totalQuarta}"></h:outputText>
					<h:outputText value="Quinta-Feira"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioEntradaQuinta}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoQuinta}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoQuinta}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaQuinta}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.totalQuinta}"></h:outputText>
					<h:outputText value="Sexta-Feira"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioEntradaSexta}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoSexta}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoSexta}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaSexta}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.totalSexta}"></h:outputText>
					<h:outputText value="Sabado"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioEntradaSabado}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaAlmocoSabado}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioRetornoAlmocoSabado}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.horarioSaidaSabado}"></h:outputText>
					<h:outputText
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.totalSabado}"></h:outputText>
				</h:panelGrid>

			</h:panelGrid>
			<center><b><h:panelGrid columns="1" border="1">
				<h:outputText
					value="Total da Semana: #{solicitacaoController.solicitacaoHorarioEspecialEstudante.totalSemana}" />
			</h:panelGrid></b></center>
			<h:panelGroup id="info">
				<rich:panel bodyClass="info">
					<rich:dataGrid columns="1"
						value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.declaracaoMatricula}"
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
			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<h:panelGrid columns="2">
				<h:outputText value="Justificativa: " />
				<h:inputTextarea disabled="#{solicitacaoController.desabilitaBotao}"
					value="#{solicitacaoController.solicitacaoHorarioEspecialEstudante.justificativa}"
					cols="50" rows="5">
				</h:inputTextarea>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<a4j:commandButton value="Deferir" reRender="form"
					disabled="#{solicitacaoController.desabilitaBotao}"
					oncomplete="#{rich:component('confirmPanel')}.show()" />
				<a4j:commandButton value="Indeferir" reRender="form"
					disabled="#{solicitacaoController.desabilitaBotao}"
					oncomplete="#{rich:component('confirmPanel02')}.show()" />
			</h:panelGrid>
			<h:panelGrid columns="1"
				rendered="#{solicitacaoController.desabilitaBotao && autenticacaoController.siapeAutenticado.indAdministrador}">
				<a4j:commandButton value="Voltar"
					action="#{solicitacaoController.retornarUltimaPesquisa}" />
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