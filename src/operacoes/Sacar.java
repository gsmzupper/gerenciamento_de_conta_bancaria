package operacoes;

import conta.Conta;

import java.lang.reflect.Field;

public class Sacar implements Operacoes {
    private final double valor;
    private Conta conta;

    public Sacar(double valor, Conta conta) {
        validaValor(valor);
        verificaConta(conta);
        this.valor = valor;
        this.conta = conta;
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
