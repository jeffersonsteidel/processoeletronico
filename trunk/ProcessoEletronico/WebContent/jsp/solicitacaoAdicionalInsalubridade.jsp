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

			<font size="2"><b>ADICIONAL DE INSALUBRIDADE</b></font>
			<h:panelGrid columns="1">
				<h:outputText
					value="#{solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.solicitante.siape} - #{solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.solicitante.nome} - #{solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.solicitante.cargo.descricao}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="3">

				<h:outputText value="Tarefas Diarias: " />
				<h:outputText value="Tarefas Semanais: " />
				<h:outputText value="Tarefas Mensais: " />
				<h:inputTextarea
					value="#{solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.tarefasDiarias}"
					rows="5" cols="50" required="true"
					requiredMessage="Campo Tarefas Diarias é obrigatório!"
					validatorMessage="Tarefas Diarias deve ter no máximo 250 caracteres!">
					<f:validateLength maximum="250"></f:validateLength>
				</h:inputTextarea>


				<h:inputTextarea
					value="#{solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.tarefasSemanais}"
					rows="5" cols="50" required="true"
					requiredMessage="Campo Tarefas Semanais é obrigatório!"
					validatorMessage="Tarefas Semanais deve ter no máximo 250 caracteres!">
					<f:validateLength maximum="250"></f:validateLength>
				</h:inputTextarea>


				<h:inputTextarea
					value="#{solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.tarefasMensais}"
					rows="5" cols="50" required="true"
					requiredMessage="Campo Tarefas Mensais é obrigatório!"
					validatorMessage="Tarefas Mensais deve ter no máximo 250 caracteres!">
					<f:validateLength maximum="250"></f:validateLength>
				</h:inputTextarea>
			</h:panelGrid>

			<h:panelGrid columns="6">

				<h:outputText value="Riscos Físicos: " />
				<h:selectBooleanCheckbox id="riscosFisicos" title="Riscos Físicos"
					value="#{solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.indRiscosFisicos}">
					<a4j:support event="onchange" action="#"
						reRender="descricaoRiscosFisicos">
					</a4j:support>
				</h:selectBooleanCheckbox>
				<h:inputTextarea id="descricaoRiscosFisicos"
					value="#{solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.justRiscosFisicos}"
					rows="5" cols="50" required="true"
					requiredMessage="Campo Descrição dos Riscos Físicos é obrigatório!"
					disabled="#{!solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.indRiscosFisicos}"
					validatorMessage="A Descrição dos Riscos Físicos deve ter no máximo 250 caracteres!">
					<f:validateLength maximum="250"></f:validateLength>
				</h:inputTextarea>

				<h:outputText value="Riscos Químico: " />
				<h:selectBooleanCheckbox id="riscosQuimicos" title="Riscos Químicos"
					value="#{solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.indRiscosQuimicos}">
					<a4j:support event="onchange" action="#"
						reRender="descricaoRiscosQuimicos">
					</a4j:support>
				</h:selectBooleanCheckbox>
				<h:inputTextarea id="descricaoRiscosQuimicos"
					value="#{solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.justRiscosQuimicos}"
					rows="5" cols="50" required="true"
					requiredMessage="Campo Descrição dos Riscos Químicos é obrigatório!"
					disabled="#{!solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.indRiscosQuimicos}"
					validatorMessage="A Descrição dos Riscos Químicos deve ter no máximo 250 caracteres!">
					<f:validateLength maximum="250"></f:validateLength>
				</h:inputTextarea>

				<h:outputText value="Riscos Biologicos: " />
				<h:selectBooleanCheckbox id="riscosBiologicos"
					value="#{solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.indRiscosBiologicos}">
					<a4j:support event="onchange" action="#"
						reRender="descricaoRiscosBiologicos">
					</a4j:support>
				</h:selectBooleanCheckbox>
				<h:inputTextarea id="descricaoRiscosBiologicos"
					value="#{solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.justRiscosBiologicos}"
					rows="5" cols="50" required="true"
					requiredMessage="Campo Descrição dos Riscos Biologicos é obrigatório!"
					disabled="#{!solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.indRiscosBiologicos}"
					validatorMessage="A Descrição dos Riscos Biologicos deve ter no máximo 250 caracteres!">
					<f:validateLength maximum="250"></f:validateLength>
				</h:inputTextarea>

				<h:outputText value="Riscos por Radiação Ionizante: " />
				<h:selectBooleanCheckbox id="riscosIrradiacaoIonizante"
					value="#{solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.indRiscosIrradiacaoIonizante}">
					<a4j:support event="onchange" action="#"
						reRender="descricaoRiscosIrradiacaoIonizante">
					</a4j:support>
				</h:selectBooleanCheckbox>
				<h:inputTextarea id="descricaoRiscosIrradiacaoIonizante"
					value="#{solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.justRiscosIrradiacaoIonizante}"
					rows="5" cols="50" required="true"
					requiredMessage="Campo Descrição dos Riscos por Radiacao Ionizante é obrigatório!"
					disabled="#{!solicitacaoAdicionalInsalubridadeController.solicitacaoAdicionalInsalubridade.indRiscosIrradiacaoIonizante}"
					validatorMessage="A Descrição dos Riscos por Radiação Ionizante deve ter no máximo 250 caracteres!">
					<f:validateLength maximum="250"></f:validateLength>
				</h:inputTextarea>

			</h:panelGrid>
			<a4j:commandButton value="Salvar"
				action="#{solicitacaoAdicionalInsalubridadeController.salvar}"
				reRender="form" />
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>