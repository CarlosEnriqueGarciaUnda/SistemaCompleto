import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.InputStream;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;
    // Asegúrate de que tu imagen 'background.jpg' esté en la carpeta 'resource'
    private static final String IMAGE_PATH = "resource/background.jpg";

    public BackgroundPanel(LayoutManager layout) {
        super(layout);
        cargarImagen();
    }

    private void cargarImagen() {
        try {
            // Carga la imagen desde el classpath (carpeta 'resource')
            InputStream is = getClass().getClassLoader().getResourceAsStream(IMAGE_PATH);
            if (is != null) {
                backgroundImage = ImageIO.read(is);
            } else {
                System.err.println("Error: Imagen de fondo '" + IMAGE_PATH + "' no encontrada en el classpath.");
                // Fondo gris claro si no encuentra la imagen
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
            // Dibuja la imagen escalándola para que ocupe todo el panel
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}