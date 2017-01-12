/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "RESERVA_EQUIPAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservaEquipamento.findAll", query = "SELECT r FROM ReservaEquipamento r")
    , @NamedQuery(name = "ReservaEquipamento.findByIdReservaEquip", query = "SELECT r FROM ReservaEquipamento r WHERE r.idReservaEquip = :idReservaEquip")
    , @NamedQuery(name = "ReservaEquipamento.findByDateReserva", query = "SELECT r FROM ReservaEquipamento r WHERE r.dateReserva = :dateReserva")})
public class ReservaEquipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reserva_equip")
    private Integer idReservaEquip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_reserva")
    @Temporal(TemporalType.DATE)
    private Date dateReserva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReservaEquip")
    private Collection<ControleEquipamentos> controleEquipamentosCollection;
    @JoinColumn(name = "id_equip", referencedColumnName = "id_equip")
    @ManyToOne(optional = false)
    private Equipamento idEquip;
    @JoinColumn(name = "id_gerente", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuario idGerente;
    @JoinColumn(name = "id_prof", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuario idProf;

    public ReservaEquipamento() {
    }

    public ReservaEquipamento(Integer idReservaEquip) {
        this.idReservaEquip = idReservaEquip;
    }

    public ReservaEquipamento(Integer idReservaEquip, Date dateReserva) {
        this.idReservaEquip = idReservaEquip;
        this.dateReserva = dateReserva;
    }

    public Integer getIdReservaEquip() {
        return idReservaEquip;
    }

    public void setIdReservaEquip(Integer idReservaEquip) {
        this.idReservaEquip = idReservaEquip;
    }

    public Date getDateReserva() {
        return dateReserva;
    }

    public void setDateReserva(Date dateReserva) {
        this.dateReserva = dateReserva;
    }

    @XmlTransient
    public Collection<ControleEquipamentos> getControleEquipamentosCollection() {
        return controleEquipamentosCollection;
    }

    public void setControleEquipamentosCollection(Collection<ControleEquipamentos> controleEquipamentosCollection) {
        this.controleEquipamentosCollection = controleEquipamentosCollection;
    }

    public Equipamento getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(Equipamento idEquip) {
        this.idEquip = idEquip;
    }

    public Usuario getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Usuario idGerente) {
        this.idGerente = idGerente;
    }

    public Usuario getIdProf() {
        return idProf;
    }

    public void setIdProf(Usuario idProf) {
        this.idProf = idProf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservaEquip != null ? idReservaEquip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaEquipamento)) {
            return false;
        }
        ReservaEquipamento other = (ReservaEquipamento) object;
        if ((this.idReservaEquip == null && other.idReservaEquip != null) || (this.idReservaEquip != null && !this.idReservaEquip.equals(other.idReservaEquip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ReservaEquipamento[ idReservaEquip=" + idReservaEquip + " ]";
    }
    
}
