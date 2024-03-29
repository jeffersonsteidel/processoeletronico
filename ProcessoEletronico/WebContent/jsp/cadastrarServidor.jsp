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
	<center><a4j:form id="form">
		<rich:panel>
			<h:panelGrid columns="1"
				rendered="#{servidorController.servidor.codigo == null}">
				<font size="2"><b>CADASTRAR SERVIDOR</b></font>
			</h:panelGrid>
			<h:panelGrid columns="1"
				rendered="#{servidorController.servidor.codigo != 0 && servidorController.servidor.codigo != null}">
				<font size="2"><b>ATUALIZAR DADOS</b></font>
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
			<rich:tabPanel switchType="client" width="750" height="120">
				<rich:tab label="Dados Pessoais">
					<h:panelGrid columns="4">
						<h:outputText value="Nome: " />
						<h:inputText value="#{servidorController.servidor.nome}" size="50"
							maxlength="100" required="true"
							requiredMessage="Campo Nome � obrigat�rio!"></h:inputText>
						<h:outputText value="Sexo: " />
						<h:selectOneMenu value="#{servidorController.servidor.sexo}"
							required="true" requiredMessage="Campo Sexo � obrigat�rio!">
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
							requiredMessage="Campo Data de Nascimento � obrigat�rio!" />
						<h:outputText value="Grupo Sangu�neo: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.grupoSanguineo.codigo}"
							required="true"
							requiredMessage="Campo Grupo Sangu�neo � obrigat�rio!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.gruposSanguineos}" />
						</h:selectOneMenu>
						<h:outputText value="Nome da M�e: " />
						<h:inputText value="#{servidorController.servidor.nomeMae}"
							size="40" maxlength="100" required="true"
							requiredMessage="Campo Nome da M�e � obrigat�rio!"></h:inputText>
						<h:outputText value="Nome do Pai: " />
						<h:inputText value="#{servidorController.servidor.nomePai}"
							size="40" maxlength="100"></h:inputText>
						<h:outputText value="Estado de Nascimento: " />
						<h:selectOneMenu id="estadoNascimentoServidor"
							value="#{servidorController.servidor.estadoNascimento.codigo}"
							required="true"
							disabled="#{!servidorController.servidorBrasileiro}"
							requiredMessage="Campo Estado de Nascimento � obrigat�rio!">
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
							requiredMessage="Campo Cidade de Nascimento � obrigat�rio!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.cidadesNascimento}" />
						</h:selectOneMenu>
						<h:outputText value="Estado Civil: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.estadoCivil.codigo}"
							required="true"
							requiredMessage="Campo Estado Civil � obrigat�rio!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.estadosCivis}" />
						</h:selectOneMenu>

						<h:outputText value="Cor da Pele: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.corPele.codigo}"
							required="true" requiredMessage="Campo Cor Pele � obrigat�rio!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.coresPeles}" />
						</h:selectOneMenu>

						<h:outputText value="Estrangeiro: " />
						<h:selectBooleanCheckbox id="estrangeiro"
							title="Marcar esta op��o caso seja imigrante!"
							value="#{servidorController.servidor.indEstrangeiro}">
							<a4j:support event="onchange"
								action="#{servidorController.isEstrangeiro}" ajaxSingle="true"
								reRender="data, dataCampo, pais, paisCampo, estadoNascimentoServidor, cidadeNascimentoServidor"></a4j:support>
						</h:selectBooleanCheckbox>


						<%-- 
					<h:outputText id="data" value="Data de Chegada no Pa�s: " />
					<rich:calendar id="dataCampo" value="" locale="" popup="true"
						disabled="#{!servidorController.servidorEstrangeiro}"
						datePattern="dd/MM/yyyy" showApplyButton="#" cellWidth="12px"
						cellHeight="12px" style="width:80px" required="true"
						inputSize="12" requiredMessage="Data de Chegada no Pa�s!" />
