package com.company;

public class Flot {
    private  int numOfBoats;
    private  int numOfFrigats;
    private int numOfDestroers;
    private int numOfBattleships;
    private  int numOfAll;

    public Flot(){

    }

    public Flot(int numOfBoats, int numOfFrigats, int numOfDestroers, int numOfBattleships) {
        this.numOfBoats = numOfBoats;
        this.numOfFrigats = numOfFrigats;
        this.numOfDestroers = numOfDestroers;
        this.numOfBattleships = numOfBattleships;
        numOfAll=numOfBattleships*4+numOfDestroers*3+numOfFrigats*2+numOfBoats;
    }
    public int getNumOfAllShips(){
        return numOfBattleships*4+numOfDestroers*3+numOfFrigats*2+numOfBoats;
    }

    public int getNumOfBoats() {
        return numOfBoats;
    }

    public void setNumOfBoats(int numOfBoats) {
        this.numOfBoats = numOfBoats;
    }

    public int getNumOfFrigats() {
        return numOfFrigats;
    }

    public void setNumOfFrigats(int numOfFrigats) {
        this.numOfFrigats = numOfFrigats;
    }

    public int getNumOfDestroers() {
        return numOfDestroers;
    }

    public void setNumOfDestroers(int numOfDestroers) {
        this.numOfDestroers = numOfDestroers;
    }

    public int getNumOfBattleships() {
        return numOfBattleships;
    }

    public void setNumOfBattleships(int numOfBattleships) {
        this.numOfBattleships = numOfBattleships;
    }

    public int getNumOfAll() {
        return numOfAll;
    }

    @Override
    public String toString() {
        return "Flot{" +
                "numOfBoats=" + numOfBoats +
                ", numOfFrigats=" + numOfFrigats +
                ", numOfDestroers=" + numOfDestroers +
                ", numOfBattleships=" + numOfBattleships +
                '}';
    }
}
