package com.example.cesmac.burguers;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.cesmac.burguers.Models.Produto;
import com.example.cesmac.burguers.Utls.ProdutoAdapter;

import java.util.ArrayList;

public class PedidosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.pedido);
        super.onCreate(savedInstanceState);

        ArrayList<Produto> produto = new ArrayList<Produto>();

        produto.add(new Produto(R.drawable.blackbeef, "Black Beef", 25, false));
        produto.add(new Produto(R.drawable.italiano, "Italiano", 20, false));
        produto.add(new Produto(R.drawable.saladadefrango,"Salada de Frango",  15, false));
        produto.add(new Produto(R.drawable.natural, "Natural",  18, false));
        produto.add(new Produto(R.drawable.agua,"Agua Mineral",  3, false));
        produto.add(new Produto(R.drawable.refrilatas, "Refrigerante Lata", 4, false));
        produto.add(new Produto(R.drawable.refrilitro,  "Refrigerante Litro",  7, false));
        produto.add(new Produto(R.drawable.whopperduplocomqueijo, "Whopper Duplo com Queijo", 22, false));
        final ProdutoAdapter adapter = new ProdutoAdapter(this, produto);

        ListView lista = findViewById(R.id.lv_custom);
        lista.setAdapter((ListAdapter) adapter);

        Button btfim = (Button) findViewById(R.id.btfinish);
        btfim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Produto> produtosSelecionados = adapter.getProdutosMarcados();
                Intent Int2 = new Intent(PedidosActivity.this, resultado.class);
                Int2.putExtra("selecionados", produtosSelecionados);
                startActivity(Int2);
            }
        });
    }



    }
