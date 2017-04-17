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
@Table(name = "entradaMedicamento")
public class EntradaMedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "entrada_id")
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataentrada;
    private String observacao;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "entradaMedicamento",
            orphanRemoval = true)
    private List<ItensEntrada> itensEntradas = new ArrayList<>();

    public void adicionaItem(ItensEntrada item) throws Exception {
        BigDecimal estoqueMedicamento = item.getMedicamento().getEstoque();
        if (item.getQuantidade().compareTo(estoqueMedicamento) >= 0) {
            item.setEntradaMedicamento(this);
            if (!itensEntradas.contains(item)) {
                itensEntradas.add(item);
            } else {
                int index = itensEntradas.indexOf(item);
                ItensEntrada ci = itensEntradas.get(index);
                BigDecimal novaQuantidade = ci.getQuantidade().add(item.getQuantidade());
                ci.setQuantidade(novaQuantidade);
            }
            item.entradaEstoque();
        } else {
            throw new Exception("Medicamento com estoque insuficiente.");
        }
    }
    
       public void removeItem(ItensEntrada item) throws Exception {
        if (itensEntradas.contains(item)) {
            itensEntradas.remove(item);
            item.retiradaEstoque();
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

    public Date getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(Date dataentrada) {
        this.dataentrada = dataentrada;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<ItensEntrada> getItensEntradas() {
        return itensEntradas;
    }

    public void setItensEntradas(List<ItensEntrada> itensEntradas) {
        this.itensEntradas = itensEntradas;
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
        if (!(object instanceof EntradaMedicamento)) {
            return false;
        }
        EntradaMedicamento other = (EntradaMedicamento) object;
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
