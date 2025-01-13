package operacoes;

import conta.Conta;

import java.lang.reflect.Field;

public class Transferir implements Operacoes {
    private final double valor;
    private final Conta contaOrigem;
    private final Conta contaDestino;

    public Transferir(double valor, Conta contaOrigem, Conta contaDestino) {
        validaValor(valor);
        validaContaOrigem(contaOrigem);
        validaContaDestino(contaDestino);
        this.valor = valor;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    private static void validaValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor tem que ser maior que (0).");
        }
    }

    private static void validaContaOrigem(Conta origem) {
        if (origem == null) {
            throw new IllegalArgumentException("A conta de origem não pode ser nula.");
        }
    }

    private static void validaContaDestino(Conta destino) {
        if (destino == null) {
            throw new IllegalArgumentException("A conta de destino não pode ser nula.");
        }
    }

    @Override
    public void operacao() {
        if (this.contaOrigem.getSaldo() < this.valor) {
            System.out.println("A transferência não pode ser realizada pois o saldo é insuficiente.");
        } else {
            try {
                Field saldoField = Conta.class.getDeclaredField("saldo");
                saldoField.setAccessible(true);
                double novoSaldo = this.contaOrigem.getSaldo() - this.valor;
                saldoField.set(this.contaOrigem, novoSaldo);

                Field saldoDestino = Conta.class.getDeclaredField("saldo");
                saldoDestino.setAccessible(true);
                double novoSaldoDestino = this.contaDestino.getSaldo() + this.valor;
                saldoDestino.set(this.contaDestino, novoSaldoDestino);

                System.out.println("Transferência realizada com sucesso.");
                System.out.println("Novo saldo da conta de origem: " + novoSaldo);
                System.out.println("Novo saldo da conta de destino: " + novoSaldoDestino);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao atualizar os saldos.", e);
            }
        }
    }
}
