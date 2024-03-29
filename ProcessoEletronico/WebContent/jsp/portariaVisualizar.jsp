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

			<font size="2"><b>PORTARIAS</b></font>


			<h:panelGrid columns="2">
				<h:outputText value="Nome da Portaria: "></h:outputText>
				<h:outputText value="#{portariaController.portaria.nome}">
				</h:outputText>
				<h:outputText value="Numero da Portaria: "></h:outputText>
				<h:outputText value="#{portariaController.portaria.numero}">
				</h:outputText>
				<h:outputText value="Data da Portaria: "></h:outputText>
				<h:outputText value="#{portariaController.portaria.data}">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:outputText>
				<h:outputText value="Tipo da Portaria: "></h:outputText>
				<h:outputText value="#{portariaController.portaria.tipo.descricao}">
				</h:outputText>
				<h:outputText value="Local da Portaria: "></h:outputText>
				<h:outputText value="#{portariaController.portaria.local}">
				</h:outputText>
				<h:outputText value="Descri��o da Portaria: "></h:outputText>
				<h:inputTextarea value="#{portariaController.portaria.descricao}"
					disabled="true" rows="10" cols="50">
				</h:inputTextarea>
			</h:panelGrid>
			<h:panelGroup id="info">
				<rich:panel bodyClass="info">
					<rich:dataGrid columns="1"
						value="#{portariaController.portaria.arquivo1}" var="file"
						rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="5">
								<a4j:mediaOutput element="img"
									createContent="#{portariaController.paint1}" value="#{row}"
									style="width:600px; height:800px;" cacheable="false">
								</a4j:mediaOutput>
							</h:panelGrid>
						</rich:panel>
					</rich:dataGrid>
					<rich:dataGrid columns="1"
						value="#{portariaController.portaria.arquivo2}" var="file"
						rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="5">
								<a4j:mediaOutput element="img"
									createContent="#{portariaController.paint2}" value="#{row}"
									style="width:600px; height:800px;" cacheable="false">
								</a4j:mediaOutput>
							</h:panelGrid>
						</rich:panel>
					</rich:dataGrid>
					<rich:dataGrid columns="1"
						value="#{portariaController.portaria.arquivo3}" var="file"
						rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="5">
								<a4j:mediaOutput element="img"
									createContent="#{portariaController.paint3}" value="#{row}"
									style="width:600px; height:800px;" cacheable="false">
								</a4j:mediaOutput>
							</h:panelGrid>
						</rich:panel>
					</rich:dataGrid>
					<rich:dataGrid columns="1"
						value="#{portariaController.portaria.arquivo4}" var="file"
						rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="5">
								<a4j:mediaOutput element="img"
									createContent="#{portariaController.paint4}" value="#{row}"
									style="width:600px; height:800px;" cacheable="false">
								</a4j:mediaOutput>
							</h:panelGrid>
						</rich:panel>
					</rich:dataGrid>
					<rich:dataGrid columns="1"
						value="#{portariaController.portaria.arquivo5}" var="file"
						rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="5">
								<a4j:mediaOutput element="img"
									createContent="#{portariaController.paint5}" value="#{row}"
									style="width:600px; height:800px;" cacheable="false">
								</a4j:mediaOutput>
							</h:panelGrid>
						</rich:panel>
					</rich:dataGrid>
				</rich:panel>
			</h:panelGroup>
			<a4j:commandButton value="Voltar"
 				action="#{portariaController.retornaUltimaPesquisa}"></a4j:commandButton>
		</rich:panel></center>

	</a4j:form>
</f:view>
</body>
</html>