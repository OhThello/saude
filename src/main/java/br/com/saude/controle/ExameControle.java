/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.controle;

import br.com.saude.converter.GenericConverter;
import br.com.saude.entidade.Exame;
import br.com.saude.entidade.TipoExame;
import br.com.saude.facede.ExameFacade;
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
public class ExameControle implements Serializable {

    private Exame exame;
    @EJB
    private ExameFacade exameFacade;
    private GenericConverter genericConverter;

    public GenericConverter converter() {
        if (genericConverter == null) {
            genericConverter = new GenericConverter(exameFacade);
        }
        return genericConverter;
    }

    public List<Exame> autoComplete(String query) {
        return exameFacade.autoComplete("nome", query);
    }

    public String novo() {
        exame = new Exame();
        return "cadastro?faces-redirect=true";
    }

    public String salvar() {
        exameFacade.salvar(exame);
        return "pesquisa?faces-redirect=true";
    }

    public void excluir(Exame e) {
        exameFacade.excluir(e);
    }

    public List<Exame> getListaExames() {
        return exameFacade.listarTodos();
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public boolean isEditando() {
        return this.exame.getId() != null;
    }
    
        public  TipoExame[] getTipoExame(){
        return TipoExame.values();
    }

}
