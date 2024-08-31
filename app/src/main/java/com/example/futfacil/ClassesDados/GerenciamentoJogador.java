package com.example.futfacil.ClassesDados;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoJogador {


    public static class Jogador {
        private String nome;
        private String sexo;
        private int peso;
        private int altura;
        private int idade;
        private String tipoDeJogo;
        private String posicao;
        private String descricao;

        // Construtor
        public Jogador(String nome, String sexo, int peso, int altura, int idade, String tipoDeJogo, String posicao, String descricao) {
            this.nome = nome;
            this.sexo = sexo;
            this.peso = peso;
            this.altura = altura;
            this.idade = idade;
            this.tipoDeJogo = tipoDeJogo;
            this.posicao = posicao;
            this.descricao = descricao;
        }

        // Getters e Setters
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        public int getPeso() {
            return peso;
        }

        public void setPeso(int peso) {
            this.peso = peso;
        }

        public int getAltura() {
            return altura;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }

        public String getTipoDeJogo() {
            return tipoDeJogo;
        }

        public void setTipoDeJogo(String tipoDeJogo) {
            this.tipoDeJogo = tipoDeJogo;
        }

        public String getPosicao() {
            return posicao;
        }

        public void setPosicao(String posicao) {
            this.posicao = posicao;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }
    }

    public static class ListaJogador {
        private static final List<Jogador> jogadores = new ArrayList<>();

        public void adicionarJogador(Jogador jogador) {
            jogadores.add(jogador);
        }

        public static List<Jogador> listarJogadores() {
            return jogadores;
        }
    }
}