package com.example.project;

public class Endereco {

    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String estado;
    private String cep;

    public Endereco(
        String logradouro, 
        int numero, 
        String complemento, 
        String bairro, 
        String municipio, 
        String estado, 
        String cep
    ) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.estado = estado;
        this.cep = cep;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String dadosEndereco() {
        
        validarCamposObrigatorios();
        
        String _logradouro = getLogradouro() + ", ";
		String _numero = (getNumero() <= 0)? "s/n" : String.format("%d", getNumero());
		String _complemento = Loja.isNullEmpty(getComplemento())? "" : " " + getComplemento();
		String _bairro = Loja.isNullEmpty(getBairro())? "" : getBairro() + " - ";
		String _municipio = getMunicipio() + " - ";
        String _cep = Loja.isNullEmpty(getCep())? "" : "CEP:" + getCep();
        
        String LN = Venda.LN;

        String output;
        output = _logradouro + _numero + _complemento + LN;
        output += _bairro + _municipio + getEstado() + LN;
        output += _cep;
        
        return output;

    }

    public void validarCamposObrigatorios() {

        if(Loja.isNullEmpty(getLogradouro()))
            throw new RuntimeException("O campo logradouro do endereço é obrigatório");
        
        if(Loja.isNullEmpty(getMunicipio()))
            throw new RuntimeException("O campo município do endereço é obrigatório");
        
        if(Loja.isNullEmpty(getEstado()))
            throw new RuntimeException("O campo estado do endereço é obrigatório");
    }
}