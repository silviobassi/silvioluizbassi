package br.edu.infnet.silvioluizbassi.api.controller;

import br.edu.infnet.silvioluizbassi.Dtos.requests.InstrutorRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.InstrutorResponse;
import br.edu.infnet.silvioluizbassi.model.service.InstrutorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstrutorController {

    private final InstrutorService instrutorService;

    public InstrutorController(InstrutorService instrutorService) {
        this.instrutorService = instrutorService;
    }

    @GetMapping(value = "/lista/instrutores")
    public List<InstrutorResponse> listarInstrutores() {
        return instrutorService.obterInstrutores();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/criar_instrutor")
    public InstrutorResponse criarInstrutor(@RequestBody InstrutorRequest instrutorRequest) {
        return instrutorService.incluir(instrutorRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}/obter_instrutor")
    public InstrutorResponse obterInstrutorPorId(@PathVariable Integer id) {
        return instrutorService.obterInstrutorPorId(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}/excluir_instrutor")
    public void excluirInstrutorPorId(@PathVariable Integer id) {
        instrutorService.excluirInstrutorPorId(id);
    }
}
