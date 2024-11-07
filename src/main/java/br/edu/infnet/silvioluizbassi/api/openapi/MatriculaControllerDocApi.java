package br.edu.infnet.silvioluizbassi.api.openapi;

import br.edu.infnet.silvioluizbassi.Dtos.requests.MatriculaRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.MatriculaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Matrícula", description = "Endpoints de Matriculas")
public interface MatriculaControllerDocApi {

    @Operation(summary = "Lista todas as matrículas", responses = {
            @ApiResponse(responseCode = "200", description = "Matrículas listadas")
    })
    List<MatriculaResponse> listarMatriculas();

    @Operation(summary = "Inclui uma nova matrícula", responses = {
            @ApiResponse(responseCode = "201", description = "Matrícula incluída")
    })
    MatriculaResponse criarMatricula(MatriculaRequest matriculaRequest);

    @Operation(summary = "Busca uma matrícula pelo id", responses = {
            @ApiResponse(responseCode = "200", description = "Matrícula encontrada"),
            @ApiResponse(responseCode = "404", description = "Matrícula não encontrada")
    })
    MatriculaResponse buscarMatricula(@Parameter(description = "ID da Matrícula") Integer id);

    @Operation(summary = "Exclui uma matrícula pelo id", responses = {
            @ApiResponse(responseCode = "204", description = "Matrícula excluída"),
            @ApiResponse(responseCode = "404", description = "Matrícula não encontrada")
    })
    void excluirMatricula(@Parameter(description = "ID da Matrícula") Integer id);
}
