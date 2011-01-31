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
	<center><a4j:form id="form">
		<rich:panel>
			<font size="2"><b>PESQUISAR DEPENDENTES</b></font>
			<h:panelGrid columns="15">

				<h:outputText value="Siape: ">
				</h:outputText>
				<h:inputText
					value="#{dependenteController.dependenteFilter.servidor.siape}"
					size="7" maxlength="7" onkeyup="mascara(this, soNumeros);">
				</h:inputText>

				<h:outputText value="Servidor: ">
				</h:outputText>
				<h:inputText
					value="#{dependenteController.dependenteFilter.servidor.nome}"
					size="25">
				</h:inputText>

				<h:outputText value="Dependente: ">
				</h:outputText>
				<h:inputText value="#{dependenteController.dependenteFilter.nome}"
					size="25">
				</h:inputText>

				<h:outputText value="Parentesco: " />
				<h:selectOneMenu
					value="#{dependenteController.dependenteFilter.grauParentesco.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{dependenteController.grausParentescos}" />
				</h:selectOneMenu>

				<h:outputText value="Status: " />
				<h:selectOneMenu
					value="#{dependenteController.dependenteFilter.statusSolicitacao.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{dependenteController.statusSolicitacoes}" />
				</h:selectOneMenu>

				<h:outputText value="Sit. Dependente: " />
				<h:selectOneMenu value="#{dependenteController.ativo}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="ATIVOS" itemValue="1" />
					<f:selectItem itemLabel="INATIVOS" itemValue="2" />
				</h:selectOneMenu>

				<h:outputText value="Sit. Servidor: " />
				<h:selectOneMenu value="#{dependenteController.situacao}">
					<f:selectItem itemLabel="TODOS" itemValue="0" />
					<f:selectItem itemLabel="ATIVOS" itemValue="1" />
					<f:selectItem itemLabel="INATIVOS" itemValue="2" />
				</h:selectOneMenu>

				<a4j:commandButton value="Pesquisar"
					action="#{dependenteController.pesquisarDependentesFiltro}"
					reRender="listaDependentes" type="submit" />
			</h:panelGrid>

			<rich:dataTable id="listaDependentes"
				value="#{dependenteController.listaDependentesFiltro}" var="list"
				width="1150px" columnClasses="center" rows="15" reRender="ds">
				<rich:column width="50px" sortBy="#{list.servidor.siape}">
					<f:facet name="header">
						<h:outputText value="Siape" />
					</f:facet>
					<h:outputText value="#{list.servidor.siape}" />
				</rich:column>

				<rich:column width="420px" sortBy="#{list.servidor.nome}">
					<f:facet name="header">
						<h:outputText value="Servidor" />
					</f:facet>
					<h:outputText value="#{list.servidor.nome}" />
				</rich:column>

				<rich:column width="420px" sortBy="#{list.nome}">
					<f:facet name="header">
						<h:outputText value="Dependente" />
					</f:facet>
					<h:outputText value="#{list.nome}" />
				</rich:column>

				<rich:column width="420px" sortBy="#{list.grauParentesco.descricao}">
					<f:facet name="header">
						<h:outputText value="Grau Parentesco" />
					</f:facet>
					<h:outputText value="#{list.grauParentesco.descricao}" />
				</rich:column>

				<rich:column width="30px">
					<f:facet name="header">
						<h:outputText value="Visualizar" />
					</f:facet>
					<a4j:commandLink action="#{dependenteController.validar}"
						reRender="listaDependentes, painel"
						oncomplete="Richfaces.showModalPanel('painel')" ajaxSingle="true">
						<h:graphicImage value="../images/encaminhado.png" style="border:0"
							width="20" height="18" id="encaminhado"
							rendered="#{list.statusSolicitacao.codigo == 1}" />
						<h:graphicImage value="../images/indeferido.gif" style="border:0"
							width="20" height="18" id="indeferido"
							rendered="#{list.statusSolicitacao.codigo == 4}" />
						<h:graphicImage value="../images/deferido.gif" style="border:0"
							width="20" height="18" id="deferido"
							rendered="#{list.statusSolicitacao.codigo == 3}" />
						<f:setPropertyActionListener value="#{list}"
							target="#{dependenteController.dependente}" />
					</a4j:commandLink>
					<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 2}"
						action="#" reRender="listaDependentes" ajaxSingle="true">
						<h:graphicImage value="../images/analize.gif" style="border:0"
							width="20" height="18" id="emAnalise" />
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
		</rich:panel>
	</a4j:form></center>

	<center><rich:modalPanel id="painel" autosized="true"
		width="560">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Detalhes do Dependente"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="../images/close.gif"
					onclick="#{rich:component('painel')}.hide();" />
			</h:panelGroup>
		</f:facet>
		<center><rich:messages layout="list"
			errorLabelClass="errorLabel" style="top:auto;"
			infoLabelClass="infoLabel">
			<f:facet name="infoMarker">
				<h:graphicImage value="../images/passed.gif" />
			</f:facet>
			<f:facet name="errorMarker">
				<h:graphicImage value="../images/error.gif" />
			</f:facet>
		</rich:messages></center>
		<h:panelGrid columns="2">
			<h:outputText value="Servidor: " />
			<h:outputText
				value="#{dependenteController.dependente.servidor.siape} - #{dependenteController.dependente.servidor.nome}" />
		</h:panelGrid>
		<h:panelGrid columns="4">
			<h:outputText value="Nome do Dependente: ">
			</h:outputText>
			<h:outputText value="#{dependenteController.dependente.nome}"></h:outputText>
			<h:outputText value="Sexo do Dependente: " />
			<h:outputText value="FEMININO"
				rendered="#{dependenteController.dependente.sexo == 'F'}"></h:outputText>
			<h:outputText value="MASCULINO"
				rendered="#{dependenteController.dependente.sexo == 'M'}"></h:outputText>
			<h:outputText value="Data de Nascimento do Dependente: " />
			<h:outputText
				value="#{dependenteController.dependente.dataNascimento}">
				<f:convertDateTime pattern="dd/MM/yyyy" />
			</h:outputText>
			<h:outputText value="CPF do Dependente: "
				rendered="#{dependenteController.dependente.cpf != ''}" />
			<h:outputText value="#{dependenteController.dependente.cpf}"
				rendered="#{dependenteController.dependente.cpf != ''}" />
			<h:outputText value="RG do Dependente: "
				rendered="#{dependenteController.dependente.rg != ''}" />
			<h:outputText value="#{dependenteController.dependente.rg}"
				rendered="#{dependenteController.dependente.rg != ''}"></h:outputText>
			<h:outputText value="UF do RG do Dependente: "
				rendered="#{dependenteController.dependente.rgUf.uf != null}" />
			<h:outputText value="#{dependenteController.dependente.rgUf.uf}"
				rendered="#{dependenteController.dependente.rgUf.uf != null}"></h:outputText>
			<h:outputText value="Orgão Emissor do RG do Dependente: "
				rendered="#{dependenteController.dependente.rgOrgao != ''}" />
			<h:outputText value="#{dependenteController.dependente.rgOrgao}"
				rendered="#{dependenteController.dependente.rgOrgao != ''}" />
			<h:outputText value="Data de Expedição do RG do Dependente: "
				rendered="#{dependenteController.dependente.rgDataExpedicao.date!=null}" />
			<h:outputText
				rendered="#{dependenteController.dependente.rgDataExpedicao.date!=null}"
				value="#{dependenteController.dependente.rgDataExpedicao}">
				<f:convertDateTime pattern="dd/MM/yyyy" />
			</h:outputText>
			<h:outputText value="Grau Parentesco: " />
			<h:outputText
				value="#{dependenteController.dependente.grauParentesco.descricao}"></h:outputText>
			<h:outputText value="Imposto de Renda: " />
			<h:outputText value="SIM"
				rendered="#{dependenteController.dependente.indIr}"></h:outputText>
			<h:outputText value="NÃO"
				rendered="#{!dependenteController.dependente.indIr}"></h:outputText>
			<h:outputText value="Necessidade Especiais: " />
			<h:outputText value="SIM"
				rendered="#{dependenteController.dependente.indNecessidadesEspeciais}"></h:outputText>
			<h:outputText value="NÃO"
				rendered="#{!dependenteController.dependente.indNecessidadesEspeciais}"></h:outputText>
			<h:outputText value="Estudante Universitário? " />
			<h:outputText value="SIM"
				rendered="#{dependenteController.dependente.indEstudante}"></h:outputText>
			<h:outputText value="NÃO"
				rendered="#{!dependenteController.dependente.indEstudante}"></h:outputText>
			<h:outputText value="Estabelecimento de Ensino: "
				rendered="#{dependenteController.dependente.indEstudante}">
			</h:outputText>
			<h:outputText value="#{dependenteController.dependente.faculdade}"
				rendered="#{dependenteController.dependente.indEstudante}"></h:outputText>
			<h:outputText value="Curso: "
				rendered="#{dependenteController.dependente.indEstudante}">
			</h:outputText>
			<h:outputText id="curso"
				rendered="#{dependenteController.dependente.indEstudante}"
				value="#{dependenteController.dependente.curso}"></h:outputText>
			<h:outputText value="Previsão de Formação: "
				rendered="#{dependenteController.dependente.indEstudante}" />
			<h:outputText id="dataFormacao"
				rendered="#{dependenteController.dependente.indEstudante}"
				value="#{dependenteController.dependente.dataFormacao}">
				<f:convertDateTime pattern="dd/MM/yyyy" />
			</h:outputText>
			<h:outputText value="Ativo: " />
			<h:outputText rendered="#{dependenteController.dependente.indAtivo}"
				value="SIM">
			</h:outputText>
			<h:outputText rendered="#{!dependenteController.dependente.indAtivo}"
				value="NÃO">
			</h:outputText>
		</h:panelGrid>
		<center><h:panelGrid columns="2" style="text-align: center;">
				<h:outputText value="Justificativa: " />
				<h:inputTextarea
					disabled="#{dependenteController.dependente.statusSolicitacao.codigo > 2}"
					value="#{dependenteController.dependente.justificativa}" cols="50"
					rows="5"></h:inputTextarea>
		</h:panelGrid> <h:panelGrid columns="2" id="botoes" style="text-align: center;">
			<a4j:commandButton value="Deferir" id="deferir"
				reRender="form, listaDependentes, painel, confirmPanel"
				ajaxSingle="true"
				disabled="#{dependenteController.dependente.statusSolicitacao.codigo > 2}"
				onclick="Richfaces.showModalPanel('confirmPanel')" />
			<a4j:commandButton value="Indeferir" id="indeferir"
				reRender="form, listaDependentes,painel, confirmPanel02"
				ajaxSingle="true"
				disabled="#{dependenteController.dependente.statusSolicitacao.codigo > 2}"
				onclick="Richfaces.showModalPanel('confirmPanel02')" />
		</h:panelGrid></center>
	</rich:modalPanel></center>

	<center><rich:modalPanel id="confirmPanel" autosized="true"
		width="200">
		<f:facet name="header">
			<h:outputText value="Confirma este deferimento?"
				style="padding-right:15px;" />
		</f:facet>
		<h:form>
			<table width="100%">
				<tbody>
					<tr>
						<td align="center" width="50%"><a4j:commandButton value="Sim"
							ajaxSingle="true" action="#{dependenteController.deferir}"
							oncomplete="#{rich:component('confirmPanel')}.hide();"
							reRender="listaDependentes, botoes" /></td>
						<td align="center" width="50%"><a4j:commandButton value="Não"
							onclick="#{rich:component('confirmPanel')}.hide();return false;" />
						</td>
					</tr>
				</tbody>
			</table>
		</h:form>
	</rich:modalPanel> <rich:modalPanel id="confirmPanel02" autosized="true" width="200">
		<f:facet name="header">
			<h:outputText value="Confirma este indeferimento?"
				style="padding-right:15px;" />
		</f:facet>
		<h:form>
			<table width="100%">
				<tbody>
					<tr>
						<td align="center" width="50%"><a4j:commandButton value="Sim"
							ajaxSingle="true" action="#{dependenteController.indeferir}"
							oncomplete="#{rich:component('confirmPanel02')}.hide();"
							reRender="listaDependentes, botoes" /></td>
						<td align="center" width="50%"><a4j:commandButton value="Não"
							onclick="#{rich:component('confirmPanel02')}.hide();return false;" />
						</td>
					</tr>
				</tbody>
			</table>
		</h:form>
	</rich:modalPanel></center>
</f:view>
</body>
</html>