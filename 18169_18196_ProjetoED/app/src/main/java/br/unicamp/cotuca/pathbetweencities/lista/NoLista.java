package br.unicamp.cotuca.pathbetweencities.lista;

public class NoLista<Dado> {
    private Dado info;
    private NoLista<Dado> prox;

    public NoLista(Dado info, NoLista<Dado> prox)
    {
        setInfo(info);
        setProx(prox);
    }

    public Dado getInfo() {
        return info;
    }

    public void setInfo(Dado info) {
        this.info = info;
    }

    public NoLista<Dado> getProx() {
        return prox;
    }

    public void setProx(NoLista<Dado> prox) {
        this.prox = prox;
    }
}
