package br.edu.infnet.silvioluizbassi.controller;

import br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorMatriculaResponse;
import br.edu.infnet.silvioluizbassi.Dtos.requests.MatriculaRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.MatriculaResponse;
import br.edu.infnet.silvioluizbassi.model.service.MatriculaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorMatriculaResponse.toMatriculaResponse;

@RestController
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping(value = "/lista/matriculas")
    public Collection<MatriculaResponse> listarMatriculas() {
        return matriculaService.obterMatriculas();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/criar_matricula")
    public MatriculaResponse criarMatricula(@RequestBody MatriculaRequest matriculaRequest) {
        matriculaService.incluir(matriculaRequest);
        return toMatriculaResponse(matriculaService.incluir(matriculaRequest));
    }
}
