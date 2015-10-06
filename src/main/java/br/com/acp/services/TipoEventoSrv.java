package br.com.acp.services;

import br.com.acp.dao.TipoEventoDao;
import br.com.acp.model.Pessoa;
import br.com.acp.model.TipoEvento;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by marcos on 05/10/15.
 */
public class TipoEventoSrv {

    @Inject
    private TipoEventoDao dao;

    public List<TipoEvento> listar(){
        return dao.listar(TipoEvento.class);
    }

    public TipoEvento getPorId(Integer id) {
        return dao.getUm(id, TipoEvento.class);
    }

    public void salvar(TipoEvento tipoEvento) {
        if(tipoEvento.getId() == null){
            dao.salvar(tipoEvento);
        } else {
            dao.atualizar(tipoEvento);
        }
    }

    public void excluir(Integer id) {
        dao.remover(id,TipoEvento.class);
    }


}
