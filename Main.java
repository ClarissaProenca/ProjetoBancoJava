import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
  static Scanner entrada = new Scanner(System.in);

  static CDB cdb = new CDB();
  static LCI lci =  new LCI();
  static LCA lca = new LCA();
  static Poupanca poupanca = new Poupanca();

  public static void GuardaDados(String nome, String cpf, String banco, double cdb, double lci, double lca, double poupanca) throws IOException{
    FileWriter arquivo = new FileWriter(new File("contas.txt"), true);
    arquivo.write("nome:" + nome +", cpf: " + cpf +",banco:" + banco +", CDB: " + cdb +", LCI: " + lci +", LCA: "+ lca +", Poupança: "+ poupanca + "\n");
    System.out.println("Sucesso na escrita de dados");
    arquivo.close();
  }

  public static void main(String[] args) throws IOException{

    String nome, cpf, banco;
    double valor, taxaSelic;
    int meses;
    
    System.out.println("Informe nome: ");
    nome = entrada.nextLine();
    System.out.println("Informe cpf: ");
    cpf = entrada.nextLine();
    System.out.println("Informe banco: ");
    banco = entrada.nextLine();

    try{
      System.out.println("Informe o valor a ser investido em R$: ");
      valor = entrada.nextDouble();
      System.out.println("Informe o tempo em meses que o dinheiro irá render: ");
      meses = entrada.nextInt();
      System.out.println("Informe a taxa SELIC: ");
      taxaSelic = entrada.nextDouble();
      
      //===============rendimento===============
      double valorCDB = cdb.CalcularRendimento(valor, meses, taxaSelic);
      double valorLCI = lci.CalcularRendimento(valor, meses, taxaSelic);
      double valorLCA = lca.CalcularRendimento(valor, meses, taxaSelic);
      double valorPoupanca = poupanca.CalcularRendimento(valor, meses, taxaSelic);

      //============montante total==============
      double montanteFinalCDB = cdb.CalcularTotal(valor, meses, taxaSelic);
      double montanteFinalLCI = lci.CalcularTotal(valor, meses, taxaSelic);
      double montanteFinalLCA = lca.CalcularTotal(valor, meses, taxaSelic);
      double montanteFinalPoupanca = poupanca.CalcularTotal(valor, meses, taxaSelic);

      System.out.println("\n===========================================\n");
      System.out.println("Rendimento líquido: \nCDB: " + valorCDB + "\nLCI: " + valorLCI + "\nLCA: " + valorLCA + "\nPoupança: " + valorPoupanca);
      System.out.println("\n===========================================\n");
      System.out.println("Valores acumulados: \nCDB: " + montanteFinalCDB + "\nLCI: " + montanteFinalLCI + "\nLCA: " + montanteFinalLCA + "\nPoupança: " + montanteFinalPoupanca);
      System.out.println("\n===========================================\n");
  
      GuardaDados(nome, cpf, banco, montanteFinalCDB, montanteFinalLCI, montanteFinalLCA, montanteFinalPoupanca);
      }catch (InputMismatchException e) {
          System.out.println("Erro: Digite apenas números válidos.");
      } catch (Exception e) {
          System.out.println("Erro desconhecido: " + e.getMessage());
      }
    }
  }