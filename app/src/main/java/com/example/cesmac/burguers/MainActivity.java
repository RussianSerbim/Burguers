package com.example.cesmac.burguers;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

                if (usuario.equals("Felipe")&& senha.equals("123")){
                    alert("Login successfully completed!");
                }
                else
                    alert("Incorrect username or password! ");

            }
        });
    }

    private void alert (String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

    }
}
