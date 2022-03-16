package pt.ipleiria.estg.es1.minesfinder;

import javax.swing.*;
import java.awt.*;

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
                botaoCampoMinado btn = new botaoCampoMinado(campoMinado);
                //btn.setText("C"+coluna+"L"+linha);
               // btn.setEstado(linha);
                botoes[coluna][linha] = btn;
                painelJogo.add(btn);
            }
        }

        setContentPane(painelJogo);
        // Destrói esta janela, removendo-a completamente da memória.
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
    }
}
