package com.example.calendariodevacinacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.calendariodevacinacao.FirebaseConex.Conexao;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button aliasbntmain;
    Button aliasbntmain2;
    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aliasbntmain =findViewById(R.id.button4);
        aliasbntmain2 = findViewById(R.id.button);





        aliasbntmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intc= new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intc);
            }
        });

        aliasbntmain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intl = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intl);

            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        auth= Conexao.getFirebaseAuth();
        FirebaseUser currentUser = auth.getCurrentUser();
        if(currentUser!= null){
            UsuarioLogado();
        }
    }

    private void UsuarioLogado() {
        Intent intent =new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }


}

