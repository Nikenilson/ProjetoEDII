package br.unicamp.cotuca.pathbetweencities.caminho;

public class Caminho implements Comparable<Caminho> {
    private int idCidadeOrigem, idCidadeDestino, distancia, tempo, custo;

    public int getIdCidadeOrigem() {
        return idCidadeOrigem;
    }

    public void setIdCidadeOrigem(int idCidadeOrigem) {
        this.idCidadeOrigem = idCidadeOrigem;
    }

    public int getIdCidadeDestino() {
        return idCidadeDestino;
    }

    public void setIdCidadeDestino(int idCidadeDestino) {
        this.idCidadeDestino = idCidadeDestino;
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

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    final int inicioIdCidadeOrigem = 0;
    final int tamanhoIdCidadeOrigem = 3;
    final int inicioIdCidadeDestino = inicioIdCidadeOrigem + tamanhoIdCidadeOrigem;
    final int tamanhoIdCidadeDestino = 3;
    final int inicioDistancia = inicioIdCidadeDestino + tamanhoIdCidadeDestino;
    final int tamanhoDistancia = 5;
    final int inicioTempo = inicioDistancia + tamanhoDistancia;
    final int tamanhoTempo = 4;
    final int inicioCusto = inicioTempo + tamanhoTempo;


    public Caminho(String linha)
    {
        this.setIdCidadeOrigem(Integer.parseInt(linha.substring(inicioIdCidadeOrigem,tamanhoIdCidadeOrigem)));
        this.setIdCidadeDestino(Integer.parseInt(linha.substring(inicioIdCidadeDestino,tamanhoIdCidadeDestino)));
        this.setDistancia(Integer.parseInt(linha.substring(inicioDistancia,tamanhoDistancia)));;
        this.setTempo(Integer.parseInt(linha.substring(inicioTempo,tamanhoTempo)));
        this.setCusto(Integer.parseInt(linha.substring(inicioCusto)));
    }

    public Caminho()
    {
        this.setIdCidadeOrigem(-1);
        this.setIdCidadeDestino(-1);
        this.setDistancia(-1);
        this.setTempo(-1);
        this.setCusto(-1);
    }

    @Override
    public int compareTo(Caminho o) {
        return 0;
    }
}
