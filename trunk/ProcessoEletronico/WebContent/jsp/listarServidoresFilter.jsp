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
	<jsp:directive.include file="menus.jsp"/>
	<center><a4j:form id="form">
			<rich:panel>
			<font size="2"><b>PESQUISAR SERVIDOR</b></font>
			<h:panelGrid columns="9">
				<h:outputText value="Siape: ">
				</h:outputText>
				<h:inputText value="#{servidorController.servidor.siape}" size="10"
					maxlength="7" onkeyup="mascara(this, soNumeros);">
				</h:inputText>
				<h:outputText value="Nome: ">
				</h:outputText>
				<h:inputText value="#{servidorController.servidor.nome}" size="80">
				</h:inputText>
				<h:outputText value="Lotação: " />
				<h:selectOneMenu
					value="#{servidorController.servidor.lotacao.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{servidorController.lotacoes}" />
				</h:selectOneMenu>

				<h:outputText value="Cargo: " />
				<h:selectOneMenu value="#{servidorController.servidor.cargo.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{servidorController.cargos}" />
				</h:selectOneMenu>

				<a4j:commandButton value="Pesquisar"
					action="#{servidorController.listarServidoresFiltro}"
					reRender="listaServidores" type="submit" />
			</h:panelGrid>

			<rich:messages layout="list">
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<rich:dataTable id="listaServidores"
				value="#{servidorController.servidoresList}" var="list"
				width="1150px" columnClasses="center" rows="15" reRender="ds">
				<rich:column width="50px" sortBy="#{list.siape}">
					<f:facet name="header">
						<h:outputText value="Siape" />
					</f:facet>
					<h:outputText value="#{list.siape}" />
				</rich:column>

				<rich:column width="420px" sortBy="#{list.nome}">
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{list.nome}" />
				</rich:column>

				<rich:column width="280px" sortBy="#{list.lotacao.descricao}">
					<f:facet name="header">
						<h:outputText value="Lotação" />
					</f:facet>
					<h:outputText value="#{list.lotacao.descricao}" />
				</rich:column>

				<rich:column width="280px" sortBy="#{list.documento.cpf}">
					<f:facet name="header">
						<h:outputText value="CPF" />
					</f:facet>
					<h:outputText value="#{list.documento.cpf}" />
				</rich:column>

				<rich:column width="280px" sortBy="#{list.cargo.descricao}">
					<f:facet name="header">
						<h:outputText value="Cargo" />
					</f:facet>
					<h:outputText value="#{list.cargo.descricao}" />
				</rich:column>


				<rich:column width="250px"
					sortBy="#{list.situacaoFuncional.descricao}">
					<f:facet name="header">
						<h:outputText value="Situação Funcional" />
					</f:facet>
					<h:outputText value="#{list.situacaoFuncional.descricao}" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Editar" />
					</f:facet>
					<a4j:commandLink action="#{servidorController.carregar}"
						reRender="listarServidores" ajaxSingle="true">
						<h:graphicImage value="../images/edit.gif" style="border:0"
							width="20" height="18" id="editar" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{servidorController.servidor.codigo}" />
					</a4j:commandLink>
					<rich:toolTip for="editar" value="Editar" />
				</rich:column>



				<f:facet name="footer">
					<rich:datascroller id="ds"></rich:datascroller>
				</f:facet>
			</rich:dataTable>
		</rich:panel>
	</a4j:form></center>
</f:view>
</body>
</html>