package br.com.etecia.gingerbread;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CoffeFragment extends Fragment {
    RecyclerView recyclerView;
    List<Products> cafeLista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_coffe, container, false);

        recyclerView = v.findViewById(R.id.rvCoffe);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.hasFixedSize();

        cafeLista = new ArrayList<>();
        cafeLista.add(new Products("Café Preto", R.drawable.coffee, "Café", 2, R.drawable.ic_baseline_favorite));
        cafeLista.add(new Products("Café com Leite", R.drawable.coffee, "Café", 3, R.drawable.ic_baseline_favorite));
        cafeLista.add(new Products("Capuccino", R.drawable.coffee, "Café", 5, R.drawable.ic_baseline_favorite));
        cafeLista.add(new Products("Frapuccino ", R.drawable.coffee, "Café", 5, R.drawable.ic_baseline_favorite));
        cafeLista.add(new Products("Café com Nutella", R.drawable.coffee, "Café", 5, R.drawable.ic_baseline_favorite));
        cafeLista.add(new Products("Café Expresso", R.drawable.coffee, "Café", 5, R.drawable.ic_baseline_favorite));

        CoffeAdapter coffeAdapter = new CoffeAdapter(getContext(), cafeLista);
        recyclerView.setAdapter(coffeAdapter);

        return v;
    }

    public class CoffeAdapter extends RecyclerView.Adapter<CoffeAdapter.ViewHolder> {

        private Context context;
        private List<Products> cafeLista;

        public CoffeAdapter(Context context, List<Products> cafeLista) {
            this.context = context;
            this.cafeLista = cafeLista;
        }

        @NonNull
        @Override
        public CoffeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view;
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.modelo_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CoffeAdapter.ViewHolder holder, int position) {
            holder.nomeCafe.setText(cafeLista.get(position).getNomeCafe());
            holder.fotoCafe.setImageResource(cafeLista.get(position).getImagemCafe());
            holder.descricaoCafe.setText(cafeLista.get(position).getDescricaoCafe());
            holder.notaCafe.setNumStars(cafeLista.get(position).getRatingCafe());
            holder.favCafe.setImageResource(cafeLista.get(position).getFavorite());
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ModeloDetalhes.class);
                    intent.putExtra("Café", cafeLista.get(holder.getAdapterPosition()).getNomeCafe());
                    intent.putExtra("Foto Café", cafeLista.get(holder.getAdapterPosition()).getImagemCafe());
                    intent.putExtra("Descrição", cafeLista.get(holder.getAdapterPosition()).getDescricaoCafe());
                    intent.putExtra("Nota Café", cafeLista.get(holder.getAdapterPosition()).getRatingCafe());
                    intent.putExtra("Favorito", cafeLista.get(holder.getAdapterPosition()).getFavorite());
                    startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    //Toast.makeText(context, cafeLista.get(holder.getAdapterPosition()).getNomeCafe(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return cafeLista.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView nomeCafe;
            ImageView fotoCafe;
            TextView descricaoCafe;
            RatingBar notaCafe;
            ImageView favCafe;
            CardView cardView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                nomeCafe = itemView.findViewById(R.id.txtNome);
                fotoCafe = itemView.findViewById(R.id.imgComida);
                descricaoCafe = itemView.findViewById(R.id.txtDescricao);
                notaCafe = itemView.findViewById(R.id.RatingBar);
                favCafe = itemView.findViewById(R.id.imgFavorite);
                cardView = itemView.findViewById(R.id.idModelo);
            }
        }
    }
}