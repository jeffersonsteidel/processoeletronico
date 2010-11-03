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
			<h:panelGrid columns="13">
				<h:outputText value="Número: ">
				</h:outputText>
				<h:inputText value="#{portariaController.portaria.numero}" size="10"
					maxlength="7" onkeyup="mascara(this, soNumeros);">
				</h:inputText>
				
				<h:outputText value="Nome: ">
				</h:outputText>
				<h:inputText value="#{portariaController.portaria.nome}" size="70">
				</h:inputText>
				
				<h:outputText value="Data: " />
				<rich:calendar
					value="#{portariaController.dataInicio}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"/>
					
				<h:outputText value="à" />
				<rich:calendar
					value="#{portariaController.dataFinal}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"/>

				<h:outputText value="Tipo Portaria: " />
				<h:selectOneMenu value="#{portariaController.portaria.descricao}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{portariaController.tiposPortaria}" />
				</h:selectOneMenu>

				<h:outputText value="Local: ">
				</h:outputText>
				<h:selectOneMenu value="#{portariaController.portaria.local}">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItem itemLabel="REITORIA" itemValue="reitoria" />
						<f:selectItem itemLabel="PROGEPE" itemValue="progepe" />
				</h:selectOneMenu>
				
				<a4j:commandButton value="Pesquisar"
					action="#{portariasController.listarPortarias}"
					reRender="listarPortarias" type="submit" />
			</h:panelGrid>

			<rich:messages layout="list">
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<rich:dataTable id="listaPortarias"
				value="#{portariaController.portariaList}" var="list"
				width="1150px" columnClasses="center" rows="15" reRender="ds">
				<rich:column width="50px" sortBy="#{list.numero}">
					<f:facet name="header">
						<h:outputText value="Numero" />
					</f:facet>
					<h:outputText value="#{list.numero}" />
				</rich:column>

				<rich:column width="420px" sortBy="#{list.nome}">
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{list.nome}" />
				</rich:column>

				<rich:column width="280px" sortBy="#{list.dataInicio}">
					<f:facet name="header">
						<h:outputText value="Data Inicio" />
					</f:facet>
					<h:outputText value="#{list.dataInicio}" />
				</rich:column>
				
				<rich:column width="280px" sortBy="#{list.dataFinal}">
					<f:facet name="header">
						<h:outputText value="Data Final" />
					</f:facet>
					<h:outputText value="#{list.dataFinal}" />
				</rich:column>

				<rich:column width="280px" sortBy="#{list.tipoPortaria.tipo}">
					<f:facet name="header">
						<h:outputText value="Tipo" />
					</f:facet>
					<h:outputText value="#{list.tipoPortaria.tipo}" />
				</rich:column>

				<rich:column width="280px" sortBy="#{list.local}">
					<f:facet name="header">
						<h:outputText value="Local" />
					</f:facet>
					<h:outputText value="#{list.local}" />
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