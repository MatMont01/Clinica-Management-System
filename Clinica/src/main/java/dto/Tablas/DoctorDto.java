package dto.Tablas;

public class DoctorDto {


    private String ciDoctor;
    private String matriculaDoctor;
    private int costoConsultaDoctor;
    private String nombreDoctor;
    private String nombrePaciente;
    private String totalCobrado;
    private String fechaDeConsulta;

    private String especialidad;

    public DoctorDto(String ciDoctor, String matriculaDoctor, int costoConsultaDoctor) {
        this.ciDoctor = ciDoctor;
        this.matriculaDoctor = matriculaDoctor;
        this.costoConsultaDoctor = costoConsultaDoctor;
    }

    public DoctorDto(String ciDoctor, String nombreDoctor,int costoConsultaDoctor,String matricula,String especialidad) {
        this.ciDoctor = ciDoctor;
        this.nombreDoctor = nombreDoctor;
        this.costoConsultaDoctor = costoConsultaDoctor;
        this.matriculaDoctor = matricula;
        this.especialidad = especialidad;
    }




    public DoctorDto(String nombreDoctor, String nombrePaciente, String totalCobrado) {
        this.nombreDoctor = nombreDoctor;
        this.nombrePaciente = nombrePaciente;
        this.totalCobrado = totalCobrado;

    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getTotalCobrado() {
        return totalCobrado;
    }

    public void setTotalCobrado(String totalCobrado) {
        this.totalCobrado = totalCobrado;
    }

    public void setFechaDeConsulta(String fechaDeConsulta) {
        this.fechaDeConsulta = fechaDeConsulta;
    }

    public String getFechaDeConsulta() {
        return fechaDeConsulta;
    }

    public String getCiDoctor() {
        return ciDoctor;
    }

    public void setCiDoctor(String ciDoctor) {
        this.ciDoctor = ciDoctor;
    }

    public String getMatriculaDoctor() {
        return matriculaDoctor;
    }

    public void setMatriculaDoctor(String matriculaDoctor) {
        this.matriculaDoctor = matriculaDoctor;
    }

    public int getCostoConsultaDoctor() {
        return costoConsultaDoctor;
    }

    public void setCostoConsultaDoctor(int costoConsultaDoctor) {
        this.costoConsultaDoctor = costoConsultaDoctor;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
