package com.company;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Player {
    Matrix matrix = new Matrix();
    Flot myFlot  = new Flot();
    private int coordinats1,coordinats2;
    private char way;
    private int type;
    private  char typeCopy;
    private int score=0;
    boolean isOk;


    Scanner s = new Scanner(System.in);
    String  inp;
    String [] parts;

    Player(){

    }

    Player(Matrix matrix,Flot myFlot){
        this.matrix=matrix;
        this.myFlot=myFlot;
    }

    public void attack(Matrix gameMatrix2){
        System.out.println("Player"+matrix.getNumOfPlayer()+"("+score+"/"+myFlot.getNumOfAll()+"):");
        inp = s.next();
        parts = inp.split(",");

        coordinats1=parseInt( parts[0])-1;
        coordinats2=parseInt( parts[1])-1;
        if(coordinats1<0 || coordinats2<0 || coordinats1>9 || coordinats2>9  ){
            System.out.println("mistake, write coordinats again");
            attack(gameMatrix2);
        }

       // if(gameMatrix2.getMatrix()[coordinats1][coordinats2]!=gameMatrix2.getSymbol() && gameMatrix2.getMatrix()[coordinats1][coordinats2]!='X' && gameMatrix2.getMatrix()[coordinats1][coordinats2]!='O') {
        if (Character.isDigit(gameMatrix2.getMatrix()[coordinats1][coordinats2])){

            System.out.println("You hit enemy ship");

            score++;
            gameMatrix2.changeSymbol(coordinats1, coordinats2, 'X');
            return;

        }
        if(gameMatrix2.getMatrix()[coordinats1][coordinats2]=='X' || gameMatrix2.getMatrix()[coordinats1][coordinats2]=='O'){
            System.out.println("coordinats are marked, please write another one:");
            attack(gameMatrix2);
        }
        if(gameMatrix2.getMatrix()[coordinats1][coordinats2]==gameMatrix2.getSymbol()) {
            gameMatrix2.changeSymbol(coordinats1, coordinats2, 'O');
        }




    }


    public boolean gameEnd(){//ok
        if(score==myFlot.getNumOfAll()){
            System.out.println("player"+matrix.numOfPlayer+" win");
            return true;
        }else return false;

    }

    public void input(){//ok
        System.out.println("Please write : 1)coor1 2)coor2 3)type 4)way");
        inp = s.next();
        parts = inp.split(",");

        coordinats1=parseInt( parts[0])-1;
        coordinats2=parseInt( parts[1])-1;

        type=parseInt(parts[2]);
        typeCopy=parts[2].charAt(0);
        way=parts[3].charAt(0);
        ////////////////////perevirka
        if(coordinats1<0 || coordinats2<0 || coordinats1>9 || coordinats2>9 || (type>4 || type<1) || (way!='a' && (way!='w') && (way!='d') && (way!='s'))  ){
            System.out.println("mistake");
            input();return;
        }
        if(type==1 && myFlot.getNumOfBoats()<=0) {
            System.out.println("mistake");
            input();
            return;
        }
        if(type==2 && myFlot.getNumOfFrigats()<=0){
            System.out.println("mistake");
            input();
            return;
        }
          //  myFlot.setNumOfFrigats(myFlot.getNumOfFrigats()-1);
        if(type==3 && myFlot.getNumOfDestroers()<=0){
            System.out.println("mistake");
            input();
            return;
        }
           // myFlot.setNumOfDestroers(myFlot.getNumOfDestroers()-1);
        if(type==4 && myFlot.getNumOfBattleships()<=0){
            System.out.println("mistake");
            input();
            return;
        }
         //   myFlot.setNumOfBattleships(myFlot.getNumOfBattleships()-1);



        isOk=matrix.placeShip(coordinats1,coordinats2,type,way);
        if(!isOk){
            System.out.println("mistake");
            input();
            return;
        }
        if(type==1){
            myFlot.setNumOfBoats(myFlot.getNumOfBoats()-1);
        }
        if(type==2){
            myFlot.setNumOfFrigats(myFlot.getNumOfFrigats()-1);
        }
        if(type==3){
            myFlot.setNumOfDestroers(myFlot.getNumOfDestroers()-1);
        }
        if(type==4){
            myFlot.setNumOfBattleships(myFlot.getNumOfBattleships()-1);
        }













        System.out.print("coordinats1= "+parts[0]+"\ncoordinats2= "+parts[1]+"\ntype= "+parts[2]+"\nway= "+parts[3]+"\n");
        System.out.println(myFlot);

    }


}
