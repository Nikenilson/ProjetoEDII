namespace apArvore
{
  partial class FrmArvore
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
      this.pbArvore = new System.Windows.Forms.PictureBox();
      this.label1 = new System.Windows.Forms.Label();
      this.label2 = new System.Windows.Forms.Label();
      this.label3 = new System.Windows.Forms.Label();
      this.txtMatricula = new System.Windows.Forms.TextBox();
      this.txtNome = new System.Windows.Forms.TextBox();
      this.txtSalario = new System.Windows.Forms.TextBox();
      this.btnInserir = new System.Windows.Forms.Button();
      this.chkBalanceada = new System.Windows.Forms.CheckBox();
      this.label4 = new System.Windows.Forms.Label();
      this.lbAltura = new System.Windows.Forms.Label();
      this.label5 = new System.Windows.Forms.Label();
      this.txtResultado = new System.Windows.Forms.TextBox();
      ((System.ComponentModel.ISupportInitialize)(this.pbArvore)).BeginInit();
      this.SuspendLayout();
      // 
      // pbArvore
      // 
      this.pbArvore.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
      this.pbArvore.Location = new System.Drawing.Point(1, 69);
      this.pbArvore.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
      this.pbArvore.Name = "pbArvore";
      this.pbArvore.Size = new System.Drawing.Size(904, 589);
      this.pbArvore.TabIndex = 0;
      this.pbArvore.TabStop = false;
      this.pbArvore.Paint += new System.Windows.Forms.PaintEventHandler(this.pbArvore_Paint);
      // 
      // label1
      // 
      this.label1.AutoSize = true;
      this.label1.Location = new System.Drawing.Point(-2, 9);
      this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
      this.label1.Name = "label1";
      this.label1.Size = new System.Drawing.Size(69, 17);
      this.label1.TabIndex = 1;
      this.label1.Text = "Matrícula:";
      this.label1.Click += new System.EventHandler(this.label1_Click);
      // 
      // label2
      // 
      this.label2.AutoSize = true;
      this.label2.Location = new System.Drawing.Point(135, 9);
      this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
      this.label2.Name = "label2";
      this.label2.Size = new System.Drawing.Size(49, 17);
      this.label2.TabIndex = 2;
      this.label2.Text = "Nome:";
      // 
      // label3
      // 
      this.label3.AutoSize = true;
      this.label3.Location = new System.Drawing.Point(374, 9);
      this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
      this.label3.Name = "label3";
      this.label3.Size = new System.Drawing.Size(56, 17);
      this.label3.TabIndex = 3;
      this.label3.Text = "Salário:";
      // 
      // txtMatricula
      // 
      this.txtMatricula.Location = new System.Drawing.Point(68, 6);
      this.txtMatricula.Name = "txtMatricula";
      this.txtMatricula.Size = new System.Drawing.Size(60, 23);
      this.txtMatricula.TabIndex = 4;
      // 
      // txtNome
      // 
      this.txtNome.Location = new System.Drawing.Point(184, 6);
      this.txtNome.Name = "txtNome";
      this.txtNome.Size = new System.Drawing.Size(191, 23);
      this.txtNome.TabIndex = 5;
      // 
      // txtSalario
      // 
      this.txtSalario.Location = new System.Drawing.Point(426, 6);
      this.txtSalario.Name = "txtSalario";
      this.txtSalario.Size = new System.Drawing.Size(72, 23);
      this.txtSalario.TabIndex = 6;
      // 
      // btnInserir
      // 
      this.btnInserir.Location = new System.Drawing.Point(505, 6);
      this.btnInserir.Name = "btnInserir";
      this.btnInserir.Size = new System.Drawing.Size(75, 28);
      this.btnInserir.TabIndex = 7;
      this.btnInserir.Text = "Inserir";
      this.btnInserir.UseVisualStyleBackColor = true;
      this.btnInserir.Click += new System.EventHandler(this.btnInserir_Click);
      // 
      // chkBalanceada
      // 
      this.chkBalanceada.AutoSize = true;
      this.chkBalanceada.Location = new System.Drawing.Point(597, 6);
      this.chkBalanceada.Name = "chkBalanceada";
      this.chkBalanceada.Size = new System.Drawing.Size(110, 21);
      this.chkBalanceada.TabIndex = 8;
      this.chkBalanceada.Text = "Balanceada?";
      this.chkBalanceada.UseVisualStyleBackColor = true;
      // 
      // label4
      // 
      this.label4.AutoSize = true;
      this.label4.Location = new System.Drawing.Point(714, 6);
      this.label4.Name = "label4";
      this.label4.Size = new System.Drawing.Size(49, 17);
      this.label4.TabIndex = 9;
      this.label4.Text = "Altura:";
      // 
      // lbAltura
      // 
      this.lbAltura.AutoSize = true;
      this.lbAltura.Location = new System.Drawing.Point(759, 6);
      this.lbAltura.Name = "lbAltura";
      this.lbAltura.Size = new System.Drawing.Size(16, 17);
      this.lbAltura.TabIndex = 10;
      this.lbAltura.Text = "0";
      // 
      // label5
      // 
      this.label5.AutoSize = true;
      this.label5.Location = new System.Drawing.Point(1, 39);
      this.label5.Name = "label5";
      this.label5.Size = new System.Drawing.Size(76, 17);
      this.label5.TabIndex = 11;
      this.label5.Text = "Resultado:";
      // 
      // txtResultado
      // 
      this.txtResultado.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
      this.txtResultado.Location = new System.Drawing.Point(84, 39);
      this.txtResultado.Name = "txtResultado";
      this.txtResultado.Size = new System.Drawing.Size(821, 23);
      this.txtResultado.TabIndex = 12;
      // 
      // FrmArvore
      // 
      this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
      this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
      this.ClientSize = new System.Drawing.Size(910, 663);
      this.Controls.Add(this.txtResultado);
      this.Controls.Add(this.label5);
      this.Controls.Add(this.lbAltura);
      this.Controls.Add(this.label4);
      this.Controls.Add(this.chkBalanceada);
      this.Controls.Add(this.btnInserir);
      this.Controls.Add(this.txtSalario);
      this.Controls.Add(this.txtNome);
      this.Controls.Add(this.txtMatricula);
      this.Controls.Add(this.label3);
      this.Controls.Add(this.label2);
      this.Controls.Add(this.label1);
      this.Controls.Add(this.pbArvore);
      this.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
      this.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
      this.Name = "FrmArvore";
      this.Text = "Visualização de Árvore AVL";
      ((System.ComponentModel.ISupportInitialize)(this.pbArvore)).EndInit();
      this.ResumeLayout(false);
      this.PerformLayout();

    }

    #endregion

    private System.Windows.Forms.PictureBox pbArvore;
    private System.Windows.Forms.Label label1;
    private System.Windows.Forms.Label label2;
    private System.Windows.Forms.Label label3;
    private System.Windows.Forms.TextBox txtMatricula;
    private System.Windows.Forms.TextBox txtNome;
    private System.Windows.Forms.TextBox txtSalario;
    private System.Windows.Forms.Button btnInserir;
    private System.Windows.Forms.CheckBox chkBalanceada;
    private System.Windows.Forms.Label label4;
    private System.Windows.Forms.Label lbAltura;
    private System.Windows.Forms.Label label5;
    private System.Windows.Forms.TextBox txtResultado;
  }
}

