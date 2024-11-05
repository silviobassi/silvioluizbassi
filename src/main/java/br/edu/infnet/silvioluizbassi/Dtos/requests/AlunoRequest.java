package br.edu.infnet.silvioluizbassi.Dtos.requests;

import br.edu.infnet.silvioluizbassi.model.domain.Genero;

import java.time.LocalDateTime;

public record AlunoRequest(
        String nome,
        LocalDateTime dataNascimento,
        Genero genero,
        String email,
        String whatsApp,
        String cep,
        boolean isBolsista,
        boolean isEnem
) {
}
