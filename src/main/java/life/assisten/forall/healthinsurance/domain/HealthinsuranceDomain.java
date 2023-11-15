package life.assisten.forall.healthinsurance.domain;

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
@Table(name = "plano_saude")
public class HealthinsuranceDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plano")
    private Integer idPlano;

    @Column(name = "nm_plano", length = 100)
    private String nmPlano;

    @Column(name = "tipo_plano", length = 50)
    private String tipoPlano;

    @Column(name = "cobertura", length = 20)
    private String cobertura;

    @Column(name = "carencia", length = 11)
    private String carencia;
}
