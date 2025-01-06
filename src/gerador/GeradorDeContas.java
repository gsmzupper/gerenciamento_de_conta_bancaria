package gerador;

import java.util.Random;

public class GeradorDeContas {
    private static final Random geradorDeNumero = new Random();

    public static int numeroDaConta() {
        return 10000000 + geradorDeNumero.nextInt(9999999);
    }

    public static int numeroDigito() {
        return 1 + geradorDeNumero.nextInt(9);
    }
}
