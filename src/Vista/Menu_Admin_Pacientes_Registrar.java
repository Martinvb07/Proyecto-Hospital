/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Controlador.PacienteDAO;
import Modelo.Paciente;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author marti
 */
public class Menu_Admin_Pacientes_Registrar extends javax.swing.JInternalFrame {

    /**
     * Creates new form Menu_Admin_Pacientes_Registrar
     */
    public Menu_Admin_Pacientes_Registrar() {
        initComponents();
    }
    
    private void limpiarCampos() {
        txtNombres.setText("");
        txtApellidos.setText("");
        cbTipoDocumento.setSelectedIndex(0);
        txtDocumento.setText("");
        cbGenero.setSelectedIndex(0);
        cbTipoSangre.setSelectedIndex(0);
        txtCelular.setText("");
        txtEmail.setText("");
        txtDireccion.setText("");
        txtContrasena.setText("");
        cbEnfermedadesCronicas.setSelectedIndex(0);
        calendarFecha.setDate(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FondoPrincipal = new javax.swing.JPanel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        cbTipoDocumento = new javax.swing.JComboBox<>();
        txtDocumento = new javax.swing.JTextField();
        calendarFecha = new com.toedter.calendar.JDateChooser();
        cbGenero = new javax.swing.JComboBox<>();
        cbTipoSangre = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaAlergias = new javax.swing.JTextArea();
        cbEnfermedadesCronicas = new javax.swing.JComboBox<>();
        txtCelular = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtOcupacion = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtEPS = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Paciente");

        FondoPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        FondoPrincipal.setLayout(null);

        txtNombres.setBackground(new java.awt.Color(220, 233, 255));
        txtNombres.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        txtNombres.setText("Nombres");
        FondoPrincipal.add(txtNombres);
        txtNombres.setBounds(40, 70, 345, 40);

        txtApellidos.setBackground(new java.awt.Color(220, 233, 255));
        txtApellidos.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        txtApellidos.setText("Apellidos");
        FondoPrincipal.add(txtApellidos);
        txtApellidos.setBounds(40, 120, 345, 40);

        cbTipoDocumento.setBackground(new java.awt.Color(220, 233, 255));
        cbTipoDocumento.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        cbTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "C.C", "C.E", "T.I", "P.A" }));
        FondoPrincipal.add(cbTipoDocumento);
        cbTipoDocumento.setBounds(40, 170, 130, 40);

        txtDocumento.setBackground(new java.awt.Color(220, 233, 255));
        txtDocumento.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        txtDocumento.setText("No. Documento");
        FondoPrincipal.add(txtDocumento);
        txtDocumento.setBounds(190, 170, 345, 40);
        FondoPrincipal.add(calendarFecha);
        calendarFecha.setBounds(580, 170, 130, 40);

        cbGenero.setBackground(new java.awt.Color(220, 233, 255));
        cbGenero.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Genero", "Masculino", "Femenino" }));
        FondoPrincipal.add(cbGenero);
        cbGenero.setBounds(40, 230, 130, 40);

        cbTipoSangre.setBackground(new java.awt.Color(220, 233, 255));
        cbTipoSangre.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        cbTipoSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo De Sangre", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        FondoPrincipal.add(cbTipoSangre);
        cbTipoSangre.setBounds(190, 230, 190, 40);

        txtAreaAlergias.setBackground(new java.awt.Color(220, 233, 255));
        txtAreaAlergias.setColumns(20);
        txtAreaAlergias.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        txtAreaAlergias.setRows(5);
        txtAreaAlergias.setText("Alergias");
        jScrollPane1.setViewportView(txtAreaAlergias);

        FondoPrincipal.add(jScrollPane1);
        jScrollPane1.setBounds(40, 290, 260, 100);

        cbEnfermedadesCronicas.setBackground(new java.awt.Color(220, 233, 255));
        cbEnfermedadesCronicas.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        cbEnfermedadesCronicas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enfermedades Crónicas", "Cáncer", "Diabetes", "Hipertensión arterial", "Osteoartrsis", "Asma", "Artritis", "Cardiopatía", "Enfermedad Pulmonar", "Ninguna", "Otra" }));
        FondoPrincipal.add(cbEnfermedadesCronicas);
        cbEnfermedadesCronicas.setBounds(340, 290, 260, 40);

        txtCelular.setBackground(new java.awt.Color(220, 233, 255));
        txtCelular.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        txtCelular.setText("Celular");
        FondoPrincipal.add(txtCelular);
        txtCelular.setBounds(40, 420, 190, 40);

        txtEmail.setBackground(new java.awt.Color(220, 233, 255));
        txtEmail.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        txtEmail.setText("Email");
        FondoPrincipal.add(txtEmail);
        txtEmail.setBounds(320, 420, 290, 40);

        txtOcupacion.setBackground(new java.awt.Color(220, 233, 255));
        txtOcupacion.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        txtOcupacion.setText("Ocupación");
        FondoPrincipal.add(txtOcupacion);
        txtOcupacion.setBounds(40, 480, 190, 40);

        txtDireccion.setBackground(new java.awt.Color(220, 233, 255));
        txtDireccion.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        txtDireccion.setText("Dirección");
        FondoPrincipal.add(txtDireccion);
        txtDireccion.setBounds(320, 480, 290, 40);

        txtEPS.setBackground(new java.awt.Color(220, 233, 255));
        txtEPS.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        txtEPS.setText("EPS");
        FondoPrincipal.add(txtEPS);
        txtEPS.setBounds(40, 540, 190, 40);

        txtContrasena.setBackground(new java.awt.Color(220, 233, 255));
        txtContrasena.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        txtContrasena.setText("Contraseña");
        FondoPrincipal.add(txtContrasena);
        txtContrasena.setBounds(320, 540, 290, 40);

        btnRegistrar.setBackground(new java.awt.Color(173, 220, 255));
        btnRegistrar.setFont(new java.awt.Font("Sylfaen", 1, 28)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        FondoPrincipal.add(btnRegistrar);
        btnRegistrar.setBounds(290, 600, 180, 45);

        lblTitulo.setFont(new java.awt.Font("Sylfaen", 1, 38)); // NOI18N
        lblTitulo.setText("Registro Pacientes");
        FondoPrincipal.add(lblTitulo);
        lblTitulo.setBounds(230, 10, 330, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FondoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaNacimiento = sdf.format(calendarFecha.getDate());

        Paciente nuevo = new Paciente(
            txtNombres.getText(),
            txtApellidos.getText(),
            cbTipoDocumento.getSelectedItem().toString(),
            txtDocumento.getText(),
            fechaNacimiento,
            cbGenero.getSelectedItem().toString(),
            cbTipoSangre.getSelectedItem().toString(),
            txtAreaAlergias.getText(),
            cbEnfermedadesCronicas.getSelectedItem().toString(),
            txtCelular.getText(),
            txtEmail.getText(),
            txtOcupacion.getText(),
            txtDireccion.getText(),
            txtEPS.getText(),
            txtContrasena.getText()

        );

        PacienteDAO dao = new PacienteDAO();
        if (dao.registrarPaciente(nuevo)) {
            JOptionPane.showMessageDialog(this, "Registro exitoso");
            limpiarCampos();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FondoPrincipal;
    private javax.swing.JButton btnRegistrar;
    private com.toedter.calendar.JDateChooser calendarFecha;
    private javax.swing.JComboBox<String> cbEnfermedadesCronicas;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JComboBox<String> cbTipoDocumento;
    private javax.swing.JComboBox<String> cbTipoSangre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextArea txtAreaAlergias;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtEPS;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtOcupacion;
    // End of variables declaration//GEN-END:variables
}
