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
@Table(name = "CONTROLE_CHAVES_SALA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControleChavesSala.findAll", query = "SELECT c FROM ControleChavesSala c")
    , @NamedQuery(name = "ControleChavesSala.findByIdControleChaves", query = "SELECT c FROM ControleChavesSala c WHERE c.idControleChaves = :idControleChaves")
    , @NamedQuery(name = "ControleChavesSala.findByDateEntregaChave", query = "SELECT c FROM ControleChavesSala c WHERE c.dateEntregaChave = :dateEntregaChave")
    , @NamedQuery(name = "ControleChavesSala.findByDateDevolucaoChave", query = "SELECT c FROM ControleChavesSala c WHERE c.dateDevolucaoChave = :dateDevolucaoChave")})
public class ControleChavesSala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_controle_chaves")
    private Integer idControleChaves;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_entrega_chave")
    @Temporal(TemporalType.DATE)
    private Date dateEntregaChave;
    @Column(name = "date_devolucao_chave")
    @Temporal(TemporalType.DATE)
    private Date dateDevolucaoChave;
    @JoinColumn(name = "id_assistente", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuario idAssistente;
    @JoinColumn(name = "id_reserva_sala", referencedColumnName = "id_reserva_sala")
    @ManyToOne(optional = false)
    private ReservaSala idReservaSala;

    public ControleChavesSala() {
    }

    public ControleChavesSala(Integer idControleChaves) {
        this.idControleChaves = idControleChaves;
    }

    public ControleChavesSala(Integer idControleChaves, Date dateEntregaChave) {
        this.idControleChaves = idControleChaves;
        this.dateEntregaChave = dateEntregaChave;
    }

    public Integer getIdControleChaves() {
        return idControleChaves;
    }

    public void setIdControleChaves(Integer idControleChaves) {
        this.idControleChaves = idControleChaves;
    }

    public Date getDateEntregaChave() {
        return dateEntregaChave;
    }

    public void setDateEntregaChave(Date dateEntregaChave) {
        this.dateEntregaChave = dateEntregaChave;
    }

    public Date getDateDevolucaoChave() {
        return dateDevolucaoChave;
    }

    public void setDateDevolucaoChave(Date dateDevolucaoChave) {
        this.dateDevolucaoChave = dateDevolucaoChave;
    }

    public Usuario getIdAssistente() {
        return idAssistente;
    }

    public void setIdAssistente(Usuario idAssistente) {
        this.idAssistente = idAssistente;
    }

    public ReservaSala getIdReservaSala() {
        return idReservaSala;
    }

    public void setIdReservaSala(ReservaSala idReservaSala) {
        this.idReservaSala = idReservaSala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControleChaves != null ? idControleChaves.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControleChavesSala)) {
            return false;
        }
        ControleChavesSala other = (ControleChavesSala) object;
        if ((this.idControleChaves == null && other.idControleChaves != null) || (this.idControleChaves != null && !this.idControleChaves.equals(other.idControleChaves))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ControleChavesSala[ idControleChaves=" + idControleChaves + " ]";
        
    }
    
}
