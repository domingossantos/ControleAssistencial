package br.com.acp.beans.evento;

import br.com.acp.beans.common.PaginaBean;
import br.com.acp.model.Pessoa;
import br.com.acp.model.TipoEvento;
import br.com.acp.services.TipoEventoSrv;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

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
    public void init(){
        if (tipoEvento == null) {
            tipoEvento = new TipoEvento();
        }
    }

    public void salvar(){
        tipoEventoSrv.salvar(tipoEvento);
        tipoEvento = null;
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
