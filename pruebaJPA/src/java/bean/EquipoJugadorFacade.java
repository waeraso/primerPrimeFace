/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidades.EquipoJugador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ingenieria
 */
@Stateless
public class EquipoJugadorFacade extends AbstractFacade<EquipoJugador> {
    @PersistenceContext(unitName = "pruebaJPAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipoJugadorFacade() {
        super(EquipoJugador.class);
    }
    
}
