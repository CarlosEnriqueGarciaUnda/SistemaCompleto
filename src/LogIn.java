import javax.swing.*;
import java.awt.*;

public class LogIn {
    private JPanel panelPrincipal;
    private JTextField emailTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel panelFormulario;

    public LogIn() {
        crearInterfaz();

        loginButton.addActionListener(e -> {
            String usuario = emailTextField.getText();
            String password = new String(passwordField.getPassword());

            if (usuario.isEmpty() || password.isEmpty()) {
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
        return panelPrincipal;
    }


}