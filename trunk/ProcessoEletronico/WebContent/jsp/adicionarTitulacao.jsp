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

			<h:panelGrid columns="4">

				<h:outputText value="Tiulação: " />

				<h:selectOneMenu
					value="#{servidorTitulacaoController.servidorTitulacao.titulacao.codigo}"
					required="true" requiredMessage="Campo Titulação é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems
						value="#{servidorTitulacaoController.titulacoes}" />
				</h:selectOneMenu>

				<h:outputText value="Estabelecimento de Ensino: " />

				<h:inputText
					value="#{servidorTitulacaoController.servidorTitulacao.estabelecimentoEnsino}"
					size="40" maxlength="100"></h:inputText>

				<h:outputText value="Curso: " />

				<h:inputText
					value="#{servidorTitulacaoController.servidorTitulacao.curso}"
					size="40" maxlength="100"></h:inputText>

				<h:outputText value="Area de Conhecimento: " />

				<h:selectOneMenu
					value="#{servidorTitulacaoController.servidorTitulacao.areaConhecimento.codigo}"
					required="true"
					requiredMessage="Campo Area de COnhecimento é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems
						value="#{servidorTitulacaoController.areasConhecimento}" />
				</h:selectOneMenu>

				<h:outputText value="Estado do Estabelecimento: " />
				<h:selectOneMenu id="estadoEstabelecimento"
					value="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.estado.codigo}"
					required="true"
					disabled="#{servidorTitulacaoController.indTitulacaoEstrangeira}"
					requiredMessage="Campo Estado de Estabelecimento é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems
						value="#{servidorTitulacaoController.estados}" />
					<a4j:support event="onchange"
						action="#{servidorTitulacaoController.listarCidadesEstabelecimento}"
						ajaxSingle="true" reRender="cidadeEstabelecimento"></a4j:support>
				</h:selectOneMenu>
				<h:outputText value="Cidade de Estabelecimento de Ensino: " />
				<h:selectOneMenu id="cidadeEstabelecimento"
					value="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.codigo}"
					required="true"
					disabled="#{servidorTitulacaoController.indTitulacaoEstrangeira}"
					requiredMessage="Campo Cidade de Nascimento é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems
						value="#{servidorTitulacaoController.cidadesEstabelecimento}" />
				</h:selectOneMenu>

				<h:outputText value="Carga Horária: " />

				<h:inputText
					value="#{servidorTitulacaoController.servidorTitulacao.cargaHoraria}"
					size="40" maxlength="4" onkeypress="mascara(this,soNumeros);"></h:inputText>

				<h:outputText value="Ano de Conclusão: " />

				<h:inputText
					value="#{servidorTitulacaoController.servidorTitulacao.anoConclusao}"
					size="40" maxlength="4" onkeypress="mascara(this,soNumeros);"></h:inputText>

				<h:outputText value="Registro no Concelho: " />

				<h:inputText
					value="#{servidorTitulacaoController.servidorTitulacao.registroConselho}"
					size="40" maxlength="11" onkeypress="mascara(this,soNumeros);"></h:inputText>

				<h:outputText value="Orgão Emissor do Registro: " />

				<h:inputText
					value="#{servidorTitulacaoController.servidorTitulacao.orgaoEmissor}"
					size="40" maxlength="8"></h:inputText>

				<h:outputText value="Estado do Orgão Emissor: " />
				<h:selectOneMenu id="estadoEmissor"
					value="#{servidorTitulacaoController.servidorTitulacao.estadoOrgaoEmissor.codigo}"
					required="true"
					requiredMessage="Campo Estado de Estabelecimento é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems
						value="#{servidorTitulacaoController.ufs}" />
				</h:selectOneMenu>

				<h:outputText value="Titulação Estrangeira: " />
				<h:selectBooleanCheckbox id="estrangeiro"
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
			<a4j:commandButton value="Salvar"
				action="#{servidorTitulacaoController.salvar}" />
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>