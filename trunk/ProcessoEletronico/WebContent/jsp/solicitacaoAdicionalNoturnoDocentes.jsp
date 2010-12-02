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

			<font size="2"><b>ADICIONAL NOTURNO - DOCENTES</b></font>

			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.solicitante.siape} - #{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>
			<a4j:region>
				<h:panelGrid columns="6">

					<h:outputText value="Campus: " />
					<h:selectOneMenu id="campus"
						value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.solicitacaoAdicionalNoturno.lotacao.codigo}"
						required="true" requiredMessage="Campo Campus é obrigatório!"
						disabled="#{solicitacaoAdicionalNoturnoController.indTurmaDefinida}">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems
							value="#{solicitacaoAdicionalNoturnoController.lotacoes}" />
						<a4j:support event="onchange"
							action="#{solicitacaoAdicionalNoturnoController.carregarCursosProfessoresPorLotacao}"
							ajaxSingle="true" reRender="curso,professor, form"></a4j:support>
					</h:selectOneMenu>
					<h:outputText value="Curso: " />
					<h:selectOneMenu id="curso"
						disabled="#{solicitacaoAdicionalNoturnoController.indTurmaDefinida}"
						value="#{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.curso.codigo}"
						required="true" requiredMessage="Campo Curso é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems
							value="#{solicitacaoAdicionalNoturnoController.cursos}" />
						<a4j:support event="onchange"
							action="#{solicitacaoAdicionalNoturnoController.confirmarTurma}"
							ajaxSingle="true" reRender="form" />
					</h:selectOneMenu>

					<h:outputText value="Turma: " />
					<h:inputText
						value="#{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.turma}"
						required="true" requiredMessage="Campo Turma é obrigatório!"
						disabled="#{solicitacaoAdicionalNoturnoController.indTurmaDefinida}">
						<a4j:support event="onchange"
							action="#{solicitacaoAdicionalNoturnoController.confirmarTurma}"
							ajaxSingle="true" reRender="form" />
					</h:inputText>
				</h:panelGrid>

				<h:panelGrid columns="10">
					<h:outputText value="Matéria: " />
					<h:inputText
						value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.materia}"
						required="true" requiredMessage="Campo Matéria é obrigatório!"
						disabled="#{!solicitacaoAdicionalNoturnoController.indTurmaDefinida}" />

					<h:outputText value="Servidor: " />
					<h:selectOneMenu id="professor"
						value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.servidor.codigo}"
						required="true" requiredMessage="Campo Servidor é obrigatório!"
						disabled="#{!solicitacaoAdicionalNoturnoController.indTurmaDefinida}">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems
							value="#{solicitacaoAdicionalNoturnoController.professoresCampus}" />
					</h:selectOneMenu>

					<h:outputText value="Data: " />
					<rich:calendar
						value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.data}"
						locale="" popup="true" datePattern="dd/MM/yyyy"
						showApplyButton="#" cellWidth="12px" cellHeight="12px"
						style="width:80px" required="true" inputSize="12"
						requiredMessage="Campo Data é obrigatório!"
						disabled="#{!solicitacaoAdicionalNoturnoController.indTurmaDefinida}" />

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
				</h:panelGrid>
				<a4j:commandButton value="Adicionar"
					action="#{solicitacaoAdicionalNoturnoController.adicionarAdicional}"
					reRender="listaAdicionais, form" />

				<rich:dataTable id="listaAdicionais"
					value="#{solicitacaoAdicionalNoturnoController.listaAdicionalNoturno}"
					var="list" width="1160px" columnClasses="center" rows="15"
					reRender="ds">

					<rich:column width="435px">
						<f:facet name="header">
							<h:outputText value="Servidor" />
						</f:facet>
						<h:outputText value="#{list.servidor.nome}" />
					</rich:column>

					<rich:column width="435px">
						<f:facet name="header">
							<h:outputText value="Matéria:" />
						</f:facet>
						<h:outputText value="#{list.materia}" />
					</rich:column>


					<rich:column width="435px">
						<f:facet name="header">
							<h:outputText value="Horário" />
						</f:facet>
						<h:outputText value="#{list.horaInicial} - #{list.horaFinal}" />
					</rich:column>

					<rich:column width="435px">
						<f:facet name="header">
							<h:outputText value="Data" />
						</f:facet>
						<h:outputText value="#{list.data}">
							<f:convertDateTime pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>

					<rich:column>
						<f:facet name="header">
							<h:outputText value="Excluir" />
						</f:facet>
						<a4j:commandLink ajaxSingle="true" id="delete" reRender="form"
							oncomplete="#{rich:component('deletePanel')}.show()">
							<h:graphicImage id="excluir" value="../images/delete.gif"
								style="border:0" />
						</a4j:commandLink>
						<rich:toolTip for="excluir" value="Excluir" />
					</rich:column>

					<f:facet name="footer">
						<rich:datascroller id="ds"></rich:datascroller>
					</f:facet>
				</rich:dataTable>

				<a4j:commandButton value="Salvar"
					action="#{solicitacaoAdicionalNoturnoController.salvarAdicional}"
					reRender="form" />


			</a4j:region>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>