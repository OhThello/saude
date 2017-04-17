/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.controle;

import br.com.saude.converter.GenericConverter;
import br.com.saude.entidade.ItensSaida;
import br.com.saude.entidade.SaidaMedicamento;
import br.com.saude.facede.SaidaMedicamentoFacade;
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
public class SaidaMedicamentoControle implements Serializable {

    private SaidaMedicamento saidaMedicamento;
    private ItensSaida itensSaida;
    @EJB
    private SaidaMedicamentoFacade saidaMedicamentoFacade;
    private GenericConverter genericConverter;

    public GenericConverter converter() {
        if (genericConverter == null) {
            genericConverter = new GenericConverter(saidaMedicamentoFacade);
        }
        return genericConverter;
    }

    public void adiconaMedicamento() {
        try {
            saidaMedicamento.adicionaItem(itensSaida);
            itensSaida = new ItensSaida();
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    ex.getMessage(), "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void removeMedicamento() {
        try {
            saidaMedicamento.removeItem(itensSaida);
            itensSaida = new ItensSaida();
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    ex.getMessage(), "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<SaidaMedicamento> autoComplete(String query) {
        return saidaMedicamentoFacade.autoComplete("nome", query);
    }

    public String novo() {
        saidaMedicamento = new SaidaMedicamento();
        itensSaida = new ItensSaida();
        return "cadastro?faces-redirect=true";
    }

    public String salvar() {
        saidaMedicamentoFacade.salvar(saidaMedicamento);
        return "pesquisa?faces-redirect=true";
    }

    public void excluir(SaidaMedicamento e) {
        saidaMedicamentoFacade.excluir(e);
    }

    public List<SaidaMedicamento> getListaSaidaMedicamentos() {
        return saidaMedicamentoFacade.listarTodos();
    }

    public SaidaMedicamento getSaidaMedicamento() {
        return saidaMedicamento;
    }

    public void setSaidaMedicamento(SaidaMedicamento saidaMedicamento) {
        this.saidaMedicamento = saidaMedicamento;
    }

    public ItensSaida getItensSaida() {
        return itensSaida;
    }

    public void setItensSaida(ItensSaida itensSaida) {
        this.itensSaida = itensSaida;
    }



    public boolean isEditando() {
        return this.saidaMedicamento.getId() != null;
    }

}
