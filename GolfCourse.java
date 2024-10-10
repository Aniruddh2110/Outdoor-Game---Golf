import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GolfCourse extends JPanel {
    private GolfBall ball; // Player's ball
    private GolfBall hole; // Representing the hole
    private int score;
    private static final int COURSE_WIDTH = 800; // Width of the course
    private static final int COURSE_HEIGHT = 600; // Height of the course
    private Random random; // Random number generator

    public GolfCourse() {
        ball = new GolfBall(50, 50); // Initial position of the player's ball
        hole = new GolfBall(700, 300); // Initial position of the hole
        score = 0; // Initialize score
        random = new Random(); // Initialize the random number generator
        setPreferredSize(new Dimension(COURSE_WIDTH, COURSE_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(0, 128, 0)); // Set background color to green
        ball.draw(g, Color.WHITE); // Draw the player's ball in white
        hole.draw(g, Color.BLACK); // Draw the hole as a black ball
        drawScore(g); // Draw the score
    }

    private void drawScore(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 20, 30); // Display score
    }

    public GolfBall getBall() {
        return ball;
    }

    public void checkForHole() {
        // Check if the player's ball is in the hole
        int ballX = ball.getX();
        int ballY = ball.getY();

        if (ballX >= hole.getX() && ballX <= hole.getX() + GolfBall.DIAMETER &&
            ballY >= hole.getY() && ballY <= hole.getY() + GolfBall.DIAMETER) {
            score++; // Increment score
            reposition(); // Reposition the ball and hole
        }
    }

    private void reposition() {
        // Randomly reposition the ball and hole within the course boundaries
        ball = new GolfBall(random.nextInt(COURSE_WIDTH - GolfBall.DIAMETER),
                            random.nextInt(COURSE_HEIGHT - GolfBall.DIAMETER));
        hole = new GolfBall(random.nextInt(COURSE_WIDTH - GolfBall.DIAMETER),
                            random.nextInt(COURSE_HEIGHT - GolfBall.DIAMETER));
    }
}
