package br.edu.infnet.silvioluizbassi;

import br.edu.infnet.silvioluizbassi.model.domain.*;
import br.edu.infnet.silvioluizbassi.model.service.*;
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
@Order(2)
public class LoaderPessoas implements ApplicationRunner {

    private final EnderecoService enderecoService;

    private final PessoaService pessoaService;

    public LoaderPessoas(EnderecoService enderecoService, PessoaService pessoaService) {
        this.enderecoService = enderecoService;
        this.pessoaService = pessoaService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/pessoas.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        Contato contato = null;

        List<Endereco> enderecos = enderecoService.obterEnderecos();
        int countEnderecos = 0;

        while (line != null) {
            String[] campos = line.split(";");

            switch (campos[0].toUpperCase()) {
                case "I" -> {

                    Instrutor instrutor = new Instrutor();
                    instrutor.setNome(campos[1]);
                    instrutor.setDataNascimento(LocalDateTime.parse(campos[2]));
                    instrutor.setGenero(Genero.valueOf(campos[3]));
                    instrutor.setFormacao(campos[4]);
                    instrutor.setEspecialidade(campos[5]);
                    instrutor.setContato(contato);

                    instrutor.setEndereco(enderecos.get(countEnderecos));

                    pessoaService.adicionar(instrutor);

                    countEnderecos++;
                }
                case "A" -> {

                    Aluno aluno = new Aluno();
                    aluno.setNome(campos[1]);
                    aluno.setDataNascimento(LocalDateTime.parse(campos[2]));
                    aluno.setGenero(Genero.valueOf(campos[3]));
                    aluno.setBolsista(Boolean.parseBoolean(campos[4]));
                    aluno.setEnem(Boolean.parseBoolean(campos[5]));

                    aluno.setEndereco(enderecos.get(countEnderecos));
                    aluno.setContato(contato);

                    pessoaService.adicionar(aluno);

                    countEnderecos++;
                }
                case "CT" -> {
                    contato = new Contato();
                    contato.setEmail(campos[1]);
                    contato.setWhatsapp(campos[2]);
                }
                default -> throw new Exception("❌ Não há pessoas a serem carregados!");

            }

            line = reader.readLine();
        }

        reader.close();

    }
}