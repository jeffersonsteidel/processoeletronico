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
			<font size="2"><b>PESQUISAR EMPREGOS</b></font>
			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<h:panelGrid columns="9">
				<h:outputText value="Siape do Servidor:" />
				<h:inputText value="#{empregoController.emprego.servidor.siape}"
					size="7" maxlength="7" onkeyup="mascara(this, soNumeros);"></h:inputText>
				<h:outputText value="Nome do Servidor:" />
				<h:inputText value="#{empregoController.emprego.servidor.nome}"
					size="60" maxlength="120"></h:inputText>
				<h:outputText value="Validados: " />
				<h:selectOneMenu value="#{empregoController.validado}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="SIM" itemValue="1" />
					<f:selectItem itemLabel="NÃO" itemValue="2" />
				</h:selectOneMenu>
				<h:outputText value="Situação: " />
				<h:selectOneMenu value="#{empregoController.situacao}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="ATIVOS" itemValue="1" />
					<f:selectItem itemLabel="INATIVOS" itemValue="2" />
				</h:selectOneMenu>
				<a4j:commandButton value="Pesquisar"
					action="#{empregoController.buscarEmpregos}"
					reRender="listaEmpregos" type="submit" />

			</h:panelGrid>
			<a4j:region>

				<rich:dataTable id="listaEmpregos"
					value="#{empregoController.listaEmpregosByFilter}" var="list"
					width="1150px" columnClasses="center" rows="15">
					<rich:column width="80px" sortBy="#{list.servidor.siape}">
						<f:facet name="header">
							<h:outputText value="Siape" />
						</f:facet>
						<h:outputText value="#{list.servidor.siape}" />
					</rich:column>
					<rich:column width="700px" sortBy="#{list.servidor.nome}">
						<f:facet name="header">
							<h:outputText value="Servidor" />
						</f:facet>
						<h:outputText value="#{list.servidor.nome}" />
					</rich:column>
					<rich:column width="700px" sortBy="#{list.empresa}">
						<f:facet name="header">
							<h:outputText value="Empresa" />
						</f:facet>
						<h:outputText value="#{list.empresa}" />
					</rich:column>

					<rich:column width="500px" sortBy="#{list.cargo}">
						<f:facet name="header">
							<h:outputText value="Cargo" />
						</f:facet>
						<h:outputText value="#{list.cargo}" />
					</rich:column>

					<rich:column width="80px" sortBy="#{list.dataAdmissao}">
						<f:facet name="header">
							<h:outputText value="Data de Admissão" />
						</f:facet>
						<h:outputText value="#{list.dataAdmissao}">
							<f:convertDateTime pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>

					<rich:column width="80px" sortBy="#{list.dataSaida}">
						<f:facet name="header">
							<h:outputText value="Data de Saida" />
						</f:facet>
						<h:outputText value="#{list.dataSaida}">
							<f:convertDateTime pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>
					<rich:column width="100px" sortBy="#{list.indValidado}">
						<f:facet name="header">
							<h:outputText value="Validado" />
						</f:facet>
						<h:outputText value="SIM" rendered="#{list.indValidado}" />
						<h:outputText value="NÃO" rendered="#{!list.indValidado}" />
					</rich:column>

					<rich:column>
						<f:facet name="header">
							<h:outputText value="Visualizar" />
						</f:facet>
						<a4j:commandLink action="#{empregoController.carregar}"
							reRender="editPanel" ajaxSingle="true"
							oncomplete="#{rich:component('editPanel')}.show()">
							<h:graphicImage value="../images/edit.gif" style="border:0"
								width="20" height="18" id="editar" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{empregoController.emprego.codigo}" />
						</a4j:commandLink>
						<rich:toolTip for="visualizar" value="Visualizar" />
					</rich:column>
					<f:facet name="footer">
						<rich:datascroller id="ds"></rich:datascroller>
					</f:facet>
				</rich:dataTable>
			</a4j:region>
		</rich:panel></center>
	</a4j:form>
	<center><rich:modalPanel id="editPanel" autosized="true"
		width="400">
		<h:form>
			<center><font size="2"><b>DETALHES DO EMPREGO</b></font> <h:panelGrid
				columns="2">
				<h:outputText value="Servidor: " />
				<h:outputText
					value="#{empregoController.emprego.servidor.siape} - #{empregoController.emprego.servidor.nome}" />
			</h:panelGrid> <h:panelGrid columns="4">
				<h:outputText value="Cargo: " />
				<h:outputText id="cargo" value="#{empregoController.emprego.cargo}"></h:outputText>
				<h:outputText value="Data de Admissão: " />
				<h:outputText value="#{empregoController.emprego.dataAdmissao}">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:outputText>
				<h:outputText value="Empresa: " />
				<h:outputText value="#{empregoController.emprego.empresa}"></h:outputText>
				<h:outputText value="Data de Saida: " />
				<h:outputText value="#{empregoController.emprego.dataSaida}">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:outputText>
			</h:panelGrid> <h:panelGrid columns="1">
				<h:outputText value="Atividades: " />
				<h:inputTextarea value="#{empregoController.emprego.atividades}"
					rows="10" cols="50" disabled="true">
				</h:inputTextarea>
			</h:panelGrid> <h:panelGrid columns="2">
				<a4j:commandButton value="Aprovar" reRender="form, listaTitulacoes"
					action="#{empregoController.validar}" />
				<a4j:commandButton value="Fechar"
					onclick="#{rich:component('editPanel')}.hide();return false;" />
			</h:panelGrid></center>
		</h:form>
	</rich:modalPanel></center>
</f:view>
</body>
</html>