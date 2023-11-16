package life.assisten.forall.diary.domain;

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
@Table(name = "AGENDA_PACIENTE")
public class DiaryDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AGENDA")
    private Integer idAgenda;

    @Column(name = "NM_REMEDIO", length = 100)
    private String nmRemedio;

    @Column(name = "DESCRICAO_REMEDIO", length = 255)
    private String descricaoRemedio;

    @Column(name = "DT_INICIO")
    @Temporal(TemporalType.DATE)
    private Date dtInicio;

    @Column(name = "DT_TERMINO")
    @Temporal(TemporalType.DATE)
    private Date dtTermino;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PatientDomain patientDomain;

}
