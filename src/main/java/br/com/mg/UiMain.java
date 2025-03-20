package br.com.mg;

import br.com.mg.ui.custom.frame.MainFrame;
import br.com.mg.ui.custom.panel.MainPainel;
import br.com.mg.ui.custom.screen.MainScreen;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UiMain {
    public static void main(String[] args) {

        final var gameConfig = Stream.of(args)
                .collect(Collectors.toMap(
                        k -> k.split(";")[0],

                        v -> v.split(";")[1]
                ));

        var mainScreen  = new MainScreen(gameConfig);
        mainScreen.biudMainScreen();
    }
}
