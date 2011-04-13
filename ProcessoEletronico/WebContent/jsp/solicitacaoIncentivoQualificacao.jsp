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

			<font size="2"><b>SOLICITAÇÃO INCENTIVO A QUALIFICAÇÃO</b></font>
			<h:panelGrid columns="2">
				<h:outputText
					value="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.servidor.siape} - #{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.servidor.nome}">
				</h:outputText>
			</h:panelGrid>

			<rich:dataTable id="listaTitulacoes"
				value="#{solicitacaoIncentivoQualificacaoController.listaTitulacoes}"
				var="list" width="1150px" columnClasses="center" rows="15"
				reRender="ds">
				<rich:column width="50px">
					<f:facet name="header">
					</f:facet>
					<h:selectOneRadio id="radios"
						value="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.codigo}">
					<f:selectItem itemValue="#{list.codigo}"  />
				</h:selectOneRadio>
				</rich:column>

				<rich:column width="50px">
					<f:facet name="header">
						<h:outputText value="Siape" />
					</f:facet>
					<h:outputText value="#{list.servidor.siape}" />
				</rich:column>

				<rich:column width="420px">
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{list.servidor.nome}" />
				</rich:column>

				<rich:column width="280px" sortBy="#{list.titulacao.descricao}">
					<f:facet name="header">
						<h:outputText value="Titulação" />
					</f:facet>
					<h:outputText value="#{list.titulacao.descricao}" />
				</rich:column>

				<rich:column width="280px"
					sortBy="#{list.areaConhecimento.descricao}">
					<f:facet name="header">
						<h:outputText value="Area de Conhecimento" />
					</f:facet>
					<h:outputText value="#{list.areaConhecimento.descricao}" />
				</rich:column>

				<f:facet name="footer">
					<rich:datascroller id="ds"></rich:datascroller>
				</f:facet>
			</rich:dataTable>

			<a4j:commandButton value="Salvar"
				action="#{solicitacaoIncentivoQualificacaoController.salvar}"
				reRender="form" />
		</rich:panel></center>
	</a4j:form>

</f:view>
</body>
</html>