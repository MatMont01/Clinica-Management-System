package daos.cirugia;

import conectar.Conexion;
import dto.Tablas.CirugiaDto;
import dto.Tablas.IngresoDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CirugiaDaoImp extends CirugiaDao<CirugiaDto> {

    ArrayList<CirugiaDto> cirujia;
    @Override
    public void registrarCirugia(String ingresoId, String ciFamiliar, String costoCirugia, String fecha, String detalle, String horaInicio, String horaFin) {
        Connection conn = Conexion.getConexion();
        String query = "insert into cirugia values " + "(" + "default" +   ","   +  ingresoId + "," + "'" + ciFamiliar+ "'" + ","  + costoCirugia +  "," + "'" + fecha + "'" +  "," + "'" + detalle+ "'" + ","+ "'" + horaInicio+ "'" + "," +"'" + horaFin+"'" + ");";
        System.out.println(query);
        //String query22 = "select limpiaReservas(); ";
        ResultSet res = null;

        try {
            java.sql.Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            // stmt.executeUpdate(query22);
            conn.close();
        } catch (SQLException e) {

            System.exit(0);
        }
    }

    @Override
    public ArrayList<CirugiaDto> getAll() {
        Connection con = Conexion.getConexion();
        cirujia = new ArrayList<>();

        String query = "select c.fecha ,c.detalles ,c.horainicio ,c.horafin , p.nombre as doctorResponsable,d.ci_doctor from reserva r\n" +
                "join ingreso i on i.id_reserva = r.id\n" +
                "join cirugia c on c.ingreso_id = i.id\n" +
                "join doctorresponsable d on d.ci_doctor  = r.ci_doctor\n" +
                "join persona p on p.ci = d.ci_doctor\n" +
                "group by c.fecha ,c.detalles ,c.horainicio ,c.horafin , p.nombre ,d.ci_doctor;";


        ResultSet res = null;
        try {
            java.sql.Statement stmt = con.createStatement();
            res = stmt.executeQuery(query);

        } catch (SQLException e) {
            //logger.error("No puede ejecutar la consulta SQL", e);
            System.exit(0);
        }
        try {
            while (res.next()) {
                String fecha = res.getString("fecha");
                String detalle = res.getString("detalles");
                String horaInicio = res.getString("horainicio");
                String horaFin = res.getString("horafin");
                String doctorResponsable = res.getString("doctorresponsable");
                String ciDoctor = res.getString("ci_doctor");



                //  logger.info(ci + " "+nombre + " "+apellidoPaterno + " "+apellidoMaterno, telefono,correo);
                cirujia.add(new CirugiaDto(fecha, detalle, horaInicio, horaFin, doctorResponsable, ciDoctor));


            }

            con.close();
        } catch (SQLException e) {
            // logger.error("Error en el motor SQL", e);

        }

        return cirujia;
    }
}



