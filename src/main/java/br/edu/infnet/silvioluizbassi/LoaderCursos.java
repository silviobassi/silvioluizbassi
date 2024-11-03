package br.edu.infnet.silvioluizbassi;

import br.edu.infnet.silvioluizbassi.model.domain.*;
import br.edu.infnet.silvioluizbassi.model.service.CursoService;
import br.edu.infnet.silvioluizbassi.model.service.PessoaService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

@Component
@Order(3)
public class LoaderCursos implements ApplicationRunner {

    private final PessoaService pessoaService;
    private final CursoService cursoService;

    public LoaderCursos(PessoaService pessoaService, CursoService cursoService) {
        this.pessoaService = pessoaService;
        this.cursoService = cursoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/cursos.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        List<Instrutor> instrutores = pessoaService.obterListaInstrutores();
        int countInstrutores = 0;

        while (line != null) {
            String[] campos = line.split(";");

            switch (campos[0].toUpperCase()) {
                case "BC" -> {
                    Bootcamp bootcamp = new Bootcamp();
                    bootcamp.setTitulo(campos[1]);
                    bootcamp.setDescricao(campos[2]);
                    bootcamp.setValor(Float.parseFloat(campos[3]));
                    bootcamp.setCargaHoraria(Integer.parseInt(campos[4]));
                    bootcamp.setPreRequisitos(campos[5]);
                    bootcamp.setEstagioObrigatorio(Boolean.parseBoolean(campos[6]));
                    bootcamp.setAtivo(Boolean.parseBoolean(campos[7]));
                    bootcamp.setTipoDeBootcamp(campos[8]);
                    bootcamp.setNivel(NivelBootcamp.valueOf(campos[9]));

                    bootcamp.getInstrutores().add(instrutores.get(countInstrutores));
                    cursoService.adicionar(bootcamp);
                    countInstrutores++;
                }
                case "EP" -> {
                    Especializacao especializacao = new Especializacao();
                    especializacao.setTitulo(campos[1]);
                    especializacao.setDescricao(campos[2]);
                    especializacao.setValor(Float.parseFloat(campos[3]));
                    especializacao.setCargaHoraria(Integer.parseInt(campos[4]));
                    especializacao.setPreRequisitos(campos[5]);
                    especializacao.setEstagioObrigatorio(Boolean.parseBoolean(campos[6]));
                    especializacao.setAtivo(Boolean.parseBoolean(campos[7]));
                    especializacao.setTipoDeEspecializacao(campos[8]);
                    especializacao.setEstagioObrigatorio(Boolean.parseBoolean(campos[9]));

                    especializacao.getInstrutores().add(instrutores.get(countInstrutores));
                    cursoService.adicionar(especializacao);
                    countInstrutores++;

                    cursoService.adicionar(especializacao);
                }
                default -> throw new Exception("❌ Não há cursos a serem carregados!");

            }

            line = reader.readLine();
        }

        reader.close();
    }
}