package br.unicamp.cotuca.pathbetweencities.lista;

public class ListaSimples<Dado extends Comparable<Dado>> {
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

    public boolean EstaVazia()
    {
        return getPrimeiro() == null;
    }

    public void InserirAntesDoInicio(NoLista<Dado> novoNo)
    {
        if (EstaVazia())
            ultimo = novoNo;
        novoNo.setProx(primeiro);
        primeiro = novoNo;
        quantosNos++;
    }

    public void InserirAntesDoInicio(Dado informacao)
    {
        if (informacao != null)
        {
            NoLista<Dado> novoNo = new NoLista<Dado>(informacao, null);
            InserirAntesDoInicio(novoNo);
        }
    }

    public void InserirAposFim(NoLista<Dado> novoNo)
    {
        if (EstaVazia())
            primeiro = novoNo;
        else
            ultimo.setProx(novoNo);
        novoNo.setProx(null);
        ultimo = novoNo;
        quantosNos++;
    }

    public void InserirAposFim(Dado informacao)
    {
        if (informacao != null)
        {
            NoLista novoNo = new NoLista<Dado>(informacao, null);
            InserirAposFim(novoNo);
        }
    }

    public boolean ExisteDado(Dado outroProcurado)
    {
        anterior = null;
        atual = primeiro;
        if (EstaVazia())
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

    public void InserirEmOrdem(Dado dados)
    {
        if (!ExisteDado(dados))
        {
            NoLista<Dado> novo = new NoLista<Dado>(dados, null);
            if (EstaVazia())
                InserirAntesDoInicio(novo);
            else
            if (anterior == null && atual != null)
                InserirAntesDoInicio(novo);
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

    public boolean Remover(Dado dados)
    {
        if (!ExisteDado(dados))
            return false;

        RemoverNo(anterior, atual);
        return true;
    }

    protected void RemoverNo(NoLista<Dado> anterior, NoLista<Dado> atual)
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

    //os parametros eram REF
    private void ProcurarMenor(NoLista<Dado> antM, NoLista<Dado> atuM)
    {
        antM = anterior = null;
        atuM = atual = primeiro;
        while (atual != null)
        {
            if (atual.getInfo().compareTo(atuM.getInfo()) < 0 )
            {
                antM = anterior;
                atuM = atual;
            }
            anterior = atual;
            atual = atual.getProx();
        }
    }

    public void Ordenar()
    {
        NoLista<Dado> menor = null, antMenor = null, noAIncluir = null;
        ListaSimples listaOrdenada = new ListaSimples<Dado>();
        while (!this.EstaVazia())
        {
            ProcurarMenor(antMenor, menor);
            noAIncluir = menor;
            this.RemoverNo(antMenor, menor);
            listaOrdenada.InserirAposFim(noAIncluir);
        }
        this.primeiro = listaOrdenada.primeiro;
        this.ultimo = listaOrdenada.ultimo;
        this.quantosNos = listaOrdenada.quantosNos;
        this.atual = this.anterior = null;
    }
}
