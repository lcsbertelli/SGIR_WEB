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
@Table(name = "DEFEITOS_EQUIP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DefeitosEquip.findAll", query = "SELECT d FROM DefeitosEquip d")
    , @NamedQuery(name = "DefeitosEquip.findByDataIdentificacao", query = "SELECT d FROM DefeitosEquip d WHERE d.dataIdentificacao = :dataIdentificacao")
    , @NamedQuery(name = "DefeitosEquip.findByIdDefeitoEquip", query = "SELECT d FROM DefeitosEquip d WHERE d.idDefeitoEquip = :idDefeitoEquip")})
public class DefeitosEquip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_identificacao")
    @Temporal(TemporalType.DATE)
    private Date dataIdentificacao;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_defeito_equip")
    private Integer idDefeitoEquip;
    @JoinColumn(name = "id_defeito", referencedColumnName = "id_defeito")
    @ManyToOne(optional = false)
    private Defeito idDefeito;
    @JoinColumn(name = "id_equip", referencedColumnName = "id_equip")
    @ManyToOne(optional = false)
    private Equipamento idEquip;
    @JoinColumn(name = "id_situacao", referencedColumnName = "id_situacao")
    @ManyToOne(optional = false)
    private Situacao idSituacao;

    public DefeitosEquip() {
    }

    public DefeitosEquip(Integer idDefeitoEquip) {
        this.idDefeitoEquip = idDefeitoEquip;
    }

    public DefeitosEquip(Integer idDefeitoEquip, Date dataIdentificacao) {
        this.idDefeitoEquip = idDefeitoEquip;
        this.dataIdentificacao = dataIdentificacao;
    }

    public Date getDataIdentificacao() {
        return dataIdentificacao;
    }

    public void setDataIdentificacao(Date dataIdentificacao) {
        this.dataIdentificacao = dataIdentificacao;
    }

    public Integer getIdDefeitoEquip() {
        return idDefeitoEquip;
    }

    public void setIdDefeitoEquip(Integer idDefeitoEquip) {
        this.idDefeitoEquip = idDefeitoEquip;
    }

    public Defeito getIdDefeito() {
        return idDefeito;
    }

    public void setIdDefeito(Defeito idDefeito) {
        this.idDefeito = idDefeito;
    }

    public Equipamento getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(Equipamento idEquip) {
        this.idEquip = idEquip;
    }

    public Situacao getIdSituacao() {
        return idSituacao;
    }

    public void setIdSituacao(Situacao idSituacao) {
        this.idSituacao = idSituacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDefeitoEquip != null ? idDefeitoEquip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DefeitosEquip)) {
            return false;
        }
        DefeitosEquip other = (DefeitosEquip) object;
        if ((this.idDefeitoEquip == null && other.idDefeitoEquip != null) || (this.idDefeitoEquip != null && !this.idDefeitoEquip.equals(other.idDefeitoEquip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.DefeitosEquip[ idDefeitoEquip=" + idDefeitoEquip + " ]";
    }
    
}
