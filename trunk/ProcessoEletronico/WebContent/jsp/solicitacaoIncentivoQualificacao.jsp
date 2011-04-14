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

			<font size="2"><b>INCENTIVO A QUALIFICAÇÃO</b></font>
			<h:panelGrid columns="2">
				<h:outputText
					value="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.servidor.siape} - #{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.servidor.nome}">
				</h:outputText>
			</h:panelGrid>
			<br>
			<h:outputText
				value="Clique na Titulação que deseja receber o incentivo: ">
			</h:outputText>
			<rich:dataTable id="listaTitulacoes"
				value="#{solicitacaoIncentivoQualificacaoController.listaTitulacoes}"
				var="list" width="1150px" columnClasses="center" rows="15"
				reRender="ds, dados">
				<a4j:support event="onRowClick"
					actionListener="#{solicitacaoIncentivoQualificacaoController.selectionChanged}"
					reRender="form" />

				<rich:column width="280px">
					<f:facet name="header">
						<h:outputText value="Titulação" />
					</f:facet>
					<h:outputText value="#{list.titulacao.descricao}" />
				</rich:column>

				<rich:column width="280px">
					<f:facet name="header">
						<h:outputText value="Curso" />
					</f:facet>
					<h:outputText value="#{list.curso}" />
				</rich:column>

				<rich:column width="280px">
					<f:facet name="header">
						<h:outputText value="Area de Conhecimento" />
					</f:facet>
					<h:outputText value="#{list.areaConhecimento.descricao}" />
				</rich:column>

				<f:facet name="footer">
					<rich:datascroller id="ds"></rich:datascroller>
				</f:facet>
			</rich:dataTable>
			<br>
			<h:outputText value="Titulação selecionada: " id="labelDados"
				rendered="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.codigo != 0 && solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.codigo != null}">
			</h:outputText>
			<h:panelGrid columns="4" id="dados"
				rendered="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.codigo != 0 && solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.codigo != null}">
				<h:outputText value="Tiulação: " />
				<h:outputText
					value="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.titulacao.descricao}" />
				<h:outputText value="Estabelecimento de Ensino: " />
				<h:outputText styleClass="maiusculo"
					value="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.estabelecimentoEnsino}" />

				<h:outputText value="Curso: " />
				<h:outputText styleClass="maiusculo"
					value="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.curso}" />

				<h:outputText value="Area de Conhecimento: " />
				<h:outputText
					value="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.areaConhecimento.descricao}" />

				<h:outputText value="Estado do Estabelecimento de Ensino: "
					rendered="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.cidadeEstabelecimentoEnsino.estado.codigo != 0}" />
				<h:outputText
					rendered="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.cidadeEstabelecimentoEnsino.estado.codigo != 0}"
					value="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.cidadeEstabelecimentoEnsino.estado.descricao}">
				</h:outputText>

				<h:outputText value="Cidade de Estabelecimento de Ensino: " />
				<h:outputText
					rendered="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.cidadeEstabelecimentoEnsino.codigo != 0}"
					value="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.cidadeEstabelecimentoEnsino.descricao}">
				</h:outputText>

				<h:outputText value="Carga Horária: " />
				<h:outputText
					value="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.cargaHoraria}"></h:outputText>

				<h:outputText value="Ano de Conclusão: "
					rendered="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.anoConclusao != null}" />

				<h:outputText
					rendered="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.anoConclusao != null}"
					value="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.anoConclusao}">
				</h:outputText>

				<h:outputText value="Registro no Conselho: "
					rendered="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.registroConselho != '' && solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.registroConselho != null}" />

				<h:outputText
					rendered="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.registroConselho != '' && solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.registroConselho != null}"
					value="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.registroConselho}"></h:outputText>

				<h:outputText value="Orgão Emissor do Registro: "
					rendered="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.orgaoEmissor != '' && solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.orgaoEmissor != null}" />

				<h:outputText styleClass="maiusculo"
					rendered="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.orgaoEmissor != '' && solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.orgaoEmissor != null}"
					value="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.orgaoEmissor}"></h:outputText>

				<h:outputText value="Estado do Orgão Emissor: "
					rendered="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.estadoOrgaoEmissor != null && solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.estadoOrgaoEmissor != ''}" />
				<h:outputText
					rendered="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.estadoOrgaoEmissor != null && solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.estadoOrgaoEmissor != ''}"
					value="#{solicitacaoIncentivoQualificacaoController.solicitacaoIncentivoQualificacao.servidorTitulacao.estadoOrgaoEmissor.descricao}">
				</h:outputText>

			</h:panelGrid>
			<a4j:commandButton value="Salvar"
				action="#{solicitacaoIncentivoQualificacaoController.salvar}"
				reRender="form" />
		</rich:panel></center>
	</a4j:form>

</f:view>
</body>
</html>