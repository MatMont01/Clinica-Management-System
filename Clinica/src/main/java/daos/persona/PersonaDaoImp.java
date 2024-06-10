package daos.persona;

import conectar.Conexion;
import dto.Tablas.PersonaDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonaDaoImp extends PersonaDao<PersonaDto> {

    ArrayList<PersonaDto> persona;
    private final static Logger logger = LogManager.getLogger(PersonaDaoImp.class);

    @Override
    public void registrarPersona(String ci, String nombre, String apellidoPaterno, String apellidoAAMaterno, String telefono, String correo) {
        Connection conn = Conexion.getConexion();
        String query = "insert into persona (ci, nombre,appaterno,apmaterno,telefono,correo) values " + "('" + ci + "'" + "," + "'" + nombre + "'" + "," + "'" + apellidoPaterno + "'" + "," + "'" + apellidoAAMaterno + "'" + "," + "'" + telefono + "'" + "," + "'" + correo + "'" + " );";
        //insert into persona (ci, nombre,appaterno,apmaterno,telefono,correo) values (andres,'carlsen','andis',77098232,'andres@hotmail.com' );
        ResultSet res = null;
        System.out.println(query);

        try {
            java.sql.Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.close();
        } catch (SQLException e) {

            System.exit(0);
        }
    }

    @Override
    public ArrayList<PersonaDto> getAll() {
        Connection conn = Conexion.getConexion();
        persona = new ArrayList<>();

        // String query = "SELECT * FROM mascotas";
        String query = " select ci,nombre,appaterno,apmaterno,telefono,correo from persona;";
        ResultSet res = null;
        try {
            java.sql.Statement stmt = conn.createStatement();
            res = stmt.executeQuery(query);
        } catch (SQLException e) {
            logger.error("No puede ejecutar la consulta SQL", e);
            System.exit(0);
        }
        try {
            while (res.next()) {
                String ci = res.getString("ci");
                String nombre = res.getString("nombre");
                String apellidoPaterno = res.getString("appaterno");
                String apellidoMaterno = res.getString("apmaterno");
                String telefono = res.getString("telefono");
                String correo = res.getString("correo");

                logger.info(ci + " "+nombre + " "+apellidoPaterno + " "+apellidoMaterno, telefono,correo);
                persona.add(new PersonaDto(ci, nombre, apellidoPaterno, apellidoMaterno, telefono, correo));

            }

            conn.close();
        } catch (SQLException e) {
            logger.error("Error en el motor SQL", e);

        }

        return persona;
    }

    @Override
    public void borrarPersona(String registro) {
        Connection conn = Conexion.getConexion();
        String query = "Delete from persona where ci = " + "'" + registro + "'";
        System.out.println(query);

        logger.info(query);

        try {
            java.sql.Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.close();
        } catch (SQLException e) {
            logger.error("No puede ejecutar la consulta SQL", e);
            System.exit(0);
        }
    }

    @Override
    public void actualizar(String ci,String Nombre,String apellidoPaterno,String apellidoAAMaterno,String telefono,String correo) {
        Connection conn = Conexion.getConexion();
        String query = "UPDATE persona set nombre = "+ "'"  +Nombre +"'" + "," + "appaterno ="  +"'"  +apellidoPaterno +"'" + ","
                        + "apmaterno =" +"'"  +apellidoAAMaterno +"'"+ ","  +"telefono = " +"'"+telefono +"'"+ "," + "correo ="+"'" +correo + "'"
                +"where ci=" + "'"+ ci + "';";

        System.out.println(query);

        logger.info(query);

        try {
            java.sql.Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.close();
        } catch (SQLException e) {
            logger.error("No puede ejecutar la consulta SQL", e);
            System.exit(0);
        }
    }


}
