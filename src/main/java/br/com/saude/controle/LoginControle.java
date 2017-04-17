/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.controle;

import br.com.saude.entidade.Usuario;
import br.com.saude.facede.UsuarioFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@SessionScoped
public class LoginControle implements Serializable {

    private String login;
    private String senha;
    private String email;
    private Usuario usuario;
    @EJB
    private UsuarioFacade usuarioFacade;

    public String logar() {
        usuario = usuarioFacade.buscarUsuario(email, senha);
        if (usuario != null) {
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new GrantedAuthorityImpl(usuario.getPermissaoUsuario().toString()));

            SecurityContext context = SecurityContextHolder.getContext();

            context.setAuthentication(new UsernamePasswordAuthenticationToken(
                    email, senha, roles));
            if (context.getAuthentication().isAuthenticated()) {
                return "/Home?faces-redirect=true";
            } else {
                //message de erro
                 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Erro", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
                return "Login";
            }
        } else {
            //message de usuario invalido
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Usuário Inválido", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "Login";
        }

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

}
