import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Heart3D extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.RED);
        int width = getWidth();
        int height = getHeight();

        for (int y = height / 2; y > -height / 2; y--) {
            for (int x = -width / 2; x < width / 2; x++) {
                double nx = x / (width / 4.0);
                double ny = y / (height / 3.0);
                double value = Math.pow(nx * nx + ny * ny - 1, 3) - nx * nx * ny * ny * ny;
                if (value <= 0) {
                    int screenX = width / 2 + x;
                    int screenY = height / 2 - y;
                    g2d.fillRect(screenX, screenY, 1, 1);
                }
            }
        }
    }

    public static void main(String[] args)
     {
        JFrame frame = new JFrame("3D Heart");
        Heart3D heartPanel = new Heart3D();
        frame.add(heartPanel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
