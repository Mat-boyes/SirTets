
import java.util.*;
import java.util.Arrays;

public class Grid {
    public static boolean[][] grid;
    public int x;
    public int y;

    public Grid(int xSize, int ySize) {
        this.grid = new boolean[xSize][ ySize];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = false;
            }
        }

    }

    public static void printRow(boolean[] row) {
        for (boolean b : row) {
            System.out.print(b);
            System.out.print("\t");
        }
        System.out.println();
    }

    public void getGrid() {
        for(boolean[] b : grid) {
            printRow(b);
        }
    }

    public boolean getCoord(int x, int y) {
        System.out.println(grid[x][y]);
        return grid[x][y];
    }

    public static void main(String[] args) {
        Grid g = new Grid(10,10);
        g.getCoord(5,5);
        g.getGrid();
        
    }
    
}

    
