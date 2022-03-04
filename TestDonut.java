
import java.awt.EventQueue;
import javax.swing.JFrame;

public class TestDonut extends JFrame {

    public TestDonut() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setSize(330, 330);

        setTitle("Donut");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            TestDonut ex = new TestDonut();
            ex.setVisible(true);
        });
    }
}