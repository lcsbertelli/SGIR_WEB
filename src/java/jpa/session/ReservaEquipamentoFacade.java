/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ReservaEquipamento;

/**
 *
 * @author lucas
 */
@Stateless
public class ReservaEquipamentoFacade extends AbstractFacade<ReservaEquipamento> {

    @PersistenceContext(unitName = "SGIR_WEBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservaEquipamentoFacade() {
        super(ReservaEquipamento.class);
    }
    
}
