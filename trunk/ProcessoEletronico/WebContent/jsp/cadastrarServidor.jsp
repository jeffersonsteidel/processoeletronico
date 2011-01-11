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
			<h:panelGrid columns="1" rendered="#{servidorController.servidor.codigo == null}">
				<font size="2"><b>CADASTRAR SERVIDOR</b></font>
			</h:panelGrid>
			<h:panelGrid columns="1" rendered="#{servidorController.servidor.codigo != 0 && servidorController.servidor.codigo != null}">
				<font size="2"><b>ATUALIZAR DADOS</b></font>
			</h:panelGrid>
			
			<rich:tabPanel switchType="client" width="750" height="120">
				<rich:tab label="Dados Pessoais">
					<h:panelGrid columns="4">
						<h:outputText value="Nome: " />
						<h:inputText value="#{servidorController.servidor.nome}" size="50"
							maxlength="100" required="true"
							requiredMessage="Campo Nome é obrigatório!"></h:inputText>
						<h:outputText value="Sexo: " />
						<h:selectOneMenu value="#{servidorController.servidor.sexo}"
							required="true" requiredMessage="Campo Sexo é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItem itemLabel="FEMININO" itemValue="F" />
							<f:selectItem itemLabel="MASCULINO" itemValue="M" />
							<a4j:support event="onchange"
								action="#{servidorController.isFeminino}" ajaxSingle="true"
								reRender="certificadoMilitar, certificadoMilitarOrgao, certificadoMilitarSerio"></a4j:support>
						</h:selectOneMenu>
						<h:outputText value="Data de Nascimento: " />
						<rich:calendar
							value="#{servidorController.servidor.dataNascimento}" locale=""
							popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
							cellWidth="12px" cellHeight="12px" style="width:80px"
							required="true" inputSize="12"
							requiredMessage="Campo Data de Nascimento é obrigatório!" />
						<h:outputText value="Grupo Sanguíneo: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.grupoSanguineo.codigo}"
							required="true"
							requiredMessage="Campo Grupo Sanguíneo é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.gruposSanguineos}" />
						</h:selectOneMenu>
						<h:outputText value="Nome da Mãe: " />
						<h:inputText value="#{servidorController.servidor.nomeMae}"
							size="40" maxlength="100" required="true"
							requiredMessage="Campo Nome da Mãe é obrigatório!"></h:inputText>
						<h:outputText value="Nome do Pai: " />
						<h:inputText value="#{servidorController.servidor.nomePai}"
							size="40" maxlength="100"></h:inputText>
						<h:outputText value="Estado de Nascimento: " />
						<h:selectOneMenu id="estadoNascimentoServidor"
							value="#{servidorController.servidor.estadoNascimento.codigo}"
							required="true"
							disabled="#{!servidorController.servidorBrasileiro}"
							requiredMessage="Campo Estado de Nascimento é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.estados}" />
							<a4j:support event="onchange"
								action="#{servidorController.listarCidadesNascimentoServidor}"
								ajaxSingle="true" reRender="cidadeNascimentoServidor"></a4j:support>
						</h:selectOneMenu>
						<h:outputText value="Cidade de Nascimento: " />
						<h:selectOneMenu id="cidadeNascimentoServidor"
							value="#{servidorController.servidor.cidadeNascimento}"
							required="true"
							disabled="#{!servidorController.servidorBrasileiro}"
							requiredMessage="Campo Cidade de Nascimento é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.cidadesNascimento}" />
						</h:selectOneMenu>
						<h:outputText value="Estado Civil: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.estadoCivil.codigo}"
							required="true"
							requiredMessage="Campo Estado Civil é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.estadosCivis}" />
						</h:selectOneMenu>

						<h:outputText value="Cor da Pele: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.corPele.codigo}"
							required="true" requiredMessage="Campo Cor Pele é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.coresPeles}" />
						</h:selectOneMenu>

						<h:outputText value="Estrangeiro: " />
						<h:selectBooleanCheckbox id="estrangeiro"
							title="Marcar esta opção caso seja imigrante!"
							value="#{servidorController.servidor.indEstrangeiro}">
							<a4j:support event="onchange"
								action="#{servidorController.isEstrangeiro}" ajaxSingle="true"
								reRender="data, dataCampo, pais, paisCampo, estadoNascimentoServidor, cidadeNascimentoServidor"></a4j:support>
						</h:selectBooleanCheckbox>


						<%-- 
					<h:outputText id="data" value="Data de Chegada no País: " />
					<rich:calendar id="dataCampo" value="" locale="" popup="true"
						disabled="#{!servidorController.servidorEstrangeiro}"
						datePattern="dd/MM/yyyy" showApplyButton="#" cellWidth="12px"
						cellHeight="12px" style="width:80px" required="true"
						inputSize="12" requiredMessage="Data de Chegada no País!" />
