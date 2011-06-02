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
			<font size="2"><b>RELATÓRIO FUNÇÕES</b></font>

			<h:panelGrid columns="8">

				<h:outputText value="Tipo Função: " />
				<h:selectOneMenu value="#{relatorioController.tipoFuncao}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{relatorioController.tipoFuncoes}" />
				</h:selectOneMenu>
		
		
				<h:outputText value="SIAPE: " />
				<h:inputText value="#{relatorioController.servidor.siape}" size="10"
					maxlength="7" required="true"
					onkeypress="mascara(this, soNumeros);"
					requiredMessage="Campo Siape é obrigatório!">
				</h:inputText>

				<h:outputText value="Local Exercicio: " />
				<h:selectOneMenu value="#{relatorioController.lotacao}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{relatorioController.locaisExercicio}" />
				</h:selectOneMenu>

				<h:outputText value="Situação do Servidor: " />
				<h:selectOneMenu value="#{relatorioController.situacao}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="ATIVOS" itemValue="1" />
					<f:selectItem itemLabel="INATIVOS" itemValue="2" />
				</h:selectOneMenu>


			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:commandButton value="Gerar Relatório"
					action="#{relatorioController.gerarRelatorioServidorFuncoesByFiltro}" />
			</h:panelGrid>

		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>