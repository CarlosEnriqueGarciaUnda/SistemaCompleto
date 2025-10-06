import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                JFrame frame = new JFrame("Login - Sistema TecNM");
                LogIn login = new LogIn();
                frame.setContentPane(login.getPanelPrincipal());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JFrame frame = new JFrame("Login - Sistema TecNM");
                LogIn login = new LogIn();
                frame.setContentPane(login.getPanelPrincipal());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}