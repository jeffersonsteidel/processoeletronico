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
			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoAlimentacaoController.solicitacaoAlimentacao.solicitante.siape} - #{solicitacaoAlimentacaoController.solicitacaoAlimentacao.solicitante.nome}">
				</h:outputText>
				<h:outputText
					value="#{solicitacaoAlimentacaoController.solicitacaoAlimentacao.solicitante.regimeTrabalho.descricao}">
				</h:outputText>
			</h:panelGrid>
			
			
			
			<h:panelGrid columns="2">
				<h:outputText value="Incluir Aux�lio"></h:outputText>
			</h:panelGrid>

		
			<a4j:commandButton value="Salvar"
				action="#{solicitacaoAlimentacaoController.salvar}" />
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>