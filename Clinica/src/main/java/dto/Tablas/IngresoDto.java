package dto.Tablas;

public class IngresoDto {
    private String id;
    private String id_reserva;
    private String id_habitacion;
    private String fecha_Entrada;
    private String fecha_Salida;
    private String motivo;
    private String costoDeInternacion;
    private String fechaCaptura;
    private String fechaReserva;
    private String nombreDoctor;
    private String nombrePaciente;
    private String observaciones;

    /*
     public IngresoDto(String id_reserva, String id_habitacion, String fecha_Entrada, String fecha_Salida, String motivo, String costoDeInternacion) {
        this.id_reserva = id_reserva;
        this.id_habitacion = id_habitacion;
        this.fecha_Entrada = fecha_Entrada;
        this.fecha_Salida = fecha_Salida;
        this.motivo = motivo;
        this.costoDeInternacion = costoDeInternacion;
    }
     */


    public IngresoDto(String id, String fechaCaptura, String fechaReserva, String nombreDoctor, String nombrePaciente, String observaciones) {
        this.id = id;
        this.fechaCaptura = fechaCaptura;
        this.fechaReserva = fechaReserva;
        this.nombreDoctor = nombreDoctor;
        this.nombrePaciente = nombrePaciente;
        this.observaciones = observaciones;
    }


    public String getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(String id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(String id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getFecha_Entrada() {
        return fecha_Entrada;
    }

    public void setFecha_Entrada(String fecha_Entrada) {
        this.fecha_Entrada = fecha_Entrada;
    }

    public String getFecha_Salida() {
        return fecha_Salida;
    }

    public void setFecha_Salida(String fecha_Salida) {
        this.fecha_Salida = fecha_Salida;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getCostoDeInternacion() {
        return costoDeInternacion;
    }

    public void setCostoDeInternacion(String costoDeInternacion) {
        this.costoDeInternacion = costoDeInternacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaCaptura() {
        return fechaCaptura;
    }

    public void setFechaCaptura(String fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
