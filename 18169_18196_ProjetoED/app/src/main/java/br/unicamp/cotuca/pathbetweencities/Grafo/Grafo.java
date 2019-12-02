package br.unicamp.cotuca.pathbetweencities.Grafo;

import android.widget.EditText;

import java.util.Stack;

import br.unicamp.cotuca.pathbetweencities.cidade.Cidade;

public class Grafo {
    private Vertice[] vertices;
    private int[][] adjMatrix;
    int numVerts;
    int verticeAtualVetor = 0;

    /// DJIKSTRA
    Tempo[] percurso;
    int infinity = Integer.MAX_VALUE;
    int verticeAtual; // global usada para indicar o vértice atualmente sendo visitado
    int doInicioAteAtual; // global usada para ajustar menor caminho com Djikstra
    int nTree;

    public Grafo(int numVerts)
    {
        this.numVerts = numVerts;
        vertices = new Vertice[numVerts];
        adjMatrix = new int[numVerts][numVerts];
        nTree = 0;
        for (int j = 0; j < numVerts; j++) // zera toda a matriz
            for (int k = 0; k < numVerts; k++)
                adjMatrix[j][k] = infinity; // distância tão grande que não existe
        percurso = new Tempo[numVerts];
    }

    public void novoVertice(Cidade cidade)
    {
        vertices[verticeAtualVetor] = new Vertice(cidade);
        verticeAtualVetor++;
    }

    public void novaAresta(int origem, int destino, int tempo)
    {
        adjMatrix[origem][destino] = tempo;
    }

    public String acharCaminho(int inicioDoPercurso, int finalDoPercurso, EditText lista)
    {
        for (int j = 0; j < numVerts; j++)
            vertices[j].foiVisitado = false;
        vertices[inicioDoPercurso].foiVisitado = true;
        for (int j = 0; j < numVerts; j++)
        {
            // anotamos no vetor percurso a distância entre o inicioDoPercurso e cada vértice
            // se não há ligação direta, o valor da distância será infinity
            int tempDist = adjMatrix[inicioDoPercurso][j];
            percurso[j] = new Tempo(inicioDoPercurso, tempDist);
        }
        for (int nTree = 0; nTree < numVerts; nTree++) {
            // Procuramos a saída não visitada do vértice inicioDoPercurso com a menor distância
            int indiceDoMenor = obterMenor();
            // e anotamos essa menor distância
            int tempoMinimo = percurso[indiceDoMenor].getTempo();
            // o vértice com a menor distância passa a ser o vértice atual
            // para compararmos com a distância calculada em AjustarMenorCaminho()
            verticeAtual = indiceDoMenor;
            doInicioAteAtual = percurso[indiceDoMenor].getTempo();
            // visitamos o vértice com a menor distância desde o inicioDoPercurso
            vertices[verticeAtual].foiVisitado = true;
            ajustarMenorCaminho(lista);
        }

        return exibirPercursos(inicioDoPercurso, finalDoPercurso);
    }

    public int obterMenor()
    {
        int distanciaMinima = infinity;
        int indiceDaMinima = 0;
        for (int j = 0; j < numVerts; j++)
            if (!(vertices[j].foiVisitado) && (percurso[j].getTempo() <distanciaMinima))
            {
                distanciaMinima = percurso[j].getTempo();
                indiceDaMinima = j;
            }
        return indiceDaMinima;
    }

    public void ajustarMenorCaminho(EditText lista)
    {
        for (int coluna = 0; coluna < numVerts; coluna++)
            if (!vertices[coluna].foiVisitado) // para cada vértice ainda não visitado
            {
                // acessamos a distância desde o vértice atual (pode ser infinity)
                int atualAteMargem = adjMatrix[verticeAtual][coluna];
                // calculamos a distância desde inicioDoPercurso passando por vertice atual até
                // esta saída
                int doInicioAteMargem = doInicioAteAtual + atualAteMargem;
                // quando encontra uma distância menor, marca o vértice a partir do
                // qual chegamos no vértice de índice coluna, e a soma da distância
                // percorrida para nele chegar
                int distanciaDoCaminho = percurso[coluna].getTempo();
                if (doInicioAteMargem < distanciaDoCaminho)
                {
                    percurso[coluna].verticePai = verticeAtual;
                    percurso[coluna].setTempo(doInicioAteMargem);
                    exibirTabela(lista);
                }
            }
        lista.append("==================Tempo ajustado==============");
        lista.append(" ");
    }

    public void exibirTabela(EditText lista)
    {
        String dist = "";
        lista.append("Vértice\tVisitado?\tPeso\tVindo de");
        for (int i = 0; i < numVerts; i++)
        {
            if (percurso[i].getTempo() == infinity)
                dist = "inf";
            else
                dist = new Integer(percurso[i].getTempo()).toString();
            lista.append(vertices[i].getCidade().getNomeCidade() + "\t" + vertices[i].foiVisitado +
                    "\t\t" + dist + "\t" + vertices[percurso[i].verticePai].getCidade().getNomeCidade());
        }
        lista.append("-----------------------------------------------------");
    }

    public String exibirPercursos(int inicioDoPercurso, int finalDoPercurso)
    {
        String resultado = "";
        /*for (int j = 0; j < numVerts; j++)
        {
            Console.Write(vertices[j].rotulo + "=");
            if (percurso[j].distancia == infinity)
                Console.Write("inf");
            else
                Console.Write(percurso[j].distancia);
            String pai = vertices[percurso[j].verticePai].rotulo;
            Console.Write("(" + pai + ") ");
        }
        Console.WriteLine();
        Console.WriteLine();
        Console.WriteLine("Tempo entre " + vertices[inicioDoPercurso].rotulo +
                " e " + vertices[finalDoPercurso].rotulo);
        Console.WriteLine();*/
        int onde = finalDoPercurso;
        Stack<Cidade> pilha = new Stack();
        int cont = 0;
        while (onde != inicioDoPercurso)
        {
            onde = percurso[onde].verticePai;
            pilha.push(vertices[onde].getCidade());
            cont++;
        }
        while (pilha.size() != 0)
        {
            resultado += pilha.pop();
            if (pilha.size() != 0)
                resultado += " --> ";
        }
        if ((cont == 1) && (percurso[finalDoPercurso].getTempo() == infinity))
            resultado = "Não há caminho";
        else
            resultado += " --> " + vertices[finalDoPercurso].getCidade().getNomeCidade();
        return resultado;
    }
}
