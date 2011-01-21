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
	<center><a4j:form id="form">
		<rich:panel>
			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<font size="2"><b>LISTAR RESSARCIMENTO SAÚDE</b></font>
			<h:panelGrid columns="13">
				<h:outputText value="Siape do Servidor: ">
				</h:outputText>
				<h:inputText
					value="#{ressarcimentoSaudeController.ressarcimentoSaudeTemp.servidor.siape}"
					size="10" maxlength="7" onkeyup="mascara(this, soNumeros);">
				</h:inputText>

				<h:outputText value="Tipo Plano: " />
				<h:selectOneMenu
					value="#{ressarcimentoSaudeController.ressarcimentoSaudeTemp.tipoPlano.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{ressarcimentoSaudeController.tiposPlanos}" />
				</h:selectOneMenu>

				<h:outputText value="Status: " />
				<h:selectOneMenu
					value="#{ressarcimentoSaudeController.ressarcimentoSaudeTemp.status.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{ressarcimentoSaudeController.status}" />
				</h:selectOneMenu>

				<h:outputText value="Situação: " />
				<h:selectOneMenu value="#{ressarcimentoSaudeController.situacao}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="ATIVOS" itemValue="1" />
					<f:selectItem itemLabel="INATIVOS" itemValue="2" />
				</h:selectOneMenu>

				<a4j:commandButton value="Pesquisar"
					action="#{ressarcimentoSaudeController.pesquisar}"
					reRender="listaRessarcimento" type="submit" />
			</h:panelGrid>

			<rich:dataTable id="listaRessarcimento"
				value="#{ressarcimentoSaudeController.ressarcimentoList}" var="list"
				width="1150px" columnClasses="center" rows="15" reRender="ds">


				<rich:column width="500px">
					<f:facet name="header">
						<h:outputText value="Servidor" />
					</f:facet>
					<h:outputText value="#{list.servidor.nome}" />
				</rich:column>

				<rich:column width="500px">
					<f:facet name="header">
						<h:outputText value="Tipo Plano" />
					</f:facet>
					<h:outputText value="#{list.tipoPlano.descricao}" />
				</rich:column>

				<rich:column width="500px">
					<f:facet name="header">
						<h:outputText value="Nome Plano" />
					</f:facet>
					<h:outputText value="#{list.nomePlano}" />
				</rich:column>

			<rich:column width="240px"
					sortBy="#{list.status.descricao}">
					<f:facet name="header">
						<h:outputText value="Status" />
					</f:facet>
					<h:outputText value="#{list.status.descricao}" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Visualizar" />
					</f:facet>
					<a4j:commandLink rendered="#{list.status.codigo == 1}" 
					action="#{ressarcimentoSaudeController.carregar}"
						reRender="editPanel" ajaxSingle="true"
						oncomplete="#{rich:component('editPanel')}.show()">
						<h:graphicImage value="../images/encaminhado.png" style="border:0"
							width="20" height="18" id="encaminhado" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{ressarcimentoSaudeController.ressarcimentoSaude.codigo}" />
					</a4j:commandLink>
					<a4j:commandLink rendered="#{list.status.codigo == 2}"
						action="#"
						reRender="listaSolicitacoes" ajaxSingle="true">
						<h:graphicImage value="../images/analize.gif" style="border:0"
							width="20" height="18" id="emAnalise" />
						</a4j:commandLink>
					<a4j:commandLink rendered="#{list.status.codigo == 3}" 
					action="#{ressarcimentoSaudeController.carregar}"
						reRender="editPanel" ajaxSingle="true"
						oncomplete="#{rich:component('editPanel')}.show()">
						<h:graphicImage value="../images/deferido.gif" style="border:0"
							width="20" height="18" id="deferido" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{ressarcimentoSaudeController.ressarcimentoSaude.codigo}" />
					</a4j:commandLink>
					<a4j:commandLink rendered="#{list.status.codigo == 4}" 
					action="#{ressarcimentoSaudeController.carregar}"
						reRender="editPanel" ajaxSingle="true"
						oncomplete="#{rich:component('editPanel')}.show()">
						<h:graphicImage value="../images/indeferido.gif" style="border:0"
							width="20" height="18" id="indeferido" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{ressarcimentoSaudeController.ressarcimentoSaude.codigo}" />
					</a4j:commandLink>
					<rich:toolTip for="encaminhado" value="Encaminhado" />
					<rich:toolTip for="emAnalise" value="Você não pode abrir uma solicitação que está em Análise!" />
					<rich:toolTip for="deferido" value="Deferido" />
					<rich:toolTip for="indeferido" value="Indeferido" />
				</rich:column>
				
				
				<f:facet name="footer">
					<rich:datascroller id="ds"></rich:datascroller>
				</f:facet>
			</rich:dataTable>

		</rich:panel>
	</a4j:form></center>

	<center><rich:modalPanel id="editPanel" autosized="false"
		style="overflow: auto;" height="500" width="1000">
		<f:facet name="header">
			<h:panelGroup>
				<center><h:outputText
					value="Detalhes do Ressarcimento Saúde"></h:outputText></center>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="../images/close.gif"
					onclick="#{rich:component('editPanel')}.hide();" />
			</h:panelGroup>
		</f:facet>
		<h:form>
			<center><h:panelGrid columns="1">
				<h:outputText
					value="Servidor: #{ressarcimentoSaudeController.ressarcimentoSaude.servidor.siape} - #{ressarcimentoSaudeController.ressarcimentoSaude.servidor.nome}" />
				<h:outputText
					value="Tipo do Plano: #{ressarcimentoSaudeController.ressarcimentoSaude.tipoPlano.descricao}" />
				<h:outputText
					value="Nome do Plano: #{ressarcimentoSaudeController.ressarcimentoSaude.nomePlano}"
					rendered="#{ressarcimentoSaudeController.indParticular}" />
				<h:outputText
					value="Numero do Contrato: #{ressarcimentoSaudeController.ressarcimentoSaude.numeroContrato}" />
				<h:outputText value="Data Adesão:" />
				<h:outputText
					value="#{ressarcimentoSaudeController.ressarcimentoSaude.dataAdesao}">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:outputText>
			</h:panelGrid> <h:outputText value="Cônjuge"
				rendered="#{not empty ressarcimentoSaudeController.conjuges}" /> <rich:dataTable
				id="listarConjugesSolicitante"
				rendered="#{not empty ressarcimentoSaudeController.conjuges}"
				value="#{ressarcimentoSaudeController.conjuges}" var="list"
				width="700px" columnClasses="center" rows="15" reRender="ds">

				<rich:column width="435px">
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{list.nome}" />
				</rich:column>

				<rich:column width="280px">
					<f:facet name="header">
						<h:outputText value="Atual" />
					</f:facet>
					<h:outputText value="Atual" rendered="#{list.atual}" />
					<h:outputText value="Ex" rendered="#{!list.atual}" />
				</rich:column>
			</rich:dataTable> <br>
			<h:outputText value="Dependentes:"
				rendered="#{not empty ressarcimentoSaudeController.dependentes}" />
			<br>
			<rich:dataTable id="listarDependentesSolicitante"
				rendered="#{not empty ressarcimentoSaudeController.dependentes}"
				value="#{ressarcimentoSaudeController.dependentes}" var="list"
				width="700px" columnClasses="center" rows="15" reRender="ds">

				<rich:column width="435px">
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{list.nome}" />
				</rich:column>
				<rich:column width="280px">
					<f:facet name="header">
						<h:outputText value="Grau de Parentesco" />
					</f:facet>
					<h:outputText value="#{list.grauParentesco.descricao}" />
				</rich:column>
				<rich:column width="280px">
					<f:facet name="header">
						<h:outputText value="Estudante" />
					</f:facet>
					<h:outputText value="SIM" rendered="#{list.indEstudante}" />
					<h:outputText value="NÃO" rendered="#{!list.indEstudante}" />
				</rich:column>
				<rich:column width="280px">
					<f:facet name="header">
						<h:outputText value="Necessidades Especiais" />
					</f:facet>
					<h:outputText value="SIM"
						rendered="#{list.indNecessidadesEspeciais}" />
					<h:outputText value="NÃO"
						rendered="#{!list.indNecessidadesEspeciais}" />
				</rich:column>
			</rich:dataTable> <h:panelGroup id="info">
				<rich:panel bodyClass="info">
					<rich:dataGrid
						value="#{ressarcimentoSaudeController.ressarcimentoSaude.files}"
						var="file" rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="2">
								<a4j:mediaOutput element="img"
									createContent="#{ressarcimentoSaudeController.paint}"
									value="#{row}"
									style="width:600px; height:800px; overflow:auto;"
									cacheable="false">
								</a4j:mediaOutput>
							</h:panelGrid>
						</rich:panel>
					</rich:dataGrid>
				</rich:panel>
			</h:panelGroup> 
				<h:panelGrid columns="2">
				<h:outputText value="Justificativa: " />
				<h:inputTextarea disabled="#{ressarcimentoSaudeController.ressarcimentoSaude.status.codigo != 2}"
					value="#{ressarcimentoSaudeController.ressarcimentoSaude.justificativa}"
					cols="50" rows="5"></h:inputTextarea>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<a4j:commandButton value="Deferir"
					action="#{ressarcimentoSaudeController.deferir}" rendered="#{ressarcimentoSaudeController.ressarcimentoSaude.status.codigo ==2}"
					reRender="listaRessarcimento" />
				<a4j:commandButton value="Indeferir" rendered="#{ressarcimentoSaudeController.ressarcimentoSaude.status.codigo ==2}"
					action="#{ressarcimentoSaudeController.indeferir}"
					reRender="listaRessarcimento" />
				<a4j:commandButton value="Fechar"
					onclick="#{rich:component('editPanel')}.hide();return false;" />
			</h:panelGrid></center>
		</h:form>
	</rich:modalPanel></center>
</f:view>
</body>
</html>
