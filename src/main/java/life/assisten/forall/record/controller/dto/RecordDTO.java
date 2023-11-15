package life.assisten.forall.record.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordDTO {

    private Integer idFicha;

    @NotNull(message = "sintomasAtuais cannot be null.")
    private String sintomasAtuais;

    @NotNull(message = "medicamentosUso cannot be null.")
    private String medicamentosUso;

    @NotNull(message = "alergia cannot be null.")
    private String alergia;

    @NotNull(message = "peso cannot be null.")
    private float peso;

    @NotNull(message = "altura cannot be null.")
    private float altura;

    @NotNull(message = "observacoes cannot be null.")
    private String observacoes;

}