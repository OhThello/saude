/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.controle;

import br.com.saude.converter.GenericConverter;
import br.com.saude.entidade.Consulta;
import br.com.saude.entidade.ConsultaItem;
import br.com.saude.entidade.TipoConsulta;
import br.com.saude.facede.ConsultaFacade;
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
public class ConsultaControle implements Serializable {

    private Consulta consulta;
    private ConsultaItem consultaItem;
    @EJB
    private ConsultaFacade consultaFacade;
    private GenericConverter genericConverter;

    public GenericConverter converter() {
        if (genericConverter == null) {
            genericConverter = new GenericConverter(consultaFacade);
        }
        return genericConverter;
    }
    
    public void adiconaMedicamento(){
        try {
            consulta.adicionaItem(consultaItem);
            consultaItem = new ConsultaItem();
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
            ex.getMessage(), "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public void removeMedicamento(){
        try {
            consulta.removeItem(consultaItem);
            consultaItem = new ConsultaItem();
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
            ex.getMessage(), "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<Consulta> autoComplete(String query) {
        return consultaFacade.autoComplete("nome", query);
    }

    public String novo() {
        consulta = new Consulta();
        consultaItem = new ConsultaItem();
        return "cadastro?faces-redirect=true";
    }

    public String salvar() {
        consultaFacade.salvar(consulta);
        return "pesquisa?faces-redirect=true";
    }

    public void excluir(Consulta e) {
        consultaFacade.excluir(e);
    }

    public List<Consulta> getListaConsultas() {
        return consultaFacade.listarTodos();
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public ConsultaItem getConsultaItem() {
        return consultaItem;
    }

    public void setConsultaItem(ConsultaItem consultaItem) {
        this.consultaItem = consultaItem;
    }
    

    public boolean isEditando() {
        return this.consulta.getId() != null;
    }

    public TipoConsulta[] getTipoConsulta() {
        return TipoConsulta.values();
    }

}
