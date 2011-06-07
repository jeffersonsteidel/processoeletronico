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
<title>Instituto Federal do Paraná</title>
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
				<rich:menuItem submitMode="ajax" value="Adicionar Função"
					action="#{funcaoServidorController.abrirAdicionarFuncaoServidor}"
					icon="../images/addfuncao.gif" />
				<rich:menuItem submitMode="ajax" value="Cadastrar Servidor"
					action="#{servidorController.cadastrar}"
					icon="../images/NOVOSERVIDOR.gif" />
				<rich:menuItem submitMode="ajax" value="Listar Servidores"
					action="#{servidorController.listar}"
					icon="../images/LISTARSERVIDORES2.gif" />
				<%--
				<rich:menuItem submitMode="ajax" value="Pesquisar Cônjuges"
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
				<rich:menuItem submitMode="ajax" value="Pesquisar Funções"
					action="#{funcaoServidorController.abrirListarFuncoes}"
					icon="../images/listfuncao.png" />

				<rich:menuItem submitMode="ajax" value="Pesquisar Servidor"
					action="#{servidorController.pesquisarServidores}"
					icon="../images/PESQUISARSERVIDOR.gif" />
				<rich:menuItem submitMode="ajax" value="Remoção Servidor"
					action="#{remocaoController.abrirCadastrarRemocao}"
					icon="../images/listarTitulacao.gif" />
				<%--	
				<rich:menuItem submitMode="ajax" value="Pesquisar Titulações"
					action="#{servidorTitulacaoController.abrirListarServidorTitulacao}"
					icon="../images/listarTitulacao.gif" />
				--%>
				<rich:menuItem submitMode="ajax" value="Remoções Servidor"
					action="#{remocaoController.abrirCadastrarRemocao}"
					icon="../images/cad_remocao.gif" />
				<rich:menuItem submitMode="ajax" value="Pesquisar Remoções"
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
				<rich:menuItem submitMode="ajax" value="Adicionar Cônjuge"
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
				<rich:menuItem submitMode="ajax" value="Adicionar Titulação"
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
						<h:outputText value="SOLICITAÇÕES" />
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
						value="Adicional Noturno - Técnicos"
						rendered="#{autenticacaoController.siapeAutenticado.indSecretaria}"
						action="#{solicitacaoAdicionalNoturnoController.abrirSolicitacaoAdicionalNoturnoTecnico}"
						icon="../images/cadastrarAdicional.jpg" />
					<rich:menuItem submitMode="ajax"
						value="Listar Adicional Noturno - Docentes"
						rendered="#{autenticacaoController.siapeAutenticado.indDiretor}"
						action="#{solicitacaoAdicionalNoturnoController.abrirListarSolicitacaoAdicionalNoturnoDocentes}"
						icon="../images/listarAdicional.jpg" />
					<rich:menuItem submitMode="ajax"
						value="Listar Adicional Noturno - Técnicos"
						rendered="#{autenticacaoController.siapeAutenticado.indDiretor}"
						action="#{solicitacaoAdicionalNoturnoController.abrirListarSolicitacaoAdicionalNoturnoTecnicos}"
						icon="../images/listarAdicional.jpg" />
				</rich:menuGroup>
				<rich:menuItem submitMode="ajax" value="Solicitação Progressão Por Capacitação"
					action="#{solicitacaoProgressaoCapacitacaoController.abrirProgressaoCapacitacao}"
					icon="../images/cadProgressao.gif" />
				<rich:menuItem submitMode="ajax" value="Afastamento do Cônjuge"
					action="#{solicitacaoAfastamentoConjugeController.abrirSolicitacaoAfastamentoConjuge}"
					icon="../images/afastamentoconjuge.gif" />
				<rich:menuItem submitMode="ajax" value="Alteração de Conta Bancária"
					action="#{solicitacaoContaBancariaController.abrirSolicitacaoContaBancaria}"
					icon="../images/ALTERARCONTABANCARIA.GIF" />
				<rich:menuItem submitMode="ajax"
					value="Alteração de Endereço/Contato"
					action="#{solicitacaoAlteracaoEnderecoController.abrirSolicitacaoAlteracaoEndereco}"
					icon="../images/endereco.gif" />
				<rich:menuItem submitMode="ajax" value="Alterar Férias"
					action="#{solicitacaoAlteracaoFeriasController.abrirSolicitacaoAlteracaoFerias}"
					icon="../images/alteracaoferias.gif" />
				<rich:menuItem submitMode="ajax" value="Auxílio Alimentação"
					action="#{solicitacaoAlimentacaoController.abrirSolicitacaoAlimentacao}"
					icon="../images/auxilioalimentacao.gif" />
				<rich:menuItem submitMode="ajax" value="Auxílio Transporte"
					action="#" icon="../images/SOLICITACAOAUTOMOVEIS.gif" />
				<rich:menuItem submitMode="ajax"
					value="Horário Especial para Estudante"
					action="#{solicitacaoHorarioEspecialEstudanteController.abrirSolicitacaoHorarioEspecialEstudante}"
					icon="../images/SOLICITACAOHORARIOESPECIALESTUDANTE.gif" />
				<rich:menuItem submitMode="ajax" value="Incentivo a Qualificação"
					action="#{solicitacaoIncentivoQualificacaoController.abrirSolicitacaoIncentivoQualificacao}"
					icon="../images/listarAdicional.jpg" />
				<rich:menuGroup value="Licenças">
					<rich:menuItem submitMode="ajax" value="Licença de Casamento"
						action="#{solicitacaoCasamentoController.abrirSolicitacaoCasamento}"
						icon="../images/listarConjuge.gif" />
					<rich:menuItem submitMode="ajax" value="Licença de Óbito"
						action="#{solicitacaoObitoController.abrirSolicitacaoObito}"
						icon="../images/obito.gif" />
					<rich:menuItem submitMode="ajax" value="Licença Paternidade"
						action="#{solicitacaoLicencaPaternidadeController.abrirSolicitacaoPaternidade}"
						icon="../images/auxiliopaternidade.gif" />
				</rich:menuGroup>
				<rich:menuGroup value="Ressarcimento Saúde">
					<rich:menuItem submitMode="ajax"
						value="Cadastrar Ressarcimento Saúde"
						action="#{ressarcimentoSaudeController.abrirRessarcimentoSaude}"
						icon="../images/ressarcimentoSaude.gif" />
					<rich:menuItem submitMode="ajax"
						value="Pesquisar Ressarcimento Saúde"
						action="#{ressarcimentoSaudeController.abrirListar}"
						icon="../images/saude.png" />
					<rich:menuItem submitMode="ajax"
						value="Reembolso Ressarcimento Saúde"
						action="#{solicitacaoRessarcimentoSaudeController.abrirSolicitacaoRessarcimentoSaude}"
						icon="../images/saude2.gif" />
				</rich:menuGroup>
				<rich:menuItem submitMode="ajax" value="Listar Solicitações"
					rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}"
					action="#{solicitacaoController.abrirPesquisarSolicitacoes}"
					icon="../images/LISTARSOLICITACOES.gif" />
				<rich:menuItem submitMode="ajax" value="Minhas Solicitações"
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
						<h:outputText value="PROGRESSÃO" />
					</h:panelGroup>
				</f:facet>
				<rich:menuItem submitMode="ajax"
					value="Cadastrar Progressão - Mérito"
					action="#{progressaoController.abrirCadastrarProgressao}"
					icon="../images/cadProgressao.gif" />
				<rich:menuItem submitMode="ajax" value="Listar Progressão - Mérito"
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
						<h:outputText value="ADMINISTRAÇÃO" />
					</h:panelGroup>
				</f:facet>
				<rich:menuItem submitMode="ajax" value="Cadastrar Cargo"
					action="#{cargoController.abrirCadastrarCargo}"
					icon="../images/cadastrarCargo.gif" />
				<rich:menuItem submitMode="ajax" value="Cadastrar Lotação"
					action="#{lotacaoController.abrirCadastrarLotacao}"
					icon="../images/cadastrarLotacao.gif" />
				<rich:menuItem submitMode="ajax" value="Gerenciar Permissões"
					action="#{permissaoController.abrirGerenciarPermissao}"
					icon="../images/permissao.gif" />
				<rich:menuItem submitMode="ajax" value="Listar Cargos"
					action="#{cargoController.abrirListarCargos}"
					icon="../images/listarCargo.gif" />
				<rich:menuItem submitMode="ajax" value="Listar Lotações"
					action="#{lotacaoController.abrirListarLotacoes}"
					icon="../images/listarLotacao.gif" />
				<rich:menuItem submitMode="ajax" value="Nova Função"
					action="#{funcaoController.abrirNovaFuncao}"
					icon="../images/novafuncao.png" />
				<rich:menuItem submitMode="ajax" value="Pesquisar Funções"
					action="#{funcaoController.abrirListarFuncoes}"
					icon="../images/pesquisarfuncoes.gif" />
			</rich:dropDownMenu>
			 --%>
			<rich:dropDownMenu
				rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}">
				<f:facet name="label">
					<h:panelGroup>
						<h:outputText value="RELATÓRIOS" />
					</h:panelGroup>
				</f:facet>
				<rich:menuItem submitMode="ajax" value="Relatórios"
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

