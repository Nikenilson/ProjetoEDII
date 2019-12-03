package br.unicamp.cotuca.pathbetweencities.lista;

import java.io.Serializable;

public class ListaSimples<Dado extends Comparable<Dado>> implements Serializable {
    private NoLista<Dado> anterior, primeiro, ultimo, atual;
    int quantosNos;

    public NoLista<Dado> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoLista<Dado> primeiro) {
        this.primeiro = primeiro;
    }

    public NoLista<Dado> getUltimo() {
        return ultimo;
    }

    public void setUltimo(NoLista<Dado> ultimo) {
        this.ultimo = ultimo;
    }

    public NoLista<Dado> getAtual() {
        return atual;
    }

    public void setAtual(NoLista<Dado> atual) {
        this.atual = atual;
    }

    public int getQuantosNos() {
        return quantosNos;
    }

    public void setQuantosNos(int quantosNos) {
        this.quantosNos = quantosNos;
    }

    public ListaSimples()
    {
        primeiro = ultimo = anterior = atual = null;
        quantosNos = 0;
    }

    public void percorrerLista()
    {
        atual = primeiro;
        while (atual != null)
        {
            System.out.println(atual.getInfo());
            atual = atual.getProx();
        }
    }

    public boolean estaVazia()
    {
        return getPrimeiro() == null;
    }

    public void inserirAntesDoInicio(NoLista<Dado> novoNo)
    {
        if (estaVazia())
            ultimo = novoNo;
        novoNo.setProx(primeiro);
        primeiro = novoNo;
        quantosNos++;
    }

    public void inserirAntesDoInicio(Dado informacao)
    {
        if (informacao != null)
        {
            NoLista<Dado> novoNo = new NoLista<Dado>(informacao, null);
            inserirAntesDoInicio(novoNo);
        }
    }

    public void inserirAposFim(NoLista<Dado> novoNo)
    {
        if (estaVazia())
            primeiro = novoNo;
        else
            ultimo.setProx(novoNo);
        novoNo.setProx(null);
        ultimo = novoNo;
        quantosNos++;
    }

    public void inserirAposFim(Dado informacao)
    {
        if (informacao != null)
        {
            NoLista novoNo = new NoLista<Dado>(informacao, null);
            inserirAposFim(novoNo);
        }
    }

    public boolean existeDado(Dado outroProcurado)
    {
        anterior = null;
        atual = primeiro;
        if (estaVazia())
            return false;

        if (outroProcurado.compareTo(primeiro.getInfo()) < 0)
            return false;

        if (outroProcurado.compareTo(ultimo.getInfo()) > 0)
        {
            anterior = ultimo;
            atual = null;
            return false;
        }

        boolean achou = false;
        boolean fim = false;

        while (!achou && !fim)
        {
            if (atual == null)
                fim = true;
            else
                if (outroProcurado.compareTo(atual.getInfo()) == 0)
                    achou = true;
                else
                    if (atual.getInfo().compareTo(outroProcurado) > 0)
                        fim = true;
                    else
                    {
                        anterior = atual;
                        atual = atual.getProx();
                    }
        }
        return achou;
    }

    public void inserirEmOrdem(Dado dados)
    {
        if (!existeDado(dados))
        {
            NoLista<Dado> novo = new NoLista<Dado>(dados, null);
            if (estaVazia())
                inserirAntesDoInicio(novo);
            else
            if (anterior == null && atual != null)
                inserirAntesDoInicio(novo);
            else
                InserirNoMeio(novo);
        }
    }
    private void InserirNoMeio(NoLista<Dado> novo)
    {
        anterior.setProx(novo);
        novo.setProx(atual);
        if (anterior == ultimo)
            ultimo = novo;
        quantosNos++;
    }

    public boolean remover(Dado dados)
    {
        if (!existeDado(dados))
            return false;

        removerNo(anterior, atual);
        return true;
    }

    protected void removerNo(NoLista<Dado> anterior, NoLista<Dado> atual)
    {
        if (anterior == null && atual != null)
        {
            primeiro = atual.getProx();
            if (primeiro == null)
                ultimo = null;
        }
        else
        {
            anterior.setProx(atual.getProx());
            if (atual == ultimo)
                ultimo = anterior;
        }
        quantosNos--;
    }


    public Object[] toArray()
    {
        Object[] array = null;
        if(!this.estaVazia())
        {
            int qtdNos = this.getQuantosNos();
            array = new Object[qtdNos];
            NoLista<Dado> atual = this.getPrimeiro();
            for(int i = 0; atual != null && i < qtdNos; i++){
                array[i] = atual.getInfo();
                atual = atual.getProx();
            }
        }

        return array;
    }
}
