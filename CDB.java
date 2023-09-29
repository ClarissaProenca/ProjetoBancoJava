public final class CDB extends RendaFixa implements IRenda {
  private double juros = 1.20;

  public CDB() {
  }

  public CDB(String nome, String cpf, String banco) {
    super(nome, cpf, banco);
  }

  public void setJuros(double juros) {
    this.juros = juros;
  }

  public double getJuros() {
    return this.juros;
  }

  public double CalcularImpostoRenda(int meses) {
    double impRenda;
    if (meses <= 6) {
      impRenda = 0.225;
    } else if (meses <= 12) {
      impRenda = 0.20;
    } else if (meses <= 24) {
      impRenda = 0.175;
    } else {
      impRenda = 0.15;
    }
    return impRenda;
  }

  public double CalcularRendimento(double valor, int meses, double taxaSelic) {
    double taxaCDI = taxaSelic / 100;
    double taxaMensal = (Math.pow(1 + taxaCDI, 1.0 / 12) - 1) * 1.2;
    // double juros = taxaMensal * this.juros * valor * meses;
    double montante = valor * (Math.pow((1 + taxaMensal), meses));
    double juros = montante - valor;
    double imposto = CalcularImpostoRenda(meses);

    return juros * (1 - imposto);
  }

  public double CalcularTotal(double valor, int meses, double taxaSelic) {
    double rendimento = CalcularRendimento(valor, meses, taxaSelic);
    return valor + rendimento;
  }
}