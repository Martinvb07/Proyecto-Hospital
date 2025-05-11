    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorAcciones;
import Modelo.CitaMedica;
import Modelo.SesionDoctor;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author marti
 */
public class Menu_Doctor_Citas extends javax.swing.JInternalFrame {
     private ControladorAcciones controlador;


    /**
     * Creates new form Menu_Doctor_Diagnosticos
     */
    public Menu_Doctor_Citas() {
        initComponents();
        this.controlador = new ControladorAcciones();
        cargarCitasDoctor();
        agregarEditorFecha();
        agregarEditorHora(); 
       
    }
    
    public DefaultTableModel cargarModeloCitasDoctor(String nombreDoctor) {
    DefaultTableModel modelo = new DefaultTableModel(
        new Object[]{"ID", "Fecha", "Hora", "Especialidad", "Documento Paciente"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
             return column == 1 || column == 2; // Fecha y Hora editables
        }
    };

    List<CitaMedica> citas = controlador.obtenerCitasPorDoctor(nombreDoctor);

    if (citas != null && !citas.isEmpty()) {
        for (CitaMedica cita : citas) {
            modelo.addRow(new Object[]{
                cita.getId(),
                cita.getFecha() != null ? cita.getFecha() : "",
                cita.getHora() != null ? cita.getHora() : "",
                cita.getEspecialidad() != null ? cita.getEspecialidad() : "",
                cita.getDocumentoPaciente() != null ? cita.getDocumentoPaciente() : "",
                
            });
        }
    } else {
        System.out.println("No se encontraron citas para el doctor");
    }

    return modelo;
}
    
    public void cargarCitasDoctor() {
    String nombreDoctor = SesionDoctor.getNombreDoctor() + " " + SesionDoctor.getApellidoDoctor();
    DefaultTableModel modelo = cargarModeloCitasDoctor(nombreDoctor);
    jTableCitas.setModel(modelo);
}
    
    private void agregarEditorFecha() {
        jTableCitas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = jTableCitas.rowAtPoint(e.getPoint());
                int columna = jTableCitas.columnAtPoint(e.getPoint());

                if (columna == 1) { // Columna "Fecha"
                    JDateChooser dateChooser = new JDateChooser();
                    dateChooser.setDateFormatString("dd/MM/yyyy");
                    int result = JOptionPane.showConfirmDialog(null, dateChooser, "Seleccione nueva fecha", JOptionPane.OK_CANCEL_OPTION);

                    if (result == JOptionPane.OK_OPTION) {
                        java.util.Date selectedDate = dateChooser.getDate();
                        if (selectedDate != null) {
                            String nuevaFecha = new java.text.SimpleDateFormat("yyyy-MM-dd").format(selectedDate);
                            int idCita = (int) jTableCitas.getValueAt(fila, 0);
                            jTableCitas.setValueAt(nuevaFecha, fila, 1);

                            controlador.actualizarFechaCita(idCita, nuevaFecha);
                            JOptionPane.showMessageDialog(null, "Fecha actualizada correctamente.");
                        }
                    }
                }
            }
        });
    }

    private void agregarEditorHora() {
        jTableCitas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = jTableCitas.rowAtPoint(e.getPoint());
                int columna = jTableCitas.columnAtPoint(e.getPoint());

                if (columna == 2) { // Columna "Hora"
                    String[] horas = {
                        "08:00", "08:30", "09:00", "09:30",
                        "10:00", "10:30", "11:00", "11:30",
                        "12:00", "14:00", "14:30", "15:00",
                        "15:30", "16:00", "16:30", "17:00"
                    };

                    JComboBox<String> comboHoras = new JComboBox<>(horas);
                    int result = JOptionPane.showConfirmDialog(null, comboHoras, "Seleccione nueva hora", JOptionPane.OK_CANCEL_OPTION);

                    if (result == JOptionPane.OK_OPTION) {
                        String nuevaHora = (String) comboHoras.getSelectedItem();
                        int idCita = (int) jTableCitas.getValueAt(fila, 0);
                        jTableCitas.setValueAt(nuevaHora, fila, 2);

                        controlador.actualizarHoraCita(idCita, nuevaHora);
                        JOptionPane.showMessageDialog(null, "Hora actualizada correctamente.");
                    }
                }
            }
        });
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
        lblCitasAgendadas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCitas = new javax.swing.JTable();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnVisto = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Citas Agendasas");
        setPreferredSize(new java.awt.Dimension(1099, 664));

        FondoPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        FondoPrincipal.setLayout(null);

        lblCitasAgendadas.setBackground(new java.awt.Color(255, 255, 255));
        lblCitasAgendadas.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        lblCitasAgendadas.setText("Lista de Citas Agendadas");
        lblCitasAgendadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCitasAgendadasMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblCitasAgendadas);
        lblCitasAgendadas.setBounds(70, 40, 300, 34);

        jTableCitas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableCitas);

        FondoPrincipal.add(jScrollPane1);
        jScrollPane1.setBounds(70, 120, 960, 360);

        lblBuscar.setBackground(new java.awt.Color(255, 255, 255));
        lblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        lblBuscar.setText("Buscar :");
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblBuscar);
        lblBuscar.setBounds(680, 40, 100, 34);
        FondoPrincipal.add(txtBuscar);
        txtBuscar.setBounds(790, 30, 220, 50);

        btnCancelar.setBackground(new java.awt.Color(173, 220, 255));
        btnCancelar.setFont(new java.awt.Font("Sylfaen", 1, 28)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        FondoPrincipal.add(btnCancelar);
        btnCancelar.setBounds(880, 510, 150, 45);

        btnVisto.setBackground(new java.awt.Color(173, 220, 255));
        btnVisto.setFont(new java.awt.Font("Sylfaen", 1, 28)); // NOI18N
        btnVisto.setText("Visto");
        btnVisto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVistoActionPerformed(evt);
            }
        });
        FondoPrincipal.add(btnVisto);
        btnVisto.setBounds(710, 510, 110, 45);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCitasAgendadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCitasAgendadasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCitasAgendadasMouseClicked

    private void lblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBuscarMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnVistoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVistoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVistoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FondoPrincipal;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnVisto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCitas;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCitasAgendadas;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
