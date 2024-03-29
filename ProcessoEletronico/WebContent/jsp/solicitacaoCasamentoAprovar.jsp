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
			<font size="2"><b>LICEN�A DE CASAMENTO</b></font>
			<h:panelGrid columns="1">
				<h:outputText
					value="Solicitante: #{solicitacaoController.solicitacaoCasamento.solicitante.siape} - #{solicitacaoController.solicitacaoCasamento.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Nome do C�njuge: " />
				<h:outputText styleClass="maiusculo"
					value="#{solicitacaoController.solicitacaoCasamento.nomeConjuge}">
				</h:outputText>

				<h:outputText value="N�mero da Certid�o de Casamento: " />
				<h:outputText
					value="#{solicitacaoController.solicitacaoCasamento.numeroCertidao}">
				</h:outputText>

				<h:outputText value="Data do Casamento: "></h:outputText>
				<h:outputText
					value="#{solicitacaoController.solicitacaoCasamento.dataCasamento}">
					<f:convertDateTime locale="pt_BR" pattern="dd/MM/yyyy" />
				</h:outputText>

				<h:outputText value="Data de Retorno ao Trabalho: "></h:outputText>
				<h:outputText
					value="#{solicitacaoController.solicitacaoCasamento.dataRetorno}">
					<f:convertDateTime locale="pt_BR" pattern="dd/MM/yyyy" />
				</h:outputText>

			</h:panelGrid>
<%--
			<a4j:region>
				<a4j:commandLink action="#{conjugeController.abrirConjugeSolicitante}" value="Verificar Dados do C�njuge">
				</a4j:commandLink>
			</a4j:region>
 --%>
			<h:panelGroup id="info">
				<rich:panel bodyClass="info">
					<rich:dataGrid columns="1"
						value="#{solicitacaoController.solicitacaoCasamento.certidaoCasamento}"
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
					value="#{solicitacaoController.solicitacaoCasamento.justificativa}"
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
								value="N�o"
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
								value="N�o"
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