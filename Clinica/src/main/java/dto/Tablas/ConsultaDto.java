package dto.Tablas;

public class ConsultaDto {

    private String id;
    private String idReserva;
    private String detalleDeConsulta;
    private String fechaDeConsulta;

    String fechaCaptura;
    String fechaReserva;
    String nombreDoctor;
    String nombrePaciente;
    String observaciones;



    public ConsultaDto(String id, String idReserva, String detalleDeConsulta, String fechaDeConsulta) {
        this.id = id;
        this.idReserva = idReserva;
        this.detalleDeConsulta = detalleDeConsulta;
        this.fechaDeConsulta = fechaDeConsulta;
    }

    public ConsultaDto(String id, String fechaCaptura, String fechaReserva, String nombreDoctor, String nombrePaciente, String observaciones) {
        this.id = id;
        this.fechaCaptura = fechaCaptura;
        this.fechaReserva = fechaReserva;
        this.nombreDoctor = nombreDoctor;
        this.nombrePaciente = nombrePaciente;
        this.observaciones = observaciones;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getDetalleDeConsulta() {
        return detalleDeConsulta;
    }

    public void setDetalleDeConsulta(String detalleDeConsulta) {
        this.detalleDeConsulta = detalleDeConsulta;
    }

    public String getFechaDeConsulta() {
        return fechaDeConsulta;
    }


    public void setFechaDeConsulta(String fechaDeConsulta) {
        this.fechaDeConsulta = fechaDeConsulta;
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
