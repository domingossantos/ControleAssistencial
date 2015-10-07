package br.com.acp.model;


import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by domingossantos on 10/09/15.
 */
@Entity
@Table(name = "evento_pessoa", schema = "public", catalog = "controle_associacao")
@SequenceGenerator(name = "evento_pessoa_id_seq", sequenceName = "evento_pessoa_id_seq", initialValue = 1, allocationSize = 1)
public class EventoPessoa {
    private Integer id;
    private Pessoa pessoaId;
    private Evento eventoId;
    private Date dataInscricao;
    private String participacao;

    public EventoPessoa(Integer id, Pessoa pessoaId, Evento eventoId, Date dataInscricao, String participacao) {
        this.id = id;
        this.pessoaId = pessoaId;
        this.eventoId = eventoId;
        this.dataInscricao = dataInscricao;
        this.participacao = participacao;
    }

    public EventoPessoa() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evento_pessoa_id_seq")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_id")
    public Evento getEventoId() {
        return eventoId;
    }

    public void setEventoId(Evento eventoId) {
        this.eventoId = eventoId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inscricao")
    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    @Basic
    @Column(name = "participacao")
    public String getParticipacao() {
        return participacao;
    }

    public void setParticipacao(String participacao) {
        this.participacao = participacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventoPessoa that = (EventoPessoa) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (pessoaId != null ? !pessoaId.equals(that.pessoaId) : that.pessoaId != null) return false;
        if (eventoId != null ? !eventoId.equals(that.eventoId) : that.eventoId != null) return false;
        if (dataInscricao != null ? !dataInscricao.equals(that.dataInscricao) : that.dataInscricao != null)
            return false;
        if (participacao != null ? !participacao.equals(that.participacao) : that.participacao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pessoaId != null ? pessoaId.hashCode() : 0);
        result = 31 * result + (eventoId != null ? eventoId.hashCode() : 0);
        result = 31 * result + (dataInscricao != null ? dataInscricao.hashCode() : 0);
        result = 31 * result + (participacao != null ? participacao.hashCode() : 0);
        return result;
    }
}
