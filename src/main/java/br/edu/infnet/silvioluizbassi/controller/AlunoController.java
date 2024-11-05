package br.edu.infnet.silvioluizbassi.controller;

import br.edu.infnet.silvioluizbassi.Dtos.requests.AlunoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.AlunoResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Aluno;
import br.edu.infnet.silvioluizbassi.model.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlunoController {

    private final PessoaService pessoaService;

    public AlunoController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping(value = "/lista/alunos")
    public List<Aluno> listarAlunos() {
        return pessoaService.obterAlunos();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/criar_aluno")
    public AlunoResponse criarAluno(@RequestBody AlunoRequest alunoRequest) {
        return pessoaService.incluirAluno(alunoRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}/obter_aluno")
    public Aluno obterAlunoPorId(@PathVariable Integer id) {
        return pessoaService.obterAlunoPorId(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}/excluir_aluno")
    public void excluirAlunoPorId(@PathVariable Integer id) {
        pessoaService.excluirAlunoPorId(id);
    }

}
