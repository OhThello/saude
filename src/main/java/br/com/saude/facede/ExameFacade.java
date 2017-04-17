/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.facede;

import br.com.saude.entidade.Exame;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aline
 */
@Stateless
public class ExameFacade extends AbstractFacade<Exame> {
    @PersistenceContext(unitName = "saudePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExameFacade() {
        super(Exame.class);
    }
    
}
