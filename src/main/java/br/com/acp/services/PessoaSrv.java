package br.com.acp.services;

import br.com.acp.dao.PessoaDao;
import br.com.acp.model.Pessoa;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by domingossantos on 20/09/15.
 */
public class PessoaSrv {

    private Pessoa pessoa;

    @Inject
    private PessoaDao pessoaDao;


    public List<Pessoa> listarTodas(){
        return pessoaDao.listar(Pessoa.class);
    }
}
