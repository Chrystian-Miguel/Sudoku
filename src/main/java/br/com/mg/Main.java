package br.com.mg;

import br.com.mg.model.Board;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private final  static Scanner sacanner = new Scanner(System.in);
    private static Board board;
    private final static int BOARD_LIMIT= 9;


    public static void main(String[] args){

        final var positions = Stream.of(args)
                .collect(Collectors.toMap(
                        k -> k.split(";")[0],

                        v -> v.split(";")[1]
                ));

        var option  = -1;
        while (true){

            
        }
    }

}