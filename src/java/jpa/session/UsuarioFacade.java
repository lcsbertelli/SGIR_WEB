/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Usuario;



/**
 *
 * @author lucas
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "SGIR_WEBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public List<Usuario> buscaUsuarioPorEmailESenha(String email, String senha) {
    return this.em
        .createNamedQuery("Usuario.findByEmailANDSenha", Usuario.class)
        .setParameter("email", email)
        .setParameter("senha", senha)    
        .getResultList();       
    }
}
