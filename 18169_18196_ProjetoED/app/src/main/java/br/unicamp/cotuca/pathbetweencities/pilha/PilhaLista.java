package br.unicamp.cotuca.pathbetweencities.pilha;

import br.unicamp.cotuca.pathbetweencities.exceptions.PilhaVaziaException;
import br.unicamp.cotuca.pathbetweencities.interfaces.Copiavel;
import br.unicamp.cotuca.pathbetweencities.interfaces.Pilha;
import br.unicamp.cotuca.pathbetweencities.lista.*;

public class PilhaLista<Dado extends Copiavel<Dado>> implements Pilha, Comparable<PilhaLista<Dado>>,
Copiavel<PilhaLista<Dado>>{
    private NoLista<Dado> topo;
    private int tamanho;

    public PilhaLista()
    {
        topo = null;
        tamanho = 0;
    }
    public int tamanho()
    {
        return tamanho;
    }
    public boolean estaVazia()
    {
        return (topo == null);
    }

    public void empilhar(Copiavel elemento)
    {
        NoLista<Dado> novoNo = new NoLista<Dado>((Dado)elemento, topo);
        topo = novoNo;
        tamanho++;
    }

    public Dado oTopo() throws Exception
    {
        Dado o;
        if (estaVazia())
            throw new PilhaVaziaException("Underflow da pilha");
        o = topo.getInfo();
        return o;
    }

    public Dado desempilhar() throws Exception
    {
        if (estaVazia())
            throw new PilhaVaziaException("Underflow da pilha");
        Dado o = topo.getInfo();
        topo = topo.getProx();
        tamanho--;
        return o;
    }

    public PilhaLista<Dado> copia()
    {
        PilhaLista<Dado> s1 = new PilhaLista<Dado>();
        PilhaLista<Dado> s2 = new PilhaLista<Dado>();
        try{
            while (!this.estaVazia())
                s1.empilhar(this.desempilhar());
            while (!s1.estaVazia())
            {
                Dado obj = s1.desempilhar();
                this.empilhar(obj);
                s2.empilhar(obj.copia());
            }
            return s2;
        }catch (Exception e){
            e.printStackTrace();
        }
        return s2;
    }

    @Override
    public int compareTo(PilhaLista<Dado> dadoPilhaLista) {
        return 0;
    }
}
