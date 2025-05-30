/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorAcciones;
import Modelo.Paciente;
import javax.swing.JDesktopPane;









/**
 *
 * @author marti
 */
public class Menu_Paciente_Historia_Clinica extends javax.swing.JInternalFrame {
    
    private ControladorAcciones controlador = new ControladorAcciones();
    private String documentoPaciente;
    

    /**
     * Creates new form Menu_Doctor_TotalPacientes
     */
    public Menu_Paciente_Historia_Clinica(JDesktopPane escritorio, String documentoPaciente) {
        initComponents();
        this.documentoPaciente = documentoPaciente;
        CargarModeloHistoriaDelPaciente(documentoPaciente);
        cargarDatosPaciente(documentoPaciente);
        
        
    }

    private void cargarDatosPaciente(String documento) {
    
    ControladorAcciones controlador = new ControladorAcciones();
    Paciente p = controlador.obtenerPacientePorDocumento(documento);

     if (p != null) {
            // Asigna los datos del paciente a las etiquetas
            lblTituloMayorNombre.setText(p.getNombres());
            lblNombre.setText(p.getNombres() + " " + p.getApellidos());
            lblFechaNacimiento.setText(p.getFechaNacimiento());
            lblTipoSangre.setText(p.getTipoSangre());
            lblAlergias.setText(p.getAlergias());
            lblEnfermedadesCronicas.setText(p.getEnfermedadesCronicas());
        } else {
            System.out.println("No se encontró el paciente con documento: " + documento);
        }

    }

    private void CargarModeloHistoriaDelPaciente(String documentoPaciente) {
    ControladorAcciones controlador = new ControladorAcciones();
    tablaConsultas.setModel(controlador.CargarModeloHistoriaDelPaciente(documentoPaciente));

    // Asegúrate de que hay al menos 6 columnas antes de ocultar la columna 5
    if (tablaConsultas.getColumnCount() > 5) {
        tablaConsultas.getColumnModel().getColumn(5).setMinWidth(0);
        tablaConsultas.getColumnModel().getColumn(5).setMaxWidth(0);
        tablaConsultas.getColumnModel().getColumn(5).setWidth(0);
    }

    // Ajustes de estilo (solo si existen las columnas)
    int totalColumnas = tablaConsultas.getColumnCount();

    if (totalColumnas > 0) tablaConsultas.getColumnModel().getColumn(0).setPreferredWidth(120);
    if (totalColumnas > 1) tablaConsultas.getColumnModel().getColumn(1).setPreferredWidth(100);
    if (totalColumnas > 2) tablaConsultas.getColumnModel().getColumn(2).setPreferredWidth(150);
    if (totalColumnas > 3) tablaConsultas.getColumnModel().getColumn(3).setPreferredWidth(150);
    if (totalColumnas > 4) tablaConsultas.getColumnModel().getColumn(4).setPreferredWidth(50);
    if (totalColumnas > 6) tablaConsultas.getColumnModel().getColumn(6).setPreferredWidth(50);

    tablaConsultas.setRowHeight(40);
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
        lblHistoriaClinica = new javax.swing.JLabel();
        lblTituloInformacionBasica = new javax.swing.JLabel();
        lblTituloNombre = new javax.swing.JLabel();
        lblTituloMayorNombre = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTituloFechaNacimiento = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblTituloTipoSangre = new javax.swing.JLabel();
        lblTipoSangre = new javax.swing.JLabel();
        lblAlergias = new javax.swing.JLabel();
        lblTituloAlergias = new javax.swing.JLabel();
        lblTituloEnfermedadesCronicas = new javax.swing.JLabel();
        lblEnfermedadesCronicas = new javax.swing.JLabel();
        lblTituloConsultasMedicasRecientes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsultas = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Historia Clinica");
        setPreferredSize(new java.awt.Dimension(1099, 664));

        FondoPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        FondoPrincipal.setLayout(null);

        lblHistoriaClinica.setBackground(new java.awt.Color(255, 255, 255));
        lblHistoriaClinica.setFont(new java.awt.Font("Sylfaen", 1, 40)); // NOI18N
        lblHistoriaClinica.setText("Historia Clínica de");
        lblHistoriaClinica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHistoriaClinicaMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblHistoriaClinica);
        lblHistoriaClinica.setBounds(300, 20, 360, 50);

