package daos.familiar;

import conectar.Conexion;
import daos.paciente.PacienteDaoImp;
import dto.Tablas.FamiliarDto;
import dto.Tablas.PacienteDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FamiliarDaoImp extends FamiliarDao<FamiliarDto>{

    ArrayList<FamiliarDto> familiar;
    private final static Logger logger = LogManager.getLogger(PacienteDaoImp.class);
    @Override
    public void registrarFamiliar(String ci, String parentesco) {
        Connection conn = Conexion.getConexion();
        String query =  "insert into familiarresponsable (ci, parentesco) values " + "('" + ci + "'" + "," + "'" + parentesco + "'" +   " );";
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

    /*
    @Override
    public ArrayList<FamiliarDto> getAll() {
        Connection conn = Conexion.getConexion();
        familiar = new ArrayList<>();

        // String query = "SELECT * FROM mascotas";
        String query = " select ci,parentesco from familiarresponsable;";
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
                String parentesco= res.getString("parentesco");



                //  logger.info(ci + " "+nombre + " "+apellidoPaterno + " "+apellidoMaterno, telefono,correo);
                familiar.add(new FamiliarDto(ci ,parentesco));

            }

            conn.close();
        } catch (SQLException e) {
            logger.error("Error en el motor SQL", e);

        }

        return familiar;
    }
     */
    @Override
    public ArrayList<FamiliarDto> getAll() {
        Connection conn = Conexion.getConexion();
        familiar = new ArrayList<>();


        String query = " select p.ci as ciPaciente ,concat(p.nombre||' '||p.appaterno||' '||p.apmaterno)as nombrePaciente,p2.ci as cifamiliar, concat(p2.nombre||' '||p2.appaterno||' '||p2.apmaterno) as nombreFamiliarResponsable,f.parentesco  from persona p\n" +
                "join reserva r on r.ci_paciente = p.ci \n" +
                "join ingreso  i on i.id_reserva = r.id\n" +
                "join cirugia c on c.ingreso_id = i.id\n" +
                "join familiarresponsable f on f.ci = c.ci_familiar \n" +
                "join persona p2 on p2.ci  = f.ci;";
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
                String ciPaciente = res.getString("cipaciente");
                String nombrePaciente= res.getString("nombrepaciente");
                String ciFamiliar= res.getString("cifamiliar");
                String nombreFamiliarResponsable= res.getString("nombrefamiliarresponsable");
                String parentesco= res.getString("parentesco");




                //  logger.info(ci + " "+nombre + " "+apellidoPaterno + " "+apellidoMaterno, telefono,correo);
                familiar.add(new FamiliarDto(ciPaciente ,nombrePaciente,ciFamiliar,nombreFamiliarResponsable,parentesco));

            }

            conn.close();
        } catch (SQLException e) {
            logger.error("Error en el motor SQL", e);

        }

        return familiar;
    }

    @Override
    public void borrarFamiliar(String registro) {
        Connection conn = Conexion.getConexion();
        String query = "Delete from familiarresponsable where ci = " + "'" + registro + "'";
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
    public void actualizar(String ci, String parentesco) {
        Connection conn = Conexion.getConexion();
        String query = "UPDATE familiarresponsable set ci = "+ "'"  +ci +"'" + "," + "parentesco="  +"'"  +parentesco +"'"
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
