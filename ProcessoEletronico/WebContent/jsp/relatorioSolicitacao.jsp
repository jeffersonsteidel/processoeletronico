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
			<font size="2"><b>RELATÓRIO SOLICITAÇÃO</b></font>

			<h:panelGrid columns="4">

				<h:outputText value="Data Perido Inicio: " />
				<rich:calendar
					value="#{relatorioController.periodoInicio}" locale="" popup="true"
					datePattern="dd/MM/yyyy" showApplyButton="#" cellWidth="12px"
					cellHeight="12px" style="width:80px" inputSize="12" />

				<h:outputText value="Data Perido Fim: " />
				<rich:calendar
					value="#{relatorioController.periodoFinal}" locale="" popup="true"
					datePattern="dd/MM/yyyy" showApplyButton="#" cellWidth="12px"
					cellHeight="12px" style="width:80px" inputSize="12" />
			</h:panelGrid>

			<h:panelGrid columns="4">
				<h:outputText value="Siape do Atendente: ">
				</h:outputText>
				<h:inputText id="siapeAtendente"
					value="#{relatorioController.atendente.siape}" size="10"
					maxlength="7" onkeypress="mascara(this, soNumeros);">
					<a4j:support event="onchange"
						action="#{relatorioController.buscarServidorAtendente}"
						ajaxSingle="true" reRender="servidorAtendente,siapeAtendente"></a4j:support>
				</h:inputText>

				<h:outputText value="Nome do Atendente: ">
				</h:outputText>
				<h:outputText id="servidorAtendente"
					value="#{relatorioController.atendente.nome}">
				</h:outputText>

				<h:outputText value="Siape do Solicitante: ">
				</h:outputText>
				<h:inputText id="siapeSolicitante"
					value="#{relatorioController.solicitante.siape}" size="10"
					maxlength="7" onkeypress="mascara(this, soNumeros);">
					<a4j:support event="onchange"
						action="#{relatorioController.buscarServidorSolicitante}"
						ajaxSingle="true" reRender="servidorSolicitante,siapeSolicitante"></a4j:support>
				</h:inputText>

				<h:outputText value="Nome do Solicitante: ">
				</h:outputText>
				<h:outputText id="servidorSolicitante"
					value="#{relatorioController.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:outputText value="Tipo Solicitação: " />
			<h:selectOneMenu value="#{relatorioController.solicitacao}">
				<f:selectItem itemLabel="SELECIONE" itemValue="" />
				<f:selectItems value="#{relatorioController.tipoSolicitacoes}" />
			</h:selectOneMenu>

			<h:outputText value="Status Solicitação: " />
			<h:selectOneMenu value="#{relatorioController.status}">
				<f:selectItem itemLabel="TODOS" itemValue="0" />
				<f:selectItem itemLabel="ENCAMINHADO" itemValue="1" />
				<f:selectItem itemLabel="EM ANÁLISE" itemValue="2" />
				<f:selectItem itemLabel="DEFERIDO" itemValue="3" />
				<f:selectItem itemLabel="INDEFERIDO" itemValue="4" />
			</h:selectOneMenu>

			<h:panelGrid columns="2">
				<h:commandButton value="Gerar Relatório"
					action="#{relatorioController.gerarRelatorioServidorSolicitacaoByFiltro}" />
			</h:panelGrid>


		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>