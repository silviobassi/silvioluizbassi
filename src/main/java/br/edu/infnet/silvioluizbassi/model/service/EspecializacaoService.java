package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto;
import br.edu.infnet.silvioluizbassi.Dtos.requests.EspecializacaoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.EspecializacaoResponse;
import br.edu.infnet.silvioluizbassi.exceptions.CursoNotFoundException;
import br.edu.infnet.silvioluizbassi.model.domain.Especializacao;
import br.edu.infnet.silvioluizbassi.model.domain.Instrutor;
import br.edu.infnet.silvioluizbassi.model.repository.EspecializacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorEspecializacaoDto.*;

@Service
public class EspecializacaoService {

    private final EspecializacaoRepository especializacaoRepository;
    private final InstrutorService instrutorService;

    public EspecializacaoService(EspecializacaoRepository especializacaoRepository, InstrutorService instrutorService) {
        this.especializacaoRepository = especializacaoRepository;
        this.instrutorService = instrutorService;
    }

    public EspecializacaoResponse incluir(EspecializacaoRequest especializacaoRequest) {
        Especializacao especializacao = toEspecializacao(especializacaoRequest);

        especializacaoRequest.instrutores().forEach(instrutorRequest -> {
            Instrutor instrutor = MontadorInstrutorDto
                    .toInstrutor(instrutorService.obterInstrutorPorId(instrutorRequest.id()));
            especializacao.getInstrutores().add(instrutor);
        });

        return toEspecializacaoResponse(especializacaoRepository.save(especializacao));
    }

    public List<EspecializacaoResponse> obterEspecializacoes() {
        return toEspecializacoesResponse(especializacaoRepository.findAll());
    }

    public long countBootcamps() {
        return especializacaoRepository.count();
    }

    public EspecializacaoResponse obterEspecializacaoPorId(Integer id) {
        return toEspecializacaoResponse(
                especializacaoRepository.findById(id).orElseThrow(CursoNotFoundException::new));
    }

    public void excluir(Integer id) {
        obterEspecializacaoPorId(id);
        especializacaoRepository.deleteById(id);
    }
}
