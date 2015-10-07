package br.com.acp.dao;

import br.com.acp.dao.common.DAO;
import br.com.acp.model.Evento;
import br.com.acp.model.EventoPessoa;
import br.com.acp.model.Pessoa;
import org.apache.poi.ss.formula.functions.Even;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by domingossantos on 10/09/15.
 */
public class EventoPessoaDao extends DAO<EventoPessoa> {

    public List<EventoPessoa> listaTodosPorEvento(Evento evento){
        Query query = getEm().createQuery("from EventoPessoa ev join ev.pessoaId Pessoa " +
                "join ev.eventoId Evento " +
                "where ev.eventoId =  :evento");
        query.setParameter("evento", evento);
        return query.getResultList();
    }


    public List<EventoPessoa> listaTodosPorPessoa(Pessoa pessoa){
        Query query = getEm().createQuery("from EventoPessoa ev join ev.pessoaId Pessoa " +
                "join ev.eventoId Evento " +
                "where ev.pessoaId =  :pessoa");
        query.setParameter("pessoa", pessoa);
        return query.getResultList();
    }
}
