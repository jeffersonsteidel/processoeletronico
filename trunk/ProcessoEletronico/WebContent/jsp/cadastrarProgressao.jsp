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
			<font size="2"><b>CADASTRAR PROGRESS�O</b></font>

			<h:panelGrid columns="4">
				<h:outputText value="C�digo: " />
				<h:inputText requiredMessage="Campo C�digo � obrigat�rio!"
					disabled="#{!lotacaoController.indNovo}" required="true"
					value="#{progressaoController.progressao.codigo}" size="6"
					onkeypress="mascara(this, soNumeros);" maxlength="6"></h:inputText>

				<h:outputText value="Classe Atual: " />
				<h:inputText requiredMessage="Campo Classe Atual � obrigat�rio!"
					required="true"
					value="#{progressaoController.progressao.classeAtual}" size="60"
					maxlength="1"></h:inputText>

				<h:outputText value="Classe Nova: " />
				<h:selectOneMenu id="classeAtual" value="#{progressaoController.}"
					required="true" requiredMessage="Campo Classe Nova � obrigat�rio!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{lotacaoController.classeNova}" />
					<a4j:support event="onchange"
						action="#{lotacaoController.listarClassesNovas}" ajaxSingle="true"
						reRender="classeAtual"></a4j:support>
				</h:selectOneMenu>

				<h:outputText value="Data Progress�o: " />
				<rich:calendar
					value="#{progressaoController.funcaoServidor.dataProgressao}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					inputSize="12" required="true"
					requiredMessage="Campo Data Progress�o � obrigat�rio!" />

				<h:outputText value="Motivo: " />
				<h:selectOneMenu id="motivo"
					value="#{progressaoController.progressao.motivo}" required="true"
					requiredMessage="Campo Motivo � obrigat�rio!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{lotacaoController.motivo}" />
					<a4j:support event="onchange"
						action="#{lotacaoController.listarMotivo}" ajaxSingle="true"
						reRender="motivo"></a4j:support>
				</h:selectOneMenu>
				
				<h:outputText value="Nome do Servidor: " />
				<h:inputText requiredMessage="Campo Nome do Servidor � obrigat�rio!"
					required="true"
					value="#{progressaoController.progressao.}" size="60"
					maxlength="80"></h:inputText>

				<h:outputText value="Portaria: " />
				<h:inputText requiredMessage="Campo Portaria � obrigat�rio!"
					required="true"
					value="#{progressaoController.preogressao.portaria}"
					size="60" maxlength="3"></h:inputText>
				

				<h:outputText value="Padr�o Atual: " />
				<h:inputText requiredMessage="Campo Padr�o Atual � obrigat�rio!"
					required="true"
					value="#{progressaoController.preogressao.padraoAtual}"
					size="60" maxlength="3"></h:inputText>

				<h:outputText value="Padr�o Novo: " />
				<h:selectOneMenu id="padraoNovo"
					value="#{progressaoController.progressao.motivo}" required="true"
					requiredMessage="Campo Padr�o Novo � obrigat�rio!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{progressaoController.padraoNovo" }" />
					<a4j:support event="onchange"
						action="#{progressaoController.listarPadraoNovo}"
						ajaxSingle="true" reRender="padraoNovo""></a4j:support>
				</h:selectOneMenu>

			</h:panelGrid>
			<h:panelGrid columns="2">
				<a4j:commandButton value="Salvar"
					action="#{lotacaoController.salvar}" reRender="form" />
			</h:panelGrid>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>