import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private Board board;
    private BufferedReader reader;
    private int n;
    private Storage storage;
    private CoordinatesHolder coordinatesHolder;

    public Game(BufferedReader reader) {
        this.reader = reader;
        this.n = 0;
        this.coordinatesHolder = new CoordinatesHolder();
    }

    public void run() throws IOException {
        gameInit();

        for (int i = 0; i < n; i++) {
            generateNewGeneration();
            applyNewColors();
            storage.checkColor();
        }


        System.out.printf("Expected result:%d%n", this.storage.getCounter());


    }

    /**
     * Game initialization method
     * @throws IOException
     */
    private void gameInit() throws IOException {
        boardSizeInit();
        generationZeroInit();
        initMonitoredCell();


    }


    /**
     * Method that generates the next generation(but not apply it)
     */
    private void generateNewGeneration() {
        for (int row = 0; row < this.board.getBoard().length; row++) {
            for (int col = 0; col < this.board.getBoard()[row].length; col++) {
                applyRules(row, col, this.board.getSpecificCell(row, col));
            }

        }
    }

    /**
     * Method that apply new generation(change the colors of the cells)
     */
    private void applyNewColors() {
        for (int row = 0; row < this.board.getBoard().length; row++) {
            for (int col = 0; col < this.board.getBoard()[row].length; col++) {
                Cell cell = this.board.getBoard()[row][col];
                cell.setColor(cell.getFutureColor());
            }

        }
    }

    /**
     * Method that apply all rules
     * @param row current row in the board
     * @param col current col in the board
     * @param cell current cell in the board
     */
    private void applyRules(int row, int col, Cell cell) {
        Map<Integer, Integer> colorEncounters = new HashMap<>();
        colorEncounters.put(0, 0);
        colorEncounters.put(1, 0);

        for (Coordinate coordinate : coordinatesHolder.getCoordinateList()) {
            int neighborColor = 0;
            try {
                neighborColor = this.board.getSpecificCell(coordinate.getRow() + row, coordinate.getCol() + col).getColor();
            } catch (IndexOutOfBoundsException ex) {
                continue;
            }

            colorEncounters.put(neighborColor, colorEncounters.get(neighborColor) + 1);

        }


        int greenEncounter = colorEncounters.get(1);

        if (greenEncounter == 2 || greenEncounter == 3 || greenEncounter == 6) {
            if (cell.getColor() == 0 && greenEncounter != 2) {
                cell.setFutureColor(1);
            }
            return;


        }
        cell.setFutureColor(0);


    }

    /**
     * method that init the monitored cell
     * @throws IOException
     */
    private void initMonitoredCell() throws IOException {


        System.out.println("Enter x1:");

        int x1 = Integer.parseInt(reader.readLine());
        System.out.println("Enter y1:");
        int y1 = Integer.parseInt(reader.readLine());
        System.out.println("Enter N:");

        this.n = Integer.parseInt(reader.readLine());


        this.storage = new Storage(this.board.getSpecificCell(y1, x1));


    }


    /**
     * initialization of the first generation(created from the user input)
     * @throws IOException
     */
    private void generationZeroInit() throws IOException {
        for (int i = 0; i < this.board.getHeight(); i++) {
            System.out.println("Enter data for current row(111,101,.... :");

            String[] row = this.reader.readLine().split("");

            this.board.setRow(i, row);


        }
    }

    /**
     * board initialization
     * @throws IOException
     */
    private void boardSizeInit() throws IOException {

        System.out.println("Enter the height of the board");
        int y = Integer.parseInt(reader.readLine());
        System.out.println("Enter the width of the board");
        int x = Integer.parseInt(reader.readLine());


        this.board = new Board(y, x);

    }


}
