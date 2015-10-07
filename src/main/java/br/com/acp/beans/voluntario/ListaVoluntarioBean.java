package br.com.acp.beans.voluntario;

import br.com.acp.beans.common.PaginaBean;
import br.com.acp.model.Evento;
import br.com.acp.model.Voluntario;
import br.com.acp.services.VoluntarioSrv;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcos on 07/10/15.
 */
@ManagedBean
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "listarVoluntario", pattern = "/voluntario/lista", viewId = "/pages/voluntario/voluntario_lista.jsf")})
public class ListaVoluntarioBean extends PaginaBean {

    @Inject
    private VoluntarioSrv voluntarioSrv;

    private List<Voluntario> voluntarios = new ArrayList<>();

    @URLAction(mappingId = "listarVoluntario", onPostback = false)
    public void abrir(){
        voluntarios = voluntarioSrv.listar();
    }

    public void excluir(Voluntario voluntario){
        voluntarioSrv.excluir(voluntario.getId());
        voluntarios = voluntarioSrv.listar();
        addInfo("Excluído com sucesso!");
    }


    public List<Voluntario> getVoluntarios() {
        return voluntarios;
    }

    public void setVoluntarios(List<Voluntario> voluntarios) {
        this.voluntarios = voluntarios;
    }
}
