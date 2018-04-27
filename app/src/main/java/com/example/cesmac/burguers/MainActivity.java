package com.example.cesmac.burguers;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cesmac.burguers.Models.Produto;
import com.example.cesmac.burguers.Utls.ProdutoAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String id = "burger";
            String name = "burger";
            String description = "burger";


            NotificationManager notifManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel mChannel = notifManager.getNotificationChannel(id);
            if (mChannel == null) {
                mChannel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH);
                mChannel.setDescription(description);
                mChannel.enableVibration(true);
                mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                notifManager.createNotificationChannel(mChannel);
            }
        }


        final Intent intent = new Intent(MainActivity.this,PedidosActivity.class);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = getSharedPreferences("app",MODE_PRIVATE);
        if (!preferences.getString("tusuario", "").equals("")) {
            startActivity(intent);
        }
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
                    startActivity(intent);
                    SharedPreferences preferences = getSharedPreferences("app",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("tusuario", "felipe");
                    editor.apply();
                }else
                    alert("Incorrect username or password! ");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_op, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent int3 = new Intent(MainActivity.this, cadastro.class );
        if(item.getItemId() == R.id.cada) {
            startActivity(int3);
        }
        if(item.getItemId() == R.id.exit) {
            finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }

    private void alert (String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

    }

}
