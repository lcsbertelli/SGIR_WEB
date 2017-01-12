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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "SALA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sala.findAll", query = "SELECT s FROM Sala s")
    , @NamedQuery(name = "Sala.findByIdSala", query = "SELECT s FROM Sala s WHERE s.idSala = :idSala")
    , @NamedQuery(name = "Sala.findByNumSala", query = "SELECT s FROM Sala s WHERE s.numSala = :numSala")
    , @NamedQuery(name = "Sala.findByQtdMaxsala", query = "SELECT s FROM Sala s WHERE s.qtdMaxsala = :qtdMaxsala")})
public class Sala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sala")
    private Integer idSala;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_sala")
    private int numSala;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtd_maxsala")
    private int qtdMaxsala;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSala")
    private Collection<ProblemaSala> problemaSalaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSala")
    private Collection<SolicitaSala> solicitaSalaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSala")
    private Collection<SalaEquipamento> salaEquipamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSala")
    private Collection<ReservaSala> reservaSalaCollection;

    public Sala() {
    }

    public Sala(Integer idSala) {
        this.idSala = idSala;
    }

    public Sala(Integer idSala, int numSala, int qtdMaxsala) {
        this.idSala = idSala;
        this.numSala = numSala;
        this.qtdMaxsala = qtdMaxsala;
    }

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public int getQtdMaxsala() {
        return qtdMaxsala;
    }

    public void setQtdMaxsala(int qtdMaxsala) {
        this.qtdMaxsala = qtdMaxsala;
    }

    @XmlTransient
    public Collection<ProblemaSala> getProblemaSalaCollection() {
        return problemaSalaCollection;
    }

    public void setProblemaSalaCollection(Collection<ProblemaSala> problemaSalaCollection) {
        this.problemaSalaCollection = problemaSalaCollection;
    }

    @XmlTransient
    public Collection<SolicitaSala> getSolicitaSalaCollection() {
        return solicitaSalaCollection;
    }

    public void setSolicitaSalaCollection(Collection<SolicitaSala> solicitaSalaCollection) {
        this.solicitaSalaCollection = solicitaSalaCollection;
    }

    @XmlTransient
    public Collection<SalaEquipamento> getSalaEquipamentoCollection() {
        return salaEquipamentoCollection;
    }

    public void setSalaEquipamentoCollection(Collection<SalaEquipamento> salaEquipamentoCollection) {
        this.salaEquipamentoCollection = salaEquipamentoCollection;
    }

    @XmlTransient
    public Collection<ReservaSala> getReservaSalaCollection() {
        return reservaSalaCollection;
    }

    public void setReservaSalaCollection(Collection<ReservaSala> reservaSalaCollection) {
        this.reservaSalaCollection = reservaSalaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSala != null ? idSala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sala)) {
            return false;
        }
        Sala other = (Sala) object;
        if ((this.idSala == null && other.idSala != null) || (this.idSala != null && !this.idSala.equals(other.idSala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Sala[ idSala=" + idSala + " ]";
    }
    
}