        lblTituloInformacionBasica.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloInformacionBasica.setFont(new java.awt.Font("Sylfaen", 1, 35)); // NOI18N
        lblTituloInformacionBasica.setText("Información Básica");
        lblTituloInformacionBasica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTituloInformacionBasicaMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblTituloInformacionBasica);
        lblTituloInformacionBasica.setBounds(40, 80, 310, 50);

        lblTituloNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloNombre.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        lblTituloNombre.setText("Nombre:");
        lblTituloNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTituloNombreMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblTituloNombre);
        lblTituloNombre.setBounds(40, 130, 100, 34);

        lblTituloMayorNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloMayorNombre.setFont(new java.awt.Font("Sylfaen", 1, 40)); // NOI18N
        lblTituloMayorNombre.setText("Nombre");
        lblTituloMayorNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTituloMayorNombreMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblTituloMayorNombre);
        lblTituloMayorNombre.setBounds(650, 20, 150, 50);

        lblNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre.setFont(new java.awt.Font("Sylfaen", 0, 22)); // NOI18N
        lblNombre.setText("XX");
        lblNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNombreMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblNombre);
        lblNombre.setBounds(150, 130, 890, 34);

        lblTituloFechaNacimiento.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloFechaNacimiento.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        lblTituloFechaNacimiento.setText("Fecha de Nacimiento:");
        lblTituloFechaNacimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTituloFechaNacimientoMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblTituloFechaNacimiento);
        lblTituloFechaNacimiento.setBounds(40, 170, 240, 34);

        lblFechaNacimiento.setBackground(new java.awt.Color(255, 255, 255));
        lblFechaNacimiento.setFont(new java.awt.Font("Sylfaen", 0, 25)); // NOI18N
        lblFechaNacimiento.setText("XX");
        lblFechaNacimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFechaNacimientoMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblFechaNacimiento);
        lblFechaNacimiento.setBounds(290, 170, 390, 34);

        lblTituloTipoSangre.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloTipoSangre.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        lblTituloTipoSangre.setText("Tipo de Sangre:");
        lblTituloTipoSangre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTituloTipoSangreMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblTituloTipoSangre);
        lblTituloTipoSangre.setBounds(40, 210, 180, 34);

        lblTipoSangre.setBackground(new java.awt.Color(255, 255, 255));
        lblTipoSangre.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblTipoSangre.setText("XX");
        lblTipoSangre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTipoSangreMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblTipoSangre);
        lblTipoSangre.setBounds(220, 200, 320, 34);

        lblAlergias.setBackground(new java.awt.Color(255, 255, 255));
        lblAlergias.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblAlergias.setText("XX");
        lblAlergias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAlergiasMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblAlergias);
        lblAlergias.setBounds(150, 240, 350, 34);

        lblTituloAlergias.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloAlergias.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        lblTituloAlergias.setText("Alergías:");
        lblTituloAlergias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTituloAlergiasMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblTituloAlergias);
        lblTituloAlergias.setBounds(40, 250, 100, 30);

        lblTituloEnfermedadesCronicas.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloEnfermedadesCronicas.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        lblTituloEnfermedadesCronicas.setText("Enfermedades Crónicas:");
        lblTituloEnfermedadesCronicas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTituloEnfermedadesCronicasMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblTituloEnfermedadesCronicas);
        lblTituloEnfermedadesCronicas.setBounds(40, 290, 270, 34);

        lblEnfermedadesCronicas.setBackground(new java.awt.Color(255, 255, 255));
        lblEnfermedadesCronicas.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblEnfermedadesCronicas.setText("XX");
        lblEnfermedadesCronicas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEnfermedadesCronicasMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblEnfermedadesCronicas);
        lblEnfermedadesCronicas.setBounds(320, 274, 480, 50);

        lblTituloConsultasMedicasRecientes.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloConsultasMedicasRecientes.setFont(new java.awt.Font("Sylfaen", 1, 35)); // NOI18N
        lblTituloConsultasMedicasRecientes.setText("Consultas Médicas Recientes");
        lblTituloConsultasMedicasRecientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTituloConsultasMedicasRecientesMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblTituloConsultasMedicasRecientes);
        lblTituloConsultasMedicasRecientes.setBounds(40, 360, 490, 50);

        tablaConsultas.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        tablaConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaConsultas);

        FondoPrincipal.add(jScrollPane1);
        jScrollPane1.setBounds(40, 410, 1000, 200);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblHistoriaClinicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHistoriaClinicaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblHistoriaClinicaMouseClicked

    private void lblTituloInformacionBasicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTituloInformacionBasicaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTituloInformacionBasicaMouseClicked

    private void lblTituloNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTituloNombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTituloNombreMouseClicked

    private void lblTituloMayorNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTituloMayorNombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTituloMayorNombreMouseClicked

    private void lblNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblNombreMouseClicked

    private void lblTituloFechaNacimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTituloFechaNacimientoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTituloFechaNacimientoMouseClicked

    private void lblFechaNacimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFechaNacimientoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblFechaNacimientoMouseClicked

    private void lblTituloTipoSangreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTituloTipoSangreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTituloTipoSangreMouseClicked

    private void lblTipoSangreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTipoSangreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTipoSangreMouseClicked

    private void lblAlergiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAlergiasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblAlergiasMouseClicked

    private void lblTituloAlergiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTituloAlergiasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTituloAlergiasMouseClicked

    private void lblTituloEnfermedadesCronicasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTituloEnfermedadesCronicasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTituloEnfermedadesCronicasMouseClicked

    private void lblEnfermedadesCronicasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEnfermedadesCronicasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblEnfermedadesCronicasMouseClicked

    private void lblTituloConsultasMedicasRecientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTituloConsultasMedicasRecientesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTituloConsultasMedicasRecientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FondoPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlergias;
    private javax.swing.JLabel lblEnfermedadesCronicas;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblHistoriaClinica;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTipoSangre;
    private javax.swing.JLabel lblTituloAlergias;
    private javax.swing.JLabel lblTituloConsultasMedicasRecientes;
    private javax.swing.JLabel lblTituloEnfermedadesCronicas;
    private javax.swing.JLabel lblTituloFechaNacimiento;
    private javax.swing.JLabel lblTituloInformacionBasica;
    private javax.swing.JLabel lblTituloMayorNombre;
    private javax.swing.JLabel lblTituloNombre;
    private javax.swing.JLabel lblTituloTipoSangre;
    private javax.swing.JTable tablaConsultas;
    // End of variables declaration//GEN-END:variables
}
