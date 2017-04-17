/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.controle;

import br.com.saude.converter.GenericConverter;
import br.com.saude.entidade.Pessoa;
import br.com.saude.facede.PessoaFacade;
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
public class PessoaControle implements Serializable {

    private Pessoa pessoa;
    @EJB
    private PessoaFacade pessoaFacade;
    private GenericConverter genericConverter;

    public GenericConverter converter() {
        if (genericConverter == null) {
            genericConverter = new GenericConverter(pessoaFacade);
        }
        return genericConverter;
    }

    public List<Pessoa> autoComplete(String query) {
        return pessoaFacade.autoComplete("nome", query);
    }

    public String novo() {
        pessoa = new Pessoa(){};
        return "cadastro?faces-redirect=true";
    }

    public String salvar() {
        pessoaFacade.salvar(pessoa);
        return "pesquisa?faces-redirect=true";
    }

    public void excluir(Pessoa e) {
        pessoaFacade.excluir(e);
    }

    public List<Pessoa> getListaPessoas() {
        return pessoaFacade.listarTodos();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public boolean isEditando() {
        return this.pessoa.getId() != null;
    }

}
