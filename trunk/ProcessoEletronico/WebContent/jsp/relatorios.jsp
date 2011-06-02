<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instituto Federal do Paran�</title>
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
					value="(retorna todos os dados do servidor, dados pessoais, funcionais, endere�o, documentos, conta banc�ria, titula��es, dependentes, empregos, c�njuge, fun��o)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR POR CONTA BANC�RIA"
					action="#{relatorioController.gerarRelatorioServidorContaBancaria}" />
				<h:outputText
					value="(retorna todos os servidores, traz o o siape, nome, banco, n�mero da conta, ag�ncia, indicador de poupan�a pelo siape)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR POR FILTRO CARGO LOTA��O"
					action="#{relatorioController.abrirRelatorioCargoLotacaoByFiltro}" />
				<h:outputText
					value="(retorna servidores por filtro, cargo, local exerc�cio e situa��o. traz o siape, nome, cargo, lota��o e indicador de atividade)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR POR FILTRO SOLICITA��O"
					action="#{relatorioController.abrirRelatorioSolicitacaoByFiltro}" />
				<h:outputText
					value="(retorna servidores por filtro, data entre, atendente, solicitante, tipo e status solicitac�o. traz solicitante, atendente, data abertura, atendimento e fechamento, tipo e status solicita��o)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR POR LOTA��O E CARGO"
					action="#{relatorioController.gerarRelatorioServidorCargoLotacao}" />
				<h:outputText
					value="(retorna todos os servidores, traz o siape, nome, cargo, lota��o e indicador de atividade ordenados pelo siape)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR C�NJUGE"
					action="#{relatorioController.gerarRelatorioServidorConjuge}" />
				<h:outputText
					value="(retorna todos os servidores que possuem c�njuge, traz o siape e nome do servidor, nome do c�njuge, sexo, cpf, se � c�njuge atual, se � servidor)" />

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
				<h:commandLink value="SERVIDOR TITULA��O"
					action="#{relatorioController.gerarRelatorioServidorTitulacao}" />
				<h:outputText
					value="(retorna todos os servidores que possuem titula��o, traz o siape, nome, titula��o, curso, estabelicimento de ensino, carga hor�ria, area de conhecimento, ano de conclus�o)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="PERMISS�O USU�RIO"
					action="#{relatorioController.abrirRelatorioPermissaoUsuario}" />
				<h:outputText
					value="(retorna as permiss�es de cada usu�rio no sistema)" />

				<h:graphicImage value="../images/icopdf.gif" />
				<h:commandLink value="SERVIDOR POR FILTRO FUN��ES"
					action="#{relatorioController.abrirRelatorioFuncoesByFiltro}" />
				<h:outputText value="(retorna ...)" />

			</h:panelGrid>
		</h:form>
	</rich:panel>
</f:view>
</body>
</html>