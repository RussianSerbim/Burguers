package com.example.cesmac.burguers.Models;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

public class Produto implements Serializable {

    private int foto;
    private String produto;
    private double preco;
    private boolean check;


    public Produto(int foto, String produto, int preco, boolean b) {
        this.foto = foto;
        this.produto = produto;
        this.preco = preco;
        if (check) this.check = true;
        else this.check = false;
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

    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}

