package br.com.acp.services;

import br.com.acp.dao.GrauParentescoDao;
import br.com.acp.model.GrauParentesco;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by domingossantos on 16/09/15.
 */
public class GrauParentescoSrv {

    @Inject
    private GrauParentescoDao grauParentescoDao;

    public List<GrauParentesco> lista(){
        return grauParentescoDao.listar(GrauParentesco.class);
    }

    public GrauParentesco porId(Integer id){
        return grauParentescoDao.getUm(id, GrauParentesco.class);
    }

    public void salvar(GrauParentesco grauParentesco){
        try{
            if(grauParentesco.getId().equals(null)){
                grauParentescoDao.salvar(grauParentesco);
            } else {
                grauParentescoDao.atualizar(grauParentesco);
            }
        } catch (Exception ex){
            ex.getMessage();
        }

    }
}
