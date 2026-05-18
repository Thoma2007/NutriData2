package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // URL de conexión SQL Server
    private static final String URL =
            "jdbc:sqlserver://localhost:1433;"
            + "databaseName=NutriAlertasDB;"
            + "encrypt=true;"
            + "trustServerCertificate=true";

    // Usuario SQL Server
    private static final String USER = "sa";

    // Contraseña SQL Server
    private static final String PASSWORD = "123456";

    // Método de conexión
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

            System.out.println("Error de conexion: "
                    + e.getMessage());
        }

        return con;
    }
}