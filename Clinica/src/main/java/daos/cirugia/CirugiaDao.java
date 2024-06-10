package daos.cirugia;

import java.util.ArrayList;

public abstract class CirugiaDao<T> {


    public abstract void registrarCirugia(String ingresoId, String ciFamiliar, String costoInternacion, String fecha, String detalle, String horaInicio, String horaFin);

    public abstract ArrayList<T> getAll();




}
