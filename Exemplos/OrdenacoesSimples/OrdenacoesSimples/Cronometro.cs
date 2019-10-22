using System;
using System.Threading.Tasks;

namespace OrdenacoesSimples
{
  class Cronometro
  {
    DateTime tempoInicial;
    DateTime duracao;
    public Cronometro()
    {
      tempoInicial = DateTime.Now;
      duracao = tempoInicial;
    }

    public void iniciarCronometro()
    {
      tempoInicial = DateTime.Now;
    }

    public void pararCronometro()
    {
      duracao = DateTime.Now;
    }

    public TimeSpan TempoDecorrido
    {
      get => duracao.Subtract(tempoInicial);
    }
  }
}
