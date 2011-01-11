<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instituto Federal do Paraná</title>
</head>
<body>
<f:view>
	<jsp:directive.include file="menus.jsp" />
	<center><a4j:form id="form">
		<rich:panel>
		    <font size="2"><b>LISTAR DOCUMENTOS</b></font>
			<h:panelGrid columns="13">
				<h:outputText value="Siape do Servidor: ">
				</h:outputText>
				<h:inputText value="#{documentoImagemController.documentoImagem.servidor.siape}" size="10"
					maxlength="7" onkeyup="mascara(this, soNumeros);">
				</h:inputText>

				<h:outputText value="Tipo Documento: " />
				<h:selectOneMenu value="#{documentoImagemController.documentoImagem.tipoDocumento.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{documentoImagemController..tiposDocumentos}" />
				</h:selectOneMenu>

				<h:outputText value="Titular do Documento: ">
				</h:outputText>
				<h:selectOneMenu value="#{documentoImagemController.titularDocumento}">
					<f:selectItem itemLabel="SERVIDOR" itemValue="1" />
					<f:selectItem itemLabel="CÔNJUGE" itemValue="2" />
					<f:selectItem itemLabel="DEPENDENTE" itemValue="3" />
				</h:selectOneMenu>

				<a4j:commandButton value="Pesquisar"
					action="#{documentoImagemController.pesquisarDocumentos}"
					reRender="listarPortarias" type="submit" />
			</h:panelGrid>

			<rich:messages layout="list">
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<rich:dataTable id="listaDocumento"
				value="#{documentoImagemController.documentoList}" var="list" width="1150px"
				columnClasses="center" rows="15" reRender="ds">
				
				
				<rich:column width="420px" sortBy="#{list.servidor.nome}">
					<f:facet name="header">
						<h:outputText value="Nome do Titular" />
					</f:facet>
					<h:outputText value="#{list.servidor.nome}" />
				</rich:column>
				
				<rich:column width="50px" sortBy="#{list.tipoDocumento.descricao}">
					<f:facet name="header">
						<h:outputText value="Tipo Documento" />
					</f:facet>
					<h:outputText value="#{list.tipoDocumento.descricao}" />
				</rich:column>

				<f:facet name="footer">
					<rich:datascroller id="ds"></rich:datascroller>
				</f:facet>
			</rich:dataTable>
		</rich:panel>
	</a4j:form> </center>
	
</f:view>
</body>
</html>
