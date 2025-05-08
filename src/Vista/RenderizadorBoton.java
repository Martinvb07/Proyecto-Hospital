package Vista;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

public class RenderizadorBoton extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0)); // Mejor distribución

        ImageIcon iconoVer = new ImageIcon(getClass().getResource("/Vista/Imagenes/Objetos/VerPaciente.png"));
        ImageIcon iconoEliminar = new ImageIcon(getClass().getResource("/Vista/Imagenes/Objetos/BorrarPacientes.png"));

        JButton btnVer = new JButton(iconoVer);
        JButton btnEliminar = new JButton(iconoEliminar);

        btnVer.setBorder(null);
        btnEliminar.setBorder(null);
        btnVer.setFocusable(false);
        btnEliminar.setFocusable(false);

        panel.add(btnVer);
        panel.add(btnEliminar);

        return panel;
    }
}
