package proyecto_gm.Articulo;

import java.awt.Component;
import java.awt.Container;
import java.awt.HeadlessException;
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
import javax.swing.table.TableModel;
import proyecto_gm.ConexionBD;

/**
 *
 * @author EduardoPC
 */
public class DatosArticulo {

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
            cstmt.setString(1, "articulos");
            cstmt.setString(2, "IdArticulo");
            cstmt.setString(3, "ART");
            cstmt.registerOutParameter(4, Types.VARCHAR);
            cstmt.execute();
            codigoGenerado = cstmt.getString(4);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return codigoGenerado;
    }

    public static void Habilitar(Container contenedor, boolean bloquear) {
        if (contenedor == null) {
            System.out.println("Error: El contenedor recibido es null.");
            return;
        }
        for (Component component : contenedor.getComponents()) {
            if (component instanceof JTextField || component instanceof JComboBox) {
                component.setEnabled(bloquear);
            } else if (component instanceof JButton) {
                String button = ((JButton) component).getName();
                if (button != null) {
                    ((JButton) component).setEnabled(button.equals("guardar") || button.equals("deshacer") ? bloquear : !bloquear);
                } else {
                    System.out.println("Advertencia: Un botón no tiene name asignado.");
                }
            }
        }
    }

    public static void CargarCategoria(JComboBox<String> cmbCategoria) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_categorias() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                cmbCategoria.addItem(rs.getString("Descripcion"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void CargarMarcas(JComboBox<String> cboMarca) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_marcas() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                cboMarca.addItem(rs.getString("Descripcion"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Mostrar(DefaultTableModel modelo) {
        try ( PreparedStatement pstmt = conn.prepareStatement("CALL listar_articulos()")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("xCodigo"),
                    rs.getString("xDescripcionCat"),
                    rs.getString("xDescripcionMar"),
                    rs.getString("xCaracteristicas"),
                    rs.getString("xDescripcion"),
                    rs.getString("xCantidad")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String CapturarCat(JComboBox<String> cmbCategoria) {
        String idCategoria = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_id_categoria(?) }")) {
            cstmt.setString(1, cmbCategoria.getSelectedItem().toString());
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                idCategoria = rs.getString("IdCategoria");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar Categoría", JOptionPane.ERROR_MESSAGE);
        }
        return idCategoria;
    }

    public static String CapturarMarca(JComboBox<String> cboMarca) {
        String idMarca = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_id_marca(?) }")) {
            cstmt.setString(1, cboMarca.getSelectedItem().toString());
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                idMarca = rs.getString("IdMarca");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar Marca", JOptionPane.ERROR_MESSAGE);
        }
        return idMarca;
    }

    public static boolean Insertar(Articulo art, JTable tabla) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL insertar_articulos(?, ?, ?, ?, ?, ?) }")) {
            cstmt.setString(1, art.getcodigoArticulo());
            cstmt.setString(2, art.getIdCategoria());
            cstmt.setString(3, art.getIdMarca());
            cstmt.setString(4, art.getCaracteristicas());
            cstmt.setString(5, art.getDescripcion());
            cstmt.setDouble(6, art.getCantidad());
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

            camposTexto[0].setText(tabla.getValueAt(filaSeleccionada, 0).toString());
            camposTexto[1].setText(tabla.getValueAt(filaSeleccionada, 4).toString());
            camposTexto[2].setText(tabla.getValueAt(filaSeleccionada, 3).toString());
            camposTexto[3].setText(tabla.getValueAt(filaSeleccionada, 5).toString());

            String categoria = tabla.getValueAt(filaSeleccionada, 1).toString();
            String marca = tabla.getValueAt(filaSeleccionada, 2).toString();

            for (int i = 0; i < combos[0].getItemCount(); i++) {
                if (combos[0].getItemAt(i).equals(categoria)) {
                    combos[0].setSelectedIndex(i);  // Seleccionar la categoría correspondiente
                    break;
                }
            }

            for (int i = 0; i < combos[1].getItemCount(); i++) {
                if (combos[1].getItemAt(i).equals(marca)) {
                    combos[1].setSelectedIndex(i);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para editar.");
        }
    }

    public static void Actualizar(Articulo art, JTable tabla, JComboBox<String> cmbCategoria, JComboBox<String> cboMarca) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_articulos(?, ?, ?, ?, ?, ?) }")) {
            String idCategoria = CapturarCat(cmbCategoria);
            String idMarca = CapturarMarca(cboMarca);

            cstmt.setString(1, art.getcodigoArticulo());
            cstmt.setInt(2, Integer.parseInt(idCategoria));
            cstmt.setInt(3, Integer.parseInt(idMarca));
            cstmt.setString(4, art.getCaracteristicas());
            cstmt.setString(5, art.getDescripcion());
            cstmt.setDouble(6, art.getCantidad());
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
            int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar articulo?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try ( CallableStatement stmt = conn.prepareCall("{ CALL eliminar_articulos(?) }")) {
                    stmt.setString(1, codigoTipo);
                    stmt.execute();
                    ((DefaultTableModel) tabla.getModel()).removeRow(fila);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un articulo para eliminar.");
        }
    }
}
