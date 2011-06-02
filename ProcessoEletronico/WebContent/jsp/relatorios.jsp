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
				<h:commandLink value="SERVIDOR GERAL"
					action="#{relatorioController.abrirRelatorioGeral}" />
				<h:outputText
					value="(retorna todos os dados do servidor, dados pessoais, funcionais, endereço, documentos, conta bancária, titulações, dependentes, empregos, cônjuge, função)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR POR CONTA BANCÁRIA"
					action="#{relatorioController.gerarRelatorioServidorContaBancaria}" />
				<h:outputText
					value="(retorna todos os servidores, traz o o siape, nome, banco, número da conta, agência, indicador de poupança pelo siape)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR POR FILTRO CARGO LOTAÇÃO"
					action="#{relatorioController.abrirRelatorioCargoLotacaoByFiltro}" />
				<h:outputText
					value="(retorna servidores por filtro, cargo, local exercício e situação. traz o siape, nome, cargo, lotação e indicador de atividade)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR POR FILTRO SOLICITAÇÂO"
					action="#{relatorioController.abrirRelatorioSolicitacaoByFiltro}" />
				<h:outputText
					value="(retorna servidores por filtro, data entre, atendente, solicitante, tipo e status solicitacão. traz solicitante, atendente, data abertura, atendimento e fechamento, tipo e status solicitação)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR POR LOTAÇÃO E CARGO"
					action="#{relatorioController.gerarRelatorioServidorCargoLotacao}" />
				<h:outputText
					value="(retorna todos os servidores, traz o siape, nome, cargo, lotação e indicador de atividade ordenados pelo siape)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR CÔNJUGE"
					action="#{relatorioController.gerarRelatorioServidorConjuge}" />
				<h:outputText
					value="(retorna todos os servidores que possuem cônjuge, traz o siape e nome do servidor, nome do cônjuge, sexo, cpf, se é cônjuge atual, se é servidor)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR DEPENDENTE"
					action="#{relatorioController.gerarRelatorioServidorDependente}" />
				<h:outputText
					value="(retorna todos os servidores que possuem dependente, traz o siape e nome do servidor, nome do dependente, sexo, grau de parentesco, cpf, data nascimento, indicador estudante, indicador pne)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR EMPREGO"
					action="#{relatorioController.gerarRelatorioServidorEmprego}" />
				<h:outputText
					value="(retorna todos os servidores que possuem emprego, traz o siape, nome, cargo, empresa, atividades, data de entrada, data de saida)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR TITULAÇÃO"
					action="#{relatorioController.gerarRelatorioServidorTitulacao}" />
				<h:outputText
					value="(retorna todos os servidores que possuem titulação, traz o siape, nome, titulação, curso, estabelicimento de ensino, carga horária, area de conhecimento, ano de conclusão)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="PERMISSÃO USUÁRIO"
					action="#{relatorioController.abrirRelatorioPermissaoUsuario}" />
				<h:outputText
					value="(retorna as permissões de cada usuário no sistema)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR POR FILTRO FUNÇÕES"
					action="#{relatorioController.abrirRelatorioFuncoesByFiltro}" />
				<h:outputText value="(retorna ...)" />

			</h:panelGrid>
		</h:form>
	</rich:panel>
</f:view>
</body>
</html>