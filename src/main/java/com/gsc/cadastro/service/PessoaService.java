package com.gsc.cadastro.service;

import com.gsc.cadastro.DTO.PessoaDTO;
import com.gsc.cadastro.model.Pessoa;
import com.gsc.cadastro.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PessoaService {

    PessoaRepository repository ;
    Pessoa pessoa = new Pessoa();
    EnderecoService enderecoService = new EnderecoService();


    PessoaDTO pessoaDTO = new PessoaDTO();

    private List<Pessoa> pessoas = new LinkedList<>();
    private final List<PessoaDTO> pessoasDto = new LinkedList<>();

    public List<PessoaDTO> listAll(){
        pessoas = repository.findAll();
        return listDTO();
    }

    private List<PessoaDTO> listDTO() {
        pessoas.forEach(itens -> {
            pessoasDto.add(new PessoaDTO(itens.getId(), itens.getNome(), itens.getDataNascimento(), enderecoService.listToPessoa(itens.getId())));
        });
        return pessoasDto;
    }


    public PessoaDTO findById(Long id){
        pessoa = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Cadastro não existe com esse id: " + id);
        });
        pessoaDTO = new PessoaDTO(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento(),
                enderecoService.listToPessoa(pessoa.getId()));
        return pessoaDTO;
    }

    public PessoaDTO create(PessoaDTO dto){
        if(dto == null || dto.toString().trim().isEmpty())
            throw new RuntimeException("Dados Incompletos");
        pessoa.setNome(dto.getNome());
        pessoa.setDataNascimento(dto.getDataNascimento());
        pessoa = repository.save(pessoa);
        dto.getEnderecos().forEach(endereco ->{
            enderecoService.create(endereco);
        });
        return dto;
    }

    public PessoaDTO update(PessoaDTO dto){
        if(dto == null || dto.toString().trim().isEmpty())
            throw new RuntimeException("Dados Incompletos");
        pessoa = repository.findById(dto.getId()).orElseThrow(() -> {
            throw new RuntimeException("Cadastro não existe com esse id: " + dto.getId());
        });
        pessoa.setNome(dto.getNome());
        pessoa.setDataNascimento(dto.getDataNascimento());
        repository.save(pessoa);
        dto.getEnderecos().forEach(endereco ->{
            enderecoService.update(endereco);
        });
        return dto;
    }
    public String delete(Long id){
        pessoa = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Cadastro não existe com esse id: " + id);
        });
        enderecoService.deleteToPessoa(pessoa.getId());
        String nome = pessoa.getNome();
        repository.delete(pessoa);
        return nome + " foi deletado";
    }

}
