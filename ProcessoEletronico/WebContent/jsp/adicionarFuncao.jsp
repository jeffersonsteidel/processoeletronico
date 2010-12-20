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
			<font size="2"><b>ADICIONAR FUN��O</b></font>
			<h:panelGrid columns="1">
				<h:outputText id="siapeNome"
					value="#{funcaoServidorController.funcaoServidor.servidor.siape} - #{funcaoServidorController.funcaoServidor.servidor.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="4">

				<h:outputText value="Tipo Fun��o: " />
				<h:selectOneMenu id="tipoFuncao"
					value="#{funcaoServidorController.funcaoServidor.funcao.tipoFuncao.codigo}"
					required="true" requiredMessage="Campo Tipo Fun��o � obrigat�rio!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{funcaoServidorController.tiposFuncoes}" />
					<a4j:support event="onchange"
						action="#{funcaoServidorController.listarFuncoes}"
						ajaxSingle="true" reRender="funcao"></a4j:support>
				</h:selectOneMenu>

				<h:outputText value="Fun��o: " />
				<h:selectOneMenu id="funcao"
					value="#{funcaoServidorController.funcaoServidor.funcao.codigo}"
					required="true" requiredMessage="Campo Fun��o � obrigat�rio!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{funcaoServidorController.funcoes}" />
				</h:selectOneMenu>

				<h:outputText value="Siape do Servidor: ">
				</h:outputText>
				<h:inputText
					value="#{funcaoServidorController.funcaoServidor.servidor.siape}"
					size="15" maxlength="7" required="true"
					requiredMessage="Campo Siape do Servidor � obrigat�rio!">
					<a4j:support event="onchange"
						action="#{funcaoServidorController.buscarServidor}"
						ajaxSingle="true" reRender="servidor"></a4j:support>
				</h:inputText>

				<h:outputText value="Nome do Servidor: ">
				</h:outputText>
				<h:outputText id="servidor"
					value="#{funcaoServidorController.funcaoServidor.servidor.nome}">
				</h:outputText>

			</h:panelGrid>

			<h:panelGrid columns="6">

				<h:outputText value="Local Exerc�cio: " />
				<h:selectOneMenu
					value="#{funcaoServidorController.funcaoServidor.localExercicio.codigo}"
					required="true"
					requiredMessage="Campo Local Exerc�cio � obrigat�rio!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{funcaoServidorController.locaisExercicio}" />
				</h:selectOneMenu>

				<h:outputText value="Data entrada: " />
				<rich:calendar value="#{conjugeController.dataEntrada}" locale=""
					popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					inputSize="12" required="true"
					requiredMessage="Campo Data entrada � obrigat�rio!" />

				<h:outputText value="Data Sa�da: " />
				<rich:calendar value="#{conjugeController.dataSaida}" locale=""
					popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					inputSize="12" required="true"
					requiredMessage="Campo Data Sa�da � obrigat�rio!" />

			</h:panelGrid>

			<a4j:region>
				<h:panelGrid columns="4">

				</h:panelGrid>
				<h:panelGrid columns="2">
					<a4j:commandButton value="Adicionar"
						action="#{funcaoServidorController.salvarFuncaoServidor}"
						reRender="listaTitulacoes, form" />
				</h:panelGrid>

			</a4j:region>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>