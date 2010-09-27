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
	<center><a4j:form id="form">
		<rich:panel header="Lotações"
			style="width: 1000px;  position: absolute; left: 30px; top: auto;">
			<rich:messages layout="list">
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<rich:dataTable id="listaLotacoes"
				value="#{lotacaoController.lotacaoList}" var="list" width="950px"
				columnClasses="center" rows="10" reRender="ds">
				<rich:column width="450px" sortBy="#{list.descricao}"
					filterBy="#{list.descricao}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Campus" />
					</f:facet>
					<h:outputText value="#{list.descricao}" />
				</rich:column>

				<rich:column sortBy="#{list.telefone}" filterBy="#{list.telefone}"
					filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Telefone" />
					</f:facet>
					<h:outputText value="#{list.telefone}" />
				</rich:column>
				<rich:column sortBy="#{list.site}" filterBy="#{list.site}"
					filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Site" />
					</f:facet>
					<h:outputText value="#{list.site}" />
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Editar" />
					</f:facet>
					<a4j:commandLink action="#{lotacaoController.carregar}"
						reRender="listaLotacoes" ajaxSingle="true">
						<h:graphicImage value="../images/edit.gif" style="border:0"
							width="20" height="18" id="editar" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{lotacaoController.lotacao.codigo}" />
						<f:setPropertyActionListener value="#{list.endereco.codigo}"
							target="#{lotacaoController.lotacao.endereco.codigo}" />	
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