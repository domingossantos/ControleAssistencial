package br.com.acp.beans;

import br.com.acp.beans.common.PaginaBean;
import br.com.acp.dao.PessoaDao;
import br.com.acp.model.Escolaridade;
import br.com.acp.model.GrauParentesco;
import br.com.acp.model.Pessoa;
import br.com.acp.services.PessoaSrv;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
public class PessoalFormBen extends PaginaBean {

    @Inject
    private PessoaSrv pessoaSrv;

    private Pessoa pessoa;

    private List<GrauParentesco> grauParentescoList;

    private List<Escolaridade> escolaridadeList;

    @PostConstruct
    public void init(){
        if(pessoa == null) {
            this.pessoa = new Pessoa();
        }
        this.escolaridadeList = pessoaSrv.listaEscolaridade();
        this.grauParentescoList = pessoaSrv.listaGrauParentesco();
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

    public void salvar(){
        try {
            pessoaSrv.salvar(pessoa);
            pessoa = null;
            addInfo("Registro Salvo");
        } catch (Exception ex){
            addWarn("Erro ao gravar dados"+ex.getMessage());
        }
    }
}
