package com.example.futfacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tela_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void login(View view) {
        TextInputEditText usuario = findViewById(R.id.ptxtUsuario);
        TextInputEditText senha = findViewById(R.id.ptxtSenha);

        String usuarioTexto = usuario.getText().toString();
        String senhaTexto = senha.getText().toString();

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
            Intent intent = new Intent(this, TelaPrincipal.class); // Substitua TelaPrincipal pela sua tela principal
            startActivity(intent);
        } else {
            // Login falhou, exibir mensagem de erro
            Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
        }
    }

    public void abrirTelaRegistro(View view) {
        Intent intent = new Intent(this, TelaRegistro.class);
        startActivity(intent);    }

}