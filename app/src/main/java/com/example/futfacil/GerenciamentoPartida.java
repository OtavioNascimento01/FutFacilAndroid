package com.example.futfacil;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoPartida {

    public static class Partida{
        private String nomePartida;
        private String tipoJogo;
        private String nivelJogo;
        private String enderecoPartida;
        private String descricaoPartida;

        public String getNomePartida() {
            return nomePartida;
        }

        public void setNomePartida(String nomePartida) {
            this.nomePartida = nomePartida;
        }

        public String getTipoJogo() {
            return tipoJogo;
        }

        public void setTipoJogo(String tipoJogo) {
            this.tipoJogo = tipoJogo;
        }

        public String getNivelJogo() {
            return nivelJogo;
        }

        public void setNivelJogo(String nivelJogo) {
            this.nivelJogo = nivelJogo;
        }

        public String getEnderecoPartida() {
            return enderecoPartida;
        }

        public void setEnderecoPartida(String enderecoPartida) {
            this.enderecoPartida = enderecoPartida;
        }

        public String getDescricaoPartida() {
            return descricaoPartida;
        }

        public void setDescricaoPartida(String descricaoPartida) {
            this.descricaoPartida = descricaoPartida;
        }

        public Partida(String nomePartida, String descricaoPartida, String enderecoPartida, String nivelJogo, String tipoJogo) {
            this.nomePartida = nomePartida;
            this.descricaoPartida = descricaoPartida;
            this.enderecoPartida = enderecoPartida;
            this.nivelJogo = nivelJogo;
            this.tipoJogo = tipoJogo;


        }
    }
    public static class ListaPartida {
        private static final List<GerenciamentoPartida.Partida> partidas = new ArrayList<>();

        public void adicionarJogador(GerenciamentoPartida.Partida partida) {
            partidas.add(partida);
        }

        public static List<GerenciamentoPartida.Partida> listarPartidas() {
            return partidas;
        }
    }

}
