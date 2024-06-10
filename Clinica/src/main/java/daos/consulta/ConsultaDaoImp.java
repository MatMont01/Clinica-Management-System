package daos.consulta;

import conectar.Conexion;
import dto.Tablas.ConsultaDto;
import dto.Tablas.ReservaDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultaDaoImp extends ConsultaDao<ConsultaDto> {

    ArrayList<ConsultaDto> consulta;


    @Override
    public void registrarConsulta(int id_reserva, String detalleDeConsulta, String fechaConsulta) {
        Connection conn = Conexion.getConexion();
        String query = "insert into consulta  values " + "(" + "default" +   ","   +  + id_reserva + "," + "'" + detalleDeConsulta+ "'" + "," + "'" + fechaConsulta + "'" +  " );";
        System.out.println(query);
        String query22 = "select limpiaReservas(); ";
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
    public ArrayList<ConsultaDto> getAll() {

        Connection con = Conexion.getConexion();
        consulta = new ArrayList<>();

        String query = "select r.id ,r.fechacaptura ,r.fechareserva  ,concat(p.nombre||' '||p.appaterno||' '||p.apmaterno  )as nombreDoctor,\n" +
                "concat(pa.nombre||' '||pa.appaterno||' '||pa.apmaterno)as nombrepaciente, r.observaciones from reserva r\n" +
                "join persona p on r.ci_doctor = p.ci\n" +
                "join persona pa on r.ci_paciente = pa.ci\n" +
                "where r.estatus = 1 ;";
        String query2 = "select limpiaReservas(); ";
        ResultSet res = null;
        try {
            java.sql.Statement stmt = con.createStatement();
            res = stmt.executeQuery(query2);
            res = stmt.executeQuery(query);

        } catch (SQLException e) {
            //logger.error("No puede ejecutar la consulta SQL", e);
            System.exit(0);
        }
        try {
            while (res.next()) {
                String id = res.getInt("id") + "";

                String fechaCaptura = res.getString("fechacaptura");
                String fechaReserva = res.getString("fechareserva");
                String nombreDoctor = res.getString("nombreDoctor");
                String nombrePaciente = res.getString("nombrepaciente");
                String observaciones = res.getString("observaciones");

                //  logger.info(ci + " "+nombre + " "+apellidoPaterno + " "+apellidoMaterno, telefono,correo);
                consulta.add(new ConsultaDto(id, fechaCaptura, fechaReserva, nombreDoctor, nombrePaciente, observaciones));


            }

            con.close();
        } catch (SQLException e) {
            // logger.error("Error en el motor SQL", e);

        }

        return consulta;

    }


    @Override
    public void borrardoctor(String registro) {

    }

    @Override
    public void actualizar(int id, int id_reserva, String detalleDeConsulta, String fechaConsulta) {

    }
}

