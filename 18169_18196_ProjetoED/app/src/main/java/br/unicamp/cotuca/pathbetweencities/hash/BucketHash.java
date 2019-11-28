package br.unicamp.cotuca.pathbetweencities.hash;

import java.util.ArrayList;

public class BucketHash {
    private final int SIZE = 17;
    ArrayList<Integer>[] data;

    public BucketHash()
    {
        data = new ArrayList[SIZE];
        for (int i = 0; i < SIZE; i++)
            data[i] = new ArrayList(1);
    }

    public int Hash(String s)
    {
        long tot = 0;
        char[] charray;
        charray = s.toUpperCase().toCharArray();
        for (int i = 0; i <= s.length() - 1; i++)
            tot += 37 * tot + (int)charray[i];
        tot = tot % data[SIZE - 1].get(0);
        if (tot < 0)
            tot += data[SIZE - 1].get(0);
        return (int)tot;
    }

    public void Insert(String item)
    {
        int hash_value = Hash(item);
        if (!data[hash_value].contains(item))
            data[hash_value].add(Integer.parseInt(item));
    }

    public boolean Remove(String item)
    {
        int hash_value = Hash(item);
        if (data[hash_value].contains(item))
        {
            data[hash_value].remove(item);
            return true;
        }
        return false;
    }

    /*public void Exibir()
    {
        for (int i = 0; i <= data[SIZE - 1].get(0); i++)
        {
            if (data[i].Count > 0)
            {
                Console.Write($"{i,3} : ");
                foreach (string chave in data[i])
                Console.Write(" | " + chave);
                Console.WriteLine();
            }
        }
        Console.ReadKey();
    }*/
}
