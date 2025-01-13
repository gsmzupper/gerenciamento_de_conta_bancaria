package operacoes;

import conta.Conta;

import java.lang.reflect.Field;

public class Sacar implements Operacoes {
    private final String numeroDaConta;
    private final double valor;
    private Conta conta;

    public Sacar(String numeroDaConta, double valor, Conta conta) {
        verificaNumeroDaConta(numeroDaConta);
        validaValor(valor);
        verificaConta(conta);
        this.numeroDaConta = numeroDaConta;
        this.valor = valor;
        this.conta = conta;
    }

    private static void verificaNumeroDaConta(String numeroDaConta) {
        if (numeroDaConta == null) {
            throw new IllegalArgumentException("O número da conta não pode ser nulo.");
        }
    }

    private static void validaValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor tem que ser maior que (0).");
        }
    }

    private static void verificaConta(Conta conta) {
        if (conta == null) {
            throw new IllegalArgumentException("A conta não pode ser nula.");
        }
    }

    @Override
    public void operacao() {
        if (this.conta.getSaldo() < this.valor) {
            System.out.println("O saque não pode ser realisado pois o saldo era insuficiente.");
        } else {
            try {
                Field saldoField = Conta.class.getDeclaredField("saldo");
                saldoField.setAccessible(true);
                double novoSaldo = this.conta.getSaldo() - this.valor;
                saldoField.set(this.conta, novoSaldo);
                System.out.println("Saque realizado com sucesso. Novo saldo: " + novoSaldo);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao atualizar o saldo.", e);
            }
        }
    }
}
