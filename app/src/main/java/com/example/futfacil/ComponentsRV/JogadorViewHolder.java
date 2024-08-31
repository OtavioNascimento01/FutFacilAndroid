package com.example.futfacil.ComponentsRV;

import androidx.recyclerview.widget.RecyclerView;
import com.example.futfacil.databinding.ItemJogadorBinding;
import com.example.futfacil.ClassesDados.GerenciamentoJogador.Jogador;

public class JogadorViewHolder extends RecyclerView.ViewHolder {
    private final ItemJogadorBinding binding;

    public JogadorViewHolder(ItemJogadorBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Jogador jogador) {
        binding.etNomeJogadorRv.setText(jogador.getNome());
        binding.etIdadeRv.setText(String.valueOf(jogador.getIdade()));
        binding.etTipoJogoRv.setText(jogador.getTipoDeJogo());
        binding.etPosicaoRv.setText(jogador.getPosicao());
    }
}
