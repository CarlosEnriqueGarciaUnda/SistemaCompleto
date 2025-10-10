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

            if (usuario.isEmpty() || password.isEmpty() || usuario.equals("Email address") || password.equals("Password")) {
                JOptionPane.showMessageDialog(panelPrincipal,
                        "Por favor ingrese usuario y contraseña",
                        "Error de Login",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(panelPrincipal);
            loginFrame.dispose();

            abrirPanelPrincipal();
        });
    }

    private void crearInterfaz() {
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
        Panel_Principal principal = new Panel_Principal();
        mainFrame.setContentPane(principal.getPanelPrincipal());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1200, 700);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public JPanel getPanelPrincipal() {
        if (panelPrincipal != null) {
            Border line = new LineBorder(Color.white, 10, true);
            panelPrincipal.setBorder(line);
        }
        return panelPrincipal;
    }
}