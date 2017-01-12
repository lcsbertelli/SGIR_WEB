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
@Table(name = "MOBILIDADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mobilidade.findAll", query = "SELECT m FROM Mobilidade m")
    , @NamedQuery(name = "Mobilidade.findByIdMobilidade", query = "SELECT m FROM Mobilidade m WHERE m.idMobilidade = :idMobilidade")
    , @NamedQuery(name = "Mobilidade.findByNome", query = "SELECT m FROM Mobilidade m WHERE m.nome = :nome")})
public class Mobilidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mobilidade")
    private Integer idMobilidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMobilidade")
    private Collection<Equipamento> equipamentoCollection;

    public Mobilidade() {
    }

    public Mobilidade(Integer idMobilidade) {
        this.idMobilidade = idMobilidade;
    }

    public Mobilidade(Integer idMobilidade, String nome) {
        this.idMobilidade = idMobilidade;
        this.nome = nome;
    }

    public Integer getIdMobilidade() {
        return idMobilidade;
    }

    public void setIdMobilidade(Integer idMobilidade) {
        this.idMobilidade = idMobilidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Equipamento> getEquipamentoCollection() {
        return equipamentoCollection;
    }

    public void setEquipamentoCollection(Collection<Equipamento> equipamentoCollection) {
        this.equipamentoCollection = equipamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMobilidade != null ? idMobilidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mobilidade)) {
            return false;
        }
        Mobilidade other = (Mobilidade) object;
        if ((this.idMobilidade == null && other.idMobilidade != null) || (this.idMobilidade != null && !this.idMobilidade.equals(other.idMobilidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "jpa.entities.Mobilidade[ idMobilidade=" + idMobilidade + " ]";
        return this.nome;
    }
    
}
