package br.unicamp.cotuca.pathbetweencities.caminho;

import androidx.annotation.NonNull;

import java.io.Serializable;

import br.unicamp.cotuca.pathbetweencities.interfaces.Copiavel;

public class Caminho implements Comparable<Caminho>, Copiavel<Caminho>, Serializable {
    private String nomeCidadeOrigem, nomeCidadeDestino;
    private int distancia, tempo;

    public String getNomeCidadeOrigem() {
        return nomeCidadeOrigem;
    }

    public void setNomeCidadeOrigem(String nomeCidadeOrigem) {
        this.nomeCidadeOrigem = nomeCidadeOrigem;
    }

    public String getNomeCidadeDestino() {
        return nomeCidadeDestino;
    }

    public void setNomeCidadeDestino(String nomeCidadeDestino) {
        this.nomeCidadeDestino = nomeCidadeDestino;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    final int inicioNomeCidadeOrigem = 0;
    final int tamanhoNomeCidadeOrigem = 14;
    final int inicioNomeCidadeDestino = inicioNomeCidadeOrigem + tamanhoNomeCidadeOrigem;
    final int tamanhoNomeCidadeDestino = inicioNomeCidadeDestino + 16;
    final int inicioDistancia =  tamanhoNomeCidadeDestino+1;
    final int tamanhoDistancia = inicioDistancia + 5;
    final int inicioTempo = tamanhoDistancia;

    public Caminho(String nomeCidadeOrigem, String nomeCidadeDestino, int distancia, int tempo){
        this.setNomeCidadeOrigem(nomeCidadeOrigem);
        this.setNomeCidadeDestino(nomeCidadeDestino);
        this.setDistancia(distancia);
        this.setTempo(tempo);
    }

    public Caminho(String linha)
    {
        this.setNomeCidadeOrigem(linha.substring(inicioNomeCidadeOrigem,tamanhoNomeCidadeOrigem).trim());
        this.setNomeCidadeDestino(linha.substring(inicioNomeCidadeDestino,tamanhoNomeCidadeDestino).trim());
        this.setDistancia(Integer.parseInt(linha.substring(inicioDistancia,tamanhoDistancia).trim()));
        this.setTempo(Integer.parseInt(linha.substring(inicioTempo).trim()));
    }

    public Caminho()
    {
        this.setNomeCidadeOrigem("");
        this.setNomeCidadeDestino("");
        this.setDistancia(-1);
        this.setTempo(Integer.MAX_VALUE);
    }

    @Override
    public int compareTo(Caminho o) {
        return 0;
    }

    public Caminho copia()
    {
        Caminho c = new Caminho();
        c.setNomeCidadeOrigem(this.getNomeCidadeOrigem());
        c.setNomeCidadeDestino(this.getNomeCidadeDestino());
        c.setDistancia(this.getDistancia());
        c.setTempo(this.getTempo());

        return c;
    }

    @NonNull
    @Override
    public String toString() {
        String ret = String.format("%-15s",this.getNomeCidadeOrigem()) +
                String.format("%-16s",this.getNomeCidadeDestino()) + String.format("%3s", this.getDistancia()) + String.format("%5s", this.getTempo());
        return ret;
    }
}
