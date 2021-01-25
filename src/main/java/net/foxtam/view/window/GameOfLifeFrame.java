package net.foxtam.view.window;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameOfLifeFrame extends JFrame {

    private static final String generationLabelText = "Generation #";
    private static final String aliveLabelText = "Alive: ";

    private final int gridSideSize;
    private JLabel generationLabel;
    private JLabel aliveLabel;
    private JPanel gridPanel;

    public GameOfLifeFrame(int gridSideSize) {
        super("Game of Life");
        this.gridSideSize = gridSideSize;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        initComponents();

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);
    }

    private void initComponents() {
        generationLabel = new JLabel();
        aliveLabel = new JLabel();
        gridPanel = new JPanel();
        initGridPanel();

        add(generationLabel);
        add(aliveLabel);
        add(gridPanel);
    }

    private void initGridPanel() {
        gridPanel.setLayout(new GridLayout(gridSideSize, gridSideSize));
        for (int i = 0; i < gridSideSize; i++) {
            for (int j = 0; j < gridSideSize; j++) {
                gridPanel.add(new Panel());
            }
        }
    }

    public void setGenerationNumber(int number) {
        generationLabel.setText(generationLabelText + number);
    }

    public void setAliveNumber(int number) {
        aliveLabel.setText(aliveLabelText + number);
    }

    public void updateCellsMap(List<Boolean> aliveCellsStatus) {
        if (aliveCellsStatus.size() != gridPanel.getComponentCount()) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < aliveCellsStatus.size(); i++) {
            Color color = aliveCellsStatus.get(i) ? Color.DARK_GRAY : Color.LIGHT_GRAY;
            gridPanel.getComponent(i).setBackground(color);
        }
    }
}
