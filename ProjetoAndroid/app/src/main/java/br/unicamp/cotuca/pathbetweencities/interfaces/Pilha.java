package br.unicamp.cotuca.pathbetweencities.interfaces;

public interface Pilha<Dado extends Comparable<Dado>>{
    void Empilhar(Dado elemento);
    Dado Desempilhar() throws Exception;
    Dado OTopo() throws Exception;
    boolean EstaVazia();
    int Tamanho();
}
