package br.com.acp.model;

import javax.persistence.*;

/**
 * Created by domingossantos on 10/09/15.
 */
@Entity
@SequenceGenerator(name = "dependente_id_seq", sequenceName = "dependente_id_seq", initialValue = 1, allocationSize = 1)
public class Dependente {
    private Integer id;
    private GrauParentesco grauParentescoId;
    private Pessoa dependente;
    private Pessoa responsavel;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dependente_id_seq")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grau_parentesco_id")
    public GrauParentesco getGrauParentescoId() {
        return grauParentescoId;
    }

    public void setGrauParentescoId(GrauParentesco grauParentescoId) {
        this.grauParentescoId = grauParentescoId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dependente_id")
    public Pessoa getDependente() {
        return dependente;
    }

    public void setDependente(Pessoa dependente) {
        this.dependente = dependente;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsavel_id")
    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dependente that = (Dependente) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
