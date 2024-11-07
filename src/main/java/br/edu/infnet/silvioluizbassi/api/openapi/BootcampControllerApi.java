package br.edu.infnet.silvioluizbassi.api.openapi;

import br.edu.infnet.silvioluizbassi.Dtos.requests.BootcampRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.BootcampResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Bootcamp", description = "API de Bootcamps")
public interface BootcampControllerApi {


    @Operation(summary = "Lista todos os bootcamps", responses = {
            @ApiResponse(responseCode = "200", description = "Bootcamps listados")
    })
    List<BootcampResponse> listarBootcamps();

    @Operation(summary = "Inclui um novo bootcamp", responses = {
            @ApiResponse(responseCode = "201", description = "Bootcamp incluído")
    })
    BootcampResponse incluirBootcamp(BootcampRequest bootcampRequest);

    @Operation(summary = "Busca um bootcamp pelo ID", responses = {
            @ApiResponse(responseCode = "200", description = "Curso encontrado"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class)))
    })
    public BootcampResponse obterBootcampPorId(@Parameter(description = "ID de um Bootcamp") Integer id);

    @Operation(summary = "Excluí um bootcamp pelo ID", responses = {
            @ApiResponse(responseCode = "204", description = "Bootcamp excluído"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class)))
    })
    void excluirBootcampPorId(@Parameter(description = "ID de um Bootcamp") Integer id);
}
