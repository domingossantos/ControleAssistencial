package br.com.acp.beans;

import br.com.acp.model.Pessoa;
import br.com.acp.services.PessoaSrv;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by domingossantos on 20/09/15.
 */
@ManagedBean
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "pessoagrid", pattern = "/pessoa/lista", viewId = "/pages/pessoa_grid.jsf")})
public class PessoaGridBean {

    private Pessoa pessoa;

    private List<Pessoa> pessoas;

    @Inject
    private PessoaSrv pessoaSrv;

    @URLAction(mappingId = "pessoagrid", onPostback = false)
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
