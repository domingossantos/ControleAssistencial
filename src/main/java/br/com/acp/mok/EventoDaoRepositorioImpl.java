package br.com.acp.mok;

import br.com.acp.model.Evento;
import br.com.acp.model.EventoPessoa;
import br.com.acp.model.Pessoa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by domingossantos on 07/10/15.
 */
public class EventoDaoRepositorioImpl implements EventoDaoRepositorio {

    private List<Pessoa> pessoas;

    @Override
    public List<EventoPessoa> listaTodosPorPessoa() {

        Evento evento1 = new Evento(1,"Evento 1 de teste");
        Evento evento2 = new Evento(2,"Evento 2 de teste");
        Evento evento3 = new Evento(3,"Evento 3 de teste");


        Pessoa pessoa1 = new Pessoa(1,"Fulano");
        Pessoa pessoa2 = new Pessoa(2,"Beltrano");


        List<EventoPessoa> eventoPessoas = new ArrayList<>();

        eventoPessoas.add(new EventoPessoa(1,pessoa1,evento1,new Date(), "S"));
        eventoPessoas.add(new EventoPessoa(2,pessoa1,evento2,new Date(), "N"));
        eventoPessoas.add(new EventoPessoa(3,pessoa1,evento3,new Date(), "S"));
        eventoPessoas.add(new EventoPessoa(4,pessoa2,evento1,new Date(), "N"));
        eventoPessoas.add(new EventoPessoa(5,pessoa2,evento2,new Date(), "N"));
        eventoPessoas.add(new EventoPessoa(6,pessoa2,evento3,new Date(), "N"));

        return eventoPessoas;
     }

    @Override
    public Pessoa getUm(Integer id) {
        return pessoas.get(id);
    }

    @Override
    public Boolean aptoInscricao(Pessoa pessoa) throws Exception {
        Boolean resultado = false;

        try{
            List<EventoPessoa> eventoPessoas = listaTodosPorPessoa();

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

    public void setPessoas(){
        Pessoa pessoa1 = new Pessoa(1,"Fulano");
        Pessoa pessoa2 = new Pessoa(2,"Beltrano");
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
    }
}
