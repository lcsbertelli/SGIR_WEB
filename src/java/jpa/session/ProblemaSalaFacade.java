/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ProblemaSala;

/**
 *
 * @author lucas
 */
@Stateless
public class ProblemaSalaFacade extends AbstractFacade<ProblemaSala> {

    @PersistenceContext(unitName = "SGIR_WEBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProblemaSalaFacade() {
        super(ProblemaSala.class);
    }
    
}
