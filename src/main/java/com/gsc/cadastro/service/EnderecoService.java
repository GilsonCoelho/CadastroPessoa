package com.gsc.cadastro.service;

import com.gsc.cadastro.DTO.EnderecoDTO;
import com.gsc.cadastro.DTO.PessoaDTO;
import com.gsc.cadastro.model.Endereco;
import com.gsc.cadastro.model.Pessoa;
import com.gsc.cadastro.repositories.EnderecoRepository;
import com.gsc.cadastro.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class EnderecoService {


    EnderecoRepository repository ;

    Endereco endereco = new Endereco();

    EnderecoDTO enderecoDto = new EnderecoDTO();


    Pessoa pessoa = new Pessoa();


    PessoaService pessoaService;

    PessoaRepository pessoaRepository;

    private List<Endereco> enderecos = new LinkedList<>();
    private List<EnderecoDTO> enderecosDto = new LinkedList<>();

    public List<EnderecoDTO> listAll(){
        enderecos = repository.findAll();
        return listDTO();
    }

    private List<EnderecoDTO> listDTO() {
        enderecos.forEach(itens -> {
            PessoaDTO dto = pessoaService.findById(itens.getId());
            enderecosDto.add(new EnderecoDTO(itens.getId(), itens.getLogradouro(), itens.getCep(), itens.getNumero(),
                    itens.getComplemento(), itens.getCidade(), dto, itens.getTipo()));
        });
        return enderecosDto;
    }

    public List<EnderecoDTO> listToPessoa(Long id){

        enderecos = repository.listToPessoa(id);

        return listDTO();
    }
    public EnderecoDTO findById(Long id){
        endereco = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Cadastro não existe com esse id: " + id);
        });
        PessoaDTO dto = pessoaService.findById(endereco.getId());
        enderecoDto.setId(endereco.getId());
        enderecoDto.setLogradouro(endereco.getLogradouro());
        enderecoDto.setNumero(endereco.getNumero());
        enderecoDto.setComplemento(endereco.getComplemento());
        enderecoDto.setCep(endereco.getCep());
        enderecoDto.setCidade(endereco.getCidade());
        enderecoDto.setPessoa(dto);
        enderecoDto.setTipo(endereco.getTipo());
        return enderecoDto;
    }

    public EnderecoDTO create(EnderecoDTO dto){
        if(dto == null || dto.toString().trim().isEmpty())
            throw new RuntimeException("Dados Incompletos");
        pessoa = pessoaRepository.findById(dto.getPessoa().getId()).orElseThrow(() -> {
            throw new RuntimeException("Pessoa não existe com esse id: " + dto.getPessoa().getId());
        });
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setCidade(dto.getCidade());
        endereco.setCep(dto.getCep());
        endereco.setComplemento(dto.getComplemento());
        endereco.setNumero(dto.getNumero());
        endereco.setPessoa(pessoa);
        endereco.setTipo(dto.getTipo());
        repository.save(endereco);
        return dto;
    }

    public EnderecoDTO update(EnderecoDTO dto){
        endereco = repository.findById(dto.getId()).orElseThrow(() -> {
            throw new RuntimeException("Cadastro não existe com esse id: " + dto.getId());
        });
        pessoa = pessoaRepository.findById(dto.getPessoa().getId()).orElseThrow(() -> {
            throw new RuntimeException("Pessoa não existe com esse id: " + dto.getPessoa().getId());
        });
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setCidade(dto.getCidade());
        endereco.setCep(dto.getCep());
        endereco.setComplemento(dto.getComplemento());
        endereco.setNumero(dto.getNumero());
        endereco.setPessoa(pessoa);
        endereco.setTipo(dto.getTipo());
        repository.save(endereco);
        return dto;
    }
    public void delete(Long id){
        endereco = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Cadastro não existe com esse id: " + id);
        });
        repository.delete(endereco);
    }
    public void deleteToPessoa(Long id){
        repository.deleteToPessoa(id);
    }

}
