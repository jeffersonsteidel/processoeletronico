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
	<rich:panel>
		<h:form>
			<h:panelGrid columns="3">
				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR POR CONTA BANCÁRIA"
					action="#{relatorioController.gerarRelatorioServidorContaBancaria}" />
				<h:outputText
					value="(retorna todos os servidores, traz o o siape, nome, banco, número da conta, agência, indicador de poupança pelo siape)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR POR LOTAÇÃO E CARGO"
					action="#{relatorioController.gerarRelatorioServidorCargoLotacao}" />
				<h:outputText
					value="(retorna todos os servidores, traz o siape, nome, cargo, lotação e indicador de atividade ordenados pelo siape)" />
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="RELATÓRIO GERAL CÔNJUGE"
					action="#{relatorioController.gerarRelatorioServidorConjuge}" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="RELATÓRIO GERAL DEPENDENTE"
					action="#{relatorioController.gerarRelatorioServidorDependente}" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="RELATÓRIO GERAL EMPREGO"
					action="#{relatorioController.gerarRelatorioServidorEmprego}" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="RELATÓRIO GERAL TITULAÇÃO"
					action="#{relatorioController.gerarRelatorioServidorTitulacao}" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="RELATÓRIO GERAL SERVIDOR"
					action="#{relatorioController.abrirRelatorioGeral}" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="RELATÓRIO PERMISSÃO USUÁRIO"
					action="#{relatorioController.abrirRelatorioPermissaoUsuario}" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="CARGO LOTAÇÂO (FILTRO)"
					action="#{relatorioController.abrirRelatorioCargoLotacaoByFiltro}" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="RELATÓRIO SOLICITAÇÂO (FILTRO)"
					action="#{relatorioController.abrirRelatorioSolicitacaoByFiltro}" />

			</h:panelGrid>
		</h:form>
	</rich:panel>
</f:view>
</body>
</html>