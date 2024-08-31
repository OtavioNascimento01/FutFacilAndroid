package com.example.futfacil.ComponentsRV;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.futfacil.ClassesDados.GerenciamentoPartida.Partida;
import com.example.futfacil.databinding.ItemPartidaBinding;
import java.util.List;

public class PartidaAdapter extends RecyclerView.Adapter<PartidaViewHolder> {
    private final List<Partida> partidas;

    public PartidaAdapter(List<Partida> partidas) {
        this.partidas = partidas;
    }

    @NonNull
    @Override
    public PartidaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemPartidaBinding binding = ItemPartidaBinding.inflate(inflater, parent, false);
        return new PartidaViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PartidaViewHolder holder, int position) {
        Partida partida = partidas.get(position);
        holder.bind(partida);
    }

    @Override
    public int getItemCount() {
        return partidas.size();
    }
}
