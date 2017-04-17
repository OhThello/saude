/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.controle;

import br.com.saude.converter.GenericConverter;
import br.com.saude.entidade.Estado;
import br.com.saude.facede.EstadoFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aline
 */

@ManagedBean
@SessionScoped
public class EstadoControle implements Serializable {

    private Estado estado;
    @EJB
    private EstadoFacade estadoFacade;
    private GenericConverter genericConverter;

    public GenericConverter converter() {
        if (genericConverter == null) {
            genericConverter = new GenericConverter(estadoFacade);
        }
        return genericConverter;
    }
    
     public List<Estado> autoComplete(String query) {
        return estadoFacade.autoComplete("nome", query);
    }

    public String novo() {
        estado = new Estado();
        return "cadastro?faces-redirect=true";
    }

    public String salvar() {
        estadoFacade.salvar(estado);
        return "pesquisa?faces-redirect=true";
    }

    public void excluir(Estado e) {
        estadoFacade.excluir(e);
    }

    public List<Estado> getListaEstados() {
        return estadoFacade.listarTodos();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean isEditando() {
        return this.estado.getId() != null;
    }

}
