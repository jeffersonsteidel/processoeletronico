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
			<font size="2"><b>LISTAR DEPENDENTES</b></font>
			<h:panelGrid columns="9">

				<h:outputText value="Siape: ">
				</h:outputText>
				<h:inputText
					value="#{dependenteController.dependente.servidor.siape}" size="10"
					maxlength="7" onkeyup="mascara(this, soNumeros);">
				</h:inputText>

				<h:outputText value="Servidor: ">
				</h:outputText>
				<h:inputText
					value="#{dependenteController.dependente.servidor.nome}" size="60">
				</h:inputText>

				<h:outputText value="Dependente: ">
				</h:outputText>
				<h:inputText value="#{dependenteController.dependente.nome}"
					size="60">
				</h:inputText>

				<h:outputText value="Parentesco: " />
				<h:selectOneMenu
					value="#{dependenteController.dependente.grauParentesco.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{dependenteController.grausParentescos}" />
				</h:selectOneMenu>

				<a4j:commandButton value="Pesquisar"
					action="#{dependenteController.listarDependentesFiltro}"
					reRender="listaDependentes" type="submit" />
			</h:panelGrid>

			<rich:messages layout="list">
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<rich:dataTable id="listaDependentes"
				value="#{dependenteController.listaDependentesFiltro}" var="list"
				width="1150px" columnClasses="center" rows="15" reRender="ds">
				<rich:column width="50px" sortBy="#{list.servidor.siape}">
					<f:facet name="header">
						<h:outputText value="Siape" />
					</f:facet>
					<h:outputText value="#{list.servidor.siape}" />
				</rich:column>

				<rich:column width="420px" sortBy="#{list.servidor.nome}">
					<f:facet name="header">
						<h:outputText value="Servidor" />
					</f:facet>
					<h:outputText value="#{list.servidor.nome}" />
				</rich:column>

				<rich:column width="420px" sortBy="#{list.nome}">
					<f:facet name="header">
						<h:outputText value="Dependente" />
					</f:facet>
					<h:outputText value="#{list.nome}" />
				</rich:column>

				<rich:column width="420px" sortBy="#{list.grauParentesco.descricao}">
					<f:facet name="header">
						<h:outputText value="Grau Parentesco" />
					</f:facet>
					<h:outputText value="#{list.grauParentesco.descricao}" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Editar" />
					</f:facet>
					<a4j:commandLink action="#{dependenteController.carregar}"
						reRender="editPanel" ajaxSingle="true"
						oncomplete="#{rich:component('editPanel')}.show()">
						<h:graphicImage value="../images/edit.gif" style="border:0"
							width="20" height="18" id="editar" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{dependenteController.dependente.codigo}" />
					</a4j:commandLink>
					<rich:toolTip for="editar" value="Editar" />
				</rich:column>

				<f:facet name="footer">
					<rich:datascroller id="ds"></rich:datascroller>
				</f:facet>
			</rich:dataTable>
		</rich:panel>
	</a4j:form></center>

	<center><rich:modalPanel id="editPanel" autosized="true"
		width="200">
		<h:form>
			<center><font size="2"><b>DETALHES DO DEPENDENTE</b></font> <h:panelGrid
				columns="4">
				<h:outputText value="Siape do Servidor: " />
				<h:inputText id="siape" requiredMessage="Campo Siape é obrigatório!"
					required="true" value="#{dependenteController.dependente.servidor.siape}"
					size="10" maxlength="8"></h:inputText>
				<h:outputText value="Nome do Servidor: " />
				<h:inputText id="servidor"
					requiredMessage="Campo Nome do Servidor é obrigatório!" required="true"
					value="#{dependenteController.dependente.servidor.nome}" size="60"
					maxlength="100"></h:inputText>
				<h:outputText value="Nome do Dependente: " />
				<h:inputText id="servidor"
					requiredMessage="Campo Nome do Dependente é obrigatório!" required="true"
					value="#{dependenteController.dependente.nome}" size="60"
					maxlength="100"></h:inputText>
				<h:outputText value="Nome do Dependente: " />
				<h:inputText id="dependente"
					requiredMessage="Campo Nome do Dependente é obrigatório!" required="true"
					value="#{dependenteController.dependente.nome}" size="60"
					maxlength="100"></h:inputText>
				<h:outputText value="Grau de Parentesco: " />
				<h:selectOneMenu
					value="#{dependenteController.dependente.grauParentesco.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{dependenteController.dependente.grauParentesco.descricao}" />
				</h:selectOneMenu>

			</h:panelGrid> <h:panelGrid columns="1">
				<a4j:commandButton value="Fechar"
					onclick="#{rich:component('editPanel')}.hide();return false;" />
			</h:panelGrid></center>
		</h:form>
	</rich:modalPanel></center>
</f:view>
</body>
</html>