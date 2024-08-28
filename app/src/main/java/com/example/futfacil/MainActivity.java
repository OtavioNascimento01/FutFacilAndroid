package com.example.futfacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.futfacil.databinding.TelaLoginBinding;

public class MainActivity extends AppCompatActivity {

    private TelaLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Inicializar o ViewBinding
        binding = TelaLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Apenas para testes no app
        GerenciamentoUsuario.ListaUsuario.inicializarUsuarioTeste();

        // Configuração do botão de login
        binding.btnLogin.setOnClickListener(this::login);
    }

    public void login(View view) {
        String usuarioTexto = binding.etUsuario.getText().toString();
        String senhaTexto = binding.etSenha.getText().toString();

        if (usuarioTexto.isEmpty() || senhaTexto.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha ambos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificar se o usuário e a senha estão corretos na lista de usuários
        GerenciamentoUsuario.Usuario usuarioEncontrado = null;
        for (GerenciamentoUsuario.Usuario u : GerenciamentoUsuario.ListaUsuario.listarUsuarios()) {
            if (u.getUsuario().equals(usuarioTexto) && u.getSenha().equals(senhaTexto)) {
                usuarioEncontrado = u;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            // Login bem-sucedido, redirecionar para a tela principal
            Intent intent = new Intent(this, TelaPrincipal.class);
            startActivity(intent);
        } else {
            // Login falhou, exibir mensagem de erro
            Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
        }
    }

    public void abrirTelaRegistro(View view) {
        Intent intent = new Intent(this, TelaRegistro.class);
        startActivity(intent);
    }
}
