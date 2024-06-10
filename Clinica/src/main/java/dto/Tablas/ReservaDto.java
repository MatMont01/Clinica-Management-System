package dto.Tablas;

import java.util.Date;

public class ReservaDto  {
    String id;
    private String ci_doctor;
    private String ci_paciente;
    private String observaciones;

    private String fechaCaptura;
    private String fechaReserva;

    private String nombreDoctor;
    private String nombrePaciente;



/*
  public ReservaDto(String id,String ci_doctor, String ci_paciente, String observaciones, String fechaCaptura,String fechaReserva) {
        this.id = id;
        this.ci_doctor = ci_doctor;
        this.ci_paciente = ci_paciente;
        this.observaciones = observaciones;
        this.fechaCaptura = fechaCaptura;
        this.fechaReserva = fechaReserva;
    }
 */





    public ReservaDto(String id, String fechaCaptura, String fechaReserva, String nombreDoctor, String nombrePaciente,String observaciones) {
        this.id = id;
        this.fechaCaptura = fechaCaptura;
        this.fechaReserva = fechaReserva;
        this.nombreDoctor = nombreDoctor;
        this.nombrePaciente = nombrePaciente;
        this.observaciones= observaciones;
    }

    public ReservaDto(String id,String fechaCaptura,String fechaReserva,String ci_doctor,String nombreDoctor,String nombrePaciente,String ci_paciente,String observaciones) {
        this.id = id;
        this.fechaCaptura = fechaCaptura;
        this.fechaReserva = fechaReserva;
        this.ci_doctor = ci_doctor;
        this.nombreDoctor = nombreDoctor;
        this.nombrePaciente = nombrePaciente;
        this.ci_paciente = ci_paciente;
        this.observaciones = observaciones;
    }



    public String getCi_doctor() {
        return ci_doctor;
    }

    public void setCi_doctor(String ci_doctor) {
        this.ci_doctor = ci_doctor;
    }

    public String getCi_paciente() {
        return ci_paciente;
    }

    public void setCi_paciente(String ci_paciente) {
        this.ci_paciente = ci_paciente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getFechaCaptura() {
        return fechaCaptura;
    }

    public void setFechaCaptura(String fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }
}
