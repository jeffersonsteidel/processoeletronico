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

			<font size="2"><b>AFASTAMENTO CÔNJUGE OU COMPANHEIRO</b></font>
			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoAfastamentoConjugeController.solicitacaoAfastamentoConjuge.solicitante.siape} - #{solicitacaoAfastamentoConjugeController.solicitacaoAfastamentoConjuge.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Tipo: " />
				<h:selectOneRadio id="radiosTipo"
					value="#{solicitacaoAfastamentoConjugeController.solicitacaoAfastamentoConjuge.tipo}">
					<f:selectItem itemValue="1" itemLabel="Concessão" />
					<f:selectItem itemValue="2" itemLabel="Prorrogação" />
				</h:selectOneRadio>

				<h:outputText value="A partir de: " />
				<rich:calendar
					value="#{solicitacaoAfastamentoConjugeController.solicitacaoAfastamentoConjuge.dataInicio}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					required="true" inputSize="12"
					requiredMessage="Campo A partir de é obrigatório!" />

				<h:outputText value="Local: " />
				<h:inputText
					value="#{solicitacaoAfastamentoConjugeController.solicitacaoAfastamentoConjuge.local}"
					size="50" required="true"
					requiredMessage="Campo Local é obrigatório!">
				</h:inputText>

				<h:outputText value="Remuneração: " />
				<h:selectOneRadio id="radiosRemuneracao"
					value="#{solicitacaoAfastamentoConjugeController.solicitacaoAfastamentoConjuge.remuneracao}">
					<f:selectItem itemValue="1" itemLabel="Sim" />
					<f:selectItem itemValue="2" itemLabel="Não" />
				</h:selectOneRadio>

				<h:outputText value="Unidade de Trabalho Receptora: " />
				<h:inputText
					value="#{solicitacaoAfastamentoConjugeController.solicitacaoAfastamentoConjuge.unidReceptora}"
					size="50" required="true"
					requiredMessage="Campo Unidade de Trabalho Receptora é obrigatório!">
				</h:inputText>

				<h:outputText value="Telefone: " />
				<h:inputText
					value="#{solicitacaoAfastamentoConjugeController.solicitacaoAfastamentoConjuge.telefone}"
					size="16" maxlength="13" required="true"
					requiredMessage="Campo Telefone é obrigatório!"
					onkeypress="mascara(this,telefone);"
					validatorMessage="Campo Telefone deve ter no mínimo 13 caracteres!">
					<f:validateLength minimum="13" />
				</h:inputText>
			</h:panelGrid>

			<a4j:commandButton value="Salvar"
				action="#{solicitacaoAfastamentoConjugeController.salvar}"
				reRender="form" />
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>