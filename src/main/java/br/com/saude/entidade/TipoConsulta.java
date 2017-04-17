/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.entidade;

/**
 *
 * @author Aline
 */
public enum TipoConsulta {
    PRE_NATAL("Pre Natal"),
    URGENCIA("Urgência"),
    PERIODICA("Periodica");

    private String descricao;

    private TipoConsulta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
