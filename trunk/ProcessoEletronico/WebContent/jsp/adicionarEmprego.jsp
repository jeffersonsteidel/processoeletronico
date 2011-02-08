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
			<font size="2"><b>ADICIONAR EMPREGO</b></font>
			<h:panelGrid columns="1">
				<h:outputText id="siapeNome"
					value="#{empregoController.emprego.servidor.siape} - #{empregoController.emprego.servidor.nome}">
				</h:outputText>
			</h:panelGrid>

			<a4j:region>
				<h:panelGrid columns="4">

					<h:outputText value="Cargo: " />

					<h:inputText id="cargo"
						requiredMessage="Campo Cargo é obrigatório!" required="true"
						value="#{empregoController.emprego.cargo}" size="40"
						maxlength="80"></h:inputText>
					<h:outputText value="Empresa: " />
					<h:inputText id="empresa"
						requiredMessage="Campo Empresa é obrigatório!" required="true"
						value="#{empregoController.emprego.empresa}" size="60"
						maxlength="100"></h:inputText>

					<h:outputText value="Data de Admissão: " />
					<rich:calendar required="true"
						requiredMessage="Campo Data de Admissão é Obrigatório!"
						value="#{empregoController.emprego.dataAdmissao}" locale=""
						popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
						cellWidth="12px" cellHeight="12px" style="width:80px"
						inputSize="12" />

					<h:outputText value="Data de Saída: " />
					<rich:calendar required="true"
						requiredMessage="Campo Data de Saida é Obrigatório!"
						value="#{empregoController.emprego.dataSaida}" locale=""
						popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
						cellWidth="12px" cellHeight="12px" style="width:80px"
						inputSize="12" />

				</h:panelGrid>

				<h:panelGrid columns="4">
					<center><h:outputText value="Atividades: " /> <h:inputTextarea
						value="#{empregoController.emprego.atividades}" rows="10"
						cols="50" required="true"
						requiredMessage="Campo Atividades é obrigatório!">
					</h:inputTextarea></center>

				</h:panelGrid>
				<h:panelGrid columns="2">
					<a4j:commandButton value="Adicionar"
						action="#{empregoController.salvarEmprego}"
						reRender="listaEmpregos, form" />
				</h:panelGrid>

				<rich:dataTable id="listaEmpregos"
					value="#{empregoController.listaEmpregos}" var="list"
					width="1150px" columnClasses="center" rows="15">

					<rich:column width="700px" sortBy="#{list.empresa}">
						<f:facet name="header">
							<h:outputText value="Empresa" />
						</f:facet>
						<h:outputText value="#{list.empresa}" />
					</rich:column>

					<rich:column width="500px" sortBy="#{list.cargo}">
						<f:facet name="header">
							<h:outputText value="Cargo" />
						</f:facet>
						<h:outputText value="#{list.cargo}" />
					</rich:column>

					<rich:column width="80px" sortBy="#{list.dataAdmissao}">
						<f:facet name="header">
							<h:outputText value="Data de Admissão" />
						</f:facet>
						<h:outputText value="#{list.dataAdmissao}">
							<f:convertDateTime pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>

					<rich:column width="80px" sortBy="#{list.dataSaida}">
						<f:facet name="header">
							<h:outputText value="Data de Saida" />
						</f:facet>
						<h:outputText value="#{list.dataSaida}">
							<f:convertDateTime pattern="dd/MM/yyyy" />
						</h:outputText>
					</rich:column>

					<rich:column>
						<f:facet name="header">
							<h:outputText value="Editar" />
						</f:facet>
						<a4j:commandLink action="#{empregoController.carregar}"
							rendered="#{list.statusSolicitacao.codigo > 2 }"
							reRender="listaEmpregos, form" ajaxSingle="true">
							<h:graphicImage value="../images/edit.gif" style="border:0"
								width="20" height="18" id="editar" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{empregoController.emprego.codigo}" />
						</a4j:commandLink>
						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo <= 2}"
							reRender="#" ajaxSingle="true">
							<h:graphicImage value="../images/edit.gif" style="border:0"
								width="20" height="18" id="editarNPermitido" />
						</a4j:commandLink>
						<rich:toolTip for="editar" value="Editar" />
						<rich:toolTip for="editarNPermitido"
							value="Você somente poderá editar dependentes deferidos ou indeferidos!" />
					</rich:column>
					
					<rich:column width="60px">
						<f:facet name="header">
							<h:outputText value="Adicionar Documentos" />
						</f:facet>
						<a4j:commandLink id="documentos"
							action="#{documentoImagemController.abrirAdicionarDocumentosEmprego}"
							reRender="listaDependentes" ajaxSingle="true">
							<h:graphicImage value="../images/add_documentos.png"
								style="border:0" width="20" height="18" />
						</a4j:commandLink>
						<rich:toolTip for="documentos" value="Clique aqui para adicionar a Cópia do Registro em Carteira!" />
					</rich:column>

					<rich:column width="30px">
						<f:facet name="header">
							<h:outputText value="Status" />
						</f:facet>

						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 1}"
							action="#{empregoController.carregar}" reRender="painel"
							ajaxSingle="true" oncomplete="#{rich:component('painel')}.show()">
							<h:graphicImage value="../images/encaminhado.png"
								style="border:0" width="20" height="18" id="encaminhado" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{empregoController.emprego.codigo}" />
						</a4j:commandLink>

						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 2}"
							action="#{empregoController.carregar}" reRender="painel"
							ajaxSingle="true" oncomplete="#{rich:component('painel')}.show()">
							<h:graphicImage value="../images/analize.gif" style="border:0"
								width="20" height="18" id="emAnalise" />
						</a4j:commandLink>

						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 3}"
							action="#{empregoController.carregar}" reRender="painel"
							ajaxSingle="true" oncomplete="#{rich:component('painel')}.show()">
							<h:graphicImage value="../images/deferido.gif" style="border:0"
								width="20" height="18" id="deferido" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{empregoController.emprego.codigo}" />
						</a4j:commandLink>

						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 4}"
							action="#{empregoController.carregar}" reRender="painel"
							ajaxSingle="true" oncomplete="#{rich:component('painel')}.show()">
							<h:graphicImage value="../images/indeferido.gif" style="border:0"
								width="20" height="18" id="indeferido" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{empregoController.emprego.codigo}" />
						</a4j:commandLink>

						<rich:toolTip for="encaminhado" value="Encaminhado" />
						<rich:toolTip for="emAnalise" value="Em Análise" />
						<rich:toolTip for="deferido" value="Deferido" />
						<rich:toolTip for="indeferido" value="Indeferido" />
					</rich:column>

					<f:facet name="footer">
						<rich:datascroller id="ds"></rich:datascroller>
					</f:facet>
				</rich:dataTable>
			</a4j:region>
		</rich:panel></center>
	</a4j:form>

	<center><rich:modalPanel id="painel" autosized="true"
		width="350">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Detalhes do Status"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="../images/close.gif"
					onclick="#{rich:component('painel')}.hide();" />
			</h:panelGroup>
		</f:facet>
		<h:panelGrid columns="2">
			<h:outputText value="Status: " />
			<h:outputText
				rendered="#{empregoController.emprego.statusSolicitacao.descricao != null}"
				value="#{empregoController.emprego.statusSolicitacao.descricao}">
			</h:outputText>
			<h:outputText value="Data Ultima Auteração: " />
			<h:outputText
				rendered="#{empregoController.emprego.dataAbertura != null}"
				value="#{empregoController.emprego.dataAbertura}">
				<f:convertDateTime pattern="dd/MM/yyyy - HH:mm:ss" />
			</h:outputText>
			<h:outputText
				rendered="#{empregoController.emprego.dataAtendimento != null}"
				value="Data Atendimento: " />
			<h:outputText
				rendered="#{empregoController.emprego.dataAtendimento != null}"
				value="#{empregoController.emprego.dataAtendimento}">
				<f:convertDateTime pattern="dd/MM/yyyy - HH:mm:ss" />
			</h:outputText>
			<h:outputText
				rendered="#{empregoController.emprego.atendente != null}"
				value="Atendente: " />
			<h:outputText
				rendered="#{empregoController.emprego.atendente!= null}"
				value="#{empregoController.atendente.nome}">
			</h:outputText>
			<h:outputText
				rendered="#{empregoController.emprego.dataFechamento != null}"
				value="Data Fechamento: " />
			<h:outputText
				rendered="#{empregoController.emprego.dataFechamento.date != null}"
				value="#{empregoController.emprego.dataFechamento}">
				<f:convertDateTime pattern="dd/MM/yyyy - HH:mm:ss" />
			</h:outputText>
			<h:outputText
				rendered="#{empregoController.emprego.justificativa != null}"
				value="Justificativa: " />
			<h:outputText
				rendered="#{empregoController.emprego.justificativa != null}"
				value="#{empregoController.emprego.justificativa}">
			</h:outputText>
		</h:panelGrid>
	</rich:modalPanel></center>

</f:view>
</body>
</html>