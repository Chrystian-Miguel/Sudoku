package br.com.mg.ui.custom.input;

import br.com.mg.model.Space;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.util.List;

import static java.util.Objects.isNull;

public class NumberText extends JTextField {

    private final Space space;

    public NumberText(Space space) {

        this.space = space;

        var dimension = new Dimension(50,50);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setVisible(true);
        this.setFont(new Font("Arial",Font.PLAIN,20));
        this.setHorizontalAlignment(CENTER);
        this.setDocument(new NumberTextLimit());
        this.setEnabled(!space.isFixed());
        if (space.isFixed()){
            this.setText(space.getActual().toString());
        }

        this.getDocument().addDocumentListener(new DocumentListener() {



            @Override
            public void insertUpdate(DocumentEvent e) {
                changeSpace();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changeSpace();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changeSpace();

            }

            private void changeSpace(){
                if (getText().isEmpty()){

                    space.ClearSpace();
                    return;
                }
                space.setActual(Integer.parseInt(getText()));

            }
        });


    }
}
