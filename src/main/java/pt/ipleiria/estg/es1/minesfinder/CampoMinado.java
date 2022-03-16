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

    private boolean[][] minas;
    private int[][] estado;

    public CampoMinado(int altura, int largura, int numeroMinas){
        this.altura = altura;
        this.largura = largura;
        this.numeroMinas = numeroMinas;
        minas = new boolean[largura][altura]; // Valores começam a false
        estado = new int[largura][altura]; // Valores começam a 0 - começa tudo tapado
    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }

    public int getEstadoQuadricula(int x, int y) {
        return estado[x][y];
    }
    public boolean hasMina(int x, int y) {
        return minas[x][y];
    }
}