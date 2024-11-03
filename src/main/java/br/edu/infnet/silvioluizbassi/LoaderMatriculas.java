package br.edu.infnet.silvioluizbassi;

import br.edu.infnet.silvioluizbassi.Dtos.requests.AlunoRequestId;
import br.edu.infnet.silvioluizbassi.Dtos.requests.CursoRequestId;
import br.edu.infnet.silvioluizbassi.Dtos.requests.MatriculaRequest;
import br.edu.infnet.silvioluizbassi.model.domain.Matricula;
import br.edu.infnet.silvioluizbassi.model.service.CursoService;
import br.edu.infnet.silvioluizbassi.model.service.MatriculaService;
import br.edu.infnet.silvioluizbassi.model.service.PessoaService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;

@Component
@Order(4)
public class LoaderMatriculas implements ApplicationRunner {

    private final PessoaService pessoaService;
    private final MatriculaService matriculaService;
    private final CursoService cursoService;

    public LoaderMatriculas(PessoaService pessoaService, MatriculaService matriculaService, CursoService cursoService) {
        this.pessoaService = pessoaService;
        this.matriculaService = matriculaService;
        this.cursoService = cursoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/matriculas.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        int countAlunos = (int) pessoaService.countAlunos();
        int countCursos = (int) cursoService.countCursos();

        while (line != null) {
            String[] campos = line.split(";");

            if (!campos[0].equalsIgnoreCase("M")) throw new Exception("❌ Não há matrículas a serem carregadas!");

            Matricula matricula = new Matricula();
            matricula.setNumeroDaMatricula(Long.parseLong(campos[1]));
            matricula.setDataMatricula(LocalDateTime.parse(campos[2]));
            matricula.setAtiva(Boolean.parseBoolean(campos[3]));


            MatriculaRequest matriculaRequest = new MatriculaRequest(
                    new AlunoRequestId(countAlunos),
                    new CursoRequestId(countCursos)
            );

            matriculaService.incluir(matriculaRequest);

            countAlunos--;
            countCursos--;

            line = reader.readLine();

        }
        reader.close();
    }
}