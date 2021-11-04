package com.company;
import java.util.Scanner;

public class TicTacToe{
    public static void main(String[] args) {
        String[] pole = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        int kolo = 1;
        int hrac = 1;

        do{
            vypis(pole, kolo);
            kolo++;

            tah(pole, hrac);
            hrac *= -1;
        }while(!vyhra(pole, kolo));;
    }

    public static void vypis(String[] pole, int kolo){
        for (int i = 0; i < 3; i++) {
            System.out.println(pole[3*i+0] + " | " + pole[3*i+1] + " | " + pole[3*i+2]);
        }
    }

    public static String[] tah(String[] pole, int hrac){
        Scanner sc = new Scanner(System.in);
        if(hrac == 1){
            System.out.println("Hrac 1 (x) hraje:");
            int misto = sc.nextInt();
            if(misto > 8 || misto < 0 || pole[misto] == "x" || pole[misto] == "o"){
                System.out.println("tady ne.");
                return tah(pole, hrac);
            }
            pole[misto] = "x";
            return pole;
        }
        else if(hrac == -1){
            System.out.println("Hrac 2 (o) hraje:");
            int misto = sc.nextInt();
            if(misto > 9 || misto < 0 || pole[misto] == "x" || pole[misto] == "o"){
                System.out.println("tady ne.");
                return tah(pole, hrac);
            }
            pole[misto] = "o";
            return pole;
        }
        return pole;
    }

    public static boolean vyhra(String[] pole, int kolo){
        if(pole[0] == pole[1] && pole[1] == pole[2]){
            vypis(pole, kolo);
            System.out.println(pole[0] + " vyhral");
            return true;
        }if(pole[3] == pole[4] && pole[4] == pole[5]){
            vypis(pole, kolo);
            System.out.println(pole[3] + " vyhral");
            return true;
        }if(pole[6] == pole[7] && pole[7] == pole[8]){
            vypis(pole, kolo);
            System.out.println(pole[6] + " vyhral");
            return true;
        }if(pole[0] == pole[3] && pole[3] == pole[6]){
            vypis(pole, kolo);
            System.out.println(pole[0] + " vyhral");
            return true;
        }if(pole[1] == pole[4] && pole[4] == pole[7]){
            vypis(pole, kolo);
            System.out.println(pole[1] + " vyhral");
            return true;
        }if(pole[2] == pole[5] && pole[5] == pole[8]){
            vypis(pole, kolo);
            System.out.println(pole[2] + " vyhral");
            return true;
        }if(pole[0] == pole[4] && pole[4] == pole[8]){
            vypis(pole, kolo);
            System.out.println(pole[0] + " vyhral");
            return true;
        }if(pole[2] == pole[4] && pole[4] == pole[6]){
            vypis(pole, kolo);
            System.out.println(pole[2] + " vyhral");
            return true;
        }if(kolo > 9){
            vypis(pole, kolo);
            System.out.println("remiza");
            return true;
        }

        return false;
    }
}
