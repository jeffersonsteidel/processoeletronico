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

			<font size="2"><b>ADICIONAR DEPENDENTE</b></font>
			<h:panelGrid columns="1">
				<h:outputText
					value="#{dependenteController.dependente.servidor.siape} - #{dependenteController.dependente.servidor.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="4">

				<h:outputText value="Nome do Dependente: ">
				</h:outputText>
				<h:inputText value="#{dependenteController.dependente.nome}"
					size="50" maxlength="100" required="true"
					requiredMessage="Campo Nome do Dependente é obrigatório!"></h:inputText>

				<h:outputText value="Sexo: " />
				<h:selectOneMenu value="#{dependenteController.dependente.sexo}"
					required="true" requiredMessage="Campo Sexo é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItem itemLabel="FEMININO" itemValue="F" />
					<f:selectItem itemLabel="MASCULINO" itemValue="M" />
				</h:selectOneMenu>

				<h:outputText value="Data de Nascimento do Dependente: " />
				<rich:calendar
					value="#{dependenteController.dependente.dataNascimento}" locale=""
					popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					required="true" inputSize="12"
					requiredMessage="Campo Data de Nascimento do Dependente é obrigatório!" />

				<h:outputText value="CPF do Dependente: " />
				<h:inputText
					value="#{dependenteController.dependente.documento.cpf}" size="16"
					maxlength="14" required="true" id="cpf"
					requiredMessage="Campo CPF do Dependente é obrigatório!"
					onkeypress="mascara(this,cpf);">
					<a4j:support event="onchange"
						action="#{dependenteController.validarCPF}" ajaxSingle="true"
						reRender="cpf, confirmPanel, messages"></a4j:support>
				</h:inputText>

				<h:outputText value="RG do Dependente: " />
				<h:inputText value="#{dependenteController.dependente.documento.rg}"
					size="16" maxlength="13" required="true"
					requiredMessage="Campo RG do Dependente é obrigatório!"></h:inputText>

				<h:outputText value="UF do RG do Dependente: " />
				<h:selectOneMenu
					value="#{dependenteController.dependente.documento.rgUf}"
					required="true"
					requiredMessage="Campo UF do RG do Dependente é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{dependenteController.ufs}" />
				</h:selectOneMenu>

				<h:outputText value="Orgão Emissor do RG do Dependente: " />
				<h:inputText
					value="#{dependenteController.dependente.documento.rgOrgaoEmissor}"
					size="16" maxlength="8" required="true"
					requiredMessage="Campo Orgão Emissor do RG do Dependente é obrigatório!" />



				<h:outputText value="Data de Expedição do RG do Dependente: " />
				<rich:calendar
					value="#{dependenteController.dependente.documento.rgDataExpedicao}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					required="true" inputSize="12"
					requiredMessage="Campo Data de Expedição do RG do Dependente é obrigatório!" />

				<h:outputText value="Grau Parentesco: " />
				<h:selectOneMenu
					value="#{dependenteController.dependente.grauParentesco.codigo}"
					required="true"
					requiredMessage="Campo Grau Parentesco é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{dependenteController.grausParentescos}" />
				</h:selectOneMenu>

				<h:outputText value="Imposto de Renda: " />
				<h:selectBooleanCheckbox id="impostoDeRenda"
					value="#{dependenteController.dependente.indIr}">
				</h:selectBooleanCheckbox>

				<h:outputText value="Necessidade Especiais: " />
				<h:selectBooleanCheckbox id="necessidadesEspeciais"
					value="#{dependenteController.dependente.indNecessidadesEspeciais}">
				</h:selectBooleanCheckbox>

				<h:outputText value="Estudante Universitário? " />
				<h:selectBooleanCheckbox id="estudanteUniversitario"
					value="#{dependenteController.dependente.indEstudante}">
				</h:selectBooleanCheckbox>

				<h:outputText value="Estabelecimento de Ensino: ">
				</h:outputText>
				<h:inputText value="#{dependenteController.dependente.faculdade}"
					size="50" maxlength="100" required="true"
					requiredMessage="Campo Estabelecimento de Ensino é obrigatório!"></h:inputText>

				<h:outputText value="Curso: ">
				</h:outputText>
				<h:inputText value="#{dependenteController.dependente.curso}"
					size="50" maxlength="100" required="true"
					requiredMessage="Campo Curso é obrigatório!"></h:inputText>

				<h:outputText value="Previsão de Formação: " />
				<rich:calendar
					value="#{dependenteController.dependente.dataFormacao}" locale=""
					popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					required="true" inputSize="12"
					requiredMessage="Campo Previsão de Formação é obrigatório!" />

			</h:panelGrid>

			<a4j:commandButton value="Adicionar"
				action="#{dependenteController.adicionarDependente}" reRender="form" />

			<rich:dataTable id="listaDependentes"
				value="#{dependenteController.listaDependentes}" var="list"
				width="1160px" columnClasses="center" rows="15" reRender="ds">

				<rich:column width="435px">
					<f:facet name="header">
						<h:outputText value="Nome do Dependente" />
					</f:facet>
					<h:outputText value="#{list.nome}" />
				</rich:column>

				<rich:column width="435px">
					<f:facet name="header">
						<h:outputText value="Grau Parentesco" />
					</f:facet>
					<h:outputText value="#{list.grauParentesco}" />
				</rich:column>

				<rich:column width="435px">
					<f:facet name="header">
						<h:outputText value="Excluir" />
					</f:facet>
					<h:outputText value="#" />
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