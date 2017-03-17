package com.aditya;

import java.util.*;
import java.math.*;

public class Main {
    public class Position{
        int i;
        int j;
        Position (int x,int y){
            this.i = x;
            this.j = y;
        }
        public String toString() {
            return "Position{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
    public void setup(){
        Position greatest_position = null;
        Position next_position;
        Position current_position;
        int greatest_block = 0;
        int current_area = 0;
        int next_area = 0;
        //input the number of rows and columns
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int columns = scan.nextInt();
        int[][] area_array = new int[rows][columns];

        for(int i =0; i < rows; i++){
            for(int j=0; j< columns; j++){
                area_array[i][j] = scan.nextInt();
            }
        }

        //test the input and find the greatest block
        for(int i = 0; i<rows; i++) {
            for(int j = 0; j<columns; j++) {
                System.out.print(area_array[i][j]+ " ");
                if(area_array[i][j] > greatest_block) {
                    greatest_block = area_array[i][j];
                    greatest_position = new Position(i, j);
                }
            }
            System.out.println();
        }
        current_position = new Position(0,0);

        current_position = greatest_position;
        System.out.print("Current Position: " + current_position.toString());

        next_position = find_next_area(area_array, current_position);

        System.out.print("Next Position: " + next_position.toString());
    }
    public static void main(String [] args) {
       Main main = new Main();
       main.setup();
    }
    public int getItemInArray(int[][] array, Position p){
        return array[p.i][p.j];
    }

    public Position getPosition(int[][] array, int value) {
        Position p = null;
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == value)
                    p = new Position(i, j);
            }
        }
        return p;
    }
    public Position find_next_area(int[][] area_array, Position current_position){
        int north =0,south=0, east=0, west=0;

        if(current_position.i - 1 >= 0)
         north = area_array[current_position.i - 1][current_position.j];
        if(current_position.i + 1 <= 3)
            south = area_array[current_position.i + 1][current_position.j];

        if(current_position.j + 1 <= 3)
            east  = area_array[current_position.i ][current_position.j + 1];
        if(current_position.j - 1 >=0)
            west = area_array[current_position.i ][current_position.j - 1];

        int next_area = Math.max(Math.max(north,south),Math.max(east,west));

        return getPosition(area_array, next_area);
    }
}