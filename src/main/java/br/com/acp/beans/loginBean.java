package br.com.acp.beans;

import br.com.acp.model.Evento;
import br.com.acp.model.Pessoa;
import br.com.acp.services.EventoSrv;
import br.com.acp.services.PessoaSrv;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by domingossantos on 07/10/15.
 */
@ManagedBean
@ViewScoped
@URLMapping(id = "login", pattern = "/login/", viewId = "/pages/login.jsf")
public class loginBean {

    @Inject
    private EventoSrv eventoSrv;

    @Inject
    private PessoaSrv pessoaSrv;

    private List<Evento> eventos;

    private List<Pessoa> pessoas;

    @URLAction(mappingId = "login", onPostback = false)
    public void init(){
        eventos = eventoSrv.emOrdem();
        pessoas = pessoaSrv.listarTodas();
    }


    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
