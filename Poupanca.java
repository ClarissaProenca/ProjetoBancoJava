public final class Poupanca extends RendaFixa implements IRenda {
  private double juros;

  public Poupanca() {
  }

  public Poupanca(String nome, String cpf, String banco) {
    super(nome, cpf, banco);
  }

  public double getJuros() {
    return this.juros;
  }

  public double CalcularRendimento(double valor, int meses, double taxaSelic) {
    double montante = 0;
    if (taxaSelic >= 8.5) {
      double taxaMensal = 0.005; // 0,5% ao mês
      montante = valor * (Math.pow((1 + taxaMensal), meses));
    } else {
      double taxaMensal = 0.7 * taxaSelic / 100; // 70% da SELIC
      montante = valor * (Math.pow((1 + taxaMensal), meses));
    }

    return (montante - valor);
  }

  public double CalcularTotal(double valor, int meses, double taxaSelic) {
    double rendimento = CalcularRendimento(valor, meses, taxaSelic);
    return valor + rendimento;
  }
}