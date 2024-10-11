package br.edu.infnet.silvioluizbassi;

import br.edu.infnet.silvioluizbassi.model.domain.*;
import br.edu.infnet.silvioluizbassi.model.service.MatriculaService;
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

    public Loader(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/matriculas.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        Matricula matricula = null;
        Aluno aluno = null;
        Instrutor instrutor = null;
        Bootcamp bootcamp = null;
        Especializacao especializacao = null;

        while (line != null) {
            String[] campos = line.split(";");

            switch (campos[0].toUpperCase()) {
                case "M":
                    matricula = new Matricula();
                    matricula.setNumeroDaMatricula(Long.parseLong(campos[1]));
                    matricula.setDataDaCompra(LocalDateTime.parse(campos[2]));
                    matricula.setAtiva(Boolean.parseBoolean(campos[3]));

                    matriculaService.adicionar(matricula);
                    break;
                case "BC":
                    bootcamp = new Bootcamp();
                    bootcamp.setTitulo(campos[1]);
                    bootcamp.setDescricao(campos[2]);
                    bootcamp.setValor(Float.parseFloat(campos[3]));
                    bootcamp.setCargaHoraria(Integer.parseInt(campos[4]));
                    bootcamp.setPreRequisitos(campos[5]);
                    bootcamp.setEstagioObrigatorio(Boolean.parseBoolean(campos[6]));
                    bootcamp.setAtivo(Boolean.parseBoolean(campos[7]));
                    bootcamp.setTipoDeBootcamp(campos[8]);

                    Objects.requireNonNull(matricula).setCurso(bootcamp);
                    break;
                case "EP":
                    especializacao = new Especializacao();
                    especializacao.setTitulo(campos[1]);
                    especializacao.setDescricao(campos[2]);
                    especializacao.setValor(Float.parseFloat(campos[3]));
                    especializacao.setCargaHoraria(Integer.parseInt(campos[4]));
                    especializacao.setPreRequisitos(campos[5]);
                    especializacao.setEstagioObrigatorio(Boolean.parseBoolean(campos[6]));
                    especializacao.setAtivo(Boolean.parseBoolean(campos[7]));
                    especializacao.setNivelDeEspecializacao(campos[8]);

                    Objects.requireNonNull(matricula).setCurso(especializacao);
                    break;
                case "I":
                    instrutor = new Instrutor();
                    instrutor.setNome(campos[1]);
                    instrutor.setDataNascimento(LocalDateTime.parse(campos[2]));
                    instrutor.setGenero(Genero.valueOf(campos[3]));
                    instrutor.setFormacao(campos[4]);
                    instrutor.setEspecialidade(campos[5]);

                    if (bootcamp != null) {
                        bootcamp.getInstrutores().add(instrutor);
                    }
                    if (especializacao != null) {
                        especializacao.getInstrutores().add(instrutor);
                    }
                    break;
                case "A":
                    aluno = new Aluno();
                    aluno.setNome(campos[1]);
                    aluno.setDataNascimento(LocalDateTime.parse(campos[2]));
                    aluno.setGenero(Genero.valueOf(campos[3]));

                    Objects.requireNonNull(matricula).setAluno(aluno);
                    break;
                case "E":
                    Endereco endereco = new Endereco();
                    endereco.setLogradouro(campos[1]);
                    endereco.setNumero(campos[2]);
                    endereco.setComplemento(campos[3]);
                    endereco.setBairro(campos[4]);
                    endereco.setCidade(campos[5]);
                    endereco.setEstado(campos[6]);
                    endereco.setCep(campos[7]);

                    if (aluno != null) {
                        aluno.setEndereco(endereco);
                    }
                    if (instrutor != null) {
                        instrutor.setEndereco(endereco);
                    }
                    break;
                case "CT":
                    Contato contato = new Contato();
                    contato.setEmail(campos[1]);
                    contato.setWhatsapp(campos[2]);

                    if (instrutor != null) {
                        instrutor.setContato(contato);
                    }
                    if (aluno != null) {
                        aluno.setContato(contato);
                    }
                    break;
                default:
                    System.out.println("Tipo de pessoa não identificado: " + campos[0]);
                    break;
            }

            line = reader.readLine();
        }

        reader.close();

        for (Matricula matriculaAtual : matriculaService.obterMatriculas()) {
            System.out.printf("Matrícula: %s%n", matriculaAtual);
            System.out.printf("Instrutor: %s%n", matriculaAtual.getCurso().getInstrutores());
        }
    }
}