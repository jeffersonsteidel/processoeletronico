<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instituto Federal do Paran�</title>
</head>
<body>
<f:view>
	<jsp:directive.include file="menus.jsp"/>
	<center><a4j:form id="form">
		<rich:panel>
			<font size="2"><b>LISTAR SERVIDORES</b></font>
			<rich:messages layout="list">
				<f:facet name="errorMarker">
					<h:graphicImage value="../images/error.gif" />
				</f:facet>
			</rich:messages>
			<rich:dataTable id="listaServidores"
				value="#{servidorController.servidores}" var="list" width="1160px"
				columnClasses="center" rows="15" reRender="ds">
				<rich:column width="50px" sortBy="#{list.siape}"
					filterBy="#{list.siape}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Siape" />
					</f:facet>
					<h:outputText value="#{list.siape}" />
				</rich:column>

				<rich:column width="435px" sortBy="#{list.nome}"
					filterBy="#{list.nome}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{list.nome}" />
				</rich:column>

				<rich:column width="280px" sortBy="#{list.lotacao.descricao}"
					filterBy="#{list.lotacao.descricao}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Lota��o" />
					</f:facet>
					<h:outputText value="#{list.lotacao.descricao}" />
				</rich:column>

				<rich:column width="280px" sortBy="#{list.documento.cpf}"
					filterBy="#{list.documento.cpf}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="CPF" />
					</f:facet>
					<h:outputText value="#{list.documento.cpf}" />
				</rich:column>
				
				<rich:column width="280px" sortBy="#{list.cargo.descricao}"
					filterBy="#{list.cargo.descricao}" filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Cargo" />
					</f:facet>
					<h:outputText value="#{list.cargo.descricao}" />
				</rich:column>
				

				<rich:column width="250px"
					sortBy="#{list.situacaoFuncional.descricao}"
					filterBy="#{list.situacaoFuncional.descricao}"
					filterEvent="onkeyup">
					<f:facet name="header">
						<h:outputText value="Situa��o Funcional" />
					</f:facet>
					<h:outputText value="#{list.situacaoFuncional.descricao}" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Editar" />
					</f:facet>
					<a4j:commandLink action="#{servidorController.carregar}"
						reRender="listarServidores" ajaxSingle="true">
						<h:graphicImage value="../images/edit.gif" style="border:0"
							width="20" height="18" id="editar" />
						<f:setPropertyActionListener value="#{list.codigo}"
							target="#{servidorController.servidor.codigo}" />
					</a4j:commandLink>
					<rich:toolTip for="editar" value="Editar" />
				</rich:column>
				
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Ativo" />
					</f:facet>
						<h:graphicImage id="ativo" value="../images/ativar.gif" style="border:0"
							width="20" height="18" rendered="#{list.dataSaida == null}"/>
						<h:graphicImage id="inativo" value="../images/desativar.gif" style="border:0"
							width="20" height="18" rendered="#{list.dataSaida != null}"/>	
						<rich:toolTip for="ativo" value="Ativo" />
						<rich:toolTip for="inativo" value="Inativo" />	
				</rich:column>
				
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Validado" />
					</f:facet>
						<h:graphicImage id="deferido" value="../images/deferido.gif" style="border:0"
							width="20" height="18" rendered="#{list.dadosValidados}"/>
						<h:graphicImage id="indeferido" value="../images/indeferido.gif" style="border:0"
							width="20" height="18" rendered="#{!list.dadosValidados}"/>	
						<rich:toolTip for="deferido" value="Validado" />
						<rich:toolTip for="indeferido" value="N�o Validado" />	
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