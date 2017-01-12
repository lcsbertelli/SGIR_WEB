/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ControleEquipamentos;

/**
 *
 * @author lucas
 */
@Stateless
public class ControleEquipamentosFacade extends AbstractFacade<ControleEquipamentos> {

    @PersistenceContext(unitName = "SGIR_WEBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ControleEquipamentosFacade() {
        super(ControleEquipamentos.class);
    }
    
}
