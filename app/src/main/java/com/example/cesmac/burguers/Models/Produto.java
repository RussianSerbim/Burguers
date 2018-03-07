package com.example.cesmac.burguers.Models;


public class Produto {

        private int foto;
        private String produto;
        private double preco;

        public Produto (int foto, String produto, double preco){
            this.foto = foto;
            this.produto = produto;
            this.preco = preco;

        }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
