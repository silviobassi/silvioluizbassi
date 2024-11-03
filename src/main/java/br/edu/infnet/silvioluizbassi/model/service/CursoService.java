package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.model.domain.Bootcamp;
import br.edu.infnet.silvioluizbassi.model.domain.Curso;
import br.edu.infnet.silvioluizbassi.model.domain.Especializacao;
import br.edu.infnet.silvioluizbassi.model.repository.BootcampRepository;
import br.edu.infnet.silvioluizbassi.model.repository.CursoRepository;
import br.edu.infnet.silvioluizbassi.model.repository.EspecializacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final EspecializacaoRepository especializacaoRepository;
    private final BootcampRepository bootcampRepository;

    public CursoService(CursoRepository cursoRepository, EspecializacaoRepository especializacaoRepository, BootcampRepository bootcampRepository) {
        this.cursoRepository = cursoRepository;
        this.especializacaoRepository = especializacaoRepository;
        this.bootcampRepository = bootcampRepository;
    }

    public Curso incluir(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> obterCursos() {
        return cursoRepository.findAll();
    }

    public List<Especializacao> obterEspecializacoes() {
        return especializacaoRepository.findAll();
    }

    public List<Bootcamp> obterBootcamps() {
        return bootcampRepository.findAll();
    }
}
