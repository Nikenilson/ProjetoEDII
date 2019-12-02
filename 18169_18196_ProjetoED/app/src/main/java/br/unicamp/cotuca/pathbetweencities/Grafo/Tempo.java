package br.unicamp.cotuca.pathbetweencities.Grafo;

public class Tempo {
    protected int tempo, verticePai;

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getVerticePai() {
        return verticePai;
    }

    public void setVerticePai(int verticePai) {
        this.verticePai = verticePai;
    }

    public Tempo(int vp, int t)
    {
        tempo = t;
        verticePai = vp;
    }
}
