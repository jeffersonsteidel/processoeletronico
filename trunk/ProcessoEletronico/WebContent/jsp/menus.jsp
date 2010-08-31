<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="StyleSheet" type="text/css" href="../css/messages-style.css"
	media="screen" />
<body>
<div id="non-printable"><f:subview id="Menu">
	<center><rich:panel header="PROGEPE - PROCESSO ELETR�NICO"
		style="height:auto;">
		<a4j:form>
			<rich:toolBar style="text-align: center;">
				<a4j:commandButton value="CADASTRAR BANCO"
					action="#{bancoController.cadastrar}" />
				<a4j:commandButton value="LISTAR BANCOS"
					action="#{bancoController.listar}" />
				<a4j:commandButton value="CADASTRAR CARGO"
					action="#{cargoController.cadastrar}" />
				<a4j:commandButton value="LISTAR CARGOS"
					action="#{cargoController.listar}" />
				<a4j:commandButton value="CADASTRAR FUN��O"
					action="#{funcaoController.cadastrar}" />
				<a4j:commandButton value="LISTAR FUN��ES"
					action="#{funcaoController.listar}" />
			</rich:toolBar>
			<rich:toolBar style="text-align: center;">
				<a4j:commandButton value="CADASTRAR LOTA��O"
					action="#{lotacaoController.cadastrar}" />
				<a4j:commandButton value="LISTAR LOTA��ES"
					action="#{lotacaoController.listar}" />
				<a4j:commandButton value="CADASTRAR SERVIDOR"
					action="#{servidorController.cadastrar}" />
				<a4j:commandButton value="CADASTRAR TIPO FUN��O" action="#" />
				<a4j:commandButton value="LISTAR TIPO FUN��O" action="#" />
			</rich:toolBar>
		</a4j:form>
	</rich:panel></center>
</f:subview></div>
</body>

