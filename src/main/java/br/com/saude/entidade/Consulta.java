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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Aline
 */
@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "consulta_id")
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    private String observacao;
    
    @ManyToOne
    private Paciente paciente;
    
    @Enumerated(EnumType.STRING)
    private TipoConsulta tipoConsulta;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
            mappedBy = "consulta", orphanRemoval = true)
    private List<ConsultaItem> consultaItens = new ArrayList<>();

    public void adicionaItem(ConsultaItem item) throws Exception {
        BigDecimal estoqueMedicamento = item.getMedicamento().getEstoque();
        if (item.getQuantidade().compareTo(estoqueMedicamento) <= 0) {
            item.setConsulta(this);
            if (!consultaItens.contains(item)) {
                consultaItens.add(item);
            } else {
                int index = consultaItens.indexOf(item);
                ConsultaItem ci = consultaItens.get(index);
                BigDecimal novaQuantidade = ci.getQuantidade().add(item.getQuantidade());
                ci.setQuantidade(novaQuantidade);
            }
            item.baixaEstoque();
        } else {
            throw new Exception("Medicamento com estoque insuficiente.");
        }
    }

    public void removeItem(ConsultaItem item) throws Exception {
        if (consultaItens.contains(item)) {
            consultaItens.remove(item);
            item.estornaEstoque();
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public List<ConsultaItem> getConsultaItens() {
        return consultaItens;
    }

    public void setConsultaItens(List<ConsultaItem> consultaItens) {
        this.consultaItens = consultaItens;
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
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
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
