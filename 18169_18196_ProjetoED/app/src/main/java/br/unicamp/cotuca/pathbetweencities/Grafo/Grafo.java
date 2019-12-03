package br.unicamp.cotuca.pathbetweencities.Grafo;

import android.widget.EditText;

import java.util.Stack;

import br.unicamp.cotuca.pathbetweencities.caminho.Caminho;
import br.unicamp.cotuca.pathbetweencities.cidade.Cidade;
import br.unicamp.cotuca.pathbetweencities.interfaces.Pilha;
import br.unicamp.cotuca.pathbetweencities.pilha.PilhaLista;

public class Grafo {
    private Vertice[] vertices;
    private Caminho[][] adjMatrix;
    int numVerts;
    int verticeAtualVetor = 0;
    int[] verticesPassados;

    public int[] getVerticesPassados() {
        return verticesPassados;
    }

    /// DJIKSTRA
    Tempo[] percurso;
    int infinity = Integer.MAX_VALUE;
    int verticeAtual;
    int doInicioAteAtual;
    int tempoMinimo;

    public Grafo(int numVerts)
    {
        this.numVerts = numVerts;
        vertices = new Vertice[numVerts];
        adjMatrix = new Caminho[numVerts][numVerts];
        for (int j = 0; j < numVerts; j++)
            for (int k = 0; k < numVerts; k++)
                adjMatrix[j][k] = new Caminho();
        percurso = new Tempo[numVerts];
    }

    public void novoVertice(Cidade cidade)
    {
        vertices[verticeAtualVetor] = new Vertice(cidade);
        verticeAtualVetor++;
    }

    public void novaAresta(int origem, int destino, Caminho peso)
    {
        adjMatrix[origem][destino] = peso;
    }

    public String acharCaminho(int inicioDoPercurso, int finalDoPercurso, EditText lista)
    {
        for (int j = 0; j < numVerts; j++)
            vertices[j].foiVisitado = false;
        vertices[inicioDoPercurso].foiVisitado = true;
        for (int j = 0; j < numVerts; j++)
        {
            int tempDist = adjMatrix[inicioDoPercurso][j].getTempo();
            percurso[j] = new Tempo(inicioDoPercurso, tempDist);
        }
        for (int nTree = 0; nTree < numVerts; nTree++) {
            int indiceDoMenor = obterMenor();
            tempoMinimo = percurso[indiceDoMenor].getTempo();
            verticeAtual = indiceDoMenor;
            doInicioAteAtual = percurso[indiceDoMenor].getTempo();
            vertices[verticeAtual].foiVisitado = true;
            ajustarMenorCaminho();
        }

        return exibirPercursos(inicioDoPercurso, finalDoPercurso);
    }

    public int obterMenor()
    {
        int distanciaMinima = infinity;
        int indiceDaMinima = 0;
        for (int j = 0; j < numVerts; j++)
            if (!(vertices[j].foiVisitado) && (percurso[j].getTempo() < distanciaMinima))
            {
                distanciaMinima = percurso[j].getTempo();
                indiceDaMinima = j;
            }
        return indiceDaMinima;
    }

    public void ajustarMenorCaminho()
    {
        for (int coluna = 0; coluna < numVerts; coluna++)
            if (!vertices[coluna].foiVisitado && adjMatrix[verticeAtual][coluna].getTempo() != infinity)
            {
                int atualAteMargem = adjMatrix[verticeAtual][coluna].getTempo();
                int doInicioAteMargem = doInicioAteAtual + atualAteMargem;
                int distanciaDoCaminho = percurso[coluna].getTempo();
                if (doInicioAteMargem < distanciaDoCaminho)
                {
                    percurso[coluna].verticePai = verticeAtual;
                    percurso[coluna].setTempo(doInicioAteMargem);
                }
            }
    }

    public String exibirPercursos(int inicioDoPercurso, int finalDoPercurso)
    {
        String resultado = "";
        int onde = finalDoPercurso, cont = 0, tempo = 0, distancia = 0;
        PilhaLista<Cidade> pilha = new PilhaLista<>();
        while (onde != inicioDoPercurso)
        {
            onde = percurso[onde].verticePai;
            pilha.empilhar(vertices[onde].getCidade());
            cont++;
        }
        verticesPassados = new int[pilha.tamanho()+1];
        Pilha<Cidade> aux = pilha.copia();
        int i = 0;
        while(!aux.estaVazia()){
            try{
                verticesPassados[i] = aux.desempilhar().getIdCidade();
                i++;
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        verticesPassados[i] = finalDoPercurso;
        int c1 = 0, c2 = 0;
        while(c1 < verticesPassados.length && c2 < verticesPassados.length) {
            c2++;
            if(c1 < verticesPassados.length && c2 < verticesPassados.length){
                tempo += adjMatrix[verticesPassados[c1]][verticesPassados[c2]].getTempo();
                distancia += adjMatrix[verticesPassados[c1]][verticesPassados[c2]].getDistancia();
            }
            c1 = c2;
        }
        while (pilha.tamanho() != 0)
        {
            try{
                resultado += pilha.desempilhar().getNomeCidade();
                if (pilha.tamanho() != 0)
                    resultado += " --> ";
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if ((cont == 1) && (percurso[finalDoPercurso].getTempo() == infinity))
            resultado = "Não há caminho";
        else{
            resultado += " --> " + vertices[finalDoPercurso].getCidade().getNomeCidade();
            resultado += "\nTempo: " + tempo;
            resultado += "\nDistancia: " + distancia;
        }
        return resultado;
    }
}
