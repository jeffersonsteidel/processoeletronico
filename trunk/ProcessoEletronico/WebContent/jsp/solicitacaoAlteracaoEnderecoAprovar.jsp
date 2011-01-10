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

			<font size="2"><b>ALTERAÇÃO DE ENDEREÇO/CONTATO</b></font>
			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.solicitante.siape} - #{solicitacaoController.solicitacaoAlteracaoEndereco.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>
			<h:panelGrid columns="1"
				rendered="#{!solicitacaoController.desabilitaBotao}">
				<center><h:outputText value="Atual" /></center>
			</h:panelGrid>


			<h:panelGrid columns="4"
				rendered="#{!solicitacaoController.desabilitaBotao}">
				<h:outputText value="Endereço: " />
				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.solicitante.endereco.rua}"></h:outputText>


				<h:outputText value="Número: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.solicitante.endereco.numero}"></h:outputText>

				<h:outputText value="Bairro: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.solicitante.endereco.bairro}"></h:outputText>

				<h:outputText value="Complemento: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.solicitante.endereco.complemento}"></h:outputText>

				<h:outputText value="CEP: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.solicitante.endereco.cep}">
				</h:outputText>

				<h:outputText value="Estado: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.solicitante.endereco.cidade.estado.descricao}">
				</h:outputText>

				<h:outputText value="Cidade: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.solicitante.endereco.cidade.descricao}" />
				<h:outputText value="Telefone: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.solicitante.telefone}" />
				<h:outputText value="Celular: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.solicitante.celular}" />
				<h:outputText value="E-mail: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.solicitante.email}"></h:outputText>
			</h:panelGrid>
			<h:panelGrid columns="1">
				<center><h:outputText value="Novo" /></center>
			</h:panelGrid>
			<h:panelGrid columns="4">
				<h:outputText value="Endereço: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.novaRua}"></h:outputText>

				<h:outputText value="Número: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.novoNumero}"></h:outputText>

				<h:outputText value="Bairro: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.novoBairro}"></h:outputText>

				<h:outputText value="Complemento: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.novoComplemento}"></h:outputText>

				<h:outputText value="CEP: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.novoCep}">
				</h:outputText>

				<h:outputText value="Estado: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.novaCidade.estado.descricao}" />

				<h:outputText value="Cidade: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.novaCidade.descricao}" />
				<h:outputText value="Telefone: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.novoTelefone}" />
				<h:outputText value="Celular: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.novoCelular}" />
				<h:outputText value="E-mail: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.novoEmail}"></h:outputText>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputText value="Justificativa: " />
				<h:inputTextarea disabled="#{solicitacaoController.desabilitaBotao}"
					value="#{solicitacaoController.solicitacaoAlteracaoEndereco.justificativa}"
					cols="50" rows="5"></h:inputTextarea>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<a4j:commandButton value="Deferir" reRender="form"
					disabled="#{solicitacaoController.desabilitaBotao}"
					oncomplete="#{rich:component('confirmPanel')}.show()" />
				<a4j:commandButton value="Indeferir" reRender="form"
					disabled="#{solicitacaoController.desabilitaBotao}"
					oncomplete="#{rich:component('confirmPanel02')}.show()" />
			</h:panelGrid>
			<h:panelGrid columns="1" rendered="#{solicitacaoController.desabilitaBotao && autenticacaoController.siapeAutenticado.indAdministrador}">
			<a4j:commandButton value="Voltar" action="#{solicitacaoController.retornarUltimaPesquisa}" />
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
								action="#{solicitacaoController.deferirSolicitacao}"
								oncomplete="#{rich:component('confirmPanel')}.hide();"
								reRender="form" /></td>
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
								reRender="form" /></td>
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