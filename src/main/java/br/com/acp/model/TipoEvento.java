package br.com.acp.model;

import javax.persistence.*;

/**
 * Created by domingossantos on 10/09/15.
 */
@Entity
@Table(name = "tipo_evento", schema = "public", catalog = "controle_associacao")
@SequenceGenerator(name = "tipo_evento_id_seq", sequenceName = "tipo_evento_id_seq", initialValue = 1, allocationSize = 1)
public class TipoEvento {
    private Integer id;
    private String descricao;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_evento_id_seq")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoEvento that = (TipoEvento) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }
}
