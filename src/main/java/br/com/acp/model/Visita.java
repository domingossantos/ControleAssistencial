package br.com.acp.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by domingossantos on 10/09/15.
 */
@Entity
@SequenceGenerator(name = "visita_id_seq", sequenceName = "visita_id_seq", initialValue = 1, allocationSize = 1)
public class Visita {
    private Integer id;
    private Calendar data;
    private String relato;
    private Pessoa pessoaId;
    private Voluntario voluntarioId;
    private TipoVisita tipoVisitaId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visita_id_seq")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "data")
    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    @Basic
    @Column(name = "relato")
    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
    }

    @ManyToOne
    @JoinColumn(name = "voluntario_id")
    public Voluntario getVoluntarioId() {
        return voluntarioId;
    }

    public void setVoluntarioId(Voluntario voluntarioId) {
        this.voluntarioId = voluntarioId;
    }

    @ManyToOne
    @JoinColumn(name = "tipo_visita_id")
    public TipoVisita getTipoVisitaId() {
        return tipoVisitaId;
    }

    public void setTipoVisitaId(TipoVisita tipoVisitaId) {
        this.tipoVisitaId = tipoVisitaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visita visita = (Visita) o;

        if (id != null ? !id.equals(visita.id) : visita.id != null) return false;
        if (data != null ? !data.equals(visita.data) : visita.data != null) return false;
        if (relato != null ? !relato.equals(visita.relato) : visita.relato != null) return false;
        if (pessoaId != null ? !pessoaId.equals(visita.pessoaId) : visita.pessoaId != null) return false;
        if (voluntarioId != null ? !voluntarioId.equals(visita.voluntarioId) : visita.voluntarioId != null)
            return false;
        if (tipoVisitaId != null ? !tipoVisitaId.equals(visita.tipoVisitaId) : visita.tipoVisitaId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (relato != null ? relato.hashCode() : 0);
        result = 31 * result + (pessoaId != null ? pessoaId.hashCode() : 0);
        result = 31 * result + (voluntarioId != null ? voluntarioId.hashCode() : 0);
        result = 31 * result + (tipoVisitaId != null ? tipoVisitaId.hashCode() : 0);
        return result;
    }
}
