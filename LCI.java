public final class LCI extends RendaFixa implements IRenda {
  private double juros = 1; // convertido de 100%;

  public LCI() {
  }

  public LCI(String nome, String cpf, String banco) {
    super(nome, cpf, banco);
  }

  public double getJuros() {
    return this.juros;
  }

  public double CalcularRendimento(double valor, int meses, double taxaSelic) {
    double taxaCDI = taxaSelic / 100;
    double taxaMensal = Math.pow(1 + taxaCDI, 1.0 / 12) - 1;
    // double jurosResultante = taxaMensal * this.juros * valor * meses;
    double montante = valor * Math.pow((1 + taxaMensal), meses);
    return (montante - valor);
  }

  public double CalcularTotal(double valor, int meses, double taxaSelic) {
    double rendimento = CalcularRendimento(valor, meses, taxaSelic);
    return valor + rendimento;
  }
}