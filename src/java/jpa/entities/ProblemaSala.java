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
@Table(name = "PROBLEMA_SALA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProblemaSala.findAll", query = "SELECT p FROM ProblemaSala p")
    , @NamedQuery(name = "ProblemaSala.findByDataIdentificacao", query = "SELECT p FROM ProblemaSala p WHERE p.dataIdentificacao = :dataIdentificacao")
    , @NamedQuery(name = "ProblemaSala.findByIdProblemaSala", query = "SELECT p FROM ProblemaSala p WHERE p.idProblemaSala = :idProblemaSala")})
public class ProblemaSala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_identificacao")
    @Temporal(TemporalType.DATE)
    private Date dataIdentificacao;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_problema_sala")
    private Integer idProblemaSala;
    @JoinColumn(name = "id_problema", referencedColumnName = "id_problema")
    @ManyToOne(optional = false)
    private Problema idProblema;
    @JoinColumn(name = "id_sala", referencedColumnName = "id_sala")
    @ManyToOne(optional = false)
    private Sala idSala;
    @JoinColumn(name = "id_situacao", referencedColumnName = "id_situacao")
    @ManyToOne(optional = false)
    private Situacao idSituacao;

    public ProblemaSala() {
    }

    public ProblemaSala(Integer idProblemaSala) {
        this.idProblemaSala = idProblemaSala;
    }

    public ProblemaSala(Integer idProblemaSala, Date dataIdentificacao) {
        this.idProblemaSala = idProblemaSala;
        this.dataIdentificacao = dataIdentificacao;
    }

    public Date getDataIdentificacao() {
        return dataIdentificacao;
    }

    public void setDataIdentificacao(Date dataIdentificacao) {
        this.dataIdentificacao = dataIdentificacao;
    }

    public Integer getIdProblemaSala() {
        return idProblemaSala;
    }

    public void setIdProblemaSala(Integer idProblemaSala) {
        this.idProblemaSala = idProblemaSala;
    }

    public Problema getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(Problema idProblema) {
        this.idProblema = idProblema;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
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
        hash += (idProblemaSala != null ? idProblemaSala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProblemaSala)) {
            return false;
        }
        ProblemaSala other = (ProblemaSala) object;
        if ((this.idProblemaSala == null && other.idProblemaSala != null) || (this.idProblemaSala != null && !this.idProblemaSala.equals(other.idProblemaSala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ProblemaSala[ idProblemaSala=" + idProblemaSala + " ]";
    }
    
}
