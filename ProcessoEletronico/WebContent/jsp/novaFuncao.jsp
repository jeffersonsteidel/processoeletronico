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
			<font size="2"><b>NOVA FUN��O</b></font>

			<h:panelGrid columns="4">
				<h:outputText value="Tipo Fun��o: " />
				<h:selectOneMenu id="tipoFuncao"
					value="#{funcaoController.funcao.tipoFuncao.codigo}"
					required="true" requiredMessage="Campo Tipo Fun��o � obrigat�rio!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{funcaoController.tipoFuncoes}" />
					<a4j:support event="onchange"
						action="#{funcaoController.listarFuncoes}"
						ajaxSingle="true" reRender="funcao,funcaoAnterior"></a4j:support>
				</h:selectOneMenu>

				<h:outputText value="Fun��o: " />
				<h:inputText id="funcao"
					value="#{funcaoController.funcao.descricao}" size="80"
					maxlength="80" required="true"
					requiredMessage="Campo Fun��o � obrigat�rio!">
				</h:inputText>

				<h:outputText value="Ato de Cria��o: " />
				<h:inputText id="atoCriacao" disabled="#{funcaoController.desabilitarCampos}"
					value="#{funcaoController.funcao.atoCriacao}" size="40"
					maxlength="100" required="true"
					requiredMessage="Campo Ato de Cria��o � obrigat�rio!">
				<rich:toolTip for="atoCriacao" value="Ex: Portaria 136/MEC/DOU 09/02/2009" />
				</h:inputText>
			
				<h:outputText value="Fun��o Anterior: " />
				<h:selectOneMenu  id="funcaoAnterior"
					value="#{funcaoController.funcao.funcaoAnterior.codigo}"
					required="false" >
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{funcaoController.funcoes}" />
					<a4j:support event="onchange"
						action="#{funcaoController.carregarAnterior}"
						ajaxSingle="true" reRender="atoCriacao,dataEdicao"></a4j:support>
				</h:selectOneMenu>
				<h:outputText value="Data de Extin��o da Fun��o Anterior: " />
					<rich:calendar id="dataEdicao" disabled="#{!funcaoController.desabilitarCampos}"
						value="#{funcaoController.funcao.funcaoAnterior.dataExtincao}"
						required="true" requiredMessage="Campo Data de Extin��o da Fun��o Anterior � obrigat�rio!"
						locale="" popup="true" datePattern="dd/MM/yyyy"
						showApplyButton="#" cellWidth="12px" cellHeight="12px"
						style="width:80px" inputSize="12" />
			</h:panelGrid>
			
			<h:outputText rendered="#{funcaoController.funcao.dataExtincao != null}" value="Fun��o Extinta em:" >
			</h:outputText>
			<h:outputText value="#{funcaoController.funcao.dataExtincao}">
				<f:convertDateTime pattern="dd/MM/yyyy" />
			</h:outputText>
				
			<h:panelGrid columns="1">
				<a4j:commandButton value="Salvar"
					action="#{funcaoController.salvarNovaFuncao}" reRender="form"/>
			</h:panelGrid>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>