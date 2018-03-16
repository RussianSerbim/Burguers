package com.example.cesmac.burguers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cesmac.burguers.Models.Produto;
import com.example.cesmac.burguers.Utls.ProdutoAdapter;

import java.util.ArrayList;

public class resultado extends AppCompatActivity {


    private ArrayList<Produto> produto = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Burguers");

        Intent intent = getIntent();
        produto = (ArrayList<Produto>) intent.getSerializableExtra("selecionados");
        final ProdutoAdapter adapter = new ProdutoAdapter(this, produto);
        ListView selecionados = findViewById(R.id.lv_custom2);
        selecionados.setAdapter((ListAdapter)adapter);
        double sum = 0;
        for (int i = 0; i < produto.size(); i++) {
            sum += produto.get(i).getPreco();
        }
        TextView total = findViewById(R.id.textView2);
        total.setText(String.valueOf(sum));
        Toast.makeText(this, "Produtos Selecionados: " + String.valueOf(produto.size()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }



}
