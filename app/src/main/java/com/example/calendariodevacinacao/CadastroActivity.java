package com.example.calendariodevacinacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calendariodevacinacao.controle.ManterCriancaActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CadastroActivity extends AppCompatActivity {

    EditText aliasemail;
    EditText aliassenha;
    Button aliasbnt;
    TextView aliaslink;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        firebaseAuth = FirebaseAuth.getInstance();

        aliasemail = findViewById(R.id.editemail);
        aliassenha = findViewById(R.id.editsenha);
        aliaslink = findViewById(R.id.textView2);
        aliasbnt = findViewById(R.id.bntinscrever);

        aliasbnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = aliasemail.getText().toString();
                String senha = aliassenha.getText().toString();

                if(email.isEmpty()){
                    aliasemail.setError("Digite um email, por favor.");
                    aliasemail.requestFocus();
                }
                else if (senha.isEmpty()){
                    aliassenha.setError("Digite uma senha, por favor.");
                    aliassenha.requestFocus();
                }

                else if(email.isEmpty() && senha.isEmpty()){
                    Toast.makeText(CadastroActivity.this, "Os campos estão vazios, por favor preencha.", Toast.LENGTH_SHORT).show();


                }else if(!(email.isEmpty() && senha.isEmpty())){
                    firebaseAuth.createUserWithEmailAndPassword(email, senha)
                            .addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = firebaseAuth.getCurrentUser();
                                        Toast.makeText(CadastroActivity.this, "Usuario criado com sucesso!.",
                                                Toast.LENGTH_SHORT).show();
                                        aliasemail.setText("");
                                        aliassenha.setText("");
                                        aliasbnt.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                Intent i = new Intent(CadastroActivity.this, ManterCriancaActivity.class);
                                                startActivity(i);
                                                finish();
                                            }
                                        });
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(CadastroActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                }


                else {
                    Toast.makeText(CadastroActivity.this, "Erro!!", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}
