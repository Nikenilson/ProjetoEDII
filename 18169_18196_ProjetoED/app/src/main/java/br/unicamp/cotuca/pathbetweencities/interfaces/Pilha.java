package br.unicamp.cotuca.pathbetweencities.interfaces;

public interface Pilha<Dado extends Copiavel<Dado>>{
    void empilhar(Dado elemento);
    Dado desempilhar() throws Exception;
    Dado oTopo() throws Exception;
    boolean estaVazia();
    int tamanho();
}
