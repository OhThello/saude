/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.controle;

import br.com.saude.converter.GenericConverter;
import br.com.saude.entidade.Medicamento;
import br.com.saude.facede.MedicamentoFacade;
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
public class MedicamentoControle implements Serializable {

    private Medicamento medicamento;
    @EJB
    private MedicamentoFacade medicamentoFacade;
    private GenericConverter genericConverter;

    public GenericConverter converter() {
        if (genericConverter == null) {
            genericConverter = new GenericConverter(medicamentoFacade);
        }
        return genericConverter;
    }

    public List<Medicamento> autoComplete(String query) {
        return medicamentoFacade.autoComplete("nome", query);
    }

    public String novo() {
        medicamento = new Medicamento();
        return "cadastro?faces-redirect=true";
    }

    public String salvar() {
        medicamentoFacade.salvar(medicamento);
        return "pesquisa?faces-redirect=true";
    }

    public void excluir(Medicamento e) {
        medicamentoFacade.excluir(e);
    }

    public List<Medicamento> getListaMedicamentos() {
        return medicamentoFacade.listarTodos();
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public boolean isEditando() {
        return this.medicamento.getId() != null;
    }

}
