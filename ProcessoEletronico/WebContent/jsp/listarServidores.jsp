<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instituto Federal do Paran�</title>
</head>
<body>
<f:view>
	<center><a4j:form id="form">
		<rich:panel header="Servidores"
			style="width: 1100px;  position: absolute; left: 30px; top: auto;">
			<rich:messages layout="list">
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<rich:dataTable id="listaServidores" value="#{servidorController.servidores}"
				var="list" width="1000px" columnClasses="center" rows="30"
				reRender="ds">
				<rich:column width="50px" sortBy="#{list.siape}"
					filterBy="#{list.siape}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Siape" />
					</f:facet>
					<h:outputText value="#{list.siape}" />
				</rich:column>
				
				<rich:column width="400px" sortBy="#{list.nome}"
					filterBy="#{list.nome}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{list.nome}" />
				</rich:column>
				
				<rich:column width="280px" sortBy="#{list.lotacao.descricao}"
					filterBy="#{list.lotacao.descricao}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Lota��o" />
					</f:facet>
					<h:outputText value="#{list.lotacao.descricao}" />
				</rich:column>
				
				<rich:column width="280px" sortBy="#{list.documento.cpf}"
					filterBy="#{list.documento.cpf}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="CPF" />
					</f:facet>
					<h:outputText value="#{list.documento.cpf}" />
				</rich:column>
				
				<rich:column width="250px" sortBy="#{list.situacaoFuncional.descricao}"
					filterBy="#{list.situacaoFuncional.descricao}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Situa��o Funcional" />
					</f:facet>
					<h:outputText value="#{list.situacaoFuncional.descricao}" />
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