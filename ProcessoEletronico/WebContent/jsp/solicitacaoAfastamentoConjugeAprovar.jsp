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

			<font size="2"><b>AFASTAMENTO CÔNJUGE OU COMPANHEIRO</b></font>
			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoController.solicitacaoAfastamentoConjuge.solicitante.siape} - #{solicitacaoController.solicitacaoAfastamentoConjuge.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Tipo: " />
				<h:selectOneRadio id="radiosTipo" disabled="true"
					value="#{solicitacaoController.solicitacaoAfastamentoConjuge.tipo}">
					<f:selectItem itemValue="1" itemLabel="Concessão" />
					<f:selectItem itemValue="2" itemLabel="Prorrogação" />
				</h:selectOneRadio>

				<h:outputText value="A partir de: " />
				<rich:calendar disabled="true"
					value="#{solicitacaoController.solicitacaoAfastamentoConjuge.dataInicio}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					required="true" inputSize="12"
					requiredMessage="Campo A partir de é obrigatório!" />

				<h:outputText value="Local: " />
				<h:outputText
					value="#{solicitacaoController.solicitacaoAfastamentoConjuge.local}">
				</h:outputText>

				<h:outputText value="Remuneração: " />
				<h:selectOneRadio id="radiosRemuneracao" disabled="true"
					value="#{solicitacaoController.solicitacaoAfastamentoConjuge.remuneracao}">
					<f:selectItem itemValue="1" itemLabel="Sim" />
					<f:selectItem itemValue="2" itemLabel="Não" />
				</h:selectOneRadio>

				<h:outputText value="Unidade de Trabalho Receptora: " />
				<h:outputText
					value="#{solicitacaoController.solicitacaoAfastamentoConjuge.unidReceptora}">
				</h:outputText>

				<h:outputText value="Telefone: " />
				<h:outputText
					value="#{solicitacaoController.solicitacaoAfastamentoConjuge.telefone}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Justificativa: " />
				<h:inputTextarea
					value="#{solicitacaoController.solicitacaoAfastamentoConjuge.justificativa}"
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