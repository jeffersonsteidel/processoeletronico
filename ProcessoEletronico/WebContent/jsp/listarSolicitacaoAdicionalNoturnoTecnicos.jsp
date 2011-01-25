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

	<center><rich:panel>
		<a4j:form id="form">
			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<font size="2"><b>LISTAR ADICIONAL NOTURNO - TÉCNICOS</b></font>

			<h:panelGrid
				rendered="#{solicitacaoAdicionalNoturnoController.indEmpty}">
				<center><h:outputText style="color:red"
					value="Nenhum adicional encontrado para este campus"></h:outputText>
				</center>
			</h:panelGrid>
			<h:panelGrid
				rendered="#{solicitacaoAdicionalNoturnoController.indVarias}">
				<center><h:outputText  style="font-weight:bold"
					value="Existe outro adicional encontrado para este campus"></h:outputText>
				</center>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText
					value="Diretor: #{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.servidor.siape} - #{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.servidor.nome}">
				</h:outputText>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputText
					rendered="#{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.solicitante != null}"
					value="Secretário: #{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.solicitante.siape} - #{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="7" id="campus"
				rendered="#{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.solicitante != null}">
				<h:outputText value="Campus: " />
				<h:selectOneMenu disabled="true"
					value="#{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.lotacao.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems
						value="#{solicitacaoAdicionalNoturnoController.lotacoes}" />
				</h:selectOneMenu>
			</h:panelGrid>



			<h:panelGrid columns="1">
				<rich:dataTable id="listaSolicitacoesAdicionalTecnicos"
					value="#{solicitacaoAdicionalNoturnoController.listaAdicionaisTecnicos}"
					var="list" width="1200px" columnClasses="center">

					<rich:column width="680px" sortBy="#{list.servidor.nome}">
						<f:facet name="header">
							<h:outputText value="Nome" />
						</f:facet>
						<h:outputText value="#{list.servidor.nome}" />
					</rich:column>

					<rich:column width="130px" sortBy="#{list.data}">
						<f:facet name="header">
							<h:outputText value="Data" />
						</f:facet>
						<h:outputText value="#{list.data}">
							<f:convertDateTime pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>

					<rich:column width="170px" sortBy="#{list.diaSemana}">
						<f:facet name="header">
							<h:outputText value="Dia da Semana" />
						</f:facet>
						<h:outputText value="#{list.diaSemana}">
						</h:outputText>
					</rich:column>

					<rich:column width="220px" sortBy="#{list.horaInicial}">
						<f:facet name="header">
							<h:outputText value="Horário" />
						</f:facet>
						<h:outputText value="#{list.horaInicial} - #{list.horaFinal}" />
					</rich:column>

					<rich:column width="940px" sortBy="#{list.motivo}">
						<f:facet name="header">
							<h:outputText value="Motivo" />
						</f:facet>
						<h:outputText value="#{list.motivo}" />
					</rich:column>

					<rich:column width="100px">
						<f:facet name="header">
							<h:outputText value="Aprovação" />
						</f:facet>
						<h:selectBooleanCheckbox value="#{list.indAprovadoDiretor}" />
					</rich:column>
				</rich:dataTable>
			</h:panelGrid>
			<h:panelGrid columns="1">
				<a4j:commandButton
					action="#{solicitacaoAdicionalNoturnoController.encaminharTecnicos}"
					id="encaminhar" reRender="form" value="Encaminhar Para Progepe"
					disabled="#{!solicitacaoAdicionalNoturnoController.indEncaminharTecnico}"></a4j:commandButton>
			</h:panelGrid>
		</a4j:form>
	</rich:panel></center>
</f:view>
</body>
</html>