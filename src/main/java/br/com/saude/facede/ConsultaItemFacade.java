/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.facede;

import br.com.saude.entidade.Cidade;
import br.com.saude.entidade.ConsultaItem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aline
 */
@Stateless
public class ConsultaItemFacade extends AbstractFacade<ConsultaItem> {
    @PersistenceContext(unitName = "saudePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsultaItemFacade() {
        super(ConsultaItem.class);
    }
    
}
