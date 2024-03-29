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
	<center><a4j:form id="form">
		<rich:panel>
			<font size="2"><b>LISTAR SOLICITA��ES</b></font>
			<h:panelGrid columns="11">
				<h:outputText value="Siape Solicitante: ">
				</h:outputText>
				<h:inputText
					value="#{solicitacaoController.solicitacao.solicitante.siape}"
					size="8" maxlength="7" onkeyup="mascara(this, soNumeros);">
				</h:inputText>
				
				<h:outputText value="Siape Atendente: ">
				</h:outputText>
				<h:inputText
					value="#{solicitacaoController.solicitacao.atendente}"
					size="8" maxlength="7" onkeyup="mascara(this, soNumeros);">
				</h:inputText>

				<h:outputText value="Tipo Solicita��o: " />
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
						style="width:80px" inputSize="12"/>
					<h:outputText value="a" />
					<rich:calendar value="#{solicitacaoController.dataAberturaFinal}"
						locale="" popup="true" datePattern="dd/MM/yyyy"
						showApplyButton="#" cellWidth="12px" cellHeight="12px"
						style="width:80px" inputSize="12"/>
				</h:panelGrid>

				<a4j:commandButton value="Pesquisar"
					action="#{solicitacaoController.pesquisarSolicitacoes}"
					reRender="listaSolicitacoes, form" type="submit" />
			</h:panelGrid>

			<rich:messages layout="list" errorLabelClass="errorLabel"
				style="top:auto;" infoLabelClass="infoLabel">
				<f:facet name="infoMarker">
					<h:graphicImage value="../images/passed.gif" />
				</f:facet>
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>

			<rich:dataTable id="listaSolicitacoes"
				value="#{solicitacaoController.solicitacoes}" var="list"
				width="1190px" columnClasses="center" rows="15" reRender="ds">
				<rich:column width="25px" sortBy="#{list.solicitante.siape}">
					<f:facet name="header">
						<h:outputText value="Solicitante" />
					</f:facet>
					<h:outputText value="#{list.solicitante.siape}" />
				</rich:column>

				<rich:column width="430px" sortBy="#{list.solicitante.nome}">
					<f:facet name="header">
						<h:outputText value="Nome do Solicitante" />
					</f:facet>
					<h:outputText value="#{list.solicitante.nome}" />
				</rich:column>

				<rich:column width="250px" sortBy="#{list.dataAbertura}">
					<f:facet name="header">
						<h:outputText value="Data Abertura" />
					</f:facet>
					<h:outputText value="#{list.dataAbertura}">
						<f:convertDateTime locale="pt_BR" pattern="dd/MM/yyyy - HH:mm:ss" />
					</h:outputText>
				</rich:column>

				<rich:column width="250px" sortBy="#{list.dataAtendimento}">
					<f:facet name="header">
						<h:outputText value="Data Atendimento" />
					</f:facet>
					<h:outputText value="#{list.dataAtendimento}"
						rendered="#{list.dataAtendimento != null}">
						<f:convertDateTime locale="pt_BR" pattern="dd/MM/yyyy - HH:mm:ss" />
					</h:outputText>
					<h:outputText value="-" rendered="#{list.dataAtendimento == null}" />
				</rich:column>

				<rich:column width="250px" sortBy="#{list.dataFechamento}">
					<f:facet name="header">
						<h:outputText value="Data Fechamento" />
					</f:facet>
					<h:outputText value="#{list.dataFechamento}"
						rendered="#{list.dataFechamento != null}">
						<f:convertDateTime locale="pt_BR" pattern="dd/MM/yyyy - HH:mm:ss" />
					</h:outputText>
					<h:outputText value="-" rendered="#{list.dataFechamento == null}" />
				</rich:column>
				
				<rich:column width="280px" sortBy="#{list.atendenteLogado}">
					<f:facet name="header">
						<h:outputText value="Atendente" />
					</f:facet>
					<h:outputText value="#{list.atendenteLogado.nome}"
						rendered="#{list.atendenteLogado.nome!=null}">
					</h:outputText>
					<h:outputText value="-"
						rendered="#{list.atendenteLogado.nome==null}"></h:outputText>
				</rich:column>

				<rich:column width="400px"
					sortBy="#{list.tipoSolicitacao.descricao}">
					<f:facet name="header">
						<h:outputText value="Tipo Solicita��o" />
					</f:facet>
					<h:outputText value="#{list.tipoSolicitacao.descricao}" />
				</rich:column>

				<rich:column width="240px"
					sortBy="#{list.statusSolicitacao.descricao}">
					<f:facet name="header">
						<h:outputText value="Status" />
					</f:facet>
					<h:outputText value="#{list.statusSolicitacao.descricao}" />
				</rich:column>


				<rich:column width="30px">
					<f:facet name="header">
						<h:outputText value="Visualizar" />
					</f:facet>
					<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 1}"
						action="#{solicitacaoController.carregarSolicitacao}"
						reRender="listaSolicitacoes" ajaxSingle="true">
						<h:graphicImage value="../images/encaminhado.png" style="border:0"
							width="20" height="18" id="encaminhado" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{solicitacaoController.codigoSolicitacao}" />
						<f:setPropertyActionListener
							value="#{list.tipoSolicitacao.codigo}"
							target="#{solicitacaoController.tipoSolicitacao}" />
					</a4j:commandLink>
					<a4j:commandLink rendered="#{list.statusSolicitacao.codigo == 2}"
						action="#"
						reRender="listaSolicitacoes" ajaxSingle="true">
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
					<rich:toolTip for="encaminhado" value="Encaminhado" />
					<rich:toolTip for="emAnalise" value="Voc� n�o pode abrir uma solicita��o que est� em An�lise!" />
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