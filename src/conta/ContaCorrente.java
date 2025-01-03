package conta;

public class ContaCorrente extends Conta {
	private double taxaManutencao;
	private double chequeEspecial;

	public ContaCorrente(int NUMEROCONTA, double taxaManutencao, double chequeEspecial) {
		super(NUMEROCONTA);
		this.taxaManutencao = taxaManutencao;
		this.chequeEspecial = chequeEspecial;
	}

	public double getTaxaManutencao() {
		return taxaManutencao;
	}

	public double getChequeEspecial() {
		return chequeEspecial;
	}

	@Override
	public void exibeDetalhes() {
		System.out.println("Conta Corrente. Número da conta: " + getNUMEROCONTA() + ", taxa de rendimento: " + TAXARENDIMENTO + "%, saldo: " + getSaldo());
		System.out.println("Taxa de manutenção: " + getTaxaManutencao() + ", " + "cheque especial: " + getChequeEspecial());
	}
}
