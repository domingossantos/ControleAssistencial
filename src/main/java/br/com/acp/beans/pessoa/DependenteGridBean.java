package br.com.acp.beans.pessoa;

import br.com.acp.model.Dependente;
import br.com.acp.model.Pessoa;
import br.com.acp.services.PessoaSrv;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by domingossantos on 05/10/15.
 */
@ManagedBean
@ViewScoped
@URLMapping(id = "dependenteGrid", pattern = "/dependente/lista/#{pessoaId : dependenteGridBean.pessoaId }", viewId = "/pages/pessoa/dependente_grid.jsf")
public class DependenteGridBean {

    @Inject
    private PessoaSrv pessoaSrv;

    private Integer pessoaId;

    private Pessoa pessoa;

    private List<Dependente> dependentes;

    @URLAction(mappingId = "dependenteGrid", onPostback = false)
    public void init(){
        pessoa = pessoaSrv.getPorId(pessoaId);
        dependentes = pessoaSrv.dependentesPorPessoa(pessoa);
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
