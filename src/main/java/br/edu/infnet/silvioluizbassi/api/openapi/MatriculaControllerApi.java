package br.edu.infnet.silvioluizbassi.api.openapi;

import br.edu.infnet.silvioluizbassi.Dtos.requests.MatriculaRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.MatriculaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Matrícula", description = "Endpoints de Matriculas")
public interface MatriculaControllerApi {

    @Operation(summary = "Lista todas as matrículas", responses = {
            @ApiResponse(responseCode = "200", description = "Matrículas listadas")
    })
    List<MatriculaResponse> listarMatriculas();

    @Operation(summary = "Inclui uma nova matrícula", responses = {
            @ApiResponse(responseCode = "201", description = "Matrícula incluída")
    })
    MatriculaResponse criarMatricula(@RequestBody MatriculaRequest matriculaRequest);
}
