package life.assisten.forall.record.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ficha")
public class RecordDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ficha")
    private Integer idFicha;

    @Column(name = "sintomas_atuais", length = 100)
    private String sintomasAtuais;

    @Column(name = "alergia", length = 50)
    private String alergia;

    @Column(name = "peso", length = 20)
    private float peso;

    @Column(name = "carencia", length = 11)
    private String carencia;
}

