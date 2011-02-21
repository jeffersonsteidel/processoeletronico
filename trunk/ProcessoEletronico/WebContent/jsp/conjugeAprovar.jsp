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

			<font size="2"><b>APROVAR CÔNJUGE</b></font>
			<h:panelGrid columns="2">
				<h:outputText value="Servidor: " />
				<h:outputText
					value="#{conjugeController.conjuge.servidor.siape} - #{conjugeController.conjuge.servidor.nome}" />
			</h:panelGrid>
			<h:panelGrid columns="4">
				<h:outputText value="Nome do Cônjuge ">
				</h:outputText>
				<h:outputText styleClass="maiusculo"
					value="#{conjugeController.conjuge.nome}"></h:outputText>
				<h:outputText value="Sexo do Cônjuge: " />
				<h:outputText value="FEMININO"
					rendered="#{conjugeController.conjuge.sexo == 'F'}"></h:outputText>
				<h:outputText value="MASCULINO"
					rendered="#{conjugeController.conjuge.sexo == 'M'}"></h:outputText>
				<h:outputText value="Data de Nascimento do Cônjuge: " />
				<h:outputText value="#{conjugeController.conjuge.dataNascimento}">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:outputText>
				<h:outputText value="CPF do Cônjuge: " />
				<h:outputText value="#{conjugeController.conjuge.cpf}"></h:outputText>
				<h:outputText value="RG do Cônjuge: " />
				<h:outputText value="#{conjugeController.conjuge.rg}"
					styleClass="maiusculo"></h:outputText>
				<h:outputText value="UF do RG do Cônjuge: " />
				<h:outputText value="#{conjugeController.conjuge.rgUf.uf}"></h:outputText>
				<h:outputText value="Orgão Emissor do RG do Cônjuge: " />
				<h:outputText value="#{conjugeController.conjuge.rgOrgao}"
					styleClass="maiusculo" />
				<h:outputText value="Data de Expedição do RG do Cônjuge: " />
				<h:outputText value="#{conjugeController.conjuge.rgDataExpedicao}">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:outputText>
				<h:outputText value="Estado de Nascimento do Cônjuge: "
					rendered="#{!conjugeController.conjuge.indEstrangeiro}" />
				<h:outputText id="estadoNascimentoConjuge"
					rendered="#{!conjugeController.conjuge.indEstrangeiro}"
					value="#{conjugeController.conjuge.cidadeNascimento.estado.descricao}" />
				<h:outputText value="Cidade de Nascimento do Cônjuge: "
					rendered="#{!conjugeController.conjuge.indEstrangeiro}" />
				<h:outputText id="cidadeNascimentoConjuge"
					rendered="#{!conjugeController.conjuge.indEstrangeiro}"
					value="#{conjugeController.conjuge.cidadeNascimento.descricao}" />
				<h:outputText value="Estrangeiro: " />
				<h:outputText value="SIM"
					rendered="#{conjugeController.conjuge.indEstrangeiro}" />
				<h:outputText value="NÃO"
					rendered="#{!conjugeController.conjuge.indEstrangeiro}" />
				<h:outputText value="País de Nascimento do Cônjuge: "
					rendered="#{conjugeController.conjuge.indEstrangeiro}" />
				<h:outputText value="#{conjugeController.conjuge.pais.descricao}"
					rendered="#{conjugeController.conjuge.indEstrangeiro}" />
				<h:outputText value="É Servidor? " />
				<h:outputText value="SIM"
					rendered="#{conjugeController.conjuge.indServidor}"></h:outputText>
				<h:outputText value="NÃO"
					rendered="#{!conjugeController.conjuge.indServidor}"></h:outputText>
				<h:outputText value="Órgão de atuação: "
					rendered="#{conjugeController.conjuge.indServidor}" />
				<h:outputText value="#{conjugeController.conjuge.local}"
					styleClass="maiusculo"
					rendered="#{conjugeController.conjuge.indServidor}"></h:outputText>
				<h:outputText value="Cônjuge Atual? " />
				<h:outputText value="SIM"
					rendered="#{conjugeController.conjuge.atual}" />
				<h:outputText value="NÃO"
					rendered="#{!conjugeController.conjuge.atual}" />
				<h:outputText value="Nova Inclusão: " />
				<h:outputText rendered="#{conjugeController.conjuge.indNovo}"
					value="SIM">
				</h:outputText>
				<h:outputText rendered="#{!conjugeController.conjuge.indNovo}"
					value="NÃO">
				</h:outputText>
			</h:panelGrid>
			<h:panelGrid columns="1" id="documentos">
				<h:outputText styleClass="negrito"
					value="Nenhum Documento apresentado!"
					rendered="#{empty conjugeController.documentos}" />
				<h:outputText value="Documentos apresentados:"
					rendered="#{not empty conjugeController.documentos}" />
				<rich:dataTable id="listaDocumento"
					rendered="#{not empty conjugeController.documentos}"
					value="#{conjugeController.documentos}" var="list" width="600px"
					columnClasses="center" reRender="ds">

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
								width="20" height="18" id="editar" />
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
					disabled="#{conjugeController.conjuge.statusSolicitacao.codigo != 2}"
					value="#{conjugeController.conjuge.justificativa}" cols="50"
					rows="5"
					validatorMessage="A Justificativa deve ter no máximo 250 caracteres!">
					<f:validateLength maximum="250"></f:validateLength>
				</h:inputTextarea>>
			</h:panelGrid>
			<h:panelGrid columns="2" id="botoes">
				<a4j:commandButton value="Deferir" reRender="confirmPanel"
					disabled="#{conjugeController.conjuge.statusSolicitacao.codigo != 2}"
					oncomplete="#{rich:component('confirmPanel')}.show()" />
				<a4j:commandButton value="Indeferir" reRender="confirmPanel02"
					disabled="#{conjugeController.conjuge.statusSolicitacao.codigo != 2}"
					oncomplete="#{rich:component('confirmPanel02')}.show()" />
			</h:panelGrid>
			<h:panelGrid columns="2">
				<a4j:commandButton value="Voltar" id="voltar"
					rendered="#{conjugeController.conjuge.statusSolicitacao.codigo > 2}"
					action="#{conjugeController.retornarUltimaPesquisa}" />
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
								action="#{conjugeController.deferir}"
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
								action="#{conjugeController.indeferir}"
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