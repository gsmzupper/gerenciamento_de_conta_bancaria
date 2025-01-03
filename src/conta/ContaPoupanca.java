package conta;

public class ContaPoupanca extends Conta {
	private final double TAXARENDIMENTO;

	public ContaPoupanca(int numeroConta, double TAXARENDIMENTO) {

		super(numeroConta);

		if (TAXARENDIMENTO <= 0) {
			throw new IllegalArgumentException("Erro: o valor da taxa deve ser maior que 0!");
		}

		this.TAXARENDIMENTO = TAXARENDIMENTO;
	}



	@Override
	public void exibeDetalhes() {
		System.out.println("Conta poupança. Número da conta: " + getNUMEROCONTA() + ", taxa de rendimento: " + TAXARENDIMENTO + "%, saldo: " + getSaldo());
	}

}
