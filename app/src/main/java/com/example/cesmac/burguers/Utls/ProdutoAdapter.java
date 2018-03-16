package com.example.cesmac.burguers.Utls;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cesmac.burguers.Models.Produto;
import com.example.cesmac.burguers.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ProdutoAdapter extends ArrayAdapter {

    private ArrayList<Produto> produtos;
    private Context c;

    private boolean[] checks;
    private ArrayList<Produto> selecionados = new ArrayList<Produto>();

    public ProdutoAdapter(Context c, ArrayList<Produto> produtos) {
        super(c, 0, produtos);
        this.produtos = produtos;
        this.c = c;

        checks = new boolean[produtos.size()];
        for (int i = 0; i < produtos.size(); i++) {
            checks[i] = false;
        }

    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(c);
        View v = inflater.inflate(R.layout.pitem, parent, false);
        final Produto produto = this.produtos.get(position);

        //Imagem
        ImageView foto = v.findViewById(R.id.iv_lv);
        foto.setImageResource(produto.getFoto());

        //Produto
        TextView nomeproduto = v.findViewById(R.id.tv_lv);
        nomeproduto.setText(produto.getProduto());

        //Preço
        TextView preco = v.findViewById(R.id.tv_lv2);
        preco.setText("R$" + produto.getPreco());

        //CheckBox
        CheckBox check = v.findViewById(R.id.cb_lv);
        check.setChecked(checks[position]);

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checks[position] = isChecked;

                if (isChecked)
                    selecionados.add(produto);
                else
                    selecionados.remove(produto);
            }
        });

        return v;
    }

    public ArrayList<Produto> getProdutosMarcados() {
        return selecionados;
    }
}






