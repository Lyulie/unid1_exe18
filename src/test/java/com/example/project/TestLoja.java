package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestLoja {

	private String BREAK = System.lineSeparator();

	private String TEXTO_ESPERADO_LOJA_COMPLETA = "Loja 1" + BREAK + 
		"Log 1, 10 C1" + BREAK + 
		"Bai 1 - Mun 1 - E1" + BREAK + 
		"CEP:11111-111 Tel (11) 1111-1111" + BREAK + 
		"Obs 1" + BREAK + 
		"CNPJ: 11.111.111/1111-11" + BREAK + 
		"IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_NUMERO = "Loja 1" + BREAK + 
		"Log 1, s/n C1" + BREAK + 
		"Bai 1 - Mun 1 - E1" + BREAK + 
		"CEP:11111-111 Tel (11) 1111-1111" + BREAK + 
		"Obs 1" + BREAK + "CNPJ: 11.111.111/1111-11" + BREAK + 
		"IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_COMPLEMENTO = "Loja 1" + BREAK + 
		"Log 1, 10" + BREAK + 
		"Bai 1 - Mun 1 - E1" + BREAK + 
		"CEP:11111-111 Tel (11) 1111-1111" + BREAK + 
		"Obs 1" + BREAK + 
		"CNPJ: 11.111.111/1111-11" + BREAK + 
		"IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_BAIRRO = "Loja 1" + BREAK + 
		"Log 1, 10 C1" + BREAK + 
		"Mun 1 - E1" + BREAK + 
		"CEP:11111-111 Tel (11) 1111-1111" + BREAK + 
		"Obs 1" + BREAK + 
		"CNPJ: 11.111.111/1111-11" + BREAK + 
		"IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_CEP = "Loja 1" + BREAK + 
		"Log 1, 10 C1" + BREAK + 
		"Bai 1 - Mun 1 - E1" + BREAK + 
		"Tel (11) 1111-1111" + BREAK + 
		"Obs 1" + BREAK + 
		"CNPJ: 11.111.111/1111-11" + BREAK + 
		"IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_TELEFONE = "Loja 1" + BREAK + 
		"Log 1, 10 C1" + BREAK + 
		"Bai 1 - Mun 1 - E1" + BREAK + 
		"CEP:11111-111" + BREAK + 
		"Obs 1" + BREAK + 
		"CNPJ: 11.111.111/1111-11" + BREAK + 
		"IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_OBSERVACAO = "Loja 1" + BREAK + 
		"Log 1, 10 C1" + BREAK + 
		"Bai 1 - Mun 1 - E1" + BREAK + 
		"CEP:11111-111 Tel (11) 1111-1111" + BREAK + 
		"" + BREAK + 
		"CNPJ: 11.111.111/1111-11" + BREAK + 
		"IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_NUMERO_SEM_COMPLEMENTO = "Loja 1" + BREAK + 
		"Log 1, s/n" + BREAK + 
		"Bai 1 - Mun 1 - E1" + BREAK + 
		"CEP:11111-111 Tel (11) 1111-1111" + BREAK + 
		"Obs 1" + BREAK + 
		"CNPJ: 11.111.111/1111-11" + BREAK + 
		"IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_NUMERO_SEM_COMPLEMENTO_SEM_BAIRRO = "Loja 1" + BREAK + 
		"Log 1, s/n" + BREAK + 
		"Mun 1 - E1" + BREAK + 
		"CEP:11111-111 Tel (11) 1111-1111" + BREAK + 
		"Obs 1" + BREAK + 
		"CNPJ: 11.111.111/1111-11" + BREAK + 
		"IE: 123456789" + BREAK;
	
	private String TEXTO_ESPERADO_EXERCICIO2_CUSTOMIZADO = "Andrea Docas" + BREAK +
		"Rua Setorial, s/n Próximo ao forte" + BREAK +
		"Camboriu - Cabedelo - PB" + BREAK +
		"CEP:58038-000 Tel (83) 8888-7777" + BREAK +
		"Entrada Km 7" + BREAK +
		"CNPJ: 42.591.651/0797-34" + BREAK +
		"IE: 244.898.500.113" + BREAK;

	private String NOME_LOJA = "Loja 1";
	private String LOGRADOURO = "Log 1";
	private int NUMERO = 10;
	private String COMPLEMENTO = "C1";
	private String BAIRRO = "Bai 1";
	private String MUNICIPIO = "Mun 1";
	private String ESTADO = "E1";
	private String CEP = "11111-111";
	private String TELEFONE = "(11) 1111-1111";
	private String OBSERVACAO = "Obs 1";
	private String CNPJ = "11.111.111/1111-11";
	private String INSCRICAO_ESTADUAL = "123456789";

	private Endereco enderecoCompleto = new Endereco(
		LOGRADOURO, 
		NUMERO, 
		COMPLEMENTO, 
		BAIRRO, 
		MUNICIPIO, 
		ESTADO, 
		CEP
	);

	private Loja lojaCompleta = new Loja(
		NOME_LOJA,
		enderecoCompleto,
		TELEFONE,
		OBSERVACAO,
		CNPJ,
		INSCRICAO_ESTADUAL
	);

	String MSG_ERR_NOME_LOJA = "O campo nome da loja é obrigatório";
	String MSG_ERR_CNPJ = "O campo cnpj da loja é obrigatório";
	String MSG_ERR_INSCRICAO_ESTADUAL = "O campo inscrição estadual da loja é obrigatório";

	String MSG_ERR_LOGRADOURO = "O campo logradouro do endereço é obrigatório";
	String MSG_ERR_MUNICIPIO = "O campo município do endereço é obrigatório";
	String MSG_ERR_ESTADO = "O campo estado do endereço é obrigatório";
	

	@Test
	public void lojaCompleta() {
		rodarTestarRetorno(TEXTO_ESPERADO_LOJA_COMPLETA, lojaCompleta);
	}

	/**
	 * Testar Campos Obrigatórios
	 * @Loja nomeLoja, cnpj, inscricaoEstadual
	 * @Endereco logradouro, municipio, estado
	 */

	@Test
	public void validarNome() {
		Loja nomeVazio = lojaCompleta;
		nomeVazio.setNomeLoja("");
		verificarCampoObrigatorio(MSG_ERR_NOME_LOJA, nomeVazio);
		//
		Loja nomeNulo = lojaCompleta;
		nomeNulo.setNomeLoja(null);
		verificarCampoObrigatorio(MSG_ERR_NOME_LOJA, nomeNulo);
	}

	@Test
	public void validarLogradouro() {
		Endereco logradouroVazio = enderecoCompleto;
		logradouroVazio.setLogradouro("");
		
		Loja lojaA = lojaCompleta;
		lojaA.setEndereco(logradouroVazio);
		verificarCampoObrigatorio(MSG_ERR_LOGRADOURO, lojaA);
		//
		Endereco logradouroNulo = enderecoCompleto;
		logradouroNulo.setLogradouro(null);

		Loja lojaB = lojaCompleta;
		lojaB.setEndereco(logradouroNulo);
		verificarCampoObrigatorio(MSG_ERR_LOGRADOURO, lojaB);
	}

	@Test
	public void validarMunicipio() {
		Endereco municipioVazio = enderecoCompleto;
		municipioVazio.setMunicipio("");

		Loja lojaA = lojaCompleta;
		lojaA.setEndereco(municipioVazio);
		verificarCampoObrigatorio(MSG_ERR_MUNICIPIO, lojaA);
		//
		Endereco municipioNulo = enderecoCompleto;
		municipioNulo.setMunicipio(null);

		Loja lojaB = lojaCompleta;
		lojaB.setEndereco(municipioNulo);
		verificarCampoObrigatorio(MSG_ERR_MUNICIPIO, lojaB);
	}

	@Test
	public void validarEstado() {
		Endereco estadoVazio = enderecoCompleto;
		estadoVazio.setEstado("");

		Loja lojaA = lojaCompleta;
		lojaA.setEndereco(estadoVazio);
		verificarCampoObrigatorio(MSG_ERR_ESTADO, lojaA);
		//
		Endereco estadoNulo = enderecoCompleto;
		estadoNulo.setEstado(null);
		
		Loja lojaB = lojaCompleta;
		lojaB.setEndereco(estadoNulo);
		verificarCampoObrigatorio(MSG_ERR_ESTADO, lojaB);
	}

	@Test
	public void validarCnpj() {
		Loja cnpjVazio = lojaCompleta;
		cnpjVazio.setCnpj("");
		verificarCampoObrigatorio(MSG_ERR_CNPJ, cnpjVazio);
		//
		Loja cnpjNulo = lojaCompleta;
		cnpjNulo.setCnpj(null);
		verificarCampoObrigatorio(MSG_ERR_CNPJ, cnpjNulo);
	}

	@Test
	public void validarInscricaoEstadual() {
		Loja ieVazia = lojaCompleta;
		ieVazia.setInscricaoEstadual("");
		verificarCampoObrigatorio(MSG_ERR_INSCRICAO_ESTADUAL, ieVazia);
		//
		Loja ieNula = lojaCompleta;
		ieNula.setInscricaoEstadual(null);
		verificarCampoObrigatorio(MSG_ERR_INSCRICAO_ESTADUAL, ieNula);
	}

	/**
	 * Testar Campos Opcionais
	 * @Loja observacao
	 * @Endereco numero, complemento, bairro, cep
	 */

	@Test
	public void validarNumero() {
		Endereco numeroZero = enderecoCompleto;
		numeroZero.setNumero(0);

		Loja loja = lojaCompleta;
		loja.setEndereco(numeroZero);
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_NUMERO, loja);
	}

	@Test
	public void validarComplemento() {
		Endereco complementoVazio = enderecoCompleto;
		complementoVazio.setComplemento("");

		Loja lojaA = lojaCompleta;
		lojaA.setEndereco(complementoVazio);
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_COMPLEMENTO, lojaA);
		//
		Endereco complementoNulo = enderecoCompleto;
		complementoNulo.setComplemento(null);

		Loja lojaB = lojaCompleta;
		lojaB.setEndereco(complementoNulo);
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_COMPLEMENTO, lojaB);

		
	}

	@Test
	public void validarBairro() {
		Endereco bairroVazio = enderecoCompleto;
		bairroVazio.setBairro("");
		
		Loja lojaA = lojaCompleta;
		lojaA.setEndereco(bairroVazio);
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_BAIRRO, lojaA);
		//
		Endereco bairroNulo = enderecoCompleto;
		bairroNulo.setBairro(null);
		
		Loja lojaB = lojaCompleta;
		lojaB.setEndereco(bairroNulo);
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_BAIRRO, lojaB);
	}

	

	@Test
	public void validarCep() {
		Endereco cepVazio = enderecoCompleto;
		cepVazio.setCep("");

		Loja lojaA = lojaCompleta;
		lojaA.setEndereco(cepVazio);
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_CEP, lojaA);
		//
		Endereco cepNulo = enderecoCompleto;
		cepNulo.setCep("");

		Loja lojaB = lojaCompleta;
		lojaB.setEndereco(cepNulo);
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_CEP, lojaB);
	}

	@Test
	public void validarTelefone() {
		Loja telefoneVazio = lojaCompleta;
		telefoneVazio.setTelefone("");
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_TELEFONE, telefoneVazio);
		//
		Loja telefoneNulo = lojaCompleta;
		telefoneNulo.setTelefone(null);
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_TELEFONE, telefoneNulo);
	}

	@Test
	public void validarObservacao() {
		Loja observacaoVazia = lojaCompleta;
		observacaoVazia.setObservacao("");
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_OBSERVACAO, observacaoVazia);
		//
		Loja observacaoNula = lojaCompleta;
		observacaoNula.setObservacao(null);
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_OBSERVACAO, observacaoNula);
	}

	@Test
	public void validarNumeroComplemento() {
		Endereco semNumeroSemComplemento = enderecoCompleto;
		semNumeroSemComplemento.setNumero(0);
		semNumeroSemComplemento.setComplemento(null);

		Loja loja = lojaCompleta;
		loja.setEndereco(semNumeroSemComplemento);
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_NUMERO_SEM_COMPLEMENTO, loja);
	}

	@Test
	public void validarNumeroComplementoBairro() {
		Endereco semNumeroSemComplementoBairro = enderecoCompleto;
		semNumeroSemComplementoBairro.setNumero(0);
		semNumeroSemComplementoBairro.setComplemento(null);
		semNumeroSemComplementoBairro.setBairro(null);

		Loja loja = lojaCompleta;
		loja.setEndereco(semNumeroSemComplementoBairro);
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_NUMERO_SEM_COMPLEMENTO_SEM_BAIRRO, loja);
	}

	@Test
	public void exercicio02_Customizado() {
		// Defina seus próprios valores para as variáveis a seguir
		String nomeLoja = "Andrea Docas";
		String logradouro = "Rua Setorial";
		int numero = 0;
		String complemento = "Próximo ao forte";
		String bairro = "Camboriu";
		String municipio = "Cabedelo";
		String estado = "PB";
		String cep = "58038-000";
		String telefone = "(83) 8888-7777";
		String observacao = "Entrada Km 7";
		String cnpj = "42.591.651/0797-34";
		String inscricaoEstadual = "244.898.500.113";

		Endereco enderecoCustomizado = new Endereco(
			logradouro, 
			numero, 
			complemento, 
			bairro, 
			municipio, 
			estado, cep
		);
		
		Loja lojaCustomizada = new Loja(
			nomeLoja,
			enderecoCustomizado, 
			telefone, 
			observacao,
			cnpj, 
			inscricaoEstadual
		);

		// E atualize o texto esperado abaixo
		rodarTestarRetorno(TEXTO_ESPERADO_EXERCICIO2_CUSTOMIZADO, lojaCustomizada);
	}

	private void rodarTestarRetorno(String expected, Loja loja) {

		// action
		String retorno = loja.dadosLoja();

		// assertion
		assertEquals(expected, retorno);
	}

	private void verificarCampoObrigatorio(String mensagemEsperada, Loja loja) {
		try {
			loja.dadosLoja();
			assertEquals("RuntimeException", "pass");
		} catch (RuntimeException e) {
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}

}
