/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ReservaSala;
import java.util.Date;

import java.util.List;

/**
 *
 * @author lucas
 */
@Stateless
public class ReservaSalaFacade extends AbstractFacade<ReservaSala> {

    @PersistenceContext(unitName = "SGIR_WEBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservaSalaFacade() {
        super(ReservaSala.class);
    }
    
    public List<ReservaSala> validaReservaSalaFacade(Date dateReserva, Date dateReservaFim) {
    return this.em
        .createNamedQuery("ReservaSala.validaReservaSala", ReservaSala.class)
        .setParameter("dateReserva", dateReserva)
        .setParameter("dateReservaFim", dateReservaFim)    
        .getResultList();       
    }
    
}
