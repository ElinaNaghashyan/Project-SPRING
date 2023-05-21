package FinalBilliard;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class BilliardBallProperties extends JPanel {
    private static final int UPDATE_RATE = 30;

    private Ball ball;
    private ContainerBox box;
    private DrawCanvas canvas;
    private int canvasWidth;
    private int canvasHeight;

    public BilliardBallProperties(int width, int height) {

        canvasWidth = width;
        canvasHeight = height;

        // Init the ball at a random location (inside the box) and moveAngle, we can change them
        Random r = new Random();
        int radius = 200;
        double x = -1 + (2* r.nextDouble());
        double y = -1 + (2* r.nextDouble());
        int speed = 5;
        int angleInDegree = r.nextInt(360);
        ball = new Ball((float) x, (float) y, radius, speed, angleInDegree, Color.BLUE);

        box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.BLACK, Color.WHITE);
        canvas = new DrawCanvas();
        this.setLayout(new BorderLayout());
        this.add(canvas, BorderLayout.CENTER);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component c = (Component)e.getSource();
                Dimension dim = c.getSize();
                canvasWidth = dim.width;
                canvasHeight = dim.height;
                box.set(0, 0, canvasWidth, canvasHeight);
            }
        });

        BallMoving();
    }

    public void BallMoving() {
        Thread gameThread;
        gameThread = new Thread() {
            public void run() {
                while (true) {
                    BilliardUpdate();
                    repaint();
                    try {
                        Thread.sleep(1000 / UPDATE_RATE);
                    } catch (InterruptedException ex) {}
                }
            }
        };
        gameThread.start();
    }

    public void BilliardUpdate() {
        ball.moveOneStepWithCollisionDetection(box);
    }

    class DrawCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            box.draw(g);
            ball.draw(g);
            g.setColor(Color.WHITE);
            g.setFont(new Font("TimesNewRomanPSMT", Font.PLAIN, 12));
            g.drawString("Ball " + ball.toString(), 20, 30);
        }

        @Override
        public Dimension getPreferredSize() {
            return (new Dimension(canvasWidth, canvasHeight));
        }
    }
}

