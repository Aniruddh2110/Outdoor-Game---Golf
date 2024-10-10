import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GolfGame extends JFrame {
    private GolfCourse course;
    private JButton moveButton;
    private JTextField angleField;
    private JTextField powerField;

    public GolfGame() {
        setLayout(new BorderLayout());

        course = new GolfCourse();
        moveButton = new JButton("Hit Ball");

        angleField = new JTextField("Angle (degrees)", 10);
        powerField = new JTextField("Power", 10);

        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double angle = Double.parseDouble(angleField.getText());
                    int power = Integer.parseInt(powerField.getText());
                    course.getBall().move(angle, power);
                    course.checkForHole(); // Check if the ball is in the hole
                    course.repaint(); // Refresh the course
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(GolfGame.this, "Invalid input. Please enter numeric values.");
                }
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(angleField);
        controlPanel.add(powerField);
        controlPanel.add(moveButton);

        add(course, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setTitle("Golf Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GolfGame::new);
    }
}
