package sample;

import javafx.scene.shape.Rectangle;

public class Player implements Runnable{

    private final static double MIN_HEIGH = 350;
    private final static double MAX_HEIGH = 0;
    private final int jumpsize = 2;

    private Rectangle wall;
    private volatile boolean up, down;

    public Player(int playercount, Rectangle rect) {
        wall = rect;
        if(playercount == 1) {
            wall.setX(10);
            up = down = false;

        } else {
            wall.setX(680);
            up = down = false;
        }
    }

    @Override
    public void run() {
        double y;
        while(true) {
            if(up) {
                y = wall.getY();
                wall.setY(y > MAX_HEIGH ? y-jumpsize : MAX_HEIGH);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(down) {
                y = wall.getY();
                wall.setY(y < MIN_HEIGH ? y+jumpsize : MIN_HEIGH);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void up(boolean state) {
        up = state;
        System.out.println("up");
    }

    public void down(boolean state) {
        down = state;
        System.out.println("down");
    }
}
