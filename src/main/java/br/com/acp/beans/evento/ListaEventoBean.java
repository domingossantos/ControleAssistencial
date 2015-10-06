package br.com.acp.beans.evento;

import br.com.acp.beans.common.PaginaBean;
import br.com.acp.model.Evento;
import br.com.acp.model.TipoEvento;
import br.com.acp.services.EventoSrv;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcos on 06/10/15.
 */

@ManagedBean
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "listaeventoid", pattern = "/evento/lista", viewId = "/pages/evento/evento_lista.jsf")})
public class ListaEventoBean extends PaginaBean {

    @Inject
    private EventoSrv eventoSrv;

    private List<Evento> eventos = new ArrayList<>();

    @URLAction(mappingId = "listaeventoid", onPostback = false)
    public void abrir(){
        eventos = eventoSrv.listar();
    }

    public void excluir(Evento evento){
        eventoSrv.excluir(evento.getId());
        eventos = eventoSrv.listar();
        addInfo("Excluído com sucesso!");
    }


    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
