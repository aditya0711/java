package com.aditya;

/**
 * Created by adityaaggarwal on 3/3/17.
 */
public class GameEntry {
    private String name;
    private int score;
    public GameEntry(String name, int score){
        this.name = name;
        this.score = score;
    }
    public String getName(){
        return this.name;
    }
    public int getScore(){
        return this.score;
    }
    public String toString(){
        return("Name: " + this.name + "  Score: " + this.score);
    }

    public class ScoreBoard{
        private int numEntries = 0;
        private GameEntry[] board;

        public ScoreBoard(int capacity){
            board = new GameEntry[capacity];
        }
        public void addHighScore(GameEntry gameEntry){
            int newScore = gameEntry.getScore();

            if(numEntries< board.length || newScore >board[numEntries-1].getScore()){
                if(newScore<board.length){
                    numEntries++;
                }
            }
            int j = numEntries - 1;
            while( j>0 && board[j-1].getScore()<newScore) {
                board[j] = board[j - 1];
                j--;
            }
            board[j] = gameEntry;
        }
        public GameEntry remove(int i){
            //check for array out of bounds
            if(i<0 || i>numEntries)
                throw new ArrayIndexOutOfBoundsException("Invalid Index: " + i);

            //find the value
            GameEntry temp = board[i];
            for(int j =i;j<numEntries-1; j++)
                board[j] = board[j+1];

            board[numEntries-1] = null;
            numEntries--;
            return temp;
        }

    }
}

