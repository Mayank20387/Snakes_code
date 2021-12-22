//package sample;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//
//public class Gameboard {
//    public static final int ROWS = 10;
//    public static final int COLS = 10;
//    public static final int NUMBER_OF_TILES = ROWS * COLS;
//    public static final int WIN_POINT = 100;
//    public static final int DICE_ROLL_DELAY = 1;
//    public static final int COMPUTER_MOVE_DELAY = 2;
//    public static final int PLAYER_STARTING_POSITION = 0;
//
//    private Map<Integer, Integer> SNAKES;
//    private Map<Integer, Integer> LADDERS;
//
//    Gameboard(){
//        initializeSNAKESandLADDERSPositions();
//        initializeTiles();
//    }
//
//    private void initializeTiles() {
//        Tile[] tiles = new Tile[NUMBER_OF_TILES];
//
//        for (int i = 0; i < tiles.length; i++) {
//            if (SNAKES.containsKey(i)) {
//                tiles[i] = new Tile(i, TileContainer.SNAKE);
//            } else if (LADDERS.containsKey(i)) {
//                tiles[i] = new Tile(i, TileContainer.LADDER);
//            } else {
//                tiles[i] = new Tile(i, TileContainer.NONE);
//            }
//        }
//    }
//
//    private void initializeSNAKESandLADDERSPositions() {
//        SNAKES = new HashMap<>();
//        LADDERS = new HashMap<>();
//
//        SNAKES.put(11, 9);
//        SNAKES.put(36, 14);
//        SNAKES.put(56, 18);
//        SNAKES.put(43, 22);
//        SNAKES.put(90, 50);
//        SNAKES.put(94, 53);
//        SNAKES.put(75, 54);
//        SNAKES.put(81, 63);
//        SNAKES.put(96, 65);
//        SNAKES.put(99,78);
//        LADDERS.put(4, 25);
//        LADDERS.put(8, 31);
//        LADDERS.put(21, 60);
//        LADDERS.put(28, 46);
//        LADDERS.put(32, 48);
//        LADDERS.put(42, 80);
//        LADDERS.put(52, 68);
//        LADDERS.put(58, 77);
//        LADDERS.put(69, 93);
//        LADDERS.put(84, 98);
//    }
//
//    public int getUpdatedPosition(int currentIndex) {
//        int updatedIndex = -1;
//
//        if (SNAKES.containsKey(currentIndex)) {
//            updatedIndex = SNAKES.get(currentIndex);
//        } else if (LADDERS.containsKey(currentIndex)) {
//            updatedIndex = LADDERS.get(currentIndex);
//        }
//
//        return updatedIndex;
//    }
//
//    public int[] getBoardCoordinates(int newIndex) {
//        int row = newIndex / ROWS;	// ROWS - 1 - newIndex / ROWS if I don't send rows*cols - newIndex
//        int column = newIndex % COLS;
//
//        if (row % 2 == 1) {		// If I don't want to send ROW * COLS - newIndex, the condition will be row % 2 == 0
//            column = COLS - 1 - column;
//        }
//
//        return new int[] {row, column};
//    }
//
//    public int rollDice() {
//        final int MIN = 1;
//        final int MAX = 6;
//
//        return new Random().nextInt((MAX - MIN) + 1) + MIN;
//    }
//
//    public Player getCurrentPlayer() {
//        Player currentPlayer = null;
//
//        if (player1.getTurn() == 1) {
//            currentPlayer = player1;
//        } else if (player2.getTurn() == 1) {
//            currentPlayer = player2;
//        }
//
//        return currentPlayer;
//    }
//
//    public Tile getTile(int index) {
//        return tiles[index];
//    }
//
//    public Player getPlayer1() {
//        return player1;
//    }
//
//    public void setPlayer1(Player player1) {
//        this.player1 = player1;
//    }
//
//    public Player getPlayer2() {
//        return player2;
//    }
//
//    public void setPlayer2(Player player2) {
//        this.player2 = player2;
//    }
//
//}
