package br.com.acp.beans.evento;

import br.com.acp.beans.common.PaginaBean;
import br.com.acp.model.Pessoa;
import br.com.acp.model.TipoEvento;
import br.com.acp.services.TipoEventoSrv;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcos on 05/10/15.
 */

@ManagedBean
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "tipoeventoid", pattern = "/cadastros/tipoevento/cadastro", viewId = "/pages/evento/tipo_evento_grid.jsf")})
public class TipoEventoBean extends PaginaBean{

    private TipoEvento tipoEvento;
    private List<TipoEvento> lista = new ArrayList<>();

    @Inject
    private TipoEventoSrv tipoEventoSrv;

    @URLAction(mappingId = "tipoeventoid", onPostback = false)
    public void abrir(){
        if (tipoEvento == null) {
            tipoEvento = new TipoEvento();
        }
        lista = tipoEventoSrv.listar();
    }

    public void salvar(){
        if (tipoEvento.getDescricao() == null || tipoEvento.getDescricao().trim().equals("")) {
            addWarn("O Campo descrição não pode ser nulo");
        }else{
            tipoEventoSrv.salvar(tipoEvento);
            lista = tipoEventoSrv.listar();
            tipoEvento = null;
            tipoEvento = new TipoEvento();
            addInfo("Salvo com sucesso!");
        }
    }

    public void excluir(TipoEvento tipoevento){
        tipoEventoSrv.excluir(tipoevento.getId());
        lista = tipoEventoSrv.listar();
        addInfo("Excluído com sucesso!");
    }

    public void editar(TipoEvento tipoevento){
        this.tipoEvento = tipoevento;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public List<TipoEvento> getLista() {
        return lista;
    }

    public void setLista(List<TipoEvento> lista) {
        this.lista = lista;
    }
}
