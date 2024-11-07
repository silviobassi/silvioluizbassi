package br.edu.infnet.silvioluizbassi.api.controller;

import br.edu.infnet.silvioluizbassi.Dtos.requests.EspecializacaoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.EspecializacaoResponse;
import br.edu.infnet.silvioluizbassi.api.openapi.EspecializacaoControllerApi;
import br.edu.infnet.silvioluizbassi.model.service.EspecializacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especializacoes")
public class EspecializacaoController implements EspecializacaoControllerApi {

    private final EspecializacaoService especializacaoService;

    public EspecializacaoController(EspecializacaoService especializacaoService) {
        this.especializacaoService = especializacaoService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/lista")
    public List<EspecializacaoResponse> listarEspecializacoes() {
        return especializacaoService.obterEspecializacoes();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/criar_especializacao")
    public EspecializacaoResponse incluirEspecializacao(@RequestBody EspecializacaoRequest especializacaoRequest) {
        return especializacaoService.incluir(especializacaoRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/buscar")
    public EspecializacaoResponse obterEspecializacaoPorId(@PathVariable Integer id) {
        return especializacaoService.obterEspecializacaoPorId(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}/excluir_especializacao")
    public void excluirEspecializacaoPorId(@PathVariable Integer id) {
        especializacaoService.excluir(id);
    }
}
