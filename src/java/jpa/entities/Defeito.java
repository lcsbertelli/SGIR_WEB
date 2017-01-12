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
@Table(name = "DEFEITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Defeito.findAll", query = "SELECT d FROM Defeito d")
    , @NamedQuery(name = "Defeito.findByIdDefeito", query = "SELECT d FROM Defeito d WHERE d.idDefeito = :idDefeito")
    , @NamedQuery(name = "Defeito.findByDescricao", query = "SELECT d FROM Defeito d WHERE d.descricao = :descricao")})
public class Defeito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_defeito")
    private Integer idDefeito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "id_gravidade", referencedColumnName = "id_gravidade")
    @ManyToOne(optional = false)
    private Gravidade idGravidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDefeito")
    private Collection<DefeitosEquip> defeitosEquipCollection;

    public Defeito() {
    }

    public Defeito(Integer idDefeito) {
        this.idDefeito = idDefeito;
    }

    public Defeito(Integer idDefeito, String descricao) {
        this.idDefeito = idDefeito;
        this.descricao = descricao;
    }

    public Integer getIdDefeito() {
        return idDefeito;
    }

    public void setIdDefeito(Integer idDefeito) {
        this.idDefeito = idDefeito;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Gravidade getIdGravidade() {
        return idGravidade;
    }

    public void setIdGravidade(Gravidade idGravidade) {
        this.idGravidade = idGravidade;
    }

    @XmlTransient
    public Collection<DefeitosEquip> getDefeitosEquipCollection() {
        return defeitosEquipCollection;
    }

    public void setDefeitosEquipCollection(Collection<DefeitosEquip> defeitosEquipCollection) {
        this.defeitosEquipCollection = defeitosEquipCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDefeito != null ? idDefeito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Defeito)) {
            return false;
        }
        Defeito other = (Defeito) object;
        if ((this.idDefeito == null && other.idDefeito != null) || (this.idDefeito != null && !this.idDefeito.equals(other.idDefeito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Defeito[ idDefeito=" + idDefeito + " ]";
    }
    
}
