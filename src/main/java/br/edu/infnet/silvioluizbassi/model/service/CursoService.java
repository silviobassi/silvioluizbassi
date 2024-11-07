package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorCursoDto;
import br.edu.infnet.silvioluizbassi.Dtos.responses.CursoResponse;
import br.edu.infnet.silvioluizbassi.exceptions.CursoNotFoundException;
import br.edu.infnet.silvioluizbassi.model.domain.Curso;
import br.edu.infnet.silvioluizbassi.model.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<CursoResponse> obterCursos() {
        return MontadorCursoDto.toCursosResponse(cursoRepository.findAll());
    }

    public Curso obterCursoPorId(Integer id) {
        return cursoRepository.findById(id).orElseThrow(CursoNotFoundException::new);
    }
}
