package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorMatriculaResponse;
import br.edu.infnet.silvioluizbassi.Dtos.responses.MatriculaResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Matricula;
import br.edu.infnet.silvioluizbassi.model.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorMatriculaResponse.*;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public Matricula incluir(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public Collection<MatriculaResponse> obterMatriculas() {
        return toMatriculasResponse(matriculaRepository.findAll());
    }

    public long countMatriculas() {
        return matriculaRepository.count();
    }
}
