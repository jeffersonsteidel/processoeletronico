<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instituto Federal do Paraná</title>
</head>
<body>
<f:view>
	<jsp:directive.include file="menus.jsp" />
	<center><a4j:form id="form">
		<rich:panel>
			<h:panelGrid columns="11">
				<h:outputText value="Siape do Solicitante: ">
				</h:outputText>
				<h:inputText
					value="#{solicitacaoController.solicitacao.solicitante.siape}"
					size="10" maxlength="7" onkeyup="mascara(this, soNumeros);">
				</h:inputText>
					
				<h:outputText value="Tipo Solicitação: " />
				<h:selectOneMenu
					value="#{solicitacaoController.solicitacao.tipoSolicitacao.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{solicitacaoController.tiposSolicitacoes}" />
				</h:selectOneMenu>

				<h:outputText value="Status: " />
				<h:selectOneMenu
					value="#{solicitacaoController.solicitacao.statusSolicitacao.codigo}">
					<f:selectItem itemLabel="SELECIONE" itemValue="" />
					<f:selectItems value="#{solicitacaoController.statusSolicitacoes}" />
				</h:selectOneMenu>

				<h:outputText value="Data de Abertura Entre: " />
				<h:panelGrid columns="3">
					<rich:calendar value="#{solicitacaoController.dataAberturaInicial}"
						locale="" popup="true" datePattern="dd/MM/yyyy"
						showApplyButton="#" cellWidth="12px" cellHeight="12px"
						style="width:80px" />
					<h:outputText value="a" />
					<rich:calendar value="#{solicitacaoController.dataAberturaFinal}"
						locale="" popup="true" datePattern="dd/MM/yyyy"
						showApplyButton="#" cellWidth="12px" cellHeight="12px"
						style="width:80px" />
				</h:panelGrid>

				<a4j:commandButton value="Pesquisar"
					action="#{solicitacaoController.pesquisarSolicitacoes}"
					reRender="listaSolicitacoes" type="submit" />
			</h:panelGrid>

			<rich:messages layout="list">
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<rich:dataTable id="listaSolicitacoes"
				value="#{solicitacaoController.solicitacoes}" var="list"
				width="1150px" columnClasses="center" rows="15" reRender="ds">
				<rich:column width="40px" sortBy="#{list.solicitante.siape}">
					<f:facet name="header">
						<h:outputText value="Siape do Solicitante" />
					</f:facet>
					<h:outputText value="#{list.solicitante.siape}" />
				</rich:column>

				<rich:column width="430px" sortBy="#{list.solicitante.nome}">
					<f:facet name="header">
						<h:outputText value="Nome do Solicitante" />
					</f:facet>
					<h:outputText value="#{list.solicitante.nome}" />
				</rich:column>

				<rich:column width="350px" sortBy="#{list.dataAbertura}">
					<f:facet name="header">
						<h:outputText value="Data Abertura" />
					</f:facet>
					<h:outputText value="#{list.dataAbertura}">
						<f:convertDateTime locale="pt_BR" pattern="dd/MM/yyyy - HH:mm:ss" />
					</h:outputText>
				</rich:column>
				
				<rich:column width="350px" sortBy="#{list.dataAtentimento}">
					<f:facet name="header">
						<h:outputText value="Data Atendimento" />
					</f:facet>
					<h:outputText value="#{list.dataAtendimento}" rendered="#{list.dataAtendimento != null}">
						<f:convertDateTime locale="pt_BR" pattern="dd/MM/yyyy - HH:mm:ss" />
					</h:outputText>
					<h:outputText value="-" rendered="#{list.dataAtendimento == null}"/>
				</rich:column>
				
				<rich:column width="350px" sortBy="#{list.dataFechamento}">
					<f:facet name="header">
						<h:outputText value="Data Fechamento" />
					</f:facet>
					<h:outputText value="#{list.dataFechamento}" rendered="#{list.dataFechamento != null}">
						<f:convertDateTime locale="pt_BR" pattern="dd/MM/yyyy - HH:mm:ss" />
					</h:outputText>
					<h:outputText value="-" rendered="#{list.dataFechamento == null}"/>
				</rich:column>

				<rich:column width="400px"
					sortBy="#{list.tipoSolicitacao.descricao}">
					<f:facet name="header">
						<h:outputText value="Tipo Solicitação" />
					</f:facet>
					<h:outputText value="#{list.tipoSolicitacao.descricao}" />
				</rich:column>

				<rich:column width="280px"
					sortBy="#{list.statusSolicitacao.descricao}">
					<f:facet name="header">
						<h:outputText value="Status" />
					</f:facet>
					<h:outputText value="#{list.statusSolicitacao.descricao}" />
				</rich:column>


				<rich:column>
					<f:facet name="header">
						<h:outputText value="Editar" />
					</f:facet>
					<a4j:commandLink action="#" reRender="#" ajaxSingle="true">
						<h:graphicImage value="../images/edit.gif" style="border:0"
							width="20" height="18" id="editar" />
						<f:setPropertyActionListener value="#" target="#" />
					</a4j:commandLink>
					<rich:toolTip for="editar" value="Editar" />
				</rich:column>



				<f:facet name="footer">
					<rich:datascroller id="ds"></rich:datascroller>
				</f:facet>
			</rich:dataTable>
		</rich:panel>
	</a4j:form></center>
</f:view>
</body>
</html>