package br.com.acp.beans.pessoa;

import br.com.acp.beans.common.PaginaBean;
import br.com.acp.model.Dependente;
import br.com.acp.model.Escolaridade;
import br.com.acp.model.GrauParentesco;
import br.com.acp.model.Pessoa;
import br.com.acp.services.PessoaSrv;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by domingossantos on 05/10/15.
 */
@ManagedBean
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "dependenteNovo", pattern = "/pessoa/dependente/novo/#{pessoaId : dependenteFormBean.pessoaId}", viewId = "/pages/pessoa/dependente_form.jsf")
})
public class DependenteFormBean extends PaginaBean{

    @Inject
    private PessoaSrv pessoaSrv;

    private Integer id;

    private Integer pessoaId;

    private Pessoa dependente;

    private Dependente dependencia;

    private List<GrauParentesco> grauParentescoList;

    private List<Escolaridade> escolaridadeList;

    @URLAction(mappingId = "dependenteNovo", onPostback = false)
    public void init(){
        try {
            if (id == null) {
                dependente = new Pessoa();
                dependencia = new Dependente();
                dependencia.setResponsavel(pessoaSrv.getPorId(pessoaId));
                grauParentescoList = pessoaSrv.listaGrauParentesco();
                escolaridadeList = pessoaSrv.listaEscolaridade();
            }
        } catch (Exception ex){
            addWarn(ex.getMessage());
        }
    }

    public void salvar(){
        if(id == null){
            pessoaSrv.salvar(dependente);

            dependencia.setDependente(dependente);

            pessoaSrv.salvaDependencia(dependencia);

            dependencia = new Dependente();

            addInfo("Registro Salvo");
        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }


    public Pessoa getDependente() {
        return dependente;
    }

    public void setDependente(Pessoa dependente) {
        this.dependente = dependente;
    }

    public Dependente getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependente dependencia) {
        this.dependencia = dependencia;
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
}
