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
	<a4j:loadScript src="../js/script.js" />
	<center><h:graphicImage value="../images/alterarDados02.GIF" />
	<a4j:form id="form">
		<rich:tabPanel switchType="client" width="950">
			<rich:tab label="Dados Pessoais">
				<h:panelGrid columns="4">
					<h:outputText value="Nome: " />
					<h:inputText value="#{servidorController.servidor.nome}" size="40"
						maxlength="100" required="true"
						requiredMessage="Campo Nome obrigatório!"></h:inputText>
					<h:outputText value="Sexo: " />
					<h:selectOneMenu value="#{servidorController.servidor.sexo}"
						required="true" requiredMessage="Campo Sexo é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItem itemLabel="FEMININO" itemValue="F" />
						<f:selectItem itemLabel="MASCULINO" itemValue="M" />
					</h:selectOneMenu>
					<h:outputText value="Data de Nascimento: " />
					<rich:calendar
						value="#{servidorController.servidor.dataNascimento}" locale=""
						popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
						cellWidth="12px" cellHeight="12px" style="width:80px"
						required="true" inputSize="12"
						requiredMessage="Campo Data de Nascimento!" />
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
						requiredMessage="Campo Nome da Mãe obrigatório!"></h:inputText>
					<h:outputText value="Nome do do Pai: " />
					<h:inputText value="#{servidorController.servidor.nomePai}"
						size="40" maxlength="100"></h:inputText>
					<h:outputText value="Estado de Nascimento: " />
					<h:selectOneMenu
						value="#{servidorController.servidor.cidadeNascimento.estado.codigo}"
						required="true"
						requiredMessage="Campo Estado de Nascimento é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorController.estados}" />
						<a4j:support event="onchange"
							action="#{servidorController.listarCidadesNascimentoServidor}"
							ajaxSingle="true" reRender="cidadeNascimentoServidor"></a4j:support>
					</h:selectOneMenu>
					<h:outputText value="Cidade de Nascimento: " />
					<h:selectOneMenu id="cidadeNascimentoServidor"
						value="#{servidorController.servidor.cidadeNascimento.codigo}"
						required="true"
						requiredMessage="Campo Cidade de Nascimento é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorController.cidades}" />
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
					<h:selectBooleanCheckbox
						value="#{servidorController.servidor.indEstrangeiro}">
						<a4j:support event="onchange"
							action="#{servidorController.isEstrangeiro}" ajaxSingle="true"
							reRender="data, dataCampo, pais, paisCampo"></a4j:support>
					</h:selectBooleanCheckbox>

					<h:outputText id="data" value="Data de Chegada no País: " />
					<rich:calendar id="dataCampo" value="" locale="" popup="true"
						disabled="#{!servidorController.servidorEstrangeiro}"
						datePattern="dd/MM/yyyy" showApplyButton="#" cellWidth="12px"
						cellHeight="12px" style="width:80px" required="true"
						inputSize="12" requiredMessage="Data de Chegada no País!" />

					<h:outputText id="pais" value="País de Orgiem: " />
					<h:selectOneMenu id="paisCampo" value="" required="true"
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
					<h:inputText value="#{servidorController.servidor.siape}" size="10"
						maxlength="7" required="true"
						requiredMessage="Campo SIAPE obrigatório!"
						onkeypress="mascara(this,soNumeros);"></h:inputText>
					<h:outputText value="Id Única: " />
					<h:inputText
						value="#{servidorController.servidor.identificacaoUnica}"
						size="10" maxlength="9" required="true"
						requiredMessage="Campo Id Única obrigatório!"
						onkeypress="mascara(this,idUnica);"></h:inputText>

					<h:outputText value="Data de Admissão no Órgão: " />
					<rich:calendar value="#{servidorController.servidor.dataAdmissao}"
						locale="" popup="true" datePattern="dd/MM/yyyy"
						showApplyButton="#" cellWidth="12px" cellHeight="12px"
						style="width:80px" required="true" inputSize="12"
						requiredMessage="Campo Data de Admissão no Órgão obrigatório!" />

					<h:outputText value="Data de Admissão no Serviço Público: " />
					<rich:calendar
						value="#{servidorController.servidor.dataAdmServicoPublico}"
						locale="" popup="true" datePattern="dd/MM/yyyy"
						showApplyButton="#" cellWidth="12px" cellHeight="12px"
						style="width:80px" required="true" inputSize="12"
						requiredMessage="Campo Data de Admissão no Serviço Público obrigatório!" />

					<h:outputText value="Lotação: " />
					<h:selectOneMenu
						value="#{servidorController.servidor.lotacao.codigo}"
						required="true" requiredMessage="Campo Lotação é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorController.lotacoes}" />
					</h:selectOneMenu>

					<h:outputText value="Local de Exercício: " />
					<h:selectOneMenu
						value="#{servidorController.servidor.localExercicio.codigo}"
						required="true"
						requiredMessage="Campo Local de Exercício é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorController.lotacoes}" />
					</h:selectOneMenu>

					<h:outputText value="Ramal: " />
					<h:inputText value="#{servidorController.servidor.ramal}" size="8"
						maxlength="4" required="true"
						requiredMessage="Campo Ramal obrigatório!"
						onkeypress="mascara(this, soNumeros);"></h:inputText>

					<h:outputText value="Cargo: " />
					<h:selectOneMenu
						value="#{servidorController.servidor.cargo.codigo}"
						required="true" requiredMessage="Campo Cargo é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorController.cargos}" />
						<a4j:support event="onchange"
							action="#{servidorController.carregarClasse}" ajaxSingle="true"
							reRender="classe"></a4j:support>
					</h:selectOneMenu>

					<h:outputText value="Classe: " />
					<h:outputText id="classe"
						value="#{servidorController.servidor.cargo.classe.sigla}" />

					<h:outputText value="Padrão: " />
					<h:selectOneMenu
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

					<h:outputText value="Função: " />
					<h:selectOneMenu
						value="#{servidorController.servidor.funcao.codigo}">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorController.funcoes}" />
					</h:selectOneMenu>

					<h:outputText value="Tipo Função: " />
					<h:selectOneMenu
						value="#{servidorController.servidor.funcao.tipoFuncao.codigo}">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorController.tipoFuncoes}" />
					</h:selectOneMenu>

					<h:outputText value="Situação Funcional: " />
					<h:selectOneMenu
						value="#{servidorController.servidor.situacaoFuncional.codigo}"
						required="true"
						requiredMessage="Campo Situação Funcional é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorController.situacoesFuncionais}" />
					</h:selectOneMenu>

					<h:outputText value="Data de Saída do Orgão: " />
					<rich:calendar value="#{servidorController.servidor.dataSaida}"
						locale="" popup="true" datePattern="dd/MM/yyyy"
						showApplyButton="#" cellWidth="12px" cellHeight="12px"
						style="width:80px" inputSize="12" />
				</h:panelGrid>
			</rich:tab>

			<rich:tab label="Documentos">
				<h:panelGrid columns="4">
					<h:outputText value="CPF: " />
					<h:inputText value="#{servidorController.servidor.documento.cpf}"
						size="16" maxlength="14" required="true"
						requiredMessage="Campo CPF obrigatório!"
						onkeypress="mascara(this,cpf);"></h:inputText>
					<h:outputText value="RG: " />
					<h:inputText value="#{servidorController.servidor.documento.rg}"
						size="16" maxlength="14" required="true"
						requiredMessage="Campo RG obrigatório!"></h:inputText>
					<h:outputText value="UF do RG: " />
					<h:selectOneMenu
						value="#{servidorController.servidor.documento.rgUf.codigo}"
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
						requiredMessage="Campo Data de Expedição do RG obrigatório!" />
					<h:outputText value="Título de Eleitor: " />
					<h:inputText
						value="#{servidorController.servidor.documento.tituloEleitor}"
						size="16" maxlength="13" required="true"
						onkeypress="mascara(this,tituloEleitor);"
						requiredMessage="Campo Título de Eleitor obrigatório!"></h:inputText>
					<h:outputText value="Título de Eleitor Zona: " />
					<h:inputText
						value="#{servidorController.servidor.documento.tituloZona}"
						size="10" maxlength="3" required="true"
						onkeypress="mascara(this,soNumeros);"
						requiredMessage="Campo Título de Eleitor Sessão obrigatório!"></h:inputText>
					<h:outputText value="Título de Eleitor Sessão: " />
					<h:inputText
						value="#{servidorController.servidor.documento.tituloSecao}"
						size="10" maxlength="4" required="true"
						onkeypress="mascara(this,soNumeros);"
						requiredMessage="Campo Título de Eleitor Sessão obrigatório!"></h:inputText>
					<h:outputText value="UF do Título de Eleitor: " />
					<h:selectOneMenu
						value="#{servidorController.servidor.documento.tituloUf.codigo}"
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
						requiredMessage="Campo Data de Emissão do Título de Eleitor obrigatório!" />
					<h:outputText value="Certificado Militar: " />
					<h:inputText
						value="#{servidorController.servidor.documento.certificadoMilitar}"
						size="16" maxlength="6" onkeypress="mascara(this, soNumeros);"></h:inputText>
					<h:outputText value="Certificado Militar Orgão Emissor: " />
					<h:inputText
						value="#{servidorController.servidor.documento.certificadoOrgaoEmissor}"
						size="16" maxlength="8"></h:inputText>
					<h:outputText value="Certificado Militar Série: " />
					<h:inputText
						value="#{servidorController.servidor.documento.certificadoSerie}"
						size="7" maxlength="1"></h:inputText>
					<h:outputText value="Carteira de Trabalho: " />
					<h:inputText
						value="#{servidorController.servidor.documento.carteiraTrabalho}"
						size="16" maxlength="7" required="true"
						requiredMessage="Campo Carteira de Trabalho obrigatório!"></h:inputText>
					<h:outputText value="Carteira de Trabalho Série: " />
					<h:inputText
						value="#{servidorController.servidor.documento.carteiraSerie}"
						size="10" maxlength="5" required="true"
						requiredMessage="Campo Carteira de Trabalho Série obrigatório!"></h:inputText>
					<h:outputText value="UF da Carteira de Trabalho: " />
					<h:selectOneMenu
						value="#{servidorController.servidor.documento.carteiraUf.codigo}"
						required="true"
						requiredMessage="Campo UF da Carteira de Trabalho é obrigatório!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorController.ufs}" />
					</h:selectOneMenu>
					<h:outputText value="PIS/PASEP: " />
					<h:inputText value="#{servidorController.servidor.documento.pis}"
						size="16" maxlength="14" required="true"
						onkeypress="mascara(this, pis);"
						requiredMessage="Campo PIS/PASEP obrigatório!"></h:inputText>
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
						requiredMessage="Campo Endereço obrigatório!"></h:inputText>

					<h:outputText value="Número: " />
					<h:inputText value="#{servidorController.servidor.endereco.numero}"
						size="5" maxlength="7" required="true"
						requiredMessage="Campo Número obrigatório!"></h:inputText>

					<h:outputText value="Bairro: " />
					<h:inputText value="#{servidorController.servidor.endereco.bairro}"
						size="30" maxlength="80" required="true"
						requiredMessage="Campo Bairro obrigatório!"></h:inputText>

					<h:outputText value="Complemento: " />
					<h:inputText
						value="#{servidorController.servidor.endereco.complemento}"
						size="25" maxlength="25"></h:inputText>

					<h:outputText value="CEP: " />
					<h:inputText value="#{servidorController.servidor.endereco.cep}"
						size="20" maxlength="9" required="true"
						requiredMessage="Campo CEP obrigatório!"
						onkeypress="mascara(this,cep)"></h:inputText>


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
						requiredMessage="Campo Telefone obrigatório!"
						onkeypress="mascara(this,telefone);"></h:inputText>

					<h:outputText value="Celular: " />
					<h:inputText value="#{servidorController.servidor.celular}"
						size="16" maxlength="13" onkeypress="mascara(this,telefone);"></h:inputText>

					<h:outputText value="E-mail: " />
					<h:inputText value="#{servidorController.servidor.email}" size="40"
						maxlength="150"></h:inputText>
				</h:panelGrid>
			</rich:tab>

			<rich:tab label="Escolaridade">
				<a4j:region>
					<h:panelGrid columns="4">
						<h:outputText value="Titulação: " />
						<h:selectOneMenu id="titulacao"
							value="#{servidorController.servidorTitulacao.titulacao.codigo}">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.titulacoes}" />
						</h:selectOneMenu>

						<h:outputText value="Estabelecimento de Ensino: " />
						<h:inputText id="estabeleciemntoEnsino" size="40"
							value="#{servidorController.servidorTitulacao.estabelecimentoEnsino}">
						</h:inputText>

						<h:outputText value="Curso: " />
						<h:inputText size="40" maxlength="80"
							value="#{servidorController.servidorTitulacao.curso}">
						</h:inputText>

						<h:outputText value="Área de Conheciemnto: " />
						<h:selectOneMenu
							value="#{servidorController.servidorTitulacao.areaConhecimento.codigo}">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.areasConhecimentos}" />
						</h:selectOneMenu>

						<h:outputText value="Estado do Estabelecimento: " />
						<h:selectOneMenu id="estadoEstabelecimento"
							disabled="#{servidorController.indTitulacaoEstrangeira}"
							value="#{servidorController.servidorTitulacao.cidadeEstabelecimentoEnsino.estado.codigo}">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.estados}" />
							<a4j:support event="onchange"
								action="#{servidorController.listarCidadesEstabelecimentoEnsino}"
								ajaxSingle="true" reRender="cidadeEstabelecimento"></a4j:support>
						</h:selectOneMenu>
						<h:outputText value="Cidade do Estabelecimento: " />
						<h:selectOneMenu id="cidadeEstabelecimento"
							disabled="#{servidorController.indTitulacaoEstrangeira}"
							value="#{servidorController.servidorTitulacao.cidadeEstabelecimentoEnsino.codigo}">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.cidades}" />
						</h:selectOneMenu>

						<h:outputText value="Ano de Conclusão: " />
						<h:inputText id="anoConclusao"
							value="#{servidorController.servidorTitulacao.anoConclusao}"
							size="10" maxlength="4" onkeypress="mascara(this, soNumeros);"></h:inputText>

						<h:outputText value="Carga Horária: " />
						<h:inputText id="cargaHoraria"
							value="#{servidorController.servidorTitulacao.cargaHoraria}"
							size="10" maxlength="4" onkeypress="mascara(this, soNumeros);"></h:inputText>

						<h:outputText value="Registro no Conselho: " />
						<h:inputText id="registroConselho"
							value="#{servidorController.servidorTitulacao.registroConselho}"
							size="10" maxlength="8"></h:inputText>

						<h:outputText value="Órgão Emissaor do Registro: " />
						<h:inputText id="orgaoRegistro"
							value="#{servidorController.servidorTitulacao.orgaoEmissor}"
							size="10" maxlength="8"></h:inputText>

						<h:outputText value="Estado do Orgão Emissor do Registro: " />
						<h:selectOneMenu id="estadoOrgaoRegistro"
							value="#{servidorController.servidorTitulacao.estadoOrgaoEmissor.codigo}">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.estados}" />
						</h:selectOneMenu>

						<h:outputText value="Titulação Estrangeira:" />
						<h:selectBooleanCheckbox id="titEstrangeira"
							value="#{servidorController.indTitulacaoEstrangeira}">
							<a4j:support event="onchange"
								action="#{servidorController.isTitulacaoEstrangeira}"
								ajaxSingle="true"
								reRender="titulacaoEstrangeira, estadoEstabelecimento, cidadeEstabelecimento"></a4j:support>
						</h:selectBooleanCheckbox>

						<h:outputText value="País: " />
						<h:selectOneMenu id="titulacaoEstrangeira"
							disabled="#{!servidorController.indTitulacaoEstrangeira}"
							value="#{servidorController.servidorTitulacao.pais.codigo}">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.paises}" />
						</h:selectOneMenu>

						<a4j:commandButton value="Adicionar"
							reRender="listaEscolariadade, titulacao, estabeleciemntoEnsino, estadoEstabelecimento,
