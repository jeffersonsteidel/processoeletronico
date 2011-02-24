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
					value="#{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.servidor.nome}">
				</h:outputText>
			</h:panelGrid>
			<h:panelGrid columns="10">
				<h:outputText value="Campus: " />
				<h:selectOneMenu id="campus" disabled="true"
					value="#{solicitacaoAdicionalNoturnoController.solicitacaoAdicionalNoturno.lotacao.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems
						value="#{solicitacaoAdicionalNoturnoController.lotacoes}" />
				</h:selectOneMenu>

				<h:outputText value="Servidor: " />
				<h:selectOneMenu id="servidoresCampus"
					value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.servidor.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems
						value="#{solicitacaoAdicionalNoturnoController.servidoresCampus}" />
				</h:selectOneMenu>

				<h:outputText value="Data: " />
				<rich:calendar id="data"
					value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.data}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					inputSize="12" />

				<h:outputText value="Hora Inicial: " />
				<h:inputText id="horaInicial"
					value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.horaInicial}"
					size="8" maxlength="5" onkeypress="mascara(this,horario);"
					validatorMessage="O campo Hora Inicial deve ter 4 digitos">
					<f:validateLength minimum="5" />
				</h:inputText>

				<h:outputText value="Hora Final: " />
				<h:inputText id="horaFinal"
					value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.horaFinal}"
					size="8" maxlength="5" onkeypress="mascara(this,horario);"
					validatorMessage="O campo Hora Final deve ter 4 digitos">
					<f:validateLength minimum="5" />
				</h:inputText>

			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText id="motivo" value="Motivo: " />
				<h:inputTextarea rows="5" cols="50"
					value="#{solicitacaoAdicionalNoturnoController.adicionalNoturno.motivo}"
					validatorMessage="Tarefas Diarias deve ter no máximo 250 caracteres!">
					<f:validateLength maximum="250"></f:validateLength>
				</h:inputTextarea>
			</h:panelGrid>

			<a4j:commandButton value="Adicionar"
				action="#{solicitacaoAdicionalNoturnoController.adicionarAdicionalTecnico}"
				reRender="listaAdicionais, form, salvar" />

			<rich:dataTable id="listaAdicionais"
				value="#{solicitacaoAdicionalNoturnoController.listaAdicionalTecnicos}"
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

			<a4j:commandButton id="salvar" value="Salvar"
				rendered="#{not empty solicitacaoAdicionalNoturnoController.listaAdicionalTecnicos}"
				action="#{solicitacaoAdicionalNoturnoController.salvarAdicionalTecnico}"
				reRender="form" />
		</rich:panel></center>
	</a4j:form>


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
							action="#{solicitacaoAdicionalNoturnoController.excluir}"
							oncomplete="#{rich:component('deletePanel')}.hide();"
							reRender="listaAdicionais, form" /></td>
						<td align="center" width="50%"><a4j:commandButton value="Não"
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