/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.controle;

import br.com.saude.converter.GenericConverter;
import br.com.saude.entidade.PermissaoUsuario;
import br.com.saude.entidade.Usuario;
import br.com.saude.facede.UsuarioFacade;
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
public class UsuarioControle implements Serializable {

    private Usuario usuario;
    @EJB
    private UsuarioFacade usuarioFacade;
    private GenericConverter genericConverter;

    public GenericConverter converter() {
        if (genericConverter == null) {
            genericConverter = new GenericConverter(usuarioFacade);
        }
        return genericConverter;
    }

    public List<Usuario> autoComplete(String query) {
        return usuarioFacade.autoComplete("nome", query);
    }

    public String novo() {
        usuario = new Usuario();
        return "cadastro?faces-redirect=true";
    }

    public String salvar() {
        usuarioFacade.salvar(usuario);
        return "pesquisa?faces-redirect=true";
    }

    public void excluir(Usuario e) {
        usuarioFacade.excluir(e);
    }

    public List<Usuario> getListaUsuarios() {
        return usuarioFacade.listarTodos();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isEditando() {
        return this.usuario.getId() != null;
    }

    public PermissaoUsuario[] getPermissoes() {
        return PermissaoUsuario.values();
    }

}
