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
			<font size="2"><b>CADASTRAR PROGRESSÃO</b></font>

			<h:panelGrid columns="4">
				<h:outputText value="Siape do Servidor: ">
				</h:outputText>
				<h:inputText id="siape"
					value="#{progressaoController.progressao.servidor.siape}" size="10"
					maxlength="7" required="true"
					requiredMessage="Campo Siape do Servidor é obrigatório!">
					<a4j:support event="onchange"
						action="#{progressaoController.buscarServidor}" ajaxSingle="true"
						reRender="servidor,siape, classeAtual,padraoAtual,classeNova"></a4j:support>
				</h:inputText>

				<h:outputText value="Nome do Servidor: ">
				</h:outputText>
				<h:outputText id="servidor"
					value="#{progressaoController.progressao.servidor.nome}">
				</h:outputText>

				<h:outputText value="Classe Atual: "></h:outputText>
				<h:outputText id="classeAtual"
					value="#{progressaoController.progressao.servidor.cargo.classe.sigla}"></h:outputText>
				<h:outputText value="Padrão Atual: "></h:outputText>
				<h:outputText id="padraoAtual"
					value="#{progressaoController.progressao.servidor.padrao.nivel}"></h:outputText>
				<h:outputText value="Classe Nova: "></h:outputText>
				<h:outputText id="classeNova"
					value="#{progressaoController.progressao.servidor.cargo.classe.sigla}"></h:outputText>
				<h:outputText value="Padrão Novo: "></h:outputText>
				<h:selectOneMenu
					value="#{progressaoController.progressao.padraoNovo}"
					required="true" requiredMessage="Campo Padrão Novo é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{progressaoController.padroes}" />
				</h:selectOneMenu>

				<h:outputText value="Data da Progressão: " />
				<rich:calendar
					value="#{progressaoController.progressao.dataProgressao}" locale=""
					popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					inputSize="12" required="true"
					requiredMessage="Campo Data da Progressão é obrigatório!" />
				<h:outputText value="Tipo Progressão: "></h:outputText>
				<h:selectOneMenu
					value="#{progressaoController.progressao.tipoProgressao.codigo}"
					required="true"
					requiredMessage="Campo Tipo Progressão é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{progressaoController.tiposProgressoes}" />
					<a4j:support event="onchange"
						action="#{progressaoController.validarTipoProgressao}"
						ajaxSingle="true" reRender="titulacoes, listaTitulacoes"></a4j:support>
				</h:selectOneMenu>
				<h:outputText value="Portaria: "></h:outputText>
				<h:inputText value="#{progressaoController.progressao.portaria}"
					size="40" maxlength="60"
					requiredMessage="Campo Portaria é obrigatório!" required="true"></h:inputText>
			</h:panelGrid>

			<h:panelGrid columns="1" id="titulacoes">
				<rich:dataTable id="listaTitulacoes"
					value="#{progressaoController.titulacoes}" var="list"
					width="1150px" columnClasses="center" rows="15"
					rendered="#{not empty progressaoController.titulacoes}">
					<rich:column width="350px" sortBy="#{list.titulacao.descricao}">
						<f:facet name="header">
							<h:outputText value="Titulacao" />
						</f:facet>
						<h:outputText value="#{list.titulacao.descricao}" />
					</rich:column>
					<rich:column width="550px" sortBy="#{list.curso}">
						<f:facet name="header">
							<h:outputText value="Curso" />
						</f:facet>
						<h:outputText value="#{list.curso}" />
					</rich:column>
					<rich:column width="400px"
						sortBy="#{list.areaConhecimento.descricao}">
						<f:facet name="header">
							<h:outputText value="Area de Conhecimento" />
						</f:facet>
						<h:outputText value="#{list.areaConhecimento.descricao}" />
					</rich:column>
				</rich:dataTable>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<a4j:commandButton value="Salvar"
					action="#{lotacaoController.salvar}" reRender="form" />
			</h:panelGrid>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>