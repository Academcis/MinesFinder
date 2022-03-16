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
            default:
                setText(estado+"");
                setBackground(Color.LIGHT_GRAY);
                break;
        }
    }

}
