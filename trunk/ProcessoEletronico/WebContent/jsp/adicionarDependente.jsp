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

			<font size="2"><b>ADICIONAR DEPENDENTE</b></font>

			<h:panelGrid columns="1">
				<h:outputText
					value="#{dependenteController.dependente.servidor.siape} - #{dependenteController.dependente.servidor.nome}">
				</h:outputText>
			</h:panelGrid>
			<a4j:region>
				<h:panelGrid columns="4">

					<h:outputText value="Nome do Dependente: ">
					</h:outputText>
					<h:inputText value="#{dependenteController.dependente.nome}"
						size="50" maxlength="100" required="true"
						requiredMessage="Campo Nome do Dependente � obrigat�rio!"></h:inputText>

					<h:outputText value="Sexo do Dependente: " />
					<h:selectOneMenu value="#{dependenteController.dependente.sexo}"
						required="true" requiredMessage="Campo Sexo � obrigat�rio!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItem itemLabel="FEMININO" itemValue="F" />
						<f:selectItem itemLabel="MASCULINO" itemValue="M" />
					</h:selectOneMenu>

					<h:outputText value="Data de Nascimento do Dependente: " />
					<rich:calendar
						value="#{dependenteController.dependente.dataNascimento}"
						locale="" popup="true" datePattern="dd/MM/yyyy"
						showApplyButton="#" cellWidth="12px" cellHeight="12px"
						style="width:80px" required="true" inputSize="12"
						requiredMessage="Campo Data de Nascimento do Dependente � obrigat�rio!" />

					<h:outputText value="CPF do Dependente: " />
					<h:inputText value="#{dependenteController.dependente.cpf}"
						size="16" maxlength="14" id="cpf" onkeypress="mascara(this,cpf);">
						<a4j:support event="onchange"
							action="#{dependenteController.validarCPF}" ajaxSingle="true"
							reRender="cpf, confirmPanel, messages"></a4j:support>
					</h:inputText>

					<h:outputText value="RG do Dependente: " />
					<h:inputText value="#{dependenteController.dependente.rg}"
						size="16" maxlength="13"></h:inputText>

					<h:outputText value="UF do RG do Dependente: " />
					<h:selectOneMenu value="#{dependenteController.dependente.rgUf.codigo}">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{dependenteController.ufs}" />
					</h:selectOneMenu>

					<h:outputText value="Org�o Emissor do RG do Dependente: " />
					<h:inputText value="#{dependenteController.dependente.rgOrgao}"
						size="16" maxlength="8" />

					<h:outputText value="Data de Expedi��o do RG do Dependente: " />
					<rich:calendar
						value="#{dependenteController.dependente.rgDataExpedicao}"
						locale="" popup="true" datePattern="dd/MM/yyyy"
						showApplyButton="#" cellWidth="12px" cellHeight="12px"
						style="width:80px" inputSize="12" />

					<h:outputText value="Grau Parentesco: " />
					<h:selectOneMenu
						value="#{dependenteController.dependente.grauParentesco.codigo}"
						required="true"
						requiredMessage="Campo Grau Parentesco � obrigat�rio!">
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

					<h:outputText value="Estudante Universit�rio: " />
					<h:selectBooleanCheckbox id="estudanteUniversitario"
						value="#{dependenteController.dependente.indEstudante}">
						<a4j:support event="onchange" action="#{dependenteController.validarEstudante}" ajaxSingle="true"
							reRender="faculdade, curso, dataFormacao"></a4j:support>
					</h:selectBooleanCheckbox>

					<h:outputText value="Estabelecimento de Ensino: ">
					</h:outputText>
					<h:inputText id="faculdade"
						value="#{dependenteController.dependente.faculdade}" size="50"
						maxlength="100"
						disabled="#{!dependenteController.dependente.indEstudante}"
						required="true"
						requiredMessage="Campo Estabelecimento de Ensino � obrigat�rio!"></h:inputText>

					<h:outputText value="Curso: ">
					</h:outputText>
					<h:inputText id="curso"
						value="#{dependenteController.dependente.curso}" size="50"
						maxlength="100"
						disabled="#{!dependenteController.dependente.indEstudante}"
						required="true" requiredMessage="Campo Curso � obrigat�rio!"></h:inputText>

					<h:outputText value="Previs�o de Forma��o: " />
					<rich:calendar id="dataFormacao"
						value="#{dependenteController.dependente.dataFormacao}" locale=""
						popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
						cellWidth="12px" cellHeight="12px" style="width:80px"
						disabled="#{!dependenteController.dependente.indEstudante}"
						required="true" inputSize="12"
						requiredMessage="Campo Previs�o de Forma��o � obrigat�rio!" />
				</h:panelGrid>

				<a4j:commandButton value="Salvar"
					action="#{dependenteController.salvarDependente}" reRender="form" />

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
						<h:outputText value="#{list.grauParentesco.descricao}" />
					</rich:column>

					<rich:column>
						<f:facet name="header">
							<h:outputText value="Editar" />
						</f:facet>
						<a4j:commandLink action="#{dependenteController.carregar}"
							reRender="listaDependentes, form" ajaxSingle="true">
							<h:graphicImage value="../images/edit.gif" style="border:0"
								width="20" height="18" id="editar" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{dependenteController.dependente.codigo}" />
						</a4j:commandLink>
						<rich:toolTip for="editar" value="Editar" />

					</rich:column>

					<rich:column>
						<f:facet name="header">
							<h:outputText value="Excluir" />
						</f:facet>
						<a4j:commandLink ajaxSingle="true" id="delete"
							reRender="form, listaDependentes"
							oncomplete="#{rich:component('deletePanel')}.show()">
							<h:graphicImage id="excluir" value="../images/delete.gif"
								style="border:0" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{dependenteController.dependente.codigo}" />
						</a4j:commandLink>
						<rich:toolTip for="excluir" value="Excluir" />
					</rich:column>

					<f:facet name="footer">
						<rich:datascroller id="ds"></rich:datascroller>
					</f:facet>
				</rich:dataTable>
			</a4j:region>



			<center><rich:modalPanel id="deletePanel" autosized="true"
				width="200">
				<f:facet name="header">
					<h:outputText value="Deseja realmente deletar este item?"
						style="padding-right:15px;" />
				</f:facet>
				<h:form>
					<table width="100%">
						<tbody>
							<tr>
								<td align="center" width="50%"><a4j:commandButton
									value="Sim" ajaxSingle="true"
									action="#{dependenteController.remover}"
									oncomplete="#{rich:component('deletePanel')}.hide();"
									reRender="form, listaDependentes" /></td>
								<td align="center" width="50%"><a4j:commandButton
									value="N�o"
									onclick="#{rich:component('deletePanel')}.hide();return false;" />
								</td>
							</tr>
						</tbody>
					</table>
				</h:form>
			</rich:modalPanel></center>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>