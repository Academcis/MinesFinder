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
    private JLabel lblNomeFacil;
    private JLabel lblNomeMedio;
    private JLabel lblNomeDificil;
    private JLabel lblTempoFacil;
    private JLabel lblTempoMedio;
    private JLabel lblTempoDificil;
    private TabelaRecordes recordesFacil;
    private TabelaRecordes recordesMedio;
    private TabelaRecordes recordesDificil;

    public MinesFinder(String title){
        super(title);
        recordesFacil = new TabelaRecordes();
        recordesMedio = new TabelaRecordes();
        recordesDificil = new TabelaRecordes();

        recordesFacil.addTabelaRecordesListener(new TabelaRecordesListener() {
            @Override
            public void recordesActualizados(TabelaRecordes recordes) {
                recordesFacilActualizado(recordes);
            }
        });
        recordesMedio.addTabelaRecordesListener(new TabelaRecordesListener() {
            @Override
            public void recordesActualizados(TabelaRecordes recordes) {
                recordesMedioActualizado(recordes);
            }
        });
        recordesDificil.addTabelaRecordesListener(new TabelaRecordesListener() {
            @Override
            public void recordesActualizados(TabelaRecordes recordes) {
                recordesDificilActualizado(recordes);
            }
        });

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
        JanelaDeJogo janela = new JanelaDeJogo("Fácil", new CampoMinado(9,9,10),recordesFacil);
        janela.setVisible(true);
    }

    private void btnJogoMedioActionPerformed(ActionEvent e) {
        JanelaDeJogo janela = new JanelaDeJogo("Médio", new CampoMinado(16,16,40),recordesMedio);
        janela.setVisible(true);
    }

    private void btnJogoDificilActionPerformed(ActionEvent e) {
        JanelaDeJogo janela = new JanelaDeJogo("Difícil", new CampoMinado(16,30,90),recordesDificil);
        janela.setVisible(true);
    }

    public static void main(String[] args) {
        new MinesFinder("Mines Finder").setVisible(true);
    }

    private void recordesFacilActualizado(TabelaRecordes recordes) {
        lblNomeFacil.setText(recordes.getNomeUtilizador());
        lblTempoFacil.setText(Long.toString(recordes.getTempoJogo()/1000));
    }
    private void recordesMedioActualizado(TabelaRecordes recordes) {
        lblNomeMedio.setText(recordes.getNomeUtilizador());
        lblTempoMedio.setText(Long.toString(recordes.getTempoJogo()/1000));
    }
    private void recordesDificilActualizado(TabelaRecordes recordes) {
        lblNomeDificil.setText(recordes.getNomeUtilizador());
        lblTempoDificil.setText(Long.toString(recordes.getTempoJogo()/1000));
    }
}
