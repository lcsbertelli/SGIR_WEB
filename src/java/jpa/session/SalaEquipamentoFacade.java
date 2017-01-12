/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.SalaEquipamento;

/**
 *
 * @author lucas
 */
@Stateless
public class SalaEquipamentoFacade extends AbstractFacade<SalaEquipamento> {

    @PersistenceContext(unitName = "SGIR_WEBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SalaEquipamentoFacade() {
        super(SalaEquipamento.class);
    }
    
}
