package life.assisten.forall.emergencyContacts.domain;

import jakarta.persistence.*;
import life.assisten.forall.patient.domain.PatientDomain;
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
@Table(name = "CONTATOS_EMERGENCIA")
public class EmergencyContactsDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTATOS")
    private Integer idContatos;

    @Column(name = "NM_NOME", length = 255)
    private String nmNome;

    @Column(name = "PARENTESCO", length = 255)
    private String parentesco;

    @Column(name = "NR_CPF", length = 11)
    private String nrCpf;

    @Column(name = "DT_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;

    @Column(name = "SEXO", length = 1)
    private char sexo;

    @Column(name = "NM_ENDERECO", length = 255)
    private String nmEndereco;

    @Column(name = "NR_TELEFONE", length = 20)
    private String nrTelefone;

    @Column(name = "NN_EMAIL", length = 100)
    private String nnEmail;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PatientDomain patientDomain;

}
