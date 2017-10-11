import java.util.*;
import java.math.BigInteger;

/**
 * Carpets main. 
 * Reads standard input and solves exact number of possible carpets of that width and length.
 * @author Mathew Boyes, Kimberley Smith, Ash Cochrane.
 */

public class Carpets {

    private static int count = 0;
    private static ArrayList<State> queue = new ArrayList<State>();
    private static HashMap<String, State> state = new HashMap<String, State>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
          String input = scanner.nextLine();
            if(input.isEmpty() || input.charAt(0) =='#') continue;
                if (input.split(" ").length != 2) {
                    System.out.println("Invalid or Bad input");
                    System.exit(0);
                }
                int width = Integer.parseInt(input.split(" ")[0]);
                int length = Integer.parseInt(input.split(" ")[1]);
                //System.out.println(width);
                //System.out.println(length);
                if ((length >= 1 && length <= 100) && (width >= 1 && width <= 6) && ((length * width) % 4 == 0)) {
                    //System.out.println("Input was: " + input);
                    System.out.println(input); //print out the input that was entered
                    //System.out.println("Amount of carpets:" + "# " + solve(length, width));
                    System.out.println("# " + number(length, width) + "\n"); //print # followed by the answer of carpets
                } else {
                    System.out.println("# Syntax error" + "\n");
                }          
        }
        scanner.close();
    }
    
    /**
     * Finds the amount of carpets in a given width and length 
     */
    public static BigInteger number(int length, int width) {
        count++;
        State empty = new State(length, width); //Create the empty state 
        state.put(empty.makeHashKey(), empty);
        queue.add(empty); //add to the queue
        //look at the states that havn't been explored
        while(queue.size() > 0) {
            State current = queue.remove(0); //remove first from the queue
            for(int piece=0; piece<PieceShapes.numPieces; piece++) {
                State newState = new State(current, piece, count);
                if(newState.isValid) { //means it fits
                    String newKey = newState.makeHashKey();
                    if(state.containsKey(newKey)) {
                        State existing = state.get(newKey);
                        current.addNeighbour(existing);
                    } else { //create state and add connection
                        count++;
                        queue.add(newState);
                        state.put(newKey, newState);
                        current.addNeighbour(newState);
                    }
                }
            }
        }

        /**
         * Loops pieces to place, then uses a graph to figure out the amount of ways to get to a state.
         */
        int piecesCount = (width*length)/4; //Number of pieces that can fit
        //Initialise a table and fill it with 0
        BigInteger[][] table = new BigInteger[count + 1][piecesCount + 1];
        for(int i = 0; i < count + 1; i++) {
            for (int j = 0; j < piecesCount + 1; j++) {
                table[i][j] = BigInteger.ZERO;
            }
        }
        
        //Get sorted array of all states
        Collection<State> stateCollection = state.values();
        List<State> stateArray = new ArrayList<State>(stateCollection);
        Collections.sort(stateArray, new Comparator<State>() {
            public int compare(State s1, State s2) {
                if(s1.number > s2.number) return 1;
                if(s1.number < s2.number) return -1;
                else return 0;
            }
        });
        
        table[0][0] = BigInteger.ONE;//when 0 peices have been placed

        //Move down the table, adding current state's value to its neighbours
        for(int row=0; row<piecesCount; row++) {
            for(State current : stateArray) {
                for(State neighbour : current.neighbours) {
                    table[neighbour.number][row+1] = table[neighbour.number][row+1].add(table[current.number][row]);
                }
            }
        }
        //The value in the bottom left cell will be the result
        return table[0][piecesCount];
        
    }

}
