package br.unicamp.cotuca.pathbetweencities.hash;

import java.io.Serializable;
import java.util.ArrayList;
import br.unicamp.cotuca.pathbetweencities.cidade.Cidade;
import br.unicamp.cotuca.pathbetweencities.lista.ListaSimples;

public class BucketHashCidade {
    private final int SIZE = 10007;
    protected ListaSimples<Cidade>[] data;

    public ListaSimples<Cidade>[] getData() {
        return data;
    }

    public void setData(ListaSimples<Cidade>[] data) {
        this.data = data;
    }

    public BucketHashCidade()
    {
        data = new ListaSimples[SIZE];
        for (int i = 0; i < SIZE; i++)
            data[i] = new ListaSimples();
    }

    public int hash(String s)
    {
        long tot = 0;
        char[] charray;
        charray = s.toUpperCase().toCharArray();
        for (int i = 0; i <= s.length() - 1; i++)
            tot += 37 * tot + (int)charray[i];
        tot = tot % (SIZE - 1);
        if (tot < 0)
            tot += SIZE - 1;
        return (int)tot;
    }

    public void insert(Cidade item)
    {
        int hash_value = hash(item.getNomeCidade());
        if (!data[hash_value].existeDado(item))
            data[hash_value].inserirAposFim(item);
    }

    public Cidade procurarCidade(String s)
    {
        int hval = hash(s);
        if (data[hval].getPrimeiro().getInfo().getNomeCidade().equals(s))
            return data[hval].getPrimeiro().getInfo();
        return null;
    }
}
