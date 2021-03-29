package com.example.calendariodevacinacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {


    TextView aliasNomeUsuario;
    Button aliasbntLogout;
    TextView aliasnomecrianca;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        aliasnomecrianca = findViewById(R.id.nomecrianca);
        aliasbntLogout = findViewById(R.id.logout);

     // aliasnomecrianca userId = firebaseDatabase.auth().currentUser.uid;
     //  return firebaseDatabase.database().ref('/users/' + userId).once('value').then((snapshvot) => {
       //       aliasnomecrianca = (snapshot.val() && snapshot.val().username) || 'Anonymous';
        // ...
//});


        aliasbntLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intomain = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intomain);
            }
        });



    }
}
