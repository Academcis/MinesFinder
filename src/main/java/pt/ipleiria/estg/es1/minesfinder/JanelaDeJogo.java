package pt.ipleiria.estg.es1.minesfinder;

import javax.swing.*;
import java.awt.*;

public class JanelaDeJogo extends JFrame{
    private JPanel painelJogo; // painel do jogo. O nome é definido no modo Design, em "field name"

    public JanelaDeJogo(String title, CampoMinado campoMinado) {
        super(title);

        int largura = campoMinado.getLargura();
        int altura = campoMinado.getAltura();
        painelJogo.setLayout(new GridLayout(largura,altura));

        // Adicionar os botões
        for (int linha=0; linha<altura; linha++) {
            for (int coluna=0; coluna<largura; coluna++){
                JButton btn = new JButton();
                btn.setText("C"+coluna+"L"+linha);
                painelJogo.add(btn);
            }
        }
        setContentPane(painelJogo);

        // Destrói esta janela, removendo-a completamente da memória.
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        pack();
    }
}
