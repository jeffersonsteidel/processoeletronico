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
	<jsp:directive.include file="menus.jsp" />
	<center><a4j:form id="form">
		<rich:panel>
			<font size="2"><b>LISTAR LOTAÇÕES</b></font>

			<rich:messages layout="list">
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<rich:dataTable id="listarLotacoes"
				value="#{lotacaoController.lotacaoList}" var="list" width="1000px"
				columnClasses="center" rows="15" reRender="ds">
				<rich:column width="50px" sortBy="#{list.codigo}"
					filterBy="#{list.codigo}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Código" />
					</f:facet>
					<h:outputText value="#{list.codigo}" />
				</rich:column>

				<rich:column width="200px" sortBy="#{list.descricao}"
					filterBy="#{list.descricao}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Campus" />
					</f:facet>
					<h:outputText value="#{list.descricao}" />
				</rich:column>

				<rich:column width="200px" sortBy="#{list.diretorAdministrativo}"
					filterBy="#{list.descricao}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Diretor Administrativo" />
					</f:facet>
					<h:outputText value="#{list.diretorAdministrativo}" />
				</rich:column>

				<rich:column width="200px" sortBy="#{list.diretorGeral}"
					filterBy="#{list.descricao}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Diretor Geral" />
					</f:facet>
					<h:outputText value="#{list.diretorGeral}" />
				</rich:column>

				<rich:column width="200px" sortBy="#{list.endereco}"
					filterBy="#{list.descricao}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Endereço" />
					</f:facet>
					<h:outputText rendered="#{list.endereco.rua != null}"
						value="#{list.endereco.rua}, #{endereco.numero} - #{endereco.bairro}
					 - #{endereco.complemento}- #{endereco.cep} - #{endereco.cidade.descricao}" />
					<h:outputText rendered="#{list.endereco.rua == null}" value="" />
				</rich:column>

				<rich:column width="50px">
					<f:facet name="header">
						<h:outputText value="Editar" />
					</f:facet>
					<a4j:commandLink action="#{lotacaoController.carregar}"
						reRender="listarLotacoes" ajaxSingle="true">
						<h:graphicImage value="../images/edit.gif" style="border:0"
							width="20" height="18" id="editar" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{lotacaoController.lotacao.codigo}" />
						<f:setPropertyActionListener value="#{list.endereco.cidade.estado.codigo}"
							target="#{lotacaoController.lotacao.endereco.cidade.estado.codigo}" />
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