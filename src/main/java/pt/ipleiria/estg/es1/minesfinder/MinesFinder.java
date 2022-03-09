package pt.ipleiria.estg.es1.minesfinder;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MinesFinder extends JFrame{

    private JPanel painelPrincipal;
    private JButton jogoFácilButton;
    private JButton jogoMédioButton;
    private JButton jogoDifícilButton;
    private JButton btnSair;
    private JLabel northLabel;
    private JPanel westJPanel;
    private JPanel centerPanel;

    public MinesFinder(String title){
        super(title);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelPrincipal);
        pack();
        btnSair.addActionListener(this::btnSairActionPerformed);
    }

    private void btnSairActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public static void main(String[] args) {
        new MinesFinder("Mines Finder").setVisible(true);
    }
}
