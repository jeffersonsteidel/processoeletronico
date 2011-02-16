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
			<font size="2"><b>GERENCIAR PERMISSÕES</b></font>

			<h:panelGrid columns="2">
				<h:outputText value="Siape do Servidor: ">
				</h:outputText>
				<h:inputText id="siape"
					value="#{permissaoController.servidor.siape}" size="10"
					maxlength="7" required="true"
					requiredMessage="Campo Siape do Servidor é obrigatório!">
					<a4j:support event="onchange"
						action="#{permissaoController.pesquisarPermissaoServidor}"
						ajaxSingle="true" reRender="form"></a4j:support>
				</h:inputText>

				<h:outputText value="Nome do Servidor: ">
				</h:outputText>
				<h:outputText id="servidor"
					value="#{permissaoController.servidor.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="1" id="permissoes"
				rendered="#{!permissaoController.isAutenticacaoNull}">
				<h:outputText value="Permissões do Servidor:"></h:outputText>
				<h:panelGrid columns="4">
					<h:selectBooleanCheckbox id="usuario"
						title="O servidor tem acesso ao sistema!" disabled="true"
						value="true">
					</h:selectBooleanCheckbox>
					<h:outputText value="Usuário" />
					<h:selectBooleanCheckbox id="secretaria"
						title="O servidor tem permissão de secretário!"
						value="#{permissaoController.autenticacao.indSecretaria}">
					</h:selectBooleanCheckbox>
					<h:outputText value="Secretária" />
					<h:selectBooleanCheckbox id="diretor"
						title="O servidor tem permissão de diretor!"
						value="#{permissaoController.autenticacao.indDiretor}">
					</h:selectBooleanCheckbox>
					<h:outputText value="Diretor" />
					<h:selectBooleanCheckbox id="administrador"
						title="O servidor tem permissão de administrador!"
						value="#{permissaoController.autenticacao.indAdministrador}">
					</h:selectBooleanCheckbox>
					<h:outputText value="Administrador" />
					<h:selectBooleanCheckbox id="gerente"
						title="O servidor tem permissão de gerente do sistema!"
						value="#{permissaoController.autenticacao.indGerente}">
					</h:selectBooleanCheckbox>
					<h:outputText value="Gerente" />
				</h:panelGrid>
			</h:panelGrid>
			<a4j:commandButton value="Salvar" rendered="#{!permissaoController.isAutenticacaoNull}"
				action="#{permissaoController.salvar}" reRender="form" />
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>