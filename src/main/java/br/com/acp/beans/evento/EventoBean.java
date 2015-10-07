package br.com.acp.beans.evento;

import br.com.acp.beans.common.PaginaBean;
import br.com.acp.model.Evento;
import br.com.acp.model.TipoEvento;
import br.com.acp.services.EventoSrv;
import br.com.acp.services.TipoEventoSrv;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLActions;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcos on 06/10/15.
 */
@ManagedBean
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "eventoid", pattern = "/evento/cadastro", viewId = "/pages/evento/evento_form.jsf"),
        @URLMapping(id = "editarEvento", pattern = "/evento/cadastro/#{id : eventoBean.id}", viewId = "/pages/evento/evento_form.jsf")})
public class EventoBean extends PaginaBean {

        @Inject
        private EventoSrv eventoSrv;

        @Inject
        private TipoEventoSrv tipoEventoSrv;

        private Evento evento;
        private Integer id;
        private List<TipoEvento> tiposDeEvento = new ArrayList<>();
        private DateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
        private DateFormat formatHora = new SimpleDateFormat("HH:mm");

@URLActions(actions = {
        @URLAction(mappingId = "eventoid", onPostback = false),
        @URLAction(mappingId = "editarEvento", onPostback = false) })
        public void abrir(){
                if (id != null) {
                        evento = eventoSrv.getPorId(id);
                }else{
                        evento = new Evento();
                }
                tiposDeEvento = tipoEventoSrv.listar();
        }

        public String salvar(){
            eventoSrv.salvar(evento);
            addInfo("Cadastro Realizado com Sucesso!");
            return "pretty:listaeventoid";
        }

        public Evento getEvento() {
                return evento;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public void setEvento(Evento evento) {
                this.evento = evento;
        }

        public List<TipoEvento> getTiposDeEvento() {
                return tiposDeEvento;
        }

        public void setTiposDeEvento(List<TipoEvento> tiposDeEvento) {
                this.tiposDeEvento = tiposDeEvento;
        }
}
