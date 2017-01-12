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
@Table(name = "PROBLEMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Problema.findAll", query = "SELECT p FROM Problema p")
    , @NamedQuery(name = "Problema.findByIdProblema", query = "SELECT p FROM Problema p WHERE p.idProblema = :idProblema")
    , @NamedQuery(name = "Problema.findByDescricao", query = "SELECT p FROM Problema p WHERE p.descricao = :descricao")})
public class Problema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_problema")
    private Integer idProblema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProblema")
    private Collection<ProblemaSala> problemaSalaCollection;
    @JoinColumn(name = "id_gravidade", referencedColumnName = "id_gravidade")
    @ManyToOne(optional = false)
    private Gravidade idGravidade;

    public Problema() {
    }

    public Problema(Integer idProblema) {
        this.idProblema = idProblema;
    }

    public Problema(Integer idProblema, String descricao) {
        this.idProblema = idProblema;
        this.descricao = descricao;
    }

    public Integer getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(Integer idProblema) {
        this.idProblema = idProblema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<ProblemaSala> getProblemaSalaCollection() {
        return problemaSalaCollection;
    }

    public void setProblemaSalaCollection(Collection<ProblemaSala> problemaSalaCollection) {
        this.problemaSalaCollection = problemaSalaCollection;
    }

    public Gravidade getIdGravidade() {
        return idGravidade;
    }

    public void setIdGravidade(Gravidade idGravidade) {
        this.idGravidade = idGravidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProblema != null ? idProblema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Problema)) {
            return false;
        }
        Problema other = (Problema) object;
        if ((this.idProblema == null && other.idProblema != null) || (this.idProblema != null && !this.idProblema.equals(other.idProblema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "jpa.entities.Problema[ idProblema=" + idProblema + " ]";
        return this.descricao;
    }
    
}
