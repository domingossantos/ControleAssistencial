package br.com.acp.beans;

import br.com.acp.beans.common.PaginaBean;
import br.com.acp.dao.GrauParentescoDao;
import br.com.acp.model.GrauParentesco;
import br.com.acp.services.GrauParentescoSrv;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by domingossantos on 12/09/15.
 */
@ManagedBean
@RequestScoped
public class GrauParentescoBean extends PaginaBean{

    private GrauParentesco grauParentesco;

    private List<GrauParentesco> listaGrau;

    @Inject
    private GrauParentescoSrv grauParentescoSrv;

    @PostConstruct
    public void init(){
        grauParentesco = new GrauParentesco();
        listaGrau = grauParentescoSrv.lista();
    }

    public GrauParentesco getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(GrauParentesco grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public List<GrauParentesco> getListaGrau() {
        return listaGrau;
    }

    public String grauPorId(Integer id){
        grauParentesco = grauParentescoSrv.porId(id);
        return "grau_form";
    }

    public String novoGrau(){
        grauParentesco = new GrauParentesco();
        return "grau_form";
    }

    public String salva(){
        try {
            grauParentescoSrv.salvar(grauParentesco);
        } catch (Exception ex){
            addWarn("Erro ao gravar registro");
        }
        return "grau";
    }

}
