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
			<font size="2"><b>PESQUISAR REMOÇÕES</b></font>
			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<h:panelGrid columns="9">
				<h:outputText value="Siape do Servidor:" />
				<h:inputText value="#{remocaoController.remocao.servidor.siape}"
					size="7" maxlength="7" onkeyup="mascara(this, soNumeros);"></h:inputText>
				<h:outputText value="Nome do Servidor:" />
				<h:inputText value="#{remocaoController.remocao.servidor.nome}"
					size="60" maxlength="120"></h:inputText>

				<a4j:commandButton value="Pesquisar"
					action="#{remocaoController.pesquisar}"
					reRender="listaRemocoes" type="submit" />

			</h:panelGrid>
			<a4j:region>

				<rich:dataTable id="listaRemocoes"
					value="#{remocaoController.remocaoList}" var="list" width="1150px"
					columnClasses="center" rows="15">
					<rich:column width="80px" sortBy="#{list.servidor.siape}">
						<f:facet name="header">
							<h:outputText value="Siape" />
						</f:facet>
						<h:outputText value="#{list.servidor.siape}" />
					</rich:column>

					<rich:column width="700px" sortBy="#{list.servidor.nome}">
						<f:facet name="header">
							<h:outputText value="Servidor" />
						</f:facet>
						<h:outputText value="#{list.servidor.nome}" />
					</rich:column>

					<rich:column width="500px" sortBy="#{list.lotacao.descricao}">
						<f:facet name="header">
							<h:outputText value="Lotacao" />
						</f:facet>
						<h:outputText value="#{list.lotacao.descricao}" />
					</rich:column>


					<rich:column width="80px" sortBy="#{list.dataEntrada}">
						<f:facet name="header">
							<h:outputText value="Data de Admissão" />
						</f:facet>
						<h:outputText value="#{list.dataEntrada}">
							<f:convertDateTime pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>

					<rich:column width="80px" sortBy="#{list.dataSaida}">
						<f:facet name="header">
							<h:outputText value="Data de Saida" />
						</f:facet>
						<h:outputText value="#{list.dataSaida}">
							<f:convertDateTime pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>


					<rich:column>
						<f:facet name="header">
							<h:outputText value="Editar" />
						</f:facet>
						<a4j:commandLink action="#{remocaoController.carregar}"
							reRender="listaRemocoes" ajaxSingle="true">
							<h:graphicImage value="../images/edit.gif" style="border:0"
								width="20" height="18" id="editar" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{remocaoController.remocao.codigo}" />
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