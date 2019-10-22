namespace EDGrafos
{
    partial class frmGrafos
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
      this.tabControl1 = new System.Windows.Forms.TabControl();
      this.tpFundamentos = new System.Windows.Forms.TabPage();
      this.label2 = new System.Windows.Forms.Label();
      this.label1 = new System.Windows.Forms.Label();
      this.btnTeste2 = new System.Windows.Forms.Button();
      this.btnTeste1 = new System.Windows.Forms.Button();
      this.btnArvoreGeradoraMinima = new System.Windows.Forms.Button();
      this.txtSaida = new System.Windows.Forms.TextBox();
      this.dgvGrafo = new System.Windows.Forms.DataGridView();
      this.btnLargura = new System.Windows.Forms.Button();
      this.btnProfundidade = new System.Windows.Forms.Button();
      this.tpDjikstra = new System.Windows.Forms.TabPage();
      this.lsbSaida = new System.Windows.Forms.ListBox();
      this.btnBuscar = new System.Windows.Forms.Button();
      this.txtDestino = new System.Windows.Forms.TextBox();
      this.txtOrigem = new System.Windows.Forms.TextBox();
      this.label4 = new System.Windows.Forms.Label();
      this.label3 = new System.Windows.Forms.Label();
      this.tabControl1.SuspendLayout();
      this.tpFundamentos.SuspendLayout();
      ((System.ComponentModel.ISupportInitialize)(this.dgvGrafo)).BeginInit();
      this.tpDjikstra.SuspendLayout();
      this.SuspendLayout();
      // 
      // tabControl1
      // 
      this.tabControl1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
      this.tabControl1.Controls.Add(this.tpFundamentos);
      this.tabControl1.Controls.Add(this.tpDjikstra);
      this.tabControl1.Location = new System.Drawing.Point(12, 12);
      this.tabControl1.Name = "tabControl1";
      this.tabControl1.SelectedIndex = 0;
      this.tabControl1.Size = new System.Drawing.Size(654, 558);
      this.tabControl1.TabIndex = 9;
      // 
      // tpFundamentos
      // 
      this.tpFundamentos.Controls.Add(this.label2);
      this.tpFundamentos.Controls.Add(this.label1);
      this.tpFundamentos.Controls.Add(this.btnTeste2);
      this.tpFundamentos.Controls.Add(this.btnTeste1);
      this.tpFundamentos.Controls.Add(this.btnArvoreGeradoraMinima);
      this.tpFundamentos.Controls.Add(this.txtSaida);
      this.tpFundamentos.Controls.Add(this.dgvGrafo);
      this.tpFundamentos.Controls.Add(this.btnLargura);
      this.tpFundamentos.Controls.Add(this.btnProfundidade);
      this.tpFundamentos.Location = new System.Drawing.Point(4, 29);
      this.tpFundamentos.Name = "tpFundamentos";
      this.tpFundamentos.Padding = new System.Windows.Forms.Padding(3);
      this.tpFundamentos.Size = new System.Drawing.Size(646, 525);
      this.tpFundamentos.TabIndex = 1;
      this.tpFundamentos.Text = "Fundamentos";
      this.tpFundamentos.UseVisualStyleBackColor = true;
      // 
      // label2
      // 
      this.label2.AutoSize = true;
      this.label2.Location = new System.Drawing.Point(277, 10);
      this.label2.Name = "label2";
      this.label2.Size = new System.Drawing.Size(80, 20);
      this.label2.TabIndex = 17;
      this.label2.Text = "Percursos";
      // 
      // label1
      // 
      this.label1.AutoSize = true;
      this.label1.Location = new System.Drawing.Point(12, 10);
      this.label1.Name = "label1";
      this.label1.Size = new System.Drawing.Size(169, 20);
      this.label1.TabIndex = 16;
      this.label1.Text = "Ordenação Topológica";
      // 
      // btnTeste2
      // 
      this.btnTeste2.Location = new System.Drawing.Point(152, 44);
      this.btnTeste2.Name = "btnTeste2";
      this.btnTeste2.Size = new System.Drawing.Size(112, 46);
      this.btnTeste2.TabIndex = 15;
      this.btnTeste2.Text = "Vestir-se";
      this.btnTeste2.UseVisualStyleBackColor = true;
      this.btnTeste2.Click += new System.EventHandler(this.btnTeste2_Click);
      // 
      // btnTeste1
      // 
      this.btnTeste1.Location = new System.Drawing.Point(12, 44);
      this.btnTeste1.Name = "btnTeste1";
      this.btnTeste1.Size = new System.Drawing.Size(112, 46);
      this.btnTeste1.TabIndex = 14;
      this.btnTeste1.Text = "Itinerário";
      this.btnTeste1.UseVisualStyleBackColor = true;
      this.btnTeste1.Click += new System.EventHandler(this.btnTeste1_Click);
      // 
      // btnArvoreGeradoraMinima
      // 
      this.btnArvoreGeradoraMinima.Location = new System.Drawing.Point(512, 19);
      this.btnArvoreGeradoraMinima.Margin = new System.Windows.Forms.Padding(5, 4, 5, 4);
      this.btnArvoreGeradoraMinima.Name = "btnArvoreGeradoraMinima";
      this.btnArvoreGeradoraMinima.Size = new System.Drawing.Size(131, 71);
      this.btnArvoreGeradoraMinima.TabIndex = 13;
      this.btnArvoreGeradoraMinima.Text = "Árvore Geradora Mínima";
      this.btnArvoreGeradoraMinima.UseVisualStyleBackColor = true;
      this.btnArvoreGeradoraMinima.Click += new System.EventHandler(this.BtnArvoreGeradoraMinima_Click);
      // 
      // txtSaida
      // 
      this.txtSaida.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
      this.txtSaida.Location = new System.Drawing.Point(12, 97);
      this.txtSaida.Name = "txtSaida";
      this.txtSaida.Size = new System.Drawing.Size(628, 26);
      this.txtSaida.TabIndex = 12;
      // 
      // dgvGrafo
      // 
      this.dgvGrafo.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
      this.dgvGrafo.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
      this.dgvGrafo.Location = new System.Drawing.Point(11, 138);
      this.dgvGrafo.Name = "dgvGrafo";
      this.dgvGrafo.RowHeadersWidth = 62;
      this.dgvGrafo.RowTemplate.Height = 28;
      this.dgvGrafo.Size = new System.Drawing.Size(629, 381);
      this.dgvGrafo.TabIndex = 11;
      // 
      // btnLargura
      // 
      this.btnLargura.Location = new System.Drawing.Point(408, 44);
      this.btnLargura.Margin = new System.Windows.Forms.Padding(5, 4, 5, 4);
      this.btnLargura.Name = "btnLargura";
      this.btnLargura.Size = new System.Drawing.Size(94, 46);
      this.btnLargura.TabIndex = 10;
      this.btnLargura.Text = "Largura";
      this.btnLargura.UseVisualStyleBackColor = true;
      this.btnLargura.Click += new System.EventHandler(this.BtnLargura_Click);
      // 
      // btnProfundidade
      // 
      this.btnProfundidade.Location = new System.Drawing.Point(281, 44);
      this.btnProfundidade.Margin = new System.Windows.Forms.Padding(5, 4, 5, 4);
      this.btnProfundidade.Name = "btnProfundidade";
      this.btnProfundidade.Size = new System.Drawing.Size(117, 46);
      this.btnProfundidade.TabIndex = 9;
      this.btnProfundidade.Text = "Profundidade";
      this.btnProfundidade.UseVisualStyleBackColor = true;
      this.btnProfundidade.Click += new System.EventHandler(this.BtnProfundidade_Click);
      // 
      // tpDjikstra
      // 
      this.tpDjikstra.Controls.Add(this.lsbSaida);
      this.tpDjikstra.Controls.Add(this.btnBuscar);
      this.tpDjikstra.Controls.Add(this.txtDestino);
      this.tpDjikstra.Controls.Add(this.txtOrigem);
      this.tpDjikstra.Controls.Add(this.label4);
      this.tpDjikstra.Controls.Add(this.label3);
      this.tpDjikstra.Location = new System.Drawing.Point(4, 29);
      this.tpDjikstra.Name = "tpDjikstra";
      this.tpDjikstra.Padding = new System.Windows.Forms.Padding(3);
      this.tpDjikstra.Size = new System.Drawing.Size(646, 525);
      this.tpDjikstra.TabIndex = 0;
      this.tpDjikstra.Text = "Djikstra";
      this.tpDjikstra.UseVisualStyleBackColor = true;
      // 
      // lsbSaida
      // 
      this.lsbSaida.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
      this.lsbSaida.Font = new System.Drawing.Font("Arial", 9F);
      this.lsbSaida.FormattingEnabled = true;
      this.lsbSaida.ItemHeight = 15;
      this.lsbSaida.Location = new System.Drawing.Point(6, 47);
      this.lsbSaida.Name = "lsbSaida";
      this.lsbSaida.Size = new System.Drawing.Size(634, 469);
      this.lsbSaida.TabIndex = 5;
      // 
      // btnBuscar
      // 
      this.btnBuscar.Location = new System.Drawing.Point(252, 15);
      this.btnBuscar.Name = "btnBuscar";
      this.btnBuscar.Size = new System.Drawing.Size(80, 26);
      this.btnBuscar.TabIndex = 4;
      this.btnBuscar.Text = "Buscar";
      this.btnBuscar.UseVisualStyleBackColor = true;
      this.btnBuscar.Click += new System.EventHandler(this.BtnBuscar_Click);
      // 
      // txtDestino
      // 
      this.txtDestino.Location = new System.Drawing.Point(194, 15);
      this.txtDestino.Name = "txtDestino";
      this.txtDestino.Size = new System.Drawing.Size(38, 26);
      this.txtDestino.TabIndex = 3;
      // 
      // txtOrigem
      // 
      this.txtOrigem.Location = new System.Drawing.Point(81, 15);
      this.txtOrigem.Name = "txtOrigem";
      this.txtOrigem.Size = new System.Drawing.Size(37, 26);
      this.txtOrigem.TabIndex = 2;
      // 
      // label4
      // 
      this.label4.AutoSize = true;
      this.label4.Location = new System.Drawing.Point(124, 18);
      this.label4.Name = "label4";
      this.label4.Size = new System.Drawing.Size(64, 20);
      this.label4.TabIndex = 1;
      this.label4.Text = "Destino";
      // 
      // label3
      // 
      this.label3.AutoSize = true;
      this.label3.Location = new System.Drawing.Point(15, 18);
      this.label3.Name = "label3";
      this.label3.Size = new System.Drawing.Size(60, 20);
      this.label3.TabIndex = 0;
      this.label3.Text = "Origem";
      // 
      // frmGrafos
      // 
      this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
      this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
      this.AutoSize = true;
      this.ClientSize = new System.Drawing.Size(668, 582);
      this.Controls.Add(this.tabControl1);
      this.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
      this.Margin = new System.Windows.Forms.Padding(5, 4, 5, 4);
      this.Name = "frmGrafos";
      this.Text = "Operações com Grafos";
      this.tabControl1.ResumeLayout(false);
      this.tpFundamentos.ResumeLayout(false);
      this.tpFundamentos.PerformLayout();
      ((System.ComponentModel.ISupportInitialize)(this.dgvGrafo)).EndInit();
      this.tpDjikstra.ResumeLayout(false);
      this.tpDjikstra.PerformLayout();
      this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tpFundamentos;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnTeste2;
        private System.Windows.Forms.Button btnTeste1;
        private System.Windows.Forms.Button btnArvoreGeradoraMinima;
        private System.Windows.Forms.TextBox txtSaida;
        private System.Windows.Forms.DataGridView dgvGrafo;
        private System.Windows.Forms.Button btnLargura;
        private System.Windows.Forms.Button btnProfundidade;
        private System.Windows.Forms.TabPage tpDjikstra;
        private System.Windows.Forms.ListBox lsbSaida;
        private System.Windows.Forms.Button btnBuscar;
        private System.Windows.Forms.TextBox txtDestino;
        private System.Windows.Forms.TextBox txtOrigem;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
    }
}

