package br.com.etecia.gingerbread;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

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
        cafeLista.add(new Products("Café Preto", R.drawable.coffee, "Café", 5, R.drawable.ic_baseline_favorite));
        cafeLista.add(new Products("Café Preto", R.drawable.coffee, "Café", 5, R.drawable.ic_baseline_favorite));
        cafeLista.add(new Products("Café Preto", R.drawable.coffee, "Café", 5, R.drawable.ic_baseline_favorite));
        cafeLista.add(new Products("Café Preto", R.drawable.coffee, "Café", 5, R.drawable.ic_baseline_favorite));
        cafeLista.add(new Products("Café Preto", R.drawable.coffee, "Café", 5, R.drawable.ic_baseline_favorite));
        cafeLista.add(new Products("Café Preto", R.drawable.coffee, "Café", 5, R.drawable.ic_baseline_favorite));


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

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                nomeCafe = itemView.findViewById(R.id.txtNome);
                fotoCafe = itemView.findViewById(R.id.imgComida);
                descricaoCafe = itemView.findViewById(R.id.txtDescricao);
                notaCafe = itemView.findViewById(R.id.RatingBar);
                favCafe = itemView.findViewById(R.id.imgFavorite);
            }
        }
    }
}