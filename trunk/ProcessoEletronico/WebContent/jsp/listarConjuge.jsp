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

			<font size="2"><b>PESQUISAR CÔNJUGE</b></font>
			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<h:panelGrid columns="11">
				<h:outputText value="Siape do Servidor:" />
				<h:inputText value="#{conjugeController.conjugeFilter.servidor.siape}"
					size="7" maxlength="7" onkeyup="mascara(this, soNumeros);"></h:inputText>
				<h:outputText value="Nome do Servidor:" />
				<h:inputText value="#{conjugeController.conjugeFilter.servidor.nome}"
					size="60" maxlength="120"></h:inputText>
				<h:outputText value="Atuais: " />
				<h:selectOneMenu value="#{conjugeController.atuais}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="SIM" itemValue="1" />
					<f:selectItem itemLabel="NÃO" itemValue="2" />
				</h:selectOneMenu>		
				<h:outputText value="Status: " />
				<h:selectOneMenu
					value="#{conjugeController.conjugeFilter.statusSolicitacao.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{conjugeController.statusSolicitacoes}" />
				</h:selectOneMenu>
				<h:outputText value="Situação do Servidor: " />
				<h:selectOneMenu value="#{conjugeController.situacao}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="ATIVOS" itemValue="1" />
					<f:selectItem itemLabel="INATIVOS" itemValue="2" />
				</h:selectOneMenu>
				<a4j:commandButton value="Pesquisar"
					action="#{conjugeController.buscarConjuges}"
					reRender="listaConjuges" type="submit" />
			</h:panelGrid>
			<a4j:region>

				<rich:dataTable id="listaConjuges"
					value="#{conjugeController.listaConjugesByFilter}" var="list"
					width="1150px" columnClasses="center" rows="15">
					<rich:column width="80px" sortBy="#{list.servidor.siape}">
						<f:facet name="header">
							<h:outputText value="Siape" />
						</f:facet>
						<h:outputText value="#{list.servidor.siape}" />
					</rich:column>
					<rich:column width="500px" sortBy="#{list.servidor.nome}">
						<f:facet name="header">
							<h:outputText value="Servidor" />
						</f:facet>
						<h:outputText value="#{list.servidor.nome}" />
					</rich:column>
					<rich:column width="550px" sortBy="#{list.nome}">
						<f:facet name="header">
							<h:outputText value="Nome do Cônjuge" />
						</f:facet>
						<h:outputText value="#{list.nome}" />
					</rich:column>
					<rich:column width="280px" sortBy="#{list.atual}">
						<f:facet name="header">
							<h:outputText value="Atual" />
						</f:facet>
						<h:outputText value="Atual" rendered="#{list.atual}" />
						<h:outputText value="Ex" rendered="#{!list.atual}" />
					</rich:column>
					<rich:column width="30px">
					<f:facet name="header">
						<h:outputText value="Visualizar" />
					</f:facet>
					<a4j:commandLink action="#{conjugeController.validar}"
						reRender="listaConjuges, painel"
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
							target="#{conjugeController.conjuge}" />
					</a4j:commandLink>
					<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 2}"
						action="#" reRender="listaConjuges" ajaxSingle="true">
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
			</a4j:region>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>