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

			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoAlimentacaoController.solicitacaoAlimentacao.solicitante.siape} - #{solicitacaoAlimentacaoController.solicitacaoAlimentacao.solicitante.nome}">
				</h:outputText>
				<h:outputText
					value="#{solicitacaoAlimentacaoController.solicitacaoAlimentacao.solicitante.regimeTrabalho.descricao}">
				</h:outputText>
			</h:panelGrid>
			
			
			
			<h:panelGrid columns="2">
				<h:outputText value="Incluir Auxílio"></h:outputText>
				D
					<h:selectOneRadio id="indAlimentacao" value="#{solicitacaoAlimentacaoController.solicitacaoAlimentacao.indAlimentacao}"
						title="Incluir Auxílio" 
						border="1">
						<f:selectItem id="true" itemLabel="Incluir" itemValue="true" />
						<f:selectItem id="false" itemLabel="Cancelae" itemValue="false" />
					</h:selectOneRadio>

				<!--				<h:selectOneRadio id="indAlimentacaoTrue"-->
<!--					value="#{solicitacaoAlimentacaoController.solicitacaoAlimentacao.indAlimentacao}">-->
<!--					<f:selectItem itemValue="true" itemLabel="Inclusão" />-->
<!--					<f:selectItem itemValue="false" itemLabel="Alteração" />-->
<!--				</h:selectOneRadio>-->
<!--								<h:selectOneRadio  id="indAlimentacaoFalse"-->
<!--					value="#{solicitacaoAlimentacaoController.solicitacaoAlimentacao.indAlimentacao}">-->
<!--					<f:selectItem itemValue="true" itemLabel="Inclusão" />-->
<!--					<f:selectItem itemValue="false" itemLabel="Alteração" />-->
<!--				</h:selectOneRadio>-->
<!--				-->
			</h:panelGrid>

<!--			<h:panelGrid columns="2">-->
<!--				<h:outputText value="Incluir Auxílio"></h:outputText>-->
<!--				<h:selectOneRadio styleClass="selectOneRadio" id="indAlimentacao"-->
<!--					value="#{solicitacaoAlimentacaoController.solicitacaoAlimentacao.indAlimentacao}">-->
<!--					<f:selectItem itemValue="true" itemLabel="Inclusão" />-->
<!--					<f:selectItem itemValue="false" itemLabel="Alteração" />-->
<!--				</h:selectOneRadio>-->
<!--			</h:panelGrid>-->
				<!-- 		<h:selectBooleanCheckbox
					value="{solicitacaoAlimentacaoController.solicitacaoAlimentacao.indAlimentacao}">
				</h:selectBooleanCheckbox>
				<h:selectBooleanCheckbox
					value="{solicitacaoAlimentacaoController.solicitacaoAlimentacao.indAlimentacao}"></h:selectBooleanCheckbox>-->
<!--			</h:panelGrid>-->
<!--				<-->
<!--					value="{solicitacaoAlimentacaoController.solicitacaoAlimentacao.indAlimentacao}">-->
<!--				</h:radioButtonGroup>-->
<!--				<h:radioButtonGroup-->
<!--					value="{solicitacaoAlimentacaoController.solicitacaoAlimentacao.indAlimentacao}">-->
<!--					</h:radioButtonGroup>-->
			
			<a4j:commandButton value="Salvar"
				action="#{solicitacaoAlimentacaoController.salvar}" />
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>