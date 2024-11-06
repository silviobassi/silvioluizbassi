package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.Dtos.requests.AlunoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.AlunoResponse;
import br.edu.infnet.silvioluizbassi.exceptions.AlunoNotFoundException;
import br.edu.infnet.silvioluizbassi.model.domain.Aluno;
import br.edu.infnet.silvioluizbassi.model.domain.Contato;
import br.edu.infnet.silvioluizbassi.model.domain.Endereco;
import br.edu.infnet.silvioluizbassi.model.repository.AlunoRepository;
import br.edu.infnet.silvioluizbassi.model.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorAlunoDto.toAlunoResponse;
import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorAlunoDto.toAlunosResponse;

@Service
public class AlunoService {

    private final PessoaRepository pessoaRepository;
    private final AlunoRepository alunoRepository;
    private final LocalizacaoService localizacaoService;
    private final EnderecoService enderecoService;

    public AlunoService(PessoaRepository pessoaRepository, AlunoRepository alunoRepository,
                        LocalizacaoService localizacaoService, EnderecoService enderecoService) {
        this.pessoaRepository = pessoaRepository;
        this.alunoRepository = alunoRepository;
        this.localizacaoService = localizacaoService;
        this.enderecoService = enderecoService;
    }

    public AlunoResponse incluir(AlunoRequest alunoRequest) {
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

    public long countAlunos() {
        return alunoRepository.count();
    }

    public long countPessoas() {
        return pessoaRepository.count();
    }

    public AlunoResponse obterAlunoPorId(Integer id) {
        return toAlunoResponse(alunoRepository.findById(id).orElseThrow(AlunoNotFoundException::new));
    }

    public void excluirAlunoPorId(Integer id) {
        obterAlunoPorId(id);
        alunoRepository.deleteById(id);
    }
}
