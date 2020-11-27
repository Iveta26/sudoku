package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.interfaces.IGrid;
import uk.ac.aber.cs21120.interfaces.ISolver;


public class Solver implements ISolver {
    public IGrid sudokuGrid;
    public Solver(IGrid g) {
        this.sudokuGrid = g;
    }

    public Solver() {

    }

    @Override
    public boolean solve() {
        String coord = ""; // get value of current coordinates of a cell from stack
        int temp; //to temporarily store val the cell when backtracking
        int val; //to store value of the cell
        boolean flag = false;
        int newVal = 1; //store value from 1 to 9
        ArrayStack stack = new ArrayStack(81);
        int count =0; //to keep track of the number of values changed for debugging

        //loop through the whole grid
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                val = sudokuGrid.get(i, j);
                if (val == 0) {
                    count++;
                    coord = String.valueOf(i) + String.valueOf(j);
                    stack.push(coord);

                    newVal = 1;

                    do {
                        sudokuGrid.set(i, j, newVal);
                        newVal++;
                    } while (sudokuGrid.isValid() == false && newVal <= 9);

                }

                if(sudokuGrid.isValid()){
                    flag =true;
                    new Solver();
                }else {
                    do{
                        coord = (String) stack.pop();
                        sudokuGrid.set(Integer.parseInt(String.valueOf(coord.charAt(0))),Integer.parseInt(String.valueOf(coord.charAt(1))), 0);//set current value to 0
                        coord = (String) stack.peek(); //see what the value of a previous cell is
                        temp = sudokuGrid.get(Integer.parseInt(String.valueOf(coord.charAt(0))),Integer.parseInt(String.valueOf(coord.charAt(1))));//get val of a previous cell
                        i = Integer.parseInt(String.valueOf(coord.charAt(0))); //so the loop doesn't move on to the next cell
                        j = Integer.parseInt(String.valueOf(coord.charAt(1)));
                        temp = temp +1;

                        //if temp is 10, we already tried 9 on the cell, hence we need to backtrack more instead of trying a new number
                        if(temp == 10){
                            flag = false;
                        }else{
                            //try a new number until valid or nothing is found
                            do{
                                sudokuGrid.set(Integer.parseInt(String.valueOf(coord.charAt(0))),Integer.parseInt(String.valueOf(coord.charAt(1))), temp);
                                temp++;
                            }while (sudokuGrid.isValid() == false && temp <= 9);
                            if(temp -1 <= 9 && sudokuGrid.isValid() == true ){
                                flag = true;
                            }else {
                                flag = false;
                            }
                        }

                    }while (flag ==false);
                }
            }
        }



        return flag;
    }



}