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
@Table(name = "CONTROLE_EQUIPAMENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControleEquipamentos.findAll", query = "SELECT c FROM ControleEquipamentos c")
    , @NamedQuery(name = "ControleEquipamentos.findByIdControleEquip", query = "SELECT c FROM ControleEquipamentos c WHERE c.idControleEquip = :idControleEquip")
    , @NamedQuery(name = "ControleEquipamentos.findByDateEntregaEquip", query = "SELECT c FROM ControleEquipamentos c WHERE c.dateEntregaEquip = :dateEntregaEquip")
    , @NamedQuery(name = "ControleEquipamentos.findByDateDevolucaoEquip", query = "SELECT c FROM ControleEquipamentos c WHERE c.dateDevolucaoEquip = :dateDevolucaoEquip")})
public class ControleEquipamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_controle_equip")
    private Integer idControleEquip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_entrega_equip")
    @Temporal(TemporalType.DATE)
    private Date dateEntregaEquip;
    @Column(name = "date_devolucao_equip")
    @Temporal(TemporalType.DATE)
    private Date dateDevolucaoEquip;
    @JoinColumn(name = "id_assistente", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuario idAssistente;
    @JoinColumn(name = "id_reserva_equip", referencedColumnName = "id_reserva_equip")
    @ManyToOne(optional = false)
    private ReservaEquipamento idReservaEquip;

    public ControleEquipamentos() {
    }

    public ControleEquipamentos(Integer idControleEquip) {
        this.idControleEquip = idControleEquip;
    }

    public ControleEquipamentos(Integer idControleEquip, Date dateEntregaEquip) {
        this.idControleEquip = idControleEquip;
        this.dateEntregaEquip = dateEntregaEquip;
    }

    public Integer getIdControleEquip() {
        return idControleEquip;
    }

    public void setIdControleEquip(Integer idControleEquip) {
        this.idControleEquip = idControleEquip;
    }

    public Date getDateEntregaEquip() {
        return dateEntregaEquip;
    }

    public void setDateEntregaEquip(Date dateEntregaEquip) {
        this.dateEntregaEquip = dateEntregaEquip;
    }

    public Date getDateDevolucaoEquip() {
        return dateDevolucaoEquip;
    }

    public void setDateDevolucaoEquip(Date dateDevolucaoEquip) {
        this.dateDevolucaoEquip = dateDevolucaoEquip;
    }

    public Usuario getIdAssistente() {
        return idAssistente;
    }

    public void setIdAssistente(Usuario idAssistente) {
        this.idAssistente = idAssistente;
    }

    public ReservaEquipamento getIdReservaEquip() {
        return idReservaEquip;
    }

    public void setIdReservaEquip(ReservaEquipamento idReservaEquip) {
        this.idReservaEquip = idReservaEquip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControleEquip != null ? idControleEquip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControleEquipamentos)) {
            return false;
        }
        ControleEquipamentos other = (ControleEquipamentos) object;
        if ((this.idControleEquip == null && other.idControleEquip != null) || (this.idControleEquip != null && !this.idControleEquip.equals(other.idControleEquip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ControleEquipamentos[ idControleEquip=" + idControleEquip + " ]";
    }
    
}
