package life.assisten.forall.doctor.controller.dto;

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
public class DoctorDTO {

    @NotNull(message = "nmMedico cannot be null.")
    private String nmMedico;

    @NotNull(message = "tipoEspecialidade cannot be null.")
    private String tipoEspecialidade;

    @NotNull(message = "crm cannot be null.")
    private String crm;

    @NotNull(message = "nrCpf cannot be null.")
    private String nrCpf;

    @NotNull(message = "dtNascimento cannot be null.")
    private Date dtNascimento;

    @NotNull(message = "sexo cannot be null.")
    private char sexo;

    @NotNull(message = "nmEndereco cannot be null.")
    private String nmEndereco;

    @NotNull(message = "nrTelefone cannot be null.")
    private String nrTelefone;

    @NotNull(message = "email cannot be null.")
    private String email;

    @NotNull(message = "password cannot be null.")
    private String password;
}
