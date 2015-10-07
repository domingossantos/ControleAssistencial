package br.com.acp.services;

import br.com.acp.dao.EventoDao;
import br.com.acp.dao.EventoPessoaDao;
import br.com.acp.model.Evento;
import br.com.acp.model.EventoPessoa;
import br.com.acp.model.Pessoa;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by marcos on 06/10/15.
 */
public class EventoSrv {
    @Inject
    private EventoDao eventoDao;

    @Inject
    private EventoPessoaDao eventoPessoaDao;

    public List<Evento> listar(){
        return eventoDao.listar(Evento.class);
    }

    public Evento getPorId(Integer id) {
        return eventoDao.getUm(id, Evento.class);
    }

    public void salvar(Evento evento) {
        if(evento.getId() == null){
            eventoDao.salvar(evento);
        } else {
            eventoDao.atualizar(evento);
        }
    }

    public void excluir(Integer id) {
        eventoDao.remover(id, Evento.class);
    }

    public List<Evento> emOrdem(){
        return eventoDao.emOrdem();
    }

    public List<EventoPessoa> pessoasPorEvento(Evento evento){
        return eventoPessoaDao.listaTodosPorEvento(evento);
    }

    public void inscrever(EventoPessoa eventoPessoa){
        try {
            eventoPessoaDao.salvar(eventoPessoa);
        } catch (Exception ex){
            System.out.println(ex.getStackTrace());
        }
    }

    public Boolean aptoInscricao(Pessoa pessoa) throws Exception {
        Boolean resultado = false;

        try{
            List<EventoPessoa> eventoPessoas = eventoPessoaDao.listaTodosPorPessoa(pessoa);

            Integer numNaoParticipa = 0;
            for(EventoPessoa eventoPessoa : eventoPessoas){
                if(eventoPessoa.getParticipacao().equals("N")){
                    numNaoParticipa++;
                }
            }

            if(numNaoParticipa <= 2){
                resultado = true;
            }

        } catch (Exception ex){
            throw new Exception("Erro ao checar se a pessoa está apta a se inscriver");
        }

        return resultado;
    }

}
