using System;

public class NoArvore<Tipo> : IComparable<NoArvore<Tipo>>, IGravarEmArquivo
                              where Tipo : IComparable<Tipo>
{
  Tipo info;  // informação armazenada
  NoArvore<Tipo> esq, dir;
  int altura;

  public NoArvore(Tipo dado, NoArvore<Tipo> esquerda, NoArvore<Tipo> direita)
  {
    Info = dado;
    Esq = esquerda;
    Dir = direita;
    altura = 0;
  }

  public NoArvore(Tipo dado) : this(dado, null, null)
  {
  }

  public NoArvore() : this(default(Tipo), null, null)
  {
  }
  public Tipo Info { get => info; set => info = value; }
  internal NoArvore<Tipo> Esq { get => esq; set => esq = value; }
  internal NoArvore<Tipo> Dir { get => dir; set => dir = value; }
  public int Altura { get => altura; set => altura = value; }

  public int CompareTo(NoArvore<Tipo> outro)
  {
    return info.CompareTo(outro.info);
  }

  public string ParaArquivo()
  {
    throw new NotImplementedException();
  }
}
