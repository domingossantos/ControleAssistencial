package br.com.acp.dao.common;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by domingossantos on 14/09/15.
 */

public class EntityManagerFactory {
    @PersistenceContext(name = "acpPU")
    private EntityManager manager;


    public EntityManagerFactory() {

    }

    @Produces @Default
    public EntityManager create(){
        return this.manager;
    }
}

