package life.assisten.forall.doctor.controller.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorNoId {

    String nmMedico;
    String tipoEspecialidade;
    String crm;
    String nrCpf;
    Date dtNascimento;
    char sexo;
    String nmEndereco;
    String nrTelefone;
    String email;

}
