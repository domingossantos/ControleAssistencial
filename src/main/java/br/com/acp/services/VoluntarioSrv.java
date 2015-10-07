package br.com.acp.services;

import br.com.acp.dao.EventoDao;
import br.com.acp.dao.VoluntarioDao;
import br.com.acp.model.Evento;
import br.com.acp.model.Voluntario;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by marcos on 07/10/15.
 */
public class VoluntarioSrv {

    @Inject
    private VoluntarioDao dao;

    public List<Voluntario> listar(){
        return dao.listar(Voluntario.class);
    }

    public Voluntario getPorId(Integer id) {
        return dao.getUm(id, Voluntario.class);
    }

    public void salvar(Voluntario voluntario) {
        if(voluntario.getId() == null){
            dao.salvar(voluntario);
        } else {
            dao.atualizar(voluntario);
        }
    }

    public void excluir(Integer id) {
        dao.remover(id,Voluntario.class);
    }

}
