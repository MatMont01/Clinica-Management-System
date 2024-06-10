package daos.consulta;

import java.util.ArrayList;

public abstract class ConsultaDao<T> {

    public abstract void registrarConsulta(int id_reserva,String detalleDeConsulta,String fechaConsulta);

    public abstract ArrayList<T> getAll();

    public abstract void borrardoctor(String registro);

    public abstract void actualizar(int id,int id_reserva,String detalleDeConsulta,String fechaConsulta);



}
