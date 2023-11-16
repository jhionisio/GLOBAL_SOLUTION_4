package life.assisten.forall.emergencyContacts.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyContactsDTO {

    @NotBlank(message = "Name is mandatory")
    private String nmNome;

    @NotBlank(message = "Relationship is mandatory")
    private String parentesco;

    @NotBlank(message = "CPF is mandatory")
    private String nrCpf;

    @NotNull(message = "Date of birth is mandatory")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dtNascimento;

    @NotBlank(message = "Gender is mandatory")
    private String sexo;

    @NotBlank(message = "Address is mandatory")
    private String nmEndereco;

    @NotBlank(message = "Phone number is mandatory")
    private String nrTelefone;

    @NotBlank(message = "Email is mandatory")
    private String nnEmail;
}
