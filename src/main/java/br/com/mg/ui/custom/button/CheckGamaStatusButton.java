package br.com.mg.ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CheckGamaStatusButton extends JButton {

    public CheckGamaStatusButton(final ActionListener actionListener) {

        this.setText("Verificar jogo");

        this.addActionListener(actionListener);


    }

}
