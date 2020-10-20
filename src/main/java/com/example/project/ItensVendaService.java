package com.example.project;

import java.util.ArrayList;

public class ItensVendaService {
    ArrayList<ItemVenda> itens = new ArrayList<>();

    public ItensVendaService(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }

    public ItensVendaService() {
        this(new ArrayList<ItemVenda>());
    }

    public void validaItemAdicionado(Produto produto, int quantidade) {
        if(isDuplicado(produto))
            throw new RuntimeException("O produto já está na lista.");

        if(produto.getValorUnitario() <= 0)
            throw new RuntimeException("Produto com valor unitário zero ou negativo.");

        if(quantidade <= 0)
            throw new RuntimeException("Item de Venda com quantidade zero ou negativa.");
    }

    public boolean adicionarItem(Produto produto, int quantidade) {
        
        validaItemAdicionado(produto, quantidade);

        int id = this.itens.size() + 1;
        ItemVenda itemNoCupom = new ItemVenda(id, produto, quantidade);
        this.itens.add(itemNoCupom);
        return true;
    }

    public boolean isDuplicado(Produto produto) {
        for (ItemVenda item : this.itens) {
            if (item.getProduto().getCodigo() == produto.getCodigo()) {
                return true;
            }
        }
        return false;
    }

    public int numeroDeItens() {
        return itens.size();
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemVenda item : this.itens) {
            total += item.getProduto().getValorUnitario() * item.getQuantidade();
        }
        return total;
    }

    @Override
    public String toString(){
        String stringfy = "";
        for (ItemVenda item : itens) {
            stringfy = stringfy.equals("") ? 
                       (stringfy += item.dadosItem()) :
                       (stringfy += Venda.LN + item.dadosItem());
        }
        return stringfy;
    }
}
