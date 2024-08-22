package com.example.futfacil;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoUsuario {

    public static class Usuario {
        private String usuario;
        private String nome;
        private String senha;
        private String email;
        private String cpf;

        // Construtor
        public Usuario(String usuario, String nome, String senha, String email, String cpf) {
            this.usuario = usuario;
            this.nome = nome;
            this.senha = senha;
            this.email = email;
            this.cpf = cpf;
        }

        // Getters e Setters
        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }

    public static class ListaUsuario {
        private static final List<Usuario> usuarios = new ArrayList<>();

        public static void adicionarUsuario(Usuario usuario) {
            usuarios.add(usuario);
        }

        public static List<Usuario> listarUsuarios() {
            return usuarios;
        }
    }
}
