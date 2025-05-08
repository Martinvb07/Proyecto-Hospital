package Vista;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.ImageIcon;

public class RenderizadorBotonCita extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                    boolean hasFocus, int row, int column) {

        JButton boton = new JButton();
        boton.setBorder(null);
        boton.setFocusable(false);

        if ("👤".equals(value)) {
            boton.setIcon(new ImageIcon(getClass().getResource("/Vista/Imagenes/Objetos/VerPaciente.png")));
        } else if ("❌".equals(value)) {
            boton.setIcon(new ImageIcon(getClass().getResource("/Vista/Imagenes/Objetos/BorrarPacientes.png")));
        } else {
            boton.setText(value != null ? value.toString() : "");
        }

        return boton;
    }
}
