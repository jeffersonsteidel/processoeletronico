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
			<h:panelGrid columns="11">
				<h:outputText value="Siape: ">
				</h:outputText>
				<h:inputText
					value="#{servidorTitulacaoController.servidorTitulacao.servidor.siape}"
					size="10" maxlength="7" onkeyup="mascara(this, soNumeros);">
				</h:inputText>
<!--				<h:outputText value="Nome: ">
				</h:outputText>
				<h:inputText
					value="#{servidorTitulacaoController.servidorTitulacao.servidor.nome}"
					size="80">
				</h:inputText> -->
				<h:outputText value="Titulação: " />
				<h:selectOneMenu
					value="#{servidorTitulacaoController.servidorTitulacao.titulacao.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{servidorTitulacaoController.titulacoes}" />
				</h:selectOneMenu>

				<h:outputText value="Area de Conhecimento: " />
				<h:selectOneMenu
					value="#{servidorTitulacaoController.servidorTitulacao.areaConhecimento.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems
						value="#{servidorTitulacaoController.areasConhecimento}" />
				</h:selectOneMenu>

				<a4j:commandButton value="Pesquisar"
					action="#{servidorTitulacaoController.listarTitulacoesFiltro}"
					reRender="listaTitulacoes" type="submit" />
			</h:panelGrid>

			<rich:messages layout="list">
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<rich:dataTable id="listaTitulacoes"
				value="#{servidorTitulacaoController.listaServidorTitulacoes}"
				var="list" width="1150px" columnClasses="center" rows="15"
				reRender="ds">
				<rich:column width="50px" sortBy="#{list.servidor.siape}">
					<f:facet name="header">
						<h:outputText value="Siape" />
					</f:facet>
					<h:outputText value="#{list.servidor.siape}" />
				</rich:column>

				<rich:column width="420px" sortBy="#{list.servidor.nome}">
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

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Editar" />
					</f:facet>
					<a4j:commandLink action="#{servidorTitulacaoController.carregar}"
						reRender="listaTitulacoes" ajaxSingle="true">
						<h:graphicImage value="../images/edit.gif" style="border:0"
							width="20" height="18" id="editar" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{servidorTitulacaoController.servidorTitulacao.codigo}" />
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