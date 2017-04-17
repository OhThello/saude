/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.controle;

import br.com.saude.converter.GenericConverter;
import br.com.saude.entidade.EntradaMedicamento;
import br.com.saude.entidade.ItensEntrada;
import br.com.saude.facede.EntradaMedicamentoFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aline
 */
@ManagedBean
@SessionScoped
public class EntradaMedicamentoControle implements Serializable {

    private EntradaMedicamento entradaMedicamento;
    private ItensEntrada itensEntrada;
    @EJB
    private EntradaMedicamentoFacade entradaMedicamentoFacade;
    private GenericConverter genericConverter;

    public GenericConverter converter() {
        if (genericConverter == null) {
            genericConverter = new GenericConverter(entradaMedicamentoFacade);
        }
        return genericConverter;
    }

    public void adiconaMedicamento() {
        try {
            entradaMedicamento.adicionaItem(itensEntrada);
            itensEntrada = new ItensEntrada();
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    ex.getMessage(), "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void removeMedicamento() {
        try {
            entradaMedicamento.removeItem(itensEntrada);
            itensEntrada = new ItensEntrada();
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    ex.getMessage(), "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<EntradaMedicamento> autoComplete(String query) {
        return entradaMedicamentoFacade.autoComplete("nome", query);
    }

    public String novo() {
        entradaMedicamento = new EntradaMedicamento();
        itensEntrada = new ItensEntrada();
        return "cadastro?faces-redirect=true";
    }

    public String salvar() {
        entradaMedicamentoFacade.salvar(entradaMedicamento);
        return "pesquisa?faces-redirect=true";
    }

    public void excluir(EntradaMedicamento e) {
        entradaMedicamentoFacade.excluir(e);
    }

    public List<EntradaMedicamento> getListaEntradaMedicamentos() {
        return entradaMedicamentoFacade.listarTodos();
    }

    public EntradaMedicamento getEntradaMedicamento() {
        return entradaMedicamento;
    }

    public void setEntradaMedicamento(EntradaMedicamento entradaMedicamento) {
        this.entradaMedicamento = entradaMedicamento;
    }

    public ItensEntrada getItensEntrada() {
        return itensEntrada;
    }

    public void setItensEntrada(ItensEntrada itensEntrada) {
        this.itensEntrada = itensEntrada;
    }

    public boolean isEditando() {
        return this.entradaMedicamento.getId() != null;
    }

}
