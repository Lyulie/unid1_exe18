package com.example.project;

public class ItemVenda {
    private Venda venda;
    private int item; //1, 2, 3
    private Produto produto;
    private int quantidade;

    public ItemVenda(
        Venda venda, 
        int item, 
        Produto produto, 
        int quantidade
    ) {
        this.venda = venda;
        this.item = item;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ItemVenda(
        int item, 
        Produto produto, 
        int quantidade
    ) {
        this.item = item;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return this.venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getItem() {
        return this.item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return this.produto.getValorUnitario() * this.quantidade;
    }

	public String dadosItem() {
        
        return this.item + " " +
               this.produto.getCodigo() + " " +
               this.produto.getDescricao() + " " +
               this.quantidade + " " +
               this.produto.getUnidade() + " " +
               Venda.doubleFixed2(this.produto.getValorUnitario()) + " " +
               this.produto.getSubstituicaoTributaria() + " " +
               Venda.doubleFixed2(getValorTotal());
	}
}
