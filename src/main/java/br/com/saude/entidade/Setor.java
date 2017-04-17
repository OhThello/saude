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
public enum Setor {
    AGENTE_COMUNITARIO("Agente Comunitário"),
    RECEPCAO("Recepção"),
    MEDICO("Médico"),
    ENFERMAGEM("Enfermagem"),
    TECNICO_ENFERMAGEM("Técnico enfermagem");
    
     private String descricao;

    private Setor(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
