package br.edu.infnet.silvioluizbassi.controller;

import br.edu.infnet.silvioluizbassi.Dtos.requests.InstrutorRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.InstrutorResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Aluno;
import br.edu.infnet.silvioluizbassi.model.domain.Endereco;
import br.edu.infnet.silvioluizbassi.model.domain.Instrutor;
import br.edu.infnet.silvioluizbassi.model.service.EnderecoService;
import br.edu.infnet.silvioluizbassi.model.service.LocalizacaoService;
import br.edu.infnet.silvioluizbassi.model.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstrutorController {

    private final PessoaService pessoaService;
    private final LocalizacaoService localizacaoService;
    private final EnderecoService enderecoService;

    public InstrutorController(PessoaService pessoaService, LocalizacaoService localizacaoService, EnderecoService enderecoService) {
        this.pessoaService = pessoaService;
        this.localizacaoService = localizacaoService;
        this.enderecoService = enderecoService;
    }

    @GetMapping(value = "/lista/instrutores")
    public List<InstrutorResponse> listarInstrutores() {
        return pessoaService.obterInstrutores();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/criar_instrutor")
    public InstrutorResponse criarInstrutor(@RequestBody InstrutorRequest instrutorRequest) {
        return pessoaService.incluirInstrutor(instrutorRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}/obter_instrutor")
    public Instrutor obterInstrutorPorId(@PathVariable Integer id) {
        return pessoaService.obterInstrutorPorId(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}/excluir_instrutor")
    public void excluirInstrutorPorId(@PathVariable Integer id) {
        pessoaService.excluirInstrutorPorId(id);
    }
}