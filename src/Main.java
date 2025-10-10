import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Configurar LookAndFeel
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 1. Crear el JFrame
            JFrame frame = new JFrame("Login - Sistema TecNM");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 2. Crear la instancia del formulario de Login
            LogIn login = new LogIn();

            // 3. Crear el BackgroundPanel. Usamos GridBagLayout para centrar el formulario.
            BackgroundPanel backgroundContainer = new BackgroundPanel(new GridBagLayout());

            // 4. Agregar el formulario de Login (panelPrincipal) al centro del BackgroundPanel
            JPanel loginPanel = login.getPanelPrincipal();
            if (loginPanel != null) {
                // GridBagConstraints por defecto centra el componente
                backgroundContainer.add(loginPanel, new GridBagConstraints());
            }

            // 5. Asignar el BackgroundPanel como el contenido principal del JFrame
            frame.setContentPane(backgroundContainer);

            // 6. Configuración de la ventana
            frame.setSize(1226, 700);
            frame.setResizable(true);
            frame.setLocationRelativeTo(null); // Centra la ventana
            frame.setVisible(true);
        });
    }
}