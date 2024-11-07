package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto;
import br.edu.infnet.silvioluizbassi.Dtos.requests.EspecializacaoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.EspecializacaoResponse;
import br.edu.infnet.silvioluizbassi.exceptions.CursoNotFoundException;
import br.edu.infnet.silvioluizbassi.model.domain.Especializacao;
import br.edu.infnet.silvioluizbassi.model.domain.Instrutor;
import br.edu.infnet.silvioluizbassi.model.repository.CursoRepository;
import br.edu.infnet.silvioluizbassi.model.repository.EspecializacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorCursoDto.toCursoEspecializacaoResponse;
import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorCursoDto.toCursosEspecializacoesResponse;

@Service
public class EspecializacaoService {

    private final EspecializacaoRepository especializacaoRepository;
    private final InstrutorService instrutorService;

    public EspecializacaoService(EspecializacaoRepository especializacaoRepository, InstrutorService instrutorService) {
        this.especializacaoRepository = especializacaoRepository;
        this.instrutorService = instrutorService;
    }

    public EspecializacaoResponse incluir(EspecializacaoRequest especializacaoRequest) {
        Especializacao especializacao = new Especializacao();

        especializacaoRequest.instrutores().forEach(instrutorRequest -> {
            Instrutor instrutor = MontadorInstrutorDto
                    .toInstrutor(instrutorService.obterInstrutorPorId(instrutorRequest.id()));
            especializacao.getInstrutores().add(instrutor);
        });

        especializacao.setTitulo(especializacaoRequest.titulo());
        especializacao.setValor(especializacaoRequest.valor());
        especializacao.setCargaHoraria(especializacaoRequest.cargaHoraria());
        especializacao.setPreRequisitos(especializacaoRequest.preRequisitos());
        especializacao.setEstagioObrigatorio(especializacaoRequest.estagioObrigatorio());
        especializacao.setTipoDeEspecializacao(especializacaoRequest.tipoDeEspecializacao());

        return toCursoEspecializacaoResponse(especializacaoRepository.save(especializacao));
    }

    public List<EspecializacaoResponse> obterEspecializacoes() {
        return toCursosEspecializacoesResponse(especializacaoRepository.findAll());
    }

    public long countBootcamps() {
        return especializacaoRepository.count();
    }

    public EspecializacaoResponse obterEspecializacaoPorId(Integer id) {
        return toCursoEspecializacaoResponse(
                especializacaoRepository.findById(id).orElseThrow(CursoNotFoundException::new));
    }

    public void excluir(Integer id) {
        obterEspecializacaoPorId(id);
        especializacaoRepository.deleteById(id);
    }
}
