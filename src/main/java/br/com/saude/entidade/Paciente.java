/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Aline
 */
@Entity
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Paciente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    private String cartaoSus;
    private String nomeMae;
    private String numeroProtuario;

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNumeroProtuario() {
        return numeroProtuario;
    }

    public void setNumeroProtuario(String numeroProtuario) {
        this.numeroProtuario = numeroProtuario;
    }

}
