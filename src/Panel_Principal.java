import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Panel_Principal {
    private JPanel panelPrincipal;
    private JPanel panelCentral;
    private CardLayout cardLayout;

    private JPanel menuPanel;
    private JButton instructoresButton;
    private JButton cursosButton;
    private JButton asistenciasButton;


    private JPanel panelInstructores;
    private JTextField txtNivelInstructores;
    private JTextField txtInstitucionInstructores;
    private JTextField txtAnioInicioInstructores;
    private JTextField txtAnioFinInstructores;
    private JButton btnAgregarInstructores;
    private JButton btnCancelarInstructores;
    private JButton btnRegresarInstructores;
    private JTable tablaInstructores;
    private JScrollPane scrollInstructores;


    private JPanel panelCursos;
    private JComboBox<String> cmbPeriodoCursos;
    private JTextField txtNombreCursos;
    private JTextField txtClaveCursos;
    private JComboBox<String> cmbDiasCursos;
    private JTextField txtHorarioCursos;
    private JComboBox<String> cmbTipoCursos;
    private JButton btnAgregarCursos;
    private JButton btnCancelarCursos;
    private JButton btnRegresarCursos;
    private JTable tablaCursos;
    private JScrollPane scrollCursos;


    private JPanel panelAsistencias;
    private JTextField txtNombreAsistencias;
    private JComboBox<String> cmbNivelAsistencias;
    private JTextField txtCurpAsistencias;
    private JTextField txtRfcAsistencias;
    private JComboBox<String> cmbDeptoAsistencias;
    private JComboBox<String> cmbJefeAsistencias;
    private JComboBox<String> cmbContratoAsistencias;
    private JButton btnAgregarAsistencias;
    private JButton btnCancelarAsistencias;
    private JButton btnRegresarAsistencias;
    private JTable tablaAsistencias;
    private JScrollPane scrollAsistencias;

    public Panel_Principal() {
        inicializarComponentes();
        configurarEventos();
        inicializarTablas();
    }

    private void inicializarComponentes() {
        cardLayout = (CardLayout) panelCentral.getLayout();
        inicializarCombobox();
    }

    private void inicializarCombobox() {

        cmbPeriodoCursos.setModel(new DefaultComboBoxModel<>(new String[]{"Seleccionar", "Feb-Ene 2025", "Agos-Dic 2025"}));
        cmbDiasCursos.setModel(new DefaultComboBoxModel<>(new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"}));
        cmbTipoCursos.setModel(new DefaultComboBoxModel<>(new String[]{"Seleccionar", "Presencial", "En línea", "Mixto"}));


        cmbNivelAsistencias.setModel(new DefaultComboBoxModel<>(new String[]{"Licenciatura", "Maestría", "Doctorado"}));
        cmbDeptoAsistencias.setModel(new DefaultComboBoxModel<>(new String[]{"Ciencias Básicas", "Ingeniería", "Administración"}));
        cmbJefeAsistencias.setModel(new DefaultComboBoxModel<>(new String[]{"Sí", "No"}));
        cmbContratoAsistencias.setModel(new DefaultComboBoxModel<>(new String[]{"Honorarios", "Base"}));
    }

    private void inicializarTablas() {

        String[] columnasInstructores = {"Nivel Académico", "Institución", "Año Inicio", "Año Fin"};
        DefaultTableModel modelInstructores = new DefaultTableModel(columnasInstructores, 0);
        tablaInstructores.setModel(modelInstructores);


        String[] columnasCursos = {"Periodo", "Nombre del Curso", "Clave", "Días", "Horario", "Tipo"};
        DefaultTableModel modelCursos = new DefaultTableModel(columnasCursos, 0);
        tablaCursos.setModel(modelCursos);


        String[] columnasAsistencias = {"Nombre", "Nivel Académico", "CURP", "RFC", "Departamento", "Jefe Inmediato", "Tipo Contrato"};
        DefaultTableModel modelAsistencias = new DefaultTableModel(columnasAsistencias, 0);
        tablaAsistencias.setModel(modelAsistencias);
    }

    private void configurarEventos() {

        instructoresButton.addActionListener(e -> cardLayout.show(panelCentral, "Instructores"));
        cursosButton.addActionListener(e -> cardLayout.show(panelCentral, "Cursos"));
        asistenciasButton.addActionListener(e -> cardLayout.show(panelCentral, "Asistencias"));


        btnAgregarInstructores.addActionListener(e -> agregarInstructor());
        btnCancelarInstructores.addActionListener(e -> limpiarCamposInstructores());
        btnRegresarInstructores.addActionListener(e -> regresarLogin());


        btnAgregarCursos.addActionListener(e -> agregarCurso());
        btnCancelarCursos.addActionListener(e -> limpiarCamposCursos());
        btnRegresarCursos.addActionListener(e -> regresarLogin());


        btnAgregarAsistencias.addActionListener(e -> agregarAsistencia());
        btnCancelarAsistencias.addActionListener(e -> limpiarCamposAsistencias());
        btnRegresarAsistencias.addActionListener(e -> regresarLogin());
    }

    private void agregarInstructor() {
        if (!txtNivelInstructores.getText().isEmpty() && !txtInstitucionInstructores.getText().isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) tablaInstructores.getModel();
            model.addRow(new Object[]{
                    txtNivelInstructores.getText(),
                    txtInstitucionInstructores.getText(),
                    txtAnioInicioInstructores.getText(),
                    txtAnioFinInstructores.getText()
            });
            limpiarCamposInstructores();
        } else {
            JOptionPane.showMessageDialog(panelPrincipal, "Complete los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void agregarCurso() {
        if (!txtNombreCursos.getText().isEmpty() && !txtClaveCursos.getText().isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) tablaCursos.getModel();
            model.addRow(new Object[]{
                    cmbPeriodoCursos.getSelectedItem(),
                    txtNombreCursos.getText(),
                    txtClaveCursos.getText(),
                    cmbDiasCursos.getSelectedItem(),
                    txtHorarioCursos.getText(),
                    cmbTipoCursos.getSelectedItem()
            });
            limpiarCamposCursos();
        } else {
            JOptionPane.showMessageDialog(panelPrincipal, "Complete los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void agregarAsistencia() {
        if (!txtNombreAsistencias.getText().isEmpty() && !txtCurpAsistencias.getText().isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) tablaAsistencias.getModel();
            model.addRow(new Object[]{
                    txtNombreAsistencias.getText(),
                    cmbNivelAsistencias.getSelectedItem(),
                    txtCurpAsistencias.getText(),
                    txtRfcAsistencias.getText(),
                    cmbDeptoAsistencias.getSelectedItem(),
                    cmbJefeAsistencias.getSelectedItem(),
                    cmbContratoAsistencias.getSelectedItem()
            });
            limpiarCamposAsistencias();
        } else {
            JOptionPane.showMessageDialog(panelPrincipal, "Complete los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void limpiarCamposInstructores() {
        txtNivelInstructores.setText("");
        txtInstitucionInstructores.setText("");
        txtAnioInicioInstructores.setText("");
        txtAnioFinInstructores.setText("");
    }

    private void limpiarCamposCursos() {
        cmbPeriodoCursos.setSelectedIndex(0);
        txtNombreCursos.setText("");
        txtClaveCursos.setText("");
        cmbDiasCursos.setSelectedIndex(0);
        txtHorarioCursos.setText("");
        cmbTipoCursos.setSelectedIndex(0);
    }

    private void limpiarCamposAsistencias() {
        txtNombreAsistencias.setText("");
        cmbNivelAsistencias.setSelectedIndex(0);
        txtCurpAsistencias.setText("");
        txtRfcAsistencias.setText("");
        cmbDeptoAsistencias.setSelectedIndex(0);
        cmbJefeAsistencias.setSelectedIndex(0);
        cmbContratoAsistencias.setSelectedIndex(0);
    }

    private void regresarLogin() {
        JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(panelPrincipal);
        mainFrame.dispose();

        JFrame loginFrame = new JFrame("Login - Sistema TecNM");
        LogIn login = new LogIn();
        loginFrame.setContentPane(login.getPanelPrincipal());
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(400, 500);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}