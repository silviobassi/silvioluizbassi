package br.edu.infnet.silvioluizbassi.Dtos.requests;

import br.edu.infnet.silvioluizbassi.model.domain.Genero;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record UpdateInstrutorRequest(
        @Schema(example = "1")
        Integer id,
        @Schema(example = "Silvio Luiz Bassi")
        String nome,
        @Schema(example = "1980-01-01T00:00:00")
        LocalDateTime dataNascimento,
        @Schema(example = "MASCULINO")
        Genero genero,
        @Schema(example = "silvio@email.com")
        String email,
        @Schema(example = "+552199999-9999")
        String whatsApp,
        @Schema(example = "13403-775")
        String cep,
        @Schema(example = "Engenheiro de Software")
        String formacao,
        @Schema(example = "Desenvolvimento de Software")
        String especialidade
) {
}
