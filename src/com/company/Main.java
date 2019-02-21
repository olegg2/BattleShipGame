package com.company;

public class Main {

    public static void main(String[] args) {


        Matrix gameMatrix = new Matrix(10,10,' ',2,1);
        Matrix gameMatrix2 = new Matrix(10,10,' ',1,2);

        Flot myFlot = new Flot(0,0,0,1);
        Flot myFlot2 = new Flot(2,1,0,0);
        int count = 1;
        boolean gameEnd;
        boolean gameEnd2;

        Player player1 = new Player(gameMatrix,myFlot);
        Player player2 = new Player(gameMatrix2,myFlot2);
        ///////////////////////1
        System.out.println("Player1 please put our ships");
        System.out.println(myFlot);
        while (count!=0) {
            player1.input();
            player1.matrix.printMatrix();

            if(myFlot.getNumOfBoats()==0 && myFlot.getNumOfFrigats()==0 && myFlot.getNumOfDestroers()==0 && myFlot.getNumOfBattleships()==0)
                count=0;
        }
        System.out.println("Player2 please put our ships");
        System.out.println(myFlot2);
        count=1;
        while (count!=0) {
            player2.input();
            player2.matrix.printMatrix();
            if(myFlot2.getNumOfBoats()==0 && myFlot2.getNumOfFrigats()==0 && myFlot2.getNumOfDestroers()==0 && myFlot2.getNumOfBattleships()==0)
                count=0;
        }///////////////////////2
        System.out.println("War is starting!!!\n");
        while (true ){
            player1.attack(gameMatrix2);
            gameMatrix2.printMatrix();
            gameEnd= player1.gameEnd();
            if(gameEnd) break;
            player2.attack(gameMatrix);
            gameMatrix.printMatrix();
            gameEnd2= player2.gameEnd();
            if(gameEnd2) break;


        }
        System.out.println("GAME OVER");









    }
}
