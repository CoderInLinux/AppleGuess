import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Apples extends JFrame implements ActionListener {

    JButton button1, button2, buttonCorrect;
    JLabel label, label1;
    int points = 0;

    public Apples() {
        //All this is the JFrame interface
        setLayout(null);
        label = new JLabel("¡Choose!");
        label.setBounds(10, 10, 100, 30);
        add(label);

        setLayout(null);
        label1 = new JLabel("Points: " + points);
        label1.setBounds(10, 40, 100, 30);
        add(label1);

        setLayout(null);
        button1 = new JButton("Apple 1");
        button1.setBounds(10, 100, 100, 30);
        add(button1);
        button1.addActionListener(this);

        setLayout(null);
        button2 = new JButton("Apple 2");
        button2.setBounds(150, 100, 100, 30);
        add(button2);
        button2.addActionListener(this);

        //Change the positions of the correct button
        Random random1 = new Random();
        buttonCorrect = random1.nextBoolean() ? button1 : button2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //If you are fine, you get a point.
        if (e.getSource() == buttonCorrect) {
            points++;
            label1.setText("Puntos: " + points);
            System.out.println("Correct Apple");
        } else  {
            //If not, it resets and you start again.
            points = 0;
            label1.setText("Puntos: " + points);
            System.out.println("Has fallado");
        }
        //Change positions when you have lost again
        Random random2 = new Random();
        buttonCorrect = random2.nextBoolean() ? button1 : button2;
    }

    public static void main(String[] args) {
        Apples apples = new Apples();
        apples.setBounds(100, 100, 450, 300);
        apples.setVisible(true);
        apples.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}