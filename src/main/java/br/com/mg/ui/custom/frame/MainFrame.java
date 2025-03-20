package br.com.mg.ui.custom.frame;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(final Dimension dimension, final JPanel mainPane){

    super("sudoku");
    this.setSize(dimension);
    this.setPreferredSize(dimension);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.add(mainPane);
    }
}
