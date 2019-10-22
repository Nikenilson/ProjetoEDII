using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace apArvore
{
  public partial class FrmArvore : Form
  {

    Arvore<Funcionario> arvore;
    public FrmArvore()
    {
      InitializeComponent();
      arvore = new Arvore<Funcionario>(pbArvore);
    }

    private void label1_Click(object sender, EventArgs e)
    {

    }

    private void DesenharArvore(bool primeiraVez, NoArvore<Funcionario> noAtual,
                                int x, int y, double angulo, double incremento,
                                double comprimento, Graphics g)
    {
      int xf, yf;
      if (noAtual != null)
      {
        Pen caneta = new Pen(Color.Red);
        xf = (int)Math.Round(x + Math.Cos(angulo) * comprimento);
        yf = (int)Math.Round(y + Math.Sin(angulo) * comprimento);
        if (primeiraVez)
          yf = 25;
        g.DrawLine(caneta, x, y, xf, yf);
        // sleep(100);
        DesenharArvore(false, noAtual.Esq, xf, yf, Math.PI / 2 + incremento,
                       incremento * 0.60, comprimento * 0.8, g);
        DesenharArvore(false, noAtual.Dir, xf, yf, Math.PI / 2 - incremento,
                       incremento * 0.60, comprimento * 0.8, g);
        // sleep(100);
        SolidBrush preenchimento = new SolidBrush(Color.Blue);
        g.FillEllipse(preenchimento, xf - 15, yf - 15, 30, 30);
        g.DrawString(Convert.ToString(noAtual.Info.Matricula), new Font("Comic Sans", 10),
        new SolidBrush(Color.Yellow), xf - 15, yf - 10);
      }
    }

    private void pbArvore_Paint(object sender, PaintEventArgs e)
    {
      Graphics g = e.Graphics;
      DesenharArvore(true, arvore.Raiz, pbArvore.Width / 2, 0, Math.PI / 2,
                    Math.PI / 2.5, 300, g);
    }

    private void btnInserir_Click(object sender, EventArgs e)
    {
      if (txtMatricula.Text != "" && txtNome.Text != "" && txtSalario.Text != "")
      {
        var novoFunc = new Funcionario(int.Parse(txtMatricula.Text),
          txtNome.Text,
          double.Parse(txtSalario.Text));
        arvore.Raiz = arvore.Insert(novoFunc, arvore.Raiz);
        pbArvore.Invalidate();
        //if (arvore.Raiz != null)
        //  chkBalanceada.Checked = Math.Abs(arvore.Raiz.Esq.Altura - arvore.Raiz.Dir.Altura) < 2;
        //else
        //  chkBalanceada.Checked = true;

        lbAltura.Text = arvore.Altura() + "";
      }
    }
  }
}
