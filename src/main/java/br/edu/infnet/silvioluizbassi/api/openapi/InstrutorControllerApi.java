package br.edu.infnet.silvioluizbassi.api.openapi;

import br.edu.infnet.silvioluizbassi.Dtos.requests.InstrutorRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.InstrutorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Instrutor", description = "API de Instrutores")
public interface InstrutorControllerApi {

    @Operation(summary = "Cria uma nova tarefa", responses = {
            @ApiResponse(responseCode = "201", description = "Instrutor criado"),
    })
    InstrutorResponse criarInstrutor(@RequestBody InstrutorRequest instrutorRequest);

    @Operation(summary = "Busca um instrutor pelo ID", responses = {
            @ApiResponse(responseCode = "200", description = "Instrutor encontrado"),
            @ApiResponse(responseCode = "404", description = "Instrutor não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class)))
    })
    InstrutorResponse obterInstrutorPorId(@PathVariable Integer id);
}
