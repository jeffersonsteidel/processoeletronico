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
			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<font size="2"><b>ADICIONAR C�NJUGE</b></font>

			<h:panelGrid columns="1">
				<h:outputText
					value="#{conjugeController.conjuge.servidor.siape} - #{conjugeController.conjuge.servidor.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:outputText style="color: #00008B"
				value="#{conjugeController.texto}" />

			<h:panelGrid columns="4">
				<h:outputText value="Nome do C�njuge ">
				</h:outputText>
				<h:inputText value="#{conjugeController.conjuge.nome}" size="50"
					maxlength="100" required="true"
					requiredMessage="Campo Nome do C�njuge � obrigat�rio!"></h:inputText>

				<h:outputText value="Sexo do C�njuge: " />
				<h:selectOneMenu value="#{conjugeController.conjuge.sexo}"
					required="true"
					requiredMessage="Campo Sexo do C�njuge � obrigat�rio!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItem itemLabel="FEMININO" itemValue="F" />
					<f:selectItem itemLabel="MASCULINO" itemValue="M" />
				</h:selectOneMenu>

				<h:outputText value="Data de Nascimento do C�njuge: " />
				<rich:calendar value="#{conjugeController.conjuge.dataNascimento}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					inputSize="12" required="true"
					requiredMessage="Campo Data de Nascimento do C�njuge � obrigat�rio!" />

				<h:outputText value="CPF do C�njuge: " />
				<h:inputText value="#{conjugeController.conjuge.cpf}" size="16"
					maxlength="14" id="cpf" onkeypress="mascara(this,cpf);"
					required="true"
					requiredMessage="Campo CPF do C�njuge � obrigat�rio!">
					<a4j:support event="onchange"
						action="#{conjugeController.validarCPF}" ajaxSingle="true"
						reRender="cpf, messages"></a4j:support>
				</h:inputText>

				<h:outputText value="RG do C�njuge: " />
				<h:inputText value="#{conjugeController.conjuge.rg}" size="16"
					maxlength="13" required="true"
					requiredMessage="Campo RG do C�njuge � obrigat�rio!"></h:inputText>

				<h:outputText value="UF do RG do C�njuge: " />
				<h:selectOneMenu value="#{conjugeController.conjuge.rgUf.codigo}"
					required="true"
					requiredMessage="Campo UF do RG do C�njuge � obrigat�rio!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{conjugeController.ufs}" />
				</h:selectOneMenu>

				<h:outputText value="Org�o Emissor do RG do C�njuge: " />
				<h:inputText value="#{conjugeController.conjuge.rgOrgao}" size="16"
					maxlength="8" required="true"
					requiredMessage="Campo Org�o Emissor do RG do C�njuge � obrigat�rio!" />

				<h:outputText value="Data de Expedi��o do RG do C�njuge: " />
				<rich:calendar value="#{conjugeController.conjuge.rgDataExpedicao}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					inputSize="12" required="true"
					requiredMessage="Campo Data de Expedi��o do RG do C�njuge � obrigat�rio!" />

				<h:outputText value="Estado de Nascimento do C�njuge: " />
				<h:selectOneMenu id="estadoNascimentoConjuge"
					value="#{conjugeController.conjuge.cidadeNascimento.estado.codigo}"
					required="true"
					disabled="#{conjugeController.conjuge.indEstrangeiro}"
					requiredMessage="Campo Estado de Nascimento do C�njuge � obrigat�rio!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{conjugeController.estados}" />
					<a4j:support event="onchange"
						action="#{conjugeController.listarCidadesNascimentoConjuge}"
						ajaxSingle="true" reRender="cidadeNascimentoConjuge"></a4j:support>
				</h:selectOneMenu>

				<h:outputText value="Cidade de Nascimento do C�njuge: " />
				<h:selectOneMenu id="cidadeNascimentoConjuge"
					value="#{conjugeController.conjuge.cidadeNascimento.codigo}"
					required="true"
					disabled="#{conjugeController.conjuge.indEstrangeiro}"
					requiredMessage="Campo Cidade de Nascimento do C�njuge � obrigat�rio!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{conjugeController.cidadesNascimento}" />
				</h:selectOneMenu>

				<h:outputText value="Estrangeiro: " />
				<h:selectBooleanCheckbox id="estrangeiro"
					title="Marcar esta op��o caso seja imigrante!"
					value="#{conjugeController.conjuge.indEstrangeiro}">
					<a4j:support event="onchange" ajaxSingle="true"
						action="#{conjugeController.limparEstado}"
						reRender="paisNascimentoConjuge, estadoNascimentoConjuge, cidadeNascimentoConjuge"></a4j:support>
				</h:selectBooleanCheckbox>

				<h:outputText value="Pa�s de Nascimento do C�njuge: " />
				<h:selectOneMenu id="paisNascimentoConjuge"
					value="#{conjugeController.conjuge.pais.codigo}" required="true"
					disabled="#{!conjugeController.conjuge.indEstrangeiro}"
					requiredMessage="Campo Pa�s de Nascimento do C�njuge � obrigat�rio!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{conjugeController.paises}" />
				</h:selectOneMenu>

				<h:outputText value="� Servidor? " />
				<h:selectBooleanCheckbox id="servidor"
					title="Marcar esta op��o caso o c�njuge seja servidor!"
					value="#{conjugeController.conjuge.indServidor}">
					<a4j:support event="onchange" ajaxSingle="true" reRender="orgao"></a4j:support>
				</h:selectBooleanCheckbox>

				<h:outputText value="�rg�o de atua��o: " />
				<h:inputText id="orgao" value="#{conjugeController.conjuge.local}"
					disabled="#{!conjugeController.conjuge.indServidor}" size="16"
					maxlength="13" required="true"
					requiredMessage="Campo �rg�o de atua��o � obrigat�rio!"></h:inputText>

				<h:outputText value="C�njuge Atual? " />
				<h:selectBooleanCheckbox id="atual"
					title="Marcar esta op��o caso o c�njuge seja atual!"
					value="#{conjugeController.conjuge.atual}">
				</h:selectBooleanCheckbox>

			</h:panelGrid>

			<a4j:commandButton value="Salvar"
				action="#{conjugeController.salvarConjuge}" reRender="form" />
			<a4j:commandButton value="Voltar" onclick="history.go(-1)"
				rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}">
			</a4j:commandButton>
			<rich:dataTable id="listarConjugesSolicitante"
				rendered="#{not empty conjugeController.conjugeList}"
				value="#{conjugeController.conjugeList}" var="list" width="1160px"
				columnClasses="center" rows="15" reRender="ds">


				<rich:column width="435px" sortBy="#{list.nome}">
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{list.nome}" />
				</rich:column>

				<rich:column width="280px" sortBy="#{list.cpf}">
					<f:facet name="header">
						<h:outputText value="CPF" />
					</f:facet>
					<h:outputText value="#{list.cpf}" />
				</rich:column>

				<rich:column width="280px" sortBy="#{list.atual}">
					<f:facet name="header">
						<h:outputText value="Atual" />
					</f:facet>
					<h:outputText value="Atual" rendered="#{list.atual}" />
					<h:outputText value="Ex" rendered="#{!list.atual}" />
				</rich:column>
				<rich:column width="100px" sortBy="#{list.indValidado}">
					<f:facet name="header">
						<h:outputText value="Validado" />
					</f:facet>
					<h:outputText value="SIM" rendered="#{list.indValidado}" />
					<h:outputText value="N�O" rendered="#{!list.indValidado}" />
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Editar" />
					</f:facet>
					<a4j:commandLink action="#{conjugeController.carregar}"
						reRender="form" ajaxSingle="true">
						<h:graphicImage value="../images/edit.gif" style="border:0"
							width="20" height="18" id="editar" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{conjugeController.conjuge.codigo}" />
					</a4j:commandLink>
					<rich:toolTip for="editar" value="Editar" />
				</rich:column>

				<f:facet name="footer">
					<rich:datascroller id="ds"></rich:datascroller>
				</f:facet>
			</rich:dataTable>





		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>