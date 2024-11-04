package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.Dtos.requests.MatriculaRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.MatriculaResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Aluno;
import br.edu.infnet.silvioluizbassi.model.domain.Curso;
import br.edu.infnet.silvioluizbassi.model.domain.Matricula;
import br.edu.infnet.silvioluizbassi.model.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorMatriculaResponse.*;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final PessoaService pessoaService;
    private final CursoService cursoService;

    public MatriculaService(MatriculaRepository matriculaRepository, PessoaService pessoaService, CursoService cursoService) {
        this.matriculaRepository = matriculaRepository;
        this.pessoaService = pessoaService;
        this.cursoService = cursoService;
    }

    public Matricula incluir(MatriculaRequest matriculaRequest) {

        Aluno aluno = pessoaService.obterAlunoPorId(matriculaRequest.aluno().id());
        Curso curso = cursoService.obterCursoPorId(matriculaRequest.curso().id());

        Matricula matricula = new Matricula();

        // Resolver a criação automática do número da matrícula
        matricula.setNumeroDaMatricula(28437248247L);
        matricula.setAluno(aluno);
        matricula.setCurso(curso);

        return matriculaRepository.save(matricula);
    }

    public Collection<MatriculaResponse> obterMatriculas() {
        return toMatriculasResponse(matriculaRepository.findAll());
    }

    public long countMatriculas() {
        return matriculaRepository.count();
    }
}
