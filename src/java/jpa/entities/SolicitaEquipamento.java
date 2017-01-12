/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "SOLICITA_EQUIPAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitaEquipamento.findAll", query = "SELECT s FROM SolicitaEquipamento s")
    , @NamedQuery(name = "SolicitaEquipamento.findByDateSolicitacao", query = "SELECT s FROM SolicitaEquipamento s WHERE s.dateSolicitacao = :dateSolicitacao")
    , @NamedQuery(name = "SolicitaEquipamento.findByIdSolicitaEquip", query = "SELECT s FROM SolicitaEquipamento s WHERE s.idSolicitaEquip = :idSolicitaEquip")})
public class SolicitaEquipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_solicitacao")
    @Temporal(TemporalType.DATE)
    private Date dateSolicitacao;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_solicita_equip")
    private Integer idSolicitaEquip;
    @JoinColumn(name = "id_equip", referencedColumnName = "id_equip")
    @ManyToOne(optional = false)
    private Equipamento idEquip;
    @JoinColumn(name = "id_prof", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuario idProf;

    public SolicitaEquipamento() {
    }

    public SolicitaEquipamento(Integer idSolicitaEquip) {
        this.idSolicitaEquip = idSolicitaEquip;
    }

    public SolicitaEquipamento(Integer idSolicitaEquip, Date dateSolicitacao) {
        this.idSolicitaEquip = idSolicitaEquip;
        this.dateSolicitacao = dateSolicitacao;
    }

    public Date getDateSolicitacao() {
        return dateSolicitacao;
    }

    public void setDateSolicitacao(Date dateSolicitacao) {
        this.dateSolicitacao = dateSolicitacao;
    }

    public Integer getIdSolicitaEquip() {
        return idSolicitaEquip;
    }

    public void setIdSolicitaEquip(Integer idSolicitaEquip) {
        this.idSolicitaEquip = idSolicitaEquip;
    }

    public Equipamento getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(Equipamento idEquip) {
        this.idEquip = idEquip;
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
        hash += (idSolicitaEquip != null ? idSolicitaEquip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitaEquipamento)) {
            return false;
        }
        SolicitaEquipamento other = (SolicitaEquipamento) object;
        if ((this.idSolicitaEquip == null && other.idSolicitaEquip != null) || (this.idSolicitaEquip != null && !this.idSolicitaEquip.equals(other.idSolicitaEquip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.SolicitaEquipamento[ idSolicitaEquip=" + idSolicitaEquip + " ]";
    }
    
}
