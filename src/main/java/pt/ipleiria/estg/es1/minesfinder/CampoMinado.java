package pt.ipleiria.estg.es1.minesfinder;

public class CampoMinado {
    public static final int VAZIO = 0;
    /* de 1 a 8 são o número de minas à volta */
    public static final int TAPADO = 9;
    public static final int DUVIDA = 10;
    public static final int MARCADO = 11;
    public static final int REBENTADO = 12;

    private final int largura;
    private final int altura;
    private final int numeroMinas;

    public CampoMinado(int altura, int largura, int numeroMinas){
        this.altura = altura;
        this.largura = largura;
        this.numeroMinas = numeroMinas;
    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }
}
