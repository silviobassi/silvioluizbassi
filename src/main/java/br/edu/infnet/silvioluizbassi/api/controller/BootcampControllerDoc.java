package br.edu.infnet.silvioluizbassi.api.controller;

import br.edu.infnet.silvioluizbassi.Dtos.requests.BootcampRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.BootcampResponse;
import br.edu.infnet.silvioluizbassi.api.openapi.BootcampControllerDocApi;
import br.edu.infnet.silvioluizbassi.model.service.BootcampService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bootcamps")
public class BootcampControllerDoc implements BootcampControllerDocApi {

    private final BootcampService bootcampService;

    public BootcampControllerDoc(BootcampService bootcampService) {
        this.bootcampService = bootcampService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/lista")
    public List<BootcampResponse> listarBootcamps() {
        return bootcampService.obterBootcamps();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/criar_bootcamp")
    public BootcampResponse incluirBootcamp(@RequestBody BootcampRequest bootcampRequest) {
        return bootcampService.incluir(bootcampRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/buscar")
    public BootcampResponse obterBootcampPorId(@PathVariable Integer id) {
        return bootcampService.obterBootcampPorId(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}/excluir_bootcamp")
    public void excluirBootcampPorId(@PathVariable Integer id) {
        bootcampService.excluir(id);
    }
}
