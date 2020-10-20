package com.example.calendariodevacinacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calendariodevacinacao.controle.ManterCalendario;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    ImageView aliasbntcalendario;

    TextView aliasNomeUsuario;
    Button aliasbntLogout;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        aliasbntcalendario = findViewById(R.id.imgcalendario);
        aliasNomeUsuario = findViewById(R.id.editText);

        aliasbntLogout = findViewById(R.id.button3);

        aliasbntLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intomain = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intomain);
            }
        });

        aliasbntcalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intocal = new Intent(HomeActivity.this, ManterCalendario.class);
                startActivity(intocal);

            }
        });

    }
}
