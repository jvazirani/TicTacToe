import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;
    private final int SQUARE_HEIGHT = 200;
    private TicTacToeViewer t;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }


    public void draw(Graphics g, TicTacToeViewer t){
        g.setColor(Color.black);
        int x = (SQUARE_HEIGHT / 2) + row * SQUARE_HEIGHT;
        int y = (SQUARE_HEIGHT / 2) + col * SQUARE_HEIGHT;
        g.drawRect(x, y, SQUARE_HEIGHT, SQUARE_HEIGHT);
        if (this.isWinningSquare == true){
            g.setColor(Color.green);
            g.fillRect(x, y, SQUARE_HEIGHT, SQUARE_HEIGHT);
            g.setColor(Color.black);
            if(marker.equals(TicTacToe.X_MARKER)){
                g.drawString("X WINS!", (SQUARE_HEIGHT), 750);
            }
            else if(marker.equals(TicTacToe.O_MARKER)){
                g.drawString("O WINS!", (SQUARE_HEIGHT + 30), 750);
            }
        }
        if(marker.equals(TicTacToe.X_MARKER)){
            g.drawImage(t.getImages()[0], x, y, SQUARE_HEIGHT, SQUARE_HEIGHT, t);
        }
        else if(marker.equals(TicTacToe.O_MARKER)){
            g.drawImage(t.getImages()[1], x, y, SQUARE_HEIGHT, SQUARE_HEIGHT, t);
        }


    }

        // params: x, y, view, graphics g, int dim
    //use marker to decide which image to draw
    // 1. if winning, fill green rect
    //2. draw black rect
    //3. draw image
}
