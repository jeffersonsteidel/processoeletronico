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
	<center><a4j:form id="form">
		<rich:panel>
			<font size="2"><b>PESQUISAR DEPENDENTES</b></font>
			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			
			<h:panelGrid columns="13">

				<h:outputText value="Siape: ">
				</h:outputText>
				<h:inputText
					value="#{dependenteController.dependente.servidor.siape}" size="7"
					maxlength="7" onkeyup="mascara(this, soNumeros);">
				</h:inputText>

				<h:outputText value="Servidor: ">
				</h:outputText>
				<h:inputText
					value="#{dependenteController.dependente.servidor.nome}" size="40">
				</h:inputText>

				<h:outputText value="Dependente: ">
				</h:outputText>
				<h:inputText value="#{dependenteController.dependente.nome}"
					size="40">
				</h:inputText>

				<h:outputText value="Parentesco: " />
				<h:selectOneMenu
					value="#{dependenteController.dependente.grauParentesco.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{dependenteController.grausParentescos}" />
				</h:selectOneMenu>

				<h:outputText value="Validados: " />
				<h:selectOneMenu value="#{dependenteController.validado}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="SIM" itemValue="1" />
					<f:selectItem itemLabel="NÃO" itemValue="2" />
				</h:selectOneMenu>

				<h:outputText value="Situação: " />
				<h:selectOneMenu value="#{dependenteController.situacao}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="ATIVOS" itemValue="1" />
					<f:selectItem itemLabel="INATIVOS" itemValue="2" />
				</h:selectOneMenu>

				<a4j:commandButton value="Pesquisar"
					action="#{dependenteController.listarDependentesFiltro}"
					reRender="listaDependentes" type="submit" />
			</h:panelGrid>

			<rich:dataTable id="listaDependentes"
				value="#{dependenteController.listaDependentesFiltro}" var="list"
				width="1150px" columnClasses="center" rows="15" reRender="ds">
				<rich:column width="50px" sortBy="#{list.servidor.siape}">
					<f:facet name="header">
						<h:outputText value="Siape" />
					</f:facet>
					<h:outputText value="#{list.servidor.siape}" />
				</rich:column>

				<rich:column width="420px" sortBy="#{list.servidor.nome}">
					<f:facet name="header">
						<h:outputText value="Servidor" />
					</f:facet>
					<h:outputText value="#{list.servidor.nome}" />
				</rich:column>

				<rich:column width="420px" sortBy="#{list.nome}">
					<f:facet name="header">
						<h:outputText value="Dependente" />
					</f:facet>
					<h:outputText value="#{list.nome}" />
				</rich:column>

				<rich:column width="420px" sortBy="#{list.grauParentesco.descricao}">
					<f:facet name="header">
						<h:outputText value="Grau Parentesco" />
					</f:facet>
					<h:outputText value="#{list.grauParentesco.descricao}" />
				</rich:column>

				<rich:column width="100px">
					<f:facet name="header">
						<h:outputText value="Validado" />
					</f:facet>
					<h:outputText value="SIM" rendered="#{list.indValidado}" />
					<h:outputText value="NÃO" rendered="#{!list.indValidado}" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Visualizar" />
					</f:facet>
					<a4j:commandLink action="#{dependenteController.carregar}"
						reRender="editPanel" ajaxSingle="true"
						oncomplete="#{rich:component('editPanel')}.show()">
						<h:graphicImage value="../images/edit.gif" style="border:0"
							width="20" height="18" id="editar" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{dependenteController.dependente.codigo}" />
					</a4j:commandLink>
					<rich:toolTip for="editar" value="Editar" />
				</rich:column>

				<f:facet name="footer">
					<rich:datascroller id="ds"></rich:datascroller>
				</f:facet>
			</rich:dataTable>
		</rich:panel>
	</a4j:form></center>

	<center><rich:modalPanel id="editPanel" autosized="true"
		width="700">
		<h:form>
			<center><font size="2"><b>DETALHES DO DEPENDENTE</b></font>
			<h:panelGrid columns="2">
				<h:outputText value="Servidor: " />
				<h:outputText
					value="#{dependenteController.dependente.servidor.siape} - #{dependenteController.dependente.servidor.nome}" />
			</h:panelGrid> <h:panelGrid columns="4">
				<h:outputText value="Nome do Dependente: ">
				</h:outputText>
				<h:outputText value="#{dependenteController.dependente.nome}"></h:outputText>
				<h:outputText value="Sexo do Dependente: " />
				<h:outputText value="FEMININO"
					rendered="#{dependenteController.dependente.sexo == 'F'}"></h:outputText>
				<h:outputText value="MASCULINO"
					rendered="#{dependenteController.dependente.sexo == 'M'}"></h:outputText>
				<h:outputText value="Data de Nascimento do Dependente: " />
				<h:outputText
					value="#{dependenteController.dependente.dataNascimento}">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:outputText>
				<h:outputText value="CPF do Dependente: "
					rendered="#{dependenteController.dependente.cpf != ''}" />
				<h:outputText value="#{dependenteController.dependente.cpf}"
					rendered="#{dependenteController.dependente.cpf != ''}" />
				<h:outputText value="RG do Dependente: "
					rendered="#{dependenteController.dependente.rg != ''}" />
				<h:outputText value="#{dependenteController.dependente.rg}"
					rendered="#{dependenteController.dependente.rg != ''}"></h:outputText>
				<h:outputText value="UF do RG do Dependente: "
					rendered="#{dependenteController.dependente.rgUf.uf != null}" />
				<h:outputText value="#{dependenteController.dependente.rgUf.uf}"
					rendered="#{dependenteController.dependente.rgUf.uf != null}"></h:outputText>
				<h:outputText value="Orgão Emissor do RG do Dependente: "
					rendered="#{dependenteController.dependente.rgOrgao != ''}" />
				<h:outputText value="#{dependenteController.dependente.rgOrgao}"
					rendered="#{dependenteController.dependente.rgOrgao != ''}" />
				<h:outputText value="Data de Expedição do RG do Dependente: "
					rendered="#{dependenteController.dependente.rgDataExpedicao.date!=null}" />
				<h:outputText
					rendered="#{dependenteController.dependente.rgDataExpedicao.date!=null}"
					value="#{dependenteController.dependente.rgDataExpedicao}">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:outputText>
				<h:outputText value="Grau Parentesco: " />
				<h:outputText
					value="#{dependenteController.dependente.grauParentesco.descricao}"></h:outputText>
				<h:outputText value="Imposto de Renda: " />
				<h:outputText value="SIM"
					rendered="#{dependenteController.dependente.indIr}"></h:outputText>
				<h:outputText value="NÃO"
					rendered="#{!dependenteController.dependente.indIr}"></h:outputText>
				<h:outputText value="Necessidade Especiais: " />
				<h:outputText value="SIM"
					rendered="#{dependenteController.dependente.indNecessidadesEspeciais}"></h:outputText>
				<h:outputText value="NÃO"
					rendered="#{!dependenteController.dependente.indNecessidadesEspeciais}"></h:outputText>
				<h:outputText value="Estudante Universitário? " />
				<h:outputText value="SIM"
					rendered="#{dependenteController.dependente.indEstudante}"></h:outputText>
				<h:outputText value="NÃO"
					rendered="#{!dependenteController.dependente.indEstudante}"></h:outputText>
				<h:outputText value="Estabelecimento de Ensino: "
					rendered="#{dependenteController.dependente.indEstudante}">
				</h:outputText>
				<h:outputText value="#{dependenteController.dependente.faculdade}"
					rendered="#{dependenteController.dependente.indEstudante}"></h:outputText>
				<h:outputText value="Curso: "
					rendered="#{dependenteController.dependente.indEstudante}">
				</h:outputText>
				<h:outputText id="curso"
					rendered="#{dependenteController.dependente.indEstudante}"
					value="#{dependenteController.dependente.curso}"></h:outputText>
				<h:outputText value="Previsão de Formação: "
					rendered="#{dependenteController.dependente.indEstudante}" />
				<h:outputText id="dataFormacao"
					rendered="#{dependenteController.dependente.indEstudante}"
					value="#{dependenteController.dependente.dataFormacao}">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:outputText>
			</h:panelGrid> <h:panelGrid columns="2">
				<a4j:commandButton value="Validar"
					action="#{dependenteController.validar}"
					reRender="form, listaDependentes" />
				<a4j:commandButton value="Fechar"
					onclick="#{rich:component('editPanel')}.hide();return false;" />
			</h:panelGrid></center>
		</h:form>
	</rich:modalPanel></center>
</f:view>
</body>
</html>