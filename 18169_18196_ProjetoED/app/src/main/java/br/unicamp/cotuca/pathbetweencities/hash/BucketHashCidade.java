package br.unicamp.cotuca.pathbetweencities.hash;

import java.util.ArrayList;
import br.unicamp.cotuca.pathbetweencities.cidade.Cidade;

public class BucketHashCidade {
    private final int SIZE = 10007;
    protected ArrayList<Cidade>[] data;

    public ArrayList<Cidade>[] getData() {
        return data;
    }

    public void setData(ArrayList<Cidade>[] data) {
        this.data = data;
    }

    public BucketHashCidade()
    {
        data = new ArrayList[SIZE];
        for (int i = 0; i < SIZE; i++)
            data[i] = new ArrayList(1);
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
        if (!data[hash_value].contains(item))
            data[hash_value].add(item);
    }

    public Cidade procurarCidade(String s)
    {
        int hval = hash(s);
        if (data[hval].get(0).getNomeCidade().equals(s))
            return data[hval].get(0);
        return null;
    }
}
