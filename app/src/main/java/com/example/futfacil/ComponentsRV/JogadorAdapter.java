package com.example.futfacil.ComponentsRV;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.futfacil.ClassesDados.GerenciamentoJogador.Jogador;
import com.example.futfacil.databinding.ItemJogadorBinding;
import java.util.List;

public class JogadorAdapter extends RecyclerView.Adapter<JogadorViewHolder> {
    private final List<Jogador> jogadores;

    public JogadorAdapter(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    @NonNull
    @Override
    public JogadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemJogadorBinding binding = ItemJogadorBinding.inflate(inflater, parent, false);
        return new JogadorViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull JogadorViewHolder holder, int position) {
        Jogador jogador = jogadores.get(position);
        holder.bind(jogador);
    }

    @Override
    public int getItemCount() {
        return jogadores.size();
    }
}
