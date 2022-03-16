package pt.ipleiria.estg.es1.minesfinder;

import javax.swing.*;
import java.awt.*;

public class botaoCampoMinado extends JButton {
    private int estado;

    public botaoCampoMinado(CampoMinado campoMinado) {
        this.estado = campoMinado.TAPADO;
    }

    public void setEstado(int estado) {
        this.estado = estado;
        switch (estado){
            case CampoMinado.VAZIO:
                setText("");
                setBackground(Color.LIGHT_GRAY);
                break;
            case CampoMinado.TAPADO:
                setText("");
                setBackground(null);
                break;
            case CampoMinado.DUVIDA:
                setText("?");
                setBackground(Color.YELLOW);
                break;
            case CampoMinado.MARCADO:
                setText("!");
                setBackground(Color.RED);
                break;
            case CampoMinado.REBENTADO:
                setText("*");
                setBackground(Color.ORANGE);
                break;
            default: // Quando tem minas ao lado e está tapado
                setText(String.valueOf(estado)); //Ou setText(estado+"")
                setBackground(Color.LIGHT_GRAY);
                break;
        }
    }

}
