import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Panel_Principal {

    private JPanel panelPrincipal;
    private JPanel menuPanel;
    private JButton instructoresButton;
    private JButton cursosButton;
    private JButton asistenciasButton;
    private JPanel panelCentral;
    private JPanel botonesCursosPanel; // ¡Añade esta línea!

    private JPanel panelInstructores;
    private JTable tablaInstructores;
    private JScrollPane scrollInstructores;
    private JPanel formularioInstructores;
    private JPanel formInstructores;
    private JPanel botonesInstructoresPanel; // Contenedor de botones
    private JButton btnAgregarInstructor;
    private JButton btnCancelarInstructor;
    private JButton btnVolverInstructor;

    // Campos de Instructores
    private JTextField txtCurpInstructores;
    private JTextField txtNombreInstructores;
    private JTextField txtRfcInstructores;
    private JTextField txtPrimerApellidoInstructores;
    private JTextField txtSegundoApellidoInstructores;
    private JTextField txtTelefonoInstructores;
    private JTextField txtCorreoInstructores;
    private JComboBox<String> cmbFormacionInstructores;
    private JTextField txtInstitucionInstructores;
    private JTextField txtTitulacionAnioInstructores;
    private JTextField txtCedulaInstructores;

    // ===============================================
    // 3. COMPONENTES DEL PANEL CURSOS (BINDINGS)
    // ===============================================
    private JPanel panelCursos;
    private JTable tablaCursos;
    private JScrollPane scrollCursos;
    private JPanel contenidoCursos;
    private JPanel formCursos;
    private JButton btnAgregarCurso;
    private JButton btnCancelarCurso;
    private JButton btnVolverCurso;

    // Campos de Cursos
    private JTextField txtPeriodoCurso;
    private JTextField txtNombreCurso;
    private JButton btnArchivoCurso;
    private JTextField txtClaveCurso;
    private JComboBox<String> cmbTipoCurso;
    private JTextField txtHoraInicioCurso;
    private JTextField txtHoraFinalCurso;
    private JPanel diasCursoPanel; // Contenedor de CheckBoxes
    private JCheckBox cbLun;
    private JCheckBox cbMar;
    private JCheckBox cbMie;
    private JCheckBox cbJue;
    private JCheckBox cbVie;
    private JCheckBox cbSab;
    private JCheckBox cbDom;
    private JTextArea txtActividadPorcentaje;

    // ===============================================
    // 4. COMPONENTES DEL PANEL ASISTENCIAS (BINDINGS)
    // ===============================================
    private JPanel panelAsistencias;
    private JTable tablaAsistencias;
    private JScrollPane scrollAsistencias;
    private JPanel contenidoAsistencias;
    private JPanel formAsistencias;
    private JButton btnAgregarAsistencia;
    private JButton btnCancelarAsistencia;
    private JButton btnVolverAsistencia;

    // Campos de Asistencias
    private JTextField txtNombreAsistencias;
    private JComboBox<String> cmbNivelAsistencias;
    private JTextField txtCurpAsistencias;
    private JTextField txtRfcAsistencias;
    private JTextField txtDepartamentoAsistencias;
    private JComboBox<String> cmbJefeAsistencias;
    private JComboBox<String> cmbContratoAsistencias;
    private JTextField txtHorarioAsistencias;

    // === NUEVO PANEL DE BIENVENIDA ===
    private JPanel panelBienvenida;

    public Panel_Principal() {
        if (panelCentral != null) {
            inicializarEstilos();
            inicializarTablas();
            crearPanelesCentrales(); // Ahora solo crea la bienvenida
        }
        agregarListeners();
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    private void inicializarEstilos() {
    }

    private void inicializarTablas() {
        String[] columnasInstructores = {
                "CURP", "Nombre(s)", "Primer Apellido", "Segundo Apellido", "RFC",
                "Teléfono", "Correo", "Formación Académica", "Institución", "Titulacion (Año)", "Cédula"
        };
        tablaInstructores.setModel(new DefaultTableModel(columnasInstructores, 0));

        String[] columnasCursos = {"Periodo", "Nombre Del Curso", "Clave", "Tipo", "Días", "Horario", "Actividades y Porcentaje"};
        tablaCursos.setModel(new DefaultTableModel(columnasCursos, 0));

        String[] columnasAsistencias = {"Nombre", "Nivel Académico", "CURP", "RFC", "Departamento", "Jefe Inmediato", "Contrato", "Horario"};
        tablaAsistencias.setModel(new DefaultTableModel(columnasAsistencias, 0));
    }

    private void crearPanelesCentrales() {
        panelBienvenida = crearPanelBienvenida();

        // Agregar todas las 'cartas' al CardLayout y mostrar la Bienvenida
        panelCentral.removeAll();
        panelCentral.add(panelBienvenida, "Bienvenida");
        panelCentral.add(panelInstructores, "Instructores");
        panelCentral.add(panelCursos, "Cursos");
        panelCentral.add(panelAsistencias, "Asistencias");

        CardLayout cl = (CardLayout) (panelCentral.getLayout());
        cl.show(panelCentral, "Bienvenida");

        panelCentral.revalidate();
        panelCentral.repaint();
    }

    // Mantiene la creación de la bienvenida manual
    private JPanel crearPanelBienvenida() {
        JPanel panel = new JPanel(new GridBagLayout()) {
            private Image backgroundImage;
            {
                try {
                    backgroundImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resource/imagenfondopanel.jpg"))).getImage();
                } catch (Exception e) {
                    System.err.println("Error al cargar la imagen de fondo: " + e.getMessage());
                }
            }
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panel.setBackground(Color.WHITE);

        JLabel bienvenidaLabel = new JLabel("¡Bienveni@!");
        bienvenidaLabel.setFont(new Font("Arial", Font.BOLD, 38));
        bienvenidaLabel.setForeground(Color.black.darker());

        panel.add(bienvenidaLabel);
        return panel;
    }

    // ===============================================
    // LÓGICA DE EVENTOS Y FUNCIONALIDAD
    // ===============================================

    private void agregarListeners() {
        CardLayout cl = (CardLayout) (panelCentral.getLayout());

        // Listeners de Navegación
        instructoresButton.addActionListener(e -> cl.show(panelCentral, "Instructores"));
        cursosButton.addActionListener(e -> cl.show(panelCentral, "Cursos"));
        asistenciasButton.addActionListener(e -> cl.show(panelCentral, "Asistencias"));

        // Listeners de Botones de Instructores
        btnAgregarInstructor.addActionListener(this::agregarInstructor);
        btnCancelarInstructor.addActionListener(e -> limpiarCamposInstructores());
        btnVolverInstructor.addActionListener(e -> cerrarVentana());

        // Listeners de Botones de Cursos
        btnAgregarCurso.addActionListener(this::agregarCurso);
        btnCancelarCurso.addActionListener(e -> limpiarCamposCursos());
        btnVolverCurso.addActionListener(e -> cerrarVentana());

        // Listeners de Botones de Asistencias
        btnAgregarAsistencia.addActionListener(this::agregarAsistencia);
        btnCancelarAsistencia.addActionListener(e -> limpiarCamposAsistencias());
        btnVolverAsistencia.addActionListener(e -> cerrarVentana());
    }

    // --- Lógica de Instructores ---
    private void agregarInstructor(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) tablaInstructores.getModel();

        if (txtCurpInstructores.getText().trim().isEmpty() || txtNombreInstructores.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panelPrincipal, "El CURP y el Nombre no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        model.addRow(new Object[]{
                txtCurpInstructores.getText(),
                txtNombreInstructores.getText(),
                txtPrimerApellidoInstructores.getText(),
                txtSegundoApellidoInstructores.getText(),
                txtRfcInstructores.getText(),
                txtTelefonoInstructores.getText(),
                txtCorreoInstructores.getText(),
                Objects.requireNonNull(cmbFormacionInstructores.getSelectedItem()).toString(),
                txtInstitucionInstructores.getText(),
                txtTitulacionAnioInstructores.getText(),
                txtCedulaInstructores.getText()
        });
        limpiarCamposInstructores();
        JOptionPane.showMessageDialog(panelPrincipal, "Instructor agregado y tabla actualizada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void limpiarCamposInstructores() {
        List<JTextComponent> campos = Arrays.asList(
                txtCurpInstructores, txtNombreInstructores, txtRfcInstructores,
                txtPrimerApellidoInstructores, txtSegundoApellidoInstructores,
                txtTelefonoInstructores, txtCorreoInstructores,
                txtInstitucionInstructores, txtTitulacionAnioInstructores,
                txtCedulaInstructores
        );
        limpiarCampos(campos);
        cmbFormacionInstructores.setSelectedIndex(0);
    }

    // --- Lógica de Cursos ---
    private void agregarCurso(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) tablaCursos.getModel();

        if (txtNombreCurso.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panelPrincipal, "El nombre del curso no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener días seleccionados
        String diasSeleccionados = obtenerDiasSeleccionados();

        model.addRow(new Object[]{
                txtPeriodoCurso.getText(),
                txtNombreCurso.getText(),
                txtClaveCurso.getText(),
                Objects.requireNonNull(cmbTipoCurso.getSelectedItem()).toString(),
                diasSeleccionados,
                txtHoraInicioCurso.getText() + "-" + txtHoraFinalCurso.getText(),
                txtActividadPorcentaje.getText()
        });
        limpiarCamposCursos();
        JOptionPane.showMessageDialog(panelPrincipal, "Curso agregado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private String obtenerDiasSeleccionados() {
        List<JCheckBox> diasCheckBoxes = Arrays.asList(cbLun, cbMar, cbMie, cbJue, cbVie, cbSab, cbDom);
        StringBuilder sb = new StringBuilder();
        for (JCheckBox cb : diasCheckBoxes) {
            if (cb.isSelected()) {
                sb.append(cb.getText()).append(" ");
            }
        }
        return sb.toString().trim();
    }

    private void limpiarCamposCursos() {
        List<JTextComponent> campos = Arrays.asList(
                txtPeriodoCurso, txtNombreCurso, txtClaveCurso, txtHoraInicioCurso, txtHoraFinalCurso, txtActividadPorcentaje
        );
        limpiarCampos(campos);
        cmbTipoCurso.setSelectedIndex(0);
        // Limpiar CheckBoxes
        List<JCheckBox> diasCheckBoxes = Arrays.asList(cbLun, cbMar, cbMie, cbJue, cbVie, cbSab, cbDom);
        for(JCheckBox cb : diasCheckBoxes) cb.setSelected(false);
    }

    // --- Lógica de Asistencias ---
    private void agregarAsistencia(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) tablaAsistencias.getModel();

        if (txtNombreAsistencias.getText().trim().isEmpty() || txtCurpAsistencias.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panelPrincipal, "El Nombre y el CURP no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        model.addRow(new Object[]{
                txtNombreAsistencias.getText(),
                Objects.requireNonNull(cmbNivelAsistencias.getSelectedItem()).toString(),
                txtCurpAsistencias.getText(),
                txtRfcAsistencias.getText(),
                txtDepartamentoAsistencias.getText(),
                Objects.requireNonNull(cmbJefeAsistencias.getSelectedItem()).toString(),
                Objects.requireNonNull(cmbContratoAsistencias.getSelectedItem()).toString(),
                txtHorarioAsistencias.getText()
        });
        limpiarCamposAsistencias();
        JOptionPane.showMessageDialog(panelPrincipal, "Asistencia agregada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void limpiarCamposAsistencias() {
        List<JTextComponent> campos = Arrays.asList(txtNombreAsistencias, txtCurpAsistencias, txtRfcAsistencias, txtDepartamentoAsistencias, txtHorarioAsistencias);
        limpiarCampos(campos);
        cmbNivelAsistencias.setSelectedIndex(0);
        cmbJefeAsistencias.setSelectedIndex(0);
        cmbContratoAsistencias.setSelectedIndex(0);
    }

    // --- Métodos Auxiliares ---

    private void limpiarCampos(List<? extends JTextComponent> campos) {
        for(JTextComponent campo : campos) {
            campo.setText("");
        }
    }

    private void configurarBotonEstandar(JButton button, Color color) {

        button.setPreferredSize(new Dimension(170, 35));
        button.setMinimumSize(new Dimension(170, 35));

        // --> AÑADIR ESTAS LÍNEAS CLAVE <--
        button.setOpaque(true);
        button.setBorderPainted(false); // Para asegurar que no hay un borde adicional feo
        // ---------------------------------

        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
    }

    private void cerrarVentana() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelPrincipal);
        if (frame != null) {
            frame.dispose();
            SwingUtilities.invokeLater(() -> {
                JFrame loginFrame = new JFrame("Login - Sistema TecNM");
                // Asegúrate de que LogIn exista y tenga un método getPanelPrincipal()
                LogIn login = new LogIn();
                BackgroundPanel backgroundContainer = new BackgroundPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                backgroundContainer.add(login.getPanelPrincipal(), gbc);
                loginFrame.setContentPane(backgroundContainer);
                loginFrame.setSize(1226, 700);
                loginFrame.setResizable(true);
                loginFrame.setLocationRelativeTo(null);
                loginFrame.setVisible(true);
            });
        }
    }

    // Método que se llama internamente por IntelliJ para inicializar los componentes del .form
    private void $$$setupUI$$$() {
        // Lógica autogenerada por el diseñador de IntelliJ.
    }
}