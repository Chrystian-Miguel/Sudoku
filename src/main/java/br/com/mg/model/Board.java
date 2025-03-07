package br.com.mg.model;

import java.util.Collection;
import java.util.List;

import static br.com.mg.model.GameStatusEnum.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Board {
    private final List<List<Space>> spaces;


    public Board(List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    public List<List<Space>> getSpaces() {
        return spaces;
    }

    public GameStatusEnum getStatus() {
        if (    spaces
                .stream()
                .flatMap(Collection::stream)
                .noneMatch(s -> !s.isFixed() && nonNull(s.getActual()))) {
            return NON_STARTED;

        }
        return spaces
                .stream()
                .flatMap(Collection::stream)
                .anyMatch(s -> isNull(s.getActual())) ? INCOMPLETE : COMPLETE;
    }

    public boolean hasErros(){
        if (getStatus()== NON_STARTED){return  false;}
        return spaces
                .stream()
                .flatMap(Collection::stream)
                .anyMatch(s -> nonNull(s.getActual()) && !s.getActual().equals(s.getExpected()));
    }
    public boolean changeValue(final  int col, final int row, final int value){
        var space = spaces.get(col).get(row);
        if(space.isFixed()){
            return false;
        }
        space.setActual(value);
        return true;
    }

    public  boolean clearValue(final int col, final int row){
        var space = spaces.get(col).get(row);
        if(space.isFixed()){
            return false;
        }
        space.ClearSpace();
        return true;
    }

    public  void reset(){
        spaces.forEach(c -> c.forEach(Space::ClearSpace));
    }

    // por gamesatus ser um enum podemos utilizar "==" ou "getStatus().equals(COMPLETE)"

    public boolean gemeIsFinished(){
        return !hasErros() && getStatus().equals(COMPLETE) ;
    }
}