--%>

						<h:outputText id="pais" value="País de Origem: " />
						<h:selectOneMenu id="paisCampo"
							value="#{servidorController.servidor.pais.codigo}"
							required="true"
							disabled="#{!servidorController.servidorEstrangeiro}"
							requiredMessage="Campo País de Origem é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.paises}" />
						</h:selectOneMenu>
					</h:panelGrid>
				</rich:tab>

				<rich:tab label="Dados Funcionais">
					<h:panelGrid columns="4">
						<h:outputText value="SIAPE: " />
						<h:inputText value="#{servidorController.servidor.siape}"
							size="10" maxlength="7" required="true"
							requiredMessage="Campo SIAPE é obrigatório!"
							onkeypress="mascara(this,soNumeros);"></h:inputText>
						<h:outputText value="Id Única: " />
						<h:inputText
							title="A Id Única pode ser encontrada no contra-cheque!"
							value="#{servidorController.servidor.identificacaoUnica}"
							size="10" maxlength="10" required="true"
							requiredMessage="Campo Id Única é obrigatório!"
							onkeypress="mascara(this,idUnica);"
							validatorMessage="O campo Id Única deve ter 10 caracteres">
							<f:validateLength minimum="10" />
						</h:inputText>
							
						<h:outputText value="Data de Admissão no IFPR: " />
						<rich:calendar value="#{servidorController.servidor.dataAdmissao}"
							locale="" popup="true" datePattern="dd/MM/yyyy"
							showApplyButton="#" cellWidth="12px" cellHeight="12px"
							style="width:80px" required="true" inputSize="12"
							requiredMessage="Campo Data de Admissão no Órgão é obrigatório!" />

						<h:outputText value="Data de Admissão no Serviço Público: " />
						<rich:calendar
							value="#{servidorController.servidor.dataAdmServicoPublico}"
							locale="" popup="true" datePattern="dd/MM/yyyy"
							showApplyButton="#" cellWidth="12px" cellHeight="12px"
							style="width:80px" required="true" inputSize="12"
							requiredMessage="Campo Data de Admissão no Serviço Público é obrigatório!" />

						<h:outputText value="Lotação: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.lotacao.codigo}"
							required="true" requiredMessage="Campo Lotação é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.lotacoes}" />
						</h:selectOneMenu>

						<h:outputText value="Ramal: " />
						<h:inputText value="#{servidorController.servidor.ramal}" size="8"
							maxlength="4" required="true"
							requiredMessage="Campo Ramal é obrigatório!"
							onkeypress="mascara(this, soNumeros);"></h:inputText>

						<h:outputText value="Cargo: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.cargo.codigo}"
							required="true" requiredMessage="Campo Cargo é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.cargos}" />
							<a4j:support event="onchange"
								action="#{servidorController.carregarClasse}" ajaxSingle="true"
								reRender="classe, padrao"></a4j:support>
						</h:selectOneMenu>

						<h:outputText value="Classe: " />
						<h:outputText id="classe"
							value="#{servidorController.servidor.cargo.classe.sigla}" />

						<h:outputText value="Padrão: " />
						<h:selectOneMenu id="padrao"
							disabled="#{servidorController.indEstagiario}"
							value="#{servidorController.servidor.padrao.codigo}"
							required="true" requiredMessage="Campo Padrão é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.padroes}" />
						</h:selectOneMenu>

						<h:outputText value="Regime de Trabalho: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.regimeTrabalho.codigo}"
							required="true"
							requiredMessage="Campo Regime de Trabalho é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.regimesTrabalhos}" />
						</h:selectOneMenu>

						<h:outputText value="Situação Funcional: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.situacaoFuncional.codigo}"
							required="true"
							requiredMessage="Campo Situação Funcional é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.situacoesFuncionais}" />
						</h:selectOneMenu>

						<h:outputText value="Data de Saída do Orgão: " rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}"/>
						<rich:calendar value="#{servidorController.servidor.dataSaida}"
							locale="" popup="true" datePattern="dd/MM/yyyy"
							rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}"
							showApplyButton="#" cellWidth="12px" cellHeight="12px"
							style="width:80px" inputSize="12" />
					</h:panelGrid>
				</rich:tab>

				<rich:tab label="Documentos">
					<h:panelGrid columns="4">
						<h:outputText value="CPF: " />
						<h:inputText value="#{servidorController.servidor.documento.cpf}"
							size="16" maxlength="14" required="true" id="cpf"
							requiredMessage="Campo CPF é obrigatório!"
							onkeypress="mascara(this,cpf);">
							<a4j:support event="onchange"
								action="#{servidorController.validarCPF}" ajaxSingle="true"
								reRender="cpf, confirmPanel, messages"></a4j:support>
						</h:inputText>
						<h:outputText value="RG: " />
						<h:inputText value="#{servidorController.servidor.documento.rg}"
							size="16" maxlength="13" required="true"
							requiredMessage="Campo RG é obrigatório!"></h:inputText>
						<h:outputText value="UF do RG: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.documento.rgUf}"
							required="true" requiredMessage="Campo UF do RG é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.ufs}" />
						</h:selectOneMenu>
						<h:outputText value="Orgão Emissor do RG: " />
						<h:inputText
							value="#{servidorController.servidor.documento.rgOrgaoEmissor}"
							size="16" maxlength="8" required="true"
							requiredMessage="Campo Orgão Emissor do RG obrigatório!"></h:inputText>
						<h:outputText value="Data de Expedição do RG: " />
						<rich:calendar
							value="#{servidorController.servidor.documento.rgDataExpedicao}"
							locale="" popup="true" datePattern="dd/MM/yyyy"
							showApplyButton="#" cellWidth="12px" cellHeight="12px"
							style="width:80px" required="true" inputSize="12"
							requiredMessage="Campo Data de Expedição do RG é obrigatório!" />
						<h:outputText value="Título de Eleitor: " />
						<h:inputText
							value="#{servidorController.servidor.documento.tituloEleitor}"
							size="16" maxlength="13" required="true"
							onkeypress="mascara(this,tituloEleitor);"
							validatorMessage="O campo Título de Eleitor deve ter 13 caracteres"
							requiredMessage="Campo Título de Eleitor é obrigatório!">
							<f:validateLength minimum="13" />
						</h:inputText>
						<h:outputText value="Título de Eleitor Zona: " />
						<h:inputText
							value="#{servidorController.servidor.documento.tituloZona}"
							size="10" maxlength="3" required="true"
							onkeypress="mascara(this,soNumeros);"
							requiredMessage="Campo Título de Eleitor Sessão é obrigatório!"></h:inputText>
						<h:outputText value="Título de Eleitor Sessão: " />
						<h:inputText
							value="#{servidorController.servidor.documento.tituloSecao}"
							size="10" maxlength="4" required="true"
							onkeypress="mascara(this,soNumeros);"
							requiredMessage="Campo Título de Eleitor Sessão é obrigatório!"></h:inputText>
						<h:outputText value="UF do Título de Eleitor: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.documento.tituloUf}"
							required="true"
							requiredMessage="Campo UF do Título de Eleitor é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.ufs}" />
						</h:selectOneMenu>
						<h:outputText value="Data de Emissão do Título de Eleitor: " />
						<rich:calendar
							value="#{servidorController.servidor.documento.tituloDataEmissao}"
							locale="" popup="true" datePattern="dd/MM/yyyy"
							showApplyButton="#" cellWidth="12px" cellHeight="12px"
							style="width:80px" required="true" inputSize="12"
							requiredMessage="Campo Data de Emissão do Título de Eleitor é obrigatório!" />
						<h:outputText value="Certificado Militar: " />
						<h:inputText disabled="#{servidorController.indFeminino}"
							id="certificadoMilitar"
							value="#{servidorController.servidor.documento.certificadoMilitar}"
							size="16" maxlength="6" onkeypress="mascara(this, soNumeros);"></h:inputText>
						<h:outputText value="Certificado Militar Orgão Emissor: " />
						<h:inputText disabled="#{servidorController.indFeminino}"
							id="certificadoMilitarOrgao"
							value="#{servidorController.servidor.documento.certificadoOrgaoEmissor}"
							size="16" maxlength="8"></h:inputText>
						<h:outputText value="Certificado Militar Série: " />
						<h:inputText disabled="#{servidorController.indFeminino}"
							id="certificadoMilitarSerio"
							value="#{servidorController.servidor.documento.certificadoSerie}"
							size="7" maxlength="1"></h:inputText>
						<h:outputText value="Carteira de Trabalho: " />
						<h:inputText
							value="#{servidorController.servidor.documento.carteiraTrabalho}"
							size="16" maxlength="7" required="true"
							requiredMessage="Campo Carteira de Trabalho é obrigatório!"></h:inputText>
						<h:outputText value="Carteira de Trabalho Série: " />
						<h:inputText
							value="#{servidorController.servidor.documento.carteiraSerie}"
							size="10" maxlength="5" required="true"
							requiredMessage="Campo Carteira de Trabalho Série é obrigatório!"></h:inputText>
						<h:outputText value="UF da Carteira de Trabalho: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.documento.carteiraUf}"
							required="true"
							requiredMessage="Campo UF da Carteira de Trabalho é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.ufs}" />
						</h:selectOneMenu>
						<h:outputText value="PIS/PASEP: " />
						<h:inputText value="#{servidorController.servidor.documento.pis}"
							size="16" maxlength="14" required="true"
							validatorMessage="O campo PIS/PASEP deve ter 14 caracteres!"
							onkeypress="mascara(this, pis);"
							requiredMessage="Campo PIS/PASEP é obrigatório!">
							<f:validateLength minimum="14" />
						</h:inputText>
						<h:outputText value="Data do 1º Emprego: " />
						<rich:calendar
							value="#{servidorController.servidor.documento.dataPrimeiroEmprego}"
							locale="" popup="true" datePattern="dd/MM/yyyy"
							showApplyButton="#" cellWidth="12px" cellHeight="12px"
							style="width:80px" inputSize="12" />
					</h:panelGrid>
				</rich:tab>

				<rich:tab label="Contato">
					<h:panelGrid columns="4">
						<h:outputText value="Endereço: " />
						<h:inputText value="#{servidorController.servidor.endereco.rua}"
							size="50" maxlength="120" required="true"
							requiredMessage="Campo Endereço é obrigatório!"></h:inputText>

						<h:outputText value="Número: " />
						<h:inputText
							value="#{servidorController.servidor.endereco.numero}" size="5"
							maxlength="7" required="true"
							requiredMessage="Campo Número é obrigatório!"></h:inputText>

						<h:outputText value="Bairro: " />
						<h:inputText
							value="#{servidorController.servidor.endereco.bairro}" size="30"
							maxlength="80" required="true"
							requiredMessage="Campo Bairro é obrigatório!"></h:inputText>

						<h:outputText value="Complemento: " />
						<h:inputText
							value="#{servidorController.servidor.endereco.complemento}"
							size="25" maxlength="25"></h:inputText>

						<h:outputText value="CEP: " />
						<h:inputText value="#{servidorController.servidor.endereco.cep}"
							size="20" maxlength="9" required="true"
							requiredMessage="Campo CEP é obrigatório!"
							validatorMessage="Campo CEP deve ter no mínimo 9 caracateres!"
							onkeypress="mascara(this,cep)">
							<f:validateLength minimum="9" />
						</h:inputText>

						<h:outputText value="Estado: " />
						<h:selectOneMenu id="estado"
							value="#{servidorController.servidor.endereco.cidade.estado.codigo}"
							required="true" requiredMessage="Campo Estado é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.estados}" />
							<a4j:support event="onchange"
								action="#{servidorController.listarCidadesContato}"
								ajaxSingle="true" reRender="cidade"></a4j:support>
						</h:selectOneMenu>

						<h:outputText value="Cidade: " />
						<h:selectOneMenu id="cidade"
							value="#{servidorController.servidor.endereco.cidade.codigo}"
							required="true" requiredMessage="Campo Cidade é obrigatório!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.cidades}" />
						</h:selectOneMenu>

						<h:outputText value="Telefone: " />
						<h:inputText value="#{servidorController.servidor.telefone}"
							size="16" maxlength="13" required="true"
							requiredMessage="Campo Telefone é obrigatório!"
							onkeypress="mascara(this,telefone);"
							validatorMessage="Campo Telefone deve ter no mínimo 13 caracteres!">
							<f:validateLength minimum="13" />
						</h:inputText>

						<h:outputText value="Celular: " />
						<h:inputText value="#{servidorController.servidor.celular}"
							size="16" maxlength="13" onkeypress="mascara(this,telefone);"
							validatorMessage="Campo Celular deve ter no mínimo 13 caracteres!">
							<f:validateLength minimum="13" />
						</h:inputText>

						<h:outputText value="E-mail: " />
						<h:inputText value="#{servidorController.servidor.email}"
							size="40" title="Colocar de preferencial o e-mail institucional!"
							maxlength="150"></h:inputText>
					</h:panelGrid>
				</rich:tab>

				<rich:tab label="Conta Bancária">
					<h:panelGrid columns="6">
						<h:outputText value="Banco: " />
						<h:selectOneMenu required="true"
							requiredMessage="Campo Banco é obrigatório!"
							value="#{servidorController.servidor.contaBancaria.banco.codigo}">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.bancos}" />
							<a4j:support event="onchange"
								action="#{servidorController.isPoupanca}" ajaxSingle="true"
								reRender="poupanca"></a4j:support>
						</h:selectOneMenu>
						<h:outputText value="Número da Conta: " />
						<h:inputText
							value="#{servidorController.servidor.contaBancaria.numeroConta}"
							size="15" maxlength="12" required="true"
							requiredMessage="Campo Número da Conta é obrigatório!"></h:inputText>
						<h:outputText value="Agência: " />
						<h:inputText
							value="#{servidorController.servidor.contaBancaria.agencia}"
							size="10" maxlength="8" required="true"
							requiredMessage="Campo Agência é obrigatório!"></h:inputText>

						<h:outputText value="Poupança:" />
						<h:selectBooleanCheckbox id="poupanca"
							title="A opção poupança é exclusiva de servidores que recebem pela Caixa Econômica Federal!"
							disabled="#{!servidorController.indPoupanca}"
							value="#{servidorController.servidor.contaBancaria.indPoupanca}">
						</h:selectBooleanCheckbox>
					</h:panelGrid>
				</rich:tab>

				<rich:tab label="SALVAR">
					<h:panelGrid columns="1">
						<center><a4j:commandButton value="Salvar"
							action="#{servidorController.salvar}" reRender="form"
							oncomplete="#{rich:component('confirmPanel')}.show()" /> <a4j:commandButton
							value="Aprovar"
							rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}"
							action="#{servidorController.aprovar}" reRender="form"
							oncomplete="#{rich:component('confirmPanel')}.show()" /></center>
						<h:panelGrid columns="2"
							rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}">
							<h:graphicImage value="../images/indeferido.gif" style="border:0"
								width="20" height="18"
								rendered="#{!servidorController.servidor.dadosValidados}" />
							<h:outputText
								rendered="#{!servidorController.servidor.dadosValidados}"
								value="Dados ainda não validados pela PROGEPE!"></h:outputText>
							<h:graphicImage value="../images/deferido.gif" style="border:0"
								width="20" height="18"
								rendered="#{servidorController.servidor.dadosValidados}" />
							<h:outputText
								rendered="#{servidorController.servidor.dadosValidados}"
								value="Dados validados pela PROGEPE!"></h:outputText>
						</h:panelGrid>
						<h:panelGrid columns="2">
							<h:outputText
								value="Data da última atualização realizada pelo servidor:"></h:outputText>
							<h:outputText value="#{servidorController.dataUltimaAlteracao}"></h:outputText>
							<h:outputText value="Data da última aprovação:"></h:outputText>
							<h:outputText value="#{servidorController.dataUltimaAprovacao}"></h:outputText>
						</h:panelGrid>
					</h:panelGrid>
				</rich:tab>
			</rich:tabPanel>
		</rich:panel>
	</a4j:form></center>
	<center><rich:modalPanel id="confirmPanel" autosized="false"
		style="overflow: auto;"
		showWhenRendered="#{not empty facesContext.maximumSeverity}">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Verificar Campos"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="../images/close.gif"
					onclick="#{rich:component('confirmPanel')}.hide();" />
			</h:panelGroup>
		</f:facet>
		<h:form>
			<table width="100%" height="100%">
				<tbody>
					<tr>
						<td><rich:messages layout="list" errorLabelClass="errorLabel"
							style="top:auto;" infoLabelClass="infoLabel">
							<f:facet name="infoMarker">
								<h:graphicImage value="../images/passed.gif" />
							</f:facet>
							<f:facet name="errorMarker">
								<h:graphicImage value="../images/error.gif" />
							</f:facet>
						</rich:messages></td>
					</tr>
				</tbody>
			</table>
		</h:form>
	</rich:modalPanel></center>
</f:view>
</body>
</html>