package gerador;

import java.util.Random;

public class GeradorDeContas {
    private static final Random geradorDeNumero = new Random();

    public static int numeroDaConta() {
        return 100000000 + geradorDeNumero.nextInt(90000000);
    }

    public static int numeroDigito() {
        return 1 + geradorDeNumero.nextInt(9);
    }
}
