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

        btnFacil.addActionListener(this::btnJogoFacilActionPerformed);

        btnMedio.addActionListener(this::btnJogoMedioActionPerformed);

        btnDificil.addActionListener(this::btnJogoDificilActionPerformed);
    }

    private void btnSairActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void btnJogoFacilActionPerformed(ActionEvent e) {
        JanelaDeJogo janela = new JanelaDeJogo("Fácil");
        janela.setVisible(true);
    }

    private void btnJogoMedioActionPerformed(ActionEvent e) {
        JanelaDeJogo janela = new JanelaDeJogo("Médio");
        janela.setVisible(true);
    }

    private void btnJogoDificilActionPerformed(ActionEvent e) {
        JanelaDeJogo janela = new JanelaDeJogo("Difícil");
        janela.setVisible(true);
    }

    public static void main(String[] args) {
        new MinesFinder("Mines Finder").setVisible(true);
    }
}
