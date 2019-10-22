using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EDGrafos
{
    public partial class frmGrafos : Form
    {
        public frmGrafos()
        {
            InitializeComponent();
        }

        private void BtnProfundidade_Click(object sender, EventArgs e)
        {
            Grafo aGraph = new Grafo(dgvGrafo);
            aGraph.NovoVertice("A");
            aGraph.NovoVertice("B");
            aGraph.NovoVertice("C");
            aGraph.NovoVertice("D");
            aGraph.NovoVertice("E");
            aGraph.NovoVertice("F");
            aGraph.NovoVertice("G");
            aGraph.NovoVertice("H");
            aGraph.NovoVertice("I");
            aGraph.NovoVertice("J");
            aGraph.NovoVertice("K");
            aGraph.NovoVertice("L");
            aGraph.NovoVertice("M");
            aGraph.NovaAresta(0, 1);
            aGraph.NovaAresta(1, 2);
            aGraph.NovaAresta(2, 3);
            aGraph.NovaAresta(0, 4);
            aGraph.NovaAresta(4, 5);
            aGraph.NovaAresta(5, 6);
            aGraph.NovaAresta(0, 7);
            aGraph.NovaAresta(7, 8);
            aGraph.NovaAresta(8, 9);
            aGraph.NovaAresta(0, 10);
            aGraph.NovaAresta(10, 11);
            aGraph.NovaAresta(11, 12);
            aGraph.exibirAdjacencias();
            aGraph.PercursoEmProfundidade(txtSaida);
        }

        private void BtnLargura_Click(object sender, EventArgs e)
        {
            Grafo aGraph = new Grafo(dgvGrafo);
            aGraph.NovoVertice("A");
            aGraph.NovoVertice("B");
            aGraph.NovoVertice("C");
            aGraph.NovoVertice("D");
            aGraph.NovoVertice("E");
            aGraph.NovoVertice("F");
            aGraph.NovoVertice("G");
            aGraph.NovoVertice("H");
            aGraph.NovoVertice("I");
            aGraph.NovoVertice("J");
            aGraph.NovoVertice("K");
            aGraph.NovoVertice("L");
            aGraph.NovoVertice("M");
            aGraph.NovaAresta(0, 1);
            aGraph.NovaAresta(1, 2);
            aGraph.NovaAresta(2, 3);
            aGraph.NovaAresta(0, 4);
            aGraph.NovaAresta(4, 5);
            aGraph.NovaAresta(5, 6);
            aGraph.NovaAresta(0, 7);
            aGraph.NovaAresta(7, 8);
            aGraph.NovaAresta(8, 9);
            aGraph.NovaAresta(0, 10);
            aGraph.NovaAresta(10, 11);
            aGraph.NovaAresta(11, 12);
            aGraph.exibirAdjacencias();
            aGraph.percursoPorLargura(txtSaida);
        }

        private void BtnArvoreGeradoraMinima_Click(object sender, EventArgs e)
        {
            Grafo aGraph = new Grafo(dgvGrafo);
            aGraph.NovoVertice("A");
            aGraph.NovoVertice("B");
            aGraph.NovoVertice("C");
            aGraph.NovoVertice("D");
            aGraph.NovoVertice("E");
            aGraph.NovoVertice("F");
            aGraph.NovoVertice("G");
            aGraph.NovaAresta(0, 1);
            aGraph.NovaAresta(0, 2);
            aGraph.NovaAresta(0, 3);
            aGraph.NovaAresta(1, 2);
            aGraph.NovaAresta(1, 3);
            aGraph.NovaAresta(1, 4);
            aGraph.NovaAresta(2, 3);
            aGraph.NovaAresta(2, 5);
            aGraph.NovaAresta(3, 5);
            aGraph.NovaAresta(3, 4);
            aGraph.NovaAresta(3, 6);
            aGraph.NovaAresta(4, 5);
            aGraph.NovaAresta(4, 6);
            aGraph.NovaAresta(5, 6);
            aGraph.exibirAdjacencias();
            aGraph.ArvoreGeradoraMinima(0, txtSaida);

        }

        private void BtnBuscar_Click(object sender, EventArgs e)
        {
            Grafo oGrafo = new Grafo(dgvGrafo);
            oGrafo.NovoVertice("A");        // 0
            oGrafo.NovoVertice("B");        // 1 
            oGrafo.NovoVertice("C");        // 2
            oGrafo.NovoVertice("D");        // 3
            oGrafo.NovoVertice("E");        // 4
            oGrafo.NovoVertice("F");        // 5
            oGrafo.NovoVertice("G");        // 6
            oGrafo.NovaAresta(0, 1, 2);     // A --> B = 2
            oGrafo.NovaAresta(0, 3, 1);     // A --> D = 1
            oGrafo.NovaAresta(1, 3, 3);     // B --> D = 3
            oGrafo.NovaAresta(1, 4, 10);    // B --> E = 10
            oGrafo.NovaAresta(2, 5, 5);     // C --> F = 5
            oGrafo.NovaAresta(2, 0, 4);     // C --> A = 4
            oGrafo.NovaAresta(3, 2, 2);     // D --> C = 2
            oGrafo.NovaAresta(3, 5, 8);     // D --> F = 8
            oGrafo.NovaAresta(3, 4, 2);     // D --> E = 2
            oGrafo.NovaAresta(3, 6, 4);     // D --> G = 4
            oGrafo.NovaAresta(4, 6, 6);     // E --> G = 6
            oGrafo.NovaAresta(6, 5, 1);     // G --> F = 1
            lsbSaida.Items.Clear();
            lsbSaida.Items.Add("");
            lsbSaida.Items.Add("Menores caminhos:");
            lsbSaida.Items.Add("");
            int ori = int.Parse(txtOrigem.Text);
            int des = int.Parse(txtDestino.Text);
            lsbSaida.Items.Add(oGrafo.Caminho(ori, des, lsbSaida) );
            lsbSaida.Items.Add("");

        }

    private void btnTeste2_Click(object sender, EventArgs e)
    {

    }

    private void btnTeste1_Click(object sender, EventArgs e)
    {
      Grafo oGrafo = new Grafo(dgvGrafo);
      oGrafo.NovoVertice("CS1"); // 0
      oGrafo.NovoVertice("CS2"); // 1
      oGrafo.NovoVertice("DS");  // 2
      oGrafo.NovoVertice("OS");  // 3
      oGrafo.NovoVertice("ALG"); // 4
      oGrafo.NovoVertice("ASM"); // 5
      oGrafo.NovoVertice("TOO"); // 6
      oGrafo.NovoVertice("TED"); // 7
      oGrafo.NovaAresta(0, 1);
      oGrafo.NovaAresta(1, 2);
      oGrafo.NovaAresta(1, 5);
      oGrafo.NovaAresta(2, 3);
      oGrafo.NovaAresta(2, 4);
      oGrafo.NovaAresta(2, 6);
      oGrafo.NovaAresta(2, 7);
      txtSaida.Text = oGrafo.OrdenacaoTopologica();
    }
  }
}
