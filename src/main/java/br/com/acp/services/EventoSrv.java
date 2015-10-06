package br.com.acp.services;

import br.com.acp.dao.EventoDao;
import br.com.acp.dao.TipoEventoDao;
import br.com.acp.model.Evento;
import br.com.acp.model.TipoEvento;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by marcos on 06/10/15.
 */
public class EventoSrv {
    @Inject
    private EventoDao dao;

    public List<Evento> listar(){
        return dao.listar(Evento.class);
    }

    public Evento getPorId(Integer id) {
        return dao.getUm(id, Evento.class);
    }

    public void salvar(Evento evento) {
        if(evento.getId() == null){
            dao.salvar(evento);
        } else {
            dao.atualizar(evento);
        }
    }

    public void excluir(Integer id) {
        dao.remover(id,Evento.class);
    }

}
