package net.foxtam.controller.window;

import javax.swing.*;

public class GameOfLife extends JFrame {

    private final int gridSideSize;

    public GameOfLife(int gridSideSize) {
        super("Game of Life");
        this.gridSideSize = gridSideSize;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 320);
        setLocationRelativeTo(null);

        initComponents();

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);
    }

    private void initComponents() {

    }
}
