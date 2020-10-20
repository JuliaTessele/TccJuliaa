package com.example.calendariodevacinacao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.calendariodevacinacao.R;
import com.example.calendariodevacinacao.modelo.Vacina;

import java.util.ArrayList;
import java.util.List;



public class AdapterCarimbos extends RecyclerView.Adapter<AdapterCarimbos.ViewHolder> {

    static List<Vacina> vacinas;
    static Context context;

    public AdapterCarimbos(Context context, List<Vacina> ordenhas) {
        this.vacinas = new ArrayList<Vacina>();
        this.context = context;
        this.vacinas = vacinas;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carimbo, null);

        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
      //  holder.txtNome.setText(vacinas.get(position).toString().nome);
       // holder.txtQuantidade.setText(String.valueOf(vacinas.get(position).quantidade));

        if (vacinas.get(position).getId_vacina().toString() != null) {
         //   Bitmap bitmap = BitmapFactory.decodeByteArray(vacinas.get(position).getId_vacina().toString(),0,vacinas.get(position).getId_vacina().toString().leng th);
         //   holder.imageView.setImageBitmap(bitmap);
        } else {
        //    holder.imageView.setImageResource(R.drawable.cow);
        }
    }

    @Override
    public int getItemCount() {
        return vacinas.size();
    }

    public static class  ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtNome, txtQuantidade;
        public ImageView imageView;

        public ViewHolder (View itemLayoutView) {
            super(itemLayoutView);
            txtQuantidade = (TextView) itemLayoutView.findViewById(R.id.txtDataAplicação);
            txtNome = (TextView) itemLayoutView.findViewById(R.id.txtNomeVacina);
            //imageView = (ImageView) itemLayoutView.findViewById(R.id.imagemCarimbo);
        }
    }
}
