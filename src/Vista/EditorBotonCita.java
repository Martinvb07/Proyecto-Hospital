package Vista;

import Controlador.ControladorAcciones;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class EditorBotonCita extends DefaultCellEditor {
    private JButton button;
    private JTable table;
    private boolean clicked;
    private JDesktopPane escritorio;
    private String documentoPaciente;

    public EditorBotonCita(JDesktopPane escritorio, JTable table, String documentoPaciente) {
        super(new JCheckBox());
        this.escritorio = escritorio;
        this.table = table;
        this.documentoPaciente = documentoPaciente;

        button = new JButton();
        button.setOpaque(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        button.setText((value == null) ? "" : value.toString());
        clicked = true;
        return button;
    }

    @Override
        public Object getCellEditorValue() {
            if (clicked) {
                int row = table.getSelectedRow();
                int idCita = Integer.parseInt(table.getValueAt(row, 5).toString()); // Columna oculta ID

                if ("👤".equals(button.getText())) {
                    // Abrir formulario con detalles
                    Menu_Paciente_Ver_Cita_Agendada ver = new Menu_Paciente_Ver_Cita_Agendada(idCita);
                    escritorio.add(ver).setVisible(true);


                } else if ("❌".equals(button.getText())) {
                    int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar esta cita?", "Confirmar", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        new ControladorAcciones().eliminarCita(idCita);
                        ((DefaultTableModel) table.getModel()).removeRow(row);
                    }
                }
            }
            clicked = false;
            return button.getText();
        }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }
}
