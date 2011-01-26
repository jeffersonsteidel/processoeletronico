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

			<font size="2"><b>RESSARCIMENTO SAÚDE</b></font>
			<h:panelGrid columns="1">
				<h:outputText
					value="#{ressarcimentoSaudeController.ressarcimentoSaude.servidor.siape} - #{ressarcimentoSaudeController.ressarcimentoSaude.servidor.nome}">
				</h:outputText>
			</h:panelGrid>
			<h:panelGrid>
				<center><h:outputText
					value="Você já possui um Ressarcimento Cadastrado, se optar em cadastrar um novo Ressarcimento será considerado o de maior data de adesão"
					style="font-weight:bold"
					rendered="#{ressarcimentoSaudeController.existeAnterior}" /></center>
			</h:panelGrid>

			<h:panelGrid columns="10">
				<h:outputText value="Tipo do Plano: "
					rendered="#{ressarcimentoSaudeController.existeAnterior}" />
				<h:outputText
					rendered="#{ressarcimentoSaudeController.existeAnterior}"
					value="#{ressarcimentoSaudeController.ressarcimentoAnterior.tipoPlano.descricao}" />

				<h:outputText value="Nome do Plano: "
					rendered="#{ressarcimentoSaudeController.existeAnterior && ressarcimentoSaudeController.ressarcimentoAnterior.tipoPlano.codigo == 3}" />
				<h:outputText
					rendered="#{ressarcimentoSaudeController.existeAnterior && ressarcimentoSaudeController.ressarcimentoAnterior.tipoPlano.codigo == 3}"
					value="#{ressarcimentoSaudeController.ressarcimentoAnterior.nomePlano}" />

				<h:outputText value="Numero do Contrato: "
					rendered="#{ressarcimentoSaudeController.existeAnterior && ressarcimentoSaudeController.ressarcimentoAnterior.tipoPlano.codigo == 3}" />
				<h:outputText
					value="#{ressarcimentoSaudeController.ressarcimentoAnterior.numeroContrato}"
					rendered="#{ressarcimentoSaudeController.existeAnterior && ressarcimentoSaudeController.ressarcimentoAnterior.tipoPlano.codigo == 3}" />

				<h:outputText value="Data de Adesão: "
					rendered="#{ressarcimentoSaudeController.existeAnterior && ressarcimentoSaudeController.ressarcimentoAnterior.tipoPlano.codigo == 3}" />
				<h:outputText
					rendered="#{ressarcimentoSaudeController.existeAnterior && ressarcimentoSaudeController.ressarcimentoAnterior.tipoPlano.codigo == 3}"
					value="#{ressarcimentoSaudeController.ressarcimentoAnterior.dataAdesao}">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="3">
				<h:outputText value="Status: "
					rendered="#{ressarcimentoSaudeController.existeAnterior}" />
				<h:outputText
					value="#{ressarcimentoSaudeController.ressarcimentoAnterior.status.descricao}"
					rendered="#{ressarcimentoSaudeController.existeAnterior}" />
				<rich:toolTip for="encaminhado" value="Encaminhado" />
				<rich:toolTip for="emAnalise"
					value="Você não pode abrir uma solicitação que está em Análise!" />
				<rich:toolTip for="deferido" value="Deferido" />
				<rich:toolTip for="indeferido" value="Indeferido" />
			</h:panelGrid>
			
			<h:panelGrid columns="1" style="text-align: center"
				rendered="#{ressarcimentoSaudeController.existeAnterior && ressarcimentoSaudeController.ressarcimentoAnterior.status.codigo == 4}">
				<h:outputText value="Motivo do Indeferimento" />
				<h:inputTextarea cols="50" rows="5"
					value="#{ressarcimentoSaudeController.ressarcimentoAnterior.justificativa}"
					disabled="true" />
				<a4j:commandButton value="Corrigir"
					action="#{ressarcimentoSaudeController.carregarRessarcimentoAnterior}" reRender="form" />

			</h:panelGrid>

			<h:panelGrid
				rendered="#{ressarcimentoSaudeController.existeAnterior}">
				<center><h:outputText value="Novo Ressarcimento" /></center>
			</h:panelGrid>
			<h:outputText value="Tipo do Plano: " />
			<h:selectOneRadio
				value="#{ressarcimentoSaudeController.ressarcimentoSaude.tipoPlano.codigo}"
				required="true"
				requiredMessage="O campo Tipo de Plano é obrigatório!">
				<f:selectItems value="#{ressarcimentoSaudeController.tiposPlanos}" />
				<a4j:support event="onchange"
					action="#{ressarcimentoSaudeController.validarTipoPlano}"
					ajaxSingle="true" reRender="form"></a4j:support>
			</h:selectOneRadio>

			<h:panelGrid columns="6"
				rendered="#{ressarcimentoSaudeController.indParticular}">

				<h:outputText value="Nome do Plano: " id="nomePlanoOutput"
					rendered="#{ressarcimentoSaudeController.indParticular}" />
				<h:inputText id="nomePlano" required="true" maxlength="100"
					requiredMessage="O campo Nome do Plano é obrigatório!"
					value="#{ressarcimentoSaudeController.ressarcimentoSaude.nomePlano}"
					rendered="#{ressarcimentoSaudeController.indParticular}" />

				<h:outputText value="Numero do Contrato: " />
				<h:inputText required="true" maxlength="15"
					requiredMessage="O campo Numero do Contrato é obrigatório!"
					value="#{ressarcimentoSaudeController.ressarcimentoSaude.numeroContrato}" />

				<h:outputText value="Data de Adesão: " />
				<rich:calendar required="true"
					requiredMessage="Campo Data de Adesão é Obrigatório!"
					value="#{ressarcimentoSaudeController.ressarcimentoSaude.dataAdesao}"
					locale="" popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					inputSize="12" />
			</h:panelGrid>

			<br>
			<h:outputText
				value="Selecione o Cônjuge para adiciona-lo(a) no plano"
				rendered="#{not empty ressarcimentoSaudeController.conjuges}" />
			<br>
			<rich:dataTable id="listarConjugesSolicitante"
				rendered="#{not empty ressarcimentoSaudeController.conjuges}"
				value="#{ressarcimentoSaudeController.conjuges}" var="list"
				width="700px" columnClasses="center" rows="15" reRender="ds">

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Incluir" />
					</f:facet>
					<h:selectBooleanCheckbox id="incluir"
						value="#{list.indRessarcimentoSaude}">
					</h:selectBooleanCheckbox>
				</rich:column>

				<rich:column width="435px">
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{list.nome}" />
				</rich:column>

				<rich:column width="280px">
					<f:facet name="header">
						<h:outputText value="Atual" />
					</f:facet>
					<h:outputText value="Atual" rendered="#{list.atual}" />
					<h:outputText value="Ex" rendered="#{!list.atual}" />
				</rich:column>
			</rich:dataTable>
			<br>
			<h:outputText
				value="Selecione os Dependentes que deseja adicionar ao plano:"
				rendered="#{not empty ressarcimentoSaudeController.dependentes}" />
			<br>
			<rich:dataTable id="listarDependentesSolicitante"
				rendered="#{not empty ressarcimentoSaudeController.dependentes}"
				value="#{ressarcimentoSaudeController.dependentes}" var="list"
				width="700px" columnClasses="center" rows="15" reRender="ds">

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Incluir" />
					</f:facet>
					<h:selectBooleanCheckbox id="incluir"
						value="#{list.indRessarcimentoSaude}">
					</h:selectBooleanCheckbox>
				</rich:column>

				<rich:column width="435px">
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{list.nome}" />
				</rich:column>
				<rich:column width="280px">
					<f:facet name="header">
						<h:outputText value="Grau de Parentesco" />
					</f:facet>
					<h:outputText value="#{list.grauParentesco.descricao}" />
				</rich:column>
				<rich:column width="280px">
					<f:facet name="header">
						<h:outputText value="Estudante" />
					</f:facet>
					<h:outputText value="SIM" rendered="#{list.indEstudante}" />
					<h:outputText value="NÃO" rendered="#{!list.indEstudante}" />
				</rich:column>
				<rich:column width="280px">
					<f:facet name="header">
						<h:outputText value="Necessidades Especiais" />
					</f:facet>
					<h:outputText value="SIM"
						rendered="#{list.indNecessidadesEspeciais}" />
					<h:outputText value="NÃO"
						rendered="#{!list.indNecessidadesEspeciais}" />
				</rich:column>
			</rich:dataTable>
			<br>
			<rich:fileUpload
				rendered="#{!ressarcimentoSaudeController.indSindicato}"
				fileUploadListener="#{ressarcimentoSaudeController.listener}"
				required="true" maxFilesQuantity="20"
				requiredMessage="É necessário adicionar o Contrato!"
				addControlLabel="Adicionar Contrato" id="upload"
				transferErrorLabel="Falha Ao realizar Transferência"
				doneLabelClass="Finalizada" autoclear="true" immediateUpload="true"
				listWidth="270px" stopControlLabel="Parar"
				acceptedTypes="jpg, gif, png" allowFlash="true"
				sizeErrorLabel="Foto muito grande" uploadControlLabel="Carregar"
				listHeight="70px">
				<a4j:support event="onuploadcomplete" reRender="info" />
			</rich:fileUpload>

			<a4j:commandButton value="Salvar"
				action="#{ressarcimentoSaudeController.salvar}" reRender="form" />

			<h:panelGroup id="info"
				rendered="#{!ressarcimentoSaudeController.indSindicato}">
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
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>