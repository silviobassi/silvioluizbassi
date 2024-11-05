package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto;
import br.edu.infnet.silvioluizbassi.Dtos.requests.AlunoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.InstrutorRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.AlunoResponse;
import br.edu.infnet.silvioluizbassi.Dtos.responses.InstrutorResponse;
import br.edu.infnet.silvioluizbassi.exceptions.AlunoNotFoundException;
import br.edu.infnet.silvioluizbassi.exceptions.InstrutorNotFoundException;
import br.edu.infnet.silvioluizbassi.model.domain.*;
import br.edu.infnet.silvioluizbassi.model.repository.AlunoRepository;
import br.edu.infnet.silvioluizbassi.model.repository.InstrutorRepository;
import br.edu.infnet.silvioluizbassi.model.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorAlunoDto.toAlunoResponse;
import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorAlunoDto.toAlunosResponse;
import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto.*;
import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto.toInstrutorResponse;
import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto.toInstrutoresResponse;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final AlunoRepository alunoRepository;
    private final InstrutorRepository instrutorRepository;
    private final LocalizacaoService localizacaoService;
    private final EnderecoService enderecoService;

    public PessoaService(PessoaRepository pessoaRepository, AlunoRepository alunoRepository, InstrutorRepository instrutorRepository, LocalizacaoService localizacaoService, EnderecoService enderecoService) {
        this.pessoaRepository = pessoaRepository;
        this.alunoRepository = alunoRepository;
        this.instrutorRepository = instrutorRepository;
        this.localizacaoService = localizacaoService;
        this.enderecoService = enderecoService;
    }

    public InstrutorResponse incluirInstrutor(InstrutorRequest instrutorRequest) {
        Endereco endereco = localizacaoService.findByCep(instrutorRequest.cep());
        endereco = enderecoService.incluir(endereco);

        Contato contato = new Contato();
        contato.setEmail(instrutorRequest.email());
        contato.setWhatsApp(instrutorRequest.whatsApp());

        Instrutor instrutor = new Instrutor();
        instrutor.setNome(instrutorRequest.nome());
        instrutor.setContato(contato);
        instrutor.setDataNascimento(instrutorRequest.dataNascimento());
        instrutor.setGenero(instrutorRequest.genero());
        instrutor.setFormacao(instrutorRequest.formacao());
        instrutor.setEspecialidade(instrutorRequest.especialidade());

        instrutor.setEndereco(endereco);
        return toInstrutorResponse(pessoaRepository.save(instrutor));
    }

    public AlunoResponse incluirAluno(AlunoRequest alunoRequest) {
        Endereco endereco = localizacaoService.findByCep(alunoRequest.cep());
        endereco = enderecoService.incluir(endereco);

        Contato contato = new Contato();
        contato.setEmail(alunoRequest.email());
        contato.setWhatsApp(alunoRequest.whatsApp());

        Aluno aluno = new Aluno();
        aluno.setNome(alunoRequest.nome());
        aluno.setContato(contato);
        aluno.setDataNascimento(alunoRequest.dataNascimento());
        aluno.setGenero(alunoRequest.genero());
        aluno.setBolsista(alunoRequest.isBolsista());
        aluno.setEnem(alunoRequest.isEnem());

        aluno.setEndereco(endereco);
        return toAlunoResponse(pessoaRepository.save(aluno));
    }

    public List<AlunoResponse> obterAlunos() {
        return toAlunosResponse(alunoRepository.findAll());
    }

    public List<Pessoa> obterPessoas() {
        return pessoaRepository.findAll();
    }

    public List<InstrutorResponse> obterInstrutores() {
        return toInstrutoresResponse(instrutorRepository.findAll());
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

    public AlunoResponse obterAlunoPorId(Integer id) {
        return toAlunoResponse(alunoRepository.findById(id).orElseThrow(AlunoNotFoundException::new));
    }

    public InstrutorResponse obterInstrutorPorId(Integer id) {
        return toInstrutorResponse(instrutorRepository.findById(id).orElseThrow(InstrutorNotFoundException::new));
    }

    public void excluirInstrutorPorId(Integer id) {
        obterInstrutorPorId(id);
        instrutorRepository.deleteById(id);
    }

    public void excluirAlunoPorId(Integer id) {
        obterAlunoPorId(id);
        alunoRepository.deleteById(id);
    }
}
