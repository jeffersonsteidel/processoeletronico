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

			<font size="2"><b>ADICIONAL NOTURNO - TÉCNICO</b></font>

			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.solicitante.siape} - #{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>
				<h:panelGrid columns="10">
					<h:outputText value="Campus: " />
					<h:selectOneMenu id="campus"
						value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.solicitacaoAdicionalNoturno.lotacao.codigo}"
						required="true" requiredMessage="Campo Campus é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems
							value="#{solicitacaoAdicionalNoturnoController.lotacoes}" />
						<a4j:support event="onchange"
							action="#{solicitacaoAdicionalNoturnoController.listarServidoresTecnicosCampus}"
							ajaxSingle="true" reRender="servidoresCampus"></a4j:support>
					</h:selectOneMenu>

					<h:outputText value="Servidor: " />
					<h:selectOneMenu id="servidoresCampus"
						value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.servidor.codigo}"
						required="true" requiredMessage="Campo Servidor é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems
							value="#{solicitacaoAdicionalNoturnoController.servidoresCampus}" />
					</h:selectOneMenu>


					<h:outputText value="Hora Inicial: " />
					<h:inputText
						value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.horaInicial}"
						size="10" maxlength="5" required="true"
						requiredMessage="Campo Hora Inicial é obrigatório!"
						onkeypress="mascara(this,horario);"
						validatorMessage="Campo Hora Inicial deve ter no mínimo 4 caracteres!">
						<f:validateLength minimum="4" />
					</h:inputText>

					<h:outputText value="Hora Final: " />
					<h:inputText
						value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.horaFinal}"
						size="10" maxlength="5" required="true"
						requiredMessage="Campo Hora Final é obrigatório!"
						onkeypress="mascara(this,horario);"
						validatorMessage="Campo Hora Final deve ter no mínimo 4 caracteres!">
						<f:validateLength minimum="4" />
					</h:inputText>

					<h:outputText value="Data: " />
					<rich:calendar
						value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.data}"
						locale="" popup="true" datePattern="dd/MM/yyyy"
						showApplyButton="#" cellWidth="12px" cellHeight="12px"
						style="width:80px" required="true" inputSize="12"
						requiredMessage="Campo Data é obrigatório!" />
				</h:panelGrid>

				<h:panelGrid columns="2">
					<h:outputText value="Motivo: " />
					<h:inputTextarea rows="5" cols="50"
						value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.motivo}"></h:inputTextarea>
				</h:panelGrid>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>