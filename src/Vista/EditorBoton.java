package Vista;

import Controlador.ControladorAcciones;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class EditorBoton extends AbstractCellEditor implements TableCellEditor {
    private JPanel panel;
    private JButton btnVer, btnEliminar;
    private JTable tabla;
    private JDesktopPane escritorio;

    public EditorBoton(JDesktopPane escritorio, JTable tabla) {
        this.escritorio = escritorio;
        this.tabla = tabla;

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));

        btnVer = new JButton(new ImageIcon(getClass().getResource("/Vista/Imagenes/Objetos/VerPaciente.png")));
        btnEliminar = new JButton(new ImageIcon(getClass().getResource("/Vista/Imagenes/Objetos/BorrarPacientes.png")));

        btnVer.setBorder(null);
        btnEliminar.setBorder(null);
        btnVer.setFocusable(false);
        btnEliminar.setFocusable(false);

        panel.add(btnVer);
        panel.add(btnEliminar);

        // Acción para VER PACIENTE
        btnVer.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                String documento = tabla.getValueAt(fila, 1).toString(); // Columna Documento
                Menu_Doctor_VerPacientes detalles = new Menu_Doctor_VerPacientes();
                detalles.cargarDatosPaciente(documento);
                escritorio.add(detalles);
                detalles.setVisible(true);
            }
        });

        // Acción para ELIMINAR PACIENTE
        
        
        btnEliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                String documento = tabla.getValueAt(fila, 1).toString();

                int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este paciente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                ControladorAcciones controlador = new ControladorAcciones();
                boolean eliminado = controlador.eliminarPaciente(documento);

            if (eliminado) {
                tabla.setModel(controlador.obtenerPacientes());

                tabla.getColumnModel().getColumn(4).setCellRenderer(new RenderizadorBoton());
                tabla.getColumnModel().getColumn(4).setCellEditor(new EditorBoton(escritorio, tabla));

                JOptionPane.showMessageDialog(null, "Paciente eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el paciente.");
            }
        }
    }
});

    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }
}
