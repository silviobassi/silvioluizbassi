package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.model.domain.Aluno;
import br.edu.infnet.silvioluizbassi.model.domain.Instrutor;
import br.edu.infnet.silvioluizbassi.model.domain.Pessoa;
import br.edu.infnet.silvioluizbassi.model.repository.AlunoRepository;
import br.edu.infnet.silvioluizbassi.model.repository.InstrutorRepository;
import br.edu.infnet.silvioluizbassi.model.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final AlunoRepository alunoRepository;
    private final InstrutorRepository instrutorRepository;


    public PessoaService(PessoaRepository pessoaRepository, AlunoRepository alunoRepository, InstrutorRepository instrutorRepository) {
        this.pessoaRepository = pessoaRepository;
        this.alunoRepository = alunoRepository;
        this.instrutorRepository = instrutorRepository;
    }

    public Pessoa adicionar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Aluno> obterListaAlunos() {
        return alunoRepository.findAll();
    }

    public List<Pessoa> obterListaPessoas() {
        return pessoaRepository.findAll();
    }

    public List<Instrutor> obterListaInstrutores() {
        return instrutorRepository.findAll();
    }
}
