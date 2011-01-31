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

			<font size="2"><b>ADICIONAR DEPENDENTE</b></font>

			<h:panelGrid columns="1">
				<h:outputText
					value="#{dependenteController.dependente.servidor.siape} - #{dependenteController.dependente.servidor.nome}">
				</h:outputText>
			</h:panelGrid>
			<a4j:region>
				<h:panelGrid columns="4">

					<h:outputText value="Nome do Dependente: ">
					</h:outputText>
					<h:inputText value="#{dependenteController.dependente.nome}"
						size="50" maxlength="100" required="true"
						requiredMessage="Campo Nome do Dependente é obrigatório!"></h:inputText>

					<h:outputText value="Sexo do Dependente: " />
					<h:selectOneMenu value="#{dependenteController.dependente.sexo}"
						required="true" requiredMessage="Campo Sexo é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItem itemLabel="FEMININO" itemValue="F" />
						<f:selectItem itemLabel="MASCULINO" itemValue="M" />
					</h:selectOneMenu>

					<h:outputText value="Data de Nascimento do Dependente: " />
					<rich:calendar
						value="#{dependenteController.dependente.dataNascimento}"
						locale="" popup="true" datePattern="dd/MM/yyyy"
						showApplyButton="#" cellWidth="12px" cellHeight="12px"
						style="width:80px" required="true" inputSize="12"
						requiredMessage="Campo Data de Nascimento do Dependente é obrigatório!" />

					<h:outputText value="CPF do Dependente: " />
					<h:inputText value="#{dependenteController.dependente.cpf}"
						required="true"
						requiredMessage="Campo CPF do Dependente é obrigatório!" size="16"
						maxlength="14" id="cpf" onkeypress="mascara(this,cpf);">
						<a4j:support event="onchange"
							action="#{dependenteController.validarCPF}" ajaxSingle="true"
							reRender="cpf, confirmPanel, messages"></a4j:support>
					</h:inputText>

					<h:outputText value="RG do Dependente: " />
					<h:inputText value="#{dependenteController.dependente.rg}"
						size="16" maxlength="13"></h:inputText>

					<h:outputText value="UF do RG do Dependente: " />
					<h:selectOneMenu
						value="#{dependenteController.dependente.rgUf.codigo}">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{dependenteController.ufs}" />
					</h:selectOneMenu>

					<h:outputText value="Orgão Emissor do RG do Dependente: " />
					<h:inputText value="#{dependenteController.dependente.rgOrgao}"
						size="16" maxlength="8" />

					<h:outputText value="Data de Expedição do RG do Dependente: " />
					<rich:calendar
						value="#{dependenteController.dependente.rgDataExpedicao}"
						locale="" popup="true" datePattern="dd/MM/yyyy"
						showApplyButton="#" cellWidth="12px" cellHeight="12px"
						style="width:80px" inputSize="12" />

					<h:outputText value="Grau Parentesco: " />
					<h:selectOneMenu
						value="#{dependenteController.dependente.grauParentesco.codigo}"
						required="true"
						requiredMessage="Campo Grau Parentesco é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{dependenteController.grausParentescos}" />
					</h:selectOneMenu>

					<h:outputText value="Imposto de Renda: " />
					<h:selectBooleanCheckbox id="impostoDeRenda"
						value="#{dependenteController.dependente.indIr}">
					</h:selectBooleanCheckbox>

					<h:outputText value="Necessidades Especiais: " />
					<h:selectBooleanCheckbox id="necessidadesEspeciais"
						value="#{dependenteController.dependente.indNecessidadesEspeciais}">
					</h:selectBooleanCheckbox>

					<h:outputText value="Estudante Universitário: " />
					<h:selectBooleanCheckbox id="estudanteUniversitario"
						value="#{dependenteController.dependente.indEstudante}">
						<a4j:support event="onchange"
							action="#{dependenteController.validarEstudante}"
							ajaxSingle="true" reRender="faculdade, curso, dataFormacao"></a4j:support>
					</h:selectBooleanCheckbox>

					<h:outputText value="Estabelecimento de Ensino: ">
					</h:outputText>
					<h:inputText id="faculdade"
						value="#{dependenteController.dependente.faculdade}" size="50"
						maxlength="100"
						disabled="#{!dependenteController.dependente.indEstudante}"
						required="true"
						requiredMessage="Campo Estabelecimento de Ensino é obrigatório!"></h:inputText>

					<h:outputText value="Curso: ">
					</h:outputText>
					<h:inputText id="curso"
						value="#{dependenteController.dependente.curso}" size="50"
						maxlength="100"
						disabled="#{!dependenteController.dependente.indEstudante}"
						required="true" requiredMessage="Campo Curso é obrigatório!"></h:inputText>

					<h:outputText value="Previsão de Formação: " />
					<rich:calendar id="dataFormacao"
						value="#{dependenteController.dependente.dataFormacao}" locale=""
						popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
						cellWidth="12px" cellHeight="12px" style="width:80px"
						disabled="#{!dependenteController.dependente.indEstudante}"
						required="true" inputSize="12"
						requiredMessage="Campo Previsão de Formação é obrigatório!" />
				</h:panelGrid>

				<a4j:commandButton value="Salvar"
					action="#{dependenteController.salvarDependente}" reRender="form" />

				<rich:dataTable id="listaDependentes"
					value="#{dependenteController.listaDependentes}" var="list"
					width="1000px" columnClasses="center" rows="15" reRender="ds">

					<rich:column width="435px">
						<f:facet name="header">
							<h:outputText value="Nome do Dependente" />
						</f:facet>
						<h:outputText value="#{list.nome}" />
					</rich:column>

					<rich:column width="435px">
						<f:facet name="header">
							<h:outputText value="Grau Parentesco" />
						</f:facet>
						<h:outputText value="#{list.grauParentesco.descricao}" />
					</rich:column>
					<rich:column width="30px">
						<f:facet name="header">
							<h:outputText value="Editar" />
						</f:facet>
						<a4j:commandLink action="#{dependenteController.carregar}"
							rendered="#{list.statusSolicitacao.codigo > 2}"
							reRender="listaDependentes, form" ajaxSingle="true">
							<h:graphicImage value="../images/edit.gif" style="border:0"
								width="20" height="18" id="editar" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{dependenteController.dependente.codigo}" />
						</a4j:commandLink>
						<a4j:commandLink 
							rendered="#{list.statusSolicitacao.codigo <= 2}"
							reRender="listaDependentes" ajaxSingle="true">
							<h:graphicImage value="../images/edit.gif" style="border:0"
								width="20" height="18" id="editarNPermitido" />
						</a4j:commandLink>
						<rich:toolTip for="editar" value="Editar" />
						<rich:toolTip for="editarNPermitido"
							value="Você somente poderá editar dependentes deferidos ou indeferidos!" />
					</rich:column>

					<rich:column width="30px">
						<f:facet name="header">
							<h:outputText value="Ativar/Desativar" />
						</f:facet>
						<a4j:commandLink action="#{dependenteController.ativarDesativar}"
							rendered="#{list.statusSolicitacao.codigo >= 2}">
							<h:graphicImage id="ativo" value="../images/ativar.gif"
								style="border:0" width="20" height="18"
								rendered="#{!list.indAtivo}" />
						</a4j:commandLink>
						<a4j:commandLink action="#{dependenteController.ativarDesativar}"
							rendered="#{list.statusSolicitacao.codigo > 2}">
							<h:graphicImage id="inativo" value="../images/desativar.gif"
								style="border:0" width="20" height="18"
								rendered="#{list.indAtivo}" />
						</a4j:commandLink>
						<a4j:commandLink action="#"
							rendered="#{list.statusSolicitacao.codigo <= 2}">
							<h:graphicImage id="ativoNPermitido" value="../images/ativar.gif"
								style="border:0" width="20" height="18"
								rendered="#{!list.indAtivo}" />
						</a4j:commandLink>
						<a4j:commandLink action="#"
							rendered="#{list.statusSolicitacao.codigo <= 2}">
							<h:graphicImage id="inativoNPermitido" value="../images/desativar.gif"
								style="border:0" width="20" height="18"
								rendered="#{list.indAtivo}" />
						</a4j:commandLink>
						<rich:toolTip for="ativo" value="Ativar" />
						<rich:toolTip for="inativo" value="Desativar" />
						<rich:toolTip for="ativoNPermitido" value="Você somente pode Ativar dependente deferidos ou indeferidos" />
						<rich:toolTip for="inativoNPermitido" value="Você somente pode Desativar dependente deferidos ou indeferidos" />
					</rich:column>

					<rich:column width="30px">
						<f:facet name="header">
							<h:outputText value="Status" />
						</f:facet>
						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 1}"
							oncomplete="#{rich:component('painel')}.show()"
							action="#{dependenteController.carregar}"
							reRender="listarConjugesSolicitante, painel" ajaxSingle="true">
							<h:graphicImage value="../images/encaminhado.png"
								style="border:0" width="20" height="18" id="encaminhado" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{dependenteController.dependente.codigo}" />
						</a4j:commandLink>
						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 2}"
							oncomplete="#{rich:component('painel')}.show()"
							action="#{dependenteController.carregar}"
							reRender="listaDependentes, painel" ajaxSingle="true">
							<h:graphicImage value="../images/analize.gif" style="border:0"
								width="20" height="18" id="emAnalise" />
						</a4j:commandLink>
						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 3}"
							action="#{dependenteController.carregar}"
							reRender="listaDependentes, painel" ajaxSingle="true"
							oncomplete="#{rich:component('painel')}.show()">
							<h:graphicImage value="../images/deferido.gif" style="border:0"
								width="20" height="18" id="deferido" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{dependenteController.dependente.codigo}" />
						</a4j:commandLink>
						<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 4}"
							action="#{dependenteController.carregar}"
							oncomplete="#{rich:component('painel')}.show()"
							reRender="listaDependentes, painel" ajaxSingle="true">
							<h:graphicImage value="../images/indeferido.gif" style="border:0"
								width="20" height="18" id="indeferido" />
							<f:setPropertyActionListener value="#{list.codigo}"
								target="#{dependenteController.dependente.codigo}" />
						</a4j:commandLink>
						<rich:toolTip for="encaminhado" value="Encaminhado" />
						<rich:toolTip for="emAnalise"
							value="Você não pode abrir uma solicitação que está em Análise!" />
						<rich:toolTip for="deferido" value="Deferido" />
						<rich:toolTip for="indeferido" value="Indeferido" />
					</rich:column>

					<f:facet name="footer">
						<rich:datascroller id="ds"></rich:datascroller>
					</f:facet>
				</rich:dataTable>
			</a4j:region>

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
						rendered="#{dependenteController.dependente.statusSolicitacao.descricao != null}"
						value="#{dependenteController.dependente.statusSolicitacao.descricao}">
					</h:outputText>
					<h:outputText value="Data da Última Alteração: " />
					<h:outputText
						rendered="#{dependenteController.dependente.dataAbertura != null}"
						value="#{dependenteController.dependente.dataAbertura}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
					<h:outputText
						rendered="#{dependenteController.dependente.dataAtendimento != null}"
						value="Data Atendimento: " />
					<h:outputText
						rendered="#{dependenteController.dependente.dataAtendimento != null}"
						value="#{dependenteController.dependente.dataAtendimento}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
					<h:outputText
						rendered="#{dependenteController.dependente.atendente != null}"
						value="Atendente: " />
					<h:outputText
						rendered="#{dependenteController.dependente.atendente!= null}"
						value="#{dependenteController.atendente.nome}">
					</h:outputText>
					<h:outputText
						rendered="#{dependenteController.dependente.dataFechamento != null}"
						value="Data Fechamento: " />
					<h:outputText
						rendered="#{dependenteController.dependente.dataFechamento.date != null}"
						value="#{dependenteController.dependente.dataFechamento}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
					<h:outputText
						rendered="#{dependenteController.dependente.justificativa != null}"
						value="Justificativa: " />
					<h:outputText
						rendered="#{dependenteController.dependente.justificativa != null}"
						value="#{dependenteController.dependente.justificativa}">
					</h:outputText>
				</h:panelGrid>
			</rich:modalPanel></center>
		</rich:panel></center>
	</a4j:form>
</f:view>
</body>
</html>