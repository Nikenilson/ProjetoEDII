using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HashChaveString01
{
  class Program
  {

    static void Main(string[] args)
    {

      MetodoBucketHash();
     // MetodosHashComColisoes();
    }
    static void MetodoBucketHash()
    {
      BucketHash balde = new BucketHash();
      string[] someNames = new string[]
      {"David", "Jennifer", "Donnie", "Mayo", "Raymond",
       "Bernica", "Mike", "Clayton", "Beata", "Michael",
        "Felipe","Silvana","Michael","Lucia", "Guilherme",
        "Monica"};
      for (int i = 0; i < someNames.Length; i++)
        balde.Insert(someNames[i]);
      balde.Exibir();
      if (balde.Remove("Raymond"))
        Console.WriteLine("Removeu: Raymond");
      else
        Console.WriteLine("Não achou: Bernica");
      balde.Exibir();
      if (balde.Remove("Chico"))
        Console.WriteLine("Removeu: Chico");
      else
        Console.WriteLine("Não achou: Chico");
      balde.Exibir();
    }

    static void MetodosHashComColisoes()
    {
      string[] tabelaDeHash = new string[10008];
      string name;
      string[] someNames = new string[]{"David", "Jennifer", "Donnie", "Mayo", "Raymond",
                                        "Bernica", "Mike", "Clayton", "Beata", "Michael",
      "Francisco da Fonseca Rodrigues"};

      //////////////////////////////////////// CASO 1

      Console.WriteLine("\n--------------------------------------------------------------");
      LimparTabelaDeHash(tabelaDeHash);
      int ultimoIndice = 100;
      int valorDeHash;
      for (int i = 0; i < someNames.Length; i++)
      {
        name = someNames[i];
        valorDeHash = HashSimples(name, ultimoIndice);

        if (tabelaDeHash[valorDeHash] != null)
          Console.WriteLine($"\nColisão na posição {valorDeHash} entre os itens " +
                            $"{tabelaDeHash[valorDeHash]} e {name}");

        tabelaDeHash[valorDeHash] = name;
      }

      ExibirDistribuicao(tabelaDeHash, $"\nCaso 1: Hash simples, último índice = {ultimoIndice}");
      Console.ReadKey();

      //////////////////////////////////////// CASO 2
      Console.WriteLine("\n--------------------------------------------------------------");
      LimparTabelaDeHash(tabelaDeHash);
      ultimoIndice = 10007;
      for (int i = 0; i < someNames.Length; i++)
      {
        name = someNames[i];
        valorDeHash = HashSimples(name, ultimoIndice);

        if (tabelaDeHash[valorDeHash] != null)
          Console.WriteLine($"\nColisão na posição {valorDeHash} entre os itens " +
                            $"{tabelaDeHash[valorDeHash]} e {name}");

        tabelaDeHash[valorDeHash] = name;
      }

      ExibirDistribuicao(tabelaDeHash, $"\nCaso 2: Hash simples, último índice = {ultimoIndice}");
      Console.ReadKey();

      //////////////////////////////////////// CASO 3
      Console.WriteLine("\n--------------------------------------------------------------");
      LimparTabelaDeHash(tabelaDeHash);
      ultimoIndice = 10007;
      for (int i = 0; i < someNames.Length; i++)
      {
        name = someNames[i];
        valorDeHash = HashAprimorado(name, ultimoIndice);

        if (tabelaDeHash[valorDeHash] != null)
          Console.WriteLine($"\nColisão na posição {valorDeHash} entre os itens " +
                            $"{tabelaDeHash[valorDeHash]} e {name}");

        tabelaDeHash[valorDeHash] = name;
      }

      ExibirDistribuicao(tabelaDeHash, $"\nCaso 3: Hash aprimorado, último índice = {ultimoIndice}");
      Console.ReadKey();

      int posicaoEncontrada;
      string nome = "";
      do
      {
        Console.WriteLine("Digite um nome para procurar:");
        nome = Console.ReadLine();
        if (nome != "")
        {
          if (EstaNoHash(nome, tabelaDeHash, out posicaoEncontrada))
            Console.WriteLine($"\n\nO nome {nome} foi encontrado na posicao {posicaoEncontrada} da tabela");
          else
            Console.WriteLine("\n\nNão foi encontrado ou foi perdido numa colisão!");
          Console.ReadKey();
        }
      }
      while (nome != "");

    }

    static int HashSimples(string s, int indiceFinalDaTabela)
    {
      int tot = 0;
      char[] cname;
      cname = s.ToUpper().ToCharArray();
      for (int i = 0; i <= cname.GetUpperBound(0); i++)
        tot += (int)cname[i];  // somatória da conversão de cada caracter para código ASCII
      return tot % indiceFinalDaTabela;
    }

    static int HashAprimorado(string s, int indiceFinalDaTabela)
    {
      long tot = 0;
      char[] cname;
      cname = s.ToUpper().ToCharArray();
      for (int i = 0; i <= cname.GetUpperBound(0); i++)
        tot += 37 * tot + (int)cname[i];
      tot = tot % indiceFinalDaTabela;
      if (tot < 0)
        tot += indiceFinalDaTabela;
      return (int) tot;
    }

    static void ExibirDistribuicao(string[] tabela, string cabecalho)
    {
      Console.WriteLine("\n" + cabecalho + "\n");
      for (int i = 0; i <= tabela.GetUpperBound(0); i++)
          if (tabela[i] != null)
             Console.WriteLine(i + " " + tabela[i]);
    }

    static void LimparTabelaDeHash(string[] tabela)
    {
      for (int i = 0; i <= tabela.GetUpperBound(0); i++)
        tabela[i] = null;
    }

    static bool EstaNoHash(string procurado, string[] tabela, out int posicao)
    {
      posicao = HashAprimorado(procurado, tabela.GetUpperBound(0));
      if (tabela[posicao] == null)
         return false;

      if (tabela[posicao].ToUpper() == procurado.ToUpper())
        return true;
      else
        return false;
    }
  }
}
