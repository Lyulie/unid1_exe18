package com.example.project;

public class ImpressoraFiscal {
    private String modelo;
    private String ecf_if;
    private String ecf;
    private String serial;

    public ImpressoraFiscal(
        String modelo, 
        String ecf_if, 
        String ecf, 
        String serial
    ) {
        this.modelo = modelo;
        this.ecf_if = ecf_if;
        this.ecf = ecf;
        this.serial = serial;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEcf_if() {
        return this.ecf_if;
    }

    public void setEcf_if(String ecf_if) {
        this.ecf_if = ecf_if;
    }

    public String getEcf() {
        return this.ecf;
    }

    public void setEcf(String ecf) {
        this.ecf = ecf;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void verificaCamposObrigatorios() {
        if (Loja.isNullEmpty(modelo))
            throw new RuntimeException("O modelo da impressora fiscal é um campo obrigatório.");
        
        if (Loja.isNullEmpty(ecf_if))
            throw new RuntimeException("O ECF-IF é um campo obrigatório.");
        
        if (Loja.isNullEmpty(ecf))
            throw new RuntimeException("O ECF é um campo obrigatório.");
        
        if (Loja.isNullEmpty(ecf))
            throw new RuntimeException("O número serial é um campo obrigatório.");
    }

    public String dadosImpressoraFiscal() {
        verificaCamposObrigatorios();
        String LN = Venda.LN;

        return (
            this.modelo + LN +
            "ECF-IF VERSÃO: " + this.ecf_if + " ECF: " + this.ecf + LN +
            "FAB: " + this.serial
        );
    }
}
