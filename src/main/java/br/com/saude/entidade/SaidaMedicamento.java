/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saude.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Aline
 */
@Entity
@Table(name = "saidaMedicamento")
public class SaidaMedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "saida_id")
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataSaida;
    private String observacao;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "saidaMedicamento",
            orphanRemoval = true)
    private List<ItensSaida> itensSaidas = new ArrayList<>();

    public void adicionaItem(ItensSaida item) throws Exception {
        BigDecimal estoqueMedicamento = item.getMedicamento().getEstoque();
        if (item.getQuantidade().compareTo(estoqueMedicamento) <= 0) {
            item.setSaidaMedicamento(this);
            if (!itensSaidas.contains(item)) {
                itensSaidas.add(item);
            } else {
                int index = itensSaidas.indexOf(item);
                ItensSaida ci = itensSaidas.get(index);
                BigDecimal novaQuantidade = ci.getQuantidade().add(item.getQuantidade());
                ci.setQuantidade(novaQuantidade);
            }
            item.retiradaEstoque();
        } else {
            throw new Exception("Medicamento com estoque insuficiente.");
        }
    }

    public void removeItem(ItensSaida item) throws Exception {
        if (itensSaidas.contains(item)) {
            itensSaidas.remove(item);
            item.entradaEstoque();
        } else {
            throw new Exception("O medicamnto selecionado não contém na lista.");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<ItensSaida> getItensSaidas() {
        return itensSaidas;
    }

    public void setItensSaidas(List<ItensSaida> itensSaidas) {
        this.itensSaidas = itensSaidas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaidaMedicamento)) {
            return false;
        }
        SaidaMedicamento other = (SaidaMedicamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id.toString();
    }

}
