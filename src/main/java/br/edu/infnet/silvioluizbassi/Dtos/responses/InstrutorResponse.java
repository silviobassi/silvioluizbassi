package br.edu.infnet.silvioluizbassi.Dtos.responses;

import br.edu.infnet.silvioluizbassi.model.domain.Genero;

import java.time.LocalDateTime;

public record InstrutorResponse(
        Integer id,
        String nome,
        LocalDateTime dataNascimento,
        Genero genero,
        String email,
        String whatsApp,
        EnderecoResponse endereco,
        String formacao,
        String especialidade
) {
}


/*
*  private Integer id;

    private String nome;
    private LocalDateTime dataNascimento;
    private Genero genero;

    @Embedded
    private Contato contato;

    @OneToOne(optional = false, orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Endereco endereco;
    * private String formacao;
    private String especialidade;
* */