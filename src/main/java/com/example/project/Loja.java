package com.example.project;

public class Loja {

    private String nomeLoja;
    private Endereco endereco;
    private String telefone;
    private String observacao;
    private String cnpj;
    private String inscricaoEstadual;

    public Loja(
        String nomeLoja, 
        Endereco endereco, 
        String telefone,
        String observacao, 
        String cnpj, 
        String inscricaoEstadual
    ) {
        this.nomeLoja = nomeLoja;
        this.endereco = endereco;
        this.telefone = telefone;
        this.observacao = observacao;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Loja(){
        this("", new Endereco("", 0, "", "", "", "", ""), "", "", "", ""); 
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public void setInscricaoEstadual(String ie) {
        this.inscricaoEstadual = ie;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public static boolean isNullEmpty(String text) {
		try{
			int k = text.length();
		} catch (NullPointerException npe) {
			return true;
		}
		return text.isEmpty();
	}

    public String dadosLoja() {
        // Implemente aqui
        validarCamposObrigatorios();

        String _telefone = isNullEmpty(getTelefone())? "" : "Tel " + getTelefone();
        _telefone = (!_telefone.isEmpty() && !isNullEmpty(endereco.getCep()))? " " + _telefone : _telefone;
		
		String _observacao = isNullEmpty(getObservacao())? "" : getObservacao();				
		String _cnpj = "CNPJ: " + getCnpj();
		String _inscricao_estadual = "IE: " + getInscricaoEstadual();

        String LN = Venda.LN;

		String output = getNomeLoja() + LN;
        output += endereco.dadosEndereco();
        output += _telefone + LN;
		output += _observacao + LN;
		output += _cnpj + LN;
		output += _inscricao_estadual + LN;

		return output;
    }
    
    public void validarCamposObrigatorios() {

        if(isNullEmpty(getNomeLoja()))
			throw new RuntimeException("O campo nome da loja é obrigatório");
		
		if(isNullEmpty(getCnpj()))
			throw new RuntimeException("O campo cnpj da loja é obrigatório");
	
		if(isNullEmpty(getInscricaoEstadual()))
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
    }
}