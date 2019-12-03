package br.unicamp.cotuca.pathbetweencities.lista;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class NoLista<Dado> implements Serializable {
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

    @NonNull
    @Override
    public String toString() {
        return info.toString();
    }
}
