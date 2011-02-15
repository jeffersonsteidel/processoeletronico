<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instituto Federal do Paran�</title>
<link rel="StyleSheet" type="text/css" href="../css/messages-style.css"
	media="screen" />
</head>
<body>
<f:view>
	<jsp:directive.include file="menus.jsp" />
	<a4j:loadScript src="../js/script.js" />
	<a4j:form id="form">
		<center><rich:panel>
			<rich:messages id="messages" layout="list"
				errorLabelClass="errorLabel" style="top:auto;"
				infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<font size="2"><b>APROVAR TITULA��O</b></font>
			<h:panelGrid columns="2">
				<h:outputText value="Servidor: " />
				<h:outputText
					value="#{servidorTitulacaoController.servidorTitulacao.servidor.siape} - #{servidorTitulacaoController.servidorTitulacao.servidor.nome}" />
			</h:panelGrid>
			<h:panelGrid columns="4">
				<h:outputText value="Tiula��o: " />
				<h:outputText
					value="#{servidorTitulacaoController.servidorTitulacao.titulacao.descricao}" />
				<h:outputText value="Estabelecimento de Ensino: " />
				<h:outputText styleClass="maiusculo"
					value="#{servidorTitulacaoController.servidorTitulacao.estabelecimentoEnsino}" />

				<h:outputText value="Curso: " 
					rendered="#{servidorTitulacaoController.indSuperior}" />
				<h:outputText styleClass="maiusculo"
					value="#{servidorTitulacaoController.servidorTitulacao.curso}"
					rendered="#{servidorTitulacaoController.indSuperior}" />

				<h:outputText value="Area de Conhecimento: "
					rendered="#{servidorTitulacaoController.indSuperior}" />
				<h:outputText
					value="#{servidorTitulacaoController.servidorTitulacao.areaConhecimento.descricao}"
					rendered="#{servidorTitulacaoController.indSuperior}" />

				<h:outputText value="Estado do Estabelecimento de Ensino: " 
					rendered="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.estado.codigo != 0}" />
				<h:outputText
					rendered="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.estado.codigo != 0}"
					value="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.estado.descricao}">
				</h:outputText>

				<h:outputText value="Cidade de Estabelecimento de Ensino: " />
				<h:outputText
					rendered="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.codigo != 0}"
					value="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.descricao}">
				</h:outputText>

				<h:outputText value="Carga Hor�ria: "
					rendered="#{servidorTitulacaoController.indSuperior}" />

				<h:outputText
					rendered="#{servidorTitulacaoController.indSuperior}"
					value="#{servidorTitulacaoController.servidorTitulacao.cargaHoraria}"></h:outputText>

				<h:outputText value="Ano de Conclus�o: "
					rendered="#{servidorTitulacaoController.servidorTitulacao.anoConclusao != null}" />

				<h:outputText
					rendered="#{servidorTitulacaoController.servidorTitulacao.anoConclusao != null}"
					value="#{servidorTitulacaoController.servidorTitulacao.anoConclusao}">
				</h:outputText>

				<h:outputText value="Registro no Conselho: " rendered="#{servidorTitulacaoController.servidorTitulacao.registroConselho != '' && servidorTitulacaoController.servidorTitulacao.registroConselho != null}"/>

				<h:outputText
					rendered="#{servidorTitulacaoController.servidorTitulacao.registroConselho != '' && servidorTitulacaoController.servidorTitulacao.registroConselho != null}"
					value="#{servidorTitulacaoController.servidorTitulacao.registroConselho}"></h:outputText>

				<h:outputText value="Org�o Emissor do Registro: " 
					rendered="#{servidorTitulacaoController.servidorTitulacao.orgaoEmissor != '' && servidorTitulacaoController.servidorTitulacao.orgaoEmissor != null}" />

				<h:outputText  styleClass="maiusculo"
					rendered="#{servidorTitulacaoController.servidorTitulacao.orgaoEmissor != '' && servidorTitulacaoController.servidorTitulacao.orgaoEmissor != null}"
					value="#{servidorTitulacaoController.servidorTitulacao.orgaoEmissor}"></h:outputText>

				<h:outputText value="Estado do Org�o Emissor: " rendered="#{servidorTitulacaoController.servidorTitulacao.estadoOrgaoEmissor != null && servidorTitulacaoController.servidorTitulacao.estadoOrgaoEmissor != ''}"/>
				<h:outputText
					rendered="#{servidorTitulacaoController.servidorTitulacao.estadoOrgaoEmissor != null && servidorTitulacaoController.servidorTitulacao.estadoOrgaoEmissor != ''}"
					value="#{servidorTitulacaoController.servidorTitulacao.estadoOrgaoEmissor.descricao}">
				</h:outputText>

				<h:outputText value="Titula��o Estrangeira: " />
				<h:outputText value="SIM"
					rendered="#{servidorTitulacaoController.indTitulacaoEstrangeira}" />
				<h:outputText value="N�O"
					rendered="#{!servidorTitulacaoController.indTitulacaoEstrangeira}" />

				<h:outputText value="Pa�s: " rendered="#{servidorTitulacaoController.indTitulacaoEstrangeira}"/>
				<h:outputText id="pais"
					rendered="#{servidorTitulacaoController.indTitulacaoEstrangeira}"
					value="#{servidorTitulacaoController.servidorTitulacao.pais.descricao}">
				</h:outputText>

			</h:panelGrid>
			<h:panelGrid columns="1" id="documentos">
				<h:outputText styleClass="negrito" value="Nenhum Documento apresentado!"  rendered="#{empty servidorTitulacaoController.documentos}"/>
				<h:outputText value="Documentos apresentados:" rendered="#{not empty servidorTitulacaoController.documentos}"/>
				<rich:dataTable id="listaDocumento" rendered="#{not empty servidorTitulacaoController.documentos}"
				value="#{servidorTitulacaoController.documentos}" var="list"
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
					<a4j:commandLink action="#{documentoImagemController.verDocumentos}"
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
			<h:panelGrid columns="2" style="text-align: center;">
				<h:outputText value="Justificativa: " />
				<h:inputTextarea id="justificativa"
					disabled="#{servidorTitulacaoController.servidorTitulacao.statusSolicitacao.codigo != 2}"
					value="#{servidorTitulacaoController.servidorTitulacao.justificativa}"
					cols="50" rows="5"></h:inputTextarea>
			</h:panelGrid>
			<h:panelGrid columns="2" id="botoes">
				<a4j:commandButton value="Deferir" reRender="confirmPanel"
					disabled="#{servidorTitulacaoController.servidorTitulacao.statusSolicitacao.codigo != 2}"
					oncomplete="#{rich:component('confirmPanel')}.show()" />
				<a4j:commandButton value="Indeferir" reRender="confirmPanel02"
					disabled="#{servidorTitulacaoController.servidorTitulacao.statusSolicitacao.codigo != 2}"
					oncomplete="#{rich:component('confirmPanel02')}.show()" />
			</h:panelGrid>
			<h:panelGrid columns="2">
				<a4j:commandButton value="Voltar" id="voltar"
					rendered="#{servidorTitulacaoController.servidorTitulacao.statusSolicitacao.codigo > 2}"
					action="#{servidorTitulacaoController.retornarUltimaPesquisa}" />
			</h:panelGrid>
		</rich:panel></center>

		<rich:modalPanel id="confirmPanel" autosized="true" width="200">
			<f:facet name="header">
				<h:outputText value="Confirma este deferimento?"
					style="padding-right:15px;" />
			</f:facet>
			<h:form>
				<table width="100%">
					<tbody>
						<tr>
							<td align="center" width="50%"><a4j:commandButton
								value="Sim" ajaxSingle="true"
								action="#{servidorTitulacaoController.deferir}"
								oncomplete="#{rich:component('confirmPanel')}.hide();"
								reRender="form, justificativa, messages, botoes, voltar" /></td>
							<td align="center" width="50%"><a4j:commandButton
								value="N�o"
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
								action="#{servidorTitulacaoController.indeferir}"
								oncomplete="#{rich:component('confirmPanel02')}.hide();"
								reRender="form, justificativa, messages, botoes, voltar" /></td>
							<td align="center" width="50%"><a4j:commandButton
								value="N�o"
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