import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Usa el look and feel del sistema operativo
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            JFrame frame = new JFrame("Login - Sistema TecNM");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            LogIn login = new LogIn();

            // Usa BackgroundPanel para dibujar el fondo de imagen
            BackgroundPanel backgroundContainer = new BackgroundPanel(new java.awt.GridBagLayout());

            java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
            gbc.anchor = java.awt.GridBagConstraints.CENTER;

            JPanel loginPanel = login.getPanelPrincipal();
            if (loginPanel != null) {
                backgroundContainer.add(loginPanel, gbc);
            }

            frame.setContentPane(backgroundContainer);

            frame.setSize(1226, 700);
            frame.setResizable(true);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}