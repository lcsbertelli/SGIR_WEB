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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "SITUACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Situacao.findAll", query = "SELECT s FROM Situacao s")
    , @NamedQuery(name = "Situacao.findByIdSituacao", query = "SELECT s FROM Situacao s WHERE s.idSituacao = :idSituacao")
    , @NamedQuery(name = "Situacao.findByNome", query = "SELECT s FROM Situacao s WHERE s.nome = :nome")})
public class Situacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_situacao")
    private Integer idSituacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSituacao")
    private Collection<DefeitosEquip> defeitosEquipCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSituacao")
    private Collection<ProblemaSala> problemaSalaCollection;

    public Situacao() {
    }

    public Situacao(Integer idSituacao) {
        this.idSituacao = idSituacao;
    }

    public Situacao(Integer idSituacao, String nome) {
        this.idSituacao = idSituacao;
        this.nome = nome;
    }

    public Integer getIdSituacao() {
        return idSituacao;
    }

    public void setIdSituacao(Integer idSituacao) {
        this.idSituacao = idSituacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<DefeitosEquip> getDefeitosEquipCollection() {
        return defeitosEquipCollection;
    }

    public void setDefeitosEquipCollection(Collection<DefeitosEquip> defeitosEquipCollection) {
        this.defeitosEquipCollection = defeitosEquipCollection;
    }

    @XmlTransient
    public Collection<ProblemaSala> getProblemaSalaCollection() {
        return problemaSalaCollection;
    }

    public void setProblemaSalaCollection(Collection<ProblemaSala> problemaSalaCollection) {
        this.problemaSalaCollection = problemaSalaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSituacao != null ? idSituacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Situacao)) {
            return false;
        }
        Situacao other = (Situacao) object;
        if ((this.idSituacao == null && other.idSituacao != null) || (this.idSituacao != null && !this.idSituacao.equals(other.idSituacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Situacao[ idSituacao=" + idSituacao + " ]";
    }
    
}
