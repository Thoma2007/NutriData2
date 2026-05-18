package controlador;

import conexion.ConexionBD;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/*
Esta clase se encarga de guardar
usuarios en la base de datos
*/

public class UsuarioDAO {

    /*
    Metodo para guardar un usuario
    en SQL Server
    */
    public void guardarUsuario(Usuario usuario) {

        Connection con = null;
        PreparedStatement ps = null;

        try {

            //Conectar a la BD
            con = ConexionBD.conectar();

            //Consulta SQL
            String sql = "INSERT INTO usuario "
                    + "(nombre, edad, peso, altura) "
                    + "VALUES (?, ?, ?, ?)";

            //Preparamos el SQL
            ps = con.prepareStatement(sql);

            //Asignamos valores
            ps.setString(1, usuario.getNombre());
            ps.setInt(2, usuario.getEdad());
            ps.setDouble(3, usuario.getPeso());
            ps.setDouble(4, usuario.getAltura());

            //Ejecutamos INSERT
            ps.executeUpdate();

            JOptionPane.showMessageDialog(
        null,
        "Usuario guardado correctamente"
);
        } catch (SQLException e) {

            System.out.println(
                    "Error al guardar usuario: "
                    + e.getMessage()
            );

        } finally {

            try {

                if (ps != null) {
                    ps.close();
                }

                if (con != null) {
                    con.close();
                }

            } catch (SQLException e) {

                System.out.println(
                        "Error cerrando conexion"
                );
            }
        }
    }
}