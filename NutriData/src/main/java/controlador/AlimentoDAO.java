package controlador;

import conexion.ConexionBD;
import modelo.Alimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
Esta clase se encarga de guardar
los alimentos en SQL Server
*/

public class AlimentoDAO {

    /*
    Metodo para guardar un alimento
    solo si no existe
    */
    public void guardarAlimento(
            Alimento alimento
    ) {

        Connection con = null;
        PreparedStatement psBuscar = null;
        PreparedStatement psInsertar = null;
        ResultSet rs = null;

        try {

            con = ConexionBD.conectar();

            //Buscar si ya existe
            String sqlBuscar =
                    "SELECT * FROM alimento "
                    + "WHERE nombre = ?";

            psBuscar =
                    con.prepareStatement(
                            sqlBuscar
                    );

            psBuscar.setString(
                    1,
                    alimento.getNombre()
            );

            rs =
                    psBuscar.executeQuery();

            //Si NO existe, insertar
            if (!rs.next()) {

                String sqlInsertar =
                        "INSERT INTO alimento "
                        + "(nombre, azucar, grasa, calorias) "
                        + "VALUES (?, ?, ?, ?)";

                psInsertar =
                        con.prepareStatement(
                                sqlInsertar
                        );

                psInsertar.setString(
                        1,
                        alimento.getNombre()
                );

                psInsertar.setDouble(
                        2,
                        alimento.getAzucar()
                );

                psInsertar.setDouble(
                        3,
                        alimento.getGrasa()
                );

                psInsertar.setDouble(
                        4,
                        alimento.getCalorias()
                );

                psInsertar.executeUpdate();

                System.out.println(
                        alimento.getNombre()
                        + " guardado"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error guardando alimento: "
                    + e.getMessage()
            );

        } finally {

            try {

                if (rs != null) rs.close();

                if (psBuscar != null)
                    psBuscar.close();

                if (psInsertar != null)
                    psInsertar.close();

                if (con != null)
                    con.close();

            } catch (SQLException e) {

                System.out.println(
                        "Error cerrando conexion"
                );
            }
        }
    }
}