cidadeEstabelecimento, anoConclusao, cargaHoraria, registroConselho,
orgaoRegistro,estadoOrgaoRegistro, titulacaoEstrangeira, titEstrangeira	"
							oncomplete="#{rich:component('confirmPanel')}.show()"
							action="#{servidorController.adicionarTitulacao}" />
					</h:panelGrid>
					<rich:dataTable id="listaEscolariadade"
						value="#{servidorController.titulacaoList}" var="list"
						width="930px" columnClasses="center" rows="10" reRender="ds">
						<rich:column width="450px">
							<f:facet name="header">
								<h:outputText value="Titulação" />
							</f:facet>
							<h:outputText value="#{list.titulacao.descricao}" />
						</rich:column>
						<rich:column width="450px">
							<f:facet name="header">
								<h:outputText value="Curso" />
							</f:facet>
							<h:outputText value="#{list.curso}" />
						</rich:column>

						<rich:column width="450px">
							<f:facet name="header">
								<h:outputText value="Ano de Conclusão" />
							</f:facet>
							<h:outputText value="#{list.anoConclusao}" />
						</rich:column>

						<rich:column>
							<f:facet name="header">
								<h:outputText value="Excluir" />
							</f:facet>
							<a4j:commandLink action="#{servidorController.removerTitulacao}"
								reRender="listaEscolariadade" ajaxSingle="true">
								<h:graphicImage value="../images/delete.gif" style="border:0"
									width="20" height="18" id="excluir" />
								<f:setPropertyActionListener value="#{list.codigo}"
									target="#{servidorController.servidorTitulacao.codigo}" />
								<f:setPropertyActionListener value="#{list.indentificador}"
									target="#{servidorController.servidorTitulacao.indentificador}" />
							</a4j:commandLink>
							<rich:toolTip for="excluir" value="Excluir" />
						</rich:column>
						<f:facet name="footer">
							<rich:datascroller id="ds"></rich:datascroller>
						</f:facet>
					</rich:dataTable>
				</a4j:region>
			</rich:tab>

			<rich:tab label="Profissional">
				<a4j:region>
					<h:panelGrid columns="4">
						<h:outputText value="Empresa: " />
						<h:inputText value="#{servidorController.emprego.empresa}"
							id="empEmpresa" maxlength="100" size="50">
						</h:inputText>
						<h:outputText value="Cargo: " />
						<h:inputText value="#{servidorController.emprego.cargo}"
							id="empCargo" maxlength="80" size="30">
						</h:inputText>


						<h:outputText value="Data de Admissão: " />
						<rich:calendar id="empDataAdm"
							value="#{servidorController.emprego.dataAdmissao}" locale=""
							popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
							cellWidth="12px" cellHeight="12px" style="width:80px"
							inputSize="12" />

						<h:outputText value="Data de Saída: " />
						<rich:calendar id="empDataSaida"
							value="#{servidorController.emprego.dataSaida}" locale=""
							popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
							cellWidth="12px" cellHeight="12px" style="width:80px"
							inputSize="12" />
						<h:outputText value="Atividades: " />
						<h:inputTextarea value="#{servidorController.emprego.atividades}"
							id="empAtividades" cols="35" rows="5">
						</h:inputTextarea>
					</h:panelGrid>
					<a4j:commandButton value="Adicionar"
						reRender="listaEmpregos, empCargo,empEmpresa, empDataAdm, empDataSaida, empAtividades"
						action="#{servidorController.adicionarEmprego}"
						oncomplete="#{rich:component('confirmPanel')}.show()" />

					<rich:dataTable id="listaEmpregos"
						value="#{servidorController.empregoList}" var="list" width="930px"
						columnClasses="center" rows="10" reRender="ds">
						<rich:column width="450px">
							<f:facet name="header">
								<h:outputText value="Empresa" />
							</f:facet>
							<h:outputText value="#{list.empresa}" />
						</rich:column>
						<rich:column width="450px">
							<f:facet name="header">
								<h:outputText value="Cargo" />
							</f:facet>
							<h:outputText value="#{list.cargo}" />
						</rich:column>
						<rich:column width="450px">
							<f:facet name="header">
								<h:outputText value="Data de Admissão" />
							</f:facet>
							<h:outputText value="#{list.dataAdmissaoString}" />
						</rich:column>
						<rich:column width="450px">
							<f:facet name="header">
								<h:outputText value="Data de Saida" />
							</f:facet>
							<h:outputText value="#{list.dataSaidaString}" />
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="Excluir" />
							</f:facet>
							<a4j:commandLink action="#{servidorController.removerEmprego}"
								reRender="listaEmpregos" ajaxSingle="true">
								<h:graphicImage value="../images/delete.gif" style="border:0"
									width="20" height="18" id="excluir" />
								<f:setPropertyActionListener value="#{list.codigo}"
									target="#{servidorController.emprego.codigo}" />
								<f:setPropertyActionListener value="#{list.indentificador}"
									target="#{servidorController.emprego.indentificador}" />
							</a4j:commandLink>
							<rich:toolTip for="excluir" value="Excluir" />
						</rich:column>
						<f:facet name="footer">
							<rich:datascroller id="ds"></rich:datascroller>
						</f:facet>
					</rich:dataTable>
				</a4j:region>
			</rich:tab>

			<rich:tab label="Conta Bancária">
				<h:panelGrid columns="6">
					<h:outputText value="Banco: " />
					<h:selectOneMenu
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
						requiredMessage="Campo Número da Conta obrigatório!"></h:inputText>
					<h:outputText value="Agência: " />
					<h:inputText
						value="#{servidorController.servidor.contaBancaria.agencia}"
						size="10" maxlength="8" required="true"
						requiredMessage="Campo Agência obrigatório!"></h:inputText>

					<h:outputText value="Poupança:" />
					<h:selectBooleanCheckbox id="poupanca"
						disabled="#{!servidorController.indPoupanca}"
						value="#{servidorController.servidor.contaBancaria.indPoupanca}">
					</h:selectBooleanCheckbox>
				</h:panelGrid>
			</rich:tab>


			<rich:tab label="Cônjuge">
				<h:panelGrid columns="4">
					<h:outputText value="Nome do Cônjuge: " />
					<h:inputText value="#{servidorController.servidor.conjuge.nome}"
						size="40" maxlength="100"></h:inputText>
					<h:outputText value="Sexo do Cônjugue: " />
					<h:selectOneMenu
						value="#{servidorController.servidor.conjuge.sexo}">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItem itemLabel="FEMININO" itemValue="F" />
						<f:selectItem itemLabel="MASCULINO" itemValue="M" />
					</h:selectOneMenu>
					<h:outputText value="CPF do Cônjuge: " />
					<h:inputText
						value="#{servidorController.servidor.conjuge.documento.cpf}"
						size="16" maxlength="14" onkeypress="mascara(this,cpf);"></h:inputText>
					<h:outputText value="RG do Cônjuge: " />
					<h:inputText
						value="#{servidorController.servidor.conjuge.documento.rg}"
						size="16" maxlength="14"></h:inputText>
					<h:outputText value="UF do RG do Cônjuge: " />
					<h:selectOneMenu
						value="#{servidorController.servidor.conjuge.documento.rgUf.codigo}">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorController.ufs}" />
					</h:selectOneMenu>
					<h:outputText value="Orgão Emissor do RG do Cônjuge: " />
					<h:inputText
						value="#{servidorController.servidor.conjuge.documento.rgOrgaoEmissor}"
						size="16" maxlength="8"></h:inputText>
					<h:outputText value="Data de Expedição do RG: " />
					<rich:calendar
						value="#{servidorController.servidor.conjuge.documento.rgDataExpedicao}"
						locale="" popup="true" datePattern="dd/MM/yyyy"
						showApplyButton="#" cellWidth="12px" cellHeight="12px"
						style="width:80px" inputSize="12" />
					<h:outputText value="Estado de Nascimento do Cônjuge: " />
					<h:selectOneMenu
						value="#{servidorController.servidor.conjuge.cidadeNascimento.estado.codigo}">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorController.estados}" />
						<a4j:support event="onchange"
							action="#{servidorController.listarCidadesConjuge}"
							ajaxSingle="true" reRender="cidadeNacimentoConjugue"></a4j:support>
					</h:selectOneMenu>
					<h:outputText value="Cidade de Nascimento do Cônjugue: " />
					<h:selectOneMenu id="cidadeNacimentoConjugue"
						value="#{servidorController.servidor.conjuge.cidadeNascimento.codigo}">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorController.cidades}" />
					</h:selectOneMenu>
					<h:outputText value="Estrangeiro: " />
					<h:selectBooleanCheckbox
						value="#{servidorController.servidor.conjuge.indEstrangeiro}">
					</h:selectBooleanCheckbox>

					<h:outputText value="É servidor? " />
					<h:selectBooleanCheckbox
						value="#{servidorController.servidor.conjuge.indServidor}">
						<a4j:support event="onchange"
							action="#{servidorController.isConjugeServidor}"
							ajaxSingle="true" reRender="orgao"></a4j:support>
					</h:selectBooleanCheckbox>

					<h:outputText value="Em qual Orgão: " />
					<h:inputText value="#{servidorController.servidor.conjuge.local}"
						id="orgao" disabled="#{!servidorController.indConjugeServidor}" />
				</h:panelGrid>
			</rich:tab>

			<rich:tab label="Dependentes">
				<a4j:region>
					<h:panelGrid columns="4">
						<h:outputText value="Nome do Dependente: " />
						<h:inputText value="#{servidorController.dependente.nome}"
							id="depNome">
						</h:inputText>

						<h:outputText value="Sexo: " />
						<h:selectOneMenu value="#{servidorController.dependente.sexo}"
							id="depSexo">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItem itemLabel="FEMININO" itemValue="F" />
							<f:selectItem itemLabel="MASCULINO" itemValue="M" />
						</h:selectOneMenu>

						<h:outputText value="Data de Nascimento do Dependente: " />
						<rich:calendar id="depDtNasc"
							value="#{servidorController.dependente.dataNascimento}" locale=""
							popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
							cellWidth="12px" cellHeight="12px" style="width:80px"
							inputSize="12" />

						<h:outputText value="CPF do Dependente: " />
						<h:inputText id="depCPF"
							value="#{servidorController.dependente.documento.cpf}" size="16"
							maxlength="14" onkeypress="mascara(this,cpf);"></h:inputText>

						<h:outputText value="RG do Dependente: " />
						<h:inputText id="depRG"
							value="#{servidorController.dependente.documento.rg}" size="16"
							maxlength="14"></h:inputText>

						<h:outputText value="UF do RG do Dependente: " />
						<h:selectOneMenu id="depUFRG"
							value="#{servidorController.dependente.documento.rgUf.codigo}">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.ufs}" />
						</h:selectOneMenu>
						<h:outputText value="Orgão Emissor do RG do Dependente: " />
						<h:inputText id="depOrgRG"
							value="#{servidorController.dependente.documento.rgOrgaoEmissor}"
							size="16" maxlength="8">
						</h:inputText>
						<h:outputText value="Data de Expedição do RG: " />
						<rich:calendar id="depExpRG"
							value="#{servidorController.dependente.documento.rgDataExpedicao}"
							locale="" popup="true" datePattern="dd/MM/yyyy"
							showApplyButton="#" cellWidth="12px" cellHeight="12px"
							style="width:80px" inputSize="12" />

						<h:outputText value="Grau Parentesco: " />
						<h:selectOneMenu id="grauParentesco"
							value="#{servidorController.dependente.grauParentesco.codigo}">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItems value="#{servidorController.grauParentescos}" />
						</h:selectOneMenu>

						<h:outputText value="Imposto de Renda: " />
						<h:selectBooleanCheckbox id="ir"
							value="#{servidorController.dependente.indIr}">
						</h:selectBooleanCheckbox>

						<h:outputText value="Necessidades Especiais: " />
						<h:selectBooleanCheckbox id="pne"
							value="#{servidorController.dependente.indNecessidadesEspeciais}">
						</h:selectBooleanCheckbox>

						<h:outputText value="Estudante Universitário? " />
						<h:selectBooleanCheckbox id="universitario"
							value="#{servidorController.dependente.indEstudante}">
							<a4j:support event="onchange"
								action="#{servidorController.isUniversitario}" ajaxSingle="true"
								reRender="estabelecimento, curso, formacao"></a4j:support>
						</h:selectBooleanCheckbox>

						<h:outputText value="Estabelecimento de Ensino:" />
						<h:inputText value="#{servidorController.dependente.faculdade}"
							id="estabelecimento"
							disabled="#{!servidorController.indUniversitario}">
						</h:inputText>

						<h:outputText value="Curso:" />
						<h:inputText value="#{servidorController.dependente.curso}"
							id="curso" disabled="#{!servidorController.indUniversitario}">
						</h:inputText>

						<h:outputText value="Previsão de Formação:" />
						<rich:calendar id="formacao"
							value="#{servidorController.dependente.dataFormacao}" locale=""
							popup="true" datePattern="dd/MM/yyyy" showApplyButton="#"
							cellWidth="12px" cellHeight="12px" style="width:80px"
							disabled="#{!servidorController.indUniversitario}" inputSize="12" />

						<a4j:commandButton value="Adicionar"
							reRender="listaDependentes, estabelecimento, curso, formacao, universitario, pne, ir, grauParentesco,
							depExpRG, depOrgRG, depUFRG, depRG, depNome, depCPF, depDtNasc, depSexo"
							action="#{servidorController.adicionarDependentes}"
							oncomplete="#{rich:component('confirmPanel')}.show()" />
					</h:panelGrid>
					<rich:dataTable id="listaDependentes"
						value="#{servidorController.dependentes}" var="list" width="930px"
						columnClasses="center" rows="10" reRender="ds">
						<rich:column width="450px">
							<f:facet name="header">
								<h:outputText value="Nome do Dependente" />
							</f:facet>
							<h:outputText value="#{list.nome}" />
						</rich:column>
						<rich:column width="450px">
							<f:facet name="header">
								<h:outputText value="Grau Parentesco" />
							</f:facet>
							<h:outputText value="#{list.grauParentesco.descricao}" />
						</rich:column>


						<rich:column>
							<f:facet name="header">
								<h:outputText value="Excluir" />
							</f:facet>
							<a4j:commandLink action="#{servidorController.removerDependente}"
								reRender="listaDependentes" ajaxSingle="true">
								<h:graphicImage value="../images/delete.gif" style="border:0"
									width="20" height="18" id="excluir" />
								<f:setPropertyActionListener value="#{list.codigo}"
									target="#{servidorController.dependente.codigo}" />
								<f:setPropertyActionListener value="#{list.indentificador}"
									target="#{servidorController.dependente.indentificador}" />
							</a4j:commandLink>
							<rich:toolTip for="excluir" value="Excluir" />
						</rich:column>
						<f:facet name="footer">
							<rich:datascroller id="ds"></rich:datascroller>
						</f:facet>
					</rich:dataTable>
				</a4j:region>
			</rich:tab>


			<rich:tab label="SALVAR">
				<a4j:commandButton value="Salvar"
					action="#{servidorController.salvar}" reRender="form"
					oncomplete="#{rich:component('confirmPanel')}.show()" />
			</rich:tab>
		</rich:tabPanel>
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