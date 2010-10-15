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
	<center><h:form id="form">
		<h:graphicImage value="../images/ifpr_logo.png" />
		<rich:panel header="INSTITUTO FEDERAL DO PARAN� - PROGEPE"
			style="width: 500px; position: absolute; left: 380px; top: 220px">
			<rich:messages layout="list" errorLabelClass="errorLabel"
				infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<h:panelGrid columns="2">
				<h:outputText value="SIAPE: " />
				<h:inputText
					value="#{autenticacaoController.autenticacao.siape}"
					size="25" maxlength="20" required="true"
					requiredMessage="Campo SIAPE obrigat�rio!"></h:inputText>
				<h:outputText value="Senha: " />
				<h:inputSecret value="#{autenticacaoController.autenticacao.senha}"
					size="25" maxlength="12" required="true"
					requiredMessage="Campo Senha obrigat�rio!"></h:inputSecret>
			</h:panelGrid>
			<a4j:commandButton value="Entrar" type="submit" reRender="form"
				action="#{autenticacaoController.login}" />
		</rich:panel>
	</h:form></center>
</f:view>
</body>
</html>