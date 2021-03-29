package com.example.calendariodevacinacao.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.example.calendariodevacinacao.R;
import com.example.calendariodevacinacao.modelo.Calendario;
import com.example.calendariodevacinacao.modelo.Crianca;
import com.example.calendariodevacinacao.modelo.Vacina;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CalendarioView extends AppCompatActivity {


    EditText aliasViewCalendario;
    Crianca crianca;
    Vacina vacina;
    Calendario calendario;
    EditText aliascdata_nasc;




    //Firebase Database Realtime
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_calendario_view);
       // aliascdata_nasc =findViewById(R.id.editText2);


        SimpleDateFormat formatadorBr = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        iniciarVacinas();
    }


    private void iniciarVacinas() {
        crianca = new Crianca();

        GregorianCalendar data_nascimento = new GregorianCalendar();
        data_nascimento.add(Calendar.DAY_OF_MONTH, 30);
        System.out.println(data_nascimento.getTime());
    }


}
