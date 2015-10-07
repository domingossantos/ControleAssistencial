package br.com.acp.beans.pessoa;

import br.com.acp.beans.common.PaginaBean;
import br.com.acp.dao.PessoaDao;
import br.com.acp.model.Escolaridade;
import br.com.acp.model.GrauParentesco;
import br.com.acp.model.Pessoa;
import br.com.acp.services.PessoaSrv;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLActions;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "pessoaNova", pattern = "/pessoa/novo", viewId = "/pages/pessoa/cadastro_pessoa.jsf"),
        @URLMapping(id = "pessoaEditar", pattern = "/pessoa/editar/#{id : pessoalFormBean.id}", viewId = "/pages/pessoa/cadastro_pessoa.jsf")
})
public class PessoalFormBean extends PaginaBean {

    @Inject
    private PessoaSrv pessoaSrv;

    private Pessoa pessoa;

    private Integer id;

    private List<GrauParentesco> grauParentescoList;

    private List<Escolaridade> escolaridadeList;

    @URLActions(
            actions = {
                    @URLAction(mappingId = "pessoaNova", onPostback = false),
                    @URLAction(mappingId = "pessoaEditar", onPostback = false)
            }
    )
    public void init(){
        try {
            if (id == null) {
                this.pessoa = new Pessoa();
            } else {
                pessoa = pessoaSrv.getPorId(id);
                pessoa.getEscolaridadeId();
            }
            this.escolaridadeList = pessoaSrv.listaEscolaridade();
        } catch (Exception ex){
            addWarn(ex.getMessage());
        }
    }


    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<GrauParentesco> getGrauParentescoList() {
        return grauParentescoList;
    }

    public void setGrauParentescoList(List<GrauParentesco> grauParentescoList) {
        this.grauParentescoList = grauParentescoList;
    }

    public List<Escolaridade> getEscolaridadeList() {
        return escolaridadeList;
    }

    public void setEscolaridadeList(List<Escolaridade> escolaridadeList) {
        this.escolaridadeList = escolaridadeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void salvar(){
        try {

            pessoaSrv.salvar(pessoa);

            if(id == null){
                pessoa = new Pessoa();
            }

            addInfo("Registro Salvo");
        } catch (Exception ex){
            addWarn("Erro ao gravar dados"+ex.getMessage());
        }
    }
}
