<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="StyleSheet" type="text/css" href="../css/messages-style.css"
	media="screen" />
<body>
<div id="non-printable"><f:subview id="Menu">
	<center><rich:panel header="INSTITUTO FEDERAL DO PARANÁ"
		style="height:auto;">
		<a4j:form>
			<h:graphicImage value="../images/ifpr_logo.png" />
			<BR />
			<font size="4"><b>PROGEPE - PROCESSO ELETRÔNICO</b></font>
			<!--<rich:toolBar style="text-align: center;">
				<a4j:commandButton value="LISTAR CARGOS"
					action="#{cargoController.listar}" />
				<a4j:commandButton value="CADASTRAR FUNÇÃO"
					action="#{funcaoController.cadastrar}" />
				<a4j:commandButton value="LISTAR FUNÇÕES"
					action="#{funcaoController.listar}" />
			</rich:toolBar>-->
			<rich:toolBar style="text-align: center;">

				<!-- ### CADASTRAR BANCO### -->
				<a4j:commandButton image="../images/bot_adicionarbanco.gif"
					action="#{bancoController.cadastrar}" />

				<!-- ### LISTAR BANCO### -->
				<a4j:commandButton image="../images/bot_listarbancos.gif"
					action="#{bancoController.listar}" />

				<!-- ### CADASTRAR LOTAÇÃO### -->
				<a4j:commandButton image="../images/bot_cadastrarlotacao.gif"
					action="#{lotacaoController.cadastrar}" />

				<!-- ### LSITAR LOTAÇÃO### -->
				<a4j:commandButton image="../images/bot_lotacoescadastradas.gif"
					action="#{lotacaoController.listar}" />

				<!-- ### CADASTRAR CARGO### -->
				<a4j:commandButton image="../images/bot_incluircargo.gif"
					action="#{cargoController.cadastrar}" />

				<!-- ### LISTAR CARGO### -->
				<a4j:commandButton image="../images/bot_listarcargo.gif"
					action="#{cargoController.listar}" />


				<!--<a4j:commandButton value="CADASTRAR TIPO FUNÇÃO" action="#{tipoFuncaoController.cadastrar}" />
				<a4j:commandButton value="LISTAR TIPO FUNÇÃO" action="#{tipoFuncaoController.listar}" />
				-->
			</rich:toolBar>
			<rich:toolBar>
				<!-- ### CADASTRAR SERVIDOR### -->
				<a4j:commandButton image="../images/bot_adicionarservidor.gif"
					action="#{servidorController.cadastrar}" />
					
				<!-- ### LISTAR SERVIDOR### -->	
				<a4j:commandButton image="../images/listarServidores.GIF"
					action="#{servidorController.listar}" />

			</rich:toolBar>
		</a4j:form>
	</rich:panel></center>
</f:subview></div>
</body>

