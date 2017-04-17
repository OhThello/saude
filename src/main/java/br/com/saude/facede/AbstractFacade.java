/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.facede;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Aline
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void inserir(T entity) {
        getEntityManager().persist(entity);
    }

    public void salvar(T entity) {
        getEntityManager().merge(entity);
    }

    public void excluir(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T pesquisar(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> listarTodos() {
        String consulta = "FROM " + entityClass.getSimpleName();
        Query query = getEntityManager().createQuery(consulta);
        return query.getResultList();
    }

    public List<T> listarContas(String where) {
        String consulta = "FROM " + entityClass.getSimpleName()+ " where "+ where;
        Query query = getEntityManager().createQuery(consulta);
        return query.getResultList();
    }

    public List<T> autoComplete(String campo, String cons) {

        String consulta = "FROM " + entityClass.getSimpleName() + " AS i"
                + " WHERE LOWER(i." + campo + ") LIKE ('%" + cons + "%')"
                + " ORDER BY i." + campo;

        Query query = getEntityManager().createQuery(consulta);
        return query.setMaxResults(20).getResultList();
    }
}
