package br.edu.infnet.silvioluizbassi.Dtos.assemblers;

import br.edu.infnet.silvioluizbassi.Dtos.requests.BootcampRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.BootcampResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Bootcamp;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto.toInstrutoresCursoResponse;

public class MontadorBootcampDto {

    public static BootcampResponse toBootcampResponse(Bootcamp bootcamp) {
        return new BootcampResponse(
                bootcamp.getId(),
                bootcamp.getTitulo(),
                bootcamp.getValor(),
                bootcamp.getCargaHoraria(),
                bootcamp.getPreRequisitos(),
                bootcamp.isEstagioObrigatorio(),
                bootcamp.isAtivo(),
                bootcamp.getNivelBootcamp(),
                toInstrutoresCursoResponse(bootcamp.getInstrutores())
        );
    }

    public static Bootcamp toBootcamp(BootcampRequest bootcampRequest) {
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

    public static List<BootcampResponse> toBootcampsResponse(List<Bootcamp> bootcamps) {
        return bootcamps.stream().map(MontadorBootcampDto::toBootcampResponse).toList();
    }

}
