/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidades.Jugador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ingenieria
 */
@Stateless
public class JugadorFacade extends AbstractFacade<Jugador> {
    @PersistenceContext(unitName = "pruebaJPAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JugadorFacade() {
        super(Jugador.class);
    }
    
}
