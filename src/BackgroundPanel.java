import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.InputStream;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    private static final String IMAGE_PATH = "resource/background.jpg";

    public BackgroundPanel(LayoutManager layout) {
        super(layout);
        cargarImagen();
    }

    private void cargarImagen() {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(IMAGE_PATH);
            if (is != null) {
                backgroundImage = ImageIO.read(is);
            } else {
                System.err.println("Error: Imagen de fondo '" + IMAGE_PATH + "' no encontrada en el classpath.");
                setBackground(new Color(230, 230, 230));
            }
        } catch (IOException e) {
            System.err.println("Excepción al cargar la imagen de fondo: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}