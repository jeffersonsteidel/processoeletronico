<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instituto Federal do Paraná</title>
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
			<font size="2"><b>CADASTRAR PROGRESSÃO POR CAPACITAÇÃO</b></font>

			<h:panelGrid columns="1">
				<h:outputText
					value="#{progressaoController.progressao.servidor.siape} - #{progressaoController.progressao.servidor.nome}">
				</h:outputText>
			</h:panelGrid>

			<h:panelGrid columns="4">
				<h:outputText value="Siape do Servidor: ">
				</h:outputText>
				<h:inputText id="siape"
					value="#{progressaoController.progressao.servidor.siape}" size="10"
					maxlength="7" required="true"
					requiredMessage="Campo Siape do Servidor é obrigatório!"
					onkeypress="mascara(this,soNumeros);">
					<a4j:support event="onchange"
						action="#{progressaoController.buscarServidor}" ajaxSingle="true"
						reRender="servidor,siape, classeAtual,padraoAtual,classeNova"></a4j:support>
				</h:inputText>

				<h:outputText value="Nome do Servidor: ">
				</h:outputText>
				<h:outputText id="servidor"
					value="#{progressaoController.progressao.servidor.nome}">
				</h:outputText>

				<h:outputText value="Classe Atual: "></h:outputText>
				<h:outputText id="classeAtual"
					value="#{progressaoController.progressao.servidor.cargo.classe.sigla}"></h:outputText>
				<h:outputText value="Padrão Atual: "></h:outputText>
				<h:outputText id="padraoAtual"
					value="#{progressaoController.progressao.servidor.padrao.nivel}"></h:outputText>
				<h:outputText value="Classe Nova: "></h:outputText>
				<h:outputText id="classeNova"
					value="#{progressaoController.progressao.servidor.cargo.classe.sigla}"></h:outputText>
				<h:outputText value="Padrão Novo: "></h:outputText>
				<h:selectOneMenu
					value="#{progressaoController.progressao.padraoNovo}"
					required="true" requiredMessage="Campo Padrão Novo é obrigatório!">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{progressaoController.padroes}" />
				</h:selectOneMenu>

				<h:outputText value="Data da Progressão: " />
				<rich:calendar
					value="#{progressaoController.progressao.dataProgressao}" locale=""
					popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					inputSize="12" required="true"
					requiredMessage="Campo Data da Progressão é obrigatório!">
					<a4j:support event="onchanged"
						action="#{progressaoController.calcularProximaProgressao}"
						ajaxSingle="true" reRender="dataProxima"></a4j:support>
				</rich:calendar>

				<h:outputText value="Portaria: "></h:outputText>
				<h:inputText value="#{progressaoController.progressao.portaria}"
					size="40" maxlength="60"
					requiredMessage="Campo Portaria é obrigatório!" required="true"></h:inputText>

				<h:outputText value="Curso: "></h:outputText>
				<h:inputText value="#{progressaoController.progressao.curso}"
					size="40" maxlength="100"
					requiredMessage="Campo Curso é obrigatório!" required="true"></h:inputText>

				<h:outputText value="Carga Horária: "></h:outputText>
				<h:inputText value="#{progressaoController.progressao.cargaHoraria}"
					size="4" maxlength="4" onkeypress="mascara(this,soNumeros);"
					requiredMessage="Campo Carga Horária é obrigatório!"
					required="true"></h:inputText>

				<h:outputText value="Instituição de Ensino: "></h:outputText>
				<h:inputText
					value="#{progressaoController.progressao.instituicaoEnsino}"
					size="40" maxlength="100"
					requiredMessage="Campo Instituição de Ensino é obrigatório!"
					required="true"></h:inputText>

				<h:outputText value="Data Inicio Curso: " />
				<rich:calendar id="dataProxima"
					value="#{progressaoController.progressao.dataInicio}" locale=""
					popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					inputSize="12" disabled="true" />

				<h:outputText value="Data Término do Curso: " />
				<rich:calendar
					value="#{progressaoController.progressao.dataTermino}" locale=""
					popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
					cellWidth="12px" cellHeight="12px" style="width:80px"
					inputSize="12" required="true"
					requiredMessage="Campo Data de Término do Curso é obrigatório!">
				</rich:calendar>

			</h:panelGrid>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>