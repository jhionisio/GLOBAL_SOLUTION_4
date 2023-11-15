package life.assisten.forall.patient.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import jakarta.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    private Integer idPaciente;

    @NotNull(message = "nmPaciente cannot be null.")
    private String nmPaciente;

    @NotNull(message = "nmDoencasCronicas cannot be null.")
    private String nmDoencasCronicas;

    @NotNull(message = "nrCpf cannot be null.")
    private String nrCpf;

    @NotNull(message = "dtNascimento cannot be null.")
    private Date dtNascimento;

    @NotNull(message = "sexo cannot be null.")
    private char sexo;

    @NotNull(message = "nrTelefone cannot be null.")
    private String nmEndereco;

    @NotNull(message = "nrTelefone cannot be null.")
    private String nrTelefone;

    @NotNull(message = "email cannot be null.")
    private String email;

}
