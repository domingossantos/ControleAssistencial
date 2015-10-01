package br.com.acp.beans;

import br.com.acp.model.Pessoa;
import br.com.acp.services.PessoaSrv;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by domingossantos on 20/09/15.
 */
@ManagedBean
public class PessoaGridBean {

    private Pessoa pessoa;

    private List<Pessoa> pessoas;

    @Inject
    private PessoaSrv pessoaSrv;

    @PostConstruct
    public void init(){
        pessoa = new Pessoa();
        pessoas = pessoaSrv.listarTodas();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
