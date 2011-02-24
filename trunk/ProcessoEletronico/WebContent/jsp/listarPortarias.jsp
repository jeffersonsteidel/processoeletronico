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
		    <font size="2"><b>LISTAR PORTARIAS</b></font>
			<h:panelGrid columns="13">
				<h:outputText value="Número: ">
				</h:outputText>
				<h:inputText value="#{portariaController.portariaFilter.numero}" size="10"
					maxlength="7" onkeyup="mascara(this, soNumeros);">
				</h:inputText>

				<h:outputText value="Nome: ">
				</h:outputText>
				<h:inputText value="#{portariaController.portariaFilter.nome}" size="50">
				</h:inputText>

				<h:outputText value="Data: " />
				<rich:calendar value="#{portariaController.dataInicio}" locale=""
					popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:30px"
					inputSize="10" />

				<h:outputText value="à" />
				<rich:calendar value="#{portariaController.dataFinal}" locale=""
					popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:30px"
					inputSize="10" />

				<h:outputText value="Tipo Portaria: " />
				<h:selectOneMenu value="#{portariaController.portariaFilter.tipo.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{portariaController.tiposPortaria}" />
				</h:selectOneMenu>

				<h:outputText value="Local: ">
				</h:outputText>
				<h:selectOneMenu value="#{portariaController.portariaFilter.local}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItem itemLabel="REITORIA" itemValue="reitoria" />
					<f:selectItem itemLabel="PROGEPE" itemValue="progepe" />
				</h:selectOneMenu>

				<a4j:commandButton value="Pesquisar"
					action="#{portariaController.pesquisarPortarias}"
					reRender="listarPortarias" type="submit" />
			</h:panelGrid>

			<rich:messages layout="list">
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<rich:dataTable id="listaPortarias"
				value="#{portariaController.portariaList}" var="list" width="1150px"
				columnClasses="center" rows="15" reRender="ds">
				<rich:column width="50px" sortBy="#{list.numero}">
					<f:facet name="header">
						<h:outputText value="Numero" />
					</f:facet>
					<h:outputText value="#{list.numero}" />
				</rich:column>

				<rich:column width="420px" sortBy="#{list.nome}">
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{list.nome}" />
				</rich:column>

				<rich:column width="280px" sortBy="#{list.data}">
					<f:facet name="header">
						<h:outputText value="Data" />
					</f:facet>
					<h:outputText value="#{list.data}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
				</rich:column>

				<rich:column width="280px" sortBy="#{list.tipo.descricao}">
					<f:facet name="header">
						<h:outputText value="Tipo" />
					</f:facet>
					<h:outputText value="#{list.tipo.descricao}" />
				</rich:column>

				<rich:column width="280px" sortBy="#{list.local}">
					<f:facet name="header">
						<h:outputText value="Local" />
					</f:facet>
					<h:outputText value="#{list.local}" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Editar" />
					</f:facet>
					<a4j:commandLink action="#{portariaController.carregar}"
						reRender="listaPortarias" ajaxSingle="true">
						<h:graphicImage value="../images/edit.gif" style="border:0"
							width="20" height="18" id="editar" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{portariaController.portaria.codigo}" />
					</a4j:commandLink>
					<rich:toolTip for="editar" value="Editar" />
				</rich:column>

				<rich:column rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}">
					<f:facet name="header">
						<h:outputText value="Excluir" />
					</f:facet>
					<a4j:commandLink ajaxSingle="true" id="delete"
						oncomplete="#{rich:component('deletePanel')}.show()">
						<h:graphicImage id="excluir" value="../images/delete.gif"
							style="border:0" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{portariaController.portaria.codigo}" />
					</a4j:commandLink>
					<rich:toolTip for="excluir" value="Excluir" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Visualizar" />
					</f:facet>
					
					<a4j:commandLink action="#{portariaController.carregarPortaria}"
						reRender="listaPortarias" ajaxSingle="true">
						<h:graphicImage value="../images/visualizar.gif" style="border:0"
							width="20" height="18" id="visualizar" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{portariaController.portaria.codigo}" />
					</a4j:commandLink>
					<rich:toolTip for="visualizar" value="Visualizar" />
				</rich:column>

				<f:facet name="footer">
					<rich:datascroller id="ds"></rich:datascroller>
				</f:facet>
			</rich:dataTable>
		</rich:panel>
	</a4j:form> <rich:modalPanel id="deletePanel" autosized="true" width="200">
		<f:facet name="header">
			<h:outputText value="Deseja realmente deletar este item?"
				style="padding-right:15px;" />
		</f:facet>
		<h:form>
			<table width="100%">
				<tbody>
					<tr>
						<td align="center" width="50%"><a4j:commandButton value="Sim"
							ajaxSingle="true" action="#{portariaController.excluir}"
							oncomplete="#{rich:component('deletePanel')}.hide();"
							reRender="listaEstado, form" /></td>
						<td align="center" width="50%"><a4j:commandButton value="Não"
							onclick="#{rich:component('deletePanel')}.hide();return false;" />
						</td>
					</tr>
				</tbody>
			</table>
		</h:form>
	</rich:modalPanel></center>
	
</f:view>
</body>
</html>
