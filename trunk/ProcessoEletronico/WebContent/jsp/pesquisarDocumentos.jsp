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
			<font size="2"><b>LISTAR DOCUMENTOS</b></font>
			<h:panelGrid columns="13">
				<h:outputText value="Siape do Servidor: ">
				</h:outputText>
				<h:inputText
					value="#{documentoImagemController.documentoImagem.servidor.siape}"
					size="10" maxlength="7" onkeypress="mascara(this, soNumeros);">
				</h:inputText>

				<h:outputText value="Tipo Documento: " />
				<h:selectOneMenu
					value="#{documentoImagemController.documentoImagem.tipoDocumento.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{documentoImagemController.tiposDocumentos}" />
				</h:selectOneMenu>

				<h:outputText value="Titular do Documento: ">
				</h:outputText>
				<h:selectOneMenu
					value="#{documentoImagemController.titularDocumento}">
					<f:selectItem itemLabel="SERVIDOR" itemValue="1" />
					<f:selectItem itemLabel="CÔNJUGE" itemValue="2" />
					<f:selectItem itemLabel="DEPENDENTE" itemValue="3" />
					<f:selectItem itemLabel="TITULAÇÃO" itemValue="4" />
				</h:selectOneMenu>
				
				<h:outputText value="Validado:" />
				<h:selectOneMenu
					value="#{documentoImagemController.validado}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="SIM" itemValue="1" />
					<f:selectItem itemLabel="NÃO" itemValue="2" />
				</h:selectOneMenu>

				<a4j:commandButton value="Pesquisar"
					action="#{documentoImagemController.pesquisarDocumentos}"
					reRender="listaDocumento" type="submit" />
			</h:panelGrid>
			
			<a4j:commandButton value="Voltar" onclick="history.go(-1)"
				rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}">
			</a4j:commandButton>

			<rich:dataTable id="listaDocumento"
				value="#{documentoImagemController.documentoList}" var="list"
				width="1150px" columnClasses="center" rows="15" reRender="ds">


				<rich:column width="500px">
					<f:facet name="header">
						<h:outputText value="Nome do Titular" />
					</f:facet>
					<h:outputText value="#{list.servidor.nome} - (SERVIDOR)"
						rendered="#{list.servidor.codigo != null}" />
					<h:outputText value="#{list.conjuge.nome} - (CÔNJUGE)"
						rendered="#{list.conjuge.codigo != null}" />
					<h:outputText value="#{list.dependente.nome} - (DEPENDENTE)"
						rendered="#{list.dependente.codigo != null}" />
						<h:outputText value="#{list.servidorTitulacao.curso} - #{list.servidorTitulacao.titulacao.descricao} - (TITULACAO)"
						rendered="#{list.servidorTitulacao.codigo != null}" />
				</rich:column>

				<rich:column width="500px">
					<f:facet name="header">
						<h:outputText value="Tipo Documento" />
					</f:facet>
					<h:outputText value="#{list.tipoDocumento.descricao}" />
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
					<a4j:commandLink action="#{documentoImagemController.carregar}"
						reRender="editPanel" ajaxSingle="true"
						oncomplete="#{rich:component('editPanel')}.show()">
						<h:graphicImage value="../images/edit.gif" style="border:0"
							width="20" height="18" id="editar" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{documentoImagemController.documentoImagem.codigo}" />
					</a4j:commandLink>
					<rich:toolTip for="visualizar" value="Visualizar" />
				</rich:column>

				<f:facet name="footer">
					<rich:datascroller id="ds"></rich:datascroller>
				</f:facet>
			</rich:dataTable>
		</rich:panel>
	</a4j:form></center>
	<center><rich:modalPanel id="editPanel" autosized="false"
		width="700" height="400" style="overflow: auto;">
		<h:form>
			<center><font size="2"><b>IMAGEM DO DOCUMENTO</b></font> <h:panelGroup
				id="info">
				<rich:panel bodyClass="info">
					<rich:dataGrid columns="1"
						value="#{documentoImagemController.documentoImagem.imagem1}"
						var="file" rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="5">
								<a4j:mediaOutput element="img"
									createContent="#{documentoImagemController.paint1}"
									value="#{row}" style="width:600px; height:800px;"
									cacheable="false">
								</a4j:mediaOutput>
							</h:panelGrid>
						</rich:panel>
					</rich:dataGrid>
					<rich:dataGrid columns="1"
						value="#{documentoImagemController.documentoImagem.imagem2}"
						var="file" rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="5">
								<a4j:mediaOutput element="img"
									createContent="#{documentoImagemController.paint2}"
									value="#{row}" style="width:600px; height:800px;"
									cacheable="false">
								</a4j:mediaOutput>
							</h:panelGrid>
						</rich:panel>
					</rich:dataGrid>
					<rich:dataGrid columns="1"
						value="#{documentoImagemController.documentoImagem.imagem3}"
						var="file" rowKeyVar="row">
						<rich:panel bodyClass="rich-laguna-panel-no-header">
							<h:panelGrid columns="5">
								<a4j:mediaOutput element="img"
									createContent="#{documentoImagemController.paint3}"
									value="#{row}" style="width:600px; height:800px;"
									cacheable="false">
								</a4j:mediaOutput>
							</h:panelGrid>
						</rich:panel>
					</rich:dataGrid>
				</rich:panel>
			</h:panelGroup> <h:panelGrid columns="2">
				<a4j:commandButton value="Aprovar" reRender="form, listaDocumento"
					action="#{documentoImagemController.validar}" />
				<a4j:commandButton value="Fechar"
					onclick="#{rich:component('editPanel')}.hide();return false;" />
			</h:panelGrid></center>
		</h:form>
	</rich:modalPanel></center>

</f:view>
</body>
</html>
