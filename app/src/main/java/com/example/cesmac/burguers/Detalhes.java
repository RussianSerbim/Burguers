package com.example.cesmac.burguers;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cesmac.burguers.Models.Produto;


public class Detalhes extends Fragment {

    private Produto produto;

    public Detalhes() {

    }

    @SuppressLint("ValidFragment")
    public Detalhes(Produto produto) {
        this.produto = produto;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View v = inflater.inflate(R.layout.fragment_detalhes, container, false);
        ImageView imagem = v.findViewById(R.id.iv_frag);
        imagem.setImageResource(produto.getFoto());

        TextView texto = v.findViewById(R.id.tv_frag1);
        texto.setText(produto.getProduto());
       return v;
    }

}
