package br.com.acp.services;

import java.util.List;

/**
 * Created by domingossantos on 04/10/15.
 */
public interface Servico {

    public Object getPorId();
    public List<Object> listarTodos();
    public void salvar(Object entity);
}
