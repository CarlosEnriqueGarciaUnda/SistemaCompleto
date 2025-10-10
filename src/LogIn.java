import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class LogIn {
    private JPanel panelPrincipal;
    private JTextField emailTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel panelFormulario;

    public LogIn() {
        // Hacemos que los paneles sean transparentes para que se vea el fondo
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

            // Validación simple (simulada)
            if (usuario.isEmpty() || password.isEmpty() || usuario.equals("Email address") || password.equals("Password")) {
                JOptionPane.showMessageDialog(panelPrincipal,
                        "Por favor ingrese usuario y contraseña",
                        "Error de Login",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Cierra la ventana de Login
            JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(panelPrincipal);
            loginFrame.dispose();

            // Abre el Panel Principal
            abrirPanelPrincipal();
        });
    }

    private void crearInterfaz() {
        // Lógica de Placeholder para email
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

        // Lógica de Placeholder para password
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
        Panel_Principal principal = new Panel_Principal();
        mainFrame.setContentPane(principal.getPanelPrincipal());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1200, 700);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public JPanel getPanelPrincipal() {
        if (panelPrincipal != null) {
            // Aplicar borde al formulario de login (Si usas un panel con Layout manager en el .form)
            Border line = new LineBorder(Color.white, 10, true);
            panelPrincipal.setBorder(line);
        }
        return panelPrincipal;
    }
}