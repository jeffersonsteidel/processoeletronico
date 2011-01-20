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
	<center><a4j:form id="form">
		<rich:panel>
			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<font size="2"><b>LISTAR RESSARCIMENTO SAÚDE</b></font>
		
			<h:panelGrid columns="13">
				<h:outputText value="Siape do Servidor: ">
				</h:outputText>
				<h:inputText
					value="#{ressarcimentoSaudeController.ressarcimentoSaudeTemp.servidor.siape}"
					size="10" maxlength="7" onkeyup="mascara(this, soNumeros);">
				</h:inputText>

				<h:outputText value="Tipo Plano: " />
				<h:selectOneMenu
					value="#{ressarcimentoSaudeController.ressarcimentoSaudeTemp.tipoPlano.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{ressarcimentoSaudeController.tiposPlanos}" />
				</h:selectOneMenu>

				<h:outputText value="Implantado:" />
				<h:selectOneMenu
					value="#{ressarcimentoSaudeController.implantado}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="SIM" itemValue="1" />
					<f:selectItem itemLabel="NÃO" itemValue="2" />
				</h:selectOneMenu>

				<a4j:commandButton value="Pesquisar"
					action="#{ressarcimentoSaudeController.pesquisar}"
					reRender="listaRessarcimento" type="submit" />
			</h:panelGrid>

			<rich:dataTable id="listaRessarcimento"
				value="#{ressarcimentoSaudeController.ressarcimentoList}" var="list"
				width="1150px" columnClasses="center" rows="15" reRender="ds">


				<rich:column width="500px">
					<f:facet name="header">
						<h:outputText value="Servidor" />
					</f:facet>
					<h:outputText value="#{list.servidor.nome}"/>
				</rich:column>

				<rich:column width="500px">
					<f:facet name="header">
						<h:outputText value="Tipo Plano" />
					</f:facet>
					<h:outputText value="#{list.tipoPlano.descricao}" />
				</rich:column>
				
				<rich:column width="500px">
					<f:facet name="header">
						<h:outputText value="Nome Plano" />
					</f:facet>
					<h:outputText value="#{list.nomePlano}"/>
				</rich:column>

				<rich:column width="100px">
					<f:facet name="header">
						<h:outputText value="Implantado" />
					</f:facet>
					<h:outputText value="SIM" rendered="#{list.indImplantado}" />
					<h:outputText value="NÃO" rendered="#{!list.indImplantado}" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Visualizar" />
					</f:facet>
					<a4j:commandLink action="#{ressarcimentoSaudeController.carregar}"
						reRender="editPanel" ajaxSingle="true"
						oncomplete="#{rich:component('editPanel')}.show()">
						<h:graphicImage value="../images/edit.gif" style="border:0"
							width="20" height="18" id="editar" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{ressarcimentoSaudeController.ressarcimentoSaude.codigo}" />
					</a4j:commandLink>
					<rich:toolTip for="editar" value="Editar" />
				</rich:column>

				<f:facet name="footer">
					<rich:datascroller id="ds"></rich:datascroller>
				</f:facet>
			</rich:dataTable>
			
		</rich:panel>
	</a4j:form></center>
	
	<center><rich:modalPanel id="editPanel" autosized="false"
		style="overflow: auto;" height="500" width="1000">
		<f:facet name="header">
			<h:panelGroup>
				<center><h:outputText value="Detalhes do Ressarcimento Saúde"></h:outputText></center>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="../images/close.gif"
					onclick="#{rich:component('editPanel')}.hide();" />
			</h:panelGroup>
		</f:facet>
		<h:form>
			<center>
			<h:panelGrid columns="1">
			<br>
				<h:outputText value="Servidor: #{ressarcimentoSaudeController.ressarcimentoSaude.servidor.siape} - #{ressarcimentoSaudeController.ressarcimentoSaude.servidor.nome}" />
				<h:outputText value="Tipo do Plano: #{ressarcimentoSaudeController.ressarcimentoSaude.tipoPlano.descricao}"/>
				<h:outputText value="Nome do Plano: #{ressarcimentoSaudeController.ressarcimentoSaude.nomePlano}" rendered="#{ressarcimentoSaudeController.indParticular}"/>
				<h:outputText value="Numero do Contrato: #{ressarcimentoSaudeController.ressarcimentoSaude.numeroContrato}"/>
			<br>
			</h:panelGrid> 
			<h:panelGroup id="info">
				<rich:panel bodyClass="info">
					<rich:dataGrid
						value="#{ressarcimentoSaudeController.ressarcimentoSaude.files}"
						var="file" rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="2">
								<a4j:mediaOutput element="img"
									createContent="#{ressarcimentoSaudeController.paint}"
									value="#{row}"
									style="width:600px; height:800px; overflow:auto;"
									cacheable="false">
								</a4j:mediaOutput>
							</h:panelGrid>
						</rich:panel>
					</rich:dataGrid>
				</rich:panel>
			</h:panelGroup>
			<h:panelGrid columns="2">
				<a4j:commandButton value="Implantar"
					action="#{ressarcimentoSaudeController.implantar}"
					reRender="listaRessarcimento"/>
				<a4j:commandButton value="Fechar"
					onclick="#{rich:component('editPanel')}.hide();return false;" />
			</h:panelGrid></center>
		</h:form>
	</rich:modalPanel></center>
</f:view>
</body>
</html>
