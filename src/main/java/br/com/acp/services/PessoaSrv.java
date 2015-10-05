package br.com.acp.services;

import br.com.acp.dao.EscolaridadeDao;
import br.com.acp.dao.GrauParentescoDao;
import br.com.acp.dao.PessoaDao;
import br.com.acp.model.Escolaridade;
import br.com.acp.model.GrauParentesco;
import br.com.acp.model.Pessoa;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by domingossantos on 20/09/15.
 */
public class PessoaSrv  {

    private Pessoa pessoa;

    @Inject
    private PessoaDao pessoaDao;

    @Inject
    private EscolaridadeDao escolaridadeDao;

    @Inject
    private GrauParentescoDao grauParentescoDao;


    public List<Pessoa> listarTodas(){
        return pessoaDao.listar(Pessoa.class);
    }

    public List<Escolaridade> listaEscolaridade(){
        return escolaridadeDao.listar(Escolaridade.class);
    }

    public List<GrauParentesco> listaGrauParentesco(){
        return grauParentescoDao.listar(GrauParentesco.class);
    }


    public List<Object> listarTodos() {
        return null;
    }


    public Object getPorId() {
        return null;
    }


    public void salvar(Pessoa pessoa) {
        if(pessoa.getId() != null){
            pessoaDao.salvar(pessoa);
        } else {
            pessoaDao.atualizar(pessoa);
        }
    }
}
