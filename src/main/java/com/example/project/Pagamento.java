package com.example.project;

import java.util.Set;

public class Pagamento {
    public static final String DINHEIRO = "Dinheiro";
    public static final String CARTAO_CREDITO = "Cartão de crédito";
    public static final String CARTAO_DEBITO = "Cartão de débito";

    private String formaPagamento;
    private double valorCompra;
    private double valorPago;
    
    public Pagamento(
        String formaPagamento, 
        double valorCompra
    ) {
        this.formaPagamento = formaPagamento;
        this.valorCompra = valorCompra;
        this.valorPago = 0.0;
    }

    public String getFormaPagamento() {
        return this.formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValorCompra() {
        return this.valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorPago() {
        return this.valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void validarPagamento(){
        Set<String> formasPagamento = Set.of(DINHEIRO, CARTAO_DEBITO, CARTAO_CREDITO);
        
        if (this.formaPagamento.equalsIgnoreCase(DINHEIRO) && this.valorPago < this.valorCompra) {
            throw new RuntimeException("Valor de pagamento incompatível com o pedido.");
        }

        if(!formasPagamento.contains(this.formaPagamento)) {
            throw new RuntimeException("Forma de pagamento indisponível.");
        }
    }

    public String dadosPagamento(){
        validarPagamento();

        String LN = Venda.LN;
        String strValorCompra = Venda.doubleFixed2(this.valorCompra);
        String strValorPago = Venda.doubleFixed2(this.valorPago);
        String strTroco = Venda.doubleFixed2(this.valorPago - this.valorCompra);
        
        String output = "";
        if(this.formaPagamento.equalsIgnoreCase(DINHEIRO)){
            output += DINHEIRO + " R$ " + strValorPago + LN + 
                     "Troco R$ " + strTroco;          
        } else if(this.formaPagamento.equalsIgnoreCase(CARTAO_CREDITO)) {
            this.valorPago = valorCompra;
            output += CARTAO_CREDITO + " R$ " + strValorCompra;

        } else if(this.formaPagamento.equalsIgnoreCase(CARTAO_DEBITO)) {
            this.valorPago = valorCompra;
            output += CARTAO_DEBITO + " R$ " + strValorCompra;
        }

        return output;
    }
}
