package com.company;


import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.*;
public class Main {




        private String[][] tablos;
        static String X = "X";
        static String O = "O";
        /**
         * objekty pro kosntruktor:
         */
        public Main()
        {
            // initialize instance variables
            tablos = new String[3][3];
        }

        /**
         * OUTPUT Boardu
         */
        public void printBoard()
        {
            System.out.println();
            for (int i = 0; i <  tablos.length; i++) {
                for (int j = 0; j <  tablos[i].length; j++) {
                    if ( tablos[i][j] == null) {
                        System.out.print("_");
                    } else {
                        System.out.print( tablos[i][j]);
                    }
                    if (j < 2) {
                        System.out.print("|");
                    } else {
                        System.out.println();
                    }
                }
            }
            System.out.println();
        }
        /* Hodnoceni kdo vyhral pomoci podminek hned potom co X odehraje
         *
         */
        public Boolean checkWinner(String play) {
            int playInRow = 0;
            int play1 = 0;
            int play2 = 0;
            int[] playInColumn = new int[ tablos[0].length];
            for (int i = 0; i <  tablos.length; i++) {
                playInRow = 0;
                for (int j = 0; j <  tablos[i].length; j++) {
                    if (null ==  tablos[i][j]) {
                        continue;
                    }
                    if ( tablos[i][j].equals(play)) {
                        playInRow++;
                        playInColumn[j]++;
                        if (i == j) {
                            play1++;
                        } else if (2 == i + j) {
                            play2++;
                        }
                    }

                }
                if (playInRow == 3) {
                    return true;
                }
            }
            if (3 == play1 || 3 == play2) {
                return true;
            }
            for (int i = 0; i < playInColumn.length; i++) {
                if (playInColumn[i] == 3) {
                    return true;
                }
            }
            return false;
        }
        /*
         * makeMove souradnice 1. sloupec nulty prvni druhy, radek nulty druhy prvni
         * ! jestlize je r nebo c chybne cislo napise hlasku "Both inputs must be integers between 0 and 2."
         */
        public void makeMove(Scanner stdin, String play) {
            int r;
            int c;
            Boolean goodInput = false;
            while(!goodInput) {
                r = -1;
                c = -1;
                System.out.println ("Enter coordinates " + play);
                if (stdin.hasNextInt()) {  // intidzri
                    r = stdin.nextInt();
                }
                if (stdin.hasNextInt()) {
                    c = stdin.nextInt();
                }
                else {
                    stdin.nextLine();
                    System.out.println("Both inputs must be integers 0 and 2.");

                }
                if ((r < 0) || (r > 2) || (c < 0) || (c > 2)) {
                    System.out.println("Both inputs must be between 0 and 2.");

                }
                // podminka: lokace musi byt prazdna
                else if ( tablos[r][c] != null ){
                    System.out.println("This location is okupajd");

                }
                else {
                    tablos[r][c] = play;
                    return;
                }
            }
            return;
        }

        public static void main(String[] args) {

          Main ttt = new Main();
            Scanner stdin = new Scanner(System.in);

            int moves = 0;
            System.out.println("Let's play TicTacToe -- X goes first");
            ttt.printBoard();
            while (moves < 9) {
                ttt.makeMove(stdin, ttt.X);
                moves++;
                if (moves > 4) {
                    if (ttt.checkWinner(X)) {
                        System.out.println(X + " You Win!!!");
                        break;
                    }
                }
                ttt.printBoard();
                ttt.makeMove(stdin, ttt.O);
                moves++;
                if (moves > 4) {
                    if (ttt.checkWinner(O)) {
                        System.out.println(O + " You Win!!!");
                        break;
                    }
                }
                ttt.printBoard();

            }
        }
    }