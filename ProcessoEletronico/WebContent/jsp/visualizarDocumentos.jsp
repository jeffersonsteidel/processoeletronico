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
				<rich:messages id="messages" layout="list"
					errorLabelClass="errorLabel" style="top:auto;"
					infoLabelClass="infoLabel">
					<f:facet name="infoMarker">
						<h:graphicImage value="../images/passed.gif" />
					</f:facet>
					<f:facet name="errorMarker">
						<h:graphicImage value="../images/error.gif" />
					</f:facet>
				</rich:messages>

				<font size="2"><b>APROVAR DOCUMENTO</b></font>
				
				<h:panelGrid columns="2">
				
				<h:outputText value="Titular: "></h:outputText>
				<h:outputText value="#{documentoImagemController.documentoImagem.dependente.nome} - DEPENDENTE" rendered="#{documentoImagemController.documentoImagem.dependente != null}"></h:outputText>
				<h:outputText value="#{documentoImagemController.documentoImagem.conjuge.nome} - CONJUGE" rendered="#{documentoImagemController.documentoImagem.conjuge != null}"></h:outputText>
				<h:outputText value="#{documentoImagemController.documentoImagem.servidor.nome} - SERVIDOR" rendered="#{documentoImagemController.documentoImagem.servidor != null}"></h:outputText>
				<h:outputText value="#{documentoImagemController.documentoImagem.emprego.cargo} - EMPREGO" rendered="#{documentoImagemController.documentoImagem.emprego != null}"></h:outputText>
				<h:outputText value="#{documentoImagemController.documentoImagem.servidorTitulacao.nome} - TITULAÇÃO" rendered="#{documentoImagemController.documentoImagem.servidorTitulacao != null}"></h:outputText>
				
				<h:outputText value="Tipo de documento: "></h:outputText>
				<h:outputText value="#{documentoImagemController.documentoImagem.tipoDocumento.descricao}"></h:outputText>
				
				</h:panelGrid>
				
				<h:form>
					<center><h:panelGroup id="info">
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
						<a4j:commandButton value="Voltar" action="#{documentoImagemController.voltar}" />
					</h:panelGrid></center>
				</h:form>
			</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>