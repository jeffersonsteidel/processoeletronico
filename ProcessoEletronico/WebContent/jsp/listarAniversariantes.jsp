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
			<font size="2"><b>LISTAR ANIVERSARIANTES</b></font>

			<h:panelGrid columns="3">
				<h:outputText value="Mês" />
				<h:selectOneMenu value="#{aniversarianteController.mes}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItem itemLabel="JANEIRO" itemValue=1 />
					<f:selectItem itemLabel="FEVEREIRO" itemValue=2 />
					<f:selectItem itemLabel="MARÇO" itemValue=3 />
					<f:selectItem itemLabel="ABRIL" itemValue=4 />
					<f:selectItem itemLabel="MAIO" itemValue=5 />
					<f:selectItem itemLabel="JUNHO" itemValue=6 />
					<f:selectItem itemLabel="JULHO" itemValue=7 />
					<f:selectItem itemLabel="AGOSTO" itemValue=8 />
					<f:selectItem itemLabel="SETEMBRO" itemValue=9 />
					<f:selectItem itemLabel="OUTUBRO" itemValue=10 />
					<f:selectItem itemLabel="NOVEMBRO" itemValue=11 />
					<f:selectItem itemLabel="DEZEMBRO" itemValue=12 />
				</h:selectOneMenu>
				<a4j:commandButton value="Pesquisar"
					action="#{aniversarianteController.pesquisarAniversariantes}"
					reRender="listaAniversariantes" type="submit" />
			</h:panelGrid>
			<a4j:region>
				<rich:dataTable id="listaAniversariantes"
					value="#{aniversarianteController.aniversariantesList}" var="list"
					width="1150px" columnClasses="center" rows="15">
					<rich:column width="80px" sortBy="#{list.siape}">
						<f:facet name="header">
							<h:outputText value="Siape" />
						</f:facet>
						<h:outputText value="#{list.siape}" />
					</rich:column>
					<rich:column width="700px" sortBy="#{list.nome}">
						<f:facet name="header">
							<h:outputText value="Servidor" />
						</f:facet>
						<h:outputText value="#{list.nome}" />
					</rich:column>
					<rich:column width="700px" sortBy="#{list.lotacao}">
						<f:facet name="header">
							<h:outputText value="Campus" />
						</f:facet>
						<h:outputText value="#{list.lotacao}" />
					</rich:column>
					<rich:column width="700px" sortBy="#{list.dataNascimento}">
						<f:facet name="header">
							<h:outputText value="Data" />
						</f:facet>
						<h:outputText value="#{list.dataNascimento}" />
					</rich:column>
					<rich:column width="700px" sortBy="#{list.diaSemana}">
						<f:facet name="header">
							<h:outputText value="Dia da Semana" />
						</f:facet>
						<h:outputText value="#{list.diaSemana}" />
					</rich:column>
					<f:facet name="footer">
					</f:facet>
				</rich:dataTable>
			</a4j:region>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>