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
			<font size="2"><b>CADASTRAR REMO��O</b></font>


			<h:panelGrid columns="4">
				<h:outputText value="Siape do Servidor: ">
				</h:outputText>
				<h:inputText id="siape"
					value="#{remocaoController.remocao.servidor.siape}" size="10"
					maxlength="7" required="true"
					onkeypress="mascara(this, soNumeros);"
					requiredMessage="Campo Siape do Servidor � obrigat�rio!">
					<a4j:support event="onchange"
						action="#{remocaoController.buscarServidor}" ajaxSingle="true"
						reRender="servidor,siape"></a4j:support>
				</h:inputText>

				<h:outputText value="Nome do Servidor: ">
				</h:outputText>
				<h:outputText id="servidor"
					value="#{remocaoController.remocao.servidor.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="6">
				<h:outputText value="Lota��o: " />
				<h:selectOneMenu value="#{remocaoController.remocao.lotacao.codigo}"
					required="true"
					requiredMessage="Campo Classe do Cargo � obrigat�rio!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{remocaoController.lotacoes}" />
				</h:selectOneMenu>

				<h:outputText value="Data Entrada: " />
				<rich:calendar value="#{remocaoController.remocao.dataEntrada}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					inputSize="12" required="true"
					requiredMessage="Campo Data Entrada � obrigat�rio!" />

				<h:outputText value="Data Sa�da: " />
				<rich:calendar value="#{remocaoController.remocao.dataSaida}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					inputSize="12" />
			</h:panelGrid>
			<h:panelGrid columns="2">
				<a4j:commandButton value="Salvar"
					action="#{remocaoController.salvar}"
					reRender="form" />

			</h:panelGrid>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>