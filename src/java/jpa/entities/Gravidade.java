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
@Table(name = "GRAVIDADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gravidade.findAll", query = "SELECT g FROM Gravidade g")
    , @NamedQuery(name = "Gravidade.findByIdGravidade", query = "SELECT g FROM Gravidade g WHERE g.idGravidade = :idGravidade")
    , @NamedQuery(name = "Gravidade.findByNome", query = "SELECT g FROM Gravidade g WHERE g.nome = :nome")})
public class Gravidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gravidade")
    private Integer idGravidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGravidade")
    private Collection<Defeito> defeitoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGravidade")
    private Collection<Problema> problemaCollection;

    public Gravidade() {
    }

    public Gravidade(Integer idGravidade) {
        this.idGravidade = idGravidade;
    }

    public Gravidade(Integer idGravidade, String nome) {
        this.idGravidade = idGravidade;
        this.nome = nome;
    }

    public Integer getIdGravidade() {
        return idGravidade;
    }

    public void setIdGravidade(Integer idGravidade) {
        this.idGravidade = idGravidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Defeito> getDefeitoCollection() {
        return defeitoCollection;
    }

    public void setDefeitoCollection(Collection<Defeito> defeitoCollection) {
        this.defeitoCollection = defeitoCollection;
    }

    @XmlTransient
    public Collection<Problema> getProblemaCollection() {
        return problemaCollection;
    }

    public void setProblemaCollection(Collection<Problema> problemaCollection) {
        this.problemaCollection = problemaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGravidade != null ? idGravidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gravidade)) {
            return false;
        }
        Gravidade other = (Gravidade) object;
        if ((this.idGravidade == null && other.idGravidade != null) || (this.idGravidade != null && !this.idGravidade.equals(other.idGravidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Gravidade[ idGravidade=" + idGravidade + " ]";
    }
    
}
