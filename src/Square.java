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
        int x = (SQUARE_HEIGHT / 2) + col * SQUARE_HEIGHT;
        int y = (SQUARE_HEIGHT / 2) + row * SQUARE_HEIGHT;
        // If there is a winning square
        if(this.isWinningSquare){
            g.setColor(Color.green);
            // Fill the box green
            g.fillRect(x, y, SQUARE_HEIGHT, SQUARE_HEIGHT);
            g.setColor(Color.black);
            // If that winning square is X, print "X wins"
            if(marker.equals(TicTacToe.X_MARKER)){
                g.drawString("X WINS!", (SQUARE_HEIGHT + 100), 750);
            }
            // If the winning square is O, print "O wins"
            else if(marker.equals(TicTacToe.O_MARKER)){
                g.drawString("O WINS!", (SQUARE_HEIGHT + 100), 750);
            }
        }
        // Draw the board of squares
        g.drawRect(x, y, SQUARE_HEIGHT, SQUARE_HEIGHT);
        // Draw the X image or the O image, depending on which one the marker equals
        if(marker.equals(TicTacToe.X_MARKER)){
            g.drawImage(t.getImages()[0], x, y, SQUARE_HEIGHT, SQUARE_HEIGHT, t);
        }
        else if(marker.equals(TicTacToe.O_MARKER)){
            g.drawImage(t.getImages()[1], x, y, SQUARE_HEIGHT, SQUARE_HEIGHT, t);
        }
    }
}
