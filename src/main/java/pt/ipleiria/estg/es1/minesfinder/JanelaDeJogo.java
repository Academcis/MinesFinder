package pt.ipleiria.estg.es1.minesfinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JanelaDeJogo extends JFrame{
    private JPanel painelJogo; // painel do jogo. O nome é definido no modo Design, em "field name"
    private botaoCampoMinado[][] botoes;
    private CampoMinado campoMinado;

    public JanelaDeJogo(String title, CampoMinado campoMinado) {
        super(title);

        int largura = campoMinado.getLargura();
        int altura = campoMinado.getAltura();
        this.campoMinado = campoMinado;

        this.botoes = new botaoCampoMinado[largura][altura];

        painelJogo.setLayout(new GridLayout(largura,altura));

        // Adicionar os botões
        for (int linha=0; linha<altura; linha++) {
            for (int coluna=0; coluna<largura; coluna++){
                //btn.setText("C"+coluna+"L"+linha);
               // btn.setEstado(linha);
                botoes[coluna][linha] = new botaoCampoMinado(linha, coluna);
                botoes[coluna][linha].addActionListener(this::btnCampoMinadoActionPerformed);
                painelJogo.add(botoes[coluna][linha]);
            }
        }

        setContentPane(painelJogo);
        // Destrói esta janela, removendo-a completamente da memória.
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
    }

    public void btnCampoMinadoActionPerformed(ActionEvent e) {
        var botao = (botaoCampoMinado) e.getSource();
        int y = botao.getLinha();
        int x = botao.getColuna();
        campoMinado.revelarQuadricula(x, y);
        actualizarEstadoBotoes();
    }

    private void actualizarEstadoBotoes() {
        for (int x = 0; x < campoMinado.getLargura(); x++) {
            for (int y = 0; y < campoMinado.getAltura(); y++) {
                botoes[x][y].setEstado(campoMinado.getEstadoQuadricula(x, y));
            }
        }
    }
}
