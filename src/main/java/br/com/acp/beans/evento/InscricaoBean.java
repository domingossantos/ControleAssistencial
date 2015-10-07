package br.com.acp.beans.evento;

import br.com.acp.beans.common.PaginaBean;
import br.com.acp.model.Evento;
import br.com.acp.model.EventoPessoa;
import br.com.acp.model.Pessoa;
import br.com.acp.services.EventoSrv;
import br.com.acp.services.PessoaSrv;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by domingossantos on 07/10/15.
 */
@ManagedBean
@ViewScoped
@URLMapping(id = "inscricao", pattern = "/evento/inscricao/#{ eventoId : inscricaoBean.eventoId}", viewId = "/pages/evento/inscricao.jsf")
public class InscricaoBean extends PaginaBean{

    @Inject
    private EventoSrv eventoSrv;

    @Inject
    private PessoaSrv pessoaSrv;

    private Integer eventoId;

    private Evento evento;

    private List<Evento> eventos;

    private List<EventoPessoa> eventoPessoas;

    private List<Pessoa> pessoas;

    private Pessoa pessoa;

    private EventoPessoa eventoPessoa;


    @URLAction(mappingId = "inscricao", onPostback = false)
    public void init(){
        evento = eventoSrv.getPorId(eventoId);
        pessoas = pessoaSrv.listarTodas();
        eventoPessoas = eventoSrv.pessoasPorEvento(evento);
    }

    public void inscrever(){

        try {
            eventoPessoa.setEventoId(evento);
            eventoPessoa.setPessoaId(pessoa);
            eventoPessoa.setDataInscricao(new Date());
            eventoSrv.inscrever(eventoPessoa);

            eventoPessoas = eventoSrv.pessoasPorEvento(evento);
        } catch (Exception ex){
            ex.getStackTrace();
            addWarn("Erro ao salvar inscrição");
        }
    }


    public List<Pessoa> lisarPessoas(){


        return pessoaSrv.listarTodas();
    }


    public Integer getEventoId() {
        return eventoId;
    }

    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<EventoPessoa> getEventoPessoas() {
        return eventoPessoas;
    }

    public void setEventoPessoas(List<EventoPessoa> eventoPessoas) {
        this.eventoPessoas = eventoPessoas;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
