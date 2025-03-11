package br.com.mg.service;

import br.com.mg.model.Board;
import br.com.mg.model.GameStatusEnum;
import br.com.mg.model.Space;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardService {


    private final static int BOARD_LIMIT= 9;

    private final Board board;

    public BoardService(final Map<String, String> gameCofig){
        this.board = new Board((initBoard(gameCofig)));
    }

    public  List<List<Space>> getSpaces(){
        return this.board.getSpaces();
    }

    public void reset(){
        this.board.reset();
    }

    public boolean hasErross(){

        return this.board.hasErros();
    }

    public GameStatusEnum getStatus(){
        return  this.board.getStatus();

    }

    public boolean gameIsFinished(){
        return  this.board.gameIsFinished();
    }

    private List<List<Space>> initBoard(Map<String, String> gameCofig) {

        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++) {

                var positionConfig = gameCofig.get("%s,%s".formatted(i, j));
                var expected = Integer.parseInt(positionConfig.split(",")[0]);
                var fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
                var currentSpace = new Space(expected, fixed);
                spaces.get(i).add(currentSpace);
            }
        }
        return   spaces;

    }

}
