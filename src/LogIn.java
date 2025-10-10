import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LogIn {
    // Variables vinculadas a tu .form de IntelliJ
    private JPanel panelPrincipal;
    private JTextField emailTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel panelFormulario;

    public LogIn() {
        // *** CRUCIAL: Hacemos el panel transparente para ver el fondo ***
        if (panelPrincipal != null) {
            panelPrincipal.setOpaque(false);
        }
        if (panelFormulario != null) {
            panelFormulario.setOpaque(false);
        }

        crearInterfaz();

        loginButton.addActionListener(e -> {
            String usuario = emailTextField.getText();
            String password = new String(passwordField.getPassword());

            // Validación básica para evitar campos vacíos o texto de placeholder
            if (usuario.isEmpty() || password.isEmpty() || usuario.equals("Email address") || password.equals("Password")) {
                JOptionPane.showMessageDialog(panelPrincipal,
                        "Por favor ingrese usuario y contraseña",
                        "Error de Login",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 1. Cerrar la ventana de Login
            JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(panelPrincipal);
            loginFrame.dispose();

            // 2. Abrir la ventana principal
            abrirPanelPrincipal();
        });
    }

    private void crearInterfaz() {
        // FocusListeners para los Placeholders
        emailTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (emailTextField.getText().equals("Email address")) {
                    emailTextField.setText("");
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (emailTextField.getText().isEmpty()) {
                    emailTextField.setText("Email address");
                }
            }
        });

        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (new String(passwordField.getPassword()).equals("Password")) {
                    passwordField.setText("");
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (new String(passwordField.getPassword()).isEmpty()) {
                    passwordField.setText("Password");
                }
            }
        });
    }

    private void abrirPanelPrincipal() {
        JFrame mainFrame = new JFrame("Sistema Principal - TecNM");

        // Instancia y asigna tu Panel_Principal
        Panel_Principal principal = new Panel_Principal();
        mainFrame.setContentPane(principal.getPanelPrincipal());

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1200, 700);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public JPanel getPanelPrincipal() {
        if (panelPrincipal != null) {
            // 1. Crear el borde de línea (negro, grosor 3, esquinas redondeadas)
            Border line = new LineBorder(Color.white, 10, true);

            // 2. Crear un borde vacío para darle un poco de relleno interno si es necesario (opcional)
            // EmptyBorder empty = new EmptyBorder(10, 10, 10, 10);

            // 3. Crear un borde compuesto: primero el relleno, luego la línea.
            // Utilizaremos solo el borde de línea para un efecto más limpio y directo.
            panelPrincipal.setBorder(line);

            // Si quieres un borde más sutil, puedes usar un color más claro como gris:
            // Border line = new LineBorder(new Color(180, 180, 180), 2, true);
        }
        return panelPrincipal;
    }
}