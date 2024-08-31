package com.example.futfacil.ComponentsRV;

import androidx.recyclerview.widget.RecyclerView;
import com.example.futfacil.databinding.ItemPartidaBinding;
import com.example.futfacil.ClassesDados.GerenciamentoPartida.Partida;

public class PartidaViewHolder extends RecyclerView.ViewHolder {
    private final ItemPartidaBinding binding;

    public PartidaViewHolder(ItemPartidaBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Partida partida) {
        binding.etNomePartidaRv.setText(partida.getNomePartida());
        binding.etEndPartidaRv.setText(partida.getEnderecoPartida());
        binding.etTipoJogoRv2.setText(partida.getTipoJogo());
        binding.etNivelJogoRv2.setText(partida.getNivelJogo());
    }
}
