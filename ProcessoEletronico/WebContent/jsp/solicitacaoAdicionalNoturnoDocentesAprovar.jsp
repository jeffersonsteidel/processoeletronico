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
			<font size="2"><b>SOLICITAÇÕES DE ADICIONAL NOTURNO -
			DOCENTES</b></font>
			<br><h:outputText
				value="Solicitante: #{solicitacaoController.solicitacaoAdicionalNoturnoDocente.solicitante.siape} - #{solicitacaoController.solicitacaoAdicionalNoturnoDocente.solicitante.nome}" />
			<br>
			<h:outputText
				value="Diretor: #{solicitacaoController.solicitacaoAdicionalNoturnoDocente.servidor.siape} - #{solicitacaoController.solicitacaoAdicionalNoturnoDocente.servidor.nome}" />
			<br><h:outputText value="Processo: #{solicitacaoController.solicitacaoAdicionalNoturnoDocente.codigo} - " />
			<h:outputText  value="#{solicitacaoController.solicitacaoAdicionalNoturnoDocente.dataAbertura}">
				<f:convertDateTime pattern="dd/MM/yyyy" />
			</h:outputText>
			<br><h:outputText
				value="Campus: #{solicitacaoController.solicitacaoAdicionalNoturnoDocente.lotacao.descricao}" />

			<h:panelGrid columns="1">
				<rich:dataTable id="listaSolicitacoesAdicionalDocentes"
					value="#{solicitacaoController.solicitacaoAdicionalNoturnoDocente.listaAdicionaisDocente}"
					var="list" width="1200px" columnClasses="center">

					<rich:column width="550px" sortBy="#{list.servidor.nome}">
						<f:facet name="header">
							<h:outputText value="Nome" />
						</f:facet>
						<h:outputText value="#{list.servidor.nome}" />
					</rich:column>

					<rich:column width="80px" sortBy="#{list.data}">
						<f:facet name="header">
							<h:outputText value="Data" />
						</f:facet>
						<h:outputText value="#{list.data}">
							<f:convertDateTime pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>

					<rich:column width="100px" sortBy="#{list.diaSemana}">
						<f:facet name="header">
							<h:outputText value="Dia da Semana" />
						</f:facet>
						<h:outputText value="#{list.diaSemana}">
						</h:outputText>
					</rich:column>

					<rich:column width="130px" sortBy="#{list.horaInicial}">
						<f:facet name="header">
							<h:outputText value="Horário" />
						</f:facet>
						<h:outputText value="#{list.horaInicial} - #{list.horaFinal}" />
					</rich:column>
					<rich:column sortBy="#{list.curso}" width="250px">
						<f:facet name="header">
							<h:outputText value="Curso" />
						</f:facet>
						<h:outputText value="#{list.curso}" />
					</rich:column>
					<rich:column sortBy="#{list.materia}" width="250px">
						<f:facet name="header">
							<h:outputText value="Matéria" />
						</f:facet>
						<h:outputText value="#{list.materia}" />
					</rich:column>
					<rich:column sortBy="#{list.turma}" width="100px">
						<f:facet name="header">
							<h:outputText value="Turma" />
						</f:facet>
						<h:outputText value="#{list.turma}" />
					</rich:column>
					
					<rich:column width="70px" sortBy="#{list.indAprovadoDiretor}">
						<f:facet name="header">
							<h:outputText value="Aprovado" />
						</f:facet>
						<h:outputText value="SIM" rendered="#{list.indAprovadoDiretor}" />
						<h:outputText value="NÃO" rendered="#{!list.indAprovadoDiretor}" />
					</rich:column>
				
				</rich:dataTable>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputText value="Justificativa: " />
				<h:inputTextarea disabled="#{solicitacaoController.desabilitaBotao}"
					value="#{solicitacaoController.solicitacaoAdicionalNoturnoDocente.justificativa}"
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