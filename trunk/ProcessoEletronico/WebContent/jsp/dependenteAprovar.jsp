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
			<rich:messages id="messages" layout="list"
				errorLabelClass="errorLabel" style="top:auto;"
				infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<font size="2"><b>APROVAR DEPENDENTE</b></font>
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
				<h:outputText
					rendered="#{!dependenteController.dependente.indAtivo}" value="NÃO">
				</h:outputText>
			</h:panelGrid>
			<h:panelGrid columns="1" id="documentos">
				<a4j:commandButton value="Ver Documentos" action="#" />
			</h:panelGrid>
			<h:panelGrid columns="2" style="text-align: center;"
				id="justificativa">
				<h:outputText value="Justificativa: " />
				<h:inputTextarea
					disabled="#{dependenteController.dependente.statusSolicitacao.codigo > 2}"
					value="#{dependenteController.dependente.justificativa}" cols="50"
					rows="5"></h:inputTextarea>
			</h:panelGrid>
			<h:panelGrid columns="2" id="botoes">
				<a4j:commandButton value="Deferir" reRender="confirmPanel"
					disabled="#{dependenteController.dependente.statusSolicitacao.codigo != 2}"
					oncomplete="#{rich:component('confirmPanel')}.show()" />
				<a4j:commandButton value="Indeferir" reRender="confirmPanel02"
					disabled="#{dependenteController.dependente.statusSolicitacao.codigo != 2}"
					oncomplete="#{rich:component('confirmPanel02')}.show()" />
			</h:panelGrid>
			<h:panelGrid columns="2" id="voltar">
				<a4j:commandButton value="Voltar"
					action="#{dependenteController.retornarUltimaPesquisa}" />
			</h:panelGrid>
		</rich:panel></center>

		<rich:modalPanel id="confirmPanel" autosized="true" width="200">
			<f:facet name="header">
				<h:outputText value="Confirma este deferimento?"
					style="padding-right:15px;" />
			</f:facet>
			<h:form>
				<table width="100%">
					<tbody>
						<tr>
							<td align="center" width="50%"><a4j:commandButton
								value="Sim" ajaxSingle="true"
								action="#{dependenteController.deferir}"
								oncomplete="#{rich:component('confirmPanel')}.hide();"
								reRender="justificativa, messages, botoes, voltar" /></td>
							<td align="center" width="50%"><a4j:commandButton
								value="Não"
								onclick="#{rich:component('confirmPanel')}.hide();return false;" />
							</td>
						</tr>
					</tbody>
				</table>
			</h:form>
		</rich:modalPanel>
		<rich:modalPanel id="confirmPanel02" autosized="true" width="200">
			<f:facet name="header">
				<h:outputText value="Confirma este indeferimento?"
					style="padding-right:15px;" />
			</f:facet>
			<h:form>
				<table width="100%">
					<tbody>
						<tr>
							<td align="center" width="50%"><a4j:commandButton
								value="Sim" ajaxSingle="true"
								action="#{dependenteController.indeferir}"
								oncomplete="#{rich:component('confirmPanel02')}.hide();"
								reRender="justificativa, messages, botoes, voltar" /></td>
							<td align="center" width="50%"><a4j:commandButton
								value="Não"
								onclick="#{rich:component('confirmPanel02')}.hide();return false;" />
							</td>
						</tr>
					</tbody>
				</table>
			</h:form>
		</rich:modalPanel>
	</a4j:form>
</f:view>
</body>
</html>