package br.unicamp.cotuca.pathbetweencities.Grafo;

import br.unicamp.cotuca.pathbetweencities.cidade.Cidade;

public class Vertice {
    protected Cidade cidade;
    protected boolean foiVisitado, estaAtivo;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade rotulo) {
        this.cidade = rotulo;
    }

    public boolean isFoiVisitado() {
        return foiVisitado;
    }

    public void setFoiVisitado(boolean foiVisitado) {
        this.foiVisitado = foiVisitado;
    }

    public boolean isEstaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo(boolean estaAtivo) {
        this.estaAtivo = estaAtivo;
    }

    public Vertice(Cidade nomeDoVertice)
    {
        cidade = nomeDoVertice;
        foiVisitado = false;
        estaAtivo = true;
    }
}
