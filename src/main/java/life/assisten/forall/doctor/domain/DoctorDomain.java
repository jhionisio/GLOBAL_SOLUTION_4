package life.assisten.forall.doctor.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario_medico")
public class DoctorDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Integer idMedico;

    @Column(name = "nm_medico", length = 100)
    private String nmMedico;

    @Column(name = "tipo_especialidade", length = 50)
    private String tipoEspecialidade;

    @Column(name = "crm", length = 20)
    private String crm;

    @Column(name = "nr_cpf", length = 11)
    private String nrCpf;

    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;

    @Column(name = "sexo", length = 1)
    private char sexo;

    @Column(name = "nm_endereco", length = 255)
    private String nmEndereco;

    @Column(name = "nr_telefone", length = 20)
    private String nrTelefone;

    @Column(name = "nn_email", length = 100)
    private String nnEmail;
}
