package br.com.acp.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;

/**
 * Created by domingossantos on 10/09/15.
 */
@Entity
@SequenceGenerator(name = "evento_id_seq", sequenceName = "evento_id_seq", initialValue = 1, allocationSize = 1)
public class Evento {
    private Integer id;
    private Calendar dataEvento;
    private String horaEvento;
    private String duracao;
    private String observacao;
    private TipoEvento tipoEventoId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evento_id_seq")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "data_evento")
    @Temporal(TemporalType.DATE)
    public Calendar getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Calendar dataEvento) {
        this.dataEvento = dataEvento;
    }

    @Basic
    @Column(name = "hora_evento")
    public String getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(String horaEvento) {
        this.horaEvento = horaEvento;
    }

    @Basic
    @Column(name = "duracao")
    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    @Basic
    @Column(name = "observacao")
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }


    @ManyToOne
    @JoinColumn(name = "tipo_evento_id")
    public TipoEvento getTipoEventoId() {
        return tipoEventoId;
    }

    public void setTipoEventoId(TipoEvento tipoEventoId) {
        this.tipoEventoId = tipoEventoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Evento evento = (Evento) o;

        if (id != null ? !id.equals(evento.id) : evento.id != null) return false;
        if (dataEvento != null ? !dataEvento.equals(evento.dataEvento) : evento.dataEvento != null) return false;
        if (horaEvento != null ? !horaEvento.equals(evento.horaEvento) : evento.horaEvento != null) return false;
        if (duracao != null ? !duracao.equals(evento.duracao) : evento.duracao != null) return false;
        if (observacao != null ? !observacao.equals(evento.observacao) : evento.observacao != null) return false;
        if (tipoEventoId != null ? !tipoEventoId.equals(evento.tipoEventoId) : evento.tipoEventoId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dataEvento != null ? dataEvento.hashCode() : 0);
        result = 31 * result + (horaEvento != null ? horaEvento.hashCode() : 0);
        result = 31 * result + (duracao != null ? duracao.hashCode() : 0);
        result = 31 * result + (observacao != null ? observacao.hashCode() : 0);
        result = 31 * result + (tipoEventoId != null ? tipoEventoId.hashCode() : 0);
        return result;
    }
}
