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
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.solicitante.siape} - #{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.solicitante.nome}">
				</h:outputText>
			</h:panelGrid>
			<h:panelGrid columns="1">
				<center><h:outputText value="Atual" /></center>
			</h:panelGrid>
			<h:panelGrid columns="4">
				<h:outputText value="Endereço: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.solicitante.endereco.rua}"></h:outputText>

				<h:outputText value="Número: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.solicitante.endereco.numero}"></h:outputText>

				<h:outputText value="Bairro: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.solicitante.endereco.bairro}"></h:outputText>

				<h:outputText value="Complemento: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.solicitante.endereco.complemento}"></h:outputText>

				<h:outputText value="CEP: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.solicitante.endereco.cep}">
				</h:outputText>

				<h:outputText value="Estado: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.solicitante.endereco.cidade.estado.descricao}">

				</h:outputText>

				<h:outputText value="Cidade: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.solicitante.endereco.cidade.descricao}" />

				<h:outputText value="Telefone: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.solicitante.telefone}">
				</h:outputText>
				<h:outputText value="Celular: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.solicitante.celular}">
				</h:outputText>
				<h:outputText value="E-mail: ">
				</h:outputText>

				<h:outputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.solicitante.email}">
				</h:outputText>
			</h:panelGrid>
			<h:panelGrid columns="1">
				<center><h:outputText value="Novo" /></center>
			</h:panelGrid>
			<h:panelGrid columns="4">
				<h:outputText value="Endereço: " />
				<h:inputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.novaRua}"
					size="50" maxlength="120" required="true"
					requiredMessage="Campo Endereço é obrigatório!"></h:inputText>

				<h:outputText value="Número: " />
				<h:inputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.novoNumero}"
					size="5" maxlength="7" required="true"
					requiredMessage="Campo Número é obrigatório!"></h:inputText>

				<h:outputText value="Bairro: " />
				<h:inputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.novoBairro}"
					size="30" maxlength="80" required="true"
					requiredMessage="Campo Bairro é obrigatório!"></h:inputText>

				<h:outputText value="Complemento: " />
				<h:inputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.novoComplemento}"
					size="25" maxlength="25"></h:inputText>

				<h:outputText value="CEP: " />
				<h:inputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.novoCep}"
					size="20" maxlength="9" required="true"
					requiredMessage="Campo CEP é obrigatório!"
					validatorMessage="Campo CEP deve ter no mínimo 9 caracateres!"
					onkeypress="mascara(this,cep)">
					<f:validateLength minimum="9" />
				</h:inputText>

				<h:outputText value="Estado: " />
				<h:selectOneMenu id="estado"
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.novaCidade.estado.codigo}"
					required="true" requiredMessage="Campo Estado é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems
						value="#{solicitacaoAlteracaoEnderecoController.estados}" />
					<a4j:support event="onchange"
						action="#{solicitacaoAlteracaoEnderecoController.listarCidades}"
						ajaxSingle="true" reRender="cidade"></a4j:support>
				</h:selectOneMenu>

				<h:outputText value="Cidade: " />
				<h:selectOneMenu id="cidade"
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.novaCidade.codigo}"
					required="true" requiredMessage="Campo Cidade é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems
						value="#{solicitacaoAlteracaoEnderecoController.cidades}" />
				</h:selectOneMenu>
				<h:outputText value="Telefone: " />
				<h:inputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.novoTelefone}"
					size="16" maxlength="13" required="true"
					requiredMessage="Campo Telefone é obrigatório!"
					onkeypress="mascara(this,telefone);"
					validatorMessage="Campo Telefone deve ter no mínimo 13 caracteres!">
					<f:validateLength minimum="13" />
				</h:inputText>
				<h:outputText value="Celular: " />
				<h:inputText
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.novoCelular}"
					size="16" maxlength="13" onkeypress="mascara(this,telefone);"
					validatorMessage="Campo Celular deve ter no mínimo 13 caracteres!">
					<f:validateLength minimum="13" />
				</h:inputText>
				<h:outputText value="E-mail: " />
				<h:inputText required="true"
					requiredMessage="Campo E-mail é obrigatório!"
					value="#{solicitacaoAlteracaoEnderecoController.solicitacaoAlteracaoEndereco.novoEmail}"
					size="40" title="Colocar de preferencial o e-mail institucional!"
					maxlength="150"></h:inputText>
			</h:panelGrid>
			<a4j:commandButton value="Salvar"
				action="#{solicitacaoAlteracaoEnderecoController.salvar}"
				reRender="form" />
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>