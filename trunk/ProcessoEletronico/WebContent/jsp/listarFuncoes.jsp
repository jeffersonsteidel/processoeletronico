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
			<font size="2"><b>LISTAR FUNÇÕES</b></font>

			<h:panelGrid columns="11">

				<h:outputText value="Tipo Função:" />
				<h:selectOneMenu id="tipoFuncao"
					value="#{funcaoServidorController.funcaoServidor.funcao.tipoFuncao.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{funcaoServidorController.tipoFuncoes}" />
					<a4j:support event="onchange"
						action="#{funcaoServidorController.listarFuncoes}"
						ajaxSingle="true" reRender="funcao"></a4j:support>
				</h:selectOneMenu>

				<h:outputText value="Função:" />
				<h:selectOneMenu id="funcao"
					value="#{funcaoServidorController.funcaoServidor.funcao.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{funcaoServidorController.funcoes}" />
				</h:selectOneMenu>

				<h:outputText value="Siape do Servidor:" />
				<h:inputText
					value="#{funcaoServidorController.funcaoServidor.servidor.siape}"
					size="10" maxlength="7" onkeyup="mascara(this, soNumeros);"></h:inputText>

				<h:outputText value="Local Exercício: " />
				<h:selectOneMenu
					value="#{funcaoServidorController.funcaoServidor.localExercicio.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{funcaoServidorController.locaisExercicio}" />
				</h:selectOneMenu>

				<h:outputText value="Atual: " />
				<h:selectBooleanCheckbox
					value="#{funcaoServidorController.indAtual}">
				</h:selectBooleanCheckbox>

				<a4j:commandButton value="Pesquisar"
					action="#{funcaoServidorController.pesquisarFuncoes}"
					reRender="listaFuncoes, form" type="submit" />
			</h:panelGrid>
			<a4j:region>

				<rich:dataTable id="listaFuncoes"
					value="#{funcaoServidorController.listaFuncoes}" var="list"
					width="1150px" columnClasses="center" rows="15">

					<rich:column width="80px" sortBy="#{list.funcao.tipoFuncao.sigla}">
						<f:facet name="header">
							<h:outputText value="Tipo Função" />
						</f:facet>
						<h:outputText value="#{list.funcao.tipoFuncao.sigla}" />
					</rich:column>

					<rich:column width="180px" sortBy="#{list.funcao.descricao}">
						<f:facet name="header">
							<h:outputText value="Função" />
						</f:facet>
						<h:outputText value="#{list.funcao.descricao}" />
					</rich:column>

					<rich:column width="250px" sortBy="#{list.servidor.nome}">
						<f:facet name="header">
							<h:outputText value="Nome do Servidor" />
						</f:facet>
						<h:outputText value="#{list.servidor.nome}" />
					</rich:column>
					
					<rich:column width="130px" sortBy="#{list.localExercicio.descricao}">
						<f:facet name="header">
							<h:outputText value="Local Exercício" />
						</f:facet>
						<h:outputText value="#{list.localExercicio.descricao}" />
					</rich:column>

					<rich:column width="60px" sortBy="#{list.dataEntrada}">
						<f:facet name="header">
							<h:outputText value="Data Entrada" />
						</f:facet>
						<h:outputText value="#{list.dataEntrada}">
							<f:convertDateTime pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>

					<rich:column width="60px" sortBy="#{list.dataSaida}">
						<f:facet name="header">
							<h:outputText value="Data Saída" />
						</f:facet>
						<h:outputText value="#{list.dataSaida}">
							<f:convertDateTime pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>

					<rich:column width="200px" sortBy="#{list.funcao.atoCriacao}">
						<f:facet name="header">
							<h:outputText value="Ato de Criação" />
						</f:facet>
						<h:outputText value="#{list.funcao.atoCriacao}" />
					</rich:column>

					<rich:column width="40">
						<f:facet name="header">
							<h:outputText value="Editar" />
						</f:facet>
						<a4j:commandLink action="#{funcaoServidorController.carregar}" reRender="listaFuncoes"
							ajaxSingle="true">
							<h:graphicImage value="../images/edit.gif" style="border:0"
								width="20" height="18" id="editar" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{funcaoServidorController.funcaoServidor.codigo}" />
						</a4j:commandLink>
						<rich:toolTip for="editar" value="Editar" />
					</rich:column>

					<f:facet name="footer">
						<rich:datascroller id="ds"></rich:datascroller>
					</f:facet>
				</rich:dataTable>
			</a4j:region>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>