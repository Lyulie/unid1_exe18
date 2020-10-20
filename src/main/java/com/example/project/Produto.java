package com.example.project;

public class Produto {
    String codigo;
    String descricao;
    String unidade;
    double valorUnitario;
    String substituicaoTributaria;

    public Produto(
        String codigo, //001
        String descricao, //nome_produto
        String unidade, //cx
        double valorUnitario, //00.00 
        String substituicaoTributaria //ST
    ) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidade = unidade;
        this.valorUnitario = valorUnitario;
        this.substituicaoTributaria = substituicaoTributaria;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return this.unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public double getValorUnitario() {
        return this.valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getSubstituicaoTributaria() {
        return this.substituicaoTributaria;
    }

    public void setSubstituicaoTributaria(String substituicaoTributaria) {
        this.substituicaoTributaria = substituicaoTributaria;
    }
}
