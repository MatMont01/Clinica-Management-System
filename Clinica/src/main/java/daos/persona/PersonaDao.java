package daos.persona;

import java.util.ArrayList;

public abstract class PersonaDao<T> {
    public abstract void registrarPersona(String ci,String Nombre,String apellidoPaterno,String apellidoAAMaterno,String telefono,String correo);

    public abstract ArrayList<T> getAll();

    public abstract void borrarPersona(String registro);

    public abstract void actualizar(String ci,String Nombre,String apellidoPaterno,String apellidoAAMaterno,String telefono,String correo);

}
