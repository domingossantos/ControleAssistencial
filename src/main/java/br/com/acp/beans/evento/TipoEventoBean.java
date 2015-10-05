package br.com.acp.beans.evento;

import br.com.acp.model.Pessoa;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by marcos on 05/10/15.
 */

@ManagedBean
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "tipoeventoid", pattern = "/cadastros/tipoevento/cadastro", viewId = "/pages/evento/tipo_evento_grid.jsf")})
public class TipoEventoBean {
    @URLAction(mappingId = "tipoeventoid", onPostback = false)
    public void init(){

    }

}
