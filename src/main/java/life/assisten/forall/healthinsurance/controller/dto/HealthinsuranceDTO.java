package life.assisten.forall.healthinsurance.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HealthinsuranceDTO {

    @NotNull(message = "nmPlano cannot be null.")
    private String nmPlano;

    @NotNull(message = "tipoPlano cannot be null.")
    private String tipoPlano;

    @NotNull(message = "cobertura cannot be null.")
    private String cobertura;

    @NotNull(message = "carencia cannot be null.")
    private String carencia;

}