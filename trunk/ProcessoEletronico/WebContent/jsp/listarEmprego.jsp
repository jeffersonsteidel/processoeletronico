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
			<font size="2"><b>PESQUISAR EMPREGOS</b></font>

			<h:panelGrid columns="5">
				<h:outputText value="Siape do Servidor:" />
				<h:inputText value="#{empregoController.emprego.servidor.siape}"
					size="10" maxlength="8"></h:inputText>
				<h:outputText value="Nome do Servidor:" />
				<h:inputText value="#{empregoController.emprego.servidor.nome}"
					size="80" maxlength="120"></h:inputText>
				<a4j:commandButton value="Pesquisar" action="#{empregoController.buscarEmpregos}"
					reRender="listaEmpregos" type="submit" />
			</h:panelGrid>
			<a4j:region>

				<rich:dataTable id="listaEmpregos"
					value="#{empregoController.listaEmpregosByFilter}" var="list"
					width="1150px" columnClasses="center" rows="15">

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
							<h:outputText value="Data de Admiss�o" />
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

					<rich:column>
						<f:facet name="header">
							<h:outputText value="Editar" />
						</f:facet>
						<a4j:commandLink action="#{empregoController.carregar}"
							reRender="listaEmpregos, form" ajaxSingle="true" oncomplete="#{rich:component('editPanel')}.show()">
							<h:graphicImage value="../images/edit.gif" style="border:0"
								width="20" height="18" id="editar" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{empregoController.emprego.codigo}" />
						</a4j:commandLink>
						<rich:toolTip for="editar" value="Editar" />
					</rich:column>
					<f:facet name="footer">
						<rich:datascroller id="ds"></rich:datascroller>
					</f:facet>
				</rich:dataTable>
			</a4j:region>
		</rich:panel></center>
	</a4j:form>
	<center><rich:modalPanel id="editPanel" autosized="true"
		width="200">
		<h:form>
				<h:panelGrid columns="4">
					<h:outputText value="Cargo: " />
					<h:inputText id="cargo"
						requiredMessage="Campo Cargo � obrigat�rio!" required="true"
						value="#{empregoController.emprego.cargo}" size="40"
						maxlength="80"></h:inputText>
					<h:outputText value="Empresa: " />
					<h:inputText id="empresa"
						requiredMessage="Campo Empresa � obrigat�rio!" required="true"
						value="#{empregoController.emprego.empresa}" size="60"
						maxlength="100"></h:inputText>

					<h:outputText value="Data de Admiss�o: " />
					<rich:calendar rendered="true"
						requiredMessage="Campo Data de Admiss�o � Obrigat�rio!"
						value="#{empregoController.emprego.dataAdmissao}" locale=""
						popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
						cellWidth="12px" cellHeight="12px" style="width:80px"
						inputSize="12" />

					<h:outputText value="Data de Saida: " />
					<rich:calendar rendered="true"
						requiredMessage="Campo Data de Admiss�o � Obrigat�rio!"
						value="#{empregoController.emprego.dataSaida}" locale=""
						popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
						cellWidth="12px" cellHeight="12px" style="width:80px"
						inputSize="12" />
				</h:panelGrid>
				<h:panelGrid columns="4">
					<center><h:outputText value="Atividades: " /> <h:inputTextarea
						value="#{empregoController.emprego.atividades}" rows="10"
						cols="50" required="true"
						requiredMessage="Campo Atividades � obrigat�rio!">
					</h:inputTextarea></center>
				</h:panelGrid>
		</h:form>
	</rich:modalPanel></center>
</f:view>
</body>
</html>