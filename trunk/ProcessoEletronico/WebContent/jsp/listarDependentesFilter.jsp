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
	<center><a4j:form id="form">
		<rich:panel>
			<rich:messages id="messages" layout="list"
				errorLabelClass="errorLabel" style="top:auto;"
				infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<font size="2"><b>PESQUISAR DEPENDENTES</b></font>
			<h:panelGrid columns="15">

				<h:outputText value="Siape: ">
				</h:outputText>
				<h:inputText
					value="#{dependenteController.dependenteFilter.servidor.siape}"
					size="7" maxlength="7" onkeyup="mascara(this, soNumeros);">
				</h:inputText>

				<h:outputText value="Servidor: ">
				</h:outputText>
				<h:inputText
					value="#{dependenteController.dependenteFilter.servidor.nome}"
					size="25">
				</h:inputText>

				<h:outputText value="Dependente: ">
				</h:outputText>
				<h:inputText value="#{dependenteController.dependenteFilter.nome}"
					size="25">
				</h:inputText>

				<h:outputText value="Parentesco: " />
				<h:selectOneMenu
					value="#{dependenteController.dependenteFilter.grauParentesco.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{dependenteController.grausParentescos}" />
				</h:selectOneMenu>

				<h:outputText value="Status: " />
				<h:selectOneMenu
					value="#{dependenteController.dependenteFilter.statusSolicitacao.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{dependenteController.statusSolicitacoes}" />
				</h:selectOneMenu>

				<h:outputText value="Sit. Dependente: " />
				<h:selectOneMenu value="#{dependenteController.ativo}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="ATIVOS" itemValue="1" />
					<f:selectItem itemLabel="INATIVOS" itemValue="2" />
				</h:selectOneMenu>

				<h:outputText value="Sit. Servidor: " />
				<h:selectOneMenu value="#{dependenteController.situacao}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="ATIVOS" itemValue="1" />
					<f:selectItem itemLabel="INATIVOS" itemValue="2" />
				</h:selectOneMenu>

				<a4j:commandButton value="Pesquisar"
					action="#{dependenteController.pesquisarDependentesFiltro}"
					reRender="listaDependentes" type="submit" />
			</h:panelGrid>

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

				<rich:column width="30px">
					<f:facet name="header">
						<h:outputText value="Visualizar" />
					</f:facet>
					<a4j:commandLink action="#{dependenteController.validar}"
						reRender="listaDependentes, painel"
						oncomplete="Richfaces.showModalPanel('painel')" ajaxSingle="true">
						<h:graphicImage value="../images/encaminhado.png" style="border:0"
							width="20" height="18" id="encaminhado"
							rendered="#{list.statusSolicitacao.codigo == 1}" />
						<h:graphicImage value="../images/indeferido.gif" style="border:0"
							width="20" height="18" id="indeferido"
							rendered="#{list.statusSolicitacao.codigo == 4}" />
						<h:graphicImage value="../images/deferido.gif" style="border:0"
							width="20" height="18" id="deferido"
							rendered="#{list.statusSolicitacao.codigo == 3}" />
						<f:setPropertyActionListener value="#{list}"
							target="#{dependenteController.dependente}" />
					</a4j:commandLink>
					<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 2}"
						action="#" reRender="listaDependentes" ajaxSingle="true">
						<h:graphicImage value="../images/analize.gif" style="border:0"
							width="20" height="18" id="emAnalise" />
					</a4j:commandLink>
					<rich:toolTip for="encaminhado" value="Encaminhado" />
					<rich:toolTip for="emAnalise"
						value="Você não pode abrir uma solicitação que está em Análise!" />
					<rich:toolTip for="deferido" value="Deferido" />
					<rich:toolTip for="indeferido" value="Indeferido" />
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