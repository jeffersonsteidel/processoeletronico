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

			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoAlteracaoFeriasController.solicitacaoAlteracaoFerias.solicitante.siape} - #{solicitacaoAlteracaoFeriasController.solicitacaoAlteracaoFerias.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>
			
			<h:panelGrid columns="4">
				<h:outputText value="De: " ></h:outputText>
				<rich:calendar
						value="#{solicitacaoAlteracaoFeriasController.solicitacaoAlteracaoFerias.dataInicio}" locale=""
						popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
						cellWidth="12px" cellHeight="12px" style="width:80px"
						required="true" inputSize="12"
						requiredMessage="Campo De (Inicio das férias) é obrigatório!" />				
				
				<h:outputText value=" a " ></h:outputText>
				<rich:calendar
						value="#{solicitacaoAlteracaoFeriasController.solicitacaoAlteracaoFerias.dataFinal}" locale=""
						popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
						cellWidth="12px" cellHeight="12px" style="width:80px"
						required="true" inputSize="12"
						requiredMessage="Campo De (Final das férias) é obrigatório!" />
				
				<h:outputText value="Para: " ></h:outputText>
				<rich:calendar
						value="#{solicitacaoAlteracaoFeriasController.solicitacaoAlteracaoFerias.novaDataInicio}" locale=""
						popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
						cellWidth="12px" cellHeight="12px" style="width:80px"
						required="true" inputSize="12"
						requiredMessage="Campo Para (Inicio das férias) é obrigatório!" />
				
				<h:outputText value=" a " ></h:outputText>
				<rich:calendar
						value="#{solicitacaoAlteracaoFeriasController.solicitacaoAlteracaoFerias.novaDataFinal}" locale=""
						popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
						cellWidth="12px" cellHeight="12px" style="width:80px"
						required="true" inputSize="12"
						requiredMessage="Campo Para (Final das férias) é obrigatório!" />
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Motivo:" ></h:outputText>
				<h:inputTextarea  cols="50" rows="5"  value = "#{solicitacaoAlteracaoFeriasController.solicitacaoAlteracaoFerias.motivo}"
				required="true" requiredMessage="Campo Motivo é obrigatório!"
				></h:inputTextarea>
			</h:panelGrid>
			
		
			<a4j:commandButton value="Salvar"
				action="#{solicitacaoAlteracaoFeriasController.salvar}" reRender="form"/>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>