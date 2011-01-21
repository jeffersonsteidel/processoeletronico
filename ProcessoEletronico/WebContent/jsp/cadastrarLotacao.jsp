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
			<font size="2"><b>CADASTRAR LOTAÇÃO</b></font>
			
			<h:panelGrid columns="4">
				<h:outputText value="Código: " />
				<h:inputText requiredMessage="Campo Código é obrigatório!"
					disabled="#{!lotacaoController.indNovo}" required="true"
					value="#{lotacaoController.lotacao.codigo}" size="6"
					onkeypress="mascara(this, soNumeros);" maxlength="6"></h:inputText>

				<h:outputText value="Nome da Locação: " />
				<h:inputText requiredMessage="Campo Nome da Locação é obrigatório!"
					required="true" value="#{lotacaoController.lotacao.descricao}"
					size="60" maxlength="100"></h:inputText>

				<h:outputText value="Diretor Administrativo: " />
				<h:inputText
					requiredMessage="Campo Diretor Administrativo é obrigatório!"
					required="true"
					value="#{lotacaoController.lotacao.diretorAdministrativo}"
					size="60" maxlength="120"></h:inputText>

				<h:outputText value="Diretor Geral: " />
				<h:inputText requiredMessage="Campo Diretor Geral é obrigatório!"
					required="true" value="#{lotacaoController.lotacao.diretorGeral}"
					size="60" maxlength="120"></h:inputText>

				<h:outputText value="Endereco: " />
				<h:inputText requiredMessage="Campo Endereço é obrigatório!"
					required="true" value="#{lotacaoController.lotacao.endereco.rua}"
					size="60" maxlength="120"></h:inputText>

				<h:outputText value="Número: " />
				<h:inputText requiredMessage="Campo Número é obrigatório!"
					required="true"
					value="#{lotacaoController.lotacao.endereco.numero}" size="10"
					maxlength="6"></h:inputText>

				<h:outputText value="Bairro: " />
				<h:inputText requiredMessage="Campo Bairro é obrigatório!"
					required="true"
					value="#{lotacaoController.lotacao.endereco.bairro}" size="60"
					maxlength="80"></h:inputText>

				<h:outputText value="Estado: " />
				<h:selectOneMenu id="estado"
					value="#{lotacaoController.lotacao.endereco.cidade.estado.codigo}"
					required="true" requiredMessage="Campo Estado é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{lotacaoController.estados}" />
					<a4j:support event="onchange"
						action="#{lotacaoController.listarCidades}"
						ajaxSingle="true" reRender="cidade"></a4j:support>
				</h:selectOneMenu>

				<h:outputText value="Cidade: " />
				<h:selectOneMenu id="cidade"
					value="#{lotacaoController.lotacao.endereco.cidade.codigo}"
					required="true" requiredMessage="Campo Cidade é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{lotacaoController.cidades}" />
				</h:selectOneMenu>

				<h:outputText value="Telefone: " />
				<h:inputText
					requiredMessage="Campo Telefone é obrigatório!"
					required="true" value="#{lotacaoController.lotacao.telefone}"
					onkeypress="mascara(this, telefone);"
					size="20" maxlength="13"></h:inputText>

				<h:outputText value="Email: " />
				<h:inputText
					requiredMessage="Campo E-mail é obrigatório!"
					required="true" value="#{lotacaoController.lotacao.email}"
					size="70" maxlength="120"></h:inputText>

				<h:outputText value="Site: " />
				<h:inputText
					requiredMessage="Campo Site é obrigatório!"
					required="true" value="#{lotacaoController.lotacao.site}" size="90"
					maxlength="130"></h:inputText>

			</h:panelGrid>
			<h:panelGrid columns="2">
				<a4j:commandButton value="Salvar"
					action="#{lotacaoController.salvar}" reRender="form" />
			</h:panelGrid>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>