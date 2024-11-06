package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.Dtos.requests.InstrutorRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.InstrutorResponse;
import br.edu.infnet.silvioluizbassi.exceptions.InstrutorNotFoundException;
import br.edu.infnet.silvioluizbassi.model.domain.Contato;
import br.edu.infnet.silvioluizbassi.model.domain.Endereco;
import br.edu.infnet.silvioluizbassi.model.domain.Instrutor;
import br.edu.infnet.silvioluizbassi.model.repository.InstrutorRepository;
import br.edu.infnet.silvioluizbassi.model.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto.toInstrutorResponse;
import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto.toInstrutoresResponse;

@Service
public class InstrutorService {

    private final PessoaRepository pessoaRepository;
    private final InstrutorRepository instrutorRepository;
    private final LocalizacaoService localizacaoService;
    private final EnderecoService enderecoService;

    public InstrutorService(PessoaRepository pessoaRepository, InstrutorRepository instrutorRepository,
                            LocalizacaoService localizacaoService, EnderecoService enderecoService) {
        this.pessoaRepository = pessoaRepository;
        this.instrutorRepository = instrutorRepository;
        this.localizacaoService = localizacaoService;
        this.enderecoService = enderecoService;

    }

    public InstrutorResponse incluir(InstrutorRequest instrutorRequest) {
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

    public List<InstrutorResponse> obterInstrutores() {
        return toInstrutoresResponse(instrutorRepository.findAll());
    }

    public long countInstrutores() {
        return instrutorRepository.count();
    }

    public InstrutorResponse obterInstrutorPorId(Integer id) {
        return toInstrutorResponse(instrutorRepository.findById(id).orElseThrow(InstrutorNotFoundException::new));
    }

    public void excluirInstrutorPorId(Integer id) {
        obterInstrutorPorId(id);
        instrutorRepository.deleteById(id);
    }

}
