/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Facultades;

import java.awt.Component;
import java.awt.Container;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

public class DatosFacultades {

    static Connection conn = ConexionBD.getConnection();

    // Limpiar campos
    public static void limpiarCampos(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            } else if (componente instanceof Container) {
                limpiarCampos((Container) componente);
            }
        }
    }

    // Bloquear campos
    public static void bloquearCampos(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setEditable(false);
            } else if (componente instanceof Container) {
                bloquearCampos((Container) componente);
            }
        }
    }

    // Habilitar campos
    public static void habilitarCampos(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setEditable(true);
            } else if (componente instanceof Container) {
                habilitarCampos((Container) componente);
            }
        }
    }

    // Botón editar
    public static void editar(JTable tabla, JTextField[] cajas) {
        int fila = tabla.getSelectedRow();

        if (fila >= 0) {
            for (int i = 0; i < cajas.length; i++) {
                String dato = tabla.getModel().getValueAt(fila, i).toString();
                cajas[i].setText(dato);
            }

            cajas[0].setEditable(false);
            cajas[1].requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para editar.");
        }
    }

    // Insertar datos
    public static void insertarDatos(Facultades facultad, JTable tabla) {
        try {
            if (facultad.getId().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese un Id", "Sistema", JOptionPane.WARNING_MESSAGE);
                return;
            }

            CallableStatement cstmt = conn.prepareCall("{ CALL insertar_facultades(?, ?) }");
            cstmt.setString(1, facultad.getId());
            cstmt.setString(2, facultad.getDescripcion());
            cstmt.execute();
            cstmt.close(); 

            CallableStatement cstmt2 = conn.prepareCall("{ CALL obtener_facultad(?) }");
            cstmt2.setString(1, facultad.getId()); // Usamos el ID de la facultad

            ResultSet rs = cstmt2.executeQuery(); 

            if (rs.next()) {
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

                Object[] rowData = {
                    rs.getString("codigoFacultad"),
                    rs.getString("descripcion")
                };

                modelo.addRow(rowData);
                tabla.setModel(modelo);  
            }

            rs.close();
            cstmt2.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Mostrar datos
    public static void mostrarDatos(DefaultTableModel modelo) {
        try {
            PreparedStatement stmt = conn.prepareStatement("CALL listar_facultades()");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("codigoFacultad"),
                    rs.getString("descripcion")
                };
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Actualizar datos
    public static void actualizarDatos(Facultades facultad, JTable tabla) {
        try {
            // Llamada al procedimiento almacenado para actualizar los datos
            CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_facultades(?, ?) }");
            cstmt.setString(1, facultad.getId());
            cstmt.setString(2, facultad.getDescripcion());
            cstmt.execute(); // Ejecuta la actualización en la base de datos

            // Limpiar y actualizar la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0); // Limpiar la tabla

            // Preparar la consulta para listar las facultades
            PreparedStatement stmt = conn.prepareStatement("CALL listar_facultades()"); // Recargar datos
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Crear una fila con los datos de la facultad
                Object[] row = new Object[]{
                    rs.getString("codigoFacultad"),
                    rs.getString("descripcion")
                };
                modelo.addRow(row); // Agregar la fila a la tabla
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Eliminar datos
    public static void eliminarDatos(JTable tabla) {
        int fila = tabla.getSelectedRow();

        if (fila >= 0) {
            String id = tabla.getModel().getValueAt(fila, 0).toString(); // Se asume que el ID está en la primera columna
            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere eliminar la fila seleccionada?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try ( CallableStatement stmt = conn.prepareCall("{ CALL eliminar_facultades(?) }")) {
                    stmt.setString(1, id); // Se usa setString porque el ID es VARCHAR
                    stmt.execute();

                    // Eliminar la fila de la tabla
                    ((DefaultTableModel) tabla.getModel()).removeRow(fila);
                    JOptionPane.showMessageDialog(null, "La fila ha sido eliminada exitosamente.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para eliminar.");
        }
    }

    // Guardar cambios
    public static void guardarCambios(Facultades facultad, JTable tabla) {
        try {
            PreparedStatement stmt = conn.prepareStatement("CALL listar_facultades()");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                DatosFacultades.actualizarDatos(facultad, tabla);
            } else {
                DatosFacultades.insertarDatos(facultad, tabla);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

