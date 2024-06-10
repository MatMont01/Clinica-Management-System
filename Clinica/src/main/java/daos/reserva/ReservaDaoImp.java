package daos.reserva;

import conectar.Conexion;
import daos.paciente.PacienteDaoImp;

import dto.Tablas.ReservaDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ReservaDaoImp extends ReservaDao<ReservaDto>{

    ArrayList<ReservaDto> reserva;
    private final static Logger logger = LogManager.getLogger(PacienteDaoImp.class);

    @Override
    public void registrarReserva(String ci_doctor, String ci_paciente, String observaciones, String fecha,String fechaReserva) {
        Connection conn = Conexion.getConexion();
        String query =  "insert into reserva  values " + "(" + "default" +   "," + "'" + ci_doctor + "'" + "," + "'" + ci_paciente+ "'" + "," + "'" + observaciones + "'" + ","  + "'" + fecha + "'" + "," +"'" + fechaReserva+"'" + ");";
        System.out.println(query);
        ResultSet res = null;

        try {
            java.sql.Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.close();
        } catch (SQLException e) {

            System.exit(0);
        }
    }

    @Override
    public ArrayList<ReservaDto> getAll() {
        Connection conn = Conexion.getConexion();
        reserva = new ArrayList<>();

        String query = "select r.id ,r.fechacaptura ,r.fechareserva  ,r.ci_doctor as doctorCI ,concat(p.nombre||' '||p.appaterno||' '||p.apmaterno  )as nombreDoctor, \n" +
                "concat(pa.nombre||' '||pa.appaterno||' '||pa.apmaterno)as nombrepaciente,r.ci_paciente as pacienteCI ,r.observaciones from reserva r \n" +
                "join persona p on r.ci_doctor = p.ci \n" +
                "join persona pa on r.ci_paciente = pa.ci\n" +
                "where r.estatus = 1;";
        String query2= "select limpiaReservas(); ";
        ResultSet res = null;
        try {
            java.sql.Statement stmt = conn.createStatement();
            res=stmt.executeQuery(query2);
            res = stmt.executeQuery(query);

        } catch (SQLException e) {
            logger.error("No puede ejecutar la consulta SQL", e);
            System.exit(0);
        }
        try {
            while (res.next()) {
                String id = res.getInt("id") +"";

                String fechaCaptura = res.getString("fechacaptura");
                String fechaReserva = res.getString("fechareserva");
                String doctorCI = res.getString("doctorCI");
                String nombredoctor = res.getString("nombredoctor");
                String nombrepaciente = res.getString("nombrepaciente");
                String pacienteCI = res.getString("pacienteCI");
                String observaciones = res.getString("observaciones");



                //  logger.info(ci + " "+nombre + " "+apellidoPaterno + " "+apellidoMaterno, telefono,correo);
                reserva.add(new ReservaDto(id,fechaCaptura ,fechaReserva,doctorCI,nombredoctor,nombrepaciente,pacienteCI,observaciones));

            }

            conn.close();
        } catch (SQLException e) {
            logger.error("Error en el motor SQL", e);

        }

        return reserva;

    }






    @Override
    public void borrarReserva(String registro) {
        Connection conn = Conexion.getConexion();
        String query = "Delete from reserva where id = " + registro + ";";
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
    public void actualizar(String id,String ci_doctor, String ci_paciente, String observaciones, String fechaCaptura,String fechaReserva) {
        Connection conn = Conexion.getConexion();
        String query = "UPDATE reserva set ci_doctor = "+ "'"  +ci_doctor +"'" + "," + "ci_paciente"  +  "=" +"'"  +ci_paciente +"'" + ","
                + "observaciones =" +"'"  +observaciones +"'"+ ","  +"fechacaptura= " +"'"+fechaCaptura +"'" + ","+"fechareserva= " +"'"+fechaReserva +"'"
                +"where id=" + id + ";";
//UPDATE reserva set ci_doctor = '9756226SC',ci_paciente='4321',observaciones ='cambio de fecha',fechacaptura= '2022-06-17'fechareserva= '2022-06-26'where id=40;
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
