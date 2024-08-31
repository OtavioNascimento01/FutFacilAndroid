package com.example.futfacil.Telas;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.futfacil.ClassesDados.GerenciamentoPartida;
import com.example.futfacil.ComponentsRV.PartidaAdapter;
import com.example.futfacil.databinding.EncontrarPartidaBinding;

public class EncontrarPartida extends AppCompatActivity {

    private EncontrarPartidaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializa o binding usando o método inflate()
        binding = EncontrarPartidaBinding.inflate(getLayoutInflater());

        // Define o layout da Activity com a raiz do binding
        View view = binding.getRoot();
        setContentView(view);

        PartidaAdapter adapter = new PartidaAdapter(GerenciamentoPartida.ListaPartida.listarPartidas());
        binding.rvPartidas.setLayoutManager(new LinearLayoutManager(this));
        binding.rvPartidas.setAdapter(adapter);
    }
}