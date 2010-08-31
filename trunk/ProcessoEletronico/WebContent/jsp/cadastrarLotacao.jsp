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
	<a4j:loadScript src="../js/script.js" />
	<center><a4j:form id="form">
		<rich:panel header="Lotação" style="width: 1080px;">
			<h:panelGrid columns="6">

				<h:outputText value="Campus: " />
				<h:inputText value="#{lotacaoController.lotacao.descricao}"
					size="50" maxlength="100" required="true"
					requiredMessage="Campo Campus obrigatório!"></h:inputText>

				<h:outputText value="Endereço: " />
				<h:inputText value="#{lotacaoController.lotacao.endereco.rua}"
					size="50" maxlength="120" required="true"
					requiredMessage="Campo Endereço obrigatório!"></h:inputText>

				<h:outputText value="Número: " />
				<h:inputText value="#{lotacaoController.lotacao.endereco.numero}"
					size="5" maxlength="7" required="true"
					requiredMessage="Campo Número obrigatório!"></h:inputText>

				<h:outputText value="Bairro: " />
				<h:inputText value="#{lotacaoController.lotacao.endereco.bairro}"
					size="30" maxlength="80" required="true"
					requiredMessage="Campo Bairro obrigatório!"></h:inputText>

				<h:outputText value="CEP: " />
				<h:inputText value="#{lotacaoController.lotacao.endereco.cep}"
					size="20" maxlength="9" required="true"
					requiredMessage="Campo CEP obrigatório!"
					onkeypress="mascara(this,cep)"></h:inputText>

				<h:outputText value="Estado: " />
				<h:selectOneMenu id="estado"
					value="#{lotacaoController.lotacao.endereco.cidade.estado.codigo}"
					required="true" requiredMessage="Campo Estado é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{lotacaoController.estados}" />
					<a4j:support event="onchange"
						action="#{lotacaoController.listarCidades}" ajaxSingle="true"
						reRender="cidade"></a4j:support>
				</h:selectOneMenu>

				<h:outputText value="Cidade: " />
				<h:selectOneMenu id="cidade"
					value="#{lotacaoController.lotacao.endereco.cidade.codigo}"
					required="true" requiredMessage="Campo Cidade é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{lotacaoController.cidades}" />
				</h:selectOneMenu>

				<h:outputText value="Diretor Geral: " />
				<h:inputText value="#{lotacaoController.lotacao.diretorGeral}" size="50"
					maxlength="120" required="true" requiredMessage="Campo Diretor Geral obrigatório!" ></h:inputText>

				<h:outputText value="Diretor Administrativo: " />
				<h:inputText value="#{lotacaoController.lotacao.diretorAdministrativo}" size="50"
					maxlength="120" required="true" requiredMessage="Campo Diretor Administrativo obrigatório!" ></h:inputText>
					
				<h:outputText value="Telefone: " />
				<h:inputText value="#{lotacaoController.lotacao.telefone.numero}"
					size="20" maxlength="13" onkeypress="mascara(this,telefone)"
					required="true" requiredMessage="Campo Telefone obrigatório!"></h:inputText>

				<h:outputText value="Site: " />
				<h:inputText value="#{lotacaoController.lotacao.site}" size="50"
					maxlength="130" required="true" requiredMessage="Campo Site obrigatório!" ></h:inputText>
					
				<h:outputText value="E-mail: " />
				<h:inputText value="#{lotacaoController.lotacao.email}" size="50"
					maxlength="120" required="true" requiredMessage="Campo E-mail obrigatório!"></h:inputText>
						
			</h:panelGrid>
			<a4j:commandButton value="Salvar" action="#{lotacaoController.salvar}"
				oncomplete="#{rich:component('confirmPanel')}.show()" />
		</rich:panel>
	</a4j:form></center>
	<center><rich:modalPanel id="confirmPanel" autosized="false"
		resizeable="true"
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
	</rich:modalPanel></center>
</f:view>
</body>
</html>