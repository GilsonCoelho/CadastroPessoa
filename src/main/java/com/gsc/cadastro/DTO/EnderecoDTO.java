package com.gsc.cadastro.DTO;

import com.gsc.cadastro.enums.TipoEnderecoEnum;
import com.gsc.cadastro.model.Pessoa;

public class EnderecoDTO {

    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private PessoaDTO pessoa;
    private TipoEnderecoEnum tipo;

    public EnderecoDTO() {
    }

    public EnderecoDTO(Long id, String logradouro, String cep, String numero, String complemento, String cidade, PessoaDTO pessoa, TipoEnderecoEnum tipo) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pessoa = pessoa;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public PessoaDTO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaDTO pessoa) {
        this.pessoa = pessoa;
    }

    public TipoEnderecoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnderecoEnum tipo) {
        this.tipo = tipo;
    }
}
