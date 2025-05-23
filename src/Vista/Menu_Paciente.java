/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Sesion;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;



/**
 *
 * @author marti
 */
public class Menu_Paciente extends javax.swing.JFrame {

    /**
     * Creates new form Menu_Doctor
     */
    public Menu_Paciente() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        FondoHorizontal = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        FondoVertical = new javax.swing.JPanel();
        lblDashboard = new javax.swing.JLabel();
        lblCitasMedicas = new javax.swing.JLabel();
        lblHistoriaClinica = new javax.swing.JLabel();
        lblPlanDeTratamiento = new javax.swing.JLabel();
        lblConfiguracion = new javax.swing.JLabel();
        FondoPrincipal = new javax.swing.JPanel();
        TratamientoEnCursoPanel = new javax.swing.JPanel();
        lblVer2 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        ProximaCitaPanel = new javax.swing.JPanel();
        lblVer1 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        lblTituloNombre = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(255, 255, 255));

        FondoHorizontal.setBackground(new java.awt.Color(220, 233, 255));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Logos/Logo_Descripcion.png"))); // NOI18N
        imgLogo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout FondoHorizontalLayout = new javax.swing.GroupLayout(FondoHorizontal);
        FondoHorizontal.setLayout(FondoHorizontalLayout);
        FondoHorizontalLayout.setHorizontalGroup(
            FondoHorizontalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoHorizontalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1006, Short.MAX_VALUE))
        );
        FondoHorizontalLayout.setVerticalGroup(
            FondoHorizontalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoHorizontalLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        escritorio.add(FondoHorizontal);
        FondoHorizontal.setBounds(0, 0, 1327, 140);

        FondoVertical.setBackground(new java.awt.Color(220, 233, 255));

        lblDashboard.setBackground(new java.awt.Color(255, 255, 255));
        lblDashboard.setFont(new java.awt.Font("Sylfaen", 1, 30)); // NOI18N
        lblDashboard.setText("Dashboard");
        lblDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDashboardMouseClicked(evt);
            }
        });

        lblCitasMedicas.setBackground(new java.awt.Color(255, 255, 255));
        lblCitasMedicas.setFont(new java.awt.Font("Sylfaen", 1, 30)); // NOI18N
        lblCitasMedicas.setText("Citas Médicas");
        lblCitasMedicas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCitasMedicasMouseClicked(evt);
            }
        });

        lblHistoriaClinica.setBackground(new java.awt.Color(255, 255, 255));
        lblHistoriaClinica.setFont(new java.awt.Font("Sylfaen", 1, 30)); // NOI18N
        lblHistoriaClinica.setText("<html>Historia <p>Clinica</html>");
        lblHistoriaClinica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHistoriaClinicaMouseClicked(evt);
            }
        });

        lblPlanDeTratamiento.setBackground(new java.awt.Color(255, 255, 255));
        lblPlanDeTratamiento.setFont(new java.awt.Font("Sylfaen", 1, 30)); // NOI18N
        lblPlanDeTratamiento.setText("<html>Plan de <p>Tratamiento</html>\n");
        lblPlanDeTratamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPlanDeTratamientoMouseClicked(evt);
            }
        });

        lblConfiguracion.setBackground(new java.awt.Color(255, 255, 255));
        lblConfiguracion.setFont(new java.awt.Font("Sylfaen", 1, 30)); // NOI18N
        lblConfiguracion.setText("Configuración");
        lblConfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConfiguracionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout FondoVerticalLayout = new javax.swing.GroupLayout(FondoVertical);
        FondoVertical.setLayout(FondoVerticalLayout);
        FondoVerticalLayout.setHorizontalGroup(
            FondoVerticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoVerticalLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(FondoVerticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDashboard)
                    .addComponent(lblCitasMedicas)
                    .addComponent(lblHistoriaClinica, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlanDeTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConfiguracion))
                .addContainerGap())
        );
        FondoVerticalLayout.setVerticalGroup(
            FondoVerticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoVerticalLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lblDashboard)
                .addGap(39, 39, 39)
                .addComponent(lblCitasMedicas)
                .addGap(27, 27, 27)
                .addComponent(lblHistoriaClinica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(lblPlanDeTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(lblConfiguracion)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        escritorio.add(FondoVertical);
        FondoVertical.setBounds(0, 140, 220, 570);

        FondoPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        FondoPrincipal.setLayout(null);

        TratamientoEnCursoPanel.setBackground(new java.awt.Color(173, 220, 255));
        TratamientoEnCursoPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TratamientoEnCursoPanelMouseClicked(evt);
            }
        });

        lblVer2.setBackground(new java.awt.Color(255, 255, 255));
        lblVer2.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        lblVer2.setText("Ver");
        lblVer2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVer2MouseClicked(evt);
            }
        });

        lbl2.setBackground(new java.awt.Color(255, 255, 255));
        lbl2.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        lbl2.setText("<html><center>Tratamiento <p>en Curso</html>");
        lbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TratamientoEnCursoPanelLayout = new javax.swing.GroupLayout(TratamientoEnCursoPanel);
        TratamientoEnCursoPanel.setLayout(TratamientoEnCursoPanelLayout);
        TratamientoEnCursoPanelLayout.setHorizontalGroup(
            TratamientoEnCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TratamientoEnCursoPanelLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(TratamientoEnCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TratamientoEnCursoPanelLayout.createSequentialGroup()
                        .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TratamientoEnCursoPanelLayout.createSequentialGroup()
                        .addComponent(lblVer2)
                        .addGap(100, 100, 100))))
        );
        TratamientoEnCursoPanelLayout.setVerticalGroup(
            TratamientoEnCursoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TratamientoEnCursoPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(lblVer2)
                .addGap(27, 27, 27))
        );

        FondoPrincipal.add(TratamientoEnCursoPanel);
        TratamientoEnCursoPanel.setBounds(570, 140, 250, 221);

        ProximaCitaPanel.setBackground(new java.awt.Color(173, 220, 255));
        ProximaCitaPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProximaCitaPanelMouseClicked(evt);
            }
        });

        lblVer1.setBackground(new java.awt.Color(255, 255, 255));
        lblVer1.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        lblVer1.setText("Ver");
        lblVer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVer1MouseClicked(evt);
            }
        });

        lbl1.setBackground(new java.awt.Color(255, 255, 255));
        lbl1.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        lbl1.setText("Próxima Cita");
        lbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ProximaCitaPanelLayout = new javax.swing.GroupLayout(ProximaCitaPanel);
        ProximaCitaPanel.setLayout(ProximaCitaPanelLayout);
        ProximaCitaPanelLayout.setHorizontalGroup(
            ProximaCitaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProximaCitaPanelLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(lblVer1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProximaCitaPanelLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(lbl1)
                .addGap(17, 17, 17))
        );
        ProximaCitaPanelLayout.setVerticalGroup(
            ProximaCitaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProximaCitaPanelLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(lblVer1)
                .addGap(27, 27, 27))
        );

        FondoPrincipal.add(ProximaCitaPanel);
        ProximaCitaPanel.setBounds(130, 140, 249, 221);

        lblTitulo2.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo2.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        lblTitulo2.setText(", aquí está tu información médica.");
        lblTitulo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTitulo2MouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblTitulo2);
        lblTitulo2.setBounds(290, 50, 590, 50);

        lblTituloNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloNombre.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        lblTituloNombre.setForeground(new java.awt.Color(102, 153, 255));
        lblTituloNombre.setText("Nombre");
        lblTituloNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTituloNombreMouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblTituloNombre);
        lblTituloNombre.setBounds(150, 50, 140, 50);

        lblTitulo1.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        lblTitulo1.setText("Hola,");
        lblTitulo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTitulo1MouseClicked(evt);
            }
        });
        FondoPrincipal.add(lblTitulo1);
        lblTitulo1.setBounds(50, 50, 110, 50);

        escritorio.add(FondoPrincipal);
        FondoPrincipal.setBounds(220, 140, 1110, 570);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1327, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashboardMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null ,"Ya estas en el menu");
        
    }//GEN-LAST:event_lblDashboardMouseClicked

    private void lblCitasMedicasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCitasMedicasMouseClicked
        // TODO add your handling code here:
        Menu_Paciente_Agendar_Cita_Medica verventana=new Menu_Paciente_Agendar_Cita_Medica();
        escritorio.add(verventana);
        verventana.show();
    }//GEN-LAST:event_lblCitasMedicasMouseClicked

    private void lblHistoriaClinicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHistoriaClinicaMouseClicked
        // TODO add your handling code here:
        Menu_Paciente_Historia_Clinica verventana=new Menu_Paciente_Historia_Clinica(escritorio, Sesion.getPaciente().getDocumento());
        escritorio.add(verventana);
        verventana.show();
        
        
    }//GEN-LAST:event_lblHistoriaClinicaMouseClicked

    private void lblPlanDeTratamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPlanDeTratamientoMouseClicked
         //TODO add your handling code here:
        Menu_Paciente_Plan_de_Tratamiento ventana = new Menu_Paciente_Plan_de_Tratamiento(escritorio, Sesion.getPaciente().getDocumento());
        escritorio.add(ventana);
        ventana.setVisible(true);
       
    }//GEN-LAST:event_lblPlanDeTratamientoMouseClicked

    private void lblConfiguracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConfiguracionMouseClicked
        // TODO add your handling code here:
        Menu_Paciente_Configuracion ventana = new Menu_Paciente_Configuracion(escritorio, Sesion.getPaciente().getDocumento());
        escritorio.add(ventana);
        ventana.setVisible(true);
       
    }//GEN-LAST:event_lblConfiguracionMouseClicked

    private void lblVer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVer1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lblVer1MouseClicked

    private void lblVer2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVer2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblVer2MouseClicked

    private void lbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl1MouseClicked

    private void lbl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl2MouseClicked

    private void ProximaCitaPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProximaCitaPanelMouseClicked
        // TODO add your handling code here:
        Menu_Paciente_Lista_Citas_Agendadas ventana = new Menu_Paciente_Lista_Citas_Agendadas(escritorio, Sesion.getPaciente().getDocumento());
        escritorio.add(ventana);
        ventana.setVisible(true);


       
    }//GEN-LAST:event_ProximaCitaPanelMouseClicked

    private void TratamientoEnCursoPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TratamientoEnCursoPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TratamientoEnCursoPanelMouseClicked

    private void lblTitulo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTitulo2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTitulo2MouseClicked

    private void lblTituloNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTituloNombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTituloNombreMouseClicked

    private void lblTitulo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTitulo1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTitulo1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Paciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FondoHorizontal;
    private javax.swing.JPanel FondoPrincipal;
    private javax.swing.JPanel FondoVertical;
    private javax.swing.JPanel ProximaCitaPanel;
    private javax.swing.JPanel TratamientoEnCursoPanel;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblCitasMedicas;
    private javax.swing.JLabel lblConfiguracion;
    private javax.swing.JLabel lblDashboard;
    private javax.swing.JLabel lblHistoriaClinica;
    private javax.swing.JLabel lblPlanDeTratamiento;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTituloNombre;
    private javax.swing.JLabel lblVer1;
    private javax.swing.JLabel lblVer2;
    // End of variables declaration//GEN-END:variables
}
