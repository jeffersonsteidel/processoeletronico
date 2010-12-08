<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instituto Federal do Paraná</title>
</head>
<body>
<f:view>
	<jsp:directive.include file="menus.jsp" />
	<center><a4j:form id="form">
		<rich:panel>
			<rich:messages layout="list">
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<font size="2"><b>SOLICITAÇÕES DE ADICIONAL NOTURNO - DOCENTE</b></font>
			<h:panelGrid columns="2">
				<h:outputText
					value="#{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.servidor.siape} - #{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.servidor.nome}">
				</h:outputText>
			</h:panelGrid>


			<h:panelGrid columns="7" id="campus">
				<h:outputText value="Campus: " />
				<h:selectOneMenu
					value="#{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.lotacao.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems
						value="#{solicitacaoAdicionalNoturnoController.lotacoes}" />
					<a4j:support event="onchange"
							action="#{solicitacaoAdicionalNoturnoController.listarProfessoresCampus}"
							ajaxSingle="true" reRender="curso"></a4j:support>
				</h:selectOneMenu>
				
				<h:outputText value="Curso: " />
				<h:inputText id="curso"
						disabled="#{solicitacaoAdicionalNoturnoController.indTurmaDefinida}"
						value="#{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.curso}"
						required="true" requiredMessage="Campo Curso é obrigatório!">
					</h:inputText>
				
				<h:outputText  value="Turma: "/>
				<h:inputText
						value="#{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.turma}"/>

				<a4j:commandButton value="Pesquisar" action="#"
					reRender="listaSolicitacoesAdicionalDocentes" />
			</h:panelGrid>

			<h:panelGrid columns="1">

				<rich:dataTable id="listaSolicitacoesAdicionalDocentes"
					value="#{solicitacaoAdicionaltNoturnoController.listaSolicitacoesAdicionalDocentes}"
					var="list" width="1160px" columnClasses="center" rows="15"
					reRender="ds">

					<rich:column width="435px" sortBy="#{list.nome}">
						<f:facet name="header">
							<h:outputText value="Nome" />
						</f:facet>
						<h:outputText value="#{list.servidor.nome}" />
					</rich:column>

					<rich:column width="435px">
						<f:facet name="header">
							<h:outputText value="Data" />
						</f:facet>
						<h:outputText value="#{list.data}">
							<f:convertDateTime pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>

					<rich:column width="435px">
						<f:facet name="header">
							<h:outputText value="Dia da Semana" />
						</f:facet>
						<h:outputText value="#{list.diaSemana}">
						</h:outputText>
					</rich:column>

					<rich:column width="435px">
						<f:facet name="header">
							<h:outputText value="Horário" />
						</f:facet>
						<h:outputText value="#{list.horaInicial} - #{list.horaFinal}" />
					</rich:column>

					<rich:column width="435px">
						<f:facet name="header">
							<h:outputText value="Matéria" />
						</f:facet>
						<h:outputText value="#{list.materia}" />
					</rich:column>

					<rich:column width="435px">
						<f:facet name="header">
							<h:outputText value="Aprovação" />
						</f:facet>
						<h:outputText value="#" />
					</rich:column>
					<f:facet name="footer">
						<rich:datascroller id="ds"></rich:datascroller>
					</f:facet>
				</rich:dataTable>
			</h:panelGrid>
		</rich:panel>
	</a4j:form></center>
</f:view>
</body>
</html>