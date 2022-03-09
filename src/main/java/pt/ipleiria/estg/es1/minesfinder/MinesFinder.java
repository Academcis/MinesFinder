package pt.ipleiria.estg.es1.minesfinder;

import javax.swing.*;

public class MinesFinder extends JFrame{

    public MinesFinder(String title){
        super(title);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MinesFinder("Mines Finder").setVisible(true);
    }
}
