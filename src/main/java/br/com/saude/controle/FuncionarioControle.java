/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.controle;

import br.com.saude.converter.GenericConverter;
import br.com.saude.entidade.Funcionario;
import br.com.saude.entidade.Setor;
import br.com.saude.facede.FuncionarioFacade;
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
public class FuncionarioControle implements Serializable {

    private Funcionario funcionario;
    @EJB
    private FuncionarioFacade funcionarioFacade;
    private GenericConverter genericConverter;

    public GenericConverter converter() {
        if (genericConverter == null) {
            genericConverter = new GenericConverter(funcionarioFacade);
        }
        return genericConverter;
    }

    public List<Funcionario> autoComplete(String query) {
        return funcionarioFacade.autoComplete("nome", query);
    }

    public String novo() {
        funcionario = new Funcionario();
        return "cadastro?faces-redirect=true";
    }

    public String salvar() {
        funcionarioFacade.salvar(funcionario);
        return "pesquisa?faces-redirect=true";
    }

    public void excluir(Funcionario e) {
        funcionarioFacade.excluir(e);
    }

    public List<Funcionario> getListaFuncionarios() {
        return funcionarioFacade.listarTodos();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public boolean isEditando() {
        return this.funcionario.getId() != null;
    }
    
     public  Setor[] getSetor(){
        return Setor.values();
    }

}
