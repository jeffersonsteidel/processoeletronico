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
			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<font size="2"><b>INCENTIVO A QUALIFICAÇÃO</b></font>
			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoController.solicitacaoIncentivoQualificacao.solicitante.siape} - #{solicitacaoController.solicitacaoIncentivoQualificacao.solicitante.nome}">
				</h:outputText>
				<h:outputText
					value="Cargo: #{solicitacaoController.solicitacaoIncentivoQualificacao.solicitante.cargo.descricao}">
				</h:outputText>
			</h:panelGrid>
			<br>
			<h:outputText value="Titulação selecionada: " id="labelDados"
				rendered="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.codigo != 0 && solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.codigo != null}">
			</h:outputText>
			<h:panelGrid columns="4" id="dados"
				rendered="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.codigo != 0 && solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.codigo != null}">
				<h:outputText value="Tiulação: " />
				<h:outputText
					value="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.titulacao.descricao}" />
				<h:outputText value="Estabelecimento de Ensino: " />
				<h:outputText styleClass="maiusculo"
					value="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.estabelecimentoEnsino}" />

				<h:outputText value="Curso: " />
				<h:outputText styleClass="maiusculo"
					value="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.curso}" />


				<h:outputText value="Estado do Estabelecimento de Ensino: "
					rendered="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.cidadeEstabelecimentoEnsino.estado.codigo != 0}" />
				<h:outputText
					rendered="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.cidadeEstabelecimentoEnsino.estado.codigo != 0}"
					value="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.cidadeEstabelecimentoEnsino.estado.descricao}">
				</h:outputText>

				<h:outputText value="Area de Conhecimento: " />
				<h:outputText
					value="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.areaConhecimento.descricao}" />

				<h:outputText value="Cidade de Estabelecimento de Ensino: " />
				<h:outputText
					rendered="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.cidadeEstabelecimentoEnsino.codigo != 0}"
					value="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.cidadeEstabelecimentoEnsino.descricao}">
				</h:outputText>

				<h:outputText value="Carga Horária: " />
				<h:outputText
					value="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.cargaHoraria}"></h:outputText>

				<h:outputText value="Ano de Conclusão: "
					rendered="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.anoConclusao != null}" />

				<h:outputText
					rendered="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.anoConclusao != null}"
					value="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.anoConclusao}">
				</h:outputText>

				<h:outputText value="Registro no Conselho: "
					rendered="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.registroConselho != '' && solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.registroConselho != null}" />

				<h:outputText
					rendered="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.registroConselho != '' && solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.registroConselho != null}"
					value="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.registroConselho}"></h:outputText>

				<h:outputText value="Orgão Emissor do Registro: "
					rendered="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.orgaoEmissor != '' && solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.orgaoEmissor != null}" />

				<h:outputText styleClass="maiusculo"
					rendered="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.orgaoEmissor != '' && solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.orgaoEmissor != null}"
					value="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.orgaoEmissor}"></h:outputText>

				<h:outputText value="Estado do Orgão Emissor: "
					rendered="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.estadoOrgaoEmissor != null && solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.estadoOrgaoEmissor != ''}" />
				<h:outputText
					rendered="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.estadoOrgaoEmissor != null && solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.estadoOrgaoEmissor != ''}"
					value="#{solicitacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.estadoOrgaoEmissor.descricao}">
				</h:outputText>
			</h:panelGrid>
			<h:panelGrid columns="1" id="documentos">
				<h:outputText styleClass="negrito"
					value="Nenhum Documento apresentado!"
					rendered="#{empty solicitacaoController.documentos}" />
				<h:outputText value="Documentos apresentados:"
					rendered="#{not empty servidorTitulacaoController.documentos}" />
				<rich:dataTable id="listaDocumento"
					rendered="#{not empty  solicitacaoController.documentos}"
					value="#{ solicitacaoController.documentos}" var="list"
					width="600px" columnClasses="center" rows="15" reRender="ds">

					<rich:column width="550px">
						<f:facet name="header">
							<h:outputText value="Tipo Documento" />
						</f:facet>
						<h:outputText value="#{list.tipoDocumento.descricao}" />
					</rich:column>

					<rich:column width="50px">
						<f:facet name="header">
							<h:outputText value="Visualizar" />
						</f:facet>
						<a4j:commandLink
							action="#{documentoImagemController.verDocumentos}"
							reRender="editPanel" ajaxSingle="true">
							<h:graphicImage value="../images/visualizar.gif" style="border:0"
								width="20" height="18" id="visualizar" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{documentoImagemController.documentoImagem.codigo}" />
						</a4j:commandLink>
						<rich:toolTip for="visualizar" value="Visualizar" />
					</rich:column>
				</rich:dataTable>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectOneRadio id="radios"
					value="#{solicitacaoController.solicitacaoIncentivoQualificacao.indQualificacaoDireta}">
					<f:selectItem itemValue="true" itemLabel="Direta" />
					<f:selectItem itemValue="false" itemLabel="Indireta" />
				</h:selectOneRadio>
			</h:panelGrid>
			<h:panelGrid columns="2" style="text-align: center;">
				<h:outputText value="Justificativa: " />
				<h:inputTextarea id="justificativa"
					disabled="#{solicitacaoController.solicitacaoIncentivoQualificacao.statusSolicitacao.codigo != 2}"
					value="#{solicitacaoController.solicitacaoIncentivoQualificacao.justificativa}"
					cols="50" rows="5">
				</h:inputTextarea>
			</h:panelGrid>
			<h:panelGrid columns="2" id="botoes">
				<a4j:commandButton value="Encaminhar a DIGEP"
					reRender="confirmPanel"
					disabled="#{solicitacaoController.solicitacaoIncentivoQualificacao.statusSolicitacao.codigo != 2}"
					oncomplete="#{rich:component('confirmPanel')}.show()" />
				<a4j:commandButton value="Indeferir" reRender="confirmPanel02"
					disabled="#{solicitacaoController.solicitacaoIncentivoQualificacao.statusSolicitacao.codigo != 2}"
					oncomplete="#{rich:component('confirmPanel02')}.show()" />
			</h:panelGrid>
			<h:panelGrid columns="2">
				<a4j:commandButton value="Voltar" id="voltar"
					rendered="#{solicitacaoController.solicitacaoIncentivoQualificacao.statusSolicitacao.codigo > 2}"
					action="#{solicitacaoController.retornarUltimaPesquisa}" />
			</h:panelGrid>
		</rich:panel></center>

		<rich:modalPanel id="confirmPanel" autosized="true" width="200">
			<f:facet name="header">
				<h:outputText value="Confirma esta Operação?"
					style="padding-right:15px;" />
			</f:facet>
			<h:form>
				<table width="100%">
					<tbody>
						<tr>
							<td align="center" width="50%"><a4j:commandButton
								value="Sim" ajaxSingle="true"
								action="#{solicitacaoController.encaminharDIGEP}"
								oncomplete="#{rich:component('confirmPanel')}.hide();"
								reRender="form, justificativa, messages, botoes, voltar" /></td>
							<td align="center" width="50%"><a4j:commandButton
								value="Não"
								onclick="#{rich:component('confirmPanel')}.hide();return false;" />
							</td>
						</tr>
					</tbody>
				</table>
			</h:form>
		</rich:modalPanel>
		<rich:modalPanel id="confirmPanel02" autosized="true" width="200">
			<f:facet name="header">
				<h:outputText value="Confirma este indeferimento?"
					style="padding-right:15px;" />
			</f:facet>
			<h:form>
				<table width="100%">
					<tbody>
						<tr>
							<td align="center" width="50%"><a4j:commandButton
								value="Sim" ajaxSingle="true"
								action="#{solicitacaoController.indeferirSolicitacao}"
								oncomplete="#{rich:component('confirmPanel02')}.hide();"
								reRender="form, justificativa, messages, botoes, voltar" /></td>
							<td align="center" width="50%"><a4j:commandButton
								value="Não"
								onclick="#{rich:component('confirmPanel02')}.hide();return false;" />
							</td>
						</tr>
					</tbody>
				</table>
			</h:form>
		</rich:modalPanel>
	</a4j:form>
</f:view>
</body>
</html>