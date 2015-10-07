package br.com.acp.dao;

import br.com.acp.dao.common.DAO;
import br.com.acp.model.Evento;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by domingossantos on 10/09/15.
 */
public class EventoDao extends DAO<Evento> {

    public List<Evento> emOrdem(){
        Query query = getEm().createQuery("from Evento e order by e.dataEvento desc ");

        return query.getResultList();
    }
}
