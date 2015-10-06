package br.com.acp.services;

import br.com.acp.dao.DependenteDao;
import br.com.acp.dao.EscolaridadeDao;
import br.com.acp.dao.GrauParentescoDao;
import br.com.acp.dao.PessoaDao;
import br.com.acp.model.Dependente;
import br.com.acp.model.Escolaridade;
import br.com.acp.model.GrauParentesco;
import br.com.acp.model.Pessoa;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by domingossantos on 20/09/15.
 */
public class PessoaSrv  {

    private Pessoa pessoa;

    @Inject
    private PessoaDao pessoaDao;

    @Inject
    private DependenteDao dependenteDao;

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


    public Pessoa getPorId(Integer id) {
        return pessoaDao.getUm(id,Pessoa.class);
    }


    public void salvar(Pessoa pessoa) {
        if(pessoa.getId() == null){
            pessoa.setDataCadastro(new Date());
            pessoaDao.salvar(pessoa);
        } else {
            pessoaDao.atualizar(pessoa);
        }
    }

    public void salvaDependencia(Dependente dependente){
        if(dependente.getId() == null){
            dependenteDao.salvar(dependente);
        } else {
            dependenteDao.atualizar(dependente);
        }
    }


    public List<Dependente> dependentesPorPessoa(Pessoa pessoa){
        return dependenteDao.listaPorPessoa(pessoa);
    }
}
