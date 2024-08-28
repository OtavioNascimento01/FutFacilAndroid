package com.example.futfacil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.futfacil.databinding.TelaRegistroBinding;

public class TelaRegistro extends AppCompatActivity {

    private TelaRegistroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = TelaRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adicionarUsuarioParaTeste();
    }

    public void registrar(View view) {
        String usuario = binding.etUsuarioRegistro.getText().toString();
        String nomeCompleto = binding.etNome.getText().toString();
        String senha = binding.etSenhaRegistro.getText().toString();
        String confirmarSenha = binding.etSenhaRegistroC.getText().toString();
        String email = binding.etEmailRegistro.getText().toString();
        String confirmarEmail = binding.etEmailRegistroC.getText().toString();
        String cpf = binding.etCpf.getText().toString();

        // Verificação de preenchimento dos campos
        if (usuario.isEmpty() || nomeCompleto.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty() ||
                email.isEmpty() || confirmarEmail.isEmpty() || cpf.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificação se as senhas coincidem
        if (!senha.equals(confirmarSenha)) {
            Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificação se os e-mails coincidem
        if (!email.equals(confirmarEmail)) {
            Toast.makeText(this, "Os e-mails não coincidem", Toast.LENGTH_SHORT).show();
            return;
        }

        // Criação e adição do novo usuário
        GerenciamentoUsuario.Usuario novoUsuario = new GerenciamentoUsuario.Usuario(usuario, nomeCompleto, senha, email, cpf);
        GerenciamentoUsuario.ListaUsuario.adicionarUsuario(novoUsuario);

        Toast.makeText(this, "Usuário registrado com sucesso!", Toast.LENGTH_SHORT).show();

        finish();
    }

    public void adicionarUsuarioParaTeste() {
        String usuario = "admin";
        String nomeCompleto = "Teste Nome Completo";
        String senha = "1";
        String email = "teste@exemplo.com";
        String cpf = "12345678901";

        GerenciamentoUsuario.Usuario novoUsuario = new GerenciamentoUsuario.Usuario(usuario, nomeCompleto, senha, email, cpf);
        GerenciamentoUsuario.ListaUsuario.adicionarUsuario(novoUsuario);
    }
}
