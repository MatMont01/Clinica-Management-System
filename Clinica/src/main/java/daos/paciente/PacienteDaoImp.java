package daos.paciente;

import conectar.Conexion;
import dto.Tablas.PacienteDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteDaoImp extends PacienteDao<PacienteDto>{

    ArrayList<PacienteDto> paciente;
    private final static Logger logger = LogManager.getLogger(PacienteDaoImp.class);

    @Override
    public void registrarPaciete(String ci, String aseguradora, boolean esParticular, boolean esAlergico, String numeroDeSeguro) {
        Connection conn = Conexion.getConexion();
        String query =  "insert into paciente (ci, nombreaseguradora,esparticular,esalergico,numeroseguro) values " + "('" + ci + "'" + "," + "'" + aseguradora + "'" + "," + "'" + esParticular+ "'" + "," + "'" + esAlergico + "'" + "," + "'" + numeroDeSeguro + "'" +  " );";
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
    public ArrayList<PacienteDto> getAll() {
        Connection conn = Conexion.getConexion();
        paciente = new ArrayList<>();

        // String query = "SELECT * FROM mascotas";
        String query = " select ci,nombreaseguradora,esparticular,esalergico,numeroseguro from paciente;";
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
                String nombreaseguradora = res.getString("nombreaseguradora");
                boolean esparticular= res.getBoolean("esparticular");
                boolean esalergico = res.getBoolean("esalergico");
                String numeroseguro = res.getString("numeroseguro");


              //  logger.info(ci + " "+nombre + " "+apellidoPaterno + " "+apellidoMaterno, telefono,correo);
                paciente.add(new PacienteDto(ci ,nombreaseguradora,esparticular,esalergico,numeroseguro));

            }

            conn.close();
        } catch (SQLException e) {
            logger.error("Error en el motor SQL", e);

        }

        return paciente;
    }

    @Override
    public void borrarPaciente(String registro) {
        Connection conn = Conexion.getConexion();
        String query = "Delete from paciente where ci = " + "'" + registro + "'";
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
    public void actualizar(String ci, String aseguradora, boolean esParticular, boolean esAlergico, String numeroDeSeguro) {
        Connection conn = Conexion.getConexion();
        String query = "UPDATE paciente set ci = "+ "'"  +ci +"'" + "," + "nombreaseguradora="  +"'"  +aseguradora +"'" + ","
                + "esParticular =" +"'"  +esParticular +"'"+ ","  +"esAlergico = " +"'"+esAlergico +"'"+ "," + "numeroseguro ="+"'" +numeroDeSeguro + "'"
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
