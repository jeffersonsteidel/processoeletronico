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
			<font size="2"><b>ADICIONAR TITULAÇÃO</b></font>
			<h:panelGrid columns="1">
				<h:outputText id="siapeNome"
					value="#{servidorTitulacaoController.servidorTitulacao.servidor.siape} - #{servidorTitulacaoController.servidorTitulacao.servidor.nome}">
				</h:outputText>
			</h:panelGrid>

			<a4j:region>
				<h:panelGrid columns="4">

					<h:outputText value="Tiulação: " />

					<h:selectOneMenu id="titulacao"
						value="#{servidorTitulacaoController.servidorTitulacao.titulacao.codigo}"
						required="true" requiredMessage="Campo Titulação é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorTitulacaoController.titulacoes}" />
						<a4j:support event="onchange"
							action="#{servidorTitulacaoController.validarTitulacao}"
							ajaxSingle="true" reRender="curso,areaConhecimento,cargaHoraria"></a4j:support>
					</h:selectOneMenu>

					<h:outputText value="Estabelecimento de Ensino: " />

					<h:inputText id="estabelecimentoEnsino"
						requiredMessage="Campo Estabelecimento de Ensino é obrigatório!"
						required="true"
						value="#{servidorTitulacaoController.servidorTitulacao.estabelecimentoEnsino}"
						size="40" maxlength="100"></h:inputText>

					<h:outputText value="Curso: " />

					<h:inputText id="curso" required="true"
						requiredMessage="Campo Curso é obrigatório!" 
						disabled="#{!servidorTitulacaoController.indSuperior}"
						value="#{servidorTitulacaoController.servidorTitulacao.curso}"
						size="40" maxlength="100"></h:inputText>

					<h:outputText value="Area de Conhecimento: " />

					<h:selectOneMenu id="areaConhecimento"
						value="#{servidorTitulacaoController.servidorTitulacao.areaConhecimento.codigo}"
						required="true" disabled="#{!servidorTitulacaoController.indSuperior}"
						requiredMessage="Campo Area de Conhecimento é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems
							value="#{servidorTitulacaoController.areasConhecimento}" />
					</h:selectOneMenu>

					<h:outputText value="Estado do Estabelecimento de Ensino: " />
					<h:selectOneMenu id="estadoEstabelecimento"
						value="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.estado.codigo}"
						required="true"
						disabled="#{servidorTitulacaoController.indTitulacaoEstrangeira}"
						requiredMessage="Campo Estado do Estabelecimento de Ensino é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorTitulacaoController.estados}" />
						<a4j:support event="onchange"
							action="#{servidorTitulacaoController.listarCidadesEstabelecimento}"
							ajaxSingle="true" reRender="cidadeEstabelecimento"></a4j:support>
					</h:selectOneMenu>
					<h:outputText value="Cidade de Estabelecimento de Ensino: " />
					<h:selectOneMenu id="cidadeEstabelecimento"
						value="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.codigo}"
						required="true"
						disabled="#{servidorTitulacaoController.indTitulacaoEstrangeira}"
						requiredMessage="Campo Cidade do Estabelecimento de Ensino é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems
							value="#{servidorTitulacaoController.cidadesEstabelecimento}" />
					</h:selectOneMenu>

					<h:outputText value="Carga Horária: " />

					<h:inputText id="cargaHoraria" required="true"
						requiredMessage="Campo Carga Horária é obrigatório!" disabled="#{!servidorTitulacaoController.indSuperior}"
						value="#{servidorTitulacaoController.servidorTitulacao.cargaHoraria}"
						size="9" maxlength="4" onkeypress="mascara(this,soNumeros);"></h:inputText>

					<h:outputText value="Ano de Conclusão: " />

					<h:inputText id="anoConclusao" required="true"
						requiredMessage="Campo Ano de Conclusão é obrigatório!"
						value="#{servidorTitulacaoController.servidorTitulacao.anoConclusao}"
						size="9" maxlength="4" onkeypress="mascara(this,soNumeros);"
						validatorMessage="Campo Ano de Conclusão deve ter 4 digitos!">
						<f:validateLength minimum="4" />
					</h:inputText>

					<h:outputText value="Registro no Concelho: " />

					<h:inputText id="registroConcelho"
						value="#{servidorTitulacaoController.servidorTitulacao.registroConselho}"
						size="9" maxlength="10"></h:inputText>

					<h:outputText value="Orgão Emissor do Registro: " />

					<h:inputText id="orgaoEmissor"
						value="#{servidorTitulacaoController.servidorTitulacao.orgaoEmissor}"
						size="9" maxlength="8"></h:inputText>

					<h:outputText value="Estado do Orgão Emissor: " />
					<h:selectOneMenu id="estadoEmissor"
						value="#{servidorTitulacaoController.servidorTitulacao.estadoOrgaoEmissor.codigo}">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorTitulacaoController.ufs}" />
					</h:selectOneMenu>

					<h:outputText value="Titulação Estrangeira: " />
					<h:selectBooleanCheckbox id="titulacaoEstrangeira"
						title="Marcar esta opção caso tenha titulação estrangeira!"
						value="#{servidorTitulacaoController.indTitulacaoEstrangeira}">
						<a4j:support event="onchange"
							action="#{servidorTitulacaoController.isTitulacaoEstrangeira}"
							ajaxSingle="true"
							reRender="estadoEstabelecimento, pais, cidadeEstabelecimento"></a4j:support>
					</h:selectBooleanCheckbox>

					<h:outputText value="País: " />
					<h:selectOneMenu id="pais"
						value="#{servidorTitulacaoController.servidorTitulacao.pais.codigo}"
						required="true"
						disabled="#{!servidorTitulacaoController.indTitulacaoEstrangeira}"
						requiredMessage="Campo País de Origem é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorTitulacaoController.paises}" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid columns="2">
					<a4j:commandButton value="Adicionar"
						action="#{servidorTitulacaoController.salvarTitulacao}"
						reRender="listaTitulacoes, titulacao, estabelecimentoEnsino, curso, areaConhecimento, estadoEstabelecimento,
					 cidadeEstabelecimento, cargaHoraria, anoConclusao, registroConcelho, orgaoEmissor, estadoEmissor, titulacaoEstrangeira, pais, listaTitulacoes"
						oncomplete="#{rich:component('confirmPanel')}.show()" />
				</h:panelGrid>
				
				<rich:dataTable id="listaTitulacoes"
					value="#{servidorTitulacaoController.listaServidorTitulacoes}"
					var="list" width="1150px" columnClasses="center" rows="15"
					reRender="ds">
					<rich:column width="500px" sortBy="#{list.titulacao.descricao}">
						<f:facet name="header">
							<h:outputText value="Titulacao" />
						</f:facet>
						<h:outputText value="#{list.titulacao.descricao}" />
					</rich:column>
					<rich:column width="400px" sortBy="#{list.curso}">
						<f:facet name="header">
							<h:outputText value="Curso" />
						</f:facet>
						<h:outputText value="#{list.curso}" />
					</rich:column>
					<rich:column width="400px"
						sortBy="#{list.areaConhecimento.descricao}">
						<f:facet name="header">
							<h:outputText value="Area de Conhecimento" />
						</f:facet>
						<h:outputText value="#{list.areaConhecimento.descricao}" />
					</rich:column>
					<rich:column width="100px" sortBy="#{list.anoConclusao}">
						<f:facet name="header">
							<h:outputText value="Ano de Conclusao" />
						</f:facet>
						<h:outputText value="#{list.anoConclusao}" />
					</rich:column>

					<rich:column>
						<f:facet name="header">
							<h:outputText value="Editar" />
						</f:facet>
						<a4j:commandLink action="#{servidorTitulacaoController.carregar}"
							reRender="listaTitulacoes" ajaxSingle="true">
							<h:graphicImage value="../images/edit.gif" style="border:0"
								width="20" height="18" id="editar" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{servidorTitulacaoController.servidorTitulacao.codigo}" />
						</a4j:commandLink>
						<rich:toolTip for="editar" value="Editar" />
					</rich:column>

					<rich:column>
						<f:facet name="header">
							<h:outputText value="Excluir" />
						</f:facet>
						<a4j:commandLink ajaxSingle="true" id="delete" reRender="form"
							oncomplete="#{rich:component('deletePanel')}.show()">
							<h:graphicImage id="excluir" value="../images/delete.gif"
								style="border:0" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{servidorTitulacaoController.servidorTitulacao.codigo}" />
						</a4j:commandLink>
						<rich:toolTip for="excluir" value="Excluir" />
					</rich:column>
					<f:facet name="footer">
						<rich:datascroller id="ds"></rich:datascroller>
					</f:facet>
				</rich:dataTable>
			</a4j:region>
		</rich:panel></center>
	</a4j:form>
	<center><rich:modalPanel id="confirmPanel" autosized="false"
		style="overflow: auto;"
		showWhenRendered="#{not empty facesContext.maximumSeverity}">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Verificar Campos"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="../images/close.gif"
					onclick="#{rich:component('confirmPanel')}.hide();" />
			</h:panelGroup>
		</f:facet>
		<h:form>
			<table width="100%" height="100%">
				<tbody>
					<tr>
						<td><rich:messages layout="list" errorLabelClass="errorLabel"
							style="top:auto;" infoLabelClass="infoLabel">
							<f:facet name="infoMarker">
								<h:graphicImage value="../images/passed.gif" />
							</f:facet>
							<f:facet name="errorMarker">
								<h:graphicImage value="../images/error.gif" />
							</f:facet>
						</rich:messages></td>
					</tr>
				</tbody>
			</table>
		</h:form>
	</rich:modalPanel> <rich:modalPanel id="deletePanel" autosized="true" width="200">
		<f:facet name="header">
			<h:outputText value="Deseja realmente deletar este item?"
				style="padding-right:15px;" />
		</f:facet>
		<h:form>
			<table width="100%">
				<tbody>
					<tr>
						<td align="center" width="50%"><a4j:commandButton value="Sim"
							ajaxSingle="true" action="#{servidorTitulacaoController.remover}"
							oncomplete="#{rich:component('deletePanel')}.hide();"
							reRender="listaTitulacoes, form" /></td>
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