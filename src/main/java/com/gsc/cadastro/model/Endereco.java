package com.gsc.cadastro.model;

import com.gsc.cadastro.enums.TipoEnderecoEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String numero;
    private String complemento;
    @Column(nullable = false)
    private String cidade;

    @ManyToOne
    @JoinColumn(name = "pessoa_fk", referencedColumnName = "id")
    private Pessoa pessoa;

    private TipoEnderecoEnum tipo;

    public Endereco(){
    }

    public Long getId() {
        return id;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoEnderecoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnderecoEnum tipo) {
        this.tipo = tipo;
    }
}
