package com.example.cesmac.burguers;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cesmac.burguers.Models.Produto;
import com.example.cesmac.burguers.Utls.ProdutoAdapter;

import java.util.ArrayList;

public class PedidosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.pedido);
        super.onCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.dm1);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawer, toolbar,R.string.menu_aberto,R.string.menu_fechado);
        drawer.addDrawerListener(toogle);
        toogle.syncState();
        NavigationView navi = findViewById(R.id.navi_v);
        navi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                long id = item.getItemId();
                if (id == R.id.exit2) {
                    SharedPreferences.Editor editor = getSharedPreferences("app",MODE_PRIVATE ).edit();
                    editor.remove("tusuario");
                    if (editor.commit()) {
                        finish();
                        System.exit(0);
                    }


                } else if (id == R.id.perfil) {

                }

                return true;
            }
        });


        final ArrayList<Produto> produto = new ArrayList<Produto>();

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
        lista.setItemsCanFocus(false);

        final FrameLayout frameLayout = findViewById(R.id.framelayout_pedidos);

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Produto produto1 = produto.get(position);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.framelayout_pedidos, new Detalhes(produto1))
                        .commit();

                frameLayout.setVisibility(View.VISIBLE);

                return true;
            }
        });

        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameLayout.setVisibility(View.INVISIBLE);
            }
        });


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
