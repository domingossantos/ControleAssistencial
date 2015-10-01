package br.com.acp.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by domingossantos on 10/09/15.
 */
@Entity
@SequenceGenerator(name = "voluntario_id_seq", sequenceName = "voluntario_id_seq")
public class Voluntario {
    private String funcao;
    private String nome;
    private Calendar dataCadastro;
    private Integer id;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voluntario_id_seq")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "funcao")
    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_cadastro")
    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voluntario that = (Voluntario) o;

        if (funcao != null ? !funcao.equals(that.funcao) : that.funcao != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (dataCadastro != null ? !dataCadastro.equals(that.dataCadastro) : that.dataCadastro != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = funcao != null ? funcao.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (dataCadastro != null ? dataCadastro.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
