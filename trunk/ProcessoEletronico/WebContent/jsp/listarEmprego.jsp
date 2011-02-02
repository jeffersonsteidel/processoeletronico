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
				<h:inputText
					value="#{empregoController.empregoFiltro.servidor.siape}" size="7"
					maxlength="7" onkeyup="mascara(this, soNumeros);"></h:inputText>
				<h:outputText value="Nome do Servidor:" />
				<h:inputText
					value="#{empregoController.empregoFiltro.servidor.nome}" size="60"
					maxlength="120"></h:inputText>
				<h:outputText value="Status: " />
				<h:selectOneMenu
					value="#{empregoController.empregoFiltro.statusSolicitacao.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{empregoController.statusSolicitacoes}" />
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



					<rich:column width="30px">
						<f:facet name="header">
							<h:outputText value="Visualizar" />
						</f:facet>

						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 1}"
							action="#{empregoController.validar}"
							reRender="panel, listaEmpregos" ajaxSingle="true">
							<h:graphicImage value="../images/encaminhado.png"
								style="border:0" width="20" height="18" id="encaminhado" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{empregoController.emprego.codigo}" />
						</a4j:commandLink>

						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 2}"
							action="#" reRender="panel" ajaxSingle="true">
							<h:graphicImage value="../images/analize.gif" style="border:0"
								width="20" height="18" id="emAnalise" />
						</a4j:commandLink>

						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 3}"
							action="#{empregoController.validar}" reRender="panel"
							ajaxSingle="true">
							<h:graphicImage value="../images/deferido.gif" style="border:0"
								width="20" height="18" id="deferido" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{empregoController.emprego.codigo}" />
						</a4j:commandLink>

						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 4}"
							action="#{empregoController.validar}" reRender="panel"
							ajaxSingle="true">
							<h:graphicImage value="../images/indeferido.gif" style="border:0"
								width="20" height="18" id="indeferido" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{empregoController.emprego.codigo}" />
						</a4j:commandLink>
						<rich:toolTip for="encaminhado" value="Encaminhado" />
						<rich:toolTip for="emAnalise" value="Analise" />
						<rich:toolTip for="deferido" value="Deferido" />
						<rich:toolTip for="indeferido" value="Indeferido" />
					</rich:column>

					<f:facet name="footer">
						<rich:datascroller id="ds"></rich:datascroller>
					</f:facet>
				</rich:dataTable>
			</a4j:region>
		</rich:panel></center>
	</a4j:form>

</f:view>
</body>
</html>