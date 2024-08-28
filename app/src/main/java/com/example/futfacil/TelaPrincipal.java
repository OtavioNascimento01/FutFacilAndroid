package com.example.futfacil;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.futfacil.databinding.ActivityMainBinding;
import com.example.futfacil.databinding.TelaPrincipalBinding;

public class TelaPrincipal extends AppCompatActivity {

    private TelaPrincipalBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializa o binding usando o método inflate()
        binding = TelaPrincipalBinding.inflate(getLayoutInflater());

        // Define o layout da Activity com a raiz do binding
        View view = binding.getRoot();
        setContentView(view);

        //definindo cliques
        binding.imgChuteiraBola.setOnClickListener(v -> buscarJogador());
        binding.txtBuscarJogador.setOnClickListener(v -> buscarJogador());
        binding.txtBuscarJogador2.setOnClickListener(v -> buscarJogador());

        binding.imgLupa.setOnClickListener(v -> encontrarPartida());
        binding.txtEncontrarPartida.setOnClickListener(v -> encontrarPartida());
        binding.txtEncontrarPartida2.setOnClickListener(v -> encontrarPartida());

        binding.imgCriarPartida.setOnClickListener(v -> criarPartida());
        binding.txtCriarPartida.setOnClickListener(v -> criarPartida());
        binding.txtCriarPartida2.setOnClickListener(v -> criarPartida());

        binding.imgCriarJogador.setOnClickListener(v -> criarJogador());
        binding.txtCriarJogador.setOnClickListener(v -> criarJogador());
        binding.txtCriarJogador2.setOnClickListener(v -> criarJogador());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }




        private void buscarJogador () {
            Intent intent = new Intent(this, BuscarJogador.class);
            startActivity(intent);
        }
        private void encontrarPartida () {
            Intent intent = new Intent(this, EncontrarPartida.class);
            startActivity(intent);
        }
        private void criarJogador () {
            Intent intent = new Intent(this, CriarJogador.class);
            startActivity(intent);
        }
        private void criarPartida () {
            Intent intent = new Intent(this, CriarPartida.class);
            startActivity(intent);
        }


    }

