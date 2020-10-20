package com.example.project;

public class Caixa {
    private String operador;
    private ImpressoraFiscal impressoraFiscal;

    public Caixa(String operador, ImpressoraFiscal impressoraFiscal) {
        this.operador = operador;
        this.impressoraFiscal = impressoraFiscal;
    }

    public String getOperador() {
        return this.operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public ImpressoraFiscal getImpressoraFiscal() {
        return this.impressoraFiscal;
    }

    public void setImpressoraFiscal(ImpressoraFiscal impressoraFiscal) {
        this.impressoraFiscal = impressoraFiscal;
    }

    public String dadosCaixa() {
        if (Loja.isNullEmpty(operador))
            throw new RuntimeException("Operador do caixa inválido.");
        
        String LN = Venda.LN;

        return (
            Venda.repetir("-", 30) + LN +
            "OPERADOR: " + this.operador + LN +
            Venda.repetir("-", 30) + LN +
            this.impressoraFiscal.dadosImpressoraFiscal()
        );
    }
}
