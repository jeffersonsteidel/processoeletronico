<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="StyleSheet" type="text/css" href="../css/messages-style.css"
	media="screen" />
<head>
<title>Instituto Federal do Paraná</title>
</head>
<body onload="verificarAutenticacao()">
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


<div id="non-printable"><f:subview id="Menu">
	<center><a4j:form>
		<a4j:jsFunction action="#{autenticacaoController.isAutenticado}"
			name="verificarAutenticacao" />
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
				<rich:menuItem submitMode="ajax" value="Cadastrar Servidor"
					action="#{servidorController.cadastrar}"
					icon="../images/NOVOSERVIDOR.gif" />
				<rich:menuItem submitMode="ajax" value="Pesquisar Servidor"
					action="#{servidorController.pesquisarServidores}"
					icon="../images/PESQUISARSERVIDOR.gif" />
				<rich:menuItem submitMode="ajax" value="Listar Servidores"
					action="#{servidorController.listar}"
					icon="../images/LISTARSERVIDORES2.gif" />
				<rich:menuItem submitMode="ajax" value="Listar Cônjuges"
					action="#{conjugeController.abrirListarConjuge}"
					icon="../images/LISTARSERVIDORES2.gif" />	
				<rich:menuItem submitMode="ajax" value="Listar Dependentes"
					action="#{dependenteController.abrirListarDependentes}"
					icon="../images/LISTARSERVIDORES2.gif" />
				<rich:menuItem submitMode="ajax" value="Listar Empregos"
					action="#{empregoController.abrirListarEmprego}"
					icon="../images/LISTARSERVIDORES2.gif" />
				<rich:menuItem submitMode="ajax" value="Listar Titulações"
					action="#{servidorTitulacaoController.abrirListarServidorTitulacao}"
					icon="../images/titulacoes.gif" />
			</rich:dropDownMenu>

			<rich:dropDownMenu>
				<f:facet name="label">
					<h:panelGroup>
						<h:outputText value="ATUALIZAR MEUS DADOS" />
					</h:panelGroup>
				</f:facet>
				<rich:menuItem submitMode="ajax" value="Atualizar Meus Dados"
					action="#{servidorController.buscarServidorLogado}"
					icon="../images/ATUALIZARDADOS.gif" />
				<rich:menuItem submitMode="ajax" value="Adicionar Dependentes"
					action="#{dependenteController.abrirAdicionarDependentes}"
					icon="../images/dependente.gif" />
				<rich:menuItem submitMode="ajax" value="Cadastrar Cônjuge"
					action="#{conjugeController.abrirCadastrarConjuge}"
					icon="../images/cadastrarConjuge.gif" />
				<rich:menuItem submitMode="ajax" value="Adicionar Titulações"
					action="#{servidorTitulacaoController.abrirAdicionarServidorTitulacao}"
					icon="../images/titulacoes.gif" />
				
				<rich:menuItem submitMode="ajax" value="Adicionar Empregos"
					action="#{empregoController.abrirEmprego}"
					icon="../images/titulacoes.gif" />
			</rich:dropDownMenu>

			<rich:dropDownMenu>
				<f:facet name="label">
					<h:panelGroup>
						<h:outputText value="SOLICITAÇÕES" />
					</h:panelGroup>
				</f:facet>
				<rich:menuItem submitMode="ajax" value="Alterar Conta Bancária"
					action="#{solicitacaoContaBancariaController.abrirSolicitacaoContaBancaria}"
					icon="../images/ALTERARCONTABANCARIA.GIF" />
				<rich:menuItem submitMode="ajax" value="Alterar Férias"
					action="#{solicitacaoAlteracaoFeriasController.abrirSolicitacaoAlteracaoFerias}"
					icon="../images/alteracaoferias.gif" />
				<rich:menuItem submitMode="ajax" value="Auxílio Alimentação"
					action="#{solicitacaoAlimentacaoController.abrirSolicitacaoAlimentacao}"
					icon="../images/auxilioalimentacao.gif" />
				<rich:menuItem submitMode="ajax"
					value="Adicional Noturno - Técnicos" rendered="#{autenticacaoController.siapeAutenticado.indSecretaria}"
					action="#{solicitacaoAdicionalNoturnoController.abrirSolicitacaoAdicionalNoturnoTecnico}"
					icon="../images/dinheiro.gif" />
				<rich:menuItem submitMode="ajax"
					value="Adicional Noturno - Docentes" rendered="#{autenticacaoController.siapeAutenticado.indSecretaria}"
					action="#{solicitacaoAdicionalNoturnoController.abrirSolicitacaoAdicionalNoturnoDocentes}"
					icon="../images/dinheiro.gif" />
				<rich:menuItem submitMode="ajax" value="Licença de Casamento"
					action="#{solicitacaoCasamentoController.abrirSolicitacaoCasamento}"
					icon="../images/casamento.gif" />
				<rich:menuItem submitMode="ajax" value="Afastamento do Cônjuge"
					action="#{solicitacaoAfastamentoConjugeController.abrirSolicitacaoAfastamentoConjuge}"
					icon="../images/afastamentoconjuge.gif" />
				<rich:menuItem submitMode="ajax" value="Licença de Óbito"
					action="#{solicitacaoObitoController.abrirSolicitacaoObito}"
					icon="../images/obito.gif" />
				<rich:menuItem submitMode="ajax" value="Licença Paternidade"
					action="#{solicitacaoLicencaPaternidadeController.abrirSolicitacaoPaternidade}"
					icon="../images/auxiliopaternidade.gif" />
				<rich:menuItem submitMode="ajax" value="Auxílio Transporte"
					action="#" icon="../images/SOLICITACAOAUTOMOVEIS.gif" />
				<rich:menuItem submitMode="ajax"
					value="Horário Especial para Estudante"
					action="#{solicitacaoHorarioEspecialEstudanteController.abrirSolicitacaoHorarioEspecialEstudante}"
					icon="../images/SOLICITACAOHORARIOESPECIALESTUDANTE.gif" />
				<rich:menuItem submitMode="ajax" value="Adicional de Insalubridade"
					action="#{solicitacaoAdicionalInsalubridadeController.abrirSolicitacaoAdicionalInsalubridade}"
					icon="../images/insalubridade.gif" />
				<rich:menuItem submitMode="ajax"
					value="Listar Adicional Noturno - Técnicos"
					rendered="#{autenticacaoController.siapeAutenticado.indDiretor}"
					action="#{solicitacaoAdicionalNoturnoController.abrirListarSolicitacaoAdicionalNoturnoTecnicos}"
					icon="../images/listarAdNoturno.GIF" />
				<rich:menuItem submitMode="ajax"
					value="Listar Adicional Noturno - Docentes"
					rendered="#{autenticacaoController.siapeAutenticado.indDiretor}"
					action="#{solicitacaoAdicionalNoturnoController.abrirListarSolicitacaoAdicionalNoturnoDocentes}"
					icon="../images/listarAdNoturno.GIF" />
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
			
			<rich:dropDownMenu rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}">
				<f:facet name="label">
					<h:panelGroup>
						<h:outputText value="FUNÇÕES" />
					</h:panelGroup>
				</f:facet>
				<rich:menuItem submitMode="ajax" value="Adicionar Função"
					action="#{funcaoServidorController.abrirAdicionarFuncaoServidor}"
					icon="../images/ALTERARSENHA.gif" />
					<rich:menuItem submitMode="ajax" value="Listar Funções"
					action="#{funcaoServidorController.abrirListarFuncoes}"
					icon="../images/LISTARSERVIDORES2.gif" />
					
			</rich:dropDownMenu>
			
			<rich:dropDownMenu
				rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}">
				<f:facet name="label">
					<h:panelGroup>
						<h:outputText value="ADMINISTRAÇÃO" />
					</h:panelGroup>
					
				</f:facet>
				<rich:menuItem submitMode="ajax" value="Nova Função"
					action="#{funcaoController.abrirNovaFuncao}"
					icon="../images/LISTARSERVIDORES2.gif" />
					<rich:menuItem submitMode="ajax" value="Pesquisar Funções"
					action="#{funcaoController.abrirListarFuncoes}"
					icon="../images/LISTARSERVIDORES2.gif" />
				</rich:dropDownMenu>
				
			
			<rich:dropDownMenu>
				<f:facet name="label">
					<h:panelGroup>
						<h:outputText value="ANIVERSARIANTES" />
					</h:panelGroup>
				</f:facet>
				<rich:menuItem submitMode="ajax" value="Aniversariantes"
					action="#{aniversarianteController.abrirAniversariantes}"
					icon="../images/ALTERARSENHA.gif" />
			</rich:dropDownMenu>

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

