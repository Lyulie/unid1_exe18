package com.example.project;

/**
 * @author Rodolpho Alves (https://github.com/Lyulie)
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestVenda {
    
    private void verificarCampoObrigatorio(
        String mensagemEsperada,
        Venda venda
    ) {
        try {
            venda.dadosVenda();
            venda.imprimirCupom();
            assertEquals("RuntimeException", "pass");
        } catch (RuntimeException re) {
            assertEquals(mensagemEsperada, re.getMessage());
        }
    }

    private void validaItemAdicionado(
        String mensagemEsperada,
        Venda venda,
        Produto produto,
        int quantidade
    ) {
        try {
            venda.getItens().adicionarItem(produto, quantidade);
            assertEquals("RuntimeException", "pass");
        } catch (RuntimeException re) {
            assertEquals(mensagemEsperada, re.getMessage());
        }
    }

    private String LOGRADOURO = "Rua 1";
    private int NUMERO = 11;
    private String COMPLEMENTO = "Complemento 1";
    private String BAIRRO = "Bairro 1";
    private String MUNICIPIO = "Municipio 1";
    private String ESTADO = "Estado 1";
    private String CEP = "11111-111";

    private String NOME_LOJA = "Loja 1";
    private String TELEFONE = "(11)1111-1111";
    private String OBSERVACAO = "Observacao 1";
    private String CPNJ = "123456789";
    private String INSCRICAO_ESTADUAL = "987654321";
 
    private String MSG_ERR_LOJA_INVALIDA = "Loja é um campo obrigatório. Insira uma loja válida.";
    private String MSG_ERR_CCF_INVALIDO = "O CCF inserido não é válido.";
    private String MSG_ERR_COO_INVALIDO = "O COO inserido não é válido.";
    private String MSG_ERR_CCF = "O Contador de Cupom Fiscal (CCF) é obrigatório.";
    private String MSG_ERR_COO = "O Contador de Ordem de Operação (COO) é obrigatório.";
    
    private String MSG_ERR_FORMA_PAGAMENTO = "Forma de pagamento indisponível.";

    private Endereco enderecoSample = new Endereco(
        LOGRADOURO, 
        11, 
        COMPLEMENTO, 
        BAIRRO, 
        MUNICIPIO, 
        ESTADO, 
        CEP
    );

    private Loja lojaSample = new Loja(
        NOME_LOJA,
        enderecoSample,
        TELEFONE,
        OBSERVACAO,
        CPNJ,
        INSCRICAO_ESTADUAL
    );

    private String COO = "123456";
    private String CCF = "123456";

    private String UNIDADE = "cx";
    private String SUBSTITUICAO_TRIBUTARIA = "ST";
    
    private String CODIGO1 = "10";
    private String DESCRICAO1 = "Banana";
    private double VALOR_UNITARIO1 = 7.45;
    private int QUANTIDADE1 = 10;
    
    private String CODIGO2 = "20";
    private String DESCRICAO2 = "Laranja";
    private double VALOR_UNITARIO2 = 3.32;
    private int QUANTIDADE2 = 5;

    private Produto produto1Sample = new Produto(
        CODIGO1, 
        DESCRICAO1, 
        UNIDADE, 
        VALOR_UNITARIO1, 
        SUBSTITUICAO_TRIBUTARIA
    );

    private Produto produto2Sample = new Produto(
        CODIGO2, 
        DESCRICAO2, 
        UNIDADE, 
        VALOR_UNITARIO2, 
        SUBSTITUICAO_TRIBUTARIA
    );

    private String FORMA_PAGAMENTO_DINHEIRO = Pagamento.DINHEIRO;
    private String FORMA_PAGAMENTO_CARTAO_DEBITO = Pagamento.CARTAO_DEBITO;
    private String FORMA_PAGAMENTO_CARTAO_CREDITO = Pagamento.CARTAO_CREDITO;

    private Pagamento pagamentoDinheiro = new Pagamento(
        FORMA_PAGAMENTO_DINHEIRO,
        (VALOR_UNITARIO1 * QUANTIDADE1) + (VALOR_UNITARIO2 * QUANTIDADE2) 
    );

    private Pagamento pagamentoCartaoDebito = new Pagamento(
        FORMA_PAGAMENTO_CARTAO_DEBITO,
        (VALOR_UNITARIO1 * QUANTIDADE1) + (VALOR_UNITARIO2 * QUANTIDADE2) 
    );

    private Pagamento pagamentoCartaoCredito = new Pagamento(
        FORMA_PAGAMENTO_CARTAO_CREDITO,
        (VALOR_UNITARIO1 * QUANTIDADE1) + (VALOR_UNITARIO2 * QUANTIDADE2) 
    );

    private Pagamento pagamentoIncorreto = new Pagamento(
        "Cheque",
        100.00
    );

    //

    private String MODELO_IMPRESSORA = "SWEDA IF ST200";
    private String ECF_IF = "01.00.05";
    private String ECF = "067";
    private String SERIAL = "SW031300000000045629";

    private ImpressoraFiscal impressoraFiscal = new ImpressoraFiscal(
        MODELO_IMPRESSORA, 
        ECF_IF, 
        ECF, 
        SERIAL
    );

    private String OPERADOR = "494715";

    private Caixa caixa = new Caixa (
        OPERADOR,
        impressoraFiscal
    );

    private double VALOR_PAGO = 100.00;

    private Venda vendaSamplePagDinheiro = new Venda(
        lojaSample,
        CCF,
        COO,
        pagamentoDinheiro,
        caixa
    );
    
    /**
     * Testar Campos Obrigatórios
     * @Vendas loja, ccf, coo
     */

    @Test
    public void validarLoja() {
        Venda lojaNula = vendaSamplePagDinheiro;
        lojaNula.setLoja(null);
        verificarCampoObrigatorio(MSG_ERR_LOJA_INVALIDA, lojaNula);
    }

    @Test
	public void validarCCF() {
        Venda ccfVazio = vendaSamplePagDinheiro;
        ccfVazio.setCcf("");
        verificarCampoObrigatorio(MSG_ERR_CCF, ccfVazio);

        Venda ccfIncorreto = vendaSamplePagDinheiro;
        ccfIncorreto.setCcf("12345");
        verificarCampoObrigatorio(MSG_ERR_CCF_INVALIDO, ccfIncorreto);
    }

    @Test
	public void validarCOO() {
        Venda cooVazio = vendaSamplePagDinheiro;
        cooVazio.setCoo("");
        verificarCampoObrigatorio(MSG_ERR_COO, cooVazio);

        Venda cooIncorreto = vendaSamplePagDinheiro;
        cooIncorreto.setCoo("12345");
        verificarCampoObrigatorio(MSG_ERR_COO_INVALIDO, cooIncorreto);
    }

    /**
     * Testar dados gerados?
     * @Vendas datahora
     */

    private String DATAHORA = "11/11/1111 11:11:11V";

    public static String parseUm(String datahora) {
        String output = "";
        
        for (char i : datahora.toCharArray()) {
            try{
                int num = Integer.parseInt("" + i);
                output += "1";
            } catch(NumberFormatException nfe) {
                output += i;
            }
        }
        return output;
    }

    @Test
    public void validarDataHora() {
        String dataAtual = parseUm(Venda.getDataAtual());
        assertEquals(dataAtual, DATAHORA);
    }

    //

    String MSG_ERR_SEM_ITENS = "Não há itens para imprimir.";
    String MSG_ERR_ITEM_DUPLICADO = "O produto já está na lista.";
    String MSG_ERR_QUANTIDADE = "Item de Venda com quantidade zero ou negativa.";
    String MSG_ERR_VALOR_VENDA = "Produto com valor unitário zero ou negativo.";

    @Test
    public void vendaSemItens() {
        Venda semItens = vendaSamplePagDinheiro;

        try {
            semItens.imprimirCupom();
            assertEquals("RuntimeException", "pass");
        } catch (RuntimeException re) {
            assertEquals(MSG_ERR_SEM_ITENS, re.getMessage());
        }
    }
    
    @Test
    public void vendaItemDuplicado() {
        Venda itemDuplicado = vendaSamplePagDinheiro;

        itemDuplicado.adicionarItem(produto1Sample, 2);
 
        validaItemAdicionado(
            MSG_ERR_ITEM_DUPLICADO, 
            itemDuplicado,
            produto1Sample, 
            3
        );
    }

    @Test
    public void quantidadeMenorQueUm() {
        Venda quantidadeMenorQueUm = vendaSamplePagDinheiro;

        validaItemAdicionado(
            MSG_ERR_QUANTIDADE, 
            quantidadeMenorQueUm,
            produto1Sample, 
            0
        );
    }

    @Test
    public void valorUnitarioZeroInferior() {
        Venda venda = vendaSamplePagDinheiro;
        Produto valorUnitarioZeroInferior = produto1Sample;
        valorUnitarioZeroInferior.setValorUnitario(-3);
        
        validaItemAdicionado(
            MSG_ERR_VALOR_VENDA, 
            venda,
            valorUnitarioZeroInferior, 
            2
        );
    }

    private String nextLine = System.lineSeparator();
    private String HIFENS = "------------------------------";
    
    String UND = UNIDADE;
    String ST = SUBSTITUICAO_TRIBUTARIA;

    String VU1 = Venda.doubleFixed2(VALOR_UNITARIO1);
    String VU2 = Venda.doubleFixed2(VALOR_UNITARIO2);
    
    String QTD1 = String.valueOf(QUANTIDADE1);
    String QTD2 = String.valueOf(QUANTIDADE2);

    String TOTAL_ITEM_1 = Venda.doubleFixed2(QUANTIDADE1 * VALOR_UNITARIO1);
    String TOTAL_ITEM_2 = Venda.doubleFixed2(QUANTIDADE2 * VALOR_UNITARIO2);

    String TOTAL_ITEM_VENDA = Venda.doubleFixed2(
        Double.parseDouble(TOTAL_ITEM_1) + 
        Double.parseDouble(TOTAL_ITEM_2)
    );

    String _VALOR_PAGO = Venda.doubleFixed2(VALOR_PAGO);
    String _TROCO = Venda.doubleFixed2(VALOR_PAGO - Double.parseDouble(TOTAL_ITEM_VENDA));

    String TEXTO_ESPERADO_IMPRIMIR_CUPOM = NOME_LOJA + nextLine +
    LOGRADOURO + ", " + NUMERO + " " + COMPLEMENTO + nextLine +
    BAIRRO + " - " + MUNICIPIO + " - " + ESTADO + nextLine +
    "CEP:" + CEP + " Tel " + TELEFONE + nextLine +
    OBSERVACAO + nextLine +
    "CNPJ: " + CPNJ + nextLine +
    "IE: " + INSCRICAO_ESTADUAL + nextLine +
    HIFENS + nextLine +
    DATAHORA + " CCF: " + CCF + " COO: " + COO + nextLine +
    "     CUPOM FISCAL     " + nextLine +
    "ITEM CODIGO DESCRICAO QTD UN VL UNIT(R$) ST VL ITEM(R$)" + nextLine +
    "1 " + CODIGO1 + " " + DESCRICAO1 + " " + QTD1 + " " + UND + " " + VU1 + " " + ST + " " + TOTAL_ITEM_1 + nextLine +
    "2 " + CODIGO2 + " " + DESCRICAO2 + " " + QTD2 + " " + UND + " " + VU2 + " " + ST + " " + TOTAL_ITEM_2 + nextLine +
    HIFENS + nextLine;
    
    //

    String TEXTO_ESPERADO_DINHEIRO = "TOTAL: R$ " + TOTAL_ITEM_VENDA + nextLine +
    FORMA_PAGAMENTO_DINHEIRO + " R$ " + _VALOR_PAGO + nextLine +
    "Troco R$ " + _TROCO;
    
    String TEXTO_ESPERADO_CARTAO_DEBITO = "TOTAL: R$ " + TOTAL_ITEM_VENDA + nextLine +
    FORMA_PAGAMENTO_CARTAO_DEBITO + " R$ " + TOTAL_ITEM_VENDA;

    String TEXTO_ESPERADO_CARTAO_CREDITO = "TOTAL: R$ " + TOTAL_ITEM_VENDA + nextLine +
    FORMA_PAGAMENTO_CARTAO_CREDITO + " R$ " + TOTAL_ITEM_VENDA;

    //

    String imposto_federal_aplicado = Venda.doubleFixed2(
        (Double.parseDouble(TOTAL_ITEM_VENDA) * (Venda.IMPOSTO_FEDERAL/100))
    );

    String imposto_estadual_aplicado = Venda.doubleFixed2(
        (Double.parseDouble(TOTAL_ITEM_VENDA) * (Venda.IMPOSTO_ESTADUAL/100))
    );

    String IMPOSTO_APLICADO = nextLine +
        "Lei 12.741, Valor aprox., Imposto" + 
        " F=" + imposto_federal_aplicado + " (" + Venda.IMPOSTO_FEDERAL + "%)," + 
        " E=" + imposto_estadual_aplicado + " (" + Venda.IMPOSTO_ESTADUAL + "%)";

    //
    
    String TEXTO_ESPERADO_CAIXA = nextLine + 
        HIFENS + nextLine +
        "OPERADOR: " + OPERADOR + nextLine +
        HIFENS + nextLine +
        MODELO_IMPRESSORA + nextLine +
        "ECF-IF VERSÃO: " + ECF_IF + " ECF: " + ECF + nextLine +
        "FAB: " + SERIAL;

    @Test
    public void impressaoCupomPagDinheiro() {
        Venda venda = vendaSamplePagDinheiro;

        venda.adicionarItem(produto1Sample, QUANTIDADE1);
        venda.adicionarItem(produto2Sample, QUANTIDADE2);

        venda.setDataHora(DATAHORA);
        venda.setPagamento(VALOR_PAGO);

        assertEquals(TEXTO_ESPERADO_IMPRIMIR_CUPOM +
                     TEXTO_ESPERADO_DINHEIRO + 
                     IMPOSTO_APLICADO +
                     TEXTO_ESPERADO_CAIXA,
                     venda.imprimirCupom());
    }

    @Test
    public void impressaoCupomPagCartaoDebito() {
        Venda venda = vendaSamplePagDinheiro;

        venda.adicionarItem(produto1Sample, QUANTIDADE1);
        venda.adicionarItem(produto2Sample, QUANTIDADE2);

        venda.setDataHora(DATAHORA);
        venda.setPagamento(pagamentoCartaoDebito);

        assertEquals(TEXTO_ESPERADO_IMPRIMIR_CUPOM + 
                     TEXTO_ESPERADO_CARTAO_DEBITO + 
                     IMPOSTO_APLICADO +
                     TEXTO_ESPERADO_CAIXA,
                     venda.imprimirCupom());
    }

    @Test
    public void impressaoCupomPagCartaoCredito() {
        Venda venda = vendaSamplePagDinheiro;

        venda.adicionarItem(produto1Sample, QUANTIDADE1);
        venda.adicionarItem(produto2Sample, QUANTIDADE2);

        venda.setDataHora(DATAHORA);
        venda.setPagamento(pagamentoCartaoCredito);

        assertEquals(TEXTO_ESPERADO_IMPRIMIR_CUPOM +
                     TEXTO_ESPERADO_CARTAO_CREDITO + 
                     IMPOSTO_APLICADO +
                     TEXTO_ESPERADO_CAIXA,
                     venda.imprimirCupom());
    }

    @Test
    public void PagamentoIncorreto() {
        Venda venda = vendaSamplePagDinheiro;
        venda.adicionarItem(produto1Sample, QUANTIDADE1);
        venda.setDataHora(DATAHORA);
        venda.setPagamento(pagamentoIncorreto);

        verificarCampoObrigatorio(
            MSG_ERR_FORMA_PAGAMENTO,
            venda
        );
    }
}
