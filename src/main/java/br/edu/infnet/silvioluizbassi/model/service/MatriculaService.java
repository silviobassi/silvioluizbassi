package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.model.domain.Matricula;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class MatriculaService {
    private final Map<Long, Matricula> mapaMatriculas = new HashMap<>();

    public void adicionar(Matricula matricula) {
        mapaMatriculas.put(matricula.getNumeroDaMatricula(), matricula);
    }

    public Collection<Matricula> obterMatriculas() {
        return mapaMatriculas.values();
    }
}
