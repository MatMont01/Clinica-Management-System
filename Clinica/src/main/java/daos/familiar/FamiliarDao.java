package daos.familiar;

import java.util.ArrayList;

public abstract class FamiliarDao <T>{


    public abstract void registrarFamiliar(String ci,String parentesco);

    public abstract ArrayList<T> getAll();

    public abstract void borrarFamiliar(String registro);

    public abstract void actualizar(String ci,String parentesco);



}
