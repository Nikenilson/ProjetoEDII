package br.unicamp.cotuca.pathbetweencities.fila;

import br.unicamp.cotuca.pathbetweencities.interfaces.Fila;
import br.unicamp.cotuca.pathbetweencities.lista.ListaSimples;
import br.unicamp.cotuca.pathbetweencities.lista.NoLista;

public class FilaLista<Dado extends Comparable<Dado>> extends ListaSimples<Dado> implements Fila<Dado>
{
        public void Enfileirar(Dado elemento)
        {
            NoLista<Dado> novoNo = new NoLista<Dado>(elemento, null);
            super.InserirAposFim(novoNo);
        }

        public Dado Retirar() throws Exception
        {
            if (!EstaVazia())
            {
                Dado elemento = super.getPrimeiro().getInfo();
                super.RemoverNo(null, getPrimeiro());
                return elemento;
            }
            throw new Exception("FilaVazia");
        }

        public Dado OInicio() throws Exception
        {
            if (EstaVazia())
                throw new Exception("FilaVazia");
            Dado o = super.getPrimeiro().getInfo();
            return o;
        }

        public Dado OFim() throws Exception
        {
            if (EstaVazia())
                throw new Exception("FilaVazia");

            Dado o = super.getUltimo().getInfo();
            return o;
        }

        public int Tamanho()
        {
            return super.getQuantosNos();
        }

        public boolean EstaVazia()
        {
            return super.EstaVazia();
        }
}
