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

			<font size="2"><b>ALTERAÇÃO DE CONTA BANCÁRIA</b></font>
			<h:panelGrid columns="1">
				<h:outputText
					value="Solicitante: #{solicitacaoController.solicitacaoContaBancaria.solicitante.siape} - #{solicitacaoController.solicitacaoContaBancaria.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="8">
				<h:outputText value="Banco Atual: ">
				</h:outputText>
				<h:outputText
					value="#{solicitacaoController.solicitacaoContaBancaria.solicitante.contaBancaria.banco.descricao}">
				</h:outputText>
				<h:outputText value="Conta Atual: ">
				</h:outputText>
				<h:outputText
					value="#{solicitacaoController.solicitacaoContaBancaria.solicitante.contaBancaria.numeroConta}">
				</h:outputText>
				<h:outputText value="Agência Atual: ">
				</h:outputText>
				<h:outputText
					value="#{solicitacaoController.solicitacaoContaBancaria.solicitante.contaBancaria.agencia}">
				</h:outputText>
				<h:outputText value="Tipo da Conta: ">
				</h:outputText>
				<h:outputText value="Poupança"
					rendered="#{solicitacaoController.solicitacaoContaBancaria.solicitante.contaBancaria.indPoupanca == true}">
				</h:outputText>
				<h:outputText value="Conta Corrente"
					rendered="#{solicitacaoController.solicitacaoContaBancaria.solicitante.contaBancaria.indPoupanca == false}">
				</h:outputText>

				<h:outputText value="Novo Banco: " />
				<h:outputText
					value="#{solicitacaoController.solicitacaoContaBancaria.novoBanco.descricao}">
				</h:outputText>
				<h:outputText value="Novo Número da Conta: " />
				<h:outputText
					value="#{solicitacaoController.solicitacaoContaBancaria.novoNumeroConta}">
				</h:outputText>
				<h:outputText value="Nova Agência: " />
				<h:outputText
					value="#{solicitacaoController.solicitacaoContaBancaria.novaAgencia}">
				</h:outputText>
				<h:outputText value="Tipo da Conta: " />
				<h:outputText value="Poupança"
					rendered="#{solicitacaoController.solicitacaoContaBancaria.novoIndPoupanca == true}">
				</h:outputText>
				<h:outputText value="Conta Corrente"
					rendered="#{solicitacaoController.solicitacaoContaBancaria.novoIndPoupanca == false}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Justificativa: " />
				<h:inputTextarea
					value="#{solicitacaoController.solicitacaoContaBancaria.justificativa}"
					cols="50" rows="5"></h:inputTextarea>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<a4j:commandButton value="Deferir" reRender="form" rendered="#{solicitacaoController.solicitacaoContaBancaria.statusSolicitacao.codigo==2}"
					oncomplete="#{rich:component('confirmPanel')}.show()"/>
				<a4j:commandButton value="Indeferir" reRender="form" rendered="#{solicitacaoController.solicitacaoContaBancaria.statusSolicitacao.codigo==2}"
					oncomplete="#{rich:component('confirmPanel02')}.show()"/>
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