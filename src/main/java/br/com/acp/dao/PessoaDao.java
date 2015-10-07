package br.com.acp.dao;

import br.com.acp.dao.common.DAO;
import br.com.acp.model.Pessoa;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by domingossantos on 10/09/15.
 */
public class PessoaDao extends DAO<Pessoa> {


    public List<Pessoa> listaTodos(){


        Query query = getEm().createQuery("select p from Pessoa p where p not in (select d.dependente from Dependente d) order by p.nome");

        return query.getResultList();
    }

    public Pessoa getPorId(Integer id) throws Exception {
        Pessoa pessoa = new Pessoa();
        try {
            Query query = getEm().createQuery("select p from Pessoa p join p.escolaridadeId Escolaridade where p.id = :id");
            query.setParameter("id", id);
            pessoa = (Pessoa) query.getSingleResult();
        } catch (NoResultException e){
            throw new Exception("Registro não encontrado");
        }
        return pessoa;
    }
}



