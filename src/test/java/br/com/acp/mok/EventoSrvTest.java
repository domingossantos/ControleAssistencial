package br.com.acp.mok;

import br.com.acp.model.Pessoa;
import br.com.acp.services.EventoSrv;
import br.com.acp.services.PessoaSrv;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * Created by domingossantos on 07/10/15.
 */
public class EventoSrvTest {

    private EventoDaoRepositorio dao;

    private Pessoa pessoa;

    @Before
    public void setUp() throws Exception {
        pessoa = dao.getUm(2);
    }

    @Test
    public void testAptoInscricao() throws Exception {
        Boolean teste = dao.aptoInscricao(pessoa);

        assertTrue(teste);
    }
}