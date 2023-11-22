package life.assisten.forall.diary.controller.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryDTO {

    @NotNull(message = "nmRemedio cannot be null.")
    private String nmRemedio;

    @NotNull(message = "descricaoRemedio cannot be null.")
    private String descricaoRemedio;

    @NotNull(message = "dtInicio cannot be null.")
    private Date dtInicio;

    private Date dtTermino;

    private Integer patientId;

}
