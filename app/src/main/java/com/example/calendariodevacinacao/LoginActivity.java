package com.example.calendariodevacinacao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calendariodevacinacao.FirebaseConex.Conexao;
import com.example.calendariodevacinacao.controle.ManterCriancaActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {



    EditText aliasemail;
    EditText aliassenha;
    Button aliasbntlogin;
    TextView aliaslink2;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        aliasemail = findViewById(R.id.adicionarEmail);
        aliassenha = findViewById(R.id.adicionarSenha);
       // aliaslink2 = findViewById(R.id.textview);
        aliasbntlogin = findViewById(R.id.gerarLogin);

        aliasbntlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = aliasemail.getText().toString().trim();
                String senha = aliassenha.getText().toString().trim();
                login(email, senha);
            }

            private void login(String email, String senha) {

                auth.signInWithEmailAndPassword(email, senha)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Intent i=new Intent(getBaseContext(), HomeActivity.class);
                                    startActivity(i);
                                    UsuarioLogado();

                                }
                                else
                                {
                                    Toast.makeText(getBaseContext(), "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
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
