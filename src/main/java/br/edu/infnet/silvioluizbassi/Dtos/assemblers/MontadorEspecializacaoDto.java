package br.edu.infnet.silvioluizbassi.Dtos.assemblers;

import br.edu.infnet.silvioluizbassi.Dtos.requests.EspecializacaoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.EspecializacaoResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Especializacao;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto.toInstrutoresCursoResponse;

public class MontadorEspecializacaoDto {

    public static EspecializacaoResponse toEspecializacaoResponse(Especializacao especializacao) {
        return new EspecializacaoResponse(
                especializacao.getId(),
                especializacao.getTitulo(),
                especializacao.getValor(),
                especializacao.getCargaHoraria(),
                especializacao.getPreRequisitos(),
                especializacao.isEstagioObrigatorio(),
                especializacao.isAtivo(),
                especializacao.getTipoDeEspecializacao().name(),
                toInstrutoresCursoResponse(especializacao.getInstrutores())
        );
    }

    public static Especializacao toEspecializacao(EspecializacaoRequest especializacaoRequest) {
        Especializacao especializacao = new Especializacao();
        especializacao.setTitulo(especializacaoRequest.titulo());
        especializacao.setDescricao(especializacaoRequest.descricao());
        especializacao.setValor(especializacaoRequest.valor());
        especializacao.setCargaHoraria(especializacaoRequest.cargaHoraria());
        especializacao.setPreRequisitos(especializacaoRequest.preRequisitos());
        especializacao.setEstagioObrigatorio(especializacaoRequest.estagioObrigatorio());
        especializacao.setTipoDeEspecializacao(especializacaoRequest.tipoDeEspecializacao());

        return especializacao;
    }

    public static List<EspecializacaoResponse> toEspecializacoesResponse(List<Especializacao> especializacoes) {
        return especializacoes.stream().map(MontadorEspecializacaoDto::toEspecializacaoResponse).toList();
    }

}
