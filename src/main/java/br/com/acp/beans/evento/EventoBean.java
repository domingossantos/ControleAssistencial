package br.com.acp.beans.evento;

import br.com.acp.beans.common.PaginaBean;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by marcos on 06/10/15.
 */
@ManagedBean
@ViewScoped
@URLMappings(mappings = {
        @URLMapping(id = "eventoid", pattern = "/evento/cadastro", viewId = "/pages/evento/evento_form.jsf")})
public class EventoBean extends PaginaBean {
}
