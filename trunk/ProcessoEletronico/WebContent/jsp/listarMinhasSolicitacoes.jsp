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
			<rich:messages layout="list">
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<rich:dataTable id="listarSolicitacoes"
				value="#{solicitacaoController.minhasSolicitacoes}" var="list"
				width="1160px" columnClasses="center" rows="15" reRender="ds">


				<rich:column width="280px" sortBy="#{list.dataAbertura}">
					<f:facet name="header">
						<h:outputText value="Data Abertura" />
					</f:facet>
					<h:outputText value="#{list.dataAbertura}">
						<f:convertDateTime pattern="dd/MM/yyyy - HH:mm:ss" />
					</h:outputText>
				</rich:column>

				<rich:column width="280px" sortBy="#{list.dataAtendimento}">
					<f:facet name="header">
						<h:outputText value="Data Atendimento" />
					</f:facet>
					<h:outputText value="#{list.dataAtendimento}"
						rendered="#{list.dataAtendimento!=null}">
						<f:convertDateTime pattern="dd/MM/yyyy - HH:mm:ss" />
					</h:outputText>
					<h:outputText value="-" rendered="#{list.dataAtendimento==null}">
					</h:outputText>
				</rich:column>

				<rich:column width="280px" sortBy="#{list.atendenteLogado}">
					<f:facet name="header">
						<h:outputText value="Atendente" />
					</f:facet>
					<h:outputText value="#{list.atendenteLogado.nome}" rendered="#{list.atendenteLogado.nome!=null}">
					</h:outputText>
					<h:outputText value="-"
						rendered="#{list.atendenteLogado.nome==null}"></h:outputText>
				</rich:column>

				<rich:column width="250px" sortBy="#{list.dataFechamento}">
					<f:facet name="header">
						<h:outputText value="Data Fechamento" />
					</f:facet>
					<h:outputText value="#{list.dataFechamento}"
						rendered="#{list.dataFechamento!=null}">
						<f:convertDateTime pattern="dd/MM/yyyy - HH:mm:ss" />
					</h:outputText>
					<h:outputText value="-" rendered="#{list.dataFechamento==null}">
					</h:outputText>
				</rich:column>

				<rich:column width="350px"
					sortBy="#{list.tipoSolicitacao.descricao}"
					filterBy="#{list.tipoSolicitacao.descricao}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Tipo Solicitação" />
					</f:facet>
					<h:outputText value="#{list.tipoSolicitacao.descricao}" />
				</rich:column>

				<rich:column width="135px"
					sortBy="#{list.statusSolicitacao.descricao}"
					filterBy="#{list.statusSolicitacao.descricao}"
					filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Status Solicitação" />
					</f:facet>
					<h:outputText value="#{list.statusSolicitacao.descricao}" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Visualizar" />
					</f:facet>
					<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 1}"
						action="#" reRender="listaSolicitacoes" ajaxSingle="true">
						<h:graphicImage value="../images/encaminhado.png" style="border:0"
							width="20" height="18" id="encaminhado" />
					</a4j:commandLink>
					<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 2}"
						action="#" reRender="listaSolicitacoes" ajaxSingle="true">
						<h:graphicImage value="../images/analize.gif" style="border:0"
							width="20" height="18" id="emAnalise" />
					</a4j:commandLink>
					<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 3}"
						action="#{solicitacaoController.carregarSolicitacao}"
						reRender="listaSolicitacoes" ajaxSingle="true">
						<h:graphicImage value="../images/deferido.gif" style="border:0"
							width="20" height="18" id="deferido" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{solicitacaoController.codigoSolicitacao}" />
						<f:setPropertyActionListener
							value="#{list.tipoSolicitacao.codigo}"
							target="#{solicitacaoController.tipoSolicitacao}" />
					</a4j:commandLink>
					<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 4}"
						action="#{solicitacaoController.carregarSolicitacao}"
						reRender="listaSolicitacoes" ajaxSingle="true">
						<h:graphicImage value="../images/indeferido.gif" style="border:0"
							width="20" height="18" id="indeferido" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{solicitacaoController.codigoSolicitacao}" />
						<f:setPropertyActionListener
							value="#{list.tipoSolicitacao.codigo}"
							target="#{solicitacaoController.tipoSolicitacao}" />
					</a4j:commandLink>
					<rich:toolTip for="encaminhado"
						value="Você somente pode ver solicitações Deferidas ou Indeferidas!" />
					<rich:toolTip for="emAnalise"
						value="Você somente pode ver solicitações Deferidas ou Indeferidas!" />
					<rich:toolTip for="deferido" value="Deferido" />
					<rich:toolTip for="indeferido" value="Indeferido" />
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