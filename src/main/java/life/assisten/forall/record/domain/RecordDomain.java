package life.assisten.forall.record.domain;

import jakarta.persistence.*;
import life.assisten.forall.patient.domain.PatientDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "paciente_medico")
public class RecordDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ficha")
    private Integer idRecord;

    @Column(name = "sintomas_atuais", length = 100)
    private String sintomasAtuais;

    @Column(name = "medicamentos_uso", length = 100)
    private String medicamentosUso;

    @Column(name = "alergia", length = 50)
    private String alergia;

    @Column(name = "peso", length = 5)
    private float peso;

    @Column(name = "altura", length = 5)
    private float altura;

    @Column(name = "observacoes", length = 100)
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PatientDomain patientDomain;
}
