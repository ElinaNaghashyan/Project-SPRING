package FinalBilliard;

import java.awt.*;
import java.util.Formatter;
import java.util.Random;
import javax.swing.*;

public class BilliardTask3_WithRectangle extends JPanel {


    private static final int BOX_WIDTH = 900;
    private static final int BOX_HEIGHT = 600;

//    private double Xo;
//    private double Yo;
//    private double Pxo;
//    private double Pyo;

    Random r = new Random();
//    Xo = -1 + (2* r.nextDouble());
//    Yo = -1 + (2* r.nextDouble());
//    Pxo = r.nextDouble();
//    Pyo = r.nextDouble();

    private float ballRadius = 20;
    private double ballX = -1 + (2* r.nextDouble());
    private double ballY = -1 + (2* r.nextDouble());

    private double Pxo = 7;   // Ball's speed for x and y
    private double Pyo = 6;

//        while(!(Math.sqrt(Pxo*Pxo+ Pyo*Pyo) > 0.99 && Math.sqrt(Pxo*Pxo+ Pyo*Pyo) <= 1)){
//            Pxo = r.nextDouble();
//            Pyo = r.nextDouble();
//        }
//


    private static final int UPDATE_RATE = 30;

    public BilliardTask3_WithRectangle() {
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));

        Thread billiardTread = new Thread() {
            public void run() {
                while (true) {
                    // Calculate the ball's new position
                    ballX += Pxo;
                    ballY += Pyo;
                    if (ballX - ballRadius < 0) {
                        Pxo = -Pxo;
                        ballX = ballRadius; // Re-position the ball at the edge
                    } else if (ballX + ballRadius > BOX_WIDTH) {
                        Pxo = -Pxo;
                        ballX = BOX_WIDTH - ballRadius;
                    }
                    if (ballY - ballRadius < 0) {
                        Pyo = -Pyo;
                        ballY = ballRadius;
                    } else if (ballY + ballRadius > BOX_HEIGHT) {
                        Pyo = -Pyo;
                        ballY = BOX_HEIGHT - ballRadius;
                    }

                    repaint();
                    try {
                        Thread.sleep(1000 / UPDATE_RATE);
                    } catch (InterruptedException ex) { }
                }
            }
        };
        billiardTread.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);

        g.setColor(Color.BLUE);
        g.fillOval((int) (ballX - ballRadius), (int) (ballY - ballRadius),
                (int)(2 * ballRadius), (int)(2 * ballRadius));

        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesNewRomanPSMT", Font.PLAIN, 12));
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("Ball @(%3.0f,%3.0f) Speed=(%2.0f,%2.0f)", ballX, ballY,
                Pxo, Pyo);
        g.drawString(sb.toString(), 20, 30);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("A Bouncing Ball");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new BilliardTask3_WithRectangle());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
