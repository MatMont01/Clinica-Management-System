package dto.Tablas;

public class CirugiaDto {

    String ingresoId;
    String ciFamiliar;
    String costoCirugia;
    String fecha;
    String detalle;
    String horaInicio;
    String horaFin;
    String nombrePaciente;

    String docotorResponsable;
    String doctorId;




    public CirugiaDto(String fecha, String detalle, String horaInicio, String horaFin, String nombreDoctor, String doctorId) {
        this.fecha = fecha;
        this.detalle = detalle;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.docotorResponsable = nombreDoctor;
        this.doctorId = doctorId;
    }




    public String getIngresoId() {
        return ingresoId;
    }

    public void setIngresoId(String ingresoId) {
        this.ingresoId = ingresoId;
    }

    public String getCiFamiliar() {
        return ciFamiliar;
    }

    public void setCiFamiliar(String ciFamiliar) {
        this.ciFamiliar = ciFamiliar;
    }

    public String getCostoCirugia() {
        return costoCirugia;
    }

    public void setCostoCirugia(String costoCirugia) {
        this.costoCirugia = costoCirugia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }


    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getDocotorResponsable() {
        return docotorResponsable;
    }

    public void setDocotorResponsable(String docotorResponsable) {
        this.docotorResponsable = docotorResponsable;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
