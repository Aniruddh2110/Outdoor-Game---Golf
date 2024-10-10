import java.awt.Color;
import java.awt.Graphics;

public class GolfBall {
    public static final int DIAMETER = 15; // Size of the ball
    private int x, y; // Position of the ball

    public GolfBall(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void move(double angle, int power) {
        // Calculate the new position based on angle (in degrees) and power
        double radians = Math.toRadians(angle);
        int dx = (int) (power * Math.cos(radians));
        int dy = (int) (power * Math.sin(radians));
        x += dx;
        y -= dy; // Subtract dy because y-coordinates increase downwards
    }

    public void draw(Graphics g, Color color) {
        g.setColor(color);
        g.fillOval(x, y, DIAMETER, DIAMETER);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, DIAMETER, DIAMETER);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
