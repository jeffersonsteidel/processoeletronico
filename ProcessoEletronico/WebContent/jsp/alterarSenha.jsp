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
	<a4j:loadScript src="../js/script.js" />
	<a4j:form id="form">
		<a4j:status>
			<f:facet name="start">
				<h:graphicImage value="../images/ajax-loader.gif" />
			</f:facet>
		</a4j:status>
		<center><rich:panel header="Alterar Senha"
			style="width: 450px; top: auto;">
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


				<h:outputText value="Senha Atual: ">
				</h:outputText>
				<h:inputSecret required="true"
					requiredMessage="Campo 'Senha Atual' é obrigatório!"
					value="#{autenticacaoController.autenticacao.senha}" size="12"
					maxlength="6">
				</h:inputSecret>

				<h:outputText value="Nova Senha: ">
				</h:outputText>
				<h:inputSecret required="true"
					requiredMessage="Campo 'Nova Senha' é obrigatório!"
					value="#{autenticacaoController.novaSenha }" size="12"
					maxlength="6">
				</h:inputSecret>

				<h:outputText value="Confirmação Nova Senha: ">
				</h:outputText>
				<h:inputSecret required="true"
					requiredMessage="Campo 'Confirmação Nova Senha' é obrigatório!"
					value="#{autenticacaoController.confirmarSenha}" size="12"
					maxlength="6">
				</h:inputSecret>


			</h:panelGrid>

			<a4j:commandButton value="Enviar"
				action="#{autenticacaoController.verificarSenha}" />
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>