package com.example.cesmac.burguers;

import android.app.ActionBar;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cesmac.burguers.Models.Produto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btlogin = (Button) findViewById(R.id.btlogin);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView usuario = (TextView) findViewById(R.id.temail);
                TextView senha = (TextView) findViewById(R.id.tsenha);
                String tusuario = usuario.getText().toString();
                String tsenha = senha.getText().toString();
                if (tusuario.equals("felipe")&& tsenha.equals("123")){
                    alert("Login successfully completed!");
                }else
                    alert("Incorrect username or password! ");
            }
        });

        ArrayList<Produto> produto = new ArrayList<Produto>();

        produto.add(new Produto(R.drawable.blackbeef, "Black Beef", 25));
        produto.add(new Produto(R.drawable.italiano, "Italiano", 20));
        produto.add(new Produto(R.drawable.saladadefrango,"Salada de Frango",  15));
        produto.add(new Produto(R.drawable.natural, "Natural",  18));
        produto.add(new Produto(R.drawable.agua,"Agua Mineral",  3));
        produto.add(new Produto(R.drawable.refrilatas, "Refrigerante Lata", 4));
        produto.add(new Produto(R.drawable.refrilitro,  "Refrigerante Litro",  7));
        produto.add(new Produto(R.drawable.whopperduplocomqueijo, "Whopper Duplo com Queijo", 22));

        ListView lista = findViewById(R.id.lv_custom);
    }

    private void alert (String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

    }

}
