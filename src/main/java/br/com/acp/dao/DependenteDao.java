package br.com.acp.dao;

import br.com.acp.dao.common.DAO;
import br.com.acp.model.Dependente;
import br.com.acp.model.Pessoa;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by domingossantos on 10/09/15.
 */
public class DependenteDao extends DAO<Dependente> {

    public List<Dependente> listaPorPessoa(Pessoa pessoa){
        Query query = getEm().createQuery("select d from Dependente d where d.responsavel = :pessoa");
        query.setParameter("pessoa", pessoa);
        return query.getResultList();
    }

}
