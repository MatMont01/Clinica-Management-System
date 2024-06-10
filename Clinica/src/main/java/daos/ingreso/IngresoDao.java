package daos.ingreso;

import java.util.ArrayList;

public abstract class IngresoDao <T>{

    public abstract void registrarIngreso(int id_reserva,int idhabitacion,String fechaIngreso,String fechaSalida,String motivo,double costoDeInternacion);

    public abstract ArrayList<T> getAll();

}
