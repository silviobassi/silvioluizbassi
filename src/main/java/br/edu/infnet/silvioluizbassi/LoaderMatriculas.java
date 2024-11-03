package br.edu.infnet.silvioluizbassi;

import br.edu.infnet.silvioluizbassi.model.domain.Aluno;
import br.edu.infnet.silvioluizbassi.model.domain.Curso;
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
import java.util.List;
import java.util.Objects;

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

        List<Aluno> alunos = pessoaService.obterAlunos();
        List<Curso> cursos = cursoService.obterCursos();

        int countAlunos = 0;
        int countCursos = 0;

        while (line != null) {
            String[] campos = line.split(";");

            if (!campos[0].equalsIgnoreCase("M")) throw new Exception("❌ Não há matrículas a serem carregadas!");

            Matricula matricula = new Matricula();
            matricula.setNumeroDaMatricula(Long.parseLong(campos[1]));
            matricula.setDataDaCompra(LocalDateTime.parse(campos[2]));
            matricula.setAtiva(Boolean.parseBoolean(campos[3]));

            Objects.requireNonNull(matricula).setAluno(alunos.get(countAlunos));

            matricula.setCurso(cursos.get(countCursos));

            countAlunos++;
            countCursos++;

            matriculaService.incluir(matricula);
            line = reader.readLine();

        }
        reader.close();
    }
}