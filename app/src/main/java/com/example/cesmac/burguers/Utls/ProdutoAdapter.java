package com.example.cesmac.burguers.Utls;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cesmac.burguers.Models.Produto;
import com.example.cesmac.burguers.R;

import java.util.ArrayList;

public class ProdutoAdapter extends ArrayAdapter {

    private ArrayList<Produto> produtos;
    private Context c;

    public ProdutoAdapter(Context c, ArrayList<Produto>produtos) {
        super(c, 0, produtos);
        this.produtos = produtos;
        this.c = c;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
        String nomeProduto = this.produtos.get(position).getProduto();
        return super.getView(position,convertView,parent);
    }
    LayoutInflater inflater = LayoutInflater.from(Context.LAYOUT_INFLATER_SERVICE);
    LayoutInflater inflater = LayoutInflater.from(c);
    View v  = inflater.inflate(R.layout.pitem, ,false);
    Produto produto = this.produtos.get(getPosition());

    //Imagem
    ImageView fotoIV = v.findViewById(R.id.iv_lv);
    fotoIV.setImageResource(produto.getFoto);

    //Produto
    TextView produto = v.findViewById(R.id.tv_lv);
    produto.setText(produto.getProduto);

    //Preço
    TextView preco = v.findViewById(R.id.tv_lv2);
    preco.setText("R$" + produto.getPreco);

    }

