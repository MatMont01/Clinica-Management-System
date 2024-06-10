package daos.paciente;

import java.util.ArrayList;

public abstract class PacienteDao<T> {

    public abstract void registrarPaciete(String ci,String aseguradora,boolean esParticular,boolean esAlergico,String numeroDeSeguro);
    public abstract ArrayList<T> getAll();

    public abstract void borrarPaciente(String registro);

    public abstract void actualizar(String ci,String aseguradora,boolean esParticular,boolean esAlergico,String numeroDeSeguro);

}
