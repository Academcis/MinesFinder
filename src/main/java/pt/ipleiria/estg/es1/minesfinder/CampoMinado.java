package pt.ipleiria.estg.es1.minesfinder;

public class CampoMinado {
    private int largura;
    private int altura;
    private int numeroMinas;

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
