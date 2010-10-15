<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="StyleSheet" type="text/css" href="../css/messages-style.css"
	media="screen" />
<body onload="verificarAutenticacao()">
<style>
.pic {
	margin-bottom: -4px;
	margin-right: 4px;
}
</style>

<div id="non-printable"><f:subview id="Menu">
	<center>
		<a4j:form>
		<a4j:jsFunction action="#{autenticacaoController.isAutenticado}"
				name="verificarAutenticacao" />
		<h:graphicImage value="../images/ifpr_logo.png" />
			<BR />
			<font size="4"><b>PROGEPE - PROCESSO ELETRÔNICO</b></font>
			<rich:toolBar>
				<rich:dropDownMenu>
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
				</rich:dropDownMenu>

				<rich:dropDownMenu>
					<f:facet name="label">
						<h:panelGroup>
							<h:outputText value="ATUALIZAR MEUS DADOS" />
						</h:panelGroup>
					</f:facet>
					<rich:menuItem submitMode="ajax" value="Atualizar Dados"
						action="#{servidorController.buscarServidorLogado}"
						icon="../images/ATUALIZARDADOS.gif" />
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
								<h:outputText value="SAIR" />
							</h:panelGroup>
						</f:facet>
						<rich:menuItem submitMode="ajax" value="SAIR" action="#{autenticacaoController.logout}"
							icon="../images/SAIR.gif" />
					</rich:dropDownMenu>
				</rich:toolBarGroup>
			</rich:toolBar>
			
			<a4j:status>
				<f:facet name="start">
					<h:graphicImage value="../images/ajax-loader.gif" />
				</f:facet>
			</a4j:status>
		</a4j:form>
	</center>
</f:subview></div>
</body>

