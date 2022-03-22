package pt.ipleiria.estg.es1.minesfinder;

import javax.swing.*;
import java.util.Random;

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

    private boolean primeiraJogada;
    protected boolean jogoTerminado;
    private boolean jogadorDerrotado;

    private long instanteInicioJogo;
    private long duracaoJogo;

    public CampoMinado(int altura, int largura, int numeroMinas){
        this.altura = altura;
        this.largura = largura;
        this.numeroMinas = numeroMinas;
        minas = new boolean[largura][altura]; // Valores começam a false
        estado = new int[largura][altura]; // Valores começam a 0 - começa tudo tapado

        primeiraJogada = true;
        jogadorDerrotado = false;
        jogoTerminado = false;

        for (var x = 0; x < largura; x++) {
            for (var y = 0; y < altura; y++) {
                estado[x][y] = TAPADO;
            }
        }
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

    public void revelarQuadricula(int x, int y) {
        if(isVitoria()){
            jogoTerminado = true;
            return;
        }

        if (jogoTerminado || estado[x][y] < TAPADO) { //Já está descoberto
            return;
        }

        // Inicializa o jogo quando for a primeira jogada para garantir que não perde logo
        if(primeiraJogada){
            colocarMinas(x,y);
            primeiraJogada = false;

            instanteInicioJogo = System.currentTimeMillis();
        }

        // Faz aqui qualquer coisa...
        //Se tiver mina rebenta
        if(hasMina(x,y)){
            estado[x][y] = CampoMinado.REBENTADO;
            jogadorDerrotado = true;
            jogoTerminado = true;
            duracaoJogo=System.currentTimeMillis()-instanteInicioJogo;
            return;
        }

        //Por agora só considero que ou tem mina ou está vazio
        int nMinas = contarMinasVizinhas(x,y);
        if (nMinas == 0){
            estado[x][y] = VAZIO;
            revelarQuadriculasVizinhas(x,y);
            duracaoJogo=System.currentTimeMillis()-instanteInicioJogo;
            return;
        }

        estado[x][y] = nMinas;
    }

    private void colocarMinas(int exceptoX, int exceptoY) {
        var aleatorio = new Random();
        int x = 0;
        int y = 0;
        for (int i = 0; i < numeroMinas; i++) {
            // Se a célula já tiver mina ou é a primeira escolhida gera outros números aletatórios
            do {
                x = aleatorio.nextInt(largura);
                y = aleatorio.nextInt(altura);
            } while (minas[x][y] || (x == exceptoX && y == exceptoY));
            minas[x][y] = true;
        }
    }

    public boolean isJogadorDerrotado() {
        return jogadorDerrotado;
    }

    public boolean isJogoTerminado() {
        return jogoTerminado;
    }

    private int contarMinasVizinhas(int x, int y) {
        var numMinasVizinhas = 0;
        for (var i = Math.max(0, x - 1); i < Math.min(largura, x + 2); i++) {
            for (var j = Math.max(0, y - 1); j < Math.min(altura, y + 2); j++) {
                if (minas[i][j]) {
                    ++numMinasVizinhas;
                }
            }
        }

        return numMinasVizinhas;
    }

    private void revelarQuadriculasVizinhas(int x, int y){
        for (var i = Math.max(0, x - 1); i < Math.min(largura, x + 2); i++) {
            for (var j = Math.max(0, y - 1); j < Math.min(altura, y + 2); j++) {
                if(!minas[x][y]) {
                    revelarQuadricula(i,j);
                }
            }
        }
    }

    protected boolean isVitoria() {
        for (int i = 0; i < largura; i++) {
            for (var j = 0 ; j < altura; j++) {
                if (!minas[i][j] && estado[i][j] >= TAPADO) {
                    return false;
                }
            }
        }
        return true;
    }

    protected void marcarComoTendoMina(int x, int y){
        if(estado[x][y]==CampoMinado.TAPADO || estado[x][y]==CampoMinado.DUVIDA){
            estado[x][y] = CampoMinado.MARCADO;
        }
    }

    protected void marcarComoSuspeita(int x, int y){
        if(estado[x][y]==CampoMinado.TAPADO || estado[x][y]==CampoMinado.MARCADO){
            estado[x][y] = CampoMinado.DUVIDA;
        }
    }

    protected void desmarcarQuadricula(int x, int y){
        if(estado[x][y]==CampoMinado.MARCADO || estado[x][y]==CampoMinado.DUVIDA){
            estado[x][y] = CampoMinado.TAPADO;
        }
    }

    public long getDuracaoJogo() {
        if (primeiraJogada) {
            return 0;
        }
        if (!jogoTerminado) {
            return System.currentTimeMillis() - instanteInicioJogo;
        }
        return duracaoJogo;
    }
}
