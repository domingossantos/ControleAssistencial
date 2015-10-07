package br.com.acp.beans.voluntario;

import br.com.acp.beans.common.PaginaBean;
import br.com.acp.model.Voluntario;
import br.com.acp.services.VoluntarioSrv;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLActions;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Date;

/**
 * Created by marcos on 07/10/15.
 */

@ManagedBean
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "voluntarioform", pattern = "/volunatario/cadastro", viewId = "/pages/voluntario/voluntario_form.jsf"),
        @URLMapping(id = "editarVoluntario", pattern = "/volunatario/cadastro/#{id : voluntarioBean.id}", viewId = "/pages/voluntario/voluntario_form.jsf")})
public class VoluntarioBean extends PaginaBean{

    @Inject
    private VoluntarioSrv voluntarioSrv;
    private Voluntario voluntario;
    private Integer id;

    @URLActions(actions = {
            @URLAction(mappingId = "voluntarioform", onPostback = false),
            @URLAction(mappingId = "editarVoluntario", onPostback = false) })
    public void abrir(){
        if (id != null) {
            voluntario = voluntarioSrv.getPorId(id);
        }else{
            voluntario = new Voluntario();
        }
    }

    public String salvar(){
        if (id == null) {
            voluntario.setDataCadastro(new Date());
        }
        voluntarioSrv.salvar(voluntario);
        addInfo("Cadastro Realizado com Sucesso!");
        return "pretty:listarVoluntario";
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
