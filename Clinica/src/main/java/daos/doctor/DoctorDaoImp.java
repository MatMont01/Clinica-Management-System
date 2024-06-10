package daos.doctor;

import conectar.Conexion;
import daos.paciente.PacienteDaoImp;
import dto.Tablas.DoctorDto;
import dto.Tablas.PacienteDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorDaoImp extends DoctorDao<DoctorDto> {
    ArrayList<DoctorDto> doctor;
    private final static Logger logger = LogManager.getLogger(DoctorDaoImp.class);

    @Override
    public void registrarDoctor(String ci, String matricula, int tarifaConsulta, String especialidad) {
        Connection conn = Conexion.getConexion();
        String query = "insert into doctor (ci, matricula,tarifaConsulta) values " + "('" + ci + "'" + "," + "'" + matricula + "'" + "," + tarifaConsulta + " );";
        String query2 = "insert into especialidaddoctor (id_especialidad,ci_doctor) values " + "(" + Integer.parseInt(especialidad) + "," + "'" + ci + "'" + ");";
        ResultSet res = null;
        System.out.println(query);
        System.out.println(query2);

        try {
            java.sql.Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.executeUpdate(query2);
            conn.close();
        } catch (SQLException e) {

            System.exit(0);
        }
    }

    @Override
    public ArrayList<DoctorDto> getAll() {
        Connection conn = Conexion.getConexion();
        doctor = new ArrayList<>();


      //  String query = " select ci,matricula,tarifaconsulta from doctor;";

        String query = "\n" +
                "select carnet,nombre,costo,matricula,especialidades from \n" +
                "(select p.nombre ||' '|| p.appaterno  || ' '||p.apmaterno as nombre,p.ci as carnet,e2.nombre as especialidades,d.tarifaconsulta as costo,d.matricula as matricula from especialidaddoctor e\n" +
                "join doctor d on d.ci = e.ci_doctor \n" +
                "join especialidad e2 on e2.id = e.id_especialidad \n" +
                "join persona p on p.ci = d.ci)a;";
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
                String ci = res.getString("carnet");
                String nombreDoctor = res.getString("nombre");
                int costoConsulta = res.getInt("costo");
                String matricula = res.getString("matricula");
                String especialidades = res.getString("especialidades");


                //  logger.info(ci + " "+nombre + " "+apellidoPaterno + " "+apellidoMaterno, telefono,correo);
                //doctor.add(new DoctorDto(ci, matricula, costoConsulta));
                doctor.add(new DoctorDto(ci, nombreDoctor, costoConsulta, matricula ,especialidades));

            }

            conn.close();
        } catch (SQLException e) {
            logger.error("Error en el motor SQL", e);

        }

        return doctor;
    }

    @Override
    public ArrayList<DoctorDto> getAllConsultas() {
        Connection conn = Conexion.getConexion();
        doctor = new ArrayList<>();


        String query = "select p.nombre as doctor ,pa.nombre as paciente, (d.tarifaconsulta * count(c.id_reserva)) as total from doctor d\n" +
                "join reserva r on d.ci = r.ci_doctor and  r.estatus = 2\n" +
                "join consulta c on c.id_reserva = r.id \n" +
                "join persona p on p.ci = d.ci \n" +
                "join persona pa on pa.ci = r.ci_paciente \n" +
                "group by p.nombre ,pa.nombre,d.tarifaconsulta;";

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
                String doctorNombre = res.getString("doctor");

                String pacienteNombre = res.getString("paciente");

                int cobroDeConsultas = res.getInt("total");


                //  logger.info(ci + " "+nombre + " "+apellidoPaterno + " "+apellidoMaterno, telefono,correo);
                doctor.add(new DoctorDto(doctorNombre, pacienteNombre, cobroDeConsultas + ""));

            }

            conn.close();
        } catch (SQLException e) {
            logger.error("Error en el motor SQL", e);

        }

        return doctor;
    }


    @Override
    public void borrardoctor(String registro) {
        Connection conn = Conexion.getConexion();
        String query = "Delete from doctor where ci = " + "'" + registro + "'";
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
    public void actualizar(String ci, String matricula, int tarifaConsulta) {
        Connection conn = Conexion.getConexion();
        String query = "UPDATE doctor set ci = " + "'" + ci + "'" + "," + "matricula=" + "'" + matricula + "'"+ ","
                + "tarifaconsulta =" +  tarifaConsulta
                + "where ci=" + "'" + ci + "';";

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
