package pt.ipleiria.estg.es1.minesfinder;

import javax.swing.*;
import java.awt.*;

public class JanelaDeJogo extends JFrame{
    private JPanel painelJogo; // painel do jogo. O nome é definido no modo Design, em "field name"

    public JanelaDeJogo(String title) {
        super(title);

        painelJogo.setLayout(new GridLayout(10,20));

        // Adicionar os botões
        for (int i=0; i<150; i++){
            JButton btn = new JButton();
            painelJogo.add(btn);
        }
        setContentPane(painelJogo);

        // Destrói esta janela, removendo-a completamente da memória.
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        pack();
    }
}
