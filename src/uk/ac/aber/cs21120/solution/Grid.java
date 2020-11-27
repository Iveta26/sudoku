package uk.ac.aber.cs21120.solution;


import uk.ac.aber.cs21120.interfaces.IGrid;

public class Grid implements IGrid {
    int myGrid[][]= new int[9][9];;

    public Grid(){
        for (int i = 0; i < 9; i++) {         //set rows
            for (int j = 0; j < 9; j++) {    //set columns
                myGrid[i][j] = 0;
            }
        }
    }

    @Override
    public int get(int x, int y) throws BadCellException {
        int result = 0;
        if(0>x || x>8 || 0 > y || y>8){
            throw new IGrid.BadCellException(x, y);
        }
        else {
            for(int i = 0; i < 9; i++){         //set rows
                for (int j = 0; j < 9; j++){    //set columns
                    if((i == x) && (j == y)){
                        result = myGrid[x][y];
                    }
                }
            }
        }
        return result;
    }


    @Override
    public void set(int x, int y, int val) throws BadCellException, BadDigitException {
        if (0 > x || x > 8 || 0 > y || y > 8 ) {
            throw new IGrid.BadCellException(x, y);
        } else if(0 > val || 9 < val){
            throw new IGrid.BadDigitException(val);
        }else {
            for (int i = 0; i < 9; i++) {         //set rows
                for (int j = 0; j < 9; j++) {    //set columns
                    if ((i == x) && (j == y )) {
                        myGrid[x][y] = val;  //add value to specified cell
                    }
                }
            }
        }
    }


    @Override
    public boolean isValid() {
        boolean flag;
        int num; //to store a value of our input

        for(int i = 0; i < 9; i++) {         //set rows
            for (int j = 0; j < 9; j++) {
                num = myGrid[i][j];     //current number

                //for checking rows and columns
                for(int z =0; z <9; z++){
                    if(num == 0){
                        break;
                    }else if(num == myGrid[i][z] && z != j){
                        flag = false;
                        return flag;
                    }else if(num == myGrid[z][j] && z != i){
                        flag = false;
                        return flag;
                    }
                }

            }

        }

        flag = checkingGrid();
        return flag;

    }


    /**
     * a function to check if 3x3 grid is valid
     * @return
     */
    public boolean checkingGrid( ){
        boolean flag = true;
        int num;
        int startVal1 =0; //to alter a limit of loop depending on the sub grid
        int limitVal1 =3;
        int startVal2 =0;
        int limitVal2 =3;


        for(int a = 0; a < 9; a++){
            //to set limit values and start values for loops
            if(a < 3) {
                startVal1 = 0;
                limitVal1 = 3;
            }else if(a > 2 && a < 6){
                startVal1 = 3;
                limitVal1 = 6;
            }else if(a > 5 && a < 9){
                startVal1 = 6;
                limitVal1 = 9;
            }


            //to check one 3x3 grid
            for(int i = startVal1; i <limitVal1; i++) {         //2 outer loops is to get current number,
                for (int j = startVal2; j < limitVal2; j++) {   //switching it after it's compared to everything else in the grid
                    num = myGrid[i][j];     //current number

                    for (int r = startVal1; r < limitVal1; r++) { //rows
                        for (int z = startVal2; z < limitVal2; z++) {  //columns
                            if (num == 0) {
                                break;
                            } else if (num == myGrid[r][z] && z != j && r != i) {  //if there is a number equivalent to current number, but not stored in a current cell
                                flag = false;
                                return flag;
                            }
                        }
                    }
                }
            }

            startVal2 =startVal2 + 3;
            limitVal2 =limitVal2 + 3;

            if(limitVal2 > 9){
                startVal2 =0;
                limitVal2 =3;
            }


        }


        return flag;
    }
}
