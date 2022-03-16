package pt.ipleiria.estg.es1.minesfinder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinesFinder extends JFrame{

    private JPanel painelPrincipal;
    private JButton btnFacil;
    private JButton btnMedio;
    private JButton btnDificil;
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

        btnFacil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Fácil");
            }
        });

        btnMedio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Médio");
            }
        });

        btnDificil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Difícil");
            }
        });
    }

    private void btnSairActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public static void main(String[] args) {
        new MinesFinder("Mines Finder").setVisible(true);
    }
}
