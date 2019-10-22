using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace OrdenacoesSimples
{
  public partial class Form1 : Form
  {
    public Form1()
    {
      InitializeComponent();
    }

    CArray nums;
    private void btnPreencher_Click(object sender, EventArgs e)
    {
      int tamanho = Convert.ToInt32(txtTamanho.Text);
      nums = new CArray(tamanho, dgvVetor, chkAnimar.Checked);
      for (int i = 0; i < tamanho; i++)
        nums.Insert(i);
    }

    private void btnAleatorio_Click(object sender, EventArgs e)
    {
      int tamanho = Convert.ToInt32(txtTamanho.Text);
      nums = new CArray(tamanho, dgvVetor, chkAnimar.Checked);
      Random rnd = new Random(tamanho);
      for (int i = 0; i < tamanho; i++)
        nums.Insert(rnd.Next(tamanho));
    }

    private void btnBubbleSort_Click(object sender, EventArgs e)
    {
      Cronometro sortTime = new Cronometro();
      sortTime.iniciarCronometro();
      nums.BubbleSort();
      sortTime.pararCronometro();
      lbBubble.Text = sortTime.TempoDecorrido.TotalMilliseconds + "";
    }

    private void btnSelectionSort_Click(object sender, EventArgs e)
    {
      Cronometro sortTime = new Cronometro();
      sortTime.iniciarCronometro();
      nums.SelectionSort();
      sortTime.pararCronometro();
      lbSelection.Text = sortTime.TempoDecorrido.TotalMilliseconds + "";
    }

    private void btnInsertionSort_Click(object sender, EventArgs e)
    {
      Cronometro sortTime = new Cronometro();
      sortTime.iniciarCronometro();
      nums.InsertionSort();
      sortTime.pararCronometro();
      lbInsertion.Text = sortTime.TempoDecorrido.TotalMilliseconds + "";
    }

    private void btnShellSort_Click(object sender, EventArgs e)
    {
      Cronometro sortTime = new Cronometro();
      sortTime.iniciarCronometro();
      nums.ShellSort();
      sortTime.pararCronometro();
      lbShell.Text = sortTime.TempoDecorrido.TotalMilliseconds+"";
    }

    private void btnMergeSort_Click(object sender, EventArgs e)
    {
      Cronometro sortTime = new Cronometro();
      sortTime.iniciarCronometro();
      nums.MergeSort();
      sortTime.pararCronometro();
      lbMerge.Text = sortTime.TempoDecorrido.TotalMilliseconds + "";
    }

    private void btnQuickSort_Click(object sender, EventArgs e)
    {
      Cronometro sortTime = new Cronometro();
      sortTime.iniciarCronometro();
      nums.QuickSort();
      sortTime.pararCronometro();
      lbQuick.Text = sortTime.TempoDecorrido.TotalMilliseconds + "";
    }
  }
}
