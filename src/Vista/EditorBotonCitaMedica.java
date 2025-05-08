package Vista;
import Controlador.ControladorAcciones;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class EditorBotonCitaMedica extends AbstractCellEditor implements TableCellEditor {

    private JButton button;
    private String icono;
    private boolean clicked;
    private JTable table;

    public EditorBotonCitaMedica(JTable table) {
        this.table = table;
        button = new JButton();
        button.setOpaque(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                int idCita = Integer.parseInt(table.getValueAt(row, 5).toString());  // Columna ID oculta

                // Lógica basada en el texto del botón (icono)
                if ("✅".equals(icono)) {
                    // Acción: marcar como vista
                    ControladorAcciones.marcarCitaComoVista(idCita);
                    ((DefaultTableModel) table.getModel()).removeRow(row); // Eliminar la fila
                } else if ("❌".equals(icono)) {
                    // Acción: marcar como no asistida
                    ControladorAcciones.marcarCitaComoNoAsistida(idCita);
                    ((DefaultTableModel) table.getModel()).removeRow(row); // Eliminar la fila
                } else if ("🗑️".equals(icono)) {
                    // Acción: eliminar cita
                    int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar esta cita?", "Confirmar", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        ControladorAcciones.marcarCitaComoVista(idCita);
                        ((DefaultTableModel) table.getModel()).removeRow(row); // Eliminar la fila
                    }
                }

                fireEditingStopped();  // Detener la edición después de hacer clic
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        icono = value.toString();  // Asignamos el icono desde el valor de la celda
        button.setText(icono);  // Actualizamos el texto del botón con el icono correspondiente
        clicked = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        clicked = false;
        return icono;  // Retorna el valor del icono (o texto) cuando termina la edición
    }
}
