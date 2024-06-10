package conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConexion() {
        String host = "localhost";
        String database = "clinica2";
        int port = 5432;
        String username = "postgres";

        String password = "root"; // colocar la contrase�a
        String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
        String urlcredentials = url + "?user=" + username + "&password=" + password;

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(urlcredentials);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos : " + e.getMessage());
            System.exit(0);
        }
        return conn;
    }

}
