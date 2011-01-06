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
			<font size="2"><b>PESQUISAR TITULAÇÕES</b></font>
				<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<h:panelGrid columns="13">
				<h:outputText value="Siape: ">
				</h:outputText>
				<h:inputText
					value="#{servidorTitulacaoController.servidorTitulacao.servidor.siape}"
					size="7" maxlength="7" onkeyup="mascara(this, soNumeros);">
				</h:inputText>
				<h:outputText value="Nome: ">
				</h:outputText>
				<h:inputText
					value="#{servidorTitulacaoController.servidorTitulacao.servidor.nome}"
					size="35">
				</h:inputText>
				<h:outputText value="Titulação: " />
				<h:selectOneMenu
					value="#{servidorTitulacaoController.servidorTitulacao.titulacao.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{servidorTitulacaoController.titulacoes}" />
				</h:selectOneMenu>

				<h:outputText value="Area Conhecimento: " />
				<h:selectOneMenu
					value="#{servidorTitulacaoController.servidorTitulacao.areaConhecimento.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems
						value="#{servidorTitulacaoController.areasConhecimento}" />
				</h:selectOneMenu>
				<h:outputText value="Validados: " />
				<h:selectOneMenu value="#{servidorTitulacaoController.validado}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="SIM" itemValue="1" />
					<f:selectItem itemLabel="NÃO" itemValue="2" />
				</h:selectOneMenu>
				<h:outputText value="Situação: " />
				<h:selectOneMenu value="#{servidorTitulacaoController.situacao}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="ATIVOS" itemValue="1" />
					<f:selectItem itemLabel="INATIVOS" itemValue="2" />
				</h:selectOneMenu>
				<a4j:commandButton value="Pesquisar"
					action="#{servidorTitulacaoController.listarTitulacoesFiltro}"
					reRender="listaTitulacoes" type="submit" />
			</h:panelGrid>

			<rich:dataTable id="listaTitulacoes"
				value="#{servidorTitulacaoController.listaTitulacoes}" var="list"
				width="1150px" columnClasses="center" rows="15" reRender="ds">
				<rich:column width="50px" sortBy="#{list.servidor.siape}">
					<f:facet name="header">
						<h:outputText value="Siape" />
					</f:facet>
					<h:outputText value="#{list.servidor.siape}" />
				</rich:column>

				<rich:column width="420px" sortBy="#{list.servidor.nome}">
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{list.servidor.nome}" />
				</rich:column>

				<rich:column width="280px" sortBy="#{list.titulacao.descricao}">
					<f:facet name="header">
						<h:outputText value="Titulação" />
					</f:facet>
					<h:outputText value="#{list.titulacao.descricao}" />
				</rich:column>

				<rich:column width="280px"
					sortBy="#{list.areaConhecimento.descricao}">
					<f:facet name="header">
						<h:outputText value="Area de Conhecimento" />
					</f:facet>
					<h:outputText value="#{list.areaConhecimento.descricao}" />
				</rich:column>

				<rich:column width="100px" sortBy="#{list.indValidado}">
					<f:facet name="header">
						<h:outputText value="Validado" />
					</f:facet>
					<h:outputText value="SIM" rendered="#{list.indValidado}" />
					<h:outputText value="NÃO" rendered="#{!list.indValidado}" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Visualizar" />
					</f:facet>
					<a4j:commandLink
						action="#{servidorTitulacaoController.carregarTitulacao}"
						reRender="editPanel" ajaxSingle="true"
						oncomplete="#{rich:component('editPanel')}.show()">
						<h:graphicImage value="../images/edit.gif" style="border:0"
							width="20" height="18" id="editar" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{empregoController.emprego.codigo}" />
					</a4j:commandLink>
					<rich:toolTip for="visualizar" value="Visualizar" />
				</rich:column>



				<f:facet name="footer">
					<rich:datascroller id="ds"></rich:datascroller>
				</f:facet>
			</rich:dataTable>
		</rich:panel>
	</a4j:form></center>
	<center><rich:modalPanel id="editPanel" autosized="true"
		width="600">
		<h:form>
			<center><font size="2"><b>DETALHES DA TITULAÇÃO</b></font> <h:panelGrid
				columns="2">
				<h:outputText value="Servidor: " />
				<h:outputText
					value="#{servidorTitulacaoController.servidorTitulacao.servidor.nome}" />
			</h:panelGrid> <h:panelGrid columns="4">
				<h:outputText value="Titulação: " />
				<h:outputText
					value="#{servidorTitulacaoController.servidorTitulacao.titulacao.descricao}"></h:outputText>
				<h:outputText value="Curso: "
					rendered="#{servidorTitulacaoController.servidorTitulacao.curso != null}" />
				<h:outputText
					value="#{servidorTitulacaoController.servidorTitulacao.curso}"
					rendered="#{servidorTitulacaoController.servidorTitulacao.curso != null}"></h:outputText>
				<h:outputText value="Area de Conhecimento: "
					rendered="#{servidorTitulacaoController.servidorTitulacao.areaConhecimento.descricao != null}" />
				<h:outputText
					value="#{servidorTitulacaoController.servidorTitulacao.areaConhecimento.descricao}"
					rendered="#{servidorTitulacaoController.servidorTitulacao.areaConhecimento.descricao != null}"></h:outputText>
				<h:outputText value="Estabelecimento de Ensino: "
					rendered="#{servidorTitulacaoController.servidorTitulacao.estabelecimentoEnsino != null}" />
				<h:outputText
					value="#{servidorTitulacaoController.servidorTitulacao.estabelecimentoEnsino}"
					rendered="#{servidorTitulacaoController.servidorTitulacao.estabelecimentoEnsino != null}"></h:outputText>
				<h:outputText value="Estado do Estabelecimento: "
					rendered="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.estado.descricao != null}" />
				<h:outputText
					value="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.estado.uf}"
					rendered="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.estado.descricao != null}"></h:outputText>
				<h:outputText value="Cidade do Estabelecimento: "
					rendered="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.descricao!= null}" />
				<h:outputText
					value="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.descricao}"
					rendered="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.descricao!= null}"></h:outputText>
				<h:outputText value="Pais do Estabelecimento: "
					rendered="#{servidorTitulacaoController.servidorTitulacao.pais.descricao != null}" />
				<h:outputText
					value="#{servidorTitulacaoController.servidorTitulacao.pais.descricao}"
					rendered="#{servidorTitulacaoController.servidorTitulacao.pais.descricao != null}"></h:outputText>
				<h:outputText value="Carga Horária: "
					rendered="#{servidorTitulacaoController.servidorTitulacao.cargaHoraria != null}" />
				<h:outputText
					value="#{servidorTitulacaoController.servidorTitulacao.cargaHoraria}"
					rendered="#{servidorTitulacaoController.servidorTitulacao.cargaHoraria != null}"></h:outputText>
				<h:outputText value="Ano de Conclusão: "
					rendered="#{servidorTitulacaoController.servidorTitulacao.anoConclusao != null}" />
				<h:outputText
					value="#{servidorTitulacaoController.servidorTitulacao.anoConclusao}"
					rendered="#{servidorTitulacaoController.servidorTitulacao.anoConclusao != null}"></h:outputText>
				<h:outputText value="Registro no Conselho: "
					rendered="#{servidorTitulacaoController.servidorTitulacao.registroConselho != null && servidorTitulacaoController.servidorTitulacao.registroConselho != ''}" />
				<h:outputText
					value="#{servidorTitulacaoController.servidorTitulacao.registroConselho}"
					rendered="#{servidorTitulacaoController.servidorTitulacao.registroConselho != null && servidorTitulacaoController.servidorTitulacao.registroConselho != ''}"></h:outputText>
				<h:outputText value="Orgão Emissor do Registro: "
					rendered="#{servidorTitulacaoController.servidorTitulacao.orgaoEmissor != null && servidorTitulacaoController.servidorTitulacao.orgaoEmissor != ''}" />
				<h:outputText
					value="#{servidorTitulacaoController.servidorTitulacao.orgaoEmissor}"
					rendered="#{servidorTitulacaoController.servidorTitulacao.orgaoEmissor != null && servidorTitulacaoController.servidorTitulacao.orgaoEmissor != ''}"></h:outputText>
				<h:outputText value="UF do Orgão Emissor: "
					rendered="#{servidorTitulacaoController.servidorTitulacao.estadoOrgaoEmissor.uf != null}" />
				<h:outputText
					value="#{servidorTitulacaoController.servidorTitulacao.estadoOrgaoEmissor.uf}"
					rendered="#{servidorTitulacaoController.servidorTitulacao.estadoOrgaoEmissor.uf != null}"></h:outputText>
			</h:panelGrid> <h:panelGrid columns="2">
				<a4j:commandButton value="Aprovar" reRender="form, listaTitulacoes"
					action="#{servidorTitulacaoController.validar}" />
				<a4j:commandButton value="Fechar"
					onclick="#{rich:component('editPanel')}.hide();return false;" />
			</h:panelGrid></center>
		</h:form>
	</rich:modalPanel></center>
</f:view>
</body>
</html>