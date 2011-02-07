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
			<font size="2"><b>ADICIONAR TITULA��O</b></font>
			<h:panelGrid columns="1">
				<h:outputText id="siapeNome"
					value="#{servidorTitulacaoController.servidorTitulacao.servidor.siape} - #{servidorTitulacaoController.servidorTitulacao.servidor.nome}">
				</h:outputText>
			</h:panelGrid>

			<a4j:region>
				<h:panelGrid columns="4">

					<h:outputText value="Tiula��o: " />

					<h:selectOneMenu id="titulacao"
						value="#{servidorTitulacaoController.servidorTitulacao.titulacao.codigo}"
						required="true" requiredMessage="Campo Titula��o � obrigat�rio!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorTitulacaoController.titulacoes}" />
						<a4j:support event="onchange"
							action="#{servidorTitulacaoController.validarTitulacao}"
							ajaxSingle="true"
							reRender="curso,areaConhecimento,cargaHoraria,registroConselho,orgaoEmissor,estadoEmissor"></a4j:support>
					</h:selectOneMenu>

					<h:outputText value="Estabelecimento de Ensino: " />

					<h:inputText id="estabelecimentoEnsino"
						requiredMessage="Campo Estabelecimento de Ensino � obrigat�rio!"
						required="true"
						value="#{servidorTitulacaoController.servidorTitulacao.estabelecimentoEnsino}"
						size="40" maxlength="100"></h:inputText>

					<h:outputText value="Curso: " />

					<h:inputText id="curso" required="true"
						requiredMessage="Campo Curso � obrigat�rio!"
						disabled="#{!servidorTitulacaoController.indSuperior}"
						value="#{servidorTitulacaoController.servidorTitulacao.curso}"
						size="40" maxlength="100"></h:inputText>

					<h:outputText value="Area de Conhecimento: " />

					<h:selectOneMenu id="areaConhecimento"
						value="#{servidorTitulacaoController.servidorTitulacao.areaConhecimento.codigo}"
						required="true"
						disabled="#{!servidorTitulacaoController.indSuperior}"
						requiredMessage="Campo Area de Conhecimento � obrigat�rio!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems
							value="#{servidorTitulacaoController.areasConhecimento}" />
					</h:selectOneMenu>

					<h:outputText value="Estado do Estabelecimento de Ensino: " />
					<h:selectOneMenu id="estadoEstabelecimento"
						value="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.estado.codigo}"
						required="true"
						disabled="#{servidorTitulacaoController.indTitulacaoEstrangeira}"
						requiredMessage="Campo Estado do Estabelecimento de Ensino � obrigat�rio!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorTitulacaoController.estados}" />
						<a4j:support event="onchange"
							action="#{servidorTitulacaoController.listarCidadesEstabelecimento}"
							ajaxSingle="true" reRender="cidadeEstabelecimento"></a4j:support>
					</h:selectOneMenu>
					<h:outputText value="Cidade de Estabelecimento de Ensino: " />
					<h:selectOneMenu id="cidadeEstabelecimento"
						value="#{servidorTitulacaoController.servidorTitulacao.cidadeEstabelecimentoEnsino.codigo}"
						required="true"
						disabled="#{servidorTitulacaoController.indTitulacaoEstrangeira}"
						requiredMessage="Campo Cidade do Estabelecimento de Ensino � obrigat�rio!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems
							value="#{servidorTitulacaoController.cidadesEstabelecimento}" />
					</h:selectOneMenu>

					<h:outputText value="Carga Hor�ria: " />

					<h:inputText id="cargaHoraria" required="true"
						requiredMessage="Campo Carga Hor�ria � obrigat�rio!"
						disabled="#{!servidorTitulacaoController.indSuperior}"
						value="#{servidorTitulacaoController.servidorTitulacao.cargaHoraria}"
						size="9" maxlength="4" onkeypress="mascara(this,soNumeros);"></h:inputText>

					<h:outputText value="Ano de Conclus�o: " />

					<h:inputText id="anoConclusao" required="true"
						requiredMessage="Campo Ano de Conclus�o � obrigat�rio!"
						value="#{servidorTitulacaoController.servidorTitulacao.anoConclusao}"
						size="9" maxlength="4" onkeypress="mascara(this,soNumeros);"
						validatorMessage="Campo Ano de Conclus�o deve ter 4 digitos!">
						<f:validateLength minimum="4" />
					</h:inputText>

					<h:outputText value="Registro no Conselho: " />

					<h:inputText id="registroConselho"
						disabled="#{!servidorTitulacaoController.indSuperior}"
						value="#{servidorTitulacaoController.servidorTitulacao.registroConselho}"
						size="9" maxlength="10"></h:inputText>

					<h:outputText value="Org�o Emissor do Registro: " />

					<h:inputText id="orgaoEmissor"
						disabled="#{!servidorTitulacaoController.indSuperior}"
						value="#{servidorTitulacaoController.servidorTitulacao.orgaoEmissor}"
						size="9" maxlength="8"></h:inputText>

					<h:outputText value="Estado do Org�o Emissor: " />
					<h:selectOneMenu id="estadoEmissor"
						disabled="#{!servidorTitulacaoController.indSuperior}"
						value="#{servidorTitulacaoController.servidorTitulacao.estadoOrgaoEmissor.codigo}">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorTitulacaoController.ufs}" />
					</h:selectOneMenu>

					<h:outputText value="Titula��o Estrangeira: " />
					<h:selectBooleanCheckbox id="titulacaoEstrangeira"
						title="Marcar esta op��o caso tenha titula��o estrangeira!"
						value="#{servidorTitulacaoController.indTitulacaoEstrangeira}">
						<a4j:support event="onchange"
							action="#{servidorTitulacaoController.isTitulacaoEstrangeira}"
							ajaxSingle="true"
							reRender="estadoEstabelecimento, pais, cidadeEstabelecimento"></a4j:support>
					</h:selectBooleanCheckbox>

					<h:outputText value="Pa�s: " />
					<h:selectOneMenu id="pais"
						value="#{servidorTitulacaoController.servidorTitulacao.pais.codigo}"
						required="true"
						disabled="#{!servidorTitulacaoController.indTitulacaoEstrangeira}"
						requiredMessage="Campo Pa�s de Origem � obrigat�rio!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorTitulacaoController.paises}" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid columns="2">
					<a4j:commandButton value="Adicionar"
						action="#{servidorTitulacaoController.salvarTitulacao}"
						reRender="listaTitulacoes, form" />
				</h:panelGrid>

				<rich:dataTable id="listaTitulacoes"
					value="#{servidorTitulacaoController.listaServidorTitulacoes}"
					var="list" width="1150px" columnClasses="center" rows="15"
					reRender="ds">
					<rich:column width="350px" sortBy="#{list.titulacao.descricao}">
						<f:facet name="header">
							<h:outputText value="Titulacao" />
						</f:facet>
						<h:outputText value="#{list.titulacao.descricao}" />
					</rich:column>
					<rich:column width="550px" sortBy="#{list.curso}">
						<f:facet name="header">
							<h:outputText value="Curso" />
						</f:facet>
						<h:outputText value="#{list.curso}" />
					</rich:column>
					<rich:column width="400px"
						sortBy="#{list.areaConhecimento.descricao}">
						<f:facet name="header">
							<h:outputText value="Area de Conhecimento" />
						</f:facet>
						<h:outputText value="#{list.areaConhecimento.descricao}" />
					</rich:column>
					<rich:column width="100px" sortBy="#{list.anoConclusao}">
						<f:facet name="header">
							<h:outputText value="Ano de Conclusao" />
						</f:facet>
						<h:outputText value="#{list.anoConclusao}" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="Editar" />
						</f:facet>
						<a4j:commandLink action="#{servidorTitulacaoController.carregarTitulacao}" disabled="#{list.statusSolicitacao.codigo < 3}"
							reRender="listaTitulacoes, form" ajaxSingle="true">
							<h:graphicImage value="../images/edit.gif" style="border:0"
								width="20" height="18" id="editar" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{servidorTitulacaoController.servidorTitulacao.codigo}" />
						</a4j:commandLink>
						<rich:toolTip for="editar" value="Editar" />
					</rich:column>
					
					<rich:column width="60px">
						<f:facet name="header">
							<h:outputText value="Adicionar Documentos" />
						</f:facet>
						<a4j:commandLink id="documentos"
							action="#{documentoImagemController.abrirAdicionarDocumentos}"
							ajaxSingle="true">
							<h:graphicImage value="../images/add_documentos.png"
								style="border:0" width="20" height="18" />
						</a4j:commandLink>
						<rich:toolTip for="documentos" value="Clique aqui para adicionar os Documentos da Titula��o!" />
					</rich:column>
					
					<rich:column width="30px">
						<f:facet name="header">
							<h:outputText value="Status" />
						</f:facet>
						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 1}"
							action="#{servidorTitulacaoController.carregarStatus}"
							reRender="painel" ajaxSingle="true"
							oncomplete="#{rich:component('painel')}.show()">
							<h:graphicImage value="../images/encaminhado.png"
								style="border:0" width="20" height="18" id="encaminhado" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{servidorTitulacaoController.servidorTitulacaoFiltro.codigo}" />
						</a4j:commandLink>
						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 2}"
							action="#{servidorTitulacaoController.carregarStatus}"
							reRender="painel" ajaxSingle="true"
							oncomplete="#{rich:component('painel')}.show()">
							<h:graphicImage value="../images/analize.gif" style="border:0"
								width="20" height="18" id="emAnalise" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{servidorTitulacaoController.servidorTitulacaoFiltro.codigo}" />
						</a4j:commandLink>
						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 3}"
							action="#{servidorTitulacaoController.carregarStatus}"
							reRender="painel" ajaxSingle="true"
							oncomplete="#{rich:component('painel')}.show()">
							<h:graphicImage value="../images/deferido.gif" style="border:0"
								width="20" height="18" id="deferido" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{servidorTitulacaoController.servidorTitulacaoFiltro.codigo}" />
						</a4j:commandLink>
						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 4}"
							action="#{servidorTitulacaoController.carregarStatus}"
							reRender="painel" ajaxSingle="true"
							oncomplete="#{rich:component('painel')}.show()">
							<h:graphicImage value="../images/indeferido.gif" style="border:0"
								width="20" height="18" id="indeferido" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{servidorTitulacaoController.servidorTitulacaoFiltro.codigo}" />
						</a4j:commandLink>
						<rich:toolTip for="encaminhado" value="Encaminhado" />
						<rich:toolTip for="emAnalise"
							value="Voc� n�o pode abrir uma solicita��o que est� em An�lise!" />
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
				rendered="#{servidorTitulacaoController.servidorTitulacaoFiltro.statusSolicitacao.descricao != null}"
				value="#{servidorTitulacaoController.servidorTitulacaoFiltro.statusSolicitacao.descricao}">
			</h:outputText>
			<h:outputText value="Data Ultima Altera��o: " />
			<h:outputText
				rendered="#{servidorTitulacaoController.servidorTitulacaoFiltro.dataAbertura != null}"
				value="#{servidorTitulacaoController.servidorTitulacaoFiltro.dataAbertura}">
				<f:convertDateTime pattern="dd/MM/yyyy - HH:mm:ss" />
			</h:outputText>
			<h:outputText
				rendered="#{servidorTitulacaoController.servidorTitulacaoFiltro.dataAtendimento != null}"
				value="Data Atendimento: " />
			<h:outputText
				rendered="#{servidorTitulacaoController.servidorTitulacaoFiltro.dataAtendimento != null}"
				value="#{servidorTitulacaoController.servidorTitulacaoFiltro.dataAtendimento}">
				<f:convertDateTime pattern="dd/MM/yyyy - HH:mm:ss" />
			</h:outputText>
			<h:outputText
				rendered="#{servidorTitulacaoController.servidorTitulacaoFiltro.atendente != null}"
				value="Atendente: " />
			<h:outputText
				rendered="#{servidorTitulacaoController.servidorTitulacaoFiltro.atendente!= null}"
				value="#{servidorTitulacaoController.atendente.nome}">
			</h:outputText>
			<h:outputText
				rendered="#{servidorTitulacaoController.servidorTitulacaoFiltro.dataFechamento != null}"
				value="Data Fechamento: " />
			<h:outputText
				rendered="#{servidorTitulacaoController.servidorTitulacaoFiltro.dataFechamento.date != null}"
				value="#{servidorTitulacaoController.servidorTitulacaoFiltro.dataFechamento}">
				<f:convertDateTime pattern="dd/MM/yyyy - HH:mm:ss" />
			</h:outputText>
			<h:outputText
				rendered="#{servidorTitulacaoController.servidorTitulacaoFiltro.justificativa != null}"
				value="Justificativa: " />
			<h:outputText
				rendered="#{servidorTitulacaoController.servidorTitulacaoFiltro.justificativa != null}"
				value="#{servidorTitulacaoController.servidorTitulacaoFiltro.justificativa}">
			</h:outputText>
		</h:panelGrid>
	</rich:modalPanel></center>
</f:view>
</body>
</html>