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
					value="Solicitante: #{solicitacaoContaBancariaController.solicitacaoContaBancaria.solicitante.siape} - #{solicitacaoContaBancariaController.solicitacaoContaBancaria.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="8">
				<h:outputText value="Banco Atual: ">
				</h:outputText>
				<h:outputText
					value="#{solicitacaoContaBancariaController.solicitacaoContaBancaria.solicitante.contaBancaria.banco.descricao}">
				</h:outputText>
				<h:outputText value="Conta Atual: ">
				</h:outputText>
				<h:outputText
					value="#{solicitacaoContaBancariaController.solicitacaoContaBancaria.solicitante.contaBancaria.numeroConta}">
				</h:outputText>
				<h:outputText value="Agência Atual: ">
				</h:outputText>
				<h:outputText
					value="#{solicitacaoContaBancariaController.solicitacaoContaBancaria.solicitante.contaBancaria.agencia}">
				</h:outputText>
				<h:outputText value="Tipo da Conta: ">
				</h:outputText>
				<h:outputText value="Poupança"
					rendered="#{solicitacaoContaBancariaController.solicitacaoContaBancaria.solicitante.contaBancaria.indPoupanca == true}">
				</h:outputText>
				<h:outputText value="Conta Corrente"
					rendered="#{solicitacaoContaBancariaController.solicitacaoContaBancaria.solicitante.contaBancaria.indPoupanca == false}">
				</h:outputText>
				
				<h:outputText value="Novo Banco: " />
				<h:outputText
					value="#{solicitacaoContaBancariaController.solicitacaoContaBancaria.novoBanco.descricao}">
				</h:outputText>
				<h:outputText value="Novo Número da Conta: " />
				<h:outputText
					value="#{solicitacaoContaBancariaController.solicitacaoContaBancaria.novoNumeroConta}">
				</h:outputText>
				<h:outputText value="Nova Agência: " />
				<h:outputText
					value="#{solicitacaoContaBancariaController.solicitacaoContaBancaria.novaAgencia}">
				</h:outputText>
				<h:outputText value="Tipo da Conta: "/>
				<h:outputText value="Poupança"
					rendered="#{solicitacaoContaBancariaController.solicitacaoContaBancaria.novoIndPoupanca == true}">
				</h:outputText>
				<h:outputText value="Conta Corrente"
					rendered="#{solicitacaoContaBancariaController.solicitacaoContaBancaria.novoIndPoupanca == false}">
				</h:outputText>
				
			</h:panelGrid>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>