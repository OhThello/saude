/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.controle;

import br.com.saude.converter.GenericConverter;
import br.com.saude.entidade.Paciente;
import br.com.saude.facede.PacienteFacade;
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
public class PacienteControle implements Serializable {

    private Paciente paciente;
    @EJB
    private PacienteFacade pacienteFacade;
    private GenericConverter genericConverter;

    public GenericConverter converter() {
        if (genericConverter == null) {
            genericConverter = new GenericConverter(pacienteFacade);
        }
        return genericConverter;
    }

    public List<Paciente> autoComplete(String query) {
        return pacienteFacade.autoComplete("nome", query);
    }

    public String novo() {
        paciente = new Paciente();
        return "cadastro?faces-redirect=true";
    }

    public String salvar() {
        pacienteFacade.salvar(paciente);
        return "pesquisa?faces-redirect=true";
    }

    public void excluir(Paciente e) {
        pacienteFacade.excluir(e);
    }

    public List<Paciente> getListaPacientes() {
        return pacienteFacade.listarTodos();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public boolean isEditando() {
        return this.paciente.getId() != null;
    }

}
