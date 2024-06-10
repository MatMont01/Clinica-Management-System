package daos.reserva;

import java.sql.Date;
import java.util.ArrayList;

public abstract class ReservaDao<T> {

    public abstract void registrarReserva(String ci_doctor, String ci_paciente, String observaciones, String fecha ,String fechaReserva);

    public abstract ArrayList<T> getAll();

    public abstract void borrarReserva(String registro);

    public abstract void actualizar(String id,String ci_doctor, String ci_paciente, String observaciones, String fechaCaptura,String fechaReserva);




}
