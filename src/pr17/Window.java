package pr17;


import javax.swing.*;

public class Window extends JFrame {

    Window() {
        super("Snake");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(410, 100, 640, 665);
        add(new GameField());
        setVisible(true);
    }

    public static void main(String[] args) {
        Window start = new Window();
    }
}