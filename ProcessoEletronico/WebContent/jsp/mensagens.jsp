
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instituto Federal do Paraná</title>
<link rel="StyleSheet" type="text/css" href="../css/messages-style.css"
	media="screen" />
</head>
<body>
<rich:modalPanel id="_messagesPanel"
	showWhenRendered="#{not empty facesContext.maximumSeverity}"
	autosized="true" moveable="true">
	<f:facet name="header">
		<h:panelGroup style="margin-right: 15px;">
			<h:outputText value="Críticas encontradas em: " />
			<ui:insert name="pageTitle" />
		</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<h:outputLink id="_fecharLink"
				onclick="document.getElementById('_messagesPanel').component.hide();return false;"
				style="color: white; font-weight: bold; cursor: pointer; margin-left: 10px; top:3px;">X</h:outputLink>
		</h:panelGroup>
	</f:facet>
	<h:form>
		<rich:messages tooltip="true" style="white-space: pre;">
			<f:facet name="errorMarker">
				<h:graphicImage url="../resources/images/error_ico.png"
					style="margin-right:5px; position: relative; top: 1px;" />
			</f:facet>
		</rich:messages>
		<rich:spacer height="40" />
		<h:panelGrid style="text-align:center; margin: 0 auto; width: 100%;">
			<h:commandButton value="Fechar" id="_fecharButton"
				onclick="document.getElementById('_messagesPanel').component.hide();return false;" />
			<rich:hotKey key="esc"
				handler="document.getElementById('_messagesPanel').component.hide();return false;" />
			<!--se o usuário clicar esc a janela da modal desaparece-->
		</h:panelGrid>
	</h:form>
</rich:modalPanel>
</body>
</html>