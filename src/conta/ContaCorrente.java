package conta;

public class ContaCorrente extends Conta {
	private double taxaManutencao;
	private double chequeEspecial;

	public ContaCorrente(int numeroConta, int digito, double taxaManutencao, double chequeEspecial) {
		super(numeroConta, digito);
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
		System.out.println("Conta Corrente. Número da conta: " + getNUMEROCONTA() + ", taxa de manutenção: " + taxaManutencao + "%, saldo: " + getSaldo());
		System.out.println("Taxa de manutenção: " + getTaxaManutencao() + ", " + "cheque especial: " + getChequeEspecial());
	}
}
