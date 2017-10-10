import java.util.*;
import java.util.Arrays;

public class Shape {
    public boolean grid[][];
    public int x;
    public int y;

    public Shape() {
        
    }

    public boolean[][] newShape() {
        String colour;
        boolean[][]temp = new boolean[0][0];
        Random random = new Random();
        int r = random.nextInt(7);
        switch(r) {
            case 0:
                colour = "Green";
                temp[0][0] = true;
                temp[0][1] = true;
                temp[1][1] = true;
                temp[1][2] = true;
                break;
            case 1:
                colour = "Dark blue";
                temp[0][2] = true;
                temp[0][1] = true;
                temp[1][1] = true;
                temp[1][0] = true;
                break;
            case 2:
                colour = "Yellow";
                temp[0][0] = true;
                temp[0][1] = true;
                temp[0][2] = true;
                temp[1][1] = true;
                break;
            case 3:
                colour = "Pink";
                temp[0][0] = true;
                temp[0][1] = true;
                temp[0][2] = true;
                temp[1][2] = true;
                break;
            case 4:
                colour = "Light blue";
                temp[0][2] = true;
                temp[1][2] = true;
                temp[1][1] = true;
                temp[1][0] = true;
                break;
            case 5:
                colour = "Purple";
                temp[0][0] = true;
                temp[1][0] = true;
                temp[0][1] = true;
                temp[1][1] = true;
                break;
            case 6:
                colour = "Red";
                temp[0][0] = true;
                temp[1][0] = true;
                temp[2][0] = true;
                temp[3][0] = true;
                break;
        }
        return temp;
                
        
    }


}