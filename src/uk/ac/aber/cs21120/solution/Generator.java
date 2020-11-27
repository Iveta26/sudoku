package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.interfaces.IGrid;

public class Generator {
    public IGrid sudokuGrid;
    public Generator(IGrid g) {
        this.sudokuGrid = g;
    }

    public Generator( ) {

    }

    /**
     *  NOTE: FOR THIS TO WORK NUMBER RANGE EXCEPTIONS
     *  IN GRID CALSS HAVE TO BE CHANGED AS THIS ALGORITHM
     *  ALSO ACCEPTS 0 AS VALID INPUT
     * method to generate a grid
     */
    public void generate(){
        int count = 1;
        int rand;
        for(int i =0; i < 9; i++){
            for(int j =0; j < 9; j++){
                count = 1;
                do{
                    rand =getRandom(0, 9);
                    sudokuGrid.set(i, j, rand);
                    count++;
                }while (sudokuGrid.isValid() == false && count <9);


            }
        }

        for(int a =0; a < 9; a++){
            for(int b =0;b < 9; b++) {
                System.out.print(sudokuGrid.get(a,b));
                if (b == 8) {
                    System.out.print("\r\n");
                }
            }
        }
    }

    /**
     * method to generate a random number
     * @param min
     * @param max
     * @return
     */
    public static int getRandom(int min, int max){
        int x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    public static void main(String args[]) {
        IGrid grid = new Grid();
        Generator g = new Generator(grid);
        g.generate();


    }
}
