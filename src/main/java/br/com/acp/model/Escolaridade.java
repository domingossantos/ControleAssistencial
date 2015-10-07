package br.com.acp.model;

import javax.persistence.*;

/**
 * Created by domingossantos on 10/09/15.
 */
@Entity
@SequenceGenerator(name = "escolaridade_id_seq", sequenceName = "escolaridade_id_seq", initialValue = 1, allocationSize = 1)
public class Escolaridade {
    private Integer id;
    private String descricao;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "escolaridade_id_seq")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "descricao")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Escolaridade{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Escolaridade that = (Escolaridade) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
