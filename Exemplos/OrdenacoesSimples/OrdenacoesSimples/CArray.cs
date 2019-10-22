using System;
using System.Windows.Forms;
using System.Drawing;


namespace OrdenacoesSimples
{
  class CArray
  {
    private int[] arr;
    private int upper;
    private int numElements;
    DataGridView dgv;
    bool animar;

    public CArray(int size, DataGridView dgvDoFormulario,
                  bool animacao)
    {
      arr = new int[size];
      upper = size - 1;
      numElements = 0;
      animar = animacao;
      dgv = dgvDoFormulario;
      if (animar)
      {
        dgv.ColumnCount = size;
        dgv.RowCount = 1;
        for (int indice = 0; indice < size; indice++)
        {
          dgv.Columns[indice].Name = Convert.ToString(indice);
          dgv.Columns[indice].Width = 20;
        }
      }
    }
    public void Insert(int item)
    {
      arr[numElements] = item;
      if (animar)
        dgv.Rows[0].Cells[numElements].Value = Convert.ToString(item);
      numElements++;
    }
    public void DisplayElements()
    {
      for (int i = 0; i <= upper; i++)
        Console.Write(arr[i] + " ");
    }
    public void Clear()
    {
      for (int i = 0; i <= upper; i++)
        arr[i] = 0;
      dgv.ColumnCount = 0;
    }

    public void BubbleSort()
    {
      if (animar)
      {
        dgv.Parent.Height = 165 + 22;
        dgv.Rows.Add(); // usado para organizar o DataGridView para exibição
      }
      int temp, linha = 0; // linha será usada para exibir as trocas de valores
      for (int outer = upper; outer >= 0; outer--)
      {
        for (int inner = 0; inner <= outer - 1; inner++)
          if (arr[inner] > arr[inner + 1])
          {
            if (animar)
            {
              dgv.Parent.Height += 22;
              linha = dgv.Rows.Add();
              for (int indice = 0; indice < numElements; indice++)
                dgv.Rows[linha - 1].Cells[indice].Value = Convert.ToString(arr[indice]);
              dgv.Rows[linha - 1].Cells[inner].Style.BackColor = Color.Red;
              dgv.Rows[linha - 1].Cells[inner + 1].Style.BackColor = Color.Orange;
              Application.DoEvents();
            }
            temp = arr[inner];
            arr[inner] = arr[inner + 1];
            arr[inner + 1] = temp;
          }
      }
      if (animar)
      {
        for (int indice = 0; indice < numElements; indice++)
          dgv.Rows[0].Cells[indice].Value = dgv.Rows[linha + 1].Cells[indice].Value;
        dgv.RowCount--;
      }
    }
    public void SelectionSort()
    {
      if (animar)
      {
        dgv.Parent.Height = 165 + 22;
        dgv.Rows.Add(); // usado para organizar o DataGridView para exibição
      }
      int min, temp, linha = 0; // linha será usada para exibir as trocas de valores
      for (int outer = 0; outer <= upper; outer++)
      {
        min = outer;
        if (animar)
        {
          dgv.Parent.Height += 22;
          linha = dgv.Rows.Add();
          for (int indice = 0; indice < numElements; indice++)
            dgv.Rows[linha - 1].Cells[indice].Value = Convert.ToString(arr[indice]);
        }
        for (int inner = outer + 1; inner <= upper; inner++)
          if (arr[inner] < arr[min])
            min = inner;
        if (outer != min)
        {
          temp = arr[outer];
          arr[outer] = arr[min];
          arr[min] = temp;
        }
        if (animar)
        {
          dgv.Rows[linha].Cells[min].Style.BackColor = Color.Red;
          dgv.Rows[linha].Cells[outer].Style.BackColor = Color.Orange;
          Application.DoEvents();
        }
      }
    }
    public void InsertionSort()
    {
      if (animar)
      {
        dgv.Parent.Height = 165 + 22;
        dgv.Rows.Add(); // usado para organizar o DataGridView para exibição
      }
      int inner, temp, linha = 0;
      for (int outer = 1; outer < numElements; outer++)
      {
        temp = arr[outer];
        inner = outer;
        if (animar)
        {
          dgv.Parent.Height += 22;
          linha = dgv.Rows.Add();
          for (int indice = 0; indice < numElements; indice++)
            dgv.Rows[linha - 1].Cells[indice].Value = Convert.ToString(arr[indice]);
        }
        while (inner > 0 && arr[inner - 1] > temp)
        {
          arr[inner] = arr[inner - 1];
          inner -= 1;
        }
        arr[inner] = temp;
        if (animar)
        {
          dgv.Rows[linha - 1].Cells[inner].Style.BackColor = Color.Red;
          dgv.Rows[linha - 1].Cells[outer].Style.BackColor = Color.Orange;
          Application.DoEvents();
        }
      }
      if (animar)
        for (int indice = 0; indice < numElements; indice++)
          dgv.Rows[linha].Cells[indice].Value = Convert.ToString(arr[indice]);
    }
    public CArray Copiar()
    {
      CArray copia = new CArray(numElements, dgv, animar);
      for (int indice = 0; indice < numElements; indice++)
        copia.Insert(arr[indice]);
      return copia;
    }

