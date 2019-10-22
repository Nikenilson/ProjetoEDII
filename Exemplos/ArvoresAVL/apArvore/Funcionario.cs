using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace apArvore
{
  class Funcionario : IComparable<Funcionario>
  { 
    int matricula;
    string nome;
    double salario;

    public override string ToString()
    {
      return matricula+"";
    }
    public Funcionario()
    {
    }

    public Funcionario(int matricula, string nome, double salario)
    {
      this.matricula = matricula;
      this.nome = nome;
      this.salario = salario;
    }

    public int Matricula { get => matricula; set => matricula = value; }
    public string Nome { get => nome; set => nome = value; }
    public double Salario { get => salario; set => salario = value; }

    public int CompareTo(Funcionario outro)
    {
      return matricula - outro.matricula;
    }
  }
}
