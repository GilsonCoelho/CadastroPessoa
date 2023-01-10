package com.gsc.cadastro.DTO;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class PessoaDTO {
    private Long id;
    private String nome;
    private Date dataNascimento;
    private List<EnderecoDTO> enderecos = new LinkedList<>();

    public PessoaDTO() {

    }

    public PessoaDTO(Long id, String nome, Date dataNascimento, List<EnderecoDTO> listToPessoa) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDTO> enderecos) {
        this.enderecos = enderecos;
    }
}
