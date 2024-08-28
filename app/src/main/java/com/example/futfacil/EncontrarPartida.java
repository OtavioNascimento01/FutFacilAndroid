package com.example.futfacil;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewbinding.ViewBinding;

import com.example.futfacil.databinding.EncontrarPartidaBinding;
import com.example.futfacil.databinding.TelaPrincipalBinding;

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
    }


}