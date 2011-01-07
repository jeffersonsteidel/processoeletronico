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

			<font size="2"><b>PESQUISAR CÔNJUGE</b></font>
			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<h:panelGrid columns="11">
				<h:outputText value="Siape do Servidor:" />
				<h:inputText value="#{conjugeController.conjuge.servidor.siape}"
					size="7" maxlength="7" onkeyup="mascara(this, soNumeros);"></h:inputText>
				<h:outputText value="Nome do Servidor:" />
				<h:inputText value="#{conjugeController.conjuge.servidor.nome}"
					size="60" maxlength="120"></h:inputText>
				<h:outputText value="Atuais: " />
				<h:selectOneMenu value="#{conjugeController.atuais}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="SIM" itemValue="1" />
					<f:selectItem itemLabel="NÃO" itemValue="2" />
				</h:selectOneMenu>		
				<h:outputText value="Validados: " />
				<h:selectOneMenu value="#{conjugeController.validado}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="SIM" itemValue="1" />
					<f:selectItem itemLabel="NÃO" itemValue="2" />
				</h:selectOneMenu>	
				<h:outputText value="Situação: " />
				<h:selectOneMenu value="#{conjugeController.situacao}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="ATIVOS" itemValue="1" />
					<f:selectItem itemLabel="INATIVOS" itemValue="2" />
				</h:selectOneMenu>
				<a4j:commandButton value="Pesquisar"
					action="#{conjugeController.buscarConjuges}"
					reRender="listaConjuges" type="submit" />
			</h:panelGrid>
			<a4j:region>

				<rich:dataTable id="listaConjuges"
					value="#{conjugeController.listaConjugesByFilter}" var="list"
					width="1150px" columnClasses="center" rows="15">
					<rich:column width="80px" sortBy="#{list.servidor.siape}">
						<f:facet name="header">
							<h:outputText value="Siape" />
						</f:facet>
						<h:outputText value="#{list.servidor.siape}" />
					</rich:column>
					<rich:column width="500px" sortBy="#{list.servidor.nome}">
						<f:facet name="header">
							<h:outputText value="Servidor" />
						</f:facet>
						<h:outputText value="#{list.servidor.nome}" />
					</rich:column>
					<rich:column width="550px" sortBy="#{list.nome}">
						<f:facet name="header">
							<h:outputText value="Nome do Cônjuge" />
						</f:facet>
						<h:outputText value="#{list.nome}" />
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
						<h:outputText value="NÃO" rendered="#{!list.indValidado}" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Visualizar" />
						</f:facet>
						<a4j:commandLink action="#{conjugeController.carregar}"
							reRender="editPanel" ajaxSingle="true"
							oncomplete="#{rich:component('editPanel')}.show()">
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
			</a4j:region>
		</rich:panel></center>
	</a4j:form>
	<center><rich:modalPanel id="editPanel" autosized="true"
		width="600">
		<h:form>
			<center><font size="2"><b>DETALHES DO CÔNJUGE</b></font> <h:panelGrid
				columns="2">
				<h:outputText value="Servidor: " />
				<h:outputText
					value="#{conjugeController.conjuge.servidor.siape} - #{conjugeController.conjuge.servidor.nome}" />
			</h:panelGrid> <h:panelGrid columns="4">
				<h:outputText value="Nome do Cônjuge ">
				</h:outputText>
				<h:outputText value="#{conjugeController.conjuge.nome}"></h:outputText>
				<h:outputText value="Sexo do Cônjuge: " />
				<h:outputText value="FEMININO"
					rendered="#{conjugeController.conjuge.sexo == 'F'}"></h:outputText>
				<h:outputText value="MASCULINO"
					rendered="#{conjugeController.conjuge.sexo == 'M'}"></h:outputText>
				<h:outputText value="Data de Nascimento do Cônjuge: " />
				<h:outputText value="#{conjugeController.conjuge.dataNascimento}">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:outputText>
				<h:outputText value="CPF do Cônjuge: " />
				<h:outputText value="#{conjugeController.conjuge.cpf}"></h:outputText>
				<h:outputText value="RG do Cônjuge: " />
				<h:outputText value="#{conjugeController.conjuge.rg}"></h:outputText>
				<h:outputText value="UF do RG do Cônjuge: " />
				<h:outputText value="#{conjugeController.conjuge.rgUf.uf}"></h:outputText>
				<h:outputText value="Orgão Emissor do RG do Cônjuge: " />
				<h:outputText value="#{conjugeController.conjuge.rgOrgao}" />
				<h:outputText value="Data de Expedição do RG do Cônjuge: " />
				<h:outputText value="#{conjugeController.conjuge.rgDataExpedicao}">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:outputText>
				<h:outputText value="Estado de Nascimento do Cônjuge: "
					rendered="#{!conjugeController.conjuge.indEstrangeiro}" />
				<h:outputText id="estadoNascimentoConjuge"
					rendered="#{!conjugeController.conjuge.indEstrangeiro}"
					value="#{conjugeController.conjuge.cidadeNascimento.estado.descricao}" />
				<h:outputText value="Cidade de Nascimento do Cônjuge: "
					rendered="#{!conjugeController.conjuge.indEstrangeiro}" />
				<h:outputText id="cidadeNascimentoConjuge"
					rendered="#{!conjugeController.conjuge.indEstrangeiro}"
					value="#{conjugeController.conjuge.cidadeNascimento.descricao}" />
				<h:outputText value="Estrangeiro: " />
				<h:outputText value="SIM"
					rendered="#{conjugeController.conjuge.indEstrangeiro}" />
				<h:outputText value="NÃO"
					rendered="#{!conjugeController.conjuge.indEstrangeiro}" />
				<h:outputText value="País de Nascimento do Cônjuge: "
					rendered="#{conjugeController.conjuge.indEstrangeiro}" />
				<h:outputText value="#{conjugeController.conjuge.pais.descricao}"
					rendered="#{conjugeController.conjuge.indEstrangeiro}" />
				<h:outputText value="É Servidor? " />
				<h:outputText value="SIM"
					rendered="#{conjugeController.conjuge.indServidor}"></h:outputText>
				<h:outputText value="NÃO"
					rendered="#{!conjugeController.conjuge.indServidor}"></h:outputText>
				<h:outputText value="Órgão de atuação: "
					rendered="#{conjugeController.conjuge.indServidor}" />
				<h:outputText value="#{conjugeController.conjuge.local}"
					rendered="#{conjugeController.conjuge.indServidor}"></h:outputText>
				<h:outputText value="Cônjuge Atual? " />
				<h:outputText value="SIM"
					rendered="#{conjugeController.conjuge.atual}" />
				<h:outputText value="NÃO"
					rendered="#{!conjugeController.conjuge.atual}" />
			</h:panelGrid> <h:panelGrid columns="2">
				<a4j:commandButton value="Aprovar" reRender="form, listaTitulacoes"
					action="#{conjugeController.validar}" />
				<a4j:commandButton value="Fechar"
					onclick="#{rich:component('editPanel')}.hide();return false;" />
			</h:panelGrid></center>
		</h:form>
	</rich:modalPanel></center>
</f:view>
</body>
</html>