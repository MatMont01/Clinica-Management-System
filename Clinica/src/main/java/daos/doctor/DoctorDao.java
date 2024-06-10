package daos.doctor;

import java.util.ArrayList;

public abstract class DoctorDao<T> {


    public abstract void registrarDoctor(String ci,String matricula,int tarifaConsulta,String consulta);

    public abstract ArrayList<T> getAll();

    public abstract ArrayList<T> getAllConsultas();

    public abstract void borrardoctor(String registro);

    public abstract void actualizar(String ci,String matricula,int tarifaConsulta);




}
