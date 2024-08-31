package com.example.futfacil.Telas;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.futfacil.ClassesDados.GerenciamentoJogador;
import com.example.futfacil.ComponentsRV.JogadorAdapter;
import com.example.futfacil.databinding.BuscarJogadorBinding;

public class BuscarJogador extends AppCompatActivity {

    private BuscarJogadorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializa o binding usando o método inflate()
        binding = BuscarJogadorBinding.inflate(getLayoutInflater());

        // Define o layout da Activity com a raiz do binding
        View view = binding.getRoot();
        setContentView(view);

        JogadorAdapter adapter = new JogadorAdapter(GerenciamentoJogador.ListaJogador.listarJogadores());
        binding.rvJogadores.setLayoutManager(new LinearLayoutManager(this));
        binding.rvJogadores.setAdapter(adapter);

    }
}