    public void ShellSort()
    {
      if (animar)
      {
        dgv.Parent.Height = 165 + 22;
        dgv.Rows.Add(); // usado para organizar o DataGridView para exibição
      }

      int inner, temp, linha = 0;
      int h = 1;
      while (h <= numElements / 3)
        h = h * 3 + 1;

      while (h > 0)
      {
        if (animar)
        {
          dgv.Parent.Height += 22;
          linha = dgv.Rows.Add();
          for (int indice = 0; indice < numElements; indice++)
            dgv.Rows[linha - 1].Cells[indice].Value = Convert.ToString(arr[indice]);
        }
        for (int outer = h; outer <= numElements - 1; outer++)
        {
          temp = arr[outer];
          inner = outer;
          while ((inner > h - 1) && arr[inner - h] >= temp)
          {
            arr[inner] = arr[inner - h];
            inner -= h;
            if (animar)
            {
              dgv.Rows[linha - 1].Cells[inner].Style.BackColor = Color.Red;
              dgv.Rows[linha - 1].Cells[outer].Style.BackColor = Color.Orange;
              Application.DoEvents();
            }
          }
          arr[inner] = temp;
          if (animar)
          {
            dgv.Rows[linha - 1].Cells[inner].Style.BackColor = Color.Red;
            dgv.Rows[linha - 1].Cells[outer].Style.BackColor = Color.Orange;
            Application.DoEvents();
          }
        }
        h = (h - 1) / 3;
      }
      if (animar)
      {
        dgv.Parent.Height = 165 + 22;
        dgv.Rows.Add(); // usado para organizar o DataGridView para exibição
        for (int indice = 0; indice < numElements; indice++)
          dgv.Rows[linha].Cells[indice].Value = Convert.ToString(arr[indice]);
      }
    }


    public void MergeSort()
    {
      if (animar)
      {
        dgv.Parent.Height = 165 + 22;
        dgv.Rows.Add(); // usado para organizar o DataGridView para exibição
      }
      int[] tempArray = new int[numElements];
      RecMergeSort(tempArray, 0, numElements - 1);
      if (animar)
      {
        dgv.Parent.Height += 22;
        int linha = dgv.Rows.Add();
        for (int indice = 0; indice < numElements; indice++)
          dgv.Rows[linha - 1].Cells[indice].Value = Convert.ToString(arr[indice]);
        Application.DoEvents();
      }
    }
    public void RecMergeSort(int[] tempArray, int esquerdo, int direito)
    {
      int linha = 0;
      if (esquerdo == direito)
        return;
      else
      {
        int meio = (int)(esquerdo + direito) / 2;
        if (animar)
        {
          dgv.Parent.Height += 22;
          linha = dgv.Rows.Add();
          for (int indice = 0; indice < numElements; indice++)
            dgv.Rows[linha - 1].Cells[indice].Value = Convert.ToString(arr[indice]);
          dgv.Rows[linha - 1].Cells[esquerdo].Style.BackColor = Color.Red;
          dgv.Rows[linha - 1].Cells[meio + 1].Style.BackColor = Color.Green;
          dgv.Rows[linha - 1].Cells[direito].Style.BackColor = Color.Orange;
          Application.DoEvents();
        }
        RecMergeSort(tempArray, esquerdo, meio);
        RecMergeSort(tempArray, meio + 1, direito);
        Merge(tempArray, esquerdo, meio + 1, direito);
      }
    }
    public void Merge(int[] tempArray, int lowp, int highp, int ubound)
    {
      int lbound = lowp;
      int mid = highp - 1;
      int j = lowp;
      int n = (ubound - lbound) + 1;
      while ((lowp <= mid) && (highp <= ubound))
        if (arr[lowp] < arr[highp])
          tempArray[j++] = arr[lowp++];
        else
          tempArray[j++] = arr[highp++];
      while (lowp <= mid)
        tempArray[j++] = arr[lowp++];
      while (highp <= ubound)
        tempArray[j++] = arr[highp++];
      for (int i = 0; i <= n - 1; i++)
        arr[lbound + i] = tempArray[lbound + i];
    }


    public void QuickSort()
    {
      RecQSort(0, numElements - 1);
      if (animar)
      {
        dgv.Parent.Height += 22;
        int linha = dgv.Rows.Add();
        for (int indice = 0; indice < numElements; indice++)
          dgv.Rows[linha].Cells[indice].Value = Convert.ToString(arr[indice]);
        Application.DoEvents();
      }
    }
    public void RecQSort(int inicio, int fim)
    {
      if (fim <= inicio)
        return;
      else
      {
        int pivot = arr[fim];
        int part = this.Partition(inicio, fim);
        RecQSort(inicio, part - 1);
        RecQSort(part + 1, fim);
      }
    }
    public int Partition(int inicio, int fim)
    {
      int pivotVal = arr[inicio];
      int oPrimeiro = inicio;
      bool okSide;
      inicio++;
      do
      {
        okSide = true;
        while (okSide) // 4
          if (arr[inicio] > pivotVal)
            okSide = false;
          else
          {
            inicio++;
            okSide = (inicio <= fim);
          }
        okSide = (inicio <= fim);
        while (okSide) // 4
          if (arr[fim] <= pivotVal)
            okSide = false;
          else
          {
            fim--;
            okSide = (inicio <= fim);
          }
        if (inicio < fim)
        {
          Trocar(inicio, fim);
          if (animar)
          {
            dgv.Parent.Height += 22;
            int linha = dgv.Rows.Add();
            for (int indice = 0; indice < numElements; indice++)
              dgv.Rows[linha].Cells[indice].Value =
              Convert.ToString(arr[indice]);
            dgv.Rows[linha].Cells[inicio].Style.BackColor = Color.Red;
            dgv.Rows[linha].Cells[fim].Style.BackColor = Color.Orange;
            Application.DoEvents();
          }
          inicio++;
          fim--;
        }
      } while (inicio <= fim);
      Trocar(oPrimeiro, fim);
      return fim;
    }
    public void Trocar(int item1, int item2)
    {
      int temp = arr[item1];
      arr[item1] = arr[item2];
      arr[item2] = temp;
    }
  }
}
