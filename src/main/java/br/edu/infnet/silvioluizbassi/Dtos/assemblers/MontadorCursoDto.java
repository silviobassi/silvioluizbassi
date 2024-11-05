package br.edu.infnet.silvioluizbassi.Dtos.assemblers;

import br.edu.infnet.silvioluizbassi.Dtos.requests.BootcampRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.EspecializacaoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.BootcampResponse;
import br.edu.infnet.silvioluizbassi.Dtos.responses.CursoMatriculaResponse;
import br.edu.infnet.silvioluizbassi.Dtos.responses.CursoResponse;
import br.edu.infnet.silvioluizbassi.Dtos.responses.EspecializacaoResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Bootcamp;
import br.edu.infnet.silvioluizbassi.model.domain.Curso;
import br.edu.infnet.silvioluizbassi.model.domain.Especializacao;

import java.util.List;

public class MontadorCursoDto {

    public static CursoMatriculaResponse toCursoMatriculaResponse(Curso curso) {
        return new CursoMatriculaResponse(curso.getId(), curso.getTitulo(), curso.getDescricao());
    }

    public static CursoResponse toCursoResponse(Curso curso) {
        CursoResponse cursoResponse = new CursoResponse();
        cursoResponse.setId(curso.getId());
        cursoResponse.setTitulo(curso.getTitulo());
        cursoResponse.setValor(curso.getValor());
        cursoResponse.setCargaHoraria(curso.getCargaHoraria());
        cursoResponse.setPreRequisitos(curso.getPreRequisitos());
        cursoResponse.setEstagioObrigatorio(curso.isEstagioObrigatorio());
        cursoResponse.setAtivo(curso.isAtivo());
        cursoResponse.setInstrutores(MontadorInstrutorDto.toInstrutoresCursoResponse(curso.getInstrutores()));

        return cursoResponse;
    }

    public static List<CursoResponse> toCursosResponse(List<Curso> cursos) {
        return cursos.stream().map(MontadorCursoDto::toCursoResponse).toList();
    }

    public static EspecializacaoResponse toCursoEspecializacaoResponse(Especializacao especializacao) {
        return new EspecializacaoResponse(
                especializacao.getId(),
                especializacao.getTitulo(),
                especializacao.getValor(),
                especializacao.getCargaHoraria(),
                especializacao.getPreRequisitos(),
                especializacao.isEstagioObrigatorio(),
                especializacao.isAtivo(),
                especializacao.getTipoDeEspecializacao().name(),
                MontadorInstrutorDto.toInstrutoresCursoResponse(especializacao.getInstrutores())
        );
    }

    public static BootcampResponse toCursoBootcampResponse(Bootcamp bootcamp) {
        return new BootcampResponse(
                bootcamp.getId(),
                bootcamp.getTitulo(),
                bootcamp.getValor(),
                bootcamp.getCargaHoraria(),
                bootcamp.getPreRequisitos(),
                bootcamp.isEstagioObrigatorio(),
                bootcamp.isAtivo(),
                bootcamp.getNivelBootcamp(),
                MontadorInstrutorDto.toInstrutoresCursoResponse(bootcamp.getInstrutores())
        );
    }

    public static Bootcamp toCursoBootcamp(BootcampRequest bootcampRequest) {
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setTitulo(bootcampRequest.titulo());
        bootcamp.setDescricao(bootcampRequest.descricao());
        bootcamp.setValor(bootcampRequest.valor());
        bootcamp.setCargaHoraria(bootcampRequest.cargaHoraria());
        bootcamp.setPreRequisitos(bootcampRequest.preRequisitos());
        bootcamp.setEstagioObrigatorio(bootcampRequest.estagioObrigatorio());
        bootcamp.setNivelBootcamp(bootcampRequest.nivel());

        return bootcamp;
    }


    public static Especializacao toCursoEspecializacao(EspecializacaoRequest especializacaoRequest) {
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
}
