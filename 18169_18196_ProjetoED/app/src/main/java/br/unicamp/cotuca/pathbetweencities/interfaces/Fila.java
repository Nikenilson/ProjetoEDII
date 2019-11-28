package br.unicamp.cotuca.pathbetweencities.interfaces;

public interface Fila<Dado extends Comparable<Dado>> {
    void Enfileirar(Dado elemento);
    Dado Retirar() throws Exception;
    Dado OInicio() throws Exception;
    Dado OFim() throws Exception;
    int Tamanho();
    boolean EstaVazia();
}
