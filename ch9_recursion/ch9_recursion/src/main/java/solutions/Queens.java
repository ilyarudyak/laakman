package solutions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ilyarudyak on 5/30/16.
 */
public class Queens {

    public static int GRID_SIZE = 4;

    public static void placeQueens(int row, Integer[] cols, ArrayList<Integer[]> results) {

//        System.out.println(Arrays.toString(cols));

        // for every column in columns: place Queen if column is available
        // if row < GRID_SIZE call placeQueens() recursively; else return
        // most important: remove Queen from last column
        for (int col = 0; col < cols.length; col++) {
            if (isAvailable(cols, row, col)) {
                // place Queen
                cols[row] = col;

                if (row < GRID_SIZE - 1) {
                    placeQueens(row + 1, cols, results);
                } else {
//                    System.out.println("adding to res: " + Arrays.toString(cols));
                    results.add(Arrays.copyOf(cols, cols.length));
                    return;
                }
                // remove Queen
                cols[row] = -1;
            }
        }
    }

    // helper methods
    public static void clear(Integer[] columns) {
        for (int i = 0; i < GRID_SIZE; i++) {
            columns[i] = -1;
        }
    }
    public static boolean isAvailable(Integer[] cols, int row1, int col1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int col2 = cols[row2];
			/* Check if (row2, column2) invalidates (row1, column1) as a queen spot. */

			/* Check if rows have a queen in the same column */
            if (col1 == col2) {
                return false;
            }

			/* Check diagonals: if the distance between the columns equals the distance
			 * between the rows, then they're in the same diagonal.
			 */
            int colDist = Math.abs(col2 - col1);
            int rowDist = Math.abs(row2 - row1);
            if (colDist == rowDist) {
                return false;
            }
        }
        return true;
    }

    // utility methods
    public static void printBoard(Integer[] columns) {
        drawLine();
        for(int i = 0; i < GRID_SIZE; i++){
            System.out.print("|");
            for (int j = 0; j < GRID_SIZE; j++){
                if (columns[i] == j) {
                    System.out.print("Q|");
                } else {
                    System.out.print(" |");
                }
            }
            System.out.print("\n");
            drawLine();
        }
        System.out.println("");
    }
    public static void printBoard2(Integer[] cols) {
        for(int i = 0; i < GRID_SIZE; i++){
            for (int j = 0; j < GRID_SIZE; j++){
                if (cols[i] == j) {
                    System.out.print("Q");
                } else {
                    System.out.print("-");
                }
            }
            System.out.print("\n");
        }
        System.out.println("");
    }
    private static void drawLine() {
        StringBuilder line = new StringBuilder();
        for (int i=0;i<GRID_SIZE*2+1;i++)
            line.append('-');
        System.out.println(line.toString());
    }
    public static void printBoards(ArrayList<Integer[]> boards) {
        for (int i = 0; i < boards.size(); i++) {
            Integer[] board = boards.get(i);
//            System.out.println(Arrays.toString(board));
            printBoard2(board);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer[]> results = new ArrayList<Integer[]>();
        Integer[] columns = new Integer[GRID_SIZE];
        clear(columns);
        placeQueens(0, columns, results);
        printBoards(results);
        System.out.println("# of solutions = " + results.size());
    }
}
