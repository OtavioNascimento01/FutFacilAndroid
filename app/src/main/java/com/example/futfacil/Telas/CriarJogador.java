package com.example.futfacil.Telas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.futfacil.ClassesDados.GerenciamentoJogador;
import com.example.futfacil.R;
import com.example.futfacil.databinding.CriarJogadorBinding;

public class CriarJogador extends AppCompatActivity {

    private CriarJogadorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inicializa o binding usando o método inflate()
        binding = CriarJogadorBinding.inflate(getLayoutInflater());

        // Define o layout da Activity com a raiz do binding
        setContentView(binding.getRoot());

        // Configuração do Spinner "Tipo de Jogo"
        ArrayAdapter<CharSequence> adapterTipoJogo = ArrayAdapter.createFromResource(this,
                R.array.tipoJogo, android.R.layout.simple_spinner_item);
        adapterTipoJogo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spTipoJogo.setAdapter(adapterTipoJogo);

        // Listener para o Spinner "Tipo de Jogo" para atualizar as posições
        binding.spTipoJogo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tipoSelecionado = parent.getItemAtPosition(position).toString();
                atualizarPosicoes(tipoSelecionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nenhuma ação necessária
            }
        });

        // Botão "Criar Jogador"
        binding.btnCriarJogador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarJogador();
            }
        });

        // Inicializa as posições do "Spinner Posicao" com "Campo" como padrão
        atualizarPosicoes("Campo");
    }

    // Método para atualizar as posições do Spinner "Posicao" de acordo com o tipo de jogo
    private void atualizarPosicoes(String tipoSelecionado) {
        int arrayId;
        switch (tipoSelecionado) {
            case "Campo":
                arrayId = R.array.posicoes_campo;
                break;
            case "Futsal":
                arrayId = R.array.posicoes_futsal;
                break;
            case "Society":
                arrayId = R.array.posicoes_society;
                break;
            default:
                arrayId = R.array.posicoes_campo;
        }
        ArrayAdapter<CharSequence> adapterPosicoes = ArrayAdapter.createFromResource(this,
                arrayId, android.R.layout.simple_spinner_item);
        adapterPosicoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spPosicao.setAdapter(adapterPosicoes);
    }

    // Método para criar um novo jogador
    private void criarJogador() {
        String nome = binding.etNomeJogador.getText().toString();
        String sexo = binding.spSexo.getSelectedItem().toString();
        int altura = Integer.parseInt(binding.etAltura.getText().toString());
        int peso = Integer.parseInt(binding.etPeso.getText().toString());
        int idade = Integer.parseInt(binding.etIdade.getText().toString());
        String tipoJogo = binding.spTipoJogo.getSelectedItem().toString();
        String posicao = binding.spPosicao.getSelectedItem().toString();
        String descricao = binding.etDescricao.getText().toString();

        if (nome.isEmpty() || sexo.isEmpty() || altura <= 0 || peso <= 0 || idade <= 0) {
            Toast.makeText(this, "Por favor, preencha todos os campos corretamente.", Toast.LENGTH_SHORT).show();
            return;
        }

        GerenciamentoJogador.Jogador jogador = new GerenciamentoJogador.Jogador(nome, sexo, peso, altura, idade, tipoJogo, posicao, descricao);

        GerenciamentoJogador.ListaJogador listaJogador = new GerenciamentoJogador.ListaJogador();
        listaJogador.adicionarJogador(jogador);

        Toast.makeText(this, "Jogador criado com sucesso!", Toast.LENGTH_SHORT).show();

        // Limpa os campos após a criação do jogador
        binding.etNomeJogador.setText("");
        binding.spSexo.setSelection(0);
        binding.etAltura.setText("");
        binding.etPeso.setText("");
        binding.etIdade.setText("");
        binding.spTipoJogo.setSelection(0);
        binding.spPosicao.setSelection(0);
        binding.etDescricao.setText("");

        Intent intent = new Intent(this, TelaPrincipal.class);
        startActivity(intent);
    }
}