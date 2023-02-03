import java.awt.*;
import javax.swing.*;
public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;
    private Image[] XO;
    private TicTacToe t;
    private Square s;


    public TicTacToeViewer(TicTacToe t){
        this.t = t;
        XO = new Image[2];
        XO[0] = new ImageIcon("Resources/X.png").getImage();
        XO[1] = new ImageIcon("Resources/O.png").getImage();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getImages(){
        return XO;
    }
    //constructor
        // create image objects

    @Override
    public void paint(Graphics g){
        // Set the color and font for the numbers
        g.setColor(Color.red);
        g.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 50));
        Square[][] board = t.getBoard();
        int x = 100;
        int y = 100;
        for(int i = 0; i < board.length; i++){
            // First row of numbers
            g.drawString("" + i, x + 100 + (i * 200), y - 5);
            for(int j = 0; j < board[0].length; j++){
                // Draw col of numbers
                if (j == 0){
                    g.drawString("" + i, x  - 30, y+ 100 + (i * 200));
                }
                // Call draw (draws the squares and images)
                board[i][j].draw(g, this);
                // Set color back to red for the numbers
                g.setColor(Color.red);
                if ((t.checkTie())){
                    g.setColor(Color.black);
                    g.drawString("Game ends in a tie!", (170), 750);
                    g.setColor(Color.red);
                }
            }
        }
    }



}
