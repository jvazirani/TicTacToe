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
        // draw numbers
        // draw col
        // x is always 100
        // y starts at 200 and increments by 200

        // draw row
        // y is always 100
        // x starts at 100 and increments by 2

        //both run 3 times
        g.setColor(Color.red);
        g.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 50));
        Square[][] board = t.getBoard();
        int x = 100;
        int y = 100;
        for(int i = 0; i < board.length; i++){
            g.drawString("" + i, x + 100 + (i * 200), y - 5);
            for(int j = 0; j < board[0].length; j++){
                if (j == 0){
                    g.drawString("" + i, x  - 30, y+ 100 + (i * 200));
                }
                board[i][j].draw(g, this);
                g.setColor(Color.red);
            }
        }
    }
    //paint
    //iterate through squares and call draw() on each
    //draw axes
    //display winning message


    //.getImages()



}