--%>

						<h:outputText id="pais" value="Pa�s de Origem: " />
						<h:selectOneMenu id="paisCampo"
							value="#{servidorController.servidor.pais.codigo}"
							required="true"
							disabled="#{!servidorController.servidorEstrangeiro}"
							requiredMessage="Campo Pa�s de Origem � obrigat�rio!">
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
							requiredMessage="Campo SIAPE � obrigat�rio!"
							onkeypress="mascara(this,soNumeros);"></h:inputText>
						<h:outputText value="Id �nica: " />
						<h:inputText
							title="A Id �nica pode ser encontrada no contra-cheque!"
							value="#{servidorController.servidor.identificacaoUnica}"
							size="10" maxlength="10" required="true"
							requiredMessage="Campo Id �nica � obrigat�rio!"
							onkeypress="mascara(this,idUnica);"
							validatorMessage="O campo Id �nica deve ter 10 caracteres">
							<f:validateLength minimum="10" />
						</h:inputText>

						<h:outputText value="Data de Admiss�o no IFPR: " />
						<rich:calendar value="#{servidorController.servidor.dataAdmissao}"
							locale="" popup="true" datePattern="dd/MM/yyyy"
							showApplyButton="#" cellWidth="12px" cellHeight="12px"
							style="width:80px" required="true" inputSize="12"
							requiredMessage="Campo Data de Admiss�o no �rg�o � obrigat�rio!" />

						<h:outputText value="Data de Admiss�o no Servi�o P�blico: " />
						<rich:calendar
							value="#{servidorController.servidor.dataAdmServicoPublico}"
							locale="" popup="true" datePattern="dd/MM/yyyy"
							showApplyButton="#" cellWidth="12px" cellHeight="12px"
							style="width:80px" required="true" inputSize="12"
							requiredMessage="Campo Data de Admiss�o no Servi�o P�blico � obrigat�rio!" />

						<h:outputText value="Lota��o: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.lotacao.codigo}"
							required="true" requiredMessage="Campo Lota��o � obrigat�rio!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.lotacoes}" />
						</h:selectOneMenu>

						<h:outputText value="Ramal: " />
						<h:inputText value="#{servidorController.servidor.ramal}" size="8"
							maxlength="4" required="true"
							requiredMessage="Campo Ramal � obrigat�rio!"
							onkeypress="mascara(this, soNumeros);"></h:inputText>

						<h:outputText value="Cargo: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.cargo.codigo}"
							required="true" requiredMessage="Campo Cargo � obrigat�rio!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.cargos}" />
							<a4j:support event="onchange"
								action="#{servidorController.carregarClasse}" ajaxSingle="true"
								reRender="classe, padrao"></a4j:support>
						</h:selectOneMenu>

						<h:outputText value="Classe: " />
						<h:outputText id="classe"
							value="#{servidorController.servidor.cargo.classe.sigla}" />

						<h:outputText value="Padr�o: " />
						<h:selectOneMenu id="padrao"
							disabled="#{servidorController.indEstagiario}"
							value="#{servidorController.servidor.padrao.codigo}"
							required="true" requiredMessage="Campo Padr�o � obrigat�rio!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.padroes}" />
						</h:selectOneMenu>

						<h:outputText value="Regime de Trabalho: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.regimeTrabalho.codigo}"
							required="true"
							requiredMessage="Campo Regime de Trabalho � obrigat�rio!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.regimesTrabalhos}" />
						</h:selectOneMenu>

						<h:outputText value="Situa��o Funcional: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.situacaoFuncional.codigo}"
							required="true"
							requiredMessage="Campo Situa��o Funcional � obrigat�rio!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.situacoesFuncionais}" />
						</h:selectOneMenu>

						<h:outputText value="Data de Sa�da do Org�o: "
							rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}" />
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
							requiredMessage="Campo CPF � obrigat�rio!"
							onkeypress="mascara(this,cpf);">
							<a4j:support event="onchange"
								action="#{servidorController.validarCPF}" ajaxSingle="true"
								reRender="cpf, confirmPanel, messages"></a4j:support>
						</h:inputText>
						<h:outputText value="RG: " />
						<h:inputText value="#{servidorController.servidor.documento.rg}"
							size="16" maxlength="13" required="true"
							requiredMessage="Campo RG � obrigat�rio!"></h:inputText>
						<h:outputText value="UF do RG: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.documento.rgUf}"
							required="true" requiredMessage="Campo UF do RG � obrigat�rio!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.ufs}" />
						</h:selectOneMenu>
						<h:outputText value="Org�o Emissor do RG: " />
						<h:inputText
							value="#{servidorController.servidor.documento.rgOrgaoEmissor}"
							size="16" maxlength="8" required="true"
							requiredMessage="Campo Org�o Emissor do RG obrigat�rio!"></h:inputText>
						<h:outputText value="Data de Expedi��o do RG: " />
						<rich:calendar
							value="#{servidorController.servidor.documento.rgDataExpedicao}"
							locale="" popup="true" datePattern="dd/MM/yyyy"
							showApplyButton="#" cellWidth="12px" cellHeight="12px"
							style="width:80px" required="true" inputSize="12"
							requiredMessage="Campo Data de Expedi��o do RG � obrigat�rio!" />
						<h:outputText value="T�tulo de Eleitor: " />
						<h:inputText
							value="#{servidorController.servidor.documento.tituloEleitor}"
							size="16" maxlength="13" required="true"
							onkeypress="mascara(this,tituloEleitor);"
							validatorMessage="O campo T�tulo de Eleitor deve ter 13 caracteres"
							requiredMessage="Campo T�tulo de Eleitor � obrigat�rio!">
							<f:validateLength minimum="13" />
						</h:inputText>
						<h:outputText value="T�tulo de Eleitor Zona: " />
						<h:inputText
							value="#{servidorController.servidor.documento.tituloZona}"
							size="10" maxlength="3" required="true"
							onkeypress="mascara(this,soNumeros);"
							requiredMessage="Campo T�tulo de Eleitor Sess�o � obrigat�rio!"></h:inputText>
						<h:outputText value="T�tulo de Eleitor Sess�o: " />
						<h:inputText
							value="#{servidorController.servidor.documento.tituloSecao}"
							size="10" maxlength="4" required="true"
							onkeypress="mascara(this,soNumeros);"
							requiredMessage="Campo T�tulo de Eleitor Sess�o � obrigat�rio!"></h:inputText>
						<h:outputText value="UF do T�tulo de Eleitor: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.documento.tituloUf}"
							required="true"
							requiredMessage="Campo UF do T�tulo de Eleitor � obrigat�rio!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.ufs}" />
						</h:selectOneMenu>
						<h:outputText value="Data de Emiss�o do T�tulo de Eleitor: " />
						<rich:calendar
							value="#{servidorController.servidor.documento.tituloDataEmissao}"
							locale="" popup="true" datePattern="dd/MM/yyyy"
							showApplyButton="#" cellWidth="12px" cellHeight="12px"
							style="width:80px" required="true" inputSize="12"
							requiredMessage="Campo Data de Emiss�o do T�tulo de Eleitor � obrigat�rio!" />
						<h:outputText value="Certificado Militar: " />
						<h:inputText disabled="#{servidorController.indFeminino}"
							id="certificadoMilitar"
							value="#{servidorController.servidor.documento.certificadoMilitar}"
							size="16" maxlength="20" onkeypress="mascara(this, soNumeros);"></h:inputText>
						<h:outputText value="Certificado Militar Org�o Emissor: " />
						<h:inputText disabled="#{servidorController.indFeminino}"
							id="certificadoMilitarOrgao"
							value="#{servidorController.servidor.documento.certificadoOrgaoEmissor}"
							size="16" maxlength="12"></h:inputText>
						<h:outputText value="Certificado Militar S�rie: " />
						<h:inputText disabled="#{servidorController.indFeminino}"
							id="certificadoMilitarSerio"
							value="#{servidorController.servidor.documento.certificadoSerie}"
							size="7" maxlength="8"></h:inputText>
						<h:outputText value="Carteira de Trabalho: " />
						<h:inputText
							value="#{servidorController.servidor.documento.carteiraTrabalho}"
							size="16" maxlength="7" required="true"
							requiredMessage="Campo Carteira de Trabalho � obrigat�rio!"></h:inputText>
						<h:outputText value="Carteira de Trabalho S�rie: " />
						<h:inputText
							value="#{servidorController.servidor.documento.carteiraSerie}"
							size="10" maxlength="5" required="true"
							requiredMessage="Campo Carteira de Trabalho S�rie � obrigat�rio!"></h:inputText>
						<h:outputText value="UF da Carteira de Trabalho: " />
						<h:selectOneMenu
							value="#{servidorController.servidor.documento.carteiraUf}">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.ufs}" />
						</h:selectOneMenu>
						<h:outputText value="PIS/PASEP: " />
						<h:inputText value="#{servidorController.servidor.documento.pis}"
							size="16" maxlength="14" required="true"
							validatorMessage="O campo PIS/PASEP deve ter 14 caracteres!"
							onkeypress="mascara(this, pis);"
							requiredMessage="Campo PIS/PASEP � obrigat�rio!">
							<f:validateLength minimum="14" />
						</h:inputText>
						<h:outputText value="Data do 1� Emprego: " />
						<rich:calendar
							value="#{servidorController.servidor.documento.dataPrimeiroEmprego}"
							locale="" popup="true" datePattern="dd/MM/yyyy"
							showApplyButton="#" cellWidth="12px" cellHeight="12px"
							style="width:80px" inputSize="12" />
					</h:panelGrid>
				</rich:tab>

				<rich:tab label="Contato">
					<h:panelGrid columns="4">
						<h:outputText value="Endere�o: " />
						<h:inputText value="#{servidorController.servidor.endereco.rua}"
							size="50" maxlength="120" required="true"
							requiredMessage="Campo Endere�o � obrigat�rio!"></h:inputText>

						<h:outputText value="N�mero: " />
						<h:inputText
							value="#{servidorController.servidor.endereco.numero}" size="5"
							maxlength="7" required="true"
							requiredMessage="Campo N�mero � obrigat�rio!"></h:inputText>

						<h:outputText value="Bairro: " />
						<h:inputText
							value="#{servidorController.servidor.endereco.bairro}" size="30"
							maxlength="80" required="true"
							requiredMessage="Campo Bairro � obrigat�rio!"></h:inputText>

						<h:outputText value="Complemento: " />
						<h:inputText
							value="#{servidorController.servidor.endereco.complemento}"
							size="25" maxlength="25"></h:inputText>

						<h:outputText value="CEP: " />
						<h:inputText value="#{servidorController.servidor.endereco.cep}"
							size="20" maxlength="9" required="true"
							requiredMessage="Campo CEP � obrigat�rio!"
							validatorMessage="Campo CEP deve ter no m�nimo 9 caracateres!"
							onkeypress="mascara(this,cep)">
							<f:validateLength minimum="9" />
						</h:inputText>

						<h:outputText value="Estado: " />
						<h:selectOneMenu id="estado"
							value="#{servidorController.servidor.endereco.cidade.estado.codigo}"
							required="true" requiredMessage="Campo Estado � obrigat�rio!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.estados}" />
							<a4j:support event="onchange"
								action="#{servidorController.listarCidadesContato}"
								ajaxSingle="true" reRender="cidade"></a4j:support>
						</h:selectOneMenu>

						<h:outputText value="Cidade: " />
						<h:selectOneMenu id="cidade"
							value="#{servidorController.servidor.endereco.cidade.codigo}"
							required="true" requiredMessage="Campo Cidade � obrigat�rio!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.cidades}" />
						</h:selectOneMenu>

						<h:outputText value="Telefone: " />
						<h:inputText value="#{servidorController.servidor.telefone}"
							size="16" maxlength="13" required="true"
							requiredMessage="Campo Telefone � obrigat�rio!"
							onkeypress="mascara(this,telefone);"
							validatorMessage="Campo Telefone deve ter no m�nimo 13 caracteres!">
							<f:validateLength minimum="13" />
						</h:inputText>

						<h:outputText value="Celular: " />
						<h:inputText value="#{servidorController.servidor.celular}"
							size="16" maxlength="13" onkeypress="mascara(this,telefone);"
							validatorMessage="Campo Celular deve ter no m�nimo 13 caracteres!">
							<f:validateLength minimum="13" />
						</h:inputText>

						<h:outputText value="E-mail: " />
						<h:inputText value="#{servidorController.servidor.email}"
							required="true" requiredMessage="Campo E-mail � obrigat�rio!"
							size="40" title="Colocar de preferencial o e-mail institucional!"
							maxlength="150"></h:inputText>
					</h:panelGrid>
				</rich:tab>

				<rich:tab label="Conta Banc�ria">
					<h:panelGrid columns="6">
						<h:outputText value="Banco: " />
						<h:selectOneMenu required="true"
							requiredMessage="Campo Banco � obrigat�rio!"
							value="#{servidorController.servidor.contaBancaria.banco.codigo}">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.bancos}" />
							<a4j:support event="onchange"
								action="#{servidorController.isPoupanca}" ajaxSingle="true"
								reRender="poupanca"></a4j:support>
						</h:selectOneMenu>
						<h:outputText value="N�mero da Conta: " />
						<h:inputText
							value="#{servidorController.servidor.contaBancaria.numeroConta}"
							size="15" maxlength="12" required="true"
							requiredMessage="Campo N�mero da Conta � obrigat�rio!"></h:inputText>
						<h:outputText value="Ag�ncia: " />
						<h:inputText
							value="#{servidorController.servidor.contaBancaria.agencia}"
							size="10" maxlength="8" required="true"
							requiredMessage="Campo Ag�ncia � obrigat�rio!"></h:inputText>

						<h:outputText value="Poupan�a:" />
						<h:selectBooleanCheckbox id="poupanca"
							title="A op��o poupan�a � exclusiva de servidores que recebem pela Caixa Econ�mica Federal!"
							disabled="#{!servidorController.indPoupanca}"
							value="#{servidorController.servidor.contaBancaria.indPoupanca}">
						</h:selectBooleanCheckbox>
					</h:panelGrid>
				</rich:tab>

				<rich:tab label="SALVAR">
					<h:panelGrid columns="1">
						<center><a4j:commandButton value="Salvar"
							action="#{servidorController.salvar}" reRender="form" /> <a4j:commandButton
							value="Aprovar"
							rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}"
							action="#{servidorController.aprovar}" reRender="form" /></center>
						<h:panelGrid columns="2"
							rendered="#{autenticacaoController.siapeAutenticado.indAdministrador}">
							<h:graphicImage value="../images/indeferido.gif" style="border:0"
								width="20" height="18"
								rendered="#{!servidorController.servidor.dadosValidados}" />
							<h:outputText
								rendered="#{!servidorController.servidor.dadosValidados}"
								value="Dados ainda n�o validados pela PROGEPE!"></h:outputText>
							<h:graphicImage value="../images/deferido.gif" style="border:0"
								width="20" height="18"
								rendered="#{servidorController.servidor.dadosValidados}" />
							<h:outputText
								rendered="#{servidorController.servidor.dadosValidados}"
								value="Dados validados pela PROGEPE!"></h:outputText>
						</h:panelGrid>
						<h:panelGrid columns="2">
							<h:outputText
								value="Data da �ltima atualiza��o realizada pelo servidor:"></h:outputText>
							<h:outputText value="#{servidorController.dataUltimaAlteracao}"></h:outputText>
							<h:outputText value="Data da �ltima aprova��o:"
								rendered="#{servidorController.dataUltimaAprovacao != null}"></h:outputText>
							<h:outputText value="#{servidorController.dataUltimaAprovacao}"></h:outputText>
						</h:panelGrid>
					</h:panelGrid>
				</rich:tab>
			</rich:tabPanel>
		</rich:panel>
	</a4j:form></center>
</f:view>
</body>
</html>