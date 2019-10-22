namespace OrdenacoesSimples
{
  partial class Form1
  {
    /// <summary>
    /// Variável de designer necessária.
    /// </summary>
    private System.ComponentModel.IContainer components = null;

    /// <summary>
    /// Limpar os recursos que estão sendo usados.
    /// </summary>
    /// <param name="disposing">true se for necessário descartar os recursos gerenciados; caso contrário, false.</param>
    protected override void Dispose(bool disposing)
    {
      if (disposing && (components != null))
      {
        components.Dispose();
      }
      base.Dispose(disposing);
    }

    #region Código gerado pelo Windows Form Designer

    /// <summary>
    /// Método necessário para suporte ao Designer - não modifique 
    /// o conteúdo deste método com o editor de código.
    /// </summary>
    private void InitializeComponent()
    {
      this.dgvVetor = new System.Windows.Forms.DataGridView();
      this.label1 = new System.Windows.Forms.Label();
      this.txtTamanho = new System.Windows.Forms.TextBox();
      this.chkAnimar = new System.Windows.Forms.CheckBox();
      this.btnPreencher = new System.Windows.Forms.Button();
      this.btnBubbleSort = new System.Windows.Forms.Button();
      this.btnAleatorio = new System.Windows.Forms.Button();
      this.btnInsertionSort = new System.Windows.Forms.Button();
      this.btnSelectionSort = new System.Windows.Forms.Button();
      this.lbBubble = new System.Windows.Forms.Label();
      this.lbSelection = new System.Windows.Forms.Label();
      this.lbInsertion = new System.Windows.Forms.Label();
      this.lbShell = new System.Windows.Forms.Label();
      this.btnShellSort = new System.Windows.Forms.Button();
      this.lbMerge = new System.Windows.Forms.Label();
      this.btnMergeSort = new System.Windows.Forms.Button();
      this.lbQuick = new System.Windows.Forms.Label();
      this.btnQuickSort = new System.Windows.Forms.Button();
      ((System.ComponentModel.ISupportInitialize)(this.dgvVetor)).BeginInit();
      this.SuspendLayout();
      // 
      // dgvVetor
      // 
      this.dgvVetor.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
      this.dgvVetor.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
      this.dgvVetor.Location = new System.Drawing.Point(3, 3);
      this.dgvVetor.Name = "dgvVetor";
      this.dgvVetor.Size = new System.Drawing.Size(732, 182);
      this.dgvVetor.TabIndex = 0;
      // 
      // label1
      // 
      this.label1.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.label1.AutoSize = true;
      this.label1.Location = new System.Drawing.Point(3, 192);
      this.label1.Name = "label1";
      this.label1.Size = new System.Drawing.Size(55, 13);
      this.label1.TabIndex = 1;
      this.label1.Text = "Tamanho:";
      // 
      // txtTamanho
      // 
      this.txtTamanho.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.txtTamanho.Location = new System.Drawing.Point(65, 192);
      this.txtTamanho.Name = "txtTamanho";
      this.txtTamanho.Size = new System.Drawing.Size(41, 20);
      this.txtTamanho.TabIndex = 2;
      // 
      // chkAnimar
      // 
      this.chkAnimar.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.chkAnimar.AutoSize = true;
      this.chkAnimar.Checked = true;
      this.chkAnimar.CheckState = System.Windows.Forms.CheckState.Checked;
      this.chkAnimar.Location = new System.Drawing.Point(6, 225);
      this.chkAnimar.Name = "chkAnimar";
      this.chkAnimar.Size = new System.Drawing.Size(58, 17);
      this.chkAnimar.TabIndex = 3;
      this.chkAnimar.Text = "Animar";
      this.chkAnimar.UseVisualStyleBackColor = true;
      // 
      // btnPreencher
      // 
      this.btnPreencher.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.btnPreencher.Location = new System.Drawing.Point(113, 192);
      this.btnPreencher.Name = "btnPreencher";
      this.btnPreencher.Size = new System.Drawing.Size(83, 23);
      this.btnPreencher.TabIndex = 4;
      this.btnPreencher.Text = "Preencher";
      this.btnPreencher.UseVisualStyleBackColor = true;
      this.btnPreencher.Click += new System.EventHandler(this.btnPreencher_Click);
      // 
      // btnBubbleSort
      // 
      this.btnBubbleSort.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.btnBubbleSort.Location = new System.Drawing.Point(202, 192);
      this.btnBubbleSort.Name = "btnBubbleSort";
      this.btnBubbleSort.Size = new System.Drawing.Size(83, 23);
      this.btnBubbleSort.TabIndex = 5;
      this.btnBubbleSort.Text = "Bubble Sort";
      this.btnBubbleSort.UseVisualStyleBackColor = true;
      this.btnBubbleSort.Click += new System.EventHandler(this.btnBubbleSort_Click);
      // 
      // btnAleatorio
      // 
      this.btnAleatorio.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.btnAleatorio.Location = new System.Drawing.Point(114, 221);
      this.btnAleatorio.Name = "btnAleatorio";
      this.btnAleatorio.Size = new System.Drawing.Size(82, 23);
      this.btnAleatorio.TabIndex = 6;
      this.btnAleatorio.Text = "Aleatório";
      this.btnAleatorio.UseVisualStyleBackColor = true;
      this.btnAleatorio.Click += new System.EventHandler(this.btnAleatorio_Click);
      // 
      // btnInsertionSort
      // 
      this.btnInsertionSort.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.btnInsertionSort.Location = new System.Drawing.Point(376, 192);
      this.btnInsertionSort.Name = "btnInsertionSort";
      this.btnInsertionSort.Size = new System.Drawing.Size(80, 23);
      this.btnInsertionSort.TabIndex = 7;
      this.btnInsertionSort.Text = "Insertion Sort";
      this.btnInsertionSort.UseVisualStyleBackColor = true;
      this.btnInsertionSort.Click += new System.EventHandler(this.btnInsertionSort_Click);
      // 
      // btnSelectionSort
      // 
      this.btnSelectionSort.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.btnSelectionSort.Location = new System.Drawing.Point(288, 192);
      this.btnSelectionSort.Name = "btnSelectionSort";
      this.btnSelectionSort.Size = new System.Drawing.Size(82, 23);
      this.btnSelectionSort.TabIndex = 8;
      this.btnSelectionSort.Text = "Selection Sort";
      this.btnSelectionSort.UseVisualStyleBackColor = true;
      this.btnSelectionSort.Click += new System.EventHandler(this.btnSelectionSort_Click);
      // 
      // lbBubble
      // 
      this.lbBubble.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.lbBubble.AutoSize = true;
      this.lbBubble.Location = new System.Drawing.Point(202, 225);
      this.lbBubble.Name = "lbBubble";
      this.lbBubble.Size = new System.Drawing.Size(40, 13);
      this.lbBubble.TabIndex = 10;
      this.lbBubble.Text = "Tempo";
      // 
      // lbSelection
      // 
      this.lbSelection.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.lbSelection.AutoSize = true;
      this.lbSelection.Location = new System.Drawing.Point(285, 225);
      this.lbSelection.Name = "lbSelection";
      this.lbSelection.Size = new System.Drawing.Size(40, 13);
      this.lbSelection.TabIndex = 11;
      this.lbSelection.Text = "Tempo";
      // 
      // lbInsertion
      // 
      this.lbInsertion.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.lbInsertion.AutoSize = true;
      this.lbInsertion.Location = new System.Drawing.Point(373, 225);
      this.lbInsertion.Name = "lbInsertion";
      this.lbInsertion.Size = new System.Drawing.Size(40, 13);
      this.lbInsertion.TabIndex = 12;
      this.lbInsertion.Text = "Tempo";
      // 
      // lbShell
      // 
      this.lbShell.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.lbShell.AutoSize = true;
      this.lbShell.Location = new System.Drawing.Point(459, 225);
      this.lbShell.Name = "lbShell";
      this.lbShell.Size = new System.Drawing.Size(40, 13);
      this.lbShell.TabIndex = 14;
      this.lbShell.Text = "Tempo";
      // 
      // btnShellSort
      // 
      this.btnShellSort.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.btnShellSort.Location = new System.Drawing.Point(462, 192);
      this.btnShellSort.Name = "btnShellSort";
      this.btnShellSort.Size = new System.Drawing.Size(80, 23);
      this.btnShellSort.TabIndex = 13;
      this.btnShellSort.Text = "Shell Sort";
      this.btnShellSort.UseVisualStyleBackColor = true;
      this.btnShellSort.Click += new System.EventHandler(this.btnShellSort_Click);
      // 
      // lbMerge
      // 
      this.lbMerge.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.lbMerge.AutoSize = true;
      this.lbMerge.Location = new System.Drawing.Point(545, 225);
      this.lbMerge.Name = "lbMerge";
      this.lbMerge.Size = new System.Drawing.Size(40, 13);
      this.lbMerge.TabIndex = 16;
      this.lbMerge.Text = "Tempo";
      // 
      // btnMergeSort
      // 
      this.btnMergeSort.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.btnMergeSort.Location = new System.Drawing.Point(548, 192);
      this.btnMergeSort.Name = "btnMergeSort";
      this.btnMergeSort.Size = new System.Drawing.Size(80, 23);
      this.btnMergeSort.TabIndex = 15;
      this.btnMergeSort.Text = "Merge Sort";
      this.btnMergeSort.UseVisualStyleBackColor = true;
      this.btnMergeSort.Click += new System.EventHandler(this.btnMergeSort_Click);
      // 
      // lbQuick
      // 
      this.lbQuick.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.lbQuick.AutoSize = true;
      this.lbQuick.Location = new System.Drawing.Point(631, 225);
      this.lbQuick.Name = "lbQuick";
      this.lbQuick.Size = new System.Drawing.Size(40, 13);
      this.lbQuick.TabIndex = 18;
      this.lbQuick.Text = "Tempo";
      // 
      // btnQuickSort
      // 
      this.btnQuickSort.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
      this.btnQuickSort.Location = new System.Drawing.Point(634, 192);
      this.btnQuickSort.Name = "btnQuickSort";
      this.btnQuickSort.Size = new System.Drawing.Size(80, 23);
      this.btnQuickSort.TabIndex = 17;
      this.btnQuickSort.Text = "Quick Sort";
      this.btnQuickSort.UseVisualStyleBackColor = true;
      this.btnQuickSort.Click += new System.EventHandler(this.btnQuickSort_Click);
      // 
      // Form1
      // 
      this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
      this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
      this.BackColor = System.Drawing.SystemColors.InactiveCaption;
      this.ClientSize = new System.Drawing.Size(738, 245);
      this.Controls.Add(this.lbQuick);
      this.Controls.Add(this.btnQuickSort);
      this.Controls.Add(this.lbMerge);
      this.Controls.Add(this.btnMergeSort);
      this.Controls.Add(this.lbShell);
      this.Controls.Add(this.btnShellSort);
      this.Controls.Add(this.lbInsertion);
      this.Controls.Add(this.lbSelection);
      this.Controls.Add(this.lbBubble);
      this.Controls.Add(this.btnSelectionSort);
      this.Controls.Add(this.btnInsertionSort);
      this.Controls.Add(this.btnAleatorio);
      this.Controls.Add(this.btnBubbleSort);
      this.Controls.Add(this.btnPreencher);
      this.Controls.Add(this.chkAnimar);
      this.Controls.Add(this.txtTamanho);
      this.Controls.Add(this.label1);
      this.Controls.Add(this.dgvVetor);
      this.Name = "Form1";
      this.Text = "Ordenações Simples";
      ((System.ComponentModel.ISupportInitialize)(this.dgvVetor)).EndInit();
      this.ResumeLayout(false);
      this.PerformLayout();

    }

    #endregion

    private System.Windows.Forms.DataGridView dgvVetor;
    private System.Windows.Forms.Label label1;
    private System.Windows.Forms.TextBox txtTamanho;
    private System.Windows.Forms.CheckBox chkAnimar;
    private System.Windows.Forms.Button btnPreencher;
    private System.Windows.Forms.Button btnBubbleSort;
    private System.Windows.Forms.Button btnAleatorio;
    private System.Windows.Forms.Button btnInsertionSort;
    private System.Windows.Forms.Button btnSelectionSort;
    private System.Windows.Forms.Label lbBubble;
    private System.Windows.Forms.Label lbSelection;
    private System.Windows.Forms.Label lbInsertion;
    private System.Windows.Forms.Label lbShell;
    private System.Windows.Forms.Button btnShellSort;
    private System.Windows.Forms.Label lbMerge;
    private System.Windows.Forms.Button btnMergeSort;
    private System.Windows.Forms.Label lbQuick;
    private System.Windows.Forms.Button btnQuickSort;
  }
}

