import java.awt.EventQueue;
import javax.swing.*;

public class Application extends JFrame {
    private static Board board;

    public Application() {

        initUI();
    }

    private void initUI() {
        Application.board=new Board(new Gamestate());
        //board.loadImage("src/fish2.png");
        add(board);
        setSize(1000, 1000);

        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void initGamestate(){
        //Do board starting state here
        BoardObject fish=new BoardObject("src/fish2.png",20,10);
        fish.setXY(400,400);
        board.addBoardObject(fish);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
        while(board==null){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        initGamestate();
        while(true){
            board.tickGame();
            board.repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("loop done");
        }
    }
}