package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.interfaces.IGrid;
import uk.ac.aber.cs21120.interfaces.ISolver;
import uk.ac.aber.cs21120.tests.Examples;

public class Main {
    public IGrid sudokuGrid;
    public Main(IGrid g) {
        this.sudokuGrid = g;
    }
    public static void main(String args[]) {
    long start= System.currentTimeMillis();;
    long timeTaken;

    for(int i = 0; i < 400; i++){
        System.out.println("Start: " + start);
        ISolver s = new Solver(Examples.getExample(i));
        s.solve();
        System.out.println("Gaps in the puzzle number " + i + ": " + Examples.getGapCount(i));

        timeTaken = System.currentTimeMillis() - start;
        System.out.println("Time taken: " + timeTaken);
    }


    }
}
