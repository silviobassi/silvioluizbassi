package br.edu.infnet.silvioluizbassi.api.controller;

import br.edu.infnet.silvioluizbassi.Dtos.requests.AlunoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateAlunoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.AlunoResponse;
import br.edu.infnet.silvioluizbassi.api.openapi.AlunoControllerDocApi;
import br.edu.infnet.silvioluizbassi.model.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController implements AlunoControllerDocApi {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping(value = "/lista")
    public List<AlunoResponse> listarAlunos() {
        return alunoService.obterAlunos();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/criar_aluno")
    public AlunoResponse criarAluno(@RequestBody AlunoRequest alunoRequest) {
        return alunoService.incluir(alunoRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/atualizar_aluno")
    public AlunoResponse atualizarAluno(@RequestBody UpdateAlunoRequest updateAlunoRequest) {
        return alunoService.atualizar(updateAlunoRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}/obter_aluno")
    public AlunoResponse obterAlunoPorId(@PathVariable Integer id) {
        return alunoService.obterAlunoPorId(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}/excluir_aluno")
    public void excluirAlunoPorId(@PathVariable Integer id) {
        alunoService.excluirAlunoPorId(id);
    }

}
