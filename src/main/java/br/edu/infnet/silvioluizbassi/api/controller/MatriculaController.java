package br.edu.infnet.silvioluizbassi.api.controller;

import br.edu.infnet.silvioluizbassi.Dtos.requests.MatriculaRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.MatriculaResponse;
import br.edu.infnet.silvioluizbassi.model.service.MatriculaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Matrícula", description = "Endpoints para gestão de matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping(value = "/lista/matriculas")
    public List<MatriculaResponse> listarMatriculas() {
        return matriculaService.obterMatriculas();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/criar_matricula")
    public MatriculaResponse criarMatricula(@RequestBody MatriculaRequest matriculaRequest) {
        return matriculaService.incluir(matriculaRequest);
    }
}
