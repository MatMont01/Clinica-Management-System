package dto.Tablas;

public class PacienteDto {
    private String ciPaciente;
    private String nombreAseguradoraPaciente;
    private boolean esParticular;
    private boolean esAlergico;
    private String numeroSeguro;

    public PacienteDto(String ciPaciente, String nombreAseguradoraPaciente, boolean esParticular, boolean esAlergico, String numeroSeguro) {
        this.ciPaciente = ciPaciente;
        this.nombreAseguradoraPaciente = nombreAseguradoraPaciente;
        this.esParticular = esParticular;
        this.esAlergico = esAlergico;
        this.numeroSeguro = numeroSeguro;
    }

    public String getCiPaciente() {
        return ciPaciente;
    }

    public void setCiPaciente(String ciPaciente) {
        this.ciPaciente = ciPaciente;
    }

    public String getNombreAseguradoraPaciente() {
        return nombreAseguradoraPaciente;
    }

    public void setNombreAseguradoraPaciente(String nombreAseguradoraPaciente) {
        this.nombreAseguradoraPaciente = nombreAseguradoraPaciente;
    }

    public boolean isEsParticular() {
        return esParticular;
    }

    public void setEsParticular(boolean esParticular) {
        this.esParticular = esParticular;
    }

    public boolean isEsAlergico() {
        return esAlergico;
    }

    public void setEsAlergico(boolean esAlergico) {
        this.esAlergico = esAlergico;
    }

    public String getNumeroSeguro() {
        return numeroSeguro;
    }

    public void setNumeroSeguro(String numeroSeguro) {
        this.numeroSeguro = numeroSeguro;
    }
}
