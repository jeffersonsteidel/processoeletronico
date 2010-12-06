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

			<font size="2"><b>ADICIONAL NOTURNO - DOCENTES</b></font>

			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.solicitante.siape} - #{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>
			<a4j:region>
				<h:panelGrid columns="7">

					<h:outputText value="Campus: " />
					<h:selectOneMenu id="campus"
						value="#{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.lotacao.codigo}"
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
						required="true" requiredMessage="Campo Curso � obrigat�rio!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems
							value="#{solicitacaoAdicionalNoturnoController.cursos}" />
					</h:selectOneMenu>

					<h:outputText value="Turma: " />
					<h:inputText
						value="#{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.turma}"
						required="true" requiredMessage="Campo Turma � obrigat�rio!"
						disabled="#{solicitacaoAdicionalNoturnoController.indTurmaDefinida}">

					</h:inputText>
					<a4j:commandButton value="OK"
						action="#{solicitacaoAdicionalNoturnoController.confirmarTurma}"
						disabled="#{solicitacaoAdicionalNoturnoController.indTurmaDefinida}"
						reRender="form" />
				</h:panelGrid>

				<h:panelGrid columns="10">
					<h:outputText value="Mat�ria: " />
					<h:inputText
						value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.materia}"
						disabled="#{!solicitacaoAdicionalNoturnoController.indTurmaDefinida}" />

					<h:outputText value="Servidor: " />
					<h:selectOneMenu id="professor"
						value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.servidor.codigo}"
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
						style="width:80px" inputSize="12"
						disabled="#{!solicitacaoAdicionalNoturnoController.indTurmaDefinida}" />

					<h:outputText value="Hora Inicial: " />
					<h:inputText
						value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.horaInicial}"
						size="10" maxlength="5" onkeypress="mascara(this,horario);"
						disabled="#{!solicitacaoAdicionalNoturnoController.indTurmaDefinida}"
						validatorMessage="Campo Hora Inicial deve ter no m�nimo 4 caracteres!">
						<f:validateLength minimum="4" />
					</h:inputText>

					<h:outputText value="Hora Final: " />
					<h:inputText
						value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.horaFinal}"
						size="10" maxlength="5" onkeypress="mascara(this,horario);"
						disabled="#{!solicitacaoAdicionalNoturnoController.indTurmaDefinida}"
						validatorMessage="Campo Hora Final deve ter no m�nimo 4 caracteres!">
						<f:validateLength minimum="4" />
					</h:inputText>
				</h:panelGrid>
				<a4j:commandButton value="Adicionar"
					action="#{solicitacaoAdicionalNoturnoController.adicionarDocente}"
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
							<h:outputText value="Mat�ria:" />
						</f:facet>
						<h:outputText value="#{list.materia}" />
					</rich:column>


					<rich:column width="435px">
						<f:facet name="header">
							<h:outputText value="Hor�rio" />
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
						<a4j:commandLink ajaxSingle="true" id="delete"
							reRender="form, listaAdicionais"
							oncomplete="#{rich:component('deletePanel')}.show()">
							<h:graphicImage id="excluir" value="../images/delete.gif"
								style="border:0" />
							<f:setPropertyActionListener value="#{list}"
								target="#{solicitacaoAdicionalNoturnoController.adicionalNoturno}" />
						</a4j:commandLink>
						<rich:toolTip for="excluir" value="Excluir" />
					</rich:column>

					<f:facet name="footer">
						<rich:datascroller id="ds"></rich:datascroller>
					</f:facet>
				</rich:dataTable>

				<a4j:commandButton value="Salvar"
					action="#{solicitacaoAdicionalNoturnoController.salvarDocentes}"
					reRender="form" />

			</a4j:region>
		</a4j:form>


	</rich:panel></center>

	<center><rich:modalPanel id="deletePanel" autosized="true"
		width="200">
		<f:facet name="header">
			<h:outputText value="Deseja realmente deletar este item?"
				style="padding-right:15px;" />
		</f:facet>
		<h:form>
			<table width="100%">
				<tbody>
					<tr>
						<td align="center" width="50%"><a4j:commandButton value="Sim"
							ajaxSingle="true"
							action="#{solicitacaoAdicionalNoturnoController.excluirDocente}"
							oncomplete="#{rich:component('deletePanel')}.hide();"
							reRender="listaAdicionais, form" /></td>
						<td align="center" width="50%"><a4j:commandButton value="N�o"
							onclick="#{rich:component('deletePanel')}.hide();return false;" />
						</td>
					</tr>
				</tbody>
			</table>
		</h:form>
	</rich:modalPanel></center>
</f:view>
</body>
</html>