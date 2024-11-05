package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.Dtos.requests.MatriculaRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.MatriculaResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Aluno;
import br.edu.infnet.silvioluizbassi.model.domain.Curso;
import br.edu.infnet.silvioluizbassi.model.domain.Matricula;
import br.edu.infnet.silvioluizbassi.model.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorMatriculaDto.toMatriculaResponse;
import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorMatriculaDto.toMatriculasResponse;

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

    public MatriculaResponse incluir(MatriculaRequest matriculaRequest) {
        Curso curso = cursoService.obterCursoPorId(matriculaRequest.curso().id());
        Aluno aluno = pessoaService.obterAlunoPorId(matriculaRequest.aluno().id());
        Matricula matricula = new Matricula();
        matricula.setNumeroDaMatricula(matriculaRequest.numeroMatricula());
        matricula.setCurso(curso);
        matricula.setAluno(aluno);
        return toMatriculaResponse(matriculaRepository.save(matricula));
    }

    public List<MatriculaResponse> obterMatriculas() {
        return toMatriculasResponse(matriculaRepository.findAll());
    }

    public long countMatriculas() {
        return matriculaRepository.count();
    }
}
