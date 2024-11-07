package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorBootcampDto;
import br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto;
import br.edu.infnet.silvioluizbassi.Dtos.requests.BootcampRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.BootcampResponse;
import br.edu.infnet.silvioluizbassi.exceptions.CursoNotFoundException;
import br.edu.infnet.silvioluizbassi.model.domain.Bootcamp;
import br.edu.infnet.silvioluizbassi.model.domain.Instrutor;
import br.edu.infnet.silvioluizbassi.model.repository.BootcampRepository;
import br.edu.infnet.silvioluizbassi.model.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorBootcampDto.toBootcampResponse;
import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorBootcampDto.toBootcampsResponse;

@Service
public class BootcampService {

    private final CursoRepository cursoRepository;
    private final BootcampRepository bootcampRepository;
    private final InstrutorService instrutorService;

    public BootcampService(CursoRepository cursoRepository, BootcampRepository bootcampRepository, InstrutorService instrutorService) {
        this.cursoRepository = cursoRepository;
        this.bootcampRepository = bootcampRepository;
        this.instrutorService = instrutorService;
    }

    public BootcampResponse incluir(BootcampRequest bootcampRequest) {
        Bootcamp bootcamp = MontadorBootcampDto.toBootcamp(bootcampRequest);

        bootcampRequest.instrutores().forEach(instrutorRequest -> {
            Instrutor instrutor = MontadorInstrutorDto
                    .toInstrutor(instrutorService.obterInstrutorPorId(instrutorRequest.id()));
            bootcamp.getInstrutores().add(instrutor);
        });

        return toBootcampResponse(cursoRepository.save(bootcamp));
    }

    public List<BootcampResponse> obterBootcamps() {
        return toBootcampsResponse(bootcampRepository.findAll());
    }

    public long countBootcamps() {
        return bootcampRepository.count();
    }

    public BootcampResponse obterBootcampPorId(Integer id) {
        return toBootcampResponse(bootcampRepository.findById(id).orElseThrow(CursoNotFoundException::new));
    }

    public void excluir(Integer id) {
        obterBootcampPorId(id);
        bootcampRepository.deleteById(id);
    }
}
