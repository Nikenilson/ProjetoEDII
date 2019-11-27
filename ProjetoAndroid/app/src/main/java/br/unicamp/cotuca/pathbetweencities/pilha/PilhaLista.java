package br.unicamp.cotuca.pathbetweencities.pilha;

import br.unicamp.cotuca.pathbetweencities.exceptions.PilhaVaziaException;
import br.unicamp.cotuca.pathbetweencities.interfaces.Pilha;
import br.unicamp.cotuca.pathbetweencities.lista.*;

public class PilhaLista<Dado extends Comparable<Dado>> implements Pilha {
    private NoLista<Dado> topo;
    private int tamanho;

    public PilhaLista()
    {
        topo = null;
        tamanho = 0;
    }
    public int Tamanho()
    {
        return tamanho;
    }
    public boolean EstaVazia()
    {
        return (topo == null);
    }

    public void Empilhar(Comparable elemento)
    {
        NoLista<Dado> novoNo = new NoLista<Dado>((Dado)elemento, topo);
        topo = novoNo;
        tamanho++;
    }
    public Dado OTopo() throws Exception
    {
        Dado o;
        if (EstaVazia())
            throw new PilhaVaziaException("Underflow da pilha");
        o = topo.getInfo();
        return o;
    }

    public Dado Desempilhar() throws Exception
    {
        if (EstaVazia())
            throw new PilhaVaziaException("Underflow da pilha");
        Dado o = topo.getInfo();
        topo = topo.getProx();
        tamanho--;
        return o;
    }
}
