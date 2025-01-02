package gerenciadores;

import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;

public class GerenciadorConta {

	public static ContaPoupanca criarConta(int numero, double taxaRendimento) {
		return new ContaPoupanca(numero, taxaRendimento);
	}

	public  static ContaCorrente criarConta(int numeroConta, double taxaManutencao, double chequeEspecial){
		return  new ContaCorrente(numeroConta, taxaManutencao, chequeEspecial);
	}

}
