/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.controle;

import br.com.saude.converter.GenericConverter;
import br.com.saude.entidade.Agendamento;
import br.com.saude.entidade.TipoAgenda;
import br.com.saude.facede.AgendamentoFacade;
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
public class AgendamentoControle implements Serializable {

    private Agendamento agendamento;
    @EJB
    private AgendamentoFacade agendamentoFacade;
    private GenericConverter genericConverter;

    public GenericConverter converter() {
        if (genericConverter == null) {
            genericConverter = new GenericConverter(agendamentoFacade);
        }
        return genericConverter;
    }

    public List<Agendamento> autoComplete(String query) {
        return agendamentoFacade.autoComplete("nome", query);
    }

    public String novo() {
        agendamento = new Agendamento();
        return "cadastro?faces-redirect=true";
    }

    public String salvar() {
        agendamentoFacade.salvar(agendamento);
        return "pesquisa?faces-redirect=true";
    }

    public void excluir(Agendamento e) {
        agendamentoFacade.excluir(e);
    }

    public List<Agendamento> getListaAgendamentos() {
        return agendamentoFacade.listarTodos();
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public boolean isEditando() {
        return this.agendamento.getId() != null;
    }
    
    public  TipoAgenda[] getTipoAgenda(){
        return TipoAgenda.values();
    }

}
