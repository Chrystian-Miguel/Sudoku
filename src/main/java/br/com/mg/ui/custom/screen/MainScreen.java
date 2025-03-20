package br.com.mg.ui.custom.screen;

import br.com.mg.service.BoardService;
import br.com.mg.ui.custom.button.CheckGamaStatusButton;
import br.com.mg.ui.custom.button.FinishGameButton;
import br.com.mg.ui.custom.button.ResetButton;
import br.com.mg.ui.custom.frame.MainFrame;
import br.com.mg.ui.custom.panel.MainPainel;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MainScreen {

    private final static Dimension dimension = new Dimension(600, 600);

    private final BoardService boardService;

    private JButton finishGameButton;
    private JButton checkGameStatusButton;
    private JButton resetButton;

    public MainScreen(final Map<String, String> gameConfig) {
        this.boardService = new BoardService(gameConfig);
    }

    public void biudMainScreen() {
        JPanel mainPanel = new MainPainel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPanel);
        addResetButton(mainPanel);
        addCheckGameStatusButton(mainPanel);
        addFinishgameButton(mainPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void addFinishgameButton(JPanel mainPanel) {

         finishGameButton = new FinishGameButton(e ->{
            if(boardService.gameIsFinished()){

                JOptionPane.showMessageDialog(null,"Parabens você concluiu o jogo");
                resetButton.setEnabled(false);
                checkGameStatusButton.setEnabled(false);
                finishGameButton.setEnabled(false);

            }else {

                JOptionPane.showMessageDialog(null,"Seu jogo tem alguma inconsistencia, ajuste e tente novamente");
            }


        });
        mainPanel.add(finishGameButton);
    }

    private void addCheckGameStatusButton(JPanel mainPanel) {


         checkGameStatusButton = new CheckGamaStatusButton(e ->{
            var hasErros = boardService.hasErross();
            var gameStatus = boardService.getStatus();
            var mensage = switch (gameStatus){

                case NON_STARTED -> "O jogo não foi iniciado";
                case INCOMPLETE -> "O jogo esta incompleto";
                case COMPLETE -> "O jogo esta completo";
            };

            mensage += hasErros? "e contém erros": "e não contem erros";
            JOptionPane.showMessageDialog(null,mensage);

        });
        mainPanel.add(checkGameStatusButton);
    }


    private void addResetButton(JPanel mainPanel) {

       resetButton = new ResetButton(e -> {
            var dialogResult = JOptionPane.showConfirmDialog(
                    null,
                    "Confirme para reiniciar o jogo",
                    "Limpar o jogo",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (dialogResult == 0){
                boardService.reset();
            }
        });
        mainPanel.add(resetButton);

    }
}
