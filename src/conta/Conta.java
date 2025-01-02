package conta;

public abstract class Conta {
	private final int NUMEROCONTA;
	private double saldo;

	public Conta(int NUMEROCONTA) {
		int limiteMinimo = 10000000;
		int limiteMaximo = 99999999;

		if (NUMEROCONTA < limiteMinimo || NUMEROCONTA > limiteMaximo) {
			throw new IllegalArgumentException("Erro: o número da conta deve possuir 8 dígitos!");
		}

		this.NUMEROCONTA = NUMEROCONTA;
		this.saldo = 0;
	}

	public int getNUMEROCONTA() {
		return NUMEROCONTA;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void adiciona(double valor) {
		this.saldo += valor;
	}

	protected void subtrai(double valor) {
		this.saldo -= valor;
	}

	public abstract void exibeDetalhes();
}

