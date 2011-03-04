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

	<center><rich:panel>
		<a4j:form id="form">
			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<font size="2"><b>ADICIONAL NOTURNO - TÉCNICOS</b></font>

			<br>
			<h:outputText
				value="Solicitante: #{solicitacaoController.solicitacaoAdicionalNoturnoTecnico.solicitante.siape} - #{solicitacaoController.solicitacaoAdicionalNoturnoTecnico.solicitante.nome}" />
			<br>
			<h:outputText
				value="Diretor: #{solicitacaoController.solicitacaoAdicionalNoturnoTecnico.servidor.siape} - #{solicitacaoController.solicitacaoAdicionalNoturnoTecnico.servidor.nome}" />
			<br>
			<h:outputText
				value="Processo: #{solicitacaoController.solicitacaoAdicionalNoturnoTecnico.codigo} - " />
			<h:outputText
				value="#{solicitacaoController.solicitacaoAdicionalNoturnoTecnico.dataAbertura}">
				<f:convertDateTime pattern="dd/MM/yyyy" />
			</h:outputText>
			<br>
			<h:outputText
				value="Campus: #{solicitacaoController.solicitacaoAdicionalNoturnoTecnico.lotacao.descricao}" />

			<h:panelGrid columns="1">
				<rich:dataTable id="listaSolicitacoesAdicionalTecnicos"
					value="#{solicitacaoController.solicitacaoAdicionalNoturnoTecnico.listaAdicionaisTecnicos}"
					var="list" width="1200px" columnClasses="center">

					<rich:column width="750px" sortBy="#{list.servidor.nome}">
						<f:facet name="header">
							<h:outputText value="Nome" />
						</f:facet>
						<h:outputText value="#{list.servidor.nome}" />
					</rich:column>

					<rich:column width="190px" sortBy="#{list.data}">
						<f:facet name="header">
							<h:outputText value="Data" />
						</f:facet>
						<h:outputText value="#{list.data}">
							<f:convertDateTime pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>

					<rich:column width="200px" sortBy="#{list.diaSemana}">
						<f:facet name="header">
							<h:outputText value="Dia da Semana" />
						</f:facet>
						<h:outputText value="#{list.diaSemana}">
						</h:outputText>
					</rich:column>

					<rich:column width="180px" sortBy="#{list.horaInicial}">
						<f:facet name="header">
							<h:outputText value="Horário" />
						</f:facet>
						<h:outputText value="#{list.horaInicial} - #{list.horaFinal}">
						</h:outputText>
					</rich:column>

					<rich:column width="70px" sortBy="#{list.indAprovadoDiretor}">
						<f:facet name="header">
							<h:outputText value="Aprovado" />
						</f:facet>
						<h:outputText value="SIM" rendered="#{list.indAprovadoDiretor}" />
						<h:outputText value="NÃO" rendered="#{!list.indAprovadoDiretor}" />
					</rich:column>

					<rich:column width="940px" sortBy="#{list.motivo}">
						<f:facet name="header">
							<h:outputText value="Motivo" />
						</f:facet>
						<h:outputText value="#{list.motivo}" />
					</rich:column>

				</rich:dataTable>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputText value="Justificativa: " />
				<h:inputTextarea disabled="#{solicitacaoController.desabilitaBotao}"
					value="#{solicitacaoController.solicitacaoAdicionalNoturnoTecnico.justificativa}"
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
		</a4j:form>
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
						<td align="center" width="50%"><a4j:commandButton value="Sim"
							ajaxSingle="true"
							action="#{solicitacaoController.deferirSolicitacao}"
							oncomplete="#{rich:component('confirmPanel')}.hide();"
							reRender="form" /></td>
						<td align="center" width="50%"><a4j:commandButton value="Não"
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
						<td align="center" width="50%"><a4j:commandButton value="Sim"
							ajaxSingle="true"
							action="#{solicitacaoController.indeferirSolicitacao}"
							oncomplete="#{rich:component('confirmPanel02')}.hide();"
							reRender="form" /></td>
						<td align="center" width="50%"><a4j:commandButton value="Não"
							onclick="#{rich:component('confirmPanel02')}.hide();return false;" />
						</td>
					</tr>
				</tbody>
			</table>
		</h:form>
	</rich:modalPanel>

</f:view>
</body>
</html>