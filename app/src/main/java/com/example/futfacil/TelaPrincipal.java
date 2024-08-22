package com.example.futfacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TelaPrincipal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);
    }
    private void buscarJogador(View view) {
        Intent intent = new Intent(this, BuscarJogador.class);
        startActivity(intent);
    }
    private void encontrarPartida(View view) {
        Intent intent = new Intent(this, EncontrarPartida.class);
        startActivity(intent);
    }
    private void criarJogador(View view) {
        Intent intent = new Intent(this, CriarJogador.class);
        startActivity(intent);
    }
    private void criarPartida(View view) {
        Intent intent = new Intent(this, CriarPartida.class);
        startActivity(intent);
    }
}
