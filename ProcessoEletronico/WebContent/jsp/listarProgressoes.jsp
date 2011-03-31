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
			<font size="2"><b>PESQUISAR PROGRESSÕES - POR MÉRITO</b></font>

			<rich:messages layout="list">
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<h:panelGrid columns="6">
				<h:outputText value="Siape Servidor: ">
				</h:outputText>
				<h:inputText
					value="#{progressaoController.progressao.servidor.siape}" size="8"
					maxlength="7" onkeyup="mascara(this, soNumeros);">
				</h:inputText>

				<h:outputText value="Status: ">
				</h:outputText>
				<h:selectOneMenu value="#{progressaoController.progressao.indConcedido}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItem itemLabel="CONCEDIDA" itemValue="1" />
					<f:selectItem itemLabel="NÃO CONCEDIDA" itemValue="2" />
					<f:selectItem itemLabel="ADIADA" itemValue="3" />
				</h:selectOneMenu>
				<a4j:commandButton value="Pesquisar"
					action="#{progressaoController.pesquisarProgressoes}"
					reRender="listarProgressao"></a4j:commandButton>
			</h:panelGrid>

			<rich:dataTable id="listarProgressao"
				value="#{progressaoController.progressaoList}" var="list"
				width="1200px" columnClasses="center" rows="15" reRender="ds">

				<rich:column width="50px" sortBy="#{list.servidor.siape}">
					<f:facet name="header">
						<h:outputText value="Siape" />
					</f:facet>
					<h:outputText value="#{list.servidor.siape}" />
				</rich:column>

				<rich:column width="400px" sortBy="#{list.servidor.nome}">
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{list.servidor.nome}" />
				</rich:column>

				<rich:column width="50px" sortBy="#{list.dataProgressao}">
					<f:facet name="header">
						<h:outputText value="Data última progressão" />
					</f:facet>
					<h:outputText value="#{list.dataProgressao}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</rich:column>

				<rich:column width="50px" sortBy="#{list.dataProximaProgressao}">
					<f:facet name="header">
						<h:outputText value="Data próxima progressão" />
					</f:facet>
					<h:outputText value="#{list.dataProximaProgressao}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</rich:column>

				<rich:column width="50px" sortBy="#{list.classeNova.sigla}">
					<f:facet name="header">
						<h:outputText value="Classe" />
					</f:facet>
					<h:outputText value="#{list.classeNova.sigla}" />
				</rich:column>

				<rich:column width="50px" sortBy="#{list.padraoAntigo.nivel}">
					<f:facet name="header">
						<h:outputText value="Padrao Anterior" />
					</f:facet>
					<h:outputText value="#{list.padraoAntigo.nivel}" />
				</rich:column>

				<rich:column width="50px" sortBy="#{list.padraoNovo.nivel}">
					<f:facet name="header">
						<h:outputText value="Padrao Novo" />
					</f:facet>
					<h:outputText value="#{list.padraoNovo.nivel}" />
				</rich:column>

				<rich:column width="50px" sortBy="#{list.portaria}">
					<f:facet name="header">
						<h:outputText value="Portaria" />
					</f:facet>
					<h:outputText value="#{list.portaria}" />
				</rich:column>
				
				<rich:column width="50px" sortBy="#{list.nota}">
					<f:facet name="header">
						<h:outputText value="Nota" />
					</f:facet>
					<h:outputText value="#{list.nota}" />
				</rich:column>
				
				<rich:column width="60px" sortBy="#{list.indConcedido}">
					<f:facet name="header">
						<h:outputText value="Status" />
					</f:facet>
					<h:outputText rendered="#{list.indConcedido == 1}"  value="CONCEDIDA" />
					<h:outputText rendered="#{list.indConcedido == 2}"  value="NÃO CONCEDIDA" />
					<h:outputText rendered="#{list.indConcedido == 3}"  value="ADIADA" />
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