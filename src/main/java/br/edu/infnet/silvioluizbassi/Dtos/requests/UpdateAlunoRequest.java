package br.edu.infnet.silvioluizbassi.Dtos.requests;

import br.edu.infnet.silvioluizbassi.model.domain.Genero;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record UpdateAlunoRequest(
        @Schema(example = "1")
        Integer id,
        @Schema(example = "Marta Soraia") String nome,
        LocalDateTime dataNascimento,
        @Schema(example = "FEMININO")
        Genero genero,
        @Schema(example = "marta@marta.email.com")
        String email,
        @Schema(example = "+552199999-9999")
        String whatsApp,
        @Schema(example = "13403-775")
        String cep,
        @Schema(example = "true")
        boolean isBolsista,
        @Schema(example = "false")
        boolean isEnem
) {

}
