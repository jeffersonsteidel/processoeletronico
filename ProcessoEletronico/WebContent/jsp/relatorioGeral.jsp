<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instituto Federal do Paraná</title>
</head>
<body>
<f:view>
	<jsp:directive.include file="menus.jsp" />
	<center><a4j:form id="form">
		<rich:panel>
			<font size="2"><b>GERAR RELATÓRIO</b></font>

			<h:panelGrid columns="4">
				<center><h:outputText value="SIAPE: " /> <h:inputText
					value="#{relatorioController.servidor.siape}" size="10" maxlength="7"
					required="true" onkeypress="mascara(this, soNumeros);"
					requiredMessage="Campo Siape é obrigatório!">
				</h:inputText></center>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:commandButton value="Gerar Relatório"
				 action="#{relatorioController.gerarRelatorioServidorGeral}"/>
			</h:panelGrid>

		</rich:panel>
	</a4j:form></center>
</f:view>
</body>
</html>