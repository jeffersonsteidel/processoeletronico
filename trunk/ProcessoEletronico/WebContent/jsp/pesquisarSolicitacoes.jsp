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
				
				<h:outputText value="Status: " />
				<h:selectOneMenu value="#{solicitacaoController.solicitacao.statusSolicitacao.descricao}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{solicitacaoController.solicitacoes}" />
				</h:selectOneMenu>

				<a4j:commandButton value="Pesquisar"
					action="#"
					reRender="#" type="submit" />
			</h:panelGrid>

			<rich:messages layout="list">
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<rich:dataTable id="listaSolicitacoes"
				value="#{solicitacaoController.solicitacoes}" var="list"
				width="1150px" columnClasses="center" rows="15" reRender="ds">
				<rich:column width="50px" sortBy="#{list.solicitante.siape}">
					<f:facet name="header">
						<h:outputText value="Siape" />
					</f:facet>
					<h:outputText value="#{list.solicitante.siape}" />
				</rich:column>

				<rich:column width="420px" sortBy="#{list.solicitante.nome}">
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{list.solicitante.nome}" />
				</rich:column>

				<rich:column width="280px" sortBy="#{list.statusSolicitacao.descricao}">
					<f:facet name="header">
						<h:outputText value="Status" />
					</f:facet>
					<h:outputText value="#{list.statusSolicitacao.descricao}" />
				</rich:column>

				
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Editar" />
					</f:facet>
					<a4j:commandLink action="#"
						reRender="#" ajaxSingle="true">
						<h:graphicImage value="../images/edit.gif" style="border:0"
							width="20" height="18" id="editar" />
						<f:setPropertyActionListener value="#"
							target="#" />
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