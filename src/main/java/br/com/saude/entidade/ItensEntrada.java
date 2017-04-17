/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Aline
 */
@Entity
@Table(name = "itensEntrada")
public class ItensEntrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "itensEntrada_id")
    private Long id;
    private BigDecimal quantidade;

    @ManyToOne
    @JoinColumn(name = "entrada_id")
    private EntradaMedicamento entradaMedicamento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;

    public void retiradaEstoque() {
        BigDecimal novoEstoque = medicamento.getEstoque().subtract(quantidade);
        medicamento.setEstoque(novoEstoque);
    }

    public void entradaEstoque() {
        BigDecimal novoEstoque = medicamento.getEstoque().add(quantidade);
        medicamento.setEstoque(novoEstoque);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public EntradaMedicamento getEntradaMedicamento() {
        return entradaMedicamento;
    }

    public void setEntradaMedicamento(EntradaMedicamento entradaMedicamento) {
        this.entradaMedicamento = entradaMedicamento;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.medicamento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItensEntrada other = (ItensEntrada) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.medicamento, other.medicamento)) {
            return false;
        }
        return true;
    }
    

  

    @Override
    public String toString() {
        return id.toString();
    }

}
