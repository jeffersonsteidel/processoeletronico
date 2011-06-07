<%@page import="javax.faces.context.FacesContext"%>
<%@page import="br.com.progepe.controller.AutenticacaoController"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="StyleSheet" type="text/css" href="../css/messages-style.css"
	media="screen" />
<head>
<title>Instituto Federal do Paran�</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="shortcut icon" href="../images/icone.png" />
</head>
<body>
<style type="text/css">
.pic {
	margin-bottom: -4px;
	margin-right: 4px;
}
</style>

<script type="text/javascript">
	function ajuda() {
		window.open("manual/indiceManual.html");
	}
</script>
<%
	if (FacesContext.getCurrentInstance().getExternalContext()
			.getSessionMap().get("usuarioLogado") == null) {
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("login.jsp");
	}
%>
<div id="non-printable"><f:subview id="Menu">
	<center><a4j:form>
		<h:graphicImage value="../images/banner_topo.gif" />
		<BR />
		<rich:toolBar>
			<rich:dropDownMenu
				rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}">
				<f:facet name="label">
					<h:panelGroup>
						<h:outputText value="SERVIDOR" />
					</h:panelGroup>
				</f:facet>
				<rich:menuItem submitMode="ajax" value="Adicionar Fun��o"
					action="#{funcaoServidorController.abrirAdicionarFuncaoServidor}"
					icon="../images/addfuncao.gif" />
				<rich:menuItem submitMode="ajax" value="Cadastrar Servidor"
					action="#{servidorController.cadastrar}"
					icon="../images/NOVOSERVIDOR.gif" />
				<rich:menuItem submitMode="ajax" value="Listar Servidores"
					action="#{servidorController.listar}"
					icon="../images/LISTARSERVIDORES2.gif" />
				<%--
				<rich:menuItem submitMode="ajax" value="Pesquisar C�njuges"
					action="#{conjugeController.abrirListarConjuge}"
					icon="../images/conjuge.png" />
				<rich:menuItem submitMode="ajax" value="Pesquisar Documentos"
					action="#{documentoImagemController.abrirPesquisarDocumentos}"
					icon="../images/listarDocumentos.gif" />
				<rich:menuItem submitMode="ajax" value="Pesquisar Dependentes"
					action="#{dependenteController.abrirListarDependentes}"
					icon="../images/listarDependente.png" />
				<rich:menuItem submitMode="ajax" value="Pesquisar Empregos"
					action="#{empregoController.abrirListarEmprego}"
					icon="../images/listemprego.gif" />
				--%>
				<rich:menuItem submitMode="ajax" value="Pesquisar Fun��es"
					action="#{funcaoServidorController.abrirListarFuncoes}"
					icon="../images/listfuncao.png" />

				<rich:menuItem submitMode="ajax" value="Pesquisar Servidor"
					action="#{servidorController.pesquisarServidores}"
					icon="../images/PESQUISARSERVIDOR.gif" />
				<rich:menuItem submitMode="ajax" value="Remo��o Servidor"
					action="#{remocaoController.abrirCadastrarRemocao}"
					icon="../images/listarTitulacao.gif" />
				<%--	
				<rich:menuItem submitMode="ajax" value="Pesquisar Titula��es"
					action="#{servidorTitulacaoController.abrirListarServidorTitulacao}"
					icon="../images/listarTitulacao.gif" />
				--%>
				<rich:menuItem submitMode="ajax" value="Remo��es Servidor"
					action="#{remocaoController.abrirCadastrarRemocao}"
					icon="../images/cad_remocao.gif" />
				<rich:menuItem submitMode="ajax" value="Pesquisar Remo��es"
					action="#{remocaoController.abrirListarRemocoes}"
					icon="../images/pes_remocao.gif" />
			</rich:dropDownMenu>

			<%--
			<rich:dropDownMenu>
				<f:facet name="label">
					<h:panelGroup>
						<h:outputText value="ATUALIZAR MEUS DADOS" />
					</h:panelGroup>
				</f:facet>
				<rich:menuItem submitMode="ajax" value="Adicionar C�njuge"
					action="#{conjugeController.abrirCadastrarConjuge}"
					icon="../images/casamento.gif" />
				<rich:menuItem submitMode="ajax" value="Adicionar Dependente"
					action="#{dependenteController.abrirAdicionarDependentes}"
					icon="../images/dependente.gif" />
				<rich:menuItem submitMode="ajax" value="Adicionar Documentos"
					action="#{documentoImagemController.abrirAdicionarDocumentos}"
					icon="../images/documentos.gif" />
				<rich:menuItem submitMode="ajax" value="Adicionar Emprego"
					action="#{empregoController.abrirEmprego}"
					icon="../images/ico_emprego.gif" />
				<rich:menuItem submitMode="ajax" value="Adicionar Titula��o"
					action="#{servidorTitulacaoController.abrirAdicionarServidorTitulacao}"
					icon="../images/titulacoes.gif" />
				<rich:menuItem submitMode="ajax" value="Atualizar Meus Dados"
					action="#{servidorController.buscarServidorLogado}"
					icon="../images/ATUALIZARDADOS.gif" />
				<rich:menuItem submitMode="ajax" value="Meus Documentos"
					action="#{documentoImagemController.abrirPesquisarMeusDocumentos}"
					icon="../images/listarDocumentos.gif" />
			</rich:dropDownMenu>

			<rich:dropDownMenu>
				<f:facet name="label">
					<h:panelGroup>
						<h:outputText value="SOLICITA��ES" />
					</h:panelGroup>
				</f:facet>
				<rich:menuGroup value="Adicionais">
					<rich:menuItem submitMode="ajax" value="Adicional de Insalubridade"
						action="#{solicitacaoAdicionalInsalubridadeController.abrirSolicitacaoAdicionalInsalubridade}"
						icon="../images/insalubridade.gif" />
					<rich:menuItem submitMode="ajax"
						value="Adicional Noturno - Docentes"
						rendered="#{autenticacaoController.siapeAutenticado.indSecretaria}"
						action="#{solicitacaoAdicionalNoturnoController.abrirSolicitacaoAdicionalNoturnoDocentes}"
						icon="../images/cadastrarAdicional.jpg" />
					<rich:menuItem submitMode="ajax"
						value="Adicional Noturno - T�cnicos"
						rendered="#{autenticacaoController.siapeAutenticado.indSecretaria}"
						action="#{solicitacaoAdicionalNoturnoController.abrirSolicitacaoAdicionalNoturnoTecnico}"
						icon="../images/cadastrarAdicional.jpg" />
					<rich:menuItem submitMode="ajax"
						value="Listar Adicional Noturno - Docentes"
						rendered="#{autenticacaoController.siapeAutenticado.indDiretor}"
						action="#{solicitacaoAdicionalNoturnoController.abrirListarSolicitacaoAdicionalNoturnoDocentes}"
						icon="../images/listarAdicional.jpg" />
					<rich:menuItem submitMode="ajax"
						value="Listar Adicional Noturno - T�cnicos"
						rendered="#{autenticacaoController.siapeAutenticado.indDiretor}"
						action="#{solicitacaoAdicionalNoturnoController.abrirListarSolicitacaoAdicionalNoturnoTecnicos}"
						icon="../images/listarAdicional.jpg" />
				</rich:menuGroup>
				<rich:menuItem submitMode="ajax" value="Solicita��o Progress�o Por Capacita��o"
					action="#{solicitacaoProgressaoCapacitacaoController.abrirProgressaoCapacitacao}"
					icon="../images/cadProgressao.gif" />
				<rich:menuItem submitMode="ajax" value="Afastamento do C�njuge"
					action="#{solicitacaoAfastamentoConjugeController.abrirSolicitacaoAfastamentoConjuge}"
					icon="../images/afastamentoconjuge.gif" />
				<rich:menuItem submitMode="ajax" value="Altera��o de Conta Banc�ria"
					action="#{solicitacaoContaBancariaController.abrirSolicitacaoContaBancaria}"
					icon="../images/ALTERARCONTABANCARIA.GIF" />
				<rich:menuItem submitMode="ajax"
					value="Altera��o de Endere�o/Contato"
					action="#{solicitacaoAlteracaoEnderecoController.abrirSolicitacaoAlteracaoEndereco}"
					icon="../images/endereco.gif" />
				<rich:menuItem submitMode="ajax" value="Alterar F�rias"
					action="#{solicitacaoAlteracaoFeriasController.abrirSolicitacaoAlteracaoFerias}"
					icon="../images/alteracaoferias.gif" />
				<rich:menuItem submitMode="ajax" value="Aux�lio Alimenta��o"
					action="#{solicitacaoAlimentacaoController.abrirSolicitacaoAlimentacao}"
					icon="../images/auxilioalimentacao.gif" />
				<rich:menuItem submitMode="ajax" value="Aux�lio Transporte"
					action="#" icon="../images/SOLICITACAOAUTOMOVEIS.gif" />
				<rich:menuItem submitMode="ajax"
					value="Hor�rio Especial para Estudante"
					action="#{solicitacaoHorarioEspecialEstudanteController.abrirSolicitacaoHorarioEspecialEstudante}"
					icon="../images/SOLICITACAOHORARIOESPECIALESTUDANTE.gif" />
				<rich:menuItem submitMode="ajax" value="Incentivo a Qualifica��o"
					action="#{solicitacaoIncentivoQualificacaoController.abrirSolicitacaoIncentivoQualificacao}"
					icon="../images/listarAdicional.jpg" />
				<rich:menuGroup value="Licen�as">
					<rich:menuItem submitMode="ajax" value="Licen�a de Casamento"
						action="#{solicitacaoCasamentoController.abrirSolicitacaoCasamento}"
						icon="../images/listarConjuge.gif" />
					<rich:menuItem submitMode="ajax" value="Licen�a de �bito"
						action="#{solicitacaoObitoController.abrirSolicitacaoObito}"
						icon="../images/obito.gif" />
					<rich:menuItem submitMode="ajax" value="Licen�a Paternidade"
						action="#{solicitacaoLicencaPaternidadeController.abrirSolicitacaoPaternidade}"
						icon="../images/auxiliopaternidade.gif" />
				</rich:menuGroup>
				<rich:menuGroup value="Ressarcimento Sa�de">
					<rich:menuItem submitMode="ajax"
						value="Cadastrar Ressarcimento Sa�de"
						action="#{ressarcimentoSaudeController.abrirRessarcimentoSaude}"
						icon="../images/ressarcimentoSaude.gif" />
					<rich:menuItem submitMode="ajax"
						value="Pesquisar Ressarcimento Sa�de"
						action="#{ressarcimentoSaudeController.abrirListar}"
						icon="../images/saude.png" />
					<rich:menuItem submitMode="ajax"
						value="Reembolso Ressarcimento Sa�de"
						action="#{solicitacaoRessarcimentoSaudeController.abrirSolicitacaoRessarcimentoSaude}"
						icon="../images/saude2.gif" />
				</rich:menuGroup>
				<rich:menuItem submitMode="ajax" value="Listar Solicita��es"
					rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}"
					action="#{solicitacaoController.abrirPesquisarSolicitacoes}"
					icon="../images/LISTARSOLICITACOES.gif" />
				<rich:menuItem submitMode="ajax" value="Minhas Solicita��es"
					action="#{solicitacaoController.abrirMinhasSolicitacoes}"
					icon="../images/MINHASSOLICITACOES.GIF" />
			</rich:dropDownMenu>
			<rich:dropDownMenu>
				<f:facet name="label">
					<h:panelGroup>
						<h:outputText value="PORTARIAS" />
					</h:panelGroup>
				</f:facet>
				<rich:menuItem submitMode="ajax" value="Adicionar Portaria"
					action="#{portariaController.abrirPortaria }"
					icon="../images/novaPortaria.gif" />
				<rich:menuItem submitMode="ajax" value="Listar Portarias"
					action="#{portariaController.listarPortarias}"
					icon="../images/portarias.gif" />
			</rich:dropDownMenu>
			--%>
			<rich:dropDownMenu>
				<f:facet name="label">
					<h:panelGroup>
						<h:outputText value="ANIVERSARIANTES" />
					</h:panelGroup>
				</f:facet>
				<rich:menuItem submitMode="ajax" value="Aniversariantes"
					action="#{aniversarianteController.abrirAniversariantes}"
					icon="../images/aniversario.png" />
			</rich:dropDownMenu>
			<%--
			<rich:dropDownMenu>
				<f:facet name="label">
					<h:panelGroup>
						<h:outputText value="PROGRESS�O" />
					</h:panelGroup>
				</f:facet>
				<rich:menuItem submitMode="ajax"
					value="Cadastrar Progress�o - M�rito"
					action="#{progressaoController.abrirCadastrarProgressao}"
					icon="../images/cadProgressao.gif" />
				<rich:menuItem submitMode="ajax" value="Listar Progress�o - M�rito"
					action="#{progressaoController.abrirListarProgressao}"
					icon="../images/listProgressao.gif" />
			</rich:dropDownMenu>
			--%>

			<rich:dropDownMenu>
				<f:facet name="label">
					<h:panelGroup>
						<h:outputText value="ALTERAR SENHA" />
					</h:panelGroup>
				</f:facet>
				<rich:menuItem submitMode="ajax" value="Alterar Senha"
					action="#{autenticacaoController.alterarSenha}"
					icon="../images/ALTERARSENHA.gif" />
			</rich:dropDownMenu>
			<%--
			<rich:dropDownMenu
				rendered="#{autenticacaoController.siapeAutenticado.indGerente}">
				<f:facet name="label">
					<h:panelGroup>
						<h:outputText value="ADMINISTRA��O" />
					</h:panelGroup>
				</f:facet>
				<rich:menuItem submitMode="ajax" value="Cadastrar Cargo"
					action="#{cargoController.abrirCadastrarCargo}"
					icon="../images/cadastrarCargo.gif" />
				<rich:menuItem submitMode="ajax" value="Cadastrar Lota��o"
					action="#{lotacaoController.abrirCadastrarLotacao}"
					icon="../images/cadastrarLotacao.gif" />
				<rich:menuItem submitMode="ajax" value="Gerenciar Permiss�es"
					action="#{permissaoController.abrirGerenciarPermissao}"
					icon="../images/permissao.gif" />
				<rich:menuItem submitMode="ajax" value="Listar Cargos"
					action="#{cargoController.abrirListarCargos}"
					icon="../images/listarCargo.gif" />
				<rich:menuItem submitMode="ajax" value="Listar Lota��es"
					action="#{lotacaoController.abrirListarLotacoes}"
					icon="../images/listarLotacao.gif" />
				<rich:menuItem submitMode="ajax" value="Nova Fun��o"
					action="#{funcaoController.abrirNovaFuncao}"
					icon="../images/novafuncao.png" />
				<rich:menuItem submitMode="ajax" value="Pesquisar Fun��es"
					action="#{funcaoController.abrirListarFuncoes}"
					icon="../images/pesquisarfuncoes.gif" />
			</rich:dropDownMenu>
			 --%>
			<rich:dropDownMenu
				rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}">
				<f:facet name="label">
					<h:panelGroup>
						<h:outputText value="RELAT�RIOS" />
					</h:panelGroup>
				</f:facet>
				<rich:menuItem submitMode="ajax" value="Relat�rios"
					action="#{relatorioController.abrirRelatorios}"
					icon="../images/icopdf.gif" />
			</rich:dropDownMenu>
			<rich:toolBarGroup location="right">
				<rich:dropDownMenu>
					<f:facet name="label">
						<h:panelGroup>
							<h:outputText value="AJUDA" />
						</h:panelGroup>
					</f:facet>
					<rich:menuItem submitMode="ajax" value="Manual do Sistema"
						icon="../images/ico_ajuda.gif" action="#" onclick="ajuda();" />
				</rich:dropDownMenu>
				<rich:dropDownMenu>
					<f:facet name="label">
						<h:panelGroup>
							<h:outputText value="SAIR" />
						</h:panelGroup>
					</f:facet>
					<rich:menuItem submitMode="ajax" value="SAIR"
						action="#{autenticacaoController.logout}"
						icon="../images/SAIR.gif" />
				</rich:dropDownMenu>
			</rich:toolBarGroup>
		</rich:toolBar>

		<a4j:status>
			<f:facet name="start">
				<h:graphicImage value="../images/ajax-loader.gif" />
			</f:facet>
		</a4j:status>
	</a4j:form></center>
</f:subview></div>
</body>

