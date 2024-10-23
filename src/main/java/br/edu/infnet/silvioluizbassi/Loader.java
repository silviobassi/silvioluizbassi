package br.edu.infnet.silvioluizbassi;

import br.edu.infnet.silvioluizbassi.model.domain.*;
import br.edu.infnet.silvioluizbassi.model.service.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class Loader implements ApplicationRunner {

    private final MatriculaService matriculaService;

    private final EnderecoService enderecoService;

    private final LocalizacaoService localizacaoService;

    private final PessoaService pessoaService;

    private final CursoService cursoService;

    public Loader(
            MatriculaService matriculaService,
            EnderecoService enderecoService,
            LocalizacaoService localizacaoService,
            PessoaService pessoaService, CursoService cursoService) {
        this.matriculaService = matriculaService;
        this.enderecoService = enderecoService;
        this.localizacaoService = localizacaoService;
        this.pessoaService = pessoaService;
        this.cursoService = cursoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/matriculas.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        Aluno aluno = null;
        Bootcamp bootcamp = null;
        Especializacao especializacao = null;
        Endereco endereco = null;
        Contato contato = null;

        while (line != null) {
            String[] campos = line.split(";");

            switch (campos[0].toUpperCase()) {
                case "M" -> {
                    Matricula matricula = new Matricula();
                    matricula.setNumeroDaMatricula(Long.parseLong(campos[1]));
                    matricula.setDataDaCompra(LocalDateTime.parse(campos[2]));
                    matricula.setAtiva(Boolean.parseBoolean(campos[3]));

                    Objects.requireNonNull(matricula).setAluno(aluno);

                    if (bootcamp != null) {
                        matricula.setCurso(bootcamp);
                        bootcamp = null;
                    }

                    if (especializacao != null) {
                        matricula.setCurso(especializacao);
                        especializacao = null;
                    }

                    matriculaService.adicionar(matricula);
                }
                case "BC" -> {
                    bootcamp = new Bootcamp();
                    bootcamp.setTitulo(campos[1]);
                    bootcamp.setDescricao(campos[2]);
                    bootcamp.setValor(Float.parseFloat(campos[3]));
                    bootcamp.setCargaHoraria(Integer.parseInt(campos[4]));
                    bootcamp.setPreRequisitos(campos[5]);
                    bootcamp.setEstagioObrigatorio(Boolean.parseBoolean(campos[6]));
                    bootcamp.setAtivo(Boolean.parseBoolean(campos[7]));
                    bootcamp.setTipoDeBootcamp(campos[8]);
                }
                case "EP" -> {
                    especializacao = new Especializacao();
                    especializacao.setTitulo(campos[1]);
                    especializacao.setDescricao(campos[2]);
                    especializacao.setValor(Float.parseFloat(campos[3]));
                    especializacao.setCargaHoraria(Integer.parseInt(campos[4]));
                    especializacao.setPreRequisitos(campos[5]);
                    especializacao.setEstagioObrigatorio(Boolean.parseBoolean(campos[6]));
                    especializacao.setAtivo(Boolean.parseBoolean(campos[7]));
                    especializacao.setNivelDeEspecializacao(campos[8]);
                }
                case "I" -> {

                    Instrutor instrutor = new Instrutor();
                    instrutor.setNome(campos[1]);
                    instrutor.setDataNascimento(LocalDateTime.parse(campos[2]));
                    instrutor.setGenero(Genero.valueOf(campos[3]));
                    instrutor.setFormacao(campos[4]);
                    instrutor.setEspecialidade(campos[5]);
                    instrutor.setEndereco(endereco);
                    instrutor.setContato(contato);

                    instrutor = (Instrutor) pessoaService.adicionar(instrutor);

                    if (especializacao != null) {
                        especializacao.getInstrutores().add(instrutor);
                        especializacao = (Especializacao) cursoService.adicionar(especializacao);
                    }

                    if (bootcamp != null) {
                        bootcamp.getInstrutores().add(instrutor);
                        bootcamp = (Bootcamp) cursoService.adicionar(bootcamp);
                    }
                }
                case "A" -> {
                    aluno = new Aluno();
                    aluno.setNome(campos[1]);
                    aluno.setDataNascimento(LocalDateTime.parse(campos[2]));
                    aluno.setGenero(Genero.valueOf(campos[3]));
                    aluno.setEndereco(endereco);
                    aluno.setContato(contato);

                    pessoaService.adicionar(aluno);
                }
                case "E" -> {
                    endereco = localizacaoService.findByCep(campos[7]);
                    endereco = enderecoService.adicionar(endereco);
                }
                case "CT" -> {
                    contato = new Contato();
                    contato.setEmail(campos[1]);
                    contato.setWhatsapp(campos[2]);
                }
                default -> System.out.println("Tipo de pessoa não identificado: " + campos[0]);

            }

            line = reader.readLine();
        }

        reader.close();

        for (Matricula matriculaAtual : matriculaService.obterMatriculas()) {
            System.out.printf("Matrícula: %s%n", matriculaAtual);
            System.out.printf("Instrutores: %s%n", matriculaAtual.getCurso().getInstrutores());
        }
    }
}