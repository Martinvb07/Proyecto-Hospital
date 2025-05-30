/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Controlador.DoctorDAO;
import Modelo.Medico;
import javax.swing.JOptionPane;



/**
 *
 * @author marti
 */
public class Menu_Admin_Medicos_Registrar extends javax.swing.JInternalFrame {

    /**
     * Creates new form Menu_Doctor_Historia_Clinica_Registrar
     */
    public Menu_Admin_Medicos_Registrar() {
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
        cbEspecialidad.setSelectedIndex(0);
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

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        cbTipoDocumento = new javax.swing.JComboBox<>();
        txtDocumento = new javax.swing.JTextField();
        calendarFecha = new com.toedter.calendar.JDateChooser();
        cbEspecialidad = new javax.swing.JComboBox<>();
        cbTipoSangre = new javax.swing.JComboBox<>();
        txtCelular = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        cbGenero = new javax.swing.JComboBox<>();
        Registrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registro Medicos");
        setPreferredSize(new java.awt.Dimension(668, 526));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Sylfaen", 1, 38)); // NOI18N
        lblTitulo.setText("Registro Médicos");
        jPanel1.add(lblTitulo);
        lblTitulo.setBounds(190, 10, 292, 50);

        txtNombres.setBackground(new java.awt.Color(220, 233, 255));
        txtNombres.setFont(new java.awt.Font("Sylfaen", 1, 17)); // NOI18N
        txtNombres.setText("Nombres");
        jPanel1.add(txtNombres);
        txtNombres.setBounds(40, 70, 190, 30);

        txtApellidos.setBackground(new java.awt.Color(220, 233, 255));
        txtApellidos.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        txtApellidos.setText("Apellidos");
        jPanel1.add(txtApellidos);
        txtApellidos.setBounds(40, 110, 190, 30);

        cbTipoDocumento.setBackground(new java.awt.Color(220, 233, 255));
        cbTipoDocumento.setFont(new java.awt.Font("Sylfaen", 1, 17)); // NOI18N
        cbTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "C.C", "C.E", "T.I", "P.A" }));
        jPanel1.add(cbTipoDocumento);
        cbTipoDocumento.setBounds(40, 150, 140, 40);

        txtDocumento.setBackground(new java.awt.Color(220, 233, 255));
        txtDocumento.setFont(new java.awt.Font("Sylfaen", 1, 17)); // NOI18N
        txtDocumento.setText("No. Documento");
        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });
        jPanel1.add(txtDocumento);
        txtDocumento.setBounds(200, 150, 220, 40);
        jPanel1.add(calendarFecha);
        calendarFecha.setBounds(450, 150, 130, 40);

        cbEspecialidad.setBackground(new java.awt.Color(220, 233, 255));
        cbEspecialidad.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        cbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Especialidad", "Medicina General", "Cardiología", "Neurología", "Ginecología", "Obstetricia", "Pediatría", "Oftalmología", "Odontología" }));
        cbEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspecialidadActionPerformed(evt);
            }
        });
        jPanel1.add(cbEspecialidad);
        cbEspecialidad.setBounds(40, 380, 230, 40);

        cbTipoSangre.setBackground(new java.awt.Color(220, 233, 255));
        cbTipoSangre.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        cbTipoSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo De Sangre", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        jPanel1.add(cbTipoSangre);
        cbTipoSangre.setBounds(200, 200, 190, 40);

        txtCelular.setBackground(new java.awt.Color(220, 233, 255));
        txtCelular.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        txtCelular.setText("Celular");
        jPanel1.add(txtCelular);
        txtCelular.setBounds(40, 260, 190, 40);

        txtEmail.setBackground(new java.awt.Color(220, 233, 255));
        txtEmail.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        txtEmail.setText("Email");
        jPanel1.add(txtEmail);
        txtEmail.setBounds(270, 260, 290, 40);

        txtDireccion.setBackground(new java.awt.Color(220, 233, 255));
        txtDireccion.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        txtDireccion.setText("Dirección");
        jPanel1.add(txtDireccion);
        txtDireccion.setBounds(40, 320, 290, 40);

        txtContrasena.setBackground(new java.awt.Color(220, 233, 255));
        txtContrasena.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        txtContrasena.setText("Contraseña");
        jPanel1.add(txtContrasena);
        txtContrasena.setBounds(350, 320, 290, 40);

        cbGenero.setBackground(new java.awt.Color(220, 233, 255));
        cbGenero.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Genero", "Masculino", "Femenino" }));
        jPanel1.add(cbGenero);
        cbGenero.setBounds(40, 200, 130, 40);

        Registrar.setBackground(new java.awt.Color(173, 220, 255));
        Registrar.setFont(new java.awt.Font("Sylfaen", 1, 28)); // NOI18N
        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(Registrar);
        Registrar.setBounds(250, 450, 160, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void cbEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEspecialidadActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        // TODO add your handling code here:
        Medico medico = new Medico();
        
        medico.setNombres(txtNombres.getText());
        medico.setApellidos(txtApellidos.getText());
        medico.setTipoDocumento(cbTipoDocumento.getSelectedItem().toString());
        medico.setNumeroDocumento(txtDocumento.getText());
        medico.setGenero(cbGenero.getSelectedItem().toString());
        medico.setTipoSangre(cbTipoSangre.getSelectedItem().toString());
        medico.setEmail(txtEmail.getText());
        medico.setCelular(txtCelular.getText());
        medico.setDireccion(txtDireccion.getText());
        medico.setContrasena(txtContrasena.getText());
        medico.setEspecialidad(cbEspecialidad.getSelectedItem().toString());

            if (calendarFecha.getDate() != null) {
                java.sql.Date fecha = new java.sql.Date(calendarFecha.getDate().getTime());
                medico.setFechaNacimiento(fecha);
            }

            if (txtNombres.getText().isEmpty() || txtEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos obligatorios.");
                return;
            }

        DoctorDAO dao = new DoctorDAO();
        boolean exito = dao.registrarMedico(medico);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Médico registrado correctamente.");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar médico.");
            }
    }//GEN-LAST:event_RegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Registrar;
    private com.toedter.calendar.JDateChooser calendarFecha;
    private javax.swing.JComboBox<String> cbEspecialidad;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JComboBox<String> cbTipoDocumento;
    private javax.swing.JComboBox<String> cbTipoSangre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
