package dto.Tablas;

public class FamiliarDto {

    private String ciFamiliar;
    private String ciPaciente;

    private String nombrePaciente;
    private String nombreFamiliar;

    private String parentesco;


    public FamiliarDto(String ci, String parentesco) {
        this.ciFamiliar = ci;
        this.parentesco = parentesco;
    }

    public FamiliarDto(String ciPaciente, String nombrePaciente, String ciFamiliar, String nombreFamiliar, String parentesco) {
        this.ciFamiliar = ciFamiliar;
        this.ciPaciente = ciPaciente;
        this.nombrePaciente = nombrePaciente;
        this.nombreFamiliar = nombreFamiliar;
        this.parentesco = parentesco;
    }


    public String getCi() {
        return ciFamiliar;
    }

    public void setCi(String ci) {
        this.ciFamiliar = ci;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getCiFamiliar() {
        return ciFamiliar;
    }

    public void setCiFamiliar(String ciFamiliar) {
        this.ciFamiliar = ciFamiliar;
    }

    public String getCiPaciente() {
        return ciPaciente;
    }

    public void setCiPaciente(String ciPaciente) {
        this.ciPaciente = ciPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreFamiliar() {
        return nombreFamiliar;
    }

    public void setNombreFamiliar(String nombreFamiliar) {
        this.nombreFamiliar = nombreFamiliar;
    }
}
