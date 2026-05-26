package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;"
            + "databaseName=NutriAlertasDB;"
            + "encrypt=true;"
            + "trustServerCertificate=true";

    private static final String USER = "sa";

    private static final String PASSWORD = "1234";

    public static Connection conectar() {

        Connection con = null;

        try {

            con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Conexion exitosa con SQL Server");

        } catch (SQLException e) {

            System.out.println("Error de conexion: " + e.getMessage());
        }

        return con;
    }
}