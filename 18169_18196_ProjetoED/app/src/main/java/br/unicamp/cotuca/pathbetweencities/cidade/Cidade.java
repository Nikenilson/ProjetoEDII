package br.unicamp.cotuca.pathbetweencities.cidade;

import androidx.annotation.NonNull;

import java.io.Serializable;

import br.unicamp.cotuca.pathbetweencities.interfaces.Copiavel;

public class Cidade implements Comparable<Cidade>, Copiavel<Cidade>, Serializable {
    private int idCidade;
    private float coordenadaX, coordenadaY;
    private String nomeCidade;

    protected final int tamanhoId = 2;
    protected final int inicioNomeCidade = 2;
    protected final int tamanhoNomeCidade = 16;
    protected final int inicioX = inicioNomeCidade + tamanhoNomeCidade;
    protected final int tamanhoCoord = 5;
    protected final int inicioY = inicioX + tamanhoCoord;

    public Cidade(int id, float x, float y, String nome)
    {
        this.setIdCidade(id);
        this.setCoordenadaX(x);
        this.setCoordenadaY(y);
        this.setNomeCidade(nome);
    }

    public Cidade (String linha)
    {
        setIdCidade(Integer.parseInt(linha.substring(0, tamanhoId).trim()));
        setNomeCidade(linha.substring(inicioNomeCidade, inicioNomeCidade+tamanhoNomeCidade).trim());
        setCoordenadaX(Float.parseFloat(linha.substring(inicioX, inicioX+tamanhoCoord).trim()));
        setCoordenadaY(Float.parseFloat(linha.substring(inicioY).trim()));
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public float getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(float coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public float getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(float coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    @Override
    public int compareTo(Cidade cidade) {
        return 0;
    }

    @Override
    public Cidade copia() {
        Cidade c = new Cidade(this.getIdCidade(), this.getCoordenadaX(), this.getCoordenadaY(), this.getNomeCidade());
        return c;
    }

    @NonNull
    @Override
    public String toString() {
        String ret = String.format("%-2s",this.getIdCidade()) +
                String.format("%-16s",this.getNomeCidade()) + String.format("%5s", this.getCoordenadaX()) + String.format("%6s", this.getCoordenadaY());
        return ret;
    }
}
