package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.exceptions.AlunoNotFoundException;
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

    public Pessoa incluir(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Aluno> obterAlunos() {
        return alunoRepository.findAll();
    }

    public List<Pessoa> obterPessoas() {
        return pessoaRepository.findAll();
    }

    public List<Instrutor> obterInstrutores() {
        return instrutorRepository.findAll();
    }

    public long countAlunos() {
        return alunoRepository.count();
    }

    public long countInstrutores() {
        return instrutorRepository.count();
    }

    public long countPessoas() {
        return pessoaRepository.count();
    }

    public Aluno obterAlunoPorId(Integer id) {
        return alunoRepository.findById(id).orElseThrow(AlunoNotFoundException::new);
    }
}
