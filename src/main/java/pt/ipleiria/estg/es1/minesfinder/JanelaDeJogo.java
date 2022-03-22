package pt.ipleiria.estg.es1.minesfinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

        painelJogo.setLayout(new GridLayout(altura,largura));

        // Adicionar os botões
        for (int coluna=0; coluna<altura; coluna++) {
            for (int linha=0; linha<largura; linha++){
                //btn.setText("C"+coluna+"L"+linha);
                // btn.setEstado(linha);
                botoes[linha][coluna] = new botaoCampoMinado(linha, coluna);
                botoes[linha][coluna].addActionListener(this::btnCampoMinadoActionPerformed);
                botoes[linha][coluna].addMouseListener(mouseListener);
                painelJogo.add(botoes[linha][coluna]);
            }
        }

        setContentPane(painelJogo);
        // Destrói esta janela, removendo-a completamente da memória.
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
    }

    public void btnCampoMinadoActionPerformed(ActionEvent e) {
        var botao = (botaoCampoMinado) e.getSource();
        int x = botao.getLinha();
        int y = botao.getColuna();
        campoMinado.revelarQuadricula(x, y);
        actualizarEstadoBotoes();

        if (campoMinado.isJogoTerminado()) {
            if (campoMinado.isJogadorDerrotado())
                JOptionPane.showMessageDialog(null, "Oh, rebentou uma mina", "Perdeu!", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Parabéns. Conseguiu descobrir todas as minas em "+
                     (campoMinado.getDuracaoJogo()/1000)+" segundos", "Vitória", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
        }
    }

    private void actualizarEstadoBotoes() {
        for (int x = 0; x < campoMinado.getLargura(); x++) {
            for (int y = 0; y < campoMinado.getAltura(); y++) {
                botoes[x][y].setEstado(campoMinado.getEstadoQuadricula(x, y));
            }
        }

        if(campoMinado.isVitoria()){
            campoMinado.jogoTerminado = true;
            return;
        }
    }

    MouseListener mouseListener=new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON3) {
                return;
            }
            var botao = (botaoCampoMinado) e.getSource();
            var x = botao.getColuna();
            var y = botao.getLinha();
            var estadoQuadricula = campoMinado.getEstadoQuadricula(x, y);
            if (estadoQuadricula == CampoMinado.TAPADO) {
                campoMinado.marcarComoTendoMina(x, y);
            } else if (estadoQuadricula == CampoMinado.MARCADO) {
                campoMinado.marcarComoSuspeita(x, y);
            } else if (estadoQuadricula == CampoMinado.DUVIDA) {
                campoMinado.desmarcarQuadricula(x, y);
            }
            actualizarEstadoBotoes();
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    };
}
