package com.company;
import static java.lang.Integer.parseInt;

public class Matrix {
     int rows,cols;
     char[][] matrix;
     char symbol;
     int num;
     int numOfPlayer;

    Matrix(){

    }

    public Matrix(int rows, int cols,char symbol,int num,int numOfPlayer) {
        this.numOfPlayer=numOfPlayer;
        this.num=num;
        this.rows = rows;
        this.cols = cols;
        this.symbol = symbol;
        matrix = new char[rows][cols];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix.length ; j++) {
                matrix[i][j] = symbol;

            }

        }


    }
    public void changeSymbol(int coordinats1,int coordinats2,char symbol){
        if (coordinats1<0 ||coordinats2<0 ||coordinats1>matrix.length || coordinats2>matrix.length){
            System.out.print("Nepravilno vvedeniy symvol\n");
            return;
        }
        matrix[coordinats1][coordinats2]=symbol;
    }

    public boolean placeShip(int coordinats1,int coordinats2,int size,char way){
        boolean isOk;
        char[][] matrixForEvil = new char [rows][cols];
        char sizeChar = Character.forDigit(size,10);

        for (int i = 0; i <matrixForEvil.length ; i++) {
            for (int j = 0; j <matrixForEvil.length ; j++) {
                matrixForEvil[i][j]=matrix[i][j];
            }

        }


        for (int i = 0; i <size ; i++) {

            switch (way){
                case 'w':
                    if(coordinats1-i>=0 && matrixForEvil[coordinats1-i][coordinats2]==symbol)
                    matrixForEvil[coordinats1-i][coordinats2]=sizeChar;
                    else return false;
                    break;
                case 's':
                    if(coordinats1+i>=matrixForEvil.length && matrixForEvil[coordinats1+i][coordinats2]==symbol)
                        matrixForEvil[coordinats1+i][coordinats2]=sizeChar;
                    else return false;
                    break;
                case 'a':
                    if(coordinats2-i>=0 && matrixForEvil[coordinats1][coordinats2-i]==symbol)
                        matrixForEvil[coordinats1][coordinats2-i]=sizeChar;
                    else return false;
                    break;
                case 'd':
                    if(coordinats2+i<=matrixForEvil.length && matrixForEvil[coordinats1][coordinats2+i]==symbol)
                        matrixForEvil[coordinats1][coordinats2+i]=sizeChar;
                    else return false;
                    break;


            }
        }
        for (int i = 0; i <matrixForEvil.length ; i++) {
            for (int j = 0; j <matrixForEvil.length ; j++) {
                matrix[i][j]=matrixForEvil[i][j];

            }

        }
        return true;
    }

 /*   public char [][] prusvoituZn(char[][] matrix){
        char [][] rez = new char[rows][cols];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix.length ; j++) {
                rez[i][j]=

            }

        }

    }*/

    public void printMatrix(){
        System.out.println("Matrix"+numOfPlayer+":");
        System.out.print("0 |");
        for (int i = 0; i <matrix.length ; i++) {
            if(i+1==10){System.out.print((i+1)+" ");}
            else
            System.out.print((i+1)+"  ");
        }
        System.out.println("|");
        for (int i = 0; i <matrix.length*3+4 ; i++) {
            System.out.print('-');

        }
        System.out.println();

        for (int i = 0; i <matrix.length ; i++) {
            if((i+1)%10!=0)
            System.out.print((i+1)+" |");
            else
                System.out.print((i+1)+"|");
            for (int j = 0; j <matrix.length ; j++) {

                System.out.print(matrix[i][j]+"  ");

            }
            System.out.println("|");

        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public char getSymbol() {
        return symbol;
    }


    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getNum() {
        return num;
    }

    public int getNumOfPlayer() {
        return numOfPlayer;
    }
}
