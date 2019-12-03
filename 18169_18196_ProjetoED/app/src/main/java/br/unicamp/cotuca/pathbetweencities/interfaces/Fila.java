package br.unicamp.cotuca.pathbetweencities.interfaces;

public interface Fila<Dado extends Comparable<Dado>> {
    void enfileirar(Dado elemento);
    Dado retirar() throws Exception;
    Dado oInicio() throws Exception;
    Dado oFim() throws Exception;
    int tamanho();
    boolean estaVazia();
}
