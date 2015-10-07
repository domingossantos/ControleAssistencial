package br.com.acp.mok;

import br.com.acp.model.EventoPessoa;
import br.com.acp.model.Pessoa;

import java.util.List;

/**
 * Created by domingossantos on 07/10/15.
 */
public interface EventoDaoRepositorio {

    List<EventoPessoa> listaTodosPorPessoa();
    Pessoa getUm(Integer id);
    Boolean aptoInscricao(Pessoa pessoa) throws Exception;
}
