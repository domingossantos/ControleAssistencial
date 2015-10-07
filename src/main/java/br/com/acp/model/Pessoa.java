package br.com.acp.model;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by domingossantos on 10/09/15.
 */
@Entity
@SequenceGenerator(name = "pessoa_id_seq", sequenceName = "pessoa_id_seq", initialValue = 1, allocationSize = 1)
public class Pessoa {
    private Integer id;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String identidade;
    private String emissorRg;
    private String cpf;
    private Date dataNascimento;
    private String nacionalidade;
    private String naturalidade;
    private Date dataCadastro;
    private Escolaridade escolaridadeId;

    public Pessoa(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pessoa() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_id_seq")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "endereco")
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Basic
    @Column(name = "bairro")
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Basic
    @Column(name = "cidade")
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Basic
    @Column(name = "uf")
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Basic
    @Column(name = "cep")
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Basic
    @Column(name = "identidade")
    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    @Basic
    @Column(name = "emissor_rg")
    public String getEmissorRg() {
        return emissorRg;
    }

    public void setEmissorRg(String emissorRg) {
        this.emissorRg = emissorRg;
    }

    @Basic
    @Column(name = "cpf")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Basic
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Basic
    @Column(name = "nacionalidade")
    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Basic
    @Column(name = "naturalidade")
    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    @Basic
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "escolaridade_id")
    public Escolaridade getEscolaridadeId() {
        return escolaridadeId;
    }

    public void setEscolaridadeId(Escolaridade escolaridadeId) {
        this.escolaridadeId = escolaridadeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        if (id != null ? !id.equals(pessoa.id) : pessoa.id != null) return false;
        if (nome != null ? !nome.equals(pessoa.nome) : pessoa.nome != null) return false;
        if (endereco != null ? !endereco.equals(pessoa.endereco) : pessoa.endereco != null) return false;
        if (bairro != null ? !bairro.equals(pessoa.bairro) : pessoa.bairro != null) return false;
        if (cidade != null ? !cidade.equals(pessoa.cidade) : pessoa.cidade != null) return false;
        if (uf != null ? !uf.equals(pessoa.uf) : pessoa.uf != null) return false;
        if (cep != null ? !cep.equals(pessoa.cep) : pessoa.cep != null) return false;
        if (identidade != null ? !identidade.equals(pessoa.identidade) : pessoa.identidade != null) return false;
        if (emissorRg != null ? !emissorRg.equals(pessoa.emissorRg) : pessoa.emissorRg != null) return false;
        if (cpf != null ? !cpf.equals(pessoa.cpf) : pessoa.cpf != null) return false;
        if (dataNascimento != null ? !dataNascimento.equals(pessoa.dataNascimento) : pessoa.dataNascimento != null)
            return false;
        if (nacionalidade != null ? !nacionalidade.equals(pessoa.nacionalidade) : pessoa.nacionalidade != null)
            return false;
        if (naturalidade != null ? !naturalidade.equals(pessoa.naturalidade) : pessoa.naturalidade != null)
            return false;
        if (dataCadastro != null ? !dataCadastro.equals(pessoa.dataCadastro) : pessoa.dataCadastro != null)
            return false;
        if (escolaridadeId != null ? !escolaridadeId.equals(pessoa.escolaridadeId) : pessoa.escolaridadeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        result = 31 * result + (bairro != null ? bairro.hashCode() : 0);
        result = 31 * result + (cidade != null ? cidade.hashCode() : 0);
        result = 31 * result + (uf != null ? uf.hashCode() : 0);
        result = 31 * result + (cep != null ? cep.hashCode() : 0);
        result = 31 * result + (identidade != null ? identidade.hashCode() : 0);
        result = 31 * result + (emissorRg != null ? emissorRg.hashCode() : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
        result = 31 * result + (nacionalidade != null ? nacionalidade.hashCode() : 0);
        result = 31 * result + (naturalidade != null ? naturalidade.hashCode() : 0);
        result = 31 * result + (dataCadastro != null ? dataCadastro.hashCode() : 0);
        result = 31 * result + (escolaridadeId != null ? escolaridadeId.hashCode() : 0);
        return result;
    }
}
