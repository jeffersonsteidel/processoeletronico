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
			<font size="2"><b>PESQUISAR FUNÇÕES</b></font>
			<rich:messages layout="list">
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<rich:dataTable id="listafuncoes"
				value="#{funcaoController.funcoesList}" var="list" width="1160px"
				columnClasses="center" rows="15" reRender="ds">
				<rich:column width="120px" sortBy="#{list.tipoFuncao.descricao}"
					filterBy="#{list.tipoFuncao.descricao}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Tipo da Função" />
					</f:facet>
					<h:outputText value="#{list.tipoFuncao.descricao}" />
				</rich:column>

				<rich:column width="900px" sortBy="#{list.descricao}"
					filterBy="#{list.descricao}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Função" />
					</f:facet>
					<h:outputText value="#{list.descricao}" />
				</rich:column>

			
				<rich:column width="250px" sortBy="#{list.atoCriacao}"
					filterBy="#{list.atoCriacao}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Ato de Criação" />
					</f:facet>
					<h:outputText value="#{list.atoCriacao}" />
				</rich:column>
			
				<rich:column width="250px" sortBy="#{list.dataExtincao}"
					filterBy="#{list.dataExtincao}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Data de Extinção" />
					</f:facet>
					<h:outputText value="#{list.dataExtincao}" />
				</rich:column>

				<rich:column width="250px" sortBy="#{list.funcaoAnterior.descricao}"
					filterBy="#{list.funcaoAnterior.descricao}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Função anterior" />
					</f:facet>
					<h:outputText value="#{list.funcaoAnterior.descricao}" />
				</rich:column>
				

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Editar" />
					</f:facet>
					<a4j:commandLink action="#{funcaoController.carregar}"
						reRender="listarServidores" ajaxSingle="true">
						<h:graphicImage value="../images/edit.gif" style="border:0"
							width="20" height="18" id="editar" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{funcaoController.funcao.codigo}" />
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