package com.example.futfacil.Telas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.futfacil.ClassesDados.GerenciamentoPartida;
import com.example.futfacil.R;
import com.example.futfacil.databinding.CriarPartidaBinding;

public class CriarPartida extends AppCompatActivity {

    private CriarPartidaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inicializa o binding usando o método inflate()
        binding = CriarPartidaBinding.inflate(getLayoutInflater());

        // Define o layout da Activity com a raiz do binding
        setContentView(binding.getRoot());

        //GerenciamentoPartida.ListaPartida.inicializarPartidaTeste();

        // Configuração do Spinner "Tipo de Jogo"
        ArrayAdapter<CharSequence> adapterTipoJogo = ArrayAdapter.createFromResource(this,
                R.array.tipoJogo, android.R.layout.simple_spinner_item);
        adapterTipoJogo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spTipoJogo2.setAdapter(adapterTipoJogo);

        // Botão "Criar Jogador"
        binding.btnCriarPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarPartida();
            }
        });

    }

    // Método para criar um novo jogador
    private void criarPartida() {
        String nomePartida = binding.etNomePartida.getText().toString();
        String tipoJogo = binding.spTipoJogo2.getSelectedItem().toString();
        String nivelJogo = binding.spNivelJogo.getSelectedItem().toString();
        String enderecoPartida = binding.etEnderecoPartida.getText().toString();
        String descricaoPartida = binding.etDescricao2.getText().toString();


        if (nomePartida.isEmpty() || enderecoPartida.isEmpty() || descricaoPartida.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos corretamente.", Toast.LENGTH_SHORT).show();
            return;
        }

        GerenciamentoPartida.Partida partida = new GerenciamentoPartida.Partida(nomePartida, tipoJogo, nivelJogo, enderecoPartida, descricaoPartida);

        GerenciamentoPartida.ListaPartida listaPartida = new GerenciamentoPartida.ListaPartida();
        listaPartida.adicionarPartida(partida);

        Toast.makeText(this, "Partida criada com sucesso!", Toast.LENGTH_SHORT).show();

        // Limpa os campos após a criação da partida
        binding.etNomePartida.setText("");
        binding.etEnderecoPartida.setText("");
        binding.spNivelJogo.setSelection(0);
        binding.spTipoJogo2.setSelection(0);
        binding.etDescricao2.setText("");

        Intent intent = new Intent(this, TelaPrincipal.class);
        startActivity(intent);
    }
}