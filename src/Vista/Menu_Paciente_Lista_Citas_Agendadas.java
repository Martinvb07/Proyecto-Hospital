    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorAcciones;
import javax.swing.JDesktopPane;

/**
 *
 * @author marti
 */
public class Menu_Paciente_Lista_Citas_Agendadas extends javax.swing.JInternalFrame {
    
    private JDesktopPane escritorio;
    private ControladorAcciones controlador = new ControladorAcciones();
    private String documentoPaciente;

    

    /**
     * Creates new form Menu_Doctor_Diagnosticos
     */
    public Menu_Paciente_Lista_Citas_Agendadas(JDesktopPane escritorio, String documentoPaciente) {
          initComponents();
          this.escritorio = escritorio;
          this.documentoPaciente = documentoPaciente;
          cargarCitas(documentoPaciente);
    }

    private void cargarCitas(String documentoPaciente) {
    ControladorAcciones controlador = new ControladorAcciones();
    jTableCitas.setModel(controlador.obtenerModeloCitasDelPaciente(documentoPaciente));

    // Ocultar ID
    jTableCitas.getColumnModel().getColumn(5).setMinWidth(0);
    jTableCitas.getColumnModel().getColumn(5).setMaxWidth(0);
    jTableCitas.getColumnModel().getColumn(5).setWidth(0);

    // Botones
    jTableCitas.getColumnModel().getColumn(4).setCellRenderer(new RenderizadorBotonCita());
    jTableCitas.getColumnModel().getColumn(4).setCellEditor(new EditorBotonCita(escritorio, jTableCitas, documentoPaciente));

    jTableCitas.getColumnModel().getColumn(6).setCellRenderer(new RenderizadorBotonCita());
    jTableCitas.getColumnModel().getColumn(6).setCellEditor(new EditorBotonCita(escritorio, jTableCitas, documentoPaciente));

    // Ajustes de estilo
    jTableCitas.getColumnModel().getColumn(0).setPreferredWidth(120);
    jTableCitas.getColumnModel().getColumn(1).setPreferredWidth(100);
    jTableCitas.getColumnModel().getColumn(2).setPreferredWidth(150);
    jTableCitas.getColumnModel().getColumn(3).setPreferredWidth(150);
    jTableCitas.getColumnModel().getColumn(4).setPreferredWidth(50);
    jTableCitas.getColumnModel().getColumn(6).setPreferredWidth(50);
    jTableCitas.setRowHeight(40);
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
        lblListaDeCitasAgendadas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCitas = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Citas Medicas");
        setPreferredSize(new java.awt.Dimension(1099, 664));

        FondoPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        FondoPrincipal.setLayout(null);

        lblListaDeCitasAgendadas.setBackground(new java.awt.Color(255, 255, 255));
        lblListaDeCitasAgendadas.setFont(new java.awt.Font("Sylfaen", 1, 40)); // NOI18N
        lblListaDeCitasAgendadas.setText("Lista de Citas Agendadas");
        lblListaDeCitasAgendadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblListaDeCitasAgendadasMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblListaDeCitasAgendadas);
        lblListaDeCitasAgendadas.setBounds(70, 30, 470, 54);

        jTableCitas.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
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
        jScrollPane1.setBounds(70, 90, 960, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblListaDeCitasAgendadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblListaDeCitasAgendadasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblListaDeCitasAgendadasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FondoPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCitas;
    private javax.swing.JLabel lblListaDeCitasAgendadas;
    // End of variables declaration//GEN-END:variables
}
