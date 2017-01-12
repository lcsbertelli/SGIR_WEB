/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "EQUIPAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipamento.findAll", query = "SELECT e FROM Equipamento e")
    , @NamedQuery(name = "Equipamento.findByIdEquip", query = "SELECT e FROM Equipamento e WHERE e.idEquip = :idEquip")
    , @NamedQuery(name = "Equipamento.findByNumPatrimonio", query = "SELECT e FROM Equipamento e WHERE e.numPatrimonio = :numPatrimonio")})
public class Equipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equip")
    private Integer idEquip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "num_patrimonio")
    private String numPatrimonio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquip")
    private Collection<SolicitaEquipamento> solicitaEquipamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquip")
    private Collection<DefeitosEquip> defeitosEquipCollection;
    @JoinColumn(name = "id_mobilidade", referencedColumnName = "id_mobilidade")
    @ManyToOne(optional = false)
    private Mobilidade idMobilidade;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private Tipo idTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquip")
    private Collection<SalaEquipamento> salaEquipamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquip")
    private Collection<ReservaEquipamento> reservaEquipamentoCollection;

    public Equipamento() {
    }

    public Equipamento(Integer idEquip) {
        this.idEquip = idEquip;
    }

    public Equipamento(Integer idEquip, String numPatrimonio) {
        this.idEquip = idEquip;
        this.numPatrimonio = numPatrimonio;
    }

    public Integer getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(Integer idEquip) {
        this.idEquip = idEquip;
    }

    public String getNumPatrimonio() {
        return numPatrimonio;
    }

    public void setNumPatrimonio(String numPatrimonio) {
        this.numPatrimonio = numPatrimonio;
    }

    @XmlTransient
    public Collection<SolicitaEquipamento> getSolicitaEquipamentoCollection() {
        return solicitaEquipamentoCollection;
    }

    public void setSolicitaEquipamentoCollection(Collection<SolicitaEquipamento> solicitaEquipamentoCollection) {
        this.solicitaEquipamentoCollection = solicitaEquipamentoCollection;
    }

    @XmlTransient
    public Collection<DefeitosEquip> getDefeitosEquipCollection() {
        return defeitosEquipCollection;
    }

    public void setDefeitosEquipCollection(Collection<DefeitosEquip> defeitosEquipCollection) {
        this.defeitosEquipCollection = defeitosEquipCollection;
    }

    public Mobilidade getIdMobilidade() {
        return idMobilidade;
    }

    public void setIdMobilidade(Mobilidade idMobilidade) {
        this.idMobilidade = idMobilidade;
    }

    public Tipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tipo idTipo) {
        this.idTipo = idTipo;
    }

    @XmlTransient
    public Collection<SalaEquipamento> getSalaEquipamentoCollection() {
        return salaEquipamentoCollection;
    }

    public void setSalaEquipamentoCollection(Collection<SalaEquipamento> salaEquipamentoCollection) {
        this.salaEquipamentoCollection = salaEquipamentoCollection;
    }

    @XmlTransient
    public Collection<ReservaEquipamento> getReservaEquipamentoCollection() {
        return reservaEquipamentoCollection;
    }

    public void setReservaEquipamentoCollection(Collection<ReservaEquipamento> reservaEquipamentoCollection) {
        this.reservaEquipamentoCollection = reservaEquipamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquip != null ? idEquip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipamento)) {
            return false;
        }
        Equipamento other = (Equipamento) object;
        if ((this.idEquip == null && other.idEquip != null) || (this.idEquip != null && !this.idEquip.equals(other.idEquip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "jpa.entities.Equipamento[ idEquip=" + idEquip + " ]";
        return "Nº Patrimonio: " + this.numPatrimonio;
    }
    
}
