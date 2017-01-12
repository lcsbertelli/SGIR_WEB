/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "SALA_EQUIPAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalaEquipamento.findAll", query = "SELECT s FROM SalaEquipamento s")
    , @NamedQuery(name = "SalaEquipamento.findByIdSalaEquip", query = "SELECT s FROM SalaEquipamento s WHERE s.idSalaEquip = :idSalaEquip")})
public class SalaEquipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sala_equip")
    private Integer idSalaEquip;
    @JoinColumn(name = "id_equip", referencedColumnName = "id_equip")
    @ManyToOne(optional = false)
    private Equipamento idEquip;
    @JoinColumn(name = "id_sala", referencedColumnName = "id_sala")
    @ManyToOne(optional = false)
    private Sala idSala;

    public SalaEquipamento() {
    }

    public SalaEquipamento(Integer idSalaEquip) {
        this.idSalaEquip = idSalaEquip;
    }

    public Integer getIdSalaEquip() {
        return idSalaEquip;
    }

    public void setIdSalaEquip(Integer idSalaEquip) {
        this.idSalaEquip = idSalaEquip;
    }

    public Equipamento getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(Equipamento idEquip) {
        this.idEquip = idEquip;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalaEquip != null ? idSalaEquip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalaEquipamento)) {
            return false;
        }
        SalaEquipamento other = (SalaEquipamento) object;
        if ((this.idSalaEquip == null && other.idSalaEquip != null) || (this.idSalaEquip != null && !this.idSalaEquip.equals(other.idSalaEquip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.SalaEquipamento[ idSalaEquip=" + idSalaEquip + " ]";
    }
    
}
