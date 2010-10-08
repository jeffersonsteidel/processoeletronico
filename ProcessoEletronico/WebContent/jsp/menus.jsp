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
			<rich:toolBar style="text-align: center;">
				<!-- ### CADASTRAR SERVIDOR### -->
				<a4j:commandButton image="../images/bot_adicionarservidor.gif"
					action="#{servidorController.cadastrar}" />
					
				<!-- ### LISTAR SERVIDOR### -->	
				<a4j:commandButton image="../images/listarServidores.GIF"
					action="#{servidorController.listar}" />
					
				<!-- ### PESQUISAR SERVIDOR### -->	
				<a4j:commandButton image="../images/pesquisarServidores.GIF"
					action="#{servidorController.pesquisarServidores}" />	
					
					
			</rich:toolBar>			
			<a4j:status>
				<f:facet name="start">
					<h:graphicImage value="../images/ajax-loader.gif" />
				</f:facet>
			</a4j:status>
		</a4j:form>
	</rich:panel></center>
</f:subview></div>
</body>

