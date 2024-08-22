package com.example.futfacil;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TelaRegistro extends AppCompatActivity {

    private EditText etUsuario, etNomeCompleto, etSenha, etConfirmarSenha, etEmail, etConfirmarEmail, etCpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_registro);

        etUsuario = findViewById(R.id.ptxtUsuarioRegistro);
        etNomeCompleto = findViewById(R.id.ptxtNome);
        etSenha = findViewById(R.id.ptxtSenhaRegistro);
        etConfirmarSenha = findViewById(R.id.ptxtSenhaRegistroC);
        etEmail = findViewById(R.id.ptxtEmailRegistro);
        etConfirmarEmail = findViewById(R.id.ptxtEmailRegistroC);
        etCpf = findViewById(R.id.ptxtCpf);
    }

    public void registrar(View view) {
        String usuario = etUsuario.getText().toString();
        String nomeCompleto = etNomeCompleto.getText().toString();
        String senha = etSenha.getText().toString();
        String confirmarSenha = etConfirmarSenha.getText().toString();
        String email = etEmail.getText().toString();
        String confirmarEmail = etConfirmarEmail.getText().toString();
        String cpf = etCpf.getText().toString();

        if (!senha.equals(confirmarSenha)) {
            Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!email.equals(confirmarEmail)) {
            Toast.makeText(this, "Os e-mails não coincidem", Toast.LENGTH_SHORT).show();
            return;
        }

        GerenciamentoUsuario.Usuario novoUsuario = new GerenciamentoUsuario.Usuario(usuario ,nomeCompleto, senha, email, cpf);
        GerenciamentoUsuario.ListaUsuario.adicionarUsuario(novoUsuario);

        Toast.makeText(this, "Usuário registrado com sucesso!", Toast.LENGTH_SHORT).show();

        finish();
    }
}