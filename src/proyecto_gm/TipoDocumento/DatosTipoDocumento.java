package proyecto_gm.TipoDocumento;

import java.awt.Component;
import java.awt.Container;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

public class DatosTipoDocumento {

    static Connection conn = ConexionBD.getConnection();

    public static void Limpiar(Container contenedor) {
        Component[] components = contenedor.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(0);
            }
        }
    }

    public static String GenerarCodigo() {
        String codigoGenerado = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL generar_codigo(?, ?, ?, ?) }");) {
            cstmt.setString(1, "tiposdocumentos");
            cstmt.setString(2, "IdTipoDocumento");
            cstmt.setString(3, "TDO");
            cstmt.registerOutParameter(4, Types.VARCHAR);
            cstmt.execute();
            codigoGenerado = cstmt.getString(4);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return codigoGenerado;
    }

    public static void Habilitar(Container contenedor, boolean bloquear) {
        Component[] components = contenedor.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField || component instanceof JComboBox) {
                component.setEnabled(bloquear);
            } else if (component instanceof JButton) {
                String button = ((JButton) component).getName();
                ((JButton) component).setEnabled(button.equals("guardar") || button.equals("deshacer") ? bloquear : !bloquear);
            }
        }
    }

    public static void CargarCombo(JComboBox<String> cboModulo) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_modulos() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                cboModulo.addItem(rs.getString("Descripcion"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Mostrar(DefaultTableModel modelo) {
        try ( PreparedStatement pstmt = conn.prepareStatement("CALL listar_tipodocumento()")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("xCodigo"), rs.getString("xDescripcion"), rs.getString("xModulo")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String Capturar(JComboBox<String> cboModulo) {
        String idModulo = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_id_modulo(?) }")) {
            cstmt.setString(1, cboModulo.getSelectedItem().toString());
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                idModulo = rs.getString("IdModulo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar Opciones", JOptionPane.ERROR_MESSAGE);
        }
        return idModulo;
    }

    public static boolean Insertar(TipoDocumento tip, JTable tabla) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL insertar_tipodocumento(?, ?, ?) }")) {
            cstmt.setString(1, tip.getCodigoTipoDoc());
            cstmt.setString(2, tip.getIdModulo());
            cstmt.setString(3, tip.getDescripcion());
            cstmt.execute();

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Mostrar(modelo);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void Editar(Container contenedor, JTable tabla, JTextField[] camposTexto, JComboBox[] combos) {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            Habilitar(contenedor, true);
            camposTexto[0].setEnabled(false);
            camposTexto[1].requestFocus();
            for (int i = 0; i < camposTexto.length; i++) {
                camposTexto[i].setText(tabla.getValueAt(filaSeleccionada, i).toString());
            }
            String moduloDescripcion = tabla.getValueAt(filaSeleccionada, 2).toString(); // xModulo
            for (int i = 0; i < combos[0].getItemCount(); i++) {
                if (combos[0].getItemAt(i).equals(moduloDescripcion)) {
                    combos[0].setSelectedIndex(i);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para editar.");
        }
    }

    public static void Actualizar(TipoDocumento tip, JTable tabla, JComboBox<String> cboModulo) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_tipodocumento(?, ?, ?) }")) {
            // Capturar el IdModulo del ComboBox seleccionado
            String idModulo = Capturar(cboModulo);

            cstmt.setString(1, tip.getCodigoTipoDoc());
            cstmt.setInt(2, Integer.parseInt(idModulo));
            cstmt.setString(3, tip.getDescripcion());
            cstmt.execute();

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Mostrar(modelo);

            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Eliminar(JTable tabla) {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String codigoTipo = tabla.getModel().getValueAt(fila, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar tipo de empleado?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try ( CallableStatement stmt = conn.prepareCall("{ CALL eliminar_tipodocumento(?) }")) {
                    stmt.setString(1, codigoTipo);
                    stmt.execute();
                    ((DefaultTableModel) tabla.getModel()).removeRow(fila);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un área para eliminar.");
        }
    }

}
