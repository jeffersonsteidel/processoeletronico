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
	<a4j:form id="form">
		<center><rich:panel>
			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<font size="2"><b>CADASTRAR PROGRESS�O - M�RITO</b></font>

			<h:panelGrid columns="4">
				<h:outputText value="Siape do Servidor: ">
				</h:outputText>
				<h:inputText id="siape"
					value="#{progressaoController.progressao.servidor.siape}" size="10"
					maxlength="7" required="true"
					requiredMessage="Campo Siape do Servidor � obrigat�rio!">
					<a4j:support event="onchange"
						action="#{progressaoController.buscarServidor}" ajaxSingle="true"
						reRender="servidor,siape, classeAtual, padraoAtual, classeNova"></a4j:support>
				</h:inputText>

				<h:outputText value="Nome do Servidor: ">
				</h:outputText>
				<h:outputText id="servidor"
					value="#{progressaoController.progressao.servidor.nome}">
				</h:outputText>

				<h:outputText value="Classe: "></h:outputText>
				<h:outputText id="classeAtual"
					value="#{progressaoController.progressao.classe.sigla}"></h:outputText>
				<h:outputText value="Padr�o Atual: "></h:outputText>
				<h:outputText id="padraoAtual"
					value="#{progressaoController.progressao.padraoAntigo.nivel}"></h:outputText>
			

				<h:outputText value="Data da Progress�o: " />
				<rich:calendar
					value="#{progressaoController.progressao.dataProgressao}" locale=""
					popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					inputSize="12" required="true"
					requiredMessage="Campo Data da Progress�o � obrigat�rio!">
					<a4j:support event="onchanged"
						action="#{progressaoController.calcularProximaProgressao}"
						ajaxSingle="true" reRender="form"></a4j:support>
				</rich:calendar>
				
				<h:outputText value="Data da Pr�xima Progress�o: " id="dataProxima1" />
				<h:outputText id="dataProxima2"
					value="#{progressaoController.progressao.dataProximaProgressao}">
					<f:convertDateTime locale="pt_BR" pattern="dd/MM/yyyy" />
				</h:outputText>
				

				<h:outputText value="Nota: "></h:outputText>
				<h:inputText value="#{progressaoController.progressao.nota}"
					size="5" maxlength="6" requiredMessage="Campo Nota � obrigat�rio!"
					required="true">
					<a4j:support event="onchange"
						action="#{progressaoController.validarConcessao}" ajaxSingle="true"
						reRender="novoPadrao"></a4j:support>
				</h:inputText>

				<h:outputText value="Padr�o Novo: "></h:outputText>
				<h:outputText id="novoPadrao"
					value="#{progressaoController.progressao.padraoNovo.nivel}">
				</h:outputText>
				

				<h:outputText value="Tipo Progress�o: "></h:outputText>
				<h:outputText value="M�RITO"></h:outputText>


				<h:outputText value="Portaria: "></h:outputText>
				<h:inputText value="#{progressaoController.progressao.portaria}"
					size="40" maxlength="60"
					requiredMessage="Campo Portaria � obrigat�rio!" required="true"></h:inputText>
			</h:panelGrid>

			<h:panelGrid>
				<a4j:commandButton value="Salvar"
					action="#{progressaoController.salvar}" reRender="form" />
			</h:panelGrid>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>