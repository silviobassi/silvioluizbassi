package br.edu.infnet.silvioluizbassi.Dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EnderecoResponse(
        Integer id,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String localidade,
        String estado,
        String cep
) {
}
