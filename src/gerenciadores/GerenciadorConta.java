package gerenciadores;

import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;

public class GerenciadorConta {

	public static ContaPoupanca criarConta(int numero, int digito, double taxaRendimento) {
		return new ContaPoupanca(numero, digito, taxaRendimento);
	}

	public  static ContaCorrente criarConta(int numeroConta, int digito, double taxaManutencao, double chequeEspecial){
		return  new ContaCorrente(numeroConta, digito, taxaManutencao, chequeEspecial);
	}

}
