package com.example.calendariodevacinacao.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calendariodevacinacao.FirebaseConex.Conexao;
import com.example.calendariodevacinacao.HomeActivity;
import com.example.calendariodevacinacao.R;
import com.example.calendariodevacinacao.modelo.Crianca;
import com.example.calendariodevacinacao.modelo.Responsavel;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class ManterCriancaActivity extends AppCompatActivity {

    EditText aliasnome, aliasdata_nasc;
    Button aliasbntcrianca;
    Crianca crianca;
    Responsavel responsavel;

    //Firebase Database Realtime
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    // Firebase Autenticação (classe conexão simplifaca a codificação
    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manter_crianca);

        aliasnome = findViewById(R.id.adicionarEmail);
        aliasdata_nasc = findViewById(R.id.adicionarSenha);
        aliasbntcrianca = findViewById(R.id.gerarLogin);


        crianca = new Crianca();
        responsavel = new Responsavel();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        final String a = user.getUid();
        inicializarFirebase();
        eventoDatabase();

        aliasbntcrianca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crianca = new Crianca();
                responsavel = new Responsavel();
                crianca.setId_crianca(UUID.randomUUID().toString());
                crianca.setNome(aliasnome.getText().toString());
                crianca.setData_nasc(aliasdata_nasc.getText().toString());
              //  crianca.setPeriodo(periodo1.getBaseContext().toString());


             //  DateTime dateTime = DateTimeFormat.forPattern("dd-MM-yyyy").parseDateTime(aliasdata_nasc.getText().toString());
               // DateTime periodo1 = dateTime.plusMonths(2);


                databaseReference.child(Conexao.getFirebaseUser().getUid()).setValue(crianca);


                Toast.makeText(ManterCriancaActivity.this, "SALVO COM SUCESSO", Toast.LENGTH_LONG).show();
                Intent inthome = new Intent(ManterCriancaActivity.this, HomeActivity.class);
                startActivity(inthome);



            }
        });


    }

    private void eventoDatabase() {
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(ManterCriancaActivity.this);
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("usuarios");
        //utilizado para funcionar Offline - testar
       // firebaseDatabase.setPersistenceEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth= Conexao.getFirebaseAuth();
        user=Conexao.getFirebaseUser();

    }
